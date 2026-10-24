# Library Management System — Problem Definition

**Phase:** 02 — Object-Oriented Programming  
**Project:** Library Management System  
**Exercise:** Stage 01, Project Exercise 01 — Problem Definition  
**Status:** Draft for review

## 1. Problem Statement

Libraries need an organized and reliable way to maintain catalog records, manage members, and track borrowing and return transactions. Without consistent records, library staff may have difficulty determining item availability, identifying overdue borrowings, calculating late fees, and reviewing transaction history.

The Library Management System will provide a centralized, console-based Java application for managing library items, member records, and borrowing transactions. It will also allow members to search the catalog, check item availability, and review their own borrowing obligations.

The system will prioritize accurate records, clear business rules, and maintainable object-oriented design.

## 2. Project Objectives

The project aims to:

1. Maintain accurate records of library items and registered members.
2. Allow staff to manage books, magazines, and member records.
3. Record borrowing and return transactions with the required dates and relationships.
4. Track item availability and identify overdue borrowings.
5. Calculate late fees consistently according to the defined policy.
6. Allow members to search for items and review their own borrowing information.
7. Preserve historical transaction records when members become inactive or items are retired.
8. Apply object-oriented programming principles, including encapsulation, inheritance, polymorphism, abstraction, and interfaces.

## 3. Intended Users

### 3.1 Library Staff

Library staff are responsible for managing library operations. They should be able to:

- Add and update books and magazines.
- Register members and update member information.
- Mark members as inactive when necessary.
- Retire library items that are no longer available for circulation.
- Search the catalog and review item availability.
- Record borrowing and return transactions.
- Identify overdue items and review applicable late fees.
- Review current and historical borrowing transactions.

### 3.2 Library Members

Library members should be able to:

- Search for library items by title.
- Identify an item's type, such as a book or magazine.
- Check whether an item is available for borrowing.
- View their own currently borrowed items and due dates.
- See the number of calendar days remaining before an item is due.
- Identify overdue items and the number of days they are overdue.
- View applicable late fees for their own borrowing transactions.

Members must not modify catalog records, member records, or borrowing transactions.

## 4. Project Scope

### 4.1 Included Features

The initial version will support:

- Catalog management for books and magazines.
- Member registration and record management.
- Unique identification of members and physical library items.
- Catalog search by title.
- Item availability tracking.
- Borrowing and return transaction recording.
- Due-date calculation.
- Overdue identification.
- Late-fee calculation.
- Current borrowing information and historical transaction review.
- Member deactivation and item retirement while preserving historical records.
- Conceptual separation of staff and member permissions.

### 4.2 Excluded Features

The following are outside the scope of the initial version:

- Database integration.
- Persistent file storage.
- User login and authentication.
- Online reservations.
- Online payments or late-fee payment processing.
- Notifications and reminders.
- Multiple library branches.
- Borrowing renewals.
- Different borrowing periods or late-fee rules for different item types.
- A maximum number of simultaneously borrowed items per member.

These features may be considered in future versions if the project requirements expand.

## 5. Functional Requirements

### 5.1 Catalog Management

The system must allow staff to add and update books and magazines.

Each physical library item must have a unique identifier. Multiple physical copies of the same title must be represented as separate items so that each copy can have its own availability and borrowing history.

The system must support searching for items by title and displaying their type and current availability.

### 5.2 Member Management

The system must allow staff to register members and update their basic information.

Each member must have a unique identifier.

Staff must be able to mark a member as inactive. Inactive members cannot start new borrowing transactions, but their records and historical transactions must remain available for review.

### 5.3 Borrowing and Returns

The system must record each borrowing transaction with the following information:

- The member who borrowed the item.
- The physical library item borrowed.
- The borrowing date.
- The due date.
- The actual return date, once the item is returned.

Books and magazines will follow the same borrowing rules.

Each physical item can have only one active borrowing transaction at a time. An item may be borrowed again after it has been returned.

Members may borrow multiple items simultaneously, with no maximum borrowing limit in the initial version.

The system must preserve historical transactions after an item is returned. Returning an item must not erase its previous borrowing record.

### 5.4 Availability and Overdue Tracking

The system must distinguish an item's current availability from the status of its borrowing transactions.

An item may be:

- **Available:** Eligible to be borrowed, provided the relevant rules are satisfied.
- **Borrowed:** Currently associated with an active borrowing transaction.
- **Retired:** No longer available for borrowing.

An active borrowing transaction may be overdue while the item remains borrowed. Overdue status must not be treated as proof that the item has been returned.

Staff must be able to review overdue borrowings. Members must be able to view the overdue information associated with their own transactions.

### 5.5 Due-Date Information

The system must display due-date information based on calendar dates:

- Before the due date, show the number of calendar days remaining.
- On the due date, indicate that the item is due today.
- After the due date, show the number of calendar days overdue.
- After return, retain the actual return date and final late fee for historical review.

### 5.6 Late-Fee Calculation

The system must calculate late fees according to the business rules in Section 6.

Staff must be able to review applicable late fees for borrowing transactions. Members must be able to view the fees associated with their own transactions.

The initial version will calculate and display fees; it will not process payments.

## 6. Business Rules

### 6.1 Borrowing Period

1. The standard borrowing period is 14 calendar days.
2. The due date is calculated by adding 14 calendar days to the borrowing date.
3. Renewals are not allowed in the initial version.
4. Books and magazines follow the same borrowing period.

### 6.2 Late-Fee Policy

1. The late fee is **₱5 per overdue calendar day per item**.
2. No late fee applies when an item is returned on or before its due date.
3. The first overdue day is the calendar day after the due date.
4. For a returned item, the final late fee is based on the actual return date.
5. For an item that remains borrowed, the current outstanding late fee is calculated through the current calendar date.
6. There is no grace period and no maximum fee cap.
7. No separate borrowing fee applies.

**Example:** If an item is due on October 20 and returned on October 23, it is three calendar days overdue. The late fee is 3 × ₱5 = ₱15.

### 6.3 Item Availability

1. A physical item can have only one active borrowing transaction at a time.
2. An item remains borrowed until its return is recorded.
3. An overdue item is still considered borrowed.
4. A returned item may become available for another borrowing transaction unless it has been retired.
5. Retired items cannot be borrowed again.
6. Each physical copy must be tracked separately.

### 6.4 Member Borrowing Limits

1. Members may borrow multiple items simultaneously.
2. No maximum number of active borrowings per member is enforced in the initial version.
3. Inactive members cannot start new borrowing transactions.

### 6.5 Record Preservation

1. Each member and physical library item must have a unique identifier.
2. Historical borrowing transactions must remain available after an item is returned.
3. Members with borrowing history must be marked inactive rather than permanently deleted.
4. Items with borrowing history must be retired rather than permanently deleted.
5. A member cannot be marked inactive while they have an active borrowing transaction.
6. An item cannot be retired while it has an active borrowing transaction.
7. Outstanding borrowing transactions must be resolved before deactivation or retirement.
8. Transaction history must retain the member, item, borrowing date, due date, and actual return date when applicable.

## 7. Data and Record Accuracy

The system must maintain a clear distinction between current item information and historical borrowing information.

An item's current availability reflects whether it can be borrowed now. A borrowing transaction records a particular borrowing event and its dates, including the actual return date when applicable.

Returning an item updates its current borrowing state but does not erase the transaction. Historical records must remain reviewable even when the associated member is inactive or the item is retired.

Late fees must be derived consistently from the transaction's due date and applicable end date.

## 8. Technical Constraints

1. The application will be developed in Java.
2. The user interface will be console-based.
3. Records will be stored in memory only.
4. Records will be lost when the application closes.
5. No database or persistent file storage will be implemented in the initial version.
6. No authentication system will be implemented initially.
7. Staff and member permissions will be separated conceptually in the design.
8. The project will be developed incrementally, following the official Phase 02 Object-Oriented Programming roadmap.

## 9. Assumptions and Limitations

- The initial system is intended as a learning project, not a production-ready library platform.
- Library staff are assumed to perform authorized administrative actions.
- Member and staff permissions are design concepts rather than security-enforced accounts in the initial version.
- The system uses calendar dates for loan periods, overdue days, and late fees.
- No renewals, borrowing limits per member, or fee caps will be enforced.
- In-memory storage means records will not survive application restarts.
- Only books and magazines are supported in the initial version.

## 10. Expected Outcome

The completed project should demonstrate a working console-based Library Management System that can maintain library catalog and member records, record borrowing and returns, determine availability and overdue status, calculate late fees, and preserve transaction history while the application is running.

The project should also demonstrate the practical application of object-oriented design principles through clearly defined class responsibilities, appropriate relationships, and maintainable code.

---

**End of draft — Stage 01, Project Exercise 01: Problem Definition**