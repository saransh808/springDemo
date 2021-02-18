package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MASTER_COUNTRY_STATES", schema = "sorion")
public class MasterCountryStates implements Serializable{

	@Id
	@Column(name = "I_STATE")
	private Integer stateId;

	@Column(name = "S_COUNTRY")
	private String countryName;

	@Column(name = "S_STATE")
	private String stateName;

	@Column(name = "B_CAPITAL")
	private boolean capital;

	@Column(name = "B_OTHER_SPECIAL")
	private boolean otherSpecial;
}
