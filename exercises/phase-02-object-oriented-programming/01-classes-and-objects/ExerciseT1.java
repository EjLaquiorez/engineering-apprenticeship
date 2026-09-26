public class ExerciseT1 {
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

		// Instance method: it uses this book's own state (title, author, pageCount)
		// and belongs to each Book object, not the whole class.
		void displayBookInfo() {
			System.out.println("Book: " + title + " by " + author + " (" + pageCount + " pages)");
		}

		// Instance method: checks the specific book instance's page count.
		boolean isLongBook() {
			return pageCount > 300;
		}
	}

	static class Member {
		String memberId;
		String name;
		String address;
		String email;
		String phoneNumber;

		Member(String memberId, String name, String address, String email, String phoneNumber) {
			this.memberId = memberId;
			this.name = name;
			this.address = address;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		// Instance method: uses this member's own contact information.
		void displayMemberInfo() {
			System.out.println("Member: " + memberId + " - " + name + " | " + email + " | " + phoneNumber);
		}

		// Instance method: updates the data for this one member object.
		void updatePhoneNumber(String newPhoneNumber) {
			this.phoneNumber = newPhoneNumber;
		}
	}

	static class Library {
		String name;
		Book[] books;
		Member[] members;
		int bookCount;
		int memberCount;

		Library(String name, int maxBooks, int maxMembers) {
			this.name = name;
			this.books = new Book[maxBooks];
			this.members = new Member[maxMembers];
		}

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

		// Instance method: display all books in this library.
		void displayBooks() {
			System.out.println("Books in " + name + ":");
			for (int i = 0; i < bookCount; i++) {
				System.out.print((i + 1) + ". ");
				books[i].displayBookInfo();
			}
		}

		// Instance method: display all members in this library.
		void displayMembers() {
			System.out.println("Members in " + name + ":");
			for (int i = 0; i < memberCount; i++) {
				System.out.print((i + 1) + ". ");
				members[i].displayMemberInfo();
			}
		}

		// Instance method: belongs to the current library object and uses its name.
		void displayLibraryInfo() {
			System.out.println("Library: " + name);
		}

		// Instance method: greets a specific member from this library instance.
		void welcomeMember(Member member) {
			System.out.println("Welcome to " + name + ", " + member.name + "!");
		}
	}

	public static void main(String[] args) {
		Book book1 = new Book("The Hobbit", 310, "J. R. R. Tolkien");
		Book book2 = new Book("Java Basics", "John Doe");
		Member member1 = new Member("M001", "Alex Smith", "1 Main Street", "alex@example.com", "555-0100");
		Member member2 = new Member("M002", "Sam Lee", "2 Oak Road", "sam@example.com", "555-0200");
		Library library = new Library("Central Library", 10, 10);

		// These methods are instance methods because they act on the library instance's own state.
		library.addBook(book1);
		library.addBook(book2);
		library.addMember(member1);
		library.addMember(member2);

		book1.displayBookInfo();
		System.out.println("Is book1 a long book? " + book1.isLongBook());
		book2.displayBookInfo();
		System.out.println("Is book2 a long book? " + book2.isLongBook());

		member1.displayMemberInfo();
		member1.updatePhoneNumber("555-0199");
		member1.displayMemberInfo();

		library.displayLibraryInfo();
		library.displayBooks();
		library.displayMembers();
		library.welcomeMember(member1);
	}
}