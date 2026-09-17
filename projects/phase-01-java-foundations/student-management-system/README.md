# Student Management System

A Java console application for managing basic student records.

## Project Purpose

The Student Management System demonstrates the Java fundamentals learned throughout Phase 01. It allows users to store student information, view records, search for students, and calculate the average grade.

## Features

* Add a student
* Store student name, age, and grade
* Display all stored students
* Search for a student by name
* Case-insensitive student search
* Calculate the average student grade
* Validate menu input
* Validate student age
* Validate student grade
* Prevent adding students when the array is full

## Student Data

Each student contains:

| Data  | Java Type |
| ----- | --------- |
| Name  | `String`  |
| Age   | `int`     |
| Grade | `double`  |

The application uses parallel arrays where the same index represents the same student.

Example:

```text
names[0]  → Earl
ages[0]   → 27
grades[0] → 98.0
```

## Program Structure

The application separates responsibilities into methods:

* `addStudent()` — adds and validates a new student
* `displayStudents()` — displays stored students
* `searchStudent()` — searches for a student by name
* `calculateAverageGrade()` — calculates the average grade
* `displayMenu()` — displays the main menu
* `handleChoice()` — handles the selected menu operation

The `main()` method controls the overall program flow and menu input.

## Input Validation

The program handles invalid numeric input using `NumberFormatException`.

### Age

Valid ages are:

```text
1–120
```

### Grade

Valid grades are:

```text
0–100
```

The program continues prompting the user until valid input is provided.

## Student Storage

The program uses arrays with a capacity of five students.

```text
String[] names
int[] ages
double[] grades
```

`studentCount` tracks the number of students currently stored and determines the next available array index.

## Testing

The application was tested for:

* Adding students
* Displaying students
* Searching for existing students
* Searching for nonexistent students
* Case-insensitive searching
* Calculating the average grade
* Invalid menu numbers
* Non-numeric menu input
* Invalid age input
* Invalid grade input
* Age boundary values
* Grade boundary values
* Full student capacity
* Empty student list

## Example

```text
1. Add Student
2. Display Students
3. Search Student
4. Calculate Average
5. Exit

Choose an option: 1

Enter student name:
Earl

Enter student age:
27

Enter student grade:
98

Name: Earl
Age: 27
Grade: 98.0

Average grade: 98.0
```

## Java Concepts Demonstrated

This project applies:

* Variables
* Primitive data types
* Strings
* Arrays
* Loops
* Conditional statements
* `switch`
* Methods
* Method parameters and return values
* `Scanner`
* Exception handling with `try-catch`
* `NumberFormatException`
* Input validation
* Basic refactoring
* Separation of responsibilities

## Status

**Complete**

This project completes the third project of Phase 01 — Java Foundations.
