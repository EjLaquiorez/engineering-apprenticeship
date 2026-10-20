public class Exercise33B {

    interface Describable {
        void describe();
    }

    interface Printable {
        void print();
    }

    static class Book implements Describable, Printable {

        // TODO: Implement describe()
        // Print: "Describing the book."
        @Override
        public void describe() {
            System.out.println("Describing the book.");
        }

        // TODO: Implement print()
        // Print: "Printing the book."
        @Override
        public void print() {
            System.out.println("Printing the book.");
        }
    }

    public static void main(String[] args) {
        // TODO: Create a Book object.
        Book book = new Book();
        // TODO: Call both methods.
        book.describe();
        book.print();
    }
}