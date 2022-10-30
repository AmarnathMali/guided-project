package com.car.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.pojo.ResponseEntity;
import com.car.service.ICarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/bill")
public class BillController {

	@Autowired
	private ICarService service;

	public void setService(ICarService service) {
		this.service = service;
	}

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public   ResponseEntity generateBill(@RequestParam int checkInId) throws ParseException {
		int result = service.generateBill(checkInId);
		ResponseEntity resp = new ResponseEntity(200, result, "");
		return resp;
	}

	@RequestMapping(value = "/pay/{checkInId}", method = RequestMethod.GET)
	public   ResponseEntity payBill(@PathVariable int checkInId) {
		String result = service.updatePayBill(checkInId);
		ResponseEntity resp = new ResponseEntity(200, result, "");
		return resp;
	}
}
