public class LibraryManagementSystem {

    static class Library {
        String name;
        int bookCount;
        int memberCount;
        Book[] books;
        Member[] members;

        Library(String name, int maxBooks, int maxMembers) {
            this.name = name;
            this.books = new Book[maxBooks];
            this.members = new Member[maxMembers];
        }

        // Create
        // addBook,addMember,displayBooks,displayMembers,displayLibrary,welcomeMember

        // Instance method: add a book to this specific library instance.
        void addBook(Book book) {
            if (bookCount < books.length) {
                books[bookCount] = book;
                bookCount++;
            } else {
                System.out.println("This library is full.");
            }
        }

        // Instance method: add a member to this specific library instance.
        void addMember(Member member) {
            if (memberCount < members.length) {
                members[memberCount] = member;
                memberCount++;
            } else {
                System.out.println("This library cannot accept more members.");
            }
        }

        void displayBooks() {
            System.out.println("Books in " + name + ":");
            for (int i = 0; i < booksCount; i++) {
                System.out.print((i + 1) + ". ");
                members[i].displayBookInfo();
            }
        }

        void displayMembers(Member member) {
            System.out.println("Members in " + name + ":");
            for (int i = 0; i < memberCount; i++) {
                System.out.print((i + 1) + ". ");
                members[i].displayMemberInfo();
            }

        }

        void welcomeMember(Member member) {
            System.out.println("Welcome to " + name + " , " + member.name + " ! ");
        }

    }

    static class Book {
        String title;
        int pageCount;
        String author;

        Book(String title, String author) {
            this(title, 0, author);
        }

        Book(String title, int pageCount, String author) {
            this.title = title;
            this.pageCount = pageCount;
            this.author = author;
        }

    }

    static class Member {
        String name;
        int memberId;
        String address;
        String email;
        int phoneNumber;

    }

    public static void main(String[] args) {

    }
}
