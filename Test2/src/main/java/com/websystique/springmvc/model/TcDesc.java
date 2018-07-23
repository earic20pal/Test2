package com.websystique.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tc_desc database table.
 * 
 */
@Entity
@Table(name="tc_desc")
@NamedQuery(name="TcDesc.findAll", query="SELECT t FROM TcDesc t")
public class TcDesc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TC_ID")
	private String tcId;

	private String description;

	//bi-directional many-to-one association to TcStatus
	@OneToMany(mappedBy="tcDesc")
	private List<TcStatus> tcStatuses;

	public TcDesc() {
	}

	public String getTcId() {
		return this.tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TcStatus> getTcStatuses() {
		return this.tcStatuses;
	}

	public void setTcStatuses(List<TcStatus> tcStatuses) {
		this.tcStatuses = tcStatuses;
	}

	public TcStatus addTcStatus(TcStatus tcStatus) {
		getTcStatuses().add(tcStatus);
		tcStatus.setTcDesc(this);

		return tcStatus;
	}

	public TcStatus removeTcStatus(TcStatus tcStatus) {
		getTcStatuses().remove(tcStatus);
		tcStatus.setTcDesc(null);

		return tcStatus;
	}

}