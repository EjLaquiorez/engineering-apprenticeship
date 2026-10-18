public class ExerciseT5 {
    abstract static class Payment {
        abstract void processPayment();

        public void printReceipt() {
            System.out.println("Printing receipt");
        }
    }

    static class CashPayment extends Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing cash payment");
        }
    }

    static class CardPayment extends Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing card payment");
        }
    }

    static class OnlinePayment extends Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing online payment");
        }
    }

    
	public static void main(String[] args) {
        Payment[] payments = {new CashPayment(), new CardPayment(), new OnlinePayment()};

        for(Payment payment : payments) {
            payment.printReceipt();
            payment.processPayment();
        }

	}
}
