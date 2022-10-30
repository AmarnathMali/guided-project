package com.car.pojo;

import java.util.Date;

public class Dashboard {

	private int checkInId;
	private Date serviceDate;
	private String vehicleNumber;
	private String userName;
	private String mobile;
	private String status;
	private String checkInDate;
	private String checkOutDate;
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dashboard(int checkInId, Date serviceDate, String vehicleNumber, String userName, String mobile,
			String status, String checkInDate, String checkOutDate) {
		super();
		this.checkInId = checkInId;
		this.serviceDate = serviceDate;
		this.vehicleNumber = vehicleNumber;
		this.userName = userName;
		this.mobile = mobile;
		this.status = status;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public int getCheckInId() {
		return checkInId;
	}
	public void setCheckInId(int checkInId) {
		this.checkInId = checkInId;
	}
	public Date getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	@Override
	public String toString() {
		return "Dashboard [checkInId=" + checkInId + ", serviceDate=" + serviceDate + ", vehicleNumber=" + vehicleNumber
				+ ", userName=" + userName + ", mobile=" + mobile + ", status=" + status + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	
	
	

}
