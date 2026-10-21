public class Exercise34B {

    interface Describable {
        void describe();
    }

    static class Book implements Describable {
        @Override
        public void describe() {
            System.out.println("Book: Clean Code");
        }
    }

    static class Magazine implements Describable {
        @Override
        public void describe() {
            System.out.println("Magazine: National Geographic");
        }
    }

    public static void main(String[] args) {
        Describable book = new Book();
        book.describe();

        book = new Magazine();
        book.describe();
    }
}