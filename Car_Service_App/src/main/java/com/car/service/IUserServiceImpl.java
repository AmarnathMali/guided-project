package com.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.pojo.CarUser;
import com.car.repository.ICarRepo;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private ICarRepo userRepo;
	public void setUserRepo(ICarRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public boolean registerCar(CarUser carUser) {
		int registerUser = userRepo.registerUser(carUser);
		if(registerUser != 0 ){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean loginCarUser(CarUser carUser) {
		int loginCarUser = userRepo.loginCarUser(carUser);
		if(loginCarUser == 1) {
			return true;
		}else {
			return false;
		}
		
	}

}
