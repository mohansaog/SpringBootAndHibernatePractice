package com.example.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mysql.model.Course;
import com.example.mysql.model.Passport;
import com.example.mysql.model.Review;
import com.example.mysql.model.Student;

@Repository
@Transactional
public class MappingRepository {

	private static final Logger logger = LoggerFactory.getLogger(MappingRepository.class);

	@Autowired
	EntityManager em;

	public void addPassport(Passport passport) {
		em.persist(passport);
	}

	public void addStudent(Student student) {
		em.persist(student);
	}

	public void addReview(Review review) {
		em.persist(review);
	}

	public void addCourse(Course course) {
		em.persist(course);
	}

	public List<Student> get_details() {
		TypedQuery<Student> nameQuery = em.createQuery("select p from Student p", Student.class);
		return nameQuery.getResultList();
	}

	public void letsPlay() {
		/*
		 * Passport passport = new Passport("P123456"); em.persist(passport);
		 * 
		 * Student student = new Student("Mike"); student.setPassport(passport);
		 * 
		 * em.persist(student);
		 */}

	@Transactional
	public void getDetailById() {
		/*
		 * Passport passport = em.find(Passport.class, 10L);
		 * logger.info("outputhai--->{}", passport); logger.info("outputhai--->{}",
		 * passport.getStudent());
		 */}

	public void letsPlay1() {
		/*
		 * // get the course Course course = em.find(Course.class, 10003L);
		 * 
		 * // Add 2 review to it Review review1 = new Review("5", "ohh nice"); Review
		 * review2 = new Review("3", "ohh wow");
		 * 
		 * // Setting up relationship course.addReviews(review1);
		 * review1.setCourse(course);
		 * 
		 * course.addReviews(review2); review2.setCourse(course); ;
		 * 
		 * // save into Database em.persist(review1); em.persist(review2);
		 * 
		 */}

	public void letsPlay2(Long id, List<Review> reviews) {
		/*
		 * Course course = em.find(Course.class, id); for (Review review : reviews) {
		 * course.addReviews(review); review.setCourse(course); em.persist(review); }
		 */}
}
