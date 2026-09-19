# Expense Tracker

A Java console application for recording, viewing, and calculating personal expenses.

## Project Purpose

The Expense Tracker demonstrates the Java fundamentals learned throughout Phase 01. It allows users to add expenses, view recorded expenses, and calculate the total amount spent while validating user input.

## Features

* Add an expense
* Store expense descriptions and amounts
* View recorded expenses
* Calculate total expenses
* Repeated menu interaction
* Input validation
* Protection against exceeding array capacity
* Numeric input validation
* Graceful program termination

## Menu

| Option | Operation     |
| ------ | ------------- |
| `1`    | Add Expense   |
| `2`    | View Expenses |
| `3`    | Exit          |

## Expense Data

Each expense contains two pieces of information:

| Data        | Type     | Purpose                         |
| ----------- | -------- | ------------------------------- |
| Description | `String` | Stores what the expense was for |
| Amount      | `double` | Stores the expense amount       |

The program stores these values using parallel arrays.

```java
String[] descriptions;
double[] amounts;
```

The same index represents the same expense.

For example:

```text
descriptions[0] = "Lunch"
amounts[0] = 150
```

Together, they represent:

```text
Lunch - 150
```

## Student Storage

The application uses an `expenseCount` variable to keep track of how many expenses are currently stored.

```java
int expenseCount;
```

`expenseCount` also determines the next available position in the arrays.

For example, if:

```text
expenseCount = 2
```

then the next expense will be stored at index:

```text
2
```

The program loops only through the stored expenses instead of the entire array capacity.

## Adding an Expense

When the user selects **Add Expense**, the program:

1. Checks whether the arrays are already full.
2. Asks the user for an expense description.
3. Asks for the expense amount.
4. Validates the amount.
5. Stores the expense in the arrays.
6. Increases `expenseCount`.

This allows multiple expenses to be stored during the same program session.

## Viewing Expenses

The program displays only the expenses that have been added.

The loop uses `expenseCount` rather than the full array length.

Conceptually:

```text
for each stored expense
    display description
    display amount
```

This prevents empty array positions from being displayed.

## Calculating Total Expenses

The total is calculated by adding the stored expense amounts.

For example:

```text
Lunch       150
Jeepney      30
Coffee       80
Groceries   500
----------------
Total       760
```

The calculation only includes expenses that have actually been added.

## Input Validation

The program validates user input before storing an expense.

### Menu

Valid menu choices are:

```text
1
2
3
```

Invalid menu choices are rejected instead of being processed as valid operations.

### Expense Amount

The expense amount must be a valid numeric value.

Invalid input is handled using `NumberFormatException` so that incorrect input does not unexpectedly terminate the program.

## Array Capacity

The program checks whether the expense arrays are full before adding a new expense.

If:

```text
expenseCount == descriptions.length
```

there is no available position for another expense.

The program displays an appropriate message instead of attempting to access an index outside the array.

## Program Structure

The application separates responsibilities into methods.

Typical responsibilities include:

* **Menu method** — displays the available operations.
* **Add expense method** — validates and stores a new expense.
* **Display expense method** — displays recorded expenses.
* **Total method** — calculates the total amount spent.

Separating these responsibilities keeps the main program flow easier to understand and maintain.

## Testing

The Expense Tracker was tested for:

* Adding an expense
* Viewing expenses
* Calculating the total
* Multiple expenses
* Empty expense list
* Invalid menu input
* Invalid numeric input
* Full array capacity
* Correct `expenseCount` behavior
* Correct total calculation
* Exiting the program

Example expenses used during development:

```text
Lunch       150
Jeepney      30
Coffee       80
Groceries   500
```

Expected total:

```text
760
```

## Error Handling

The application handles invalid user input instead of allowing the program to terminate unexpectedly.

`NumberFormatException` is used when Java cannot convert text input into the expected numeric value.

The program then displays an error message and allows the user to continue.

## Java Concepts Demonstrated

* Variables
* Primitive data types
* `String`
* `double`
* Conditional statements
* `switch`
* Loops
* Methods
* Method parameters
* Return values
* Arrays
* Array indexing
* `array.length`
* `Scanner`
* `try-catch`
* `NumberFormatException`
* Input validation
* String methods
* Basic refactoring

## Engineering Practices

* Separation of responsibilities
* Reusable helper methods
* Input validation
* Defensive array handling
* Clear variable naming
* User-friendly error messages
* Testing normal and invalid input
* Refactoring repeated logic into methods

## Status

**Complete**

This project is the second completed project of Phase 01 — Java Foundations.
