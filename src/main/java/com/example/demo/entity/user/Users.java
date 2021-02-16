package com.example.demo.entity.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USERS", schema="sorion")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="I_USER_ID")
	private Integer userIdPk;
	
	@Column(name="S_USER_FIRST_NAME")
	private String userFirstName;
	
	@Column(name="S_USER_LAST_NAME")
	private String userLastName;
	
	@Column(name="S_USER_MIDDLE_NAME")
	private String userMiddleName;
	
	@Column(name="S_EMAIL")
	private String email;
	
	@Column(name="T_DATE_OF_BIRTH")
	private String dateOfBirth;
	
//	@Column(name="I_LOGON_ADD")
//	private Integer logonAdd;
//	
//	@Column(name="I_LOGON_UPD")
//	private Integer logonUpd;
	
	@Column(name="T_TIMESTAMP_ADD")
	private LocalDateTime timeStmpAdd;
	
	@Column(name="T_TIMESTAMP_UPD")
	private LocalDateTime timeStmpUpd;
}
