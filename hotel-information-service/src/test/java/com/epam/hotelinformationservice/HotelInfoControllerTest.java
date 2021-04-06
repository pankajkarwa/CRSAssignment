package com.epam.hotelinformationservice;


import static org.mockito.ArgumentMatchers.*;

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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.epam.hotelinformationservice.entity.Address;
import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;
import com.epam.hotelinformationservice.entity.ReservationStatus;
import com.epam.hotelinformationservice.entity.Room;
import com.epam.hotelinformationservice.services.HotelInfoDaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelInfoControllerTest {
	
	private MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext context;
    
    @MockBean
    private HotelInfoDaoService hotelInfoDaoService;
    
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
               // .apply(springSecurity())
                .build();
    }
    
    private Address address = new Address(1L, "Nagar Pune Road", "KedGaon", "Ahmednagar","414001");
    private HotelInfo hotel = new HotelInfo(1L, "Hotel Yash Grand", "0241-2411429",1, address);
    private Reservation reservation = new Reservation(new Room(),1L, new Date(), new Date(), 1L, ReservationStatus.REQUESTED);

    //addHotel
    
    @Test
    public void addHotelTest() throws Exception {
    	
    	given(hotelInfoDaoService.addNewHotel(any())).willReturn(hotel);
    	
    	ObjectMapper objectMapper= new ObjectMapper();
    	String json= objectMapper.writeValueAsString(hotel);
    	
    	((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(post("/hotels")))
    	.contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(json))
        .andExpect(status().isCreated());
    	   	
    }
    
    @Test
    public void getHotelByIdTest() throws Exception {
    	given(hotelInfoDaoService.getHotelById(anyLong())).willReturn(hotel);    	
    	((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(get("/hotel")))
    	.accept(MediaType.APPLICATION_JSON_VALUE))
    	.andExpect(status().isOk());
    }
    

}
