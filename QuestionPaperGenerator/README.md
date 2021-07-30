Question Paper Generator

Problem Definition:

Design and Implement a Question Paper Generator

The application must store a number of questions in a Question Store. Questions can have the following attributes {text, subject, topic, difficulty, marks}

The Question Paper Generator should be capable of generating Question Papers based on a given template. A Template specifies the total number of marks & distribution of marks based on an attribute. We should also be able to combine two or more templates to produce more powerful results

Example :
1. (100 marks, Difficulty, {20% Easy, 50% Medium; 30% Hard})
   This means that we are required to generate a question paper of 100 marks which 20% (i.e 20 marks) worth of questions having Difficulty=Easy, 50% having Difficulty=Medium, 30% having Difficulty=Hard
2. (100 marks, Topic, {40% OS; 60% Algo})
   This means we are required to generate a question paper of 100 marks with 40% marks having Topic=OS and 60% having Topic=Algo
3. Combination of above two: (100 marks, Difficulty, {15% Easy, 0% Medium; 85% Hard}, Topic, {40% OS; 60% Algo})

40%OS 60%Algo + 15%Easy 85%Hard	→ QP(100) (40 m -> OS, 60 m -> Algo); (40 m Easy, 60 m Hard)


Bonus Feature:
System has functionality to add, modify, delete questions from question bank. Generate question will have 10x throughput of add/modify/delete combined. Code should take care of concurrency issues

Requirements:
Should support this using In-Memory DS constructs, use of DB not allowed.

Expectations:


Create the sample data yourself. You can put it into a file, test case or main driver program itself.
Code should be demoable. Either by using a main driver program or test cases.
Code should be modular. Code should have basic OO design. Please do not jam in responsibilities of one class into another.
Code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without re-writing entire codebase.
Code should handle edge cases properly and fail gracefully.
Code should be legible, readable and DRY.

Guidelines:


Please discuss the solution with an interviewer
Please do not access internet for anything EXCEPT syntax
You are free to use the language of your choice
All work should be your own
