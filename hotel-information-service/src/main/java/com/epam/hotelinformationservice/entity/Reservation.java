package com.epam.hotelinformationservice.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "Reservation")
public class Reservation {
	
	@JoinColumn(name = "roomNo")
	private Room room;
	@Id
    private Long guestId;
	private Date fromDate;
    private Date toDate;
    private Long reservationId;
    private ReservationStatus state;
    //private String roomType;
    
    @Override
	public String toString() {
		return "Reservation [room=" + room + ", guestId=" + guestId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", reservationId=" + reservationId + ", state=" + state + "]";
	}


    
    
    
    

	
    public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Room room, Long guestId, Date fromDate, Date toDate, Long reservationId, ReservationStatus state
			) {
		
		this.room = room;
		this.guestId = guestId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reservationId = reservationId;
		this.state = state;
		
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
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

	/*public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}*/

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId);
    }

	
}
