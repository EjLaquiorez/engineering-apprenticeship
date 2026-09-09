public class Lesson30Exercise {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        // Print first and last element.
        System.out.println("First Element: " + numbers[0]);
        System.out.println("Last Element: " + numbers[numbers.length - 1]);

        // Comment out numbers[5] and explain the error.
        // System.out.println(numbers[5]);
        // This throws ArrayIndexOutOfBoundsException because index 5 is out of range for a 5-element array.

        // Traverse using i < numbers.length.
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // Replace numbers[2] with 99.
        numbers[2] = 99;
        System.out.println("Updated element at index 2: " + numbers[2]);
    }
}

