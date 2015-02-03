package com.p2p.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2p.car.dao.UserMapper;
import com.p2p.car.model.UserBean;
import com.p2p.car.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;

	public UserMapper getAddMapper() {
		return userMapper;
	}
	@Autowired
	public void setAddMapper(UserMapper addMapper) {
		this.userMapper = addMapper;
	}

	@Override
	public boolean addInfo(UserBean addInfo) {
		if (userMapper.insertSelective(addInfo) == 1) {
			return true;
		}
		return false;
	}
	@Override
	public List<UserBean> getAll() {
		return userMapper.getAll();
	}
	@Override
	public boolean delete(String id) {
		if (userMapper.deleteByPrimaryKey(id) == 1) {
			return true;
		}
		return false;
	}
	@Override
	public UserBean findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public boolean update(UserBean addInfo) {
		if (userMapper.updateByPrimaryKeySelective(addInfo) == 1) {
			return true;
		}
		return false;
	}
	

}
