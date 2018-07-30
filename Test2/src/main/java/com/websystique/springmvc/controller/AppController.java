package com.websystique.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.model.TcDesc;
import com.websystique.springmvc.model.TcStatus;
import com.websystique.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 * public String listEmployees(@RequestParam("module") String Module,ModelMap model) {
	 */
	@RequestMapping(value = {  "/list" }, method = RequestMethod.POST)
	public String listEmployees(@RequestParam(value = "module", required = true) String Module,ModelMap model) {
		System.out.println("Module name is "+Module);
		List<Date> dates = service.getAllSortedDates();
		List<String> tcids=service.getAllTestCaseIds(Module);
		List<List<String>> result=new LinkedList<List<String>>();
		
		Iterator itr=tcids.iterator();
		while(itr.hasNext())
		{
			List<String> ls= new LinkedList<String>();
			String tcid=(String) itr.next();
			ls.add(tcid);
			for(Date date:dates)
			{
				String str=service.getResultOfTestCaseID(tcid,date);
				ls.add(str);
				
			}
			result.add(ls);
		}
		
		model.addAttribute("TCIDs", tcids);
		model.addAttribute("employees", dates);
		model.addAttribute("results", result);
		return "index";
	}
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String HomePage(ModelMap model) {
		List<String> tcids=service.getAllModule();
		model.addAttribute("listCategory", tcids);
		return "registration";
	}
	
}
