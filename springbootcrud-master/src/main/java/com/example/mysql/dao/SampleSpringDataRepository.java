package com.example.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.model.Sample;
public interface SampleSpringDataRepository extends JpaRepository<Sample, Long> {

	List<Sample> findByName(String name);
	
	List<Sample> findByNameAndId(Long id,String name);
	
	List<Sample> countByName(String name);
	
}
