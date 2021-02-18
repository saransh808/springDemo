package com.example.demo.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MasterFlags;
import com.example.demo.repository.MasterFlagsRepository;
import com.example.demo.response.DataExceptionMessages;
import com.example.demo.response.DbConstraints;

@Service
@Transactional
//@CacheConfig(cacheNames="MasterFlagServiceCache")
public class MasterFlagServiceImpl {

	@Autowired
	private MasterFlagsRepository masterFlagsRepository;
	
	
	DataExceptionMessages dataExceptionMessages;
	DbConstraints dbConstraints;
	
	
	public List<MasterFlags> findAll(){
		return (List<MasterFlags>) masterFlagsRepository.findAll();
	}


	public MasterFlags create(MasterFlags masterFlag) throws Exception{
		if(masterFlag.getFlagName().contains(" "))
			throw new Exception("Flag name can not have space");
		List<MasterFlags> flags = (List<MasterFlags>) masterFlagsRepository.findAll();
		boolean unique = true;
		for(MasterFlags flag : flags)
			if(flag.getFlagName().equalsIgnoreCase(masterFlag.getFlagName())) unique=false;
		if(unique) masterFlagsRepository.save(masterFlag);
		else throw new ConstraintViolationException(dataExceptionMessages.DUPLICATE_DATA_FOUND,  new SQLException("UNIQUE KEY"), null);
		return masterFlag;
	}
}
