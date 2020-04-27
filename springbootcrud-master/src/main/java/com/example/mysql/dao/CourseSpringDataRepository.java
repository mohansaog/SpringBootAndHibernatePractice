package com.example.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.mysql.model.Course;
import com.example.mysql.model.Sample;
@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

	List<Sample> findByName(String name);
	
	List<Sample> findByNameAndId(Long id,String name);
}
