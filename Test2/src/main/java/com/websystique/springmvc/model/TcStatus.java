package com.websystique.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tc_status database table.
 * 
 */
@Entity
@Table(name="tc_status")
@NamedQuery(name="TcStatus.findAll", query="SELECT t FROM TcStatus t")
public class TcStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String module;

	private String status;

	private String time;

	//bi-directional many-to-one association to TcDesc
	@ManyToOne
	@JoinColumn(name="TC_ID")
	private TcDesc tcDesc;

	public TcStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TcDesc getTcDesc() {
		return this.tcDesc;
	}

	public void setTcDesc(TcDesc tcDesc) {
		this.tcDesc = tcDesc;
	}

}