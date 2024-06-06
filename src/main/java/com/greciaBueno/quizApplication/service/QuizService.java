package com.greciaBueno.quizApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.greciaBueno.quizApplication.dao.QueryDao;
import com.greciaBueno.quizApplication.dao.QuizDao;
import com.greciaBueno.quizApplication.model.Query;
import com.greciaBueno.quizApplication.model.QuestionWrapper;
import com.greciaBueno.quizApplication.model.Quiz;
import com.greciaBueno.quizApplication.model.Response;

/*
 	The QuizService class allows us to interact with the database
 	for Quiz objects.  Some of the methods that includes are to 
 	create a new quiz, retrieve questions of a quiz by its ID, and 
 	calculate the result of a quiz based on the responses submited.
 */

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QueryDao questionDao;

	//This method will create a new Quiz object, sets its title and questions
	//and save it to the database using quizDao.  It does this by retrieving a list of
	//random queries of the specified type (category) and number (numQ) as well as 
	//assigning it a title
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Query> questions = questionDao.findRandomQueriesByType(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	//getQuizQuestions will retrieve the questions of a specific quiz id by providig
	//the ID number.  Once if finds the quiz, it gets the list of questions associated
	//with the quiz
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Query> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Query q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getQuestion1(), q.getQuestion2(), q.getQuestion3(), q.getQuestion4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	//the user provides the id and responses and it calculates the result of a quiz
	//based on the responses.  It will find the quiz by its ID.
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Query> questions = quiz.get().getQuestions();
		int right = 0;
		int i = 0;
		
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			
			i++;
		}
		
		return new ResponseEntity<>(right, HttpStatus.OK);
		
	}
	
	
}
