package library.service;

import java.time.LocalDate;

import library.model.BorrowingTransaction;
import library.model.LibraryItem;
import library.model.ItemStatus;
import library.model.Member;
import library.model.MemberStatus;

public class BorrowingService {
    private int nextTransactionId = 1;

    public BorrowingTransaction borrowItem(Member member, LibraryItem item) {
        if (member.getStatus() != MemberStatus.ACTIVE) {
            throw new IllegalStateException("Inactive members cannot borrow items.");
        }
        if (item.getStatus() != ItemStatus.AVAILABLE) {
            throw new IllegalStateException("Item is not available for borrowing.");
        }
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14);
        String transactionId = String.valueOf(nextTransactionId++);
        return new BorrowingTransaction(transactionId, member, item, borrowDate, dueDate);
    }
}