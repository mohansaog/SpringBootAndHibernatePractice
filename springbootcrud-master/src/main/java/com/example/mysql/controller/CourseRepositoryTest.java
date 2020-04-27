package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.dao.CourseSpringDataRepository;
import com.example.mysql.dao.SampleSpringDataRepository;
import com.example.mysql.model.Course;
import com.example.mysql.model.Sample;


@RestController
@CrossOrigin
@Transactional
@RequestMapping(value = "/test")
public class CourseRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);

	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Autowired
	SampleSpringDataRepository repo;
	
	@GetMapping("/findbyid")
	public Optional<Course> findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		logger.info("outputhai -> {}",courseOptional);
		return courseOptional;
	}
	
	@GetMapping("/findbyid1")
	public Optional<Course> findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(2001L);
		if(!courseOptional.isPresent())
			logger.info("khali hai chacha");
		logger.info("outputhai -> {}",courseOptional);
		return courseOptional;
	}
	
	@GetMapping("/findbyid2")
	public List<Sample> PlayWithSpringDataRepository() {
		repo.save(new Sample("mohan book"));
		List<Sample> pm = repo.findAll();
		logger.info("All Data -> {}",repo.findAll());
		logger.info("Count  -> {}",repo.count());
		return pm;
	}
	
	//sorting
	@GetMapping("/findbyid3")
	public void sorted_order() {
		//Sort sort = new Sort(Sort.Direction.DESC,"name");
		logger.info("{}",repo.findAll());
	}
	
	//paging using spring data JPA repository
	@GetMapping("/findbyid4")
	public void paggination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Sample> firstPage = repo.findAll(pageRequest);
		logger.info("first page -> {}",firstPage);
		logger.info("first page content -> {}",firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Sample> secondPage = repo.findAll(secondPageable);
		logger.info("second page -> {}",secondPage.getContent());
	}
	
	@GetMapping("/findbyid5")
	public List<Sample> findByName() {
		List<Sample> pm = repo.findByName("mohan book");
		return pm;
	}
	
}
