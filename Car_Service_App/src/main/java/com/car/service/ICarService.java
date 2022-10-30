package com.car.service;

import java.util.Date;
import java.util.List;

import com.car.pojo.CarService;
import com.car.pojo.Dashboard;
import com.car.pojo.Slot;

public interface ICarService {

	boolean checkAvailability(Date date);

	int bookASlot(Slot slot);
	
	int checkInCar(CarService carService);

	List<Dashboard> displayDashboard();

	int generateBill(int checkInId);

	String updatePayBill(int checkInId);

	

}
