package com.greciaBueno.quizApplication.model;

import lombok.Data;

/*
 	This QuestionWrapper class is used to represent a question with 
 	//multiple answer options.  It uses lombok to create boilerplate code
 	and contains fields for question, ID, and four answer options.
 	Omitting the correct answer.
 */

@Data
public class QuestionWrapper {


	private Integer id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	//constructor intilizes these fields
	public QuestionWrapper(Integer id, String questionTitle, String option1, String option2,
			String option3, String option4) {
		this.id = id;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	
	
	
	
}

