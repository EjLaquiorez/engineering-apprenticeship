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

Answer these without looking back:

Q1

What is variable scope?

Q2

Why can an inner block access a variable declared in an outer block?

Q3

Why can't an outer block access a variable declared inside an inner block?

Q4

Will this compile?

if (true) {

    int x = 10;
}

System.out.println(x);

Why?

Q5

Where is age accessible?

public static void main(String[] args) {

    int age = 25;

    if (age > 18) {
        System.out.println(age);
    }

    System.out.println(age);
}
Q6

Why is keeping a variable's scope small generally a good engineering practice?