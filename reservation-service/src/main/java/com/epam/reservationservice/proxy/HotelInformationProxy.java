package com.epam.reservationservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import com.epam.reservationservice.model.ProxyHotel;
import com.epam.reservationservice.model.Reservation;


@FeignClient(name="hotel-information-service",url = "localhost:8200")
public interface HotelInformationProxy {

	@GetMapping(path="/hotelById/{id}")
	public ProxyHotel getHotelById(@PathVariable long id);
	
	 @GetMapping(path = "/hotels")
	    public List<ProxyHotel> getListOfHotels(List<Long> hotelIds);
	 
	    @PostMapping(path = "/hotels/{hotelId}/reservation")
		public ResponseEntity<Reservation> reservationRequest(@RequestBody Reservation reservation, @PathVariable("hotelId") long hotelId);
		
		@PutMapping(path = "/hotels/{hotelId}/reservation")
		public ResponseEntity<Reservation> updateReservation(Long hotelId, Reservation reservation);
		
	 
	 

}
