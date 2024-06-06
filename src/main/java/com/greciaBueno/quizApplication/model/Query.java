package com.greciaBueno.quizApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
 	This Query class is an entity that maps to the question table in 
 	the database.  It uses lombok to generate boilerplate code and jackson
 	to specify the JSON property name.  Each field corresponds to one 
 	column in the question table.
 */

@Data
@Entity
@Table(name = "question")
public class Query {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;
    
    @Column(name = "type")
    @JsonProperty("type")
    private String type;
    
    @Column(name = "question_title")
    @JsonProperty("questionTitle")
    private String questionTitle;
    
    @Column(name = "answer1")
    @JsonProperty("answer1")
    private String question1;
    
    @Column(name = "answer2")
    @JsonProperty("answer2")
    private String question2;
    
    @Column(name = "answer3")
    @JsonProperty("answer3")
    private String question3;
    
    @Column(name = "answer4")
    @JsonProperty("answer4")
    private String question4;
    
    @Column(name = "right_answer")
    @JsonProperty("rightAnswer")
    private String rightAnswer;
    
    @Column(name = "difficultylevel")
    @JsonProperty("difficultylevel")
    private String difficultylevel;
    
}
