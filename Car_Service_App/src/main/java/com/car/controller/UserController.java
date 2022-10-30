package com.car.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.pojo.CarUser;
import com.car.pojo.ResponseEntity;
import com.car.service.IUserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@PostMapping(value="/register")
	public ResponseEntity registerCarUser(@RequestBody CarUser carUser){
		System.out.println("input received is "+carUser);
		boolean result = userService.registerCar(carUser);
		ResponseEntity resp = new ResponseEntity(200, result, "success");
		return resp;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity loginCarUser(@RequestBody CarUser carUser) {
		
		boolean login = userService.loginCarUser(carUser);
		System.out.println("login received is "+carUser);
		ResponseEntity resp = new ResponseEntity(200,login,"");
		return resp;
	}
	

}
