public class Lesson20Exercise{
    public static void main(String[] args) {
        System.out.println("Total Price: " + calculateTotal(1499.99, 7));
    }
    static double calculateTotal(double price, int quantity){
        return price * quantity;
    }

}