package com.epam.reservationservice.model;


public class ProxyAddress {
	
	
	
	    public ProxyAddress(Long addressId, String street, String area, String city) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.area = area;
		this.city = city;
	}
		private Long addressId;
	    private String street;
	    private String area;
	    private String city;
	    private String pin;
	    
	    public ProxyAddress() {
			super();
			// TODO Auto-generated constructor stub
		}
	    public ProxyAddress(Long addressId, String street, String area, String city, String pin) {
			super();
			this.addressId = addressId;
			this.street = street;
			this.area = area;
			this.city = city;
			this.pin = pin;
		}
		public Long getAddressId() {
			return addressId;
		}
		public void setAddressId(Long addressId) {
			this.addressId = addressId;
		}
		public String getStreet() {
			return street;
		}
		
		public void setStreet(String street) {
			this.street = street;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		@Override
		public String toString() {
			return "Address [addressId=" + addressId + ", street=" + street + ", area=" + area + ", city=" + city + ", pin="
					+ pin + "]";
		}	

}
