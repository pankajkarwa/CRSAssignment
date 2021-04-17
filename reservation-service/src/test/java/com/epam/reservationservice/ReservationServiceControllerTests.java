package com.epam.reservationservice;

import java.util.Date;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.epam.reservationservice.model.Card;
import com.epam.reservationservice.model.Reservation;
import com.epam.reservationservice.model.ReservationStatus;
import com.epam.reservationservice.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationServiceControllerTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	@MockBean
	private ReservationService reservationService;
	private Card card =  new Card("78787878XXXX","10","2025");

	private Reservation reservation = new Reservation(new Date(), new Date(), 1L, 1L, 1L, ReservationStatus.REQUESTED,
			"SINGLE", new Card(card.getCardNumber(), card.getExpMonth(), card.getExpYear()));

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				// .apply(springSecurity())
				.build();
	}

	public void reservationRequest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reservation);
		given(reservationService.requestForReservation(any())).willReturn(reservation);
	}

}
