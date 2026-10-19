public class Exercise32C {

    interface Describable {
        void describe();
    }

    static class Book implements Describable {
        private final String title;
        private final String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public void describe() {
            System.out.println(getClass().getSimpleName() + ": " + title + " by " + author);
        }
    }

    static class Magazine implements Describable {
        private String title;
        private int issueNumber;

        Magazine(String title, int issueNumber) {
            this.title = title;
            this.issueNumber = issueNumber;
        }

        @Override
        public void describe() {
            System.out.println(getClass().getSimpleName() + ": " + title + ", Issue " + issueNumber);
        }
    }

    public static void main(String[] args) {
        Describable item = new Book("Clean Code", "Robert C. Martin");
        item.describe();

        item = new Magazine("National Geographic", 42);
        item.describe();
    }
}
