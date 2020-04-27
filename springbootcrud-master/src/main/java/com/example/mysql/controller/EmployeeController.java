package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.dao.CourseRepository;
import com.example.mysql.dao.EmployeeJpaRepository;
import com.example.mysql.model.Course;
import com.example.mysql.model.PrevEmployee;
import com.example.mysql.serviceImpl.Myserviceimpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private Myserviceimpl service;
	
	@Autowired
	EmployeeJpaRepository service1;
	
	@Autowired
	CourseRepository service2;

	@PostMapping("/newEmployee")
	public String createEmployee(@RequestBody PrevEmployee newemp) {
		//service.addNewEmployee(newemp);
		service1.update(newemp);
		return "added successfully";
	}
	
	@PostMapping("/newCourse")
	public String createCourse(@RequestBody Course course) {
		//service.addNewEmployee(newemp);
		service2.save(course);
		return "added successfully";
	}

	@GetMapping("/allEmployee")
	public List<PrevEmployee> getAllEmpoyee() {
		return service1.findAllEmployee();
	}

	@GetMapping("/getEmployee/{id}")
	public PrevEmployee getEmployee(@PathVariable Integer id) throws Exception {
		PrevEmployee em = service1.findById(id);
		return em;
	}
	
	@GetMapping("/getCourse/{id}")
	public Course getCourse(@PathVariable Long id) throws Exception {
		Course course = service2.findById(id);
		return course;
	}

	@PutMapping("/getUpdate/{id}")
	public String getUpdate(@RequestBody PrevEmployee emp, @PathVariable Integer id) throws Exception {
		Optional<PrevEmployee> empop = service.getEmployeeById(id);
		if (!empop.isPresent()) {
			throw new Exception("not found in database");
		}
		if (emp.getEname() == null || emp.getEname().isEmpty()) {
			emp.setEname(empop.get().getEname());
		}
		if (emp.getDepartment() == null || emp.getDepartment().isEmpty()) {
			emp.setDepartment(empop.get().getDepartment());
		}
		if (emp.getSalary() == 0) {
			emp.setSalary(empop.get().getSalary());
		}
		emp.setId(id);
		service.updateEmployee(emp);
		return "updated successfully";
	} 

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) throws Exception {
		Optional<PrevEmployee> emp = service.getEmployeeById(id);
		if (!emp.isPresent())
			throw new Exception("id not present");
		service.deleteById(id);
		return "delete successfully"; 
	}
	
	@DeleteMapping("/deleteEmployee1/{id}")
	public String deleteEmployeeById1(@PathVariable Integer id) throws Exception {
		service1.deleteById(id);
		return "delete successfully"; 
	}
	
	@GetMapping("/getallcourse")
	public List<?> getAllCourse() {
		return service2.create_query();
	}
	
	@GetMapping("/getallcourse1")
	public List<?> getAllCourse1() {
		return service2.native_query_with_parameter_1();
	}
	
	@GetMapping("/getallcourse2")
	public List<?> getAllCourse2() {
		int id = 3;
		return service2.native_query_with_parameter_2(id);
	}
	
	
	
	
}
