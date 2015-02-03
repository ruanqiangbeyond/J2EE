package com.isfotstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("message", "hell spring mvc");
		mv.setViewName("hello");
		return mv;
	}	
}
