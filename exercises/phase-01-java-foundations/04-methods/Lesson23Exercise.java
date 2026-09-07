public class Lesson23Exercise {

    
    static void displayStudent(String name, double total) {
        double finalTotal = calculateDiscountedTotal(total);

        System.out.println("Student: " + name);
        System.out.println("Original Total: $" + total);
        System.out.println("Final Total: $" + finalTotal);
        System.out.println("Status: " + (hasDiscount(total) ? "Discount Applied" : "No Discount"));
    }

    static boolean hasDiscount(double total) {
        return total >= 500;
    }

    static double calculateDiscountedTotal(double total) {
        if (hasDiscount(total)) {
            return total - 20;
        }
        return total;
    }

    public static void main(String[] args) {
        displayStudent("Justine", 700);
    }
}

// Create Lesson23FinalExercise.java with a small student program containing:

// A method that calculates something.
// A method that returns a boolean.
// A method that displays information.
// main() that coordinates the methods.
// At least one parameter.
// At least one return value.
// At least one void method.