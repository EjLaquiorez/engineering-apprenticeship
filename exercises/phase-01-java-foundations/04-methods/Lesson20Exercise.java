public class Lesson20Exercise{
    public static void main(String[] args) {
        double subtotal = calculateSubTotal(1499.99, 7);
        System.out.println("Subtotal: " + subtotal);

        double subtotal2 = calculateSubTotal(499.99, 8);
        System.out.println("Subtotal: " + subtotal2);
    }
    static double calculateSubTotal(double price, int quantity){
        return price * quantity;
    }

}