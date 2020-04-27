package com.example.mysql.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.dao.MappingRepository;
import com.example.mysql.dao.MappingRepository_M2M;
import com.example.mysql.model.Course;
import com.example.mysql.model.Passport;
import com.example.mysql.model.Review;
import com.example.mysql.model.Student;

@RestController
@CrossOrigin
@Transactional
@RequestMapping(value = "/mapping")
public class MappingController {
	
	//Below section is use for @OneToOne mapping 
		@Autowired
		MappingRepository service;
		
		@Autowired
		MappingRepository_M2M service1;
		
		@PostMapping("/newPassport")
		public String createPassport(@RequestBody Passport passport) {
		    service.addPassport(passport);
			return "passport added successfully";
		}
		
		@PostMapping("/newStudent")
		public String createStudent(@RequestBody Student student) {
			service.addStudent(student);
			return "student added successfully";
		}

		@PostMapping("/newCourse")
		public String createCourse(@RequestBody Course course) {
			service.addCourse(course);
			return "student added successfully";
		}
		
		@GetMapping("/getalldetails")
		public List<Student> getAllDtails(){
			return service.get_details();
		}
		
		@GetMapping("/getdetailsbyid")
		public void getDetailById(){
			service.getDetailById();
		}
		
		@GetMapping("/playwithonetoone")
		public String playWithOneToOne(){
			 service.letsPlay();
			 return "well played OneToOne";
		}
		
		@PostMapping("/newReview")
		public String createReview(@RequestBody Review review) throws Exception{
			service.addReview(review);
			return "student added successfully";
		}
		
		@GetMapping("/playwithonetomany")
		public String playWithOneToMany(){
			 service.letsPlay1();
			 return "well played OneToMany&ManyToOne";
		}
		
		@PostMapping("/playwithonetomany1/{id}")
		public String playWithOneToManyGeneralise( @RequestBody List<Review> reviews,@PathVariable Long id){
			 service.letsPlay2(id,reviews);
			 return "well played OneToMany&ManyToOne in Generalised form";
		}
		
		@PostMapping("/manytomanyinsert1")
		public String manyToManyInsertS( @RequestBody Student student){
			 service1.insert_student(student);
			 return "Student added";
		}
		
		@PostMapping("/manytomanyinsert2")
		public String manyToManyInsertC( @RequestBody Course course){
			 service1.insert_course(course);
			 return "Student added";
		}
		
		@GetMapping("/getmamytomanydata")
		public String retrieve_student(){
			 service1.retrieve_student_and_course();
			 return "yup";
		}
		
		@GetMapping("/insertmanytomany")
		public String insert_ManyToMany(){
			 service1.insert_student_and_course();
			 return "insrted";
		}
		
		@GetMapping("/getdetailswithoutstudents")
		public List<Course> get_details_without_student_from_course(){
			 return service1.getDtailsWithoutStudents();
		}
		
	  @GetMapping("/getcoursedetailsatleast2students") 
	  public List<Course> get_details_atleast_2_student_from_course() { 
		  return service1.getDtailsatleast2Students(); 
	}
	  
	  @GetMapping("/getpassportfromstudentbtpattern") 
	  public List<Student> getPassportFromStutntUsngPattern() { 
		  return service1.get_passport_By_pattern(); 
	}
	 
	  @GetMapping("/getdetailsofcourseandstudent") 
	  public void getdetailsofcourseandstudent() { 
		   service1.cross_join(); 
	}  
		
}
