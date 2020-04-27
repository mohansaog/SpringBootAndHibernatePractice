package com.example.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mysql.model.Course;
import com.example.mysql.model.Student;

@Repository
@Transactional
public class MappingRepository_M2M {
	
	private static final Logger logger = LoggerFactory.getLogger(MappingRepository.class);
	
	@Autowired
	EntityManager em;

	public void insert_student(Student student) {
		em.persist(student);
	}
	
	public void insert_course(Course course) {
		em.persist(course);
	}
	
	public void retrieve_student_and_course() {
		Student student = em.find(Student.class, 2001L);
		logger.info("output is ->{}",student.getCourses());
	}
	
	public void insert_student_and_course() {
		Student student = new Student("suresh");
		Course course = new Course("c++ course");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudents(student);
		
		em.persist(student);
	}

	public List<Course> getDtailsWithoutStudents() {
	TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty",Course.class);
	return query.getResultList();
	}

	
	  public List<Course> getDtailsatleast2Students() 
	  { 
		  TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		  List<Course> resultList = query.getResultList(); 
		  logger.info("outputhai-> {}",resultList);
		  return resultList;
	  }
	  
	  public List<Student> get_passport_By_pattern() 
	  { 
		  TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%123%'", Student.class);
		  List<Student> resultList = query.getResultList();
		  return resultList;
	  }
	  
	  public void join() 
	  { 
		  Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		  List<Object[]> resultList = query.getResultList();
		  for(Object[] obj : resultList) {
			  logger.info("course {} : student{}",obj[0],obj[1]);
		  }
	  }
	  
	  public void cross_join() 
	  { 
		  Query query = em.createQuery("Select c, s from Course c, Student s");
		  List<Object[]> resultList = query.getResultList();
		  for(Object[] obj : resultList) {
			  logger.info("course {} : student{}",obj[0],obj[1]);
		  }
	  }
	 
}