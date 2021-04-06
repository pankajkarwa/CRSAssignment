package com.epam.hotelinformationservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


public class Hotel {
	
	
   
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getStarRatting() {
		return starRatting;
	}


	public void setStarRatting(int starRatting) {
		this.starRatting = starRatting;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Room> getRooms() {
		return rooms;
	}


	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	private String name;
    private String phoneNumber;
    private int starRatting;
    
   
    private Address address;

   
    private List<Room> rooms = new ArrayList<>();

   
    private List<Reservation> reservations = new ArrayList<>();


}
