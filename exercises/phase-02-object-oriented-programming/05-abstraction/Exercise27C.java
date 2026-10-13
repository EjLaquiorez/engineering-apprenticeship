public class Exercise27C {
    // Abstraction: callers use the common LibraryItem type without needing to
    // know how each kind of item determines its borrowing period.
    abstract static class LibraryItem {
        public abstract int calculateBorrowingDays();
    }

    static class Book extends LibraryItem {
        // Encapsulation: keep the borrowing-period detail private and expose it
        // through the public behavior declared by LibraryItem.
        private static final int BORROWING_DAYS = 14;

        @Override
        public int calculateBorrowingDays() {
            return BORROWING_DAYS;
        }
    }

    static class Magazine extends LibraryItem {
        private static final int BORROWING_DAYS = 7;

        @Override
        public int calculateBorrowingDays() {
            return BORROWING_DAYS;
        }
    }

    static class DVD extends LibraryItem {
        private static final int BORROWING_DAYS = 3;

        @Override
        public int calculateBorrowingDays() {
            return BORROWING_DAYS;
        }
    }

    public static void main(String[] args) {
        // Polymorphism lets the same call work for every kind of library item.
        LibraryItem[] items = {
            new Book(),
            new Magazine(),
            new DVD()
        };

        for (LibraryItem item : items) {
            System.out.println(
                item.getClass().getSimpleName()
                    + " borrowing period: "
                    + item.calculateBorrowingDays()
                    + " days"
            );
        }
    }
}