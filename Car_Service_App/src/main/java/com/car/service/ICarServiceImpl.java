package com.car.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.controller.Costs;
import com.car.pojo.CarService;
import com.car.pojo.Dashboard;
import com.car.pojo.Slot;
import com.car.repository.ICarRepo;


@Service
public class ICarServiceImpl implements ICarService{
	
	@Autowired
	private ICarRepo carRepo;

	public void setCarServiceRepo(ICarRepo carServiceRepo) {
		this.carRepo = carRepo;
	}

	public boolean checkAvailability(Date inputDate) {
		int count = carRepo.checkAvailability(inputDate);
		if (count >= 5) {
			return false;
		} else {
			return true;
		}
	}	

	@Override
	public int bookASlot(Slot slot) {
		int result = carRepo.bookASlot(slot);
		return result;
	}

	@Override
	public int checkInCar(CarService carService) {
		int result = carRepo.checkInCar(carService);
		return result;
	}

	@Override
	public List<Dashboard> displayDashboard() {
		return carRepo.displayDashboard();
		 
	}

	@Override
	public int generateBill(int checkInId) {
		CarService cs = carRepo.getServiceDetails(checkInId);
		int serviceBill = Costs.serviceCharge.getAmount();
		for(String s : cs.getAdditionalCheckUps()) {
			switch(s) {
				case "wheelAlignment" : 
					serviceBill = serviceBill + Costs.wheelAlignment.getAmount();
					break;
				case "gearCheckUp" :
					serviceBill = serviceBill + Costs.gearCheckUp.getAmount();
					break;
				case "oilsCheckUp" :
					serviceBill = serviceBill + Costs.oilsCheckUp.getAmount();
					break;
			}
		}
		carRepo.updateBillInService(checkInId, serviceBill);
		return serviceBill;
	}

	

	@Override
	public String updatePayBill(int checkInId) {
		int result = carRepo.updatePayBill(checkInId);
		return (result != 0) ? "success" : "failure";
	}

	
}
