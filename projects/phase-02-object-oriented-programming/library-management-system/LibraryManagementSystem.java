public class LibraryManagementSystem {

    static class Library{
        String name;
        int bookCount;
        int memberCount;
        Book[] books;
        Member[] members;

        Library(String name, int maxBooks, int maxMembers){
            this.name = name;
            this.books = new Book[maxBooks];
            this.members = new Member[maxMembers];
        }

        //Create addBook,addMember,displayBooks,displayMembers,displayLibrary,welcomeMember

        void addBook(){

        }

        void addMember(){

        }

        void displayBooks(){

        }

        void displayMembers(Member member){
            System.out.println("Members in " + name + ":");
			for (int i = 0; i < memberCount; i++) {
				System.out.print((i + 1) + ". ");
				members[i].displayMemberInfo();
			}

        }

        void welcomeMember(Member member){
            System.out.println("Welcome to " + name + " , " + member.name + " ! ");
        }

    }

    static class Book{
        String title;
        int pageCount;
        String author;



    }

    static class Member{
        String name;
        int memberId;
        String address;
        String email;
        int phoneNumber;



    

    }
    public static void main(String[] args) {
        
    }
}
