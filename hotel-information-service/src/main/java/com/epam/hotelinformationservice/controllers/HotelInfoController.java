package com.epam.hotelinformationservice.controllers;

import java.net.URI;
import java.util.List;

import javax.persistence.PostLoad;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hotelinformationservice.entity.Hotel;
import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;
import com.epam.hotelinformationservice.services.HotelInfoDaoService;




@RestController
public class HotelInfoController {
	
	@Autowired
	private HotelInfoDaoService hotelInfoDaoService;
	//@PostMapping(value = "/hotels", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/addhotels")
	public ResponseEntity<HotelInfo> addHotel(@RequestBody HotelInfo hotelInfo) {
		HotelInfo savedInfo = hotelInfoDaoService.addNewHotel(hotelInfo);
		
		return ResponseEntity.created(URI.create(String.format("/hotelById/" + savedInfo.getHotelId())))
				.body(savedInfo);
		//return null;
		
	}
	
	@GetMapping(path="/hotelById/{id}")
	public HotelInfo getHotelById(@PathVariable long id) {
	    HotelInfo hotelInfo =hotelInfoDaoService.getHotelById(id);
	    return hotelInfo;
	
	}
	
	@PostMapping(path = "/hotels/{hotelId}/reservation")
	public ResponseEntity<Reservation> reservationRequest(@RequestBody Reservation reservation, @PathVariable("hotelId") long hotelId) {
		
		return ResponseEntity.ok(hotelInfoDaoService.reservationRequest(hotelId,reservation));
		
	}
	
	@PutMapping(path = "/hotels/{hotelId}/reservation")
	public ResponseEntity<Reservation> updateReservation(Long hotelId, Reservation reservation) {
        Reservation reservationResult = hotelInfoDaoService.updateReservation(hotelId, reservation);
        return ResponseEntity.accepted().body(reservationResult);
    }
	
	 
  /*  public ResponseEntity<List<Reservation>> getAllReservationsByHotelId(Long hotelId){
        return ResponseEntity.ok(hotelInfoDaoService.getAllReservationsByHotelId(hotelId));
    }

    
   /* public List<Reservation> getReservationByGuestId(Long hotelId, Long guestId)
    {
        List<Reservation> reservations = service.getReservationByGuestIdPerHotel(hotelId, guestId);
        return reservations;
    }
*/
	 @GetMapping(path = "/hotels")
    public List<Hotel> getListOfHotels(List<Long> hotelIds){
        return hotelInfoDaoService.getHotels(hotelIds);
    }

	
	
	

	
	

}
