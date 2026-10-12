public class Exercise27A {
    public static void main(String[] args) {
        LibraryItem item = new LibraryItem();
        int borrowingDays = item.calculateBorrowingDays();

        System.out.println("Borrowing period: " + borrowingDays + " days");
    }

    static class LibraryItem {
        private static final int BORROWING_DAYS = 14;

        public int calculateBorrowingDays() {
            return BORROWING_DAYS;
        }
    }
}