package com.p2p.car.service;

import java.util.List;

import com.p2p.car.model.UserBean;

public interface UserService {
	
	boolean addInfo(UserBean addInfo);
	
	List<UserBean> getAll();
	
	boolean delete(String id);
	
	UserBean findById(String id);
	
	boolean update(UserBean addInfo);

}
