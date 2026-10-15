public class Exercise29B {

    static abstract class Payment {
        public abstract void processPayment();
    }

    static class CashPayment extends Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing cash payment.");
        }
    }

    static class CardPayment extends Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing card payment.");
        }
    }

    public static void main(String[] args) {
        CashPayment cashPayment = new CashPayment();
        CardPayment cardPayment = new CardPayment();

        cashPayment.processPayment();
        cardPayment.processPayment();
    }
}