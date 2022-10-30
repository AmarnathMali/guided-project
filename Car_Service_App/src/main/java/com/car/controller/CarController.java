package com.car.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.car.pojo.CarService;
import com.car.pojo.Dashboard;
import com.car.pojo.ResponseEntity;
import com.car.pojo.Slot;
import com.car.service.ICarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/carApp")
public class CarController {

	@Autowired
	private ICarService carService;

	public void setCarService(ICarService carService) {
		this.carService = carService;
	}
	
	@PostMapping(value = "/checkslot")
	public ResponseEntity checkAvailability(@RequestBody String date) throws ParseException {
		System.out.println("date received is " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateInUtil = sdf.parse(date);
		boolean result = carService.checkAvailability(dateInUtil);
		ResponseEntity resp = new ResponseEntity(200, result, "");
		return resp;
		
	}
	
	@PostMapping(value = "/book")
	public   ResponseEntity bookASlot(@RequestBody Slot slot) {
		System.out.println("book slot rest api "+ slot);
		int booking = carService.bookASlot(slot);
		ResponseEntity resp = new ResponseEntity(200,booking,"");
		return resp;
		
	}
	
	
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public ResponseEntity checkInCar(@RequestBody CarService checkCarService) {
		System.out.println("checkin car web service called with input "+checkCarService);
		int checkInId = carService.checkInCar(checkCarService);
		return new ResponseEntity(200, checkInId, "");
	}

	@GetMapping(value = "/dashboard")
	public   ResponseEntity displayDashboard() {
		List<Dashboard> dashboards = carService.displayDashboard();
		ResponseEntity resp = new ResponseEntity(200, dashboards, "");
		return resp;
	}

}
