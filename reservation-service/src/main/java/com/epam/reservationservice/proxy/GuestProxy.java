package com.epam.reservationservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.epam.reservationservice.model.ProxyGuest;

@FeignClient(name="guest-service",url = "localhost:8100")
public interface GuestProxy {
	
	@GetMapping(path = "/guestById/{id}")
	public ProxyGuest retrivalGuest(@PathVariable long id);
	
	
	
	

}
