public class Exercise34A {

    interface Describable {
        void describe();
    }

    static class Book implements Describable {
        @Override
        public void describe() {
            System.out.println("Describing a book.");
        }
    }

    static class Magazine implements Describable {
        @Override
        public void describe() {
            System.out.println("Describing a magazine.");
        }
    }

    static class LibraryReport implements Describable {
        @Override
        public void describe() {
            System.out.println("Describing a library report.");
        }
    }

    public static void main(String[] args) {
        Describable[] itemDescribables = {new Book(), new Magazine(), new LibraryReport()};

        for (Describable itemDescribable : itemDescribables) {
            itemDescribable.describe();
        }
    }
}