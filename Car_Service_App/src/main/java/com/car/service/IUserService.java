package com.car.service;

import com.car.pojo.CarUser;

public interface IUserService {

	boolean registerCar(CarUser carUser);

	boolean loginCarUser(CarUser carUser);

}
