package com.btp.olingo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btp.olingo.entities.Address;
import com.btp.olingo.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@RequestMapping("/address")
	public List<Address> readAddresses(){
		return addressService.getAddresses();
	}
	
	@PostMapping("/address")
	public Address createAddress(@RequestBody Address addressObj) {
		return addressService.createAddress(addressObj);
	}
}
