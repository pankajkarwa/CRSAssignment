package com.epam.hotelinformationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.hotelinformationservice.entity.HotelInfo;
import com.epam.hotelinformationservice.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{

}
