package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MasterFlags;

@Repository
public interface MasterFlagsRepository extends CrudRepository<MasterFlags, Integer>{
	
	

}
