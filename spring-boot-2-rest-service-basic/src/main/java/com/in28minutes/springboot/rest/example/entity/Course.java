package com.in28minutes.springboot.rest.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;

//TODO	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id")
//	private Student student;

	public Course() {
		super();
	}
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
