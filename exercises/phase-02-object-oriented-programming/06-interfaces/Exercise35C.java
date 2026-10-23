public class Exercise35C {
	interface Printable{
		void print();
	}

	interface Borrowable{
		void borrow();

		void returnItem();
	}

	interface LateFeeCalculable{
		void calculateLateFee();
	}

	interface Describable{
		void describe();
	}
    
	static class Book implements Describable, Printable, Borrowable, LateFeeCalculable {
		private final String title;

		Book(String title) {
			this.title = title;
		}

		@Override
		public void describe(){
			System.out.println("Book: " + title);
		}

		@Override
		public void print() {
			System.out.println("Printing book: " + title);
		}

		@Override
		public void borrow() {
			System.out.println("Borrowing book: " + title);
		}

		@Override
		public void returnItem() {
			System.out.println("Returning book: " + title);
		}

		@Override
		public void calculateLateFee() {
			System.out.println("Calculating late fee for: " + title);
		}

	}

	static class Magazine implements Describable, Borrowable, LateFeeCalculable {
		private final String title;

		Magazine(String title) {
			this.title = title;
		}

		@Override
		public void describe() {
			System.out.println("Magazine: " + title);
		}

		@Override
		public void borrow() {
			System.out.println("Borrowing magazine: " + title);
		}

		@Override
		public void returnItem() {
			System.out.println("Returning magazine: " + title);
		}

		@Override
		public void calculateLateFee() {
			System.out.println("Calculating late fee for: " + title);
		}
	}

	static class LibraryReport implements Describable, Printable {
		private final String contents;

		LibraryReport(String contents) {
			this.contents = contents;
		}

		@Override
		public void describe() {
			System.out.println("Library report: " + contents);
		}

		@Override
		public void print() {
			System.out.println("Printing library report: " + contents);
		}
	}

	public static void main(String[] args) {
		Book book = new Book("Lord of the Rings.");
		book.describe();
		book.print();
		book.borrow();
		book.returnItem();
		book.calculateLateFee();

		Magazine magazine = new Magazine("National Geographic");
		magazine.describe();
		magazine.borrow();
		magazine.returnItem();
		magazine.calculateLateFee();

		LibraryReport report = new LibraryReport("Available books and magazines");
		report.describe();
		report.print();
	}
}

