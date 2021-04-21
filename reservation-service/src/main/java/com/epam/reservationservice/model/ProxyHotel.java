package com.epam.reservationservice.model;

import java.util.ArrayList;
import java.util.List;


public class ProxyHotel {
	
	private Long hotelId;
	public ProxyHotel(Long hotelId, String name, String phoneNumber, int starRatting, ProxyAddress address) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.starRatting = starRatting;
		this.address = address;
	}


	private String name;
    private String phoneNumber;
    private int starRatting;   
    private ProxyAddress address;
    
       
	/*
	 * private List<Room> rooms = new ArrayList<>();
	 * 
	 * 
	 * private List<Reservation> reservations = new ArrayList<>(); public String
	 * getName() { return name; }
	 * 
	 */
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


	public ProxyAddress getAddress() {
		return address;
	}


	public void setProxyAddress(ProxyAddress address) {
		this.address = address;
	}


	public Object getHotelId() {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * public List<Room> getRooms() { return rooms; }
	 * 
	 * 
	 * public void setRooms(List<Room> rooms) { this.rooms = rooms; }
	 * 
	 * 
	 * public List<Reservation> getReservations() { return reservations; }
	 * 
	 * 
	 * public void setReservations(List<Reservation> reservations) {
	 * this.reservations = reservations; }
	 */

	


}
