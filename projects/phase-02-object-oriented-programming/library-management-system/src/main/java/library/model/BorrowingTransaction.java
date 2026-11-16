package library.model;

import java.time.LocalDate;

public class BorrowingTransaction {
	private final String transactionId;
	private final Member member;
	private final LibraryItem libraryItem;
	private final LocalDate borrowDate;
	private final LocalDate dueDate;
	private LocalDate returnDate;

	public BorrowingTransaction(String transactionId, Member member, LibraryItem libraryItem, LocalDate borrowDate,
			LocalDate dueDate) {
		this.transactionId = transactionId;
		this.member = member;
		this.libraryItem = libraryItem;
		this.borrowDate = borrowDate;
		this.dueDate = dueDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public Member getMember() {
		return member;
	}

	public LibraryItem getLibraryItem() {
		return libraryItem;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void recordReturn(LocalDate returnDate) {
		if (this.returnDate != null) {
			throw new IllegalStateException("This transaction has already been completed.");
		}
		if (returnDate.isBefore(borrowDate)) {
			throw new IllegalArgumentException("Return date cannot be before the borrowing date.");
		}
		this.returnDate = returnDate;
	}

	public boolean isActive() {
		return returnDate == null;
	}
}
