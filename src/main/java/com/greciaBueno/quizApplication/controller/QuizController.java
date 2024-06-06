package com.greciaBueno.quizApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.greciaBueno.quizApplication.model.QuestionWrapper;
import com.greciaBueno.quizApplication.model.Response;
import com.greciaBueno.quizApplication.service.QuizService;

/*
 	The QuizController is a RESTful web service controller.  It will return data
 	directly as JSON.  It has 3 endpoints which retrieve quiz questions by ID, 
 	submit responses to calculate quiz results, and requests to create quizzes.
 */

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	//Automatic dependecy injection
	@Autowired
	QuizService quizService;
	
	//This method takes 3 request parameters and returns a ResponseEntity containing
	//a string message indicating success or failure.  The category, numQ, and title
	//should be bound to the corresponding query parameters in the request URL.
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
		
		return quizService.createQuiz(category, numQ, title);
		
	}
	
	//The {id} part is a path variable that will be passed to the method.  it returns 
	//a ResponseEntity containing a list of QuestionWrapper objects that will represent
	//the questions of the quiz.
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
		
		return quizService.getQuizQuestions(id);
		
	}
	
	//This method takes an id path variable and a list of Response objects in the request
	//body, and returns a ResponseEntity containing an integer representaing the calculated 
	//result of the quiz.  The @ResquestBody annotation indicates that the responses parameter
	//should be bound to the body of the HTTP request in a JSON representation.
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
		return quizService.calculateResult(id, responses);
	}
	
	

}

