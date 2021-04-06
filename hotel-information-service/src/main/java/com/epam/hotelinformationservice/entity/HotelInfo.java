package com.epam.hotelinformationservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Hotel")
public class HotelInfo {	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long hotelId;
	    private String name;
	    private String phoneNumber;
	    private int starRatting;
	    
	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "addressId")
	    private Address address;

	    @ElementCollection
	    @CollectionTable(name = "Room", joinColumns = @JoinColumn(name = "hotel_id"))
	    @Column(name = "rooms")
	    private List<Room> rooms = new ArrayList<>();

	    @Column(name = "reservations")
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "reservationId")
	    private List<Reservation> reservations = new ArrayList<>();

	    
	    
	    
	    public HotelInfo() {
			
		}

	    
	    public HotelInfo(Long hotelId, String name, String phoneNumber, int starRatting, Address address) {
	        this.hotelId = hotelId;
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.starRatting = starRatting;
	        this.address = address;
	    }


		public Long getHotelId() {
			return hotelId;
		}

		/*@Override
		public String toString() {
			return "HotelInfo [hotelId=" + hotelId + ", name=" + name + ", phoneNumber=" + phoneNumber
					+ ", starRatting=" + starRatting + ", address=" + address + ", rooms=" + rooms + ", reservations="
					+ reservations + "]";
		}*/


		public void setHotelId(Long hotelId) {
			this.hotelId = hotelId;
		}

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

		

}
