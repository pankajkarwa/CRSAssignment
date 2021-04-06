/**
 * 
 */
package com.epam.hotelinformationservice;

import static org.hamcrest.CoreMatchers.any;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.hotelinformationservice.entity.Address;
import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;
import com.epam.hotelinformationservice.entity.ReservationStatus;
import com.epam.hotelinformationservice.entity.Room;
import com.epam.hotelinformationservice.entity.RoomType;
import com.epam.hotelinformationservice.repository.HotelInfoRepository;
import com.epam.hotelinformationservice.services.HotelInfoDaoService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

/**
 * @author Pankaj_Karwa
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelInfoDaoServiceTest {
	
	@Autowired
	private HotelInfoDaoService hotelInfoDaoService;
	
	@MockBean
	private HotelInfoRepository hotelInfoRepository;
	
	
	private Address address = new Address(1L, "Nagar Pune Road", "KedGaon", "Ahmednagar","414001");
    private HotelInfo hotel = new HotelInfo(1L, "Hotel Yash Grand", "0241-2411429",1, address);
    private Optional<HotelInfo> hotel1 = Optional.of(new HotelInfo(1L, "Hotel Yash Grand", "0241-2411429",1, address));
    private Reservation reservation = new Reservation(new Room(),1L, new Date(), new Date(), 1L, ReservationStatus.REQUESTED);
    private Room room =  new Room(102, 1000, RoomType.KING);
    
    
    @Test
    public void addNewHotelTest() {
    	
    	given(hotelInfoRepository.saveHotelInfo(any())).willReturn(hotel);
    	HotelInfo hotelInfo = hotelInfoDaoService.addNewHotel(hotel);
        assertEquals(hotelInfo.getHotelId(), hotel.getHotelId());
    	
    }
	
    
    @Test
    public void getHotelByIdTest() {
    	//given(hotelInfoRepository.findById(anyLong())).willReturn(hotel1);
    	HotelInfo hotelInfo=hotelInfoDaoService.getHotelById(1L);    	
    	assertEquals(hotel.getHotelId(), hotelInfo.getHotelId());
		
    }
    @Test
    public void reservationRequest() {
        //hotel.setReservations(new ArrayList<>());
        hotel.getRooms().add(room);
        given(hotelInfoRepository.findHotelById(anyLong())).willReturn(hotel1);
        Reservation reservation = hotelInfoDaoService.reservationRequest(1L, this.reservation);
        assertTrue(reservation.getState().equals(ReservationStatus.REQUESTED));
    }
    

}
