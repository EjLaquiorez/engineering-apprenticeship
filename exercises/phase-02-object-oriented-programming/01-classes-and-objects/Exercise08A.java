public class Exercise08A{

    static class Book{
        String title;
        int pages;



        Book(String title, int pages){
            this.title = title;
            this.pages = pages;
            
        }
        Book(){
            this("Unknown", 0);
        }

        public static void main(String[] args) {
            Book book = new Book();
            Book secondBook = new Book("Java Basics", 300);
            System.out.println(book.title + " " + book.pages);
            System.out.println(secondBook.title + " " + secondBook.pages);
        }
    }
}