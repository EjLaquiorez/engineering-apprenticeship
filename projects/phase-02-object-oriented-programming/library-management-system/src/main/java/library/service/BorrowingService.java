package library.service;

import library.model.LibraryItem;
import library.model.ItemStatus;
import library.model.Member;
import library.model.MemberStatus;

public class BorrowingService {
    public void borrowItem(Member member, LibraryItem item) {
        if (member.getStatus() != MemberStatus.ACTIVE) {
            throw new IllegalStateException("Inactive members cannot borrow items.");
        }
        if (item.getStatus() != ItemStatus.AVAILABLE) {
            throw new IllegalStateException("Item is not available for borrowing.");
        }
    }
}