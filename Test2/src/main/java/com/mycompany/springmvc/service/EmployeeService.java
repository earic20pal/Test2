package com.mycompany.springmvc.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.mycompany.springmvc.model.TcDesc;
import com.mycompany.springmvc.model.TcStatus;

public interface EmployeeService {


	List<TcDesc> findAllEmployees();

	List<Date> getAllSortedDates();

	List<String> getAllTestCaseIds(String Module);

	String getResultOfTestCaseID(String tcid, Date date);

	List<String> getAllModule();

	Collection<? extends String> getTcidsForSelectedModule(String module); 
	
	
}
