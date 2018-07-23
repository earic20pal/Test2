package com.websystique.springmvc.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.websystique.springmvc.model.TcDesc;
import com.websystique.springmvc.model.TcStatus;

public interface EmployeeDao {

	List<TcDesc> findAllTcDesc();

	List<Date> findAllDatesTCRun();

	List<String> findAllTestCaseIds(String Module);

	String getResultOfTCIDs(String tcid, Date date);

	List<String> getAllModule();

	Collection<? extends String> getTcidsForSelectedModule(String module);
}
