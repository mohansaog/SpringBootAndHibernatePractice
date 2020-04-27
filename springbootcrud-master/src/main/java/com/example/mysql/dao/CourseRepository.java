package com.example.mysql.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mysql.model.Course;


@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void save(Course course) {
			em.persist(course);
		}
	
	public List<?> create_query() {
		TypedQuery<?> namedQuery = em.createNamedQuery("get_specific_course_name",Course.class);
		return namedQuery.getResultList();
	}
	
	
	public List<?> native_query_with_parameter() {
		Query query = em.createNativeQuery("select * from course where id=?");
		query.setParameter(1, 5);
		return query.getResultList();
	}

	public List<?> native_query_with_parameter_1() {
		Query query = em.createNativeQuery("select * from course where id=:id");
		query.setParameter("id", 6);
		return query.getResultList();
	}
	
	public List<?> native_query_with_parameter_2(int id) {
		Query query = em.createNativeQuery("select * from course where id=:id");
		query.setParameter("id", id);
		return query.getResultList();
	}
}