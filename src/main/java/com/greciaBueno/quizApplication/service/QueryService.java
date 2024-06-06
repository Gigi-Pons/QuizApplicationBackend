package com.greciaBueno.quizApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.greciaBueno.quizApplication.dao.QueryDao;
import com.greciaBueno.quizApplication.model.Query;

/*
 	The QueryService class provides methods to interact with the 
 	database for query objects.  There are a total of 3 methods for 
 	retrieving all queries, retrieving queries by type, and creating
 	new queries.  To perform these operatons we use QueryDao.
 	The @service annotation marks the class as a Spring Service 
 	component.
 */

@Service
public class QueryService {

    @Autowired
    QueryDao queryDao;
    
    //Attempts to find all queries and return the queries with a 200 OK status
    public ResponseEntity<List<Query>> getAllQueries() {
        try {
            return new ResponseEntity<>(queryDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    
    //Retrieve queries by type
    public ResponseEntity<List<Query>> getQueriesByType(String type) {
        try {
            return new ResponseEntity<>(queryDao.findByType(type), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    
    //Saves the query and returns a success message with 201 status
    public ResponseEntity<String> createQuery(Query query) {
        try {
            queryDao.save(query);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }
    
}
