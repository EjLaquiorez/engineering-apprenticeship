package library.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import library.model.ItemType;
import library.model.LibraryItem;
import library.model.Member;
import library.model.BorrowingTransaction;

class BorrowingServiceTest {

    @Test
    void borrowItem_shouldCreateTransactionAndMarkItemAsBorrowed() {
        Member member = new Member(1, "John");
        LibraryItem item = new LibraryItem("B001", "Clean Code", ItemType.BOOK);
        BorrowingService borrowingService = new BorrowingService();
        BorrowingTransaction transaction = borrowingService.borrowItem(member, item);
    }

}