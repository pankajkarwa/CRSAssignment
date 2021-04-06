/**
 * 
 */
package com.epam.hotelinformationservice.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;
import com.epam.hotelinformationservice.entity.Room;
import com.epam.hotelinformationservice.repository.HotelInfoRepository;



/**
 * @author Pankaj_Karwa
 *
 */
@Component
public class HotelInfoDaoService {
	
	@Autowired
	private HotelInfoRepository hotelInfoRepository;

	public HotelInfo addNewHotel(HotelInfo hotelInfo) {
		// TODO Auto-generated method stub
		HotelInfo savedInfo =hotelInfoRepository.saveHotelInfo(hotelInfo);
		return savedInfo;
	}

	public HotelInfo getHotelById(long id) {
		// TODO Auto-generated method stub
		
		Optional<HotelInfo> hotelByIDInfo=hotelInfoRepository.findHotelById(id);
		return hotelByIDInfo.get();
	}

	public Reservation reservationRequest(long hotelId, Reservation reservation) {
		Optional<HotelInfo> hotelInfo= hotelInfoRepository.findHotelById(hotelId);
		reservation.setRoom(findAvailableRoom(hotelInfo,reservation.getFromDate(),reservation.getToDate()));
		return reservation;
	}

	private Room findAvailableRoom(Optional<HotelInfo> hotelInfo, Date fromDate, Date toDate) {
		List<Room> reservedRooms= hotelInfo.get().getReservations().stream().filter(iReservation->iReservation.getFromDate().equals(fromDate))
				.map(iReservation->iReservation.getRoom()).collect(Collectors.toList());
		
		Optional<Room> avilableRoom=hotelInfo.get().getRooms().stream().filter(room->{return reservedRooms.contains(room);}).findFirst();
		
		return avilableRoom.isPresent()? avilableRoom.get():null;  
	}

	public Reservation updateReservation(Long hotelId, Reservation reservation) {
		Reservation findReservation = hotelInfoRepository.findReservationById(reservation.getReservationId());
		//findReservation.setState(null);
		findReservation.setState(reservation.getState());
        return reservation;
	}

	public Object getAllReservationsByHotelId(Long hotelId) {
		
		return null;
	}

	
}
