package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class control {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String str() {
		return "first";
	}
	
	@GetMapping("/meditation")
	public String med() {
		return "meditation";
	}
	
}
