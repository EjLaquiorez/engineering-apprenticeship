public class Exercise07B {
    static class Book{
        String title;
        int pages;

        Book(String title, int pages){
            this.title = title;
            this.pages = pages;
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Unknown", 1);

        System.out.println("Title: " + book.title);
        System.out.println("Pages: " + book.pages);


    }
}
