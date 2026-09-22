public class Exercise07A {
    static class Book{
        String title;
        String pages;

        Book(){
            title = "Unknown";
            pages = "1";
        }
    }

    public static void main(String[] args) {
        Book book = new Book();

        System.out.println(book.title);
        System.out.println(book.pages);


    }
}
