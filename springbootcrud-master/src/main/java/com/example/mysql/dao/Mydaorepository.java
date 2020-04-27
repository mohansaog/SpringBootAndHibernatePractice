package com.example.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.model.PrevEmployee;

public interface Mydaorepository extends JpaRepository<PrevEmployee, Integer> {

}
