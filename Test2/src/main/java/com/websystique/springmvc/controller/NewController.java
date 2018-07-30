package com.websystique.springmvc.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.service.EmployeeService;


@RestController
@RequestMapping("/")
public class NewController {
	 @Autowired
	 EmployeeService service;
	 
	 @RequestMapping(value = "getTCForSelectedModule", method = RequestMethod.POST)
		public @ResponseBody List<String> getTCForSelectedModule(@RequestParam(value = "module", required = true) String module) {
		System.out.print("in get tcids method with ModuleName : "+module);
		List<String> cityList = new ArrayList<String>();
		cityList.add("hello");
		//		//This way seems to be more dynamic for me no need to update the class if we add new state
//		cityList.addAll(service.getTcidsForSelectedModule(module));
		System.out.println(cityList);
		return cityList;
		
	}
}
