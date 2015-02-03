package com.p2p.car.model;

import java.io.Serializable;

public class CarBean implements Serializable {
	private String carId;
	private String carName;
	private String carImage;
	private String carGearboxes;
	private String userId;
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	public String getCarGearboxes() {
		return carGearboxes;
	}
	public void setCarGearboxes(String carGearboxes) {
		this.carGearboxes = carGearboxes;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
