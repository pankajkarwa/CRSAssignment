/**
 * 
 */
package com.epam.hotelinformationservice.repository;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;

/**
 * @author Pankaj_Karwa
 *
 */
@Component
public  class HotelInfoRepository {

	@Autowired
	private CustomeRepository customeRepository;
	
	@Autowired
	public ReservationRepository reservationRepository;
	
	public Optional<HotelInfo> findHotelById(Long id) {		
	     Optional<HotelInfo> hotelInfo=customeRepository.findById(id);
		
		return hotelInfo;
	}

	public  HotelInfo saveHotelInfo(HotelInfo hotelInfo) {
		HotelInfo hotelInfo2= customeRepository.save(hotelInfo);
		return hotelInfo2;
		
	}

	public Reservation findReservationById(Long reservationId) {
		
	        Optional<Reservation> reservationDTO = reservationRepository.findById(reservationId);

	        return reservationDTO.isPresent()?reservationDTO.get(): reservationDTO.orElseThrow(() -> new EntityNotFoundException("Reservation not found :"+reservationId));

	    

	}

	
}
