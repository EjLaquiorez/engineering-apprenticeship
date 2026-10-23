public class ExerciseT6 {

    interface Printable {
        // TODO: Declare one method for printing
        void print();
    }

    static class Report implements Printable {

        // TODO: Implement the required method
        @Override
        public void print() {
            System.out.println("Printing report.");
        }

    }

    static class Invoice implements Printable {
        // TODO: Implement the required method
        @Override 
        public void print() {
            System.out.println("Printing invoice.");
        }
    }

    public static void main(String[] args) {
        // TODO: Create one Report and one Invoice
        Printable report = new Report();
        Printable invoice = new Invoice();

        report.print();
        invoice.print();
    }
}