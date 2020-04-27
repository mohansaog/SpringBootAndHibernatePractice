package com.example.mysql.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.dao.Mydaorepository;
import com.example.mysql.model.PrevEmployee;

@Service
public class Myserviceimpl {
	@Autowired
    Mydaorepository dao;
	
    public PrevEmployee addNewEmployee(PrevEmployee emp) {
        return dao.save(emp);
    }

    public List<PrevEmployee> getAllEmployee() {
    	return dao.findAll();
    }
    
    public Optional<PrevEmployee> getEmployeeById(Integer id) {
    	return dao.findById(id);
    }
    
    public PrevEmployee updateEmployee(PrevEmployee emp) {
    	return dao.save(emp);
    }
    
    public void deleteById(Integer id) {
    	dao.deleteById(id);
    }
}
