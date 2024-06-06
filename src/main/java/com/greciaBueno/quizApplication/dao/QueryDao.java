package com.greciaBueno.quizApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 	This file contains a repository interface that extendes JpaRepository to
 	provide CRUD operations for the Query entity.  It includes two methods (custom)
 	findByType and findRancomQueriesByType.  The last method is used to find a random
 	subset of queries by their type using a native SQL query.
 */

@Repository
public interface QueryDao extends JpaRepository<com.greciaBueno.quizApplication.model.Query, Integer> {
    
	//This method generates a query to find all Query entities with a specific type.
	//It then returns a list of Query objects that match the given type.
    List<com.greciaBueno.quizApplication.model.Query> findByType(String type);

    //This native query selects all columns from the question table where the type
    //matches the specified type, orders the results randomly, and limits the number
    //of results to numQ
    @Query(value = "SELECT * FROM question q WHERE q.type=:type ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<com.greciaBueno.quizApplication.model.Query> findRandomQueriesByType(String type, int numQ);

}
