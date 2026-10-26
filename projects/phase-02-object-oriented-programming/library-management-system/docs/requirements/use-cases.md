# Library Management System — Use Cases

## 1. Purpose

This document describes the goals that staff and members can accomplish through the Library Management System. It defines the system's actors, their permitted use cases, and the boundaries of Version 1.

The system is a console-based Java application. It manages library item records, member records, borrowing and return transactions, item availability, due dates, and late fees. Version 1 stores data in memory, so records are not retained after the application closes.

## 2. Scope and Design Decisions

- Staff manage library records and record borrowing and return transactions.
- Members can search the catalog and view their own borrowing information and late fees.
- Books and magazines follow the same borrowing rules.
- Each physical library item has a unique identifier.
- Borrowing lasts 14 calendar days.
- The late fee is ₱5 per overdue calendar day per item.
- The system does not include login/authentication, database or file persistence, online reservations, payment processing, or member-initiated borrowing.
- Member-initiated borrowing may be considered for a future version.

## 3. Actors

### 3.1 Staff

Staff members maintain library and member records, record borrowing and returns, search the catalog, check item availability, and review overdue transactions and late fees.

### 3.2 Member

Members search the library catalog and view their own active borrowings, due dates, overdue days, and applicable late fees. Members cannot modify library records or borrowing transactions through the system.

## 4. Use-Case List

The following use cases define the main interactions supported in Version 1.

### Staff Use Cases

| ID | Use Case | Description |
|---|---|---|
| UC-S01 | Add Library Items | Add books and magazines to the catalog. |
| UC-S02 | Update Library Item Details | Update information for existing library items. |
| UC-S03 | Register and Update Members | Create member records and update their information. |
| UC-S04 | Retire Library Items | Mark items as retired so they cannot be borrowed again. |
| UC-S05 | Mark Members Inactive | Mark a member as inactive so they cannot borrow items. |
| UC-S06 | Record Borrowing and Returns | Record when a member borrows an item or returns it. |
| UC-S07 | Review Overdue Borrowings and Late Fees | Review overdue transactions and their current or final fees. |
| UC-S08 | Search Catalog and Check Availability | Search library items and check whether they are available. |

### Member Use Cases

| ID | Use Case | Description |
|---|---|---|
| UC-M01 | Search Library Catalog | Search items by title and view their type and availability. |
| UC-M02 | View Currently Borrowed Items | View the member's active borrowing transactions and item details. |
| UC-M03 | Check Due Dates and Overdue Fees | View days remaining, overdue days, and applicable late fees. |

## 5. Use-Case Constraints and Business Rules

### 5.1 Library Item Rules

- Each physical library item must have a unique identifier.
- Books and magazines follow the same borrowing rules.
- An item can have only one active borrowing transaction at a time.
- An item is unavailable while it has an active borrowing transaction, including when that transaction is overdue.
- A retired item cannot be borrowed.
- Staff must resolve any active borrowing transaction before retiring its item.
- Retiring an item preserves its historical records; it does not erase transaction history.

### 5.2 Member Rules

- Each member must have a unique identifier.
- An inactive member cannot borrow items.
- Staff must resolve a member's active borrowing transactions before marking that member inactive.
- Member records and historical transactions must be preserved when a member becomes inactive.

### 5.3 Borrowing and Return Rules

- Staff record borrowing and return transactions.
- The standard borrowing period is 14 calendar days from the borrowing date.
- The due date is the borrowing date plus 14 calendar days.
- Renewals are not supported in Version 1.
- Members may borrow multiple items; no maximum borrowing limit is enforced in Version 1.
- A returned item may be borrowed again if it has not been retired.
- Each transaction must retain its member, item, borrowing date, due date, and actual return date when returned.

### 5.4 Due Dates and Late Fees

- The late fee is ₱5 per overdue calendar day, per item.
- There is no grace period and no fee cap.
- An item becomes overdue on the day after its due date.
- Before the due date, the system shows the number of days remaining.
- On the due date, the system shows "Due today."
- After the due date, the system shows the number of overdue days and the current late fee.
- For a returned item, the final late fee is calculated through the actual return date.
- For an item that has not been returned, the current late fee is calculated through the current calendar date.
- The system calculates and displays late fees but does not process payments.

### 5.5 Record Integrity

- Historical borrowing and return transactions must be preserved.
- Retiring an item or marking a member inactive must not delete their historical transactions.
- Item status and transaction status are distinct: an item can be currently borrowed even when its transaction is overdue.
- Version 1 stores records in memory only. All records are lost when the application closes.