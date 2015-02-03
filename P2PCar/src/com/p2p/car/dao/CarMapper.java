package com.p2p.car.dao;

import java.util.List;

import com.p2p.car.model.CarBean;

public interface CarMapper {
    int deleteByPrimaryKey(String id);

    int insert(CarBean record);

    int insertSelective(CarBean record);

    CarBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CarBean record);

    int updateByPrimaryKey(CarBean record);
    
    List<CarBean> getAllCar(String userId);
}