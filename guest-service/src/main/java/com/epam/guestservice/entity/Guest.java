package com.epam.guestservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description =" All Details about Guest" )
@Entity
public class Guest {
	
	@Id
	@GeneratedValue
	private Long guestId;
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name should have atleast 2 characters")
    private String name;
	@Email(message = "Email should be valid")
	@ApiModelProperty(notes="Email should be valid")
    private String email;
    private String contactNumber;
    public Guest() {
		
	}

	private int rating;
    private String message;
    
    @ElementCollection
    private List<Long> reservations =  new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "Card", joinColumns = @JoinColumn(name = "guest_id"))
    private List<Card> cards = new ArrayList<>();
    
    
    @Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", rating=" + rating + ", message=" + message + ", reservations=" + reservations + ", cards=" + cards
				+ "]";
	}



	public Long getGuestId() {
		return guestId;
	}



	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public List<Long> getReservations() {
		return reservations;
	}



	public void setReservations(List<Long> reservations) {
		this.reservations = reservations;
	}



	public List<Card> getCards() {
		return cards;
	}



	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	

	

	public Guest(String message) {
		// TODO Auto-generated constructor stub
		this.setMessage(message);
	}

	public Guest(long guestId, String name, String email, String contactNumber, int rating, String message) {
		// TODO Auto-generated constructor stub
		this.guestId=guestId;
		this.name=name;
		this.email= email;
		this.contactNumber=contactNumber;
		this.rating=rating;
		this.message=message;
		
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
