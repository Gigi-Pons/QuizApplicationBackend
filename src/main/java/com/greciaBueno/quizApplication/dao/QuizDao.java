package com.greciaBueno.quizApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greciaBueno.quizApplication.model.Quiz;

//The QuizDao is a repository interface that extends JpaRepository 
//to provide CRUD operations for the Quiz entity.
//It automatically inherets methods from JpaRepository to perform 
//database operations without needing to implement them.
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
