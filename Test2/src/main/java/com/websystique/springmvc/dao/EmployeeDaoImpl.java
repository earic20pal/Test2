package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TcDesc;
import com.websystique.springmvc.model.TcStatus;

@Repository("employeeDao123")
public class EmployeeDaoImpl extends AbstractDao<Integer, TcDesc> implements EmployeeDao {

	

	@SuppressWarnings("unchecked")
	public List<TcDesc> findAllTcDesc() {
		Criteria criteria = createEntityCriteria();
		return (List<TcDesc>) criteria.list();
	}

	public List<Date> findAllDatesTCRun() {
		Criteria crit= getSession().createCriteria(TcStatus.class);
		List<TcStatus> list= crit.list();
		Set<Date> set= new LinkedHashSet<Date>();
		for(TcStatus obj: list) {
			set.add(obj.getDate());
		}
		 List<Date> li= new ArrayList<Date>(set);
		return li;
	}

	public List<String> findAllTestCaseIds(String Module) {
		Criteria crit= getSession().createCriteria(TcStatus.class).add(Restrictions.eq("module", Module));
		crit.setMaxResults(10);
		List<TcStatus> list= crit.list();
		Set<String> set= new LinkedHashSet<String>();
		for(TcStatus obj: list) {
			set.add(obj.getTcDesc().getTcId());
		}
		 List<String> li= new ArrayList<String>(set);
		return li;
	}

	public String getResultOfTCIDs(String tcid, Date date) {
		String str = null;
		Criteria crit= getSession().createCriteria(TcStatus.class).createAlias("tcDesc", "t").add(Restrictions.eq("t.tcId", tcid));
		crit=crit.add(Restrictions.eq("date", date));
		List<TcStatus> list= crit.list();
		for(TcStatus obj: list) {
			str=obj.getStatus();
		}
		if(str==null)
		{
			str="N/A";
		}
		return str;
	}

	public List<String> getAllModule() {
		Criteria crit= getSession().createCriteria(TcStatus.class);
		ProjectionList proj= Projections.projectionList();
		proj.add(Projections.distinct(Projections.property("module")));
		crit.setProjection(proj);
		List<String> rsList = crit.list();
		return rsList;
	}

	public Collection<? extends String> getTcidsForSelectedModule(String module) {
		Criteria crit= getSession().createCriteria(TcStatus.class).add(Restrictions.eq("module", module));
		ProjectionList proj= Projections.projectionList();
		proj.add(Projections.distinct(Projections.property("tcDesc.tcId")));
		crit.setProjection(proj);
		List<String> rsList = crit.list();
		return rsList;
	}

	
}
