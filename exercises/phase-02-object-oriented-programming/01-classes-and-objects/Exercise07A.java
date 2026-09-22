public class Exercise07A {
    static class Book{
        String title;
        int pages;

        Book(){
            title = "Unknown";
            pages = 0;
        }
    }

    public static void main(String[] args) {
        Book book = new Book();

        System.out.println("Title: " + book.title);
        System.out.println("Pages: " + book.pages);


    }
}
