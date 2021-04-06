package com.epam.hotelinformationservice;

import static org.hamcrest.CoreMatchers.any;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.hotelinformationservice.entity.Address;
import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;
import com.epam.hotelinformationservice.entity.ReservationStatus;
import com.epam.hotelinformationservice.entity.Room;
import com.epam.hotelinformationservice.entity.RoomType;
import com.epam.hotelinformationservice.repository.HotelInfoRepository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelInfoRepositoryTest {
	
	@Autowired
	private HotelInfoRepository hotelInfoRepository;
	
	private Address address = new Address(1L, "Nagar Pune Road", "KedGaon", "Ahmednagar","414001");
    private HotelInfo hotel = new HotelInfo(1L, "Hotel Yash Grand", "0241-2411429",1, address);
    private Room room = new Room(501, 4500, RoomType.KING);
    private Reservation reservation = new Reservation(new Room(),1L, new Date(), new Date(), 1L, ReservationStatus.REQUESTED);
    
	@Test
	public void saveTest() {
		HotelInfo save= hotelInfoRepository.saveHotelInfo(hotel);
		assertEquals(save.getHotelId(), hotel.getHotelId());
	}
	
	@Test
	public void findByIdTest() {
		Optional<HotelInfo> findById=hotelInfoRepository.findHotelById(1L);
		 assertEquals(findById.get().getHotelId(), hotel.getHotelId());
	}

}
