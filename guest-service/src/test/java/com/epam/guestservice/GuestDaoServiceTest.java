package com.epam.guestservice;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.guestservice.Dao.GuestDaoService;
import com.epam.guestservice.entity.Guest;
import com.epam.guestservice.repository.GuestRepository;

import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestDaoServiceTest {
	
	@Autowired
	private GuestDaoService guestDaoService;
	
	@MockBean
	private GuestRepository guestRepository;
	
	private Guest guest = new Guest(1L, "Thomas", "thomas@gmail.com", "986989989", 3, "Welcome");
	private Optional<Guest> guest1 = Optional.of(new Guest(1L, "Thomas", "thomas@gmail.com", "986989989", 3, "Welcome"));
	private Optional<Guest> guest2 = Optional.of(new Guest(1L, "Thomas", "thomas@gmail.com", "986989989", 3, "Welcome"));
	@Test
	@Order(1)
	public void findAllGuest() {
		given(guestRepository.findById(1L)).willReturn(guest1);
		given(guestRepository.findById(2L)).willReturn(guest2);
		
	    List<Guest> guestList=guestDaoService.findAllGuest();
	    assertTrue(guestList.stream().filter(guest -> guest.getGuestId().equals(1L)).findFirst().isPresent());
	}
	
	@Test
	@Order(2)
	public void saveGuest() {
		
		 given(guestRepository.save(any())).willReturn(guest);
		 
		 Guest resultGuest= guestDaoService.saveGuest(guest);
		 
		 assertEquals(guest.getGuestId(), resultGuest.getGuestId());
		 assertEquals(guest.getName(), resultGuest.getName());
		 assertEquals(guest.getEmail(), resultGuest.getEmail());
		 assertEquals(guest.getContactNumber(), resultGuest.getContactNumber());
		
		
	}
	
	@Test
	@Order(3)
	public void findGuestById() {
				
		Guest resultGust= guestDaoService.findGuestById(1L);
		assertEquals(guest.getGuestId(), resultGust.getGuestId());
		assertEquals(guest.getContactNumber(), resultGust.getContactNumber());
		assertEquals(guest.getEmail(), resultGust.getEmail());
		assertEquals(guest.getName(), resultGust.getName());
				
	}
	
	

}
