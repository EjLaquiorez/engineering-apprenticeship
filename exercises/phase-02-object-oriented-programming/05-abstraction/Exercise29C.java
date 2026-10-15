public class Exercise29C {

    static abstract class Payment {

        abstract public void processPayment();

        public void printReceipt() {
            System.out.println("Printing receipt.");
        }
    }

    static class CashPayment extends Payment {

        @Override
        public void processPayment() {
            System.out.println("Processing cash payment.");
        }
    }

    public static void main(String[] args) {

        CashPayment cashPayment = new CashPayment();
        cashPayment.processPayment();
        cashPayment.printReceipt();
    }
}