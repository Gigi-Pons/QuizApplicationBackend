# Quiz Application Backend

## Overview
This quiz application allows administrators to create and manage questions.  It also allows users to take quizzes, submit responses and recieve results.  
The applciation is using Spring Boot backend to handle business logic and data management through PostgreSQL database.  
Please refer to the [QuizApplicationFrontend](https://github.com/Gigi-Pons/QuizApplicationFrontend) to see the frontend implementeation and see it live.

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

### **queries/allQueries**
Allows the retrieval of all questions.  

<img width="1591" alt="allQueries" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/acd79c8d-d621-4a4b-a4f5-c81cde6ded24">  

### **queries/type{type}**
Allows the retrieval of questions based on their category.

<img width="982" alt="type:{type}" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/303c1d16-5388-42f2-96f8-97157b6d8d8d">  

### **queries/create**
Allows administrators to create a new question by sending a JSON object in the request body containing the fields necessary for the Query entity.  

<img width="1387" alt="create" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/381dad14-a52e-4cfe-91a6-20cb46d5e685">  

### **/quiz/create**
Allows the creation of a new quiz by specifying the category, number of questions, and quiz title.

<img width="899" alt="createQuizId" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/9a24af61-ab68-46f3-bfd4-342d03f6a775">

Here is an image of the quiz_questions table with the quiz ID (1) and the respective questions collected from the question database.

<img width="845" alt="createQuizQuestions" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/1c5a0439-d23e-4e0d-bc81-980ed1d3e895">

### **/quiz/get{id}**
Allows users to retrieve quiz questions by providing a specific quiz ID.

<img width="860" alt="getQuizId" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/3b21b96c-b969-4b3f-a2a8-a90dce5dbecb">

### **quiz/submit{id}**
Allows users to submit their responses to the quiz questions and the backend will calculate and return their results.

<img width="875" alt="submitResults" src="https://github.com/Gigi-Pons/QuizApplication/assets/77705265/252c772c-d993-4d88-b292-6f43270bcbae">  

### Credit
This project was inspired from Telusko on YouTube.









