package com.epam.reservationservice;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.epam.reservationservice.model.Card;
import com.epam.reservationservice.model.ProxyGuest;
import com.epam.reservationservice.model.Reservation;
import com.epam.reservationservice.model.ReservationStatus;
import com.epam.reservationservice.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationServiceControllerTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	@MockBean
	private ReservationService reservationService;
	private Card card =  new Card("56565656XXXX","23","2026");

	private Reservation reservation = new Reservation(new Date(), new Date(), 1L, 1L, 1L, ReservationStatus.REQUESTED,
			"SINGLE", new Card(card.getCardNumber(), card.getExpMonth(), card.getExpYear()));

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				// .apply(springSecurity())
				.build();
	}

	@Test
	public void reservationRequest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reservation);
		given(reservationService.requestForReservation(any())).willReturn(reservation);
		mockMvc.perform(post("/reservation")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());			
	}
	
	@Test
	public void confirmReservation() throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		String json = mapper.writeValueAsString(reservation);
		given(reservationService.updateReservation(any())).willReturn(reservation);
		mockMvc.perform(patch("/reservation")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());		
				
	}
	
	@Test
	public void getReservation () throws Exception{
		
		given(reservationService.getReservation(anyLong())).willReturn(reservation);
		mockMvc.perform(get("/reservations/{id}","1")
                .param("isDetailsRequired","false")
                .accept(MediaType.APPLICATION_JSON_VALUE))                
                .andExpect(status().isOk());
		
	}
	
	@Test
	public void cancelReservation() throws Exception{
		reservation.setState(ReservationStatus.CANCELLED);
        ObjectMapper mapper =  new ObjectMapper();
        String input =  mapper.writeValueAsString(reservation);
        given(reservationService.updateReservation(any())).willReturn(reservation);
        mockMvc.perform(patch("/reservations")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(input))                       
                   .andExpect(status().isOk());
				
	}	
	
	 @Test
	    public void getReservationsByGuestId() throws Exception {
		 ProxyGuest guest =  new ProxyGuest(1l, "Pankaj","Pankaj@gmail.com", "8884352728", 3, new ArrayList<>()); 
	        
	        given(reservationService.getReservationsByGuestId(anyLong())).willReturn(guest);

	        mockMvc.perform(get("/reservations/guests/{guestId}","1")
	                .contentType(MediaType.APPLICATION_JSON_VALUE)	                
	        )
	                .andExpect(status().isOk());

	    }
	
	

}
