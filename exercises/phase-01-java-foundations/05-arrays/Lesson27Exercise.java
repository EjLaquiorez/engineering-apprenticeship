public class Lesson27Exercise{
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        // numbers[0] means the value stored at index 0, the first position in the array.
        // These statements manually visit every index from 0 through 4.
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
        System.out.println(numbers[4]);

        // Backward traversal manually visits the indexes from 4 down to 0.
        System.out.println(numbers[4]);
        System.out.println(numbers[3]);
        System.out.println(numbers[2]);
        System.out.println(numbers[1]);
        System.out.println(numbers[0]);
    }

}