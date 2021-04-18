package com.epam.guestservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guestservice.Dao.GuestDaoService;
import com.epam.guestservice.entity.Guest;
import com.epam.guestservice.exception.GuestNotFoundException;
import com.epam.guestservice.repository.GuestRepository;

@RestController
public class GusetController {
	
	/*@Autowired
	private GuestDaoService guestDaoService;
	*/
	@Autowired
	private GuestRepository guestRepository ;
	@Autowired
	private GuestDaoService guestDaoService;
	 

	/*@GetMapping(path = "/guestTest")
	public String getGuest() {
		return "Guset";
	}

	@GetMapping(path = "/guest")
	public Guest getGuestList() {
		return new Guest("Guset");
	}

	// fetch guest by Id.
	@GetMapping(path = "/guest/{Id}")
	public Guest getGuestList(@PathVariable int Id) {
		return new Guest("Guset");
	}

	
*/
	@GetMapping(path = "/guests")
	public List<Guest> retrievAllGuest() {
		return guestDaoService.findAllGuest();
		//return guestRepository.findAll();
	}

	@GetMapping(path = "/guestById/{id}")
	public Guest retrivalGuest(@PathVariable long id) throws EntityNotFoundException {

		Guest guest = guestDaoService.findGuestById(id);
		//Optional<Guest> guest = guestRepository.findById(id);
		if (guest == null) {
			throw new GuestNotFoundException("Guest Id:" + id);
		}
		return guest;
	}

	@PostMapping(path = "/newGuest")
	public ResponseEntity<Guest> addGuest(@Valid @RequestBody Guest guest) {
		Guest savedGuest = guestDaoService.saveGuest(guest);
		//Guest savedGuest = guestRepository.save(guest);
		
		return ResponseEntity.created(URI.create(String.format("/guestById/" + savedGuest.getGuestId())))
				.body(savedGuest);
	}

}
