# Calculator

**Phase:** 1 — Java Foundations  
**Status:** 🟡 In Progress

## Purpose

Build a command-line calculator that performs basic arithmetic operations.

## Requirements

- Support addition, subtraction, multiplication, division
- Handle invalid input gracefully
- Use methods to organize operations
- No external dependencies

## Usage

Run the calculator from the project root after implementing the source files:

```powershell
java -cp src Calculator
```

Enter two numbers and an operation when prompted. Division by zero and malformed
input should produce a clear error message without crashing the program.

## Getting Started

Copy the project scaffold:

```powershell
Copy-Item -Recurse ../../templates/project-scaffold .
```

Then implement in `src/`.
