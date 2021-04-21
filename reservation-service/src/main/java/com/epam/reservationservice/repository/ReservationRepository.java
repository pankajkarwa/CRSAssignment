package com.epam.reservationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.reservationservice.model.Reservation;


@Repository
public interface ReservationRepository extends  CrudRepository<Reservation, Long> {

}
