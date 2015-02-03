package com.p2p.car.dao;

import java.util.List;

import com.p2p.car.model.UserBean;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
    
    List<UserBean> getAll();
}