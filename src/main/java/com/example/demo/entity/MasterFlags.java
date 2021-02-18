package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
//@RedisHash("MasterFlags")
@Table(name = "MASTER_FLAGS", schema = "sorion")
public class MasterFlags implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "I_FLAG_ID")
	private Integer flagId;

	@Column(name = "S_FLAG_NAME")
	private String flagName;

	@Column(name = "S_FLAG_DESC")
	private String flagDescripton;

}
