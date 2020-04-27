package com.example.mysql.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries (
		value = { 
@NamedQuery(name = "find_all_course", query = "select c from Course c"),
@NamedQuery(name = "get_specific_course_name", query = "select c from Course c where name='murhi'")
		}
)

@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "courses")//non=owning side
	private List<Student> students = new ArrayList<Student>();
	
	
	private String name;
	
	protected Course() {}
	
	public Course (String name) {
		this.name = name;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}
	
	public void removeStudents(Student student) {
		this.students.remove(student);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
