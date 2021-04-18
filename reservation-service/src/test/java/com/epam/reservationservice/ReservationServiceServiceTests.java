package com.epam.reservationservice;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.reservationservice.model.Card;
import com.epam.reservationservice.model.ProxyAddress;
import com.epam.reservationservice.model.ProxyGuest;
import com.epam.reservationservice.model.ProxyHotel;
import com.epam.reservationservice.model.Reservation;
import com.epam.reservationservice.model.ReservationStatus;
import com.epam.reservationservice.proxy.GuestProxy;
import com.epam.reservationservice.proxy.HotelInformationProxy;
import com.epam.reservationservice.repository.ReservationRepositoryImpl;
import com.epam.reservationservice.service.ReservationService;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceServiceTests {
	@MockBean
	private ReservationRepositoryImpl reservationRepositoryImpl;
	
	 @MockBean
	    private HotelInformationProxy hotelProxy;

	    @MockBean
	    private GuestProxy guestProxy;


	    @Autowired
	    private ReservationService reservationService;
	    
	    
	    private ProxyGuest guest =  new ProxyGuest(1l, "Michael Kong","michaelkong@hotmail.com","986090909");
	    private ProxyAddress proxyAddress = new ProxyAddress(1L, "Nagar Pune Road", "Kedgaon", "AhmedNagar");
	    private ProxyHotel proxyHotel = new ProxyHotel(1L, "Hotel Yash Grand", "0241-2411497", 2, proxyAddress);;
	    private Card card =  new Card("549777700880XXXX","20","2028");
	    private Reservation reservation = new Reservation(new Date(), new Date(), 1L, 1L, 1L, ReservationStatus.REQUESTED,"SINGLE", card);
	   // private ReservationEntity reservationEntity =  new ReservationEntity(new Date(), new Date(), 1L, 1L, 1L, "REQUEST", new CardEntity(card.getCardNumber(), card.getExpMonth(), card.getExpYear()));

	    @Test
	    public void getGuestById() throws Exception {
	        given(guestProxy.retrivalGuest(anyLong())).willReturn(guest);
	        ProxyGuest guest = reservationService.getGuestById(1L);
	        assertTrue(guest.getGuestId().equals(1L));
	    }

	   /* //@Test(expected = EntityNotFoundException.class)
	    @Test
	    public void getGuestById_EntityNotFound() throws Exception {
	        given(guestProxy.retrivalGuest(anyLong())).willThrow(new EntityNotFoundException("Guest not found"));
	        reservationService.getGuestById(1L);
	    }*/

	    @Test
	    public void getHotelById() {
	       given(hotelProxy.getHotelById(anyLong())).willReturn(this.proxyHotel);
	        ProxyHotel proxyHotel = reservationService.getHotelById(1L);
	        assertTrue(proxyHotel.getHotelId().equals(1L));
	        assertTrue(proxyHotel.getAddress().getAddressId().equals(1L));
	    }

	    @Test
	    public void requestForReservation() throws Exception {
	        given(reservationRepositoryImpl.save(any())).willReturn(reservationEntity);
	        given(hotelProxy.reservationRequest(any(), anyLong())).willReturn(ResponseEntity.accepted().build());
	        reservationService.requestForReservation(reservation);
	        verify(hotelProxy).reservationRequest(any(), anyLong());
	    }

	    @Test
	    public void confirmReservation() throws ReservationEntityNotFoundException {
	        given(hotelProxy.updateReservation(anyLong(),any())).willReturn(ResponseEntity.accepted().build());
	        given(guestProxy.addStayByGuest(anyLong(), anyLong())).willReturn(ResponseEntity.ok(guest));
	        given(guestProxy.addNewCard(anyLong(),any())).willReturn(ResponseEntity.ok(guest));
	        given(reservationRepositoryImpl.getReservationById(anyLong())).willReturn(reservationEntity);
	        reservation.setState(ReservationStatus.CONFIRMED);
	        Reservation reservation = reservationService.updateReservation(this.reservation);
	        verify(hotelProxy).updateReservation(anyLong(),any());
	        verify(guestProxy).addStayByGuest(anyLong(), anyLong());
	        verify(reservationRepositoryImpl).getReservationById(anyLong());


	        assertTrue(reservation.getState().equals(ReservationStatus.CONFIRMED));
	    }

	    @Test
	    public void getReservation() throws Exception {
	        given(reservationRepositoryImpl.getReservationById(anyLong())).willReturn(reservationEntity);
	        reservationService.getReservation(1L);
	        verify(hotelProxy,times(0)).getHotelById(anyLong());
	        verify(guestProxy, times(0)).getGuest(anyLong());
	    }


	    @Test
	    public void getReservationsByGuestId() {
	        guest.getReservations().add(1l);
	        given(guestProxy.getGuest(anyLong())).willReturn(ResponseEntity.ok(guest));
	        given(reservationRepositoryImpl.getReservationById(anyLong())).willReturn(reservationEntity);
	        com.crs.microservices.hotelreservationservice.vo.Guest reservationsByGuestId = reservationService.getReservationsByGuestId(1l);

	        assertFalse(reservationsByGuestId.getReservations().isEmpty());
	        assertTrue(reservationsByGuestId.getReservations().stream().filter(r -> r.getReservationId().equals(1l)).findFirst().isPresent());

	    }

	    @Test
	    public void cancelReservation() throws Exception, ReservationEntityNotFoundException {
	        CardEntity cardEntity =  new CardEntity(card.getCardNumber(), card.getExpMonth(), card.getExpYear());
	        reservationEntity.setCard(cardEntity);
	        given(reservationRepositoryImpl.getReservationById(anyLong())).willReturn(reservationEntity);
	        given(hotelProxy.updateReservation(anyLong(), any())).willReturn(ResponseEntity.accepted().build());
	        reservation.setState(ReservationStatus.CANCELLED);
	        reservationService.updateReservation(reservation);
	        verify(reservationRepositoryImpl).getReservationById(anyLong());
	        verify(hotelProxy).updateReservation(anyLong(), any());
	    }



}
