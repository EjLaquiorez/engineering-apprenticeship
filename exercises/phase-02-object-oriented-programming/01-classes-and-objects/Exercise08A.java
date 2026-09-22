public class Exercise08A{

    static class Book{
        String title;
        int pages;



        Book(String title, int pages){
            this.title = title;
            this.pages = pages;
            
        }
        Book(){
            this("Unknown", 1);
        }

        public static void main(String[] args) {
            Book book = new Book();
            System.out.println(book.title + " " + book.pages);
        }
    }
}