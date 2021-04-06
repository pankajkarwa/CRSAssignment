package com.epam.guestservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


import com.epam.guestservice.Dao.GuestDaoService;
import com.epam.guestservice.entity.Guest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GusetControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private GuestDaoService guestDaoService;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
//	                .apply(springSecurity())
				.build();
	}

	private Guest guest = new Guest(1L, "Thomas", "thomas@gmail.com", "986989989", 3, "Welcome");

	@Test
	public void retrivalGuest_ShouldReturnGuest() throws Exception {
		given(guestDaoService.findGuestById(1L)).willReturn(guest);
		mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.get("/guests/{guestId}", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("name").value("Thomas"))
				.andExpect(jsonPath("email").value("Thomas@hotmail.com"))
				.andExpect(jsonPath("contactNumber").value("986989989")));

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void retrievAllGuest_ShouldReturnAllGuest() throws Exception {
		
		given(((BDDMockito) guestDaoService.findAllGuest()).willReturn(Arrays.asList(guest)));
		
		MvcResult mvcResult =((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(get("/guests")))		
		.param("guestId", "1")
        .param("guestId", "2"))
        .andExpect(status().isOk())
        .andReturn();		
		
		 assertTrue(mvcResult.getResponse().getContentAsString().contains("Thomas"));
		
	}
	
	@Test
	public void addGuest_ShouldAddNewGuest() throws Exception {
		given(guestDaoService.saveGuest(any())).willReturn(guest);
		
		ObjectMapper mapper =  new ObjectMapper();
        String json = mapper.writeValueAsString(guest);
        
        ((ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(post("")))
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(json))        
        .andExpect(status().isCreated());
        
	}
	
	

}
