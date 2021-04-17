package com.epam.reservationservice.model;

import java.util.Date;

public class Reservation {
	private Date fromDate;
    private Date toDate;
    private Long guestId;
    private Long hotelId;
    private Long reservationId;
	private ReservationStatus state;
    private String roomType;
    private ProxyGuest guest;
    private ProxyHotel proxyHotel;
    private double amount;
    private Card card;
    
    public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}


	public Reservation(Date fromDate, Date toDate, Long guestId, Long hotelId, Long reservationId, ReservationStatus state, String roomType, Card card) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.guestId = guestId;
        this.hotelId = hotelId;
        this.reservationId = reservationId;
        this.state = state;
        this.roomType = roomType;
        this.card = card;
    }
    
    
    public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Long getGuestId() {
		return guestId;
	}
	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public ReservationStatus getState() {
		return state;
	}
	public void setState(ReservationStatus state) {
		this.state = state;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public ProxyGuest getGuest() {
		return guest;
	}
	public void setGuest(ProxyGuest guest) {
		this.guest = guest;
	}
	public ProxyHotel getProxyHotel() {
		return proxyHotel;
	}
	public void setProxyHotel(ProxyHotel proxyHotel) {
		this.proxyHotel = proxyHotel;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	


}
