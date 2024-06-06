# Quiz Application

## Overview
This quiz application allows administrators to create and manage questions.  It also allows users to take quizzes, submit responses and recieve results.  
The applciation is using Spring Boot backend to handle business logic and data management through PostgreSQL database.  

## The Components 
### **Entities**  
- Query: a question in the quiz.
- Quiz: a quiz containing a collection of questions.
  
### **Controllers**
- QueryController: Manages CRUD operations for questions/query.
- QuizController: quiz creation, submission, as well as retrieval.

### **Services**  
- QueryService: The business logic for all the questions.
- QuizService: The business logic for every quiz created.

### ** Repositories**
- QueryDao: Managing questions through data access object.
- QuizDao: Managing quizzes thorugh data access object.

