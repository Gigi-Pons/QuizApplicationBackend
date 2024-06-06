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

### **Repositories**
- QueryDao: Managing questions through data access object, which interacts with the database.
- QuizDao: Managing quizzes thorugh data access object, which interacts with the database.

### **Data Transfer Objects**
- QuestionWrapper: Encapsulates the details about the questions to be transferred between layers.
- Response: Encapsulates the details about the responses to specific quiz questions.

## The Database
Here is an overview of the current database and its contents.  It currently holds 10 questions in a trivia fashion with its respective answers.  

<img width="1528" alt="Database" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/5857dded-297f-4452-bdcc-6a9862897be9">  

## The API Endpoints  

### **allQueries**
Allows the retrieval of all questions.  

<img width="1591" alt="allQueries" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/acd79c8d-d621-4a4b-a4f5-c81cde6ded24">




