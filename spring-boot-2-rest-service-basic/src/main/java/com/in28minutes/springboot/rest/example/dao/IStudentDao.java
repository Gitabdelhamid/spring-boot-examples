package com.in28minutes.springboot.rest.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.rest.example.entity.Student;

@Repository
public interface IStudentDao extends JpaRepository<Student, Long>{

}
