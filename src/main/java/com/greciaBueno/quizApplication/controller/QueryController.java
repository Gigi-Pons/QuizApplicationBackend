package com.greciaBueno.quizApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greciaBueno.quizApplication.model.Query;
import com.greciaBueno.quizApplication.service.QueryService;

/*
	This is a Spring Boot REST controller named QueryController.  It handles
	HTTP requests for managing query/questions entities.  The class is a RESTful 
	web service controller.  It will return data directly as JSON.  The base 
	URL for all endpoints in this controller will be /queries.
 */


@RestController
@RequestMapping("queries")
public class QueryController {

	//Automatic dependency injection
    @Autowired
    QueryService queryService;

    //Returns ResponseEntity containing a list of Query objects by calling the
    //getAllQueries method of the queryService.  The service method fetches all 
    //queries from the database.
    @GetMapping("allQueries") 
    public ResponseEntity<List<Query>> getAllQueries() {
        return queryService.getAllQueries();
    }

    //This method takes a {type} path variable and returns a ResponseEntity 
    //containing a list of Query objects that match the specified type.
    //The type parameter should be bound to the type path variable from the URL.
    @GetMapping("type/{type}")
    public ResponseEntity<List<Query>> getQueriesByType(@PathVariable String type) {
        return queryService.getQueriesByType(type);
    }

    //This method takes a query object in the request body, which should contain
    //a JSON representation of a Query object.  It then returns a ResponseEntity
    //containing a string message indicating success or failure
    @PostMapping("create")
    public ResponseEntity<String> createQuery(@RequestBody Query query) {
        return queryService.createQuery(query);
    }

}
