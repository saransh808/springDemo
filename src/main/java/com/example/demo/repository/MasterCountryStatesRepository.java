package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MasterCountryStates;

@Repository
public interface MasterCountryStatesRepository extends JpaRepository<MasterCountryStates, Integer>{
	public Page<MasterCountryStates> findAll(Pageable pageable);
}
