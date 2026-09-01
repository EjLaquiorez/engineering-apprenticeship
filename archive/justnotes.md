Part A

Run it.

Tell me:

Why does age work inside the if block? it works inside the if block because if is inside the main
Why does age work after the if block? because it is declared on main
Why does licenseNumber work inside the if block? it is declared inside the if block
Part B — Predict Before Running

Add this:

System.out.println(licenseNumber);

after the if block.

Don't run it immediately.

First predict:

Will it compile or produce an error?

Then run it and compare your prediction with reality.

Part C — Fix It

Make the program compile again without simply deleting licenseNumber.

Your goal is to make licenseNumber accessible where you need it.

Knowledge Check

public class Lesson02Exercise {

    public static void main(String[] args) {

        int age = 25;
        int licenseNumber = 12345;

        if (age >= 18) {


            System.out.println(age);
            System.out.println(licenseNumber);
        }

        System.out.println(age);
        System.out.println(licenseNumber);
    }
}

Answer these without looking back:

Q1

What is variable scope? variable scope is the part where that variable can only work and be use.

Q2

Why can an inner block access a variable declared in an outer block? Because declaring outside means what is inside that clause can access it but not vice versa

Q3

Why can't an outer block access a variable declared inside an inner block? Because declaring inside the inner block only and not the main cannot be use on other block or on much bigger clause.

Q4

Will this compile?

if (true) {

    int x = 10;
}

System.out.println(x);

Why?
No, because the variable x is declared only inside the if block
Q5

Where is age accessible?
can access it every where, because it is declared on main
public static void main(String[] args) {

    int age = 25;

    if (age > 18) {
        System.out.println(age);
    }

    System.out.println(age);
}
Q6

Why is keeping a variable's scope small generally a good engineering practice? to limit other code interacting with that variable and have a cleaner logic and arguments


Exercise — Primitive Data Types

Create:

Lesson03Exercise.java

Your program must declare these variables:

1. Age

Represent someone's age.

Use the appropriate primitive type.

2. Price

Represent:

1499.99

Use the appropriate primitive type.

3. Account status

Represent whether an account is active.

Use:

true
4. Grade

Represent the letter:

A
5. Large number

Represent:

9000000000

Choose the appropriate primitive type.

Then print all five variables.

Your output should conceptually look like:

Age: ...
Price: ...
Active: ...
Grade: ...
Large number: ...
Break It

After your correct version works, intentionally create these mistakes one at a time:

Experiment 1

Try putting a decimal into an int.

int number = 10.5;

What does Java tell you?

Experiment 2

Try:

boolean active = 1;

What happens?

Experiment 3

Try:

char grade = "A";

What happens?

Experiment 4

Try assigning a value outside the range of byte.

byte number = 128;

What happens?

The goal isn't just to see errors.

The goal is to understand why Java rejects them.

Knowledge Check

Answer these without looking back.

Q1

What is a data type?

Q2

What is the difference between int and double?

Q3

Which primitive type would you normally use for:

42

and why?

Q4

Which primitive type would you use for:

42.75

and why?

Q5

What are the only two values a boolean can contain?

Q6

What is the difference between:

'A'

and:

"A"
Q7

Why does this require an L?

long population = 9000000000L;
Q8

Why does this require an f?

float temperature = 36.5f;
Q9

Which type would you choose for:

A person's age
A product price
Whether a user is logged in
A single letter grade
A very large whole-number count

Explain why, rather than simply listing the types.

Evidence Required

Before Lesson 03 is complete, send me:

Your Lesson03Exercise.java
Its output
Your answers to Q1–Q9
What happened in the four Break It experiments

Then I'll review your reasoning and code.