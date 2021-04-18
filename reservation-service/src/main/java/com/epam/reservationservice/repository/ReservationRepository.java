package com.epam.reservationservice.repository;

import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
