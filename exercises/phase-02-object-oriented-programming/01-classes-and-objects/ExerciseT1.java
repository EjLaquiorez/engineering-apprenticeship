public class ExerciseT1 {
	static class Book {
		String title;
		int pageCount;
		String author;

		Book(String title, int pageCount, String author) {
			this.title = title;
			this.pageCount = pageCount;
			this.author = author;
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
	}

	static class Library {
		String name;

		Library(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Book book = new Book("The Hobbit", 310, "J. R. R. Tolkien");
		Member member = new Member("M001", "Alex Smith", "1 Main Street", "alex@example.com", "555-0100");
		Library library = new Library("Central Library");

		System.out.println(library.name);
		System.out.println(book.title + " - " + member.name);
	}
}