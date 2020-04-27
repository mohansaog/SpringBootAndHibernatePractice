package com.example.mysql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.mysql.model.PrevEmployee;

@Repository
@Transactional
public class EmployeeJpaRepository {

	@PersistenceContext
	EntityManager em;
	
	public List<PrevEmployee> findAllEmployee() {
		TypedQuery<PrevEmployee> namedQuery = em.createNamedQuery("find_all_employee",PrevEmployee.class);
		return namedQuery.getResultList();
	}
	
	public PrevEmployee findById(Integer id) {
		return em.find(PrevEmployee.class, id);
	}
	
	public void update(PrevEmployee emp) {
		em.merge(emp);
	}
	
	public void deleteById(Integer id) {
		PrevEmployee emp = findById(id);
		em.remove(emp);
	}
}
