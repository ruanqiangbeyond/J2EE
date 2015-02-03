package com.p2p.car.service;

import java.util.List;

import com.p2p.car.model.CarBean;

public interface CarService {
	
	boolean addInfo(CarBean addInfo);
	
	List<CarBean> getAllCar(String userId);
	
	boolean delete(String id);
	
	CarBean findById(String id);
	
	boolean update(CarBean addInfo);

}
