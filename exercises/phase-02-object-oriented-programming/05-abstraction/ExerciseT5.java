public class ExerciseT5 {
    abstract static class Payment {
        abstract void processPayment();

        public void printReceipt() {

        }
    }

    static class CashPayment extends Payment {
        @Override
        public void processPayment() {

        }
    }

    static class CardPayment extends Payment {
        @Override
        public void processPayment() {
            
        }
    }

    static class OnlinePayment extends Payment {
        @Override
        public void processPayment() {
            
        }
    }

    
	public static void main(String[] args) {
        Payment cash = new CashPayment();
        Payment card = new CardPayment();
        Payment online = new OnlinePayment();
        

        cash.processPayment();
        cash.printReceipt();
        card.processPayment();
        card.printReceipt();
        online.processPayment();
        online.printReceipt();
	}
}
