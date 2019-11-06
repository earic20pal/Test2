package com.mycompany.springmvc.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvc.dao.EmployeeDao;
import com.mycompany.springmvc.model.TcDesc;
import com.mycompany.springmvc.model.TcStatus;

@Service("employeeServices")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	
	public List<TcDesc> findAllEmployees() {
		return dao.findAllTcDesc();
	}


	public List<Date> getAllSortedDates() {
		return dao.findAllDatesTCRun();
	}


	public List<String> getAllTestCaseIds(String Module) {
		return dao.findAllTestCaseIds(Module);
	}


	

	public String getResultOfTestCaseID(String tcid, Date date) {
		return dao.getResultOfTCIDs(tcid,date);
	}


	public List<String> getAllModule() {
		return dao.getAllModule();
	}


	public Collection<? extends String> getTcidsForSelectedModule(String module) {
		return dao.getTcidsForSelectedModule(module);
	}

	
	
}
