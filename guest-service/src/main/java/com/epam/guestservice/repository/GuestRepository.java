package com.epam.guestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.guestservice.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
	
	
	

}
