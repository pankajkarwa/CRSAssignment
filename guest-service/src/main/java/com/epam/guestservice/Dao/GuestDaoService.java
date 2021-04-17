package com.epam.guestservice.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.guestservice.entity.Guest;
import com.epam.guestservice.repository.GuestRepository;

@Component
public class GuestDaoService {
	private static List<Guest> guests= new ArrayList<>(); 
	
	
	@Autowired
	private GuestRepository guestRepository ;
	
	static {
		guests.add(new Guest(1,"Thomas","thomas@gemail.com","6764376438",3,"welcome"));
		guests.add(new Guest(2,"Thomas","thomas@gemail.com","6764376438",3,"welcome"));
		guests.add(new Guest(3,"Thomas","thomas@gemail.com","6764376438",3,"welcome"));
	}
	
	public List<Guest> findAllGuest(){
		return guestRepository.findAll();
		//return guests;
	}
	
	public Guest saveGuest(Guest guest) {
		
		 guestRepository.save(guest);
		//guests.add(guest);
		return guest;		
	}
	
	public Guest findGuestById(long Id) throws EntityNotFoundException
	{
		Optional<Guest> guestbyId= guestRepository.findById(Id);
		
		/*for(Guest guest:guests) {
			if(guest.getGuestId()==Id) {
				return guest;
			}`
		}*/
		return guestbyId.get();
	}

}
