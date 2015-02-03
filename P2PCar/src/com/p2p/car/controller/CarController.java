package com.p2p.car.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.p2p.car.model.CarBean;
import com.p2p.car.service.CarService;

@Controller
public class CarController {
	static Logger log4j = Logger.getLogger(CarController.class.getClass());
	private CarService carService;

	public CarService getCarService() {
		return carService;
	}
	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	@SuppressWarnings("finally")
	@RequestMapping("addCar")
	public String addCar(CarBean car,HttpServletRequest request){
		String strInfo = "添加失败。";
		try {			
			car.setCarId(UUID.randomUUID().toString());
			log4j.info(car.getCarName() + ":::::" + car.getCarGearboxes());
			if(carService.addInfo(car)){
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
	
	@RequestMapping("getAllCar")
	public String getAllCar(HttpServletRequest request){
		String userId = request.getParameter("userId");
		try {			
			List<CarBean> list = carService.getAllCar(userId);
			log4j.info(list);
			request.setAttribute("userId", userId);
			request.setAttribute("addLists", list);
			return "listAllCar";
		} catch (Exception e) {
			log4j.error("获取用户数据失败"+e);
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}
	@RequestMapping("addNewCar")
	public String addNewCar(HttpServletRequest request){
		String userId = request.getParameter("userId");
		if(userId==null||userId.equals("")){
			request.setAttribute("InfoMessage", "请先登陆");
			return "result";
		}
		request.setAttribute("userId", userId);
		return "addCar";
	}
	
	
	
	
	
	@SuppressWarnings("finally")
	@RequestMapping("deleteCar")
	public String deleteCar(String tid,HttpServletRequest request){
		String strInfo = "用户删除失败。";
		try {			
			if(carService.delete(tid)){
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
	@RequestMapping("modifyCar")
	public String modifyCar(String tid,HttpServletRequest request){
		try {			
			CarBean car = carService.findById(tid);
			request.setAttribute("car", car);
			return "modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("updateCar")
	public String updateCar(CarBean car,HttpServletRequest request){
		String strInfo = "用户更新失败。";
		try {			
			if(carService.update(car)){
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
