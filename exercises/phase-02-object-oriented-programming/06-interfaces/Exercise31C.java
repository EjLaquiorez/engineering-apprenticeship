public class Exercise31C {

    interface Summarizable {
        void summarize();
    }

    static class Book implements Summarizable {
        @Override
        public void summarize() {
            System.out.println("Summarizing book");
        }
    }

    static class Report implements Summarizable {
        @Override
        public void summarize() {
            System.out.println("Summarizing report");
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        Report report = new Report();

        book.summarize();
        report.summarize();
    }
}
