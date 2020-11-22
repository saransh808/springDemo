package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MASTER_FLAGS", schema="sorion")
public class MasterFlags {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="I_FLAG_ID")
	private Integer flagId;
	
	@Column(name="S_FLAG_NAME")
	private String flagName;		
	
	@Column(name="S_FLAG_DESC")
	private String flagDescripton;

	public Integer getFlagId() {
		return flagId;
	}

	public void setFlagId(Integer flagId) {
		this.flagId = flagId;
	}

	public String getFlagName() {
		return flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public String getFlagDescripton() {
		return flagDescripton;
	}

	public void setFlagDescripton(String flagDescripton) {
		this.flagDescripton = flagDescripton;
	}

	public MasterFlags(Integer flagId, String flagName, String flagDescripton) {
		super();
		this.flagId = flagId;
		this.flagName = flagName;
		this.flagDescripton = flagDescripton;
	}

	@Override
	public String toString() {
		return "MasterFlags [flagId=" + flagId + ", flagName=" + flagName + ", flagDescripton=" + flagDescripton + "]\n";
	}
	
	
	public MasterFlags() {
		super();
	}
}
