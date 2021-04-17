package com.epam.reservationservice.model;

public class Card {
	 private Long cardId;
	    private String cardNumber;
	    private String expMonth;
	    private String expYear;
	    
		public Card(String cardNumber, String expMonth, String expYear) {			
			this.cardNumber = cardNumber;
			this.expMonth = expMonth;
			this.expYear = expYear;
		}
		public Card() {
			
		}
		public Long getCardId() {
			return cardId;
		}
		public void setCardId(Long cardId) {
			this.cardId = cardId;
		}
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
		public String getExpMonth() {
			return expMonth;
		}
		public void setExpMonth(String expMonth) {
			this.expMonth = expMonth;
		}
		public String getExpYear() {
			return expYear;
		}
		public void setExpYear(String expYear) {
			this.expYear = expYear;
		}
}
