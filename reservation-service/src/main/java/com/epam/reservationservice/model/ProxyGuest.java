package com.epam.reservationservice.model;

import java.util.ArrayList;
import java.util.List;

/*import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
*/
public class ProxyGuest {
	    private Long guestId;
	    private String name;
	    private String email;
	    private String contactNumber;
	    private int ratting;
	    private List<Card> card;
	    private List<Long> reservations =  new ArrayList<>();

	    
	    
	    public ProxyGuest(long l, String string, String string2, String string3, int i, ArrayList arrayList) {
			// TODO Auto-generated constructor stub
		}
		public Long getGuestId() {
			return guestId;
		}
		public void setGuestId(Long guestId) {
			this.guestId = guestId;
		}
		public ProxyGuest(Long guestId, String name, String email, String contactNumber, int ratting, List<Card> card,
				List<Long> reservations) {
			this.guestId = guestId;
			this.name = name;
			this.email = email;
			this.contactNumber = contactNumber;
			this.ratting = ratting;
			this.reservations = reservations;
		}
		public ProxyGuest(Long guestId, String name, String email, String contactNumber) {
			super();
			this.guestId = guestId;
			this.name = name;
			this.email = email;
			this.contactNumber = contactNumber;
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
		public int getRatting() {
			return ratting;
		}
		public void setRatting(int ratting) {
			this.ratting = ratting;
		}
		public List<Card> getCard() {
			return card;
		}
		public void setCard(List<Card> card) {
			this.card = card;
		}
		public List<Long> getReservations() {
			return reservations;
		}
		public void setReservations(List<Long> reservations) {
			this.reservations = reservations;
		}
			
	

}
