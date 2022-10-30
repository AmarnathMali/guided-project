package com.car.repository;

import java.util.Date;
import java.util.List;

import com.car.pojo.CarService;
import com.car.pojo.CarUser;
import com.car.pojo.Dashboard;
import com.car.pojo.Slot;

public interface ICarRepo {

	 int registerUser(CarUser carUser);

	int loginCarUser(CarUser carUser);


	int bookASlot(Slot slot);

	int checkInCar(CarService carService);

	List<Dashboard> displayDashboard();

	int checkAvailability(Date inputDate);

	CarService getServiceDetails(int checkInId);

	int updateBillInService(int checkInId, int serviceBill);

	int updatePayBill(int checkInId);

	


}
