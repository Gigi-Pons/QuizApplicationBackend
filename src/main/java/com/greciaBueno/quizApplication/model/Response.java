package com.greciaBueno.quizApplication.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//This Response class is a simple data holder with only 
//two fields.

@Data
@RequiredArgsConstructor
public class Response {
	
	private Integer id;
	private String response;

}
