public class Exercise27B {
    abstract static class LibraryItem {
        public abstract int calculateBorrowingDays();
    }

    static class Book extends LibraryItem {
        @Override
        public int calculateBorrowingDays() {
            return 14;
        }
    }

    static class Magazine extends LibraryItem {
        @Override
        public int calculateBorrowingDays() {
            return 7;
        }
    }

    static class DVD extends LibraryItem {
        @Override
        public int calculateBorrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
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