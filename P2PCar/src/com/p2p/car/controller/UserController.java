package com.p2p.car.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.p2p.car.model.UserBean;
import com.p2p.car.service.UserService;

@Controller
public class UserController {
	static Logger log4j = Logger.getLogger(UserController.class.getClass());
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("addUser")
	public String addUser(UserBean add,HttpServletRequest request){
		String strInfo = "添加失败。";
		try {			
			add.setUserId(UUID.randomUUID().toString());
			log4j.info(add.getUserId() + ":::::" + add.getUserName());
			if(userService.addInfo(add)){
				log4j.info("添加用户成功......");
				strInfo = "添加用户成功。";
			}
			request.setAttribute("InfoMessage", strInfo);
		} catch (Exception e) {
			log4j.error(e);
			request.setAttribute("InfoMessage", strInfo);
		} finally {			
			return "result";
		}
	}
	
	@RequestMapping("getAllUser")
	public String getAllUser(HttpServletRequest request){
		try {			
			List<UserBean> list = userService.getAll();
			log4j.info(list);
			request.setAttribute("addLists", list);
			return "listAll";
		} catch (Exception e) {
			log4j.error("获取用户数据失败"+e);
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("deleteUser")
	public String deleteUser(String tid,HttpServletRequest request){
		String strInfo = "用户删除失败。";
		try {			
			if(userService.delete(tid)){
				strInfo = "用户已被删除。";
				request.setAttribute("InfoMessage", strInfo);
			}
		} catch (Exception e) {
			log4j.error("删除用户数据失败"+e);
			request.setAttribute("InfoMessage", strInfo);
		} finally {			
			return "result";
		}
	}
	@RequestMapping("modifyUser")
	public String modifyUser(String tid,HttpServletRequest request){
		try {			
			UserBean add = userService.findById(tid);
			request.setAttribute("add", add);
			return "modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("updateUser")
	public String updateUser(UserBean add,HttpServletRequest request){
		String strInfo = "用户更新失败。";
		try {			
			if(userService.update(add)){
				strInfo = "更新用户成功。";
				request.setAttribute("InfoMessage", strInfo);
			}
		} catch (Exception e) {
			log4j.error("删除用户数据失败"+e);
			request.setAttribute("InfoMessage", strInfo);
		} finally {			
			return "result";
		}
	}

}
