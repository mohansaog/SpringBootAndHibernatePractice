package com.example.mysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	protected Sample() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Sample [id=%s, name=%s]", id, name);
	}

	public Sample(String name) {
		super();
		this.name = name;
	}
	
}
