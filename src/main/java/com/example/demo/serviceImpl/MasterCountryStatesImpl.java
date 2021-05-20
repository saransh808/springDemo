package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.MasterCountryStates;
import com.example.demo.repository.MasterCountryStatesRepository;

@Service
@Transactional
public class MasterCountryStatesImpl {
	
	@Autowired
	private MasterCountryStatesRepository masterCountryStatesReposritory;
	
	
	@Cacheable(value="state-cache-All", key="'AllState'")
	public List<MasterCountryStates> findAll(){
		return masterCountryStatesReposritory.findAll();
	}
	
	public List<MasterCountryStates> findAllPaged(Integer pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, 10);
		Page<MasterCountryStates> page = masterCountryStatesReposritory.findAll(pageable);
		return page.toList();
	}
	
	
	@Cacheable(value="state-cache", key="'stateId'+#stateId")
	public Optional<MasterCountryStates> findById(Integer stateId){
		return masterCountryStatesReposritory.findById(stateId);
		
	}
	

}
