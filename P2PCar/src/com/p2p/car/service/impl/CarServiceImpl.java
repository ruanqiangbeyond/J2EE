package com.p2p.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2p.car.dao.CarMapper;
import com.p2p.car.model.CarBean;
import com.p2p.car.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService {
	
	private CarMapper carMapper;

	public CarMapper getAddMapper() {
		return carMapper;
	}
	@Autowired
	public void setAddMapper(CarMapper carMapper) {
		this.carMapper = carMapper;
	}

	@Override
	public boolean addInfo(CarBean addInfo) {
		if (carMapper.insertSelective(addInfo) == 1) {
			return true;
		}
		return false;
	}
	@Override
	public List<CarBean> getAllCar(String userId) {
		return carMapper.getAllCar(userId);
	}
	@Override
	public boolean delete(String id) {
		if (carMapper.deleteByPrimaryKey(id) == 1) {
			return true;
		}
		return false;
	}
	@Override
	public CarBean findById(String id) {
		return carMapper.selectByPrimaryKey(id);
	}
	@Override
	public boolean update(CarBean addInfo) {
		if (carMapper.updateByPrimaryKeySelective(addInfo) == 1) {
			return true;
		}
		return false;
	}
	

}
