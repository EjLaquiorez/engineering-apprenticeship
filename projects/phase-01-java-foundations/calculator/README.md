# Calculator

A Java console application that performs basic arithmetic operations with validated user input.

## Project Purpose

The Calculator demonstrates the Java fundamentals learned throughout Phase 01. It allows users to perform addition, subtraction, multiplication, and division while handling invalid input and division-by-zero cases safely.

## Features

* Addition
* Subtraction
* Multiplication
* Division
* Repeated calculations through a menu
* Case-insensitive `exit` command
* Input validation
* Whole-number menu and operand input validation
* Division-by-zero protection
* Graceful program termination

## Supported Operations

| Option | Operation        |
| ------ | ---------------- |
| `1`    | Add              |
| `2`    | Subtract         |
| `3`    | Multiply         |
| `4`    | Divide           |
| `exit` | Close calculator |

## Program Structure

The application separates responsibilities into methods:

* `displayOperation()` — controls the calculator menu and operation loop
* `getNumber()` — reads and validates numeric input
* Arithmetic logic — performs the selected calculation

The main program starts the calculator by calling the appropriate operation-handling method.

## Input Validation

The program validates menu and number input before performing calculations.

### Menu

Valid menu choices are:

```text
1–4
```

The user can also enter:

```text
exit
```

The `exit` command is handled case-insensitively and accepts surrounding whitespace.

### Numbers

Operands must be entered as whole numbers.

For example:

```text
10
5
```

is valid, while:

```text
10.5
```

is rejected.

Invalid numeric input is handled using `NumberFormatException`.

## Division by Zero

The calculator prevents division by zero.

For example:

```text
5 ÷ 0
```

does not perform the calculation and instead displays an appropriate error message.

## Testing

The calculator was tested for:

* Addition: `10 + 5 = 15`
* Division: `5 / 2 = 2.5`
* Division by zero
* Invalid menu choices
* Negative numbers
* Zero
* Non-numeric input
* Decimal input rejection
* `exit` command
* Uppercase `EXIT`
* Whitespace around the exit command
* Repeated calculations

### Example Test

```text
=== Calculator ===
1. Add
2. Subtract
3. Multiply
4. Divide
Type 'exit' to quit

Choose an operation: exit
Calculator closed.
```

## Error Handling

The application uses `try-catch` to handle invalid numeric input.

`NumberFormatException` is caught when Java cannot convert the user's input into the expected numeric type.

The calculator then displays an error message instead of terminating unexpectedly.

## Java Concepts Demonstrated

This project applies:

* Variables
* Primitive data types
* `String`
* Conditional statements
* `switch`
* Loops
* Methods
* Method parameters
* Return values
* `Scanner`
* `try-catch`
* `NumberFormatException`
* Input validation
* String methods
* Regular expressions
* Try-with-resources
* Basic refactoring

## Engineering Practices

The project also demonstrates:

* Separation of responsibilities
* Reusable helper methods
* Defensive input handling
* Resource management with try-with-resources
* User-friendly error messages
* Repeated testing of normal and invalid inputs

## Status

**Complete**

This project is the first completed project of Phase 01 — Java Foundations.
