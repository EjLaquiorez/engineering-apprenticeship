package library.model;

import java.time.LocalDate;

public class BorrowingTransaction {
	private final String transactionId;
	private final Member member;
	private final LibraryItem libraryItem;
	private final LocalDate borrowDate;
	private final LocalDate dueDate;
	private LocalDate returnDate;
}
