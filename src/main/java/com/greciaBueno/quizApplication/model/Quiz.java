package com.greciaBueno.quizApplication.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Table;
import lombok.Data;

/*
 	The quiz class is an entity that maps to a database table using
 	the annotation @Entity.  
 */

@Entity
@Data
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	//This is a unidirectional many to many relationship between Quiz and Query.  
	//Each quiz can have multiple Query objects and each Query can 
	//belong to multiple quiz objects.  Only the Quiz entity needs to know about the 
	//Query entities it is related to.  The Query entity does not need to be aware
	//of the Quiz entities it is part of.
	@ManyToMany
	private List<Query> questions;
	
}

