package com.epam.hotelinformationservice.entity;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "Room")
public class Room {
	
	    private int roomNo;
	    private double rentPerNight;
		private RoomType roomType;
	    private boolean isOccupiedCurrently = false;

	    @Override
		public String toString() {
			return "Room [roomNo=" + roomNo + ", rentPerNight=" + rentPerNight + ", roomType=" + roomType
					+ ", isOccupiedCurrently=" + isOccupiedCurrently + "]";
		}

		public Room() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Room(int roomNo, double rentPerNight, RoomType roomType) {
			this.roomNo=roomNo;
			this.rentPerNight=rentPerNight;
			this.roomType=roomType;
		}

		public int getRoomNo() {
			return roomNo;
		}

		public void setRoomNo(int roomNo) {
			this.roomNo = roomNo;
		}

		public double getRentPerNight() {
			return rentPerNight;
		}

		public void setRentPerNight(double rentPerNight) {
			this.rentPerNight = rentPerNight;
		}

		public RoomType getRoomType() {
			return roomType;
		}

		public void setRoomType(RoomType roomType) {
			this.roomType = roomType;
		}

		public boolean isOccupiedCurrently() {
			return isOccupiedCurrently;
		}

		public void setOccupiedCurrently(boolean isOccupiedCurrently) {
			this.isOccupiedCurrently = isOccupiedCurrently;
		}


	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Room room = (Room) o;
	        return roomNo == room.roomNo && roomType == room.roomType;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(roomNo, roomType);
	    }
	    

}
