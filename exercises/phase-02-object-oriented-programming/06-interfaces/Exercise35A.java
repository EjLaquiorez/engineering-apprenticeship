public class Exercise35A {

    static class SeparateInterfaceDesign {

        interface Describable {
            void describe();
        }

        interface Printable {
            void print();
        }

        interface Borrowable {
            void borrow();
        }

        static class Book implements Describable, Printable, Borrowable {
            @Override
            public void describe() {
                System.out.println("Describing a book.");
            }

            @Override
            public void print() {
                System.out.println("Printing a book.");
            }

            @Override
            public void borrow() {
                System.out.println("Borrowing a book.");
            }
        }

        static class Magazine implements Describable, Borrowable {
            @Override
            public void describe() {
                System.out.println("Describing a magazine.");
            }

            @Override
            public void borrow() {
                System.out.println("Borrowing a magazine.");
            }
        }

        static class LibraryReport implements Describable, Printable {
            @Override
            public void describe() {
                System.out.println("Describing a library report.");
            }

            @Override
            public void print() {
                System.out.println("Printing a library report.");
            }
        }
    }

    static class CombinedInterfaceDesign {

        interface LibraryItemActions {
            void describe();

            void print();

            void borrow();
        }

        static class Book implements LibraryItemActions {
            @Override
            public void describe() {
                System.out.println("Describing a book.");
            }

            @Override
            public void print() {
                System.out.println("Printing a book.");
            }

            @Override
            public void borrow() {
                System.out.println("Borrowing a book.");
            }
        }

        static class Magazine implements LibraryItemActions {
            @Override
            public void describe() {
                System.out.println("Describing a magazine.");
            }

            @Override
            public void print() {
                throw new UnsupportedOperationException("A magazine cannot be printed.");
            }

            @Override
            public void borrow() {
                System.out.println("Borrowing a magazine.");
            }
        }

        static class LibraryReport implements LibraryItemActions {
            @Override
            public void describe() {
                System.out.println("Describing a library report.");
            }

            @Override
            public void print() {
                System.out.println("Printing a library report.");
            }

            @Override
            public void borrow() {
                throw new UnsupportedOperationException("A library report cannot be borrowed.");
            }
        }
    }

    public static void main(String[] args) {
        demonstrateSeparateInterfaces();
        demonstrateCombinedInterface();
    }

    private static void demonstrateSeparateInterfaces() {
        System.out.println("Design A: separate interfaces");

        SeparateInterfaceDesign.Book book = new SeparateInterfaceDesign.Book();
        book.describe();
        book.print();
        book.borrow();

        SeparateInterfaceDesign.Magazine magazine = new SeparateInterfaceDesign.Magazine();
        magazine.describe();
        magazine.borrow();

        SeparateInterfaceDesign.LibraryReport report = new SeparateInterfaceDesign.LibraryReport();
        report.describe();
        report.print();
    }

    private static void demonstrateCombinedInterface() {
        System.out.println("\nDesign B: one combined interface");

        CombinedInterfaceDesign.Book book = new CombinedInterfaceDesign.Book();
        book.describe();
        book.print();
        book.borrow();

        CombinedInterfaceDesign.Magazine magazine = new CombinedInterfaceDesign.Magazine();
        magazine.describe();
        attemptUnsupportedAction("Magazine print: ", magazine::print);
        magazine.borrow();

        CombinedInterfaceDesign.LibraryReport report = new CombinedInterfaceDesign.LibraryReport();
        report.describe();
        report.print();
        attemptUnsupportedAction("Library report borrow: ", report::borrow);
    }

    private static void attemptUnsupportedAction(String action, Runnable operation) {
        try {
            operation.run();
        } catch (UnsupportedOperationException exception) {
            System.out.println(action + exception.getMessage());
        }
    }
}