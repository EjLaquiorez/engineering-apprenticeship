# Phase 02 Project — Library Management System

We'll build this project incrementally, following your official 16-stage roadmap. I'll act as your engineering mentor: you'll make the design decisions, explain your reasoning, and produce the deliverables. I'll review your work before we move to the next exercise.

Current stage: Stage 01 — Requirements\
Current exercise: Project Exercise 01 — Problem Definition\
Status: Not started

No Java code yet. For now, we're defining what the system must do, whom it serves, and which rules it must follow.

## Stage 01 preview — Requirements

The goal of this stage is to establish what the system should do before deciding how to implement it.

Project Exercise 01 — Problem Definition

Describe the problem, intended users, system goals, scope, constraints, and important business rules. We will finalize the late-fee policy here.

Deliverable: `docs/requirements/problem-definition.md`

Project Exercise 02 — Use Cases

Identify the interactions staff and members need to perform, including the normal flow and relevant alternative or invalid scenarios.

Deliverable: `docs/requirements/use-cases.md`

### Completion criteria

Before Stage 01 is complete, we'll have:

- A clear problem statement and project objective.
- Defined users and their responsibilities.
- Agreed features and explicit exclusions.
- Documented rules for availability, borrowing, returns, due dates, and late fees.
- A reviewed problem-definition document committed to Git.
- A use-case document completed and committed after Exercise 02.

We'll create the folders and files only as we need them, rather than building the entire proposed directory structure upfront.

## Exercise 01 — Part A: Define the problem

Before we write the document, let's make sure the requirements are precise. Here is our working definition based on your project brief.

## Working problem definition

The library needs a reliable way to manage its books and other library items, maintain member records, and track borrowing and return transactions. Manual or disconnected records can make it difficult to determine an item's current availability, identify overdue items, calculate late fees, and review borrowing history.

The proposed Library Management System will centralize these records so library staff can manage library operations and members can find items, check availability, and monitor their own borrowing obligations.

This is our starting draft, not the final document. We still need to agree on the business rules.

### Part B: Decide the late-fee policy

I recommend starting with a simple, predictable rule for our first version.

### Proposed rule: Fixed daily late fee

Suggested starting policy — awaiting your approval

# ₱5 per day

- No late fee if the item is returned on or before its due date.
- The first overdue day is the day after the due date.
- Each overdue calendar day incurs ₱5 per item.
- For returned items, calculate the fee using the actual return date.
- For items still borrowed, calculate the current outstanding fee using today's date.
- No borrowing fee, grace period, or fee cap in the initial version.

For example, if an item is due on October 20 and returned on October 23, the overdue days are October 21, 22, and 23. The late fee is \\(3 \times ₱5 = ₱15\\).

One important design distinction: the late fee belongs to the borrowing transaction, while the item's current availability belongs to the item itself. Returning an item updates its current status, but it must not erase the transaction's borrowing and return history.

### Your first design decision

Do you want to adopt the proposed ₱5 per calendar day, starting the day after the due date, with no grace period or cap, or would you prefer a different policy?

Once we settle this rule, we'll review the remaining requirements together, finalize `problem-definition.md`, and prepare its Git commit using your existing `commit-guide.md` conventions. We won't move to Exercise 02 until Exercise 01 is reviewed and complete.

Great. We'll adopt the simple fixed daily late-fee rule for the first version of the Library Management System.

## Decision recorded — Late-fee policy

Approved business rule

# ₱5 per overdue calendar day

- Start: The calendar day after the due date.
- End: The actual return date for returned items; today for items still borrowed.
- Grace period: None.
- Fee cap: None.
- Borrowing fee: None; only late fees apply.

For example, an item due on October 20 and returned on October 23 incurs a ₱15 late fee. An item returned on its due date incurs ₱0.

This gives us a simple rule to implement and test later. We'll also preserve the original due date and actual return date in each borrowing transaction so the historical fee can be reviewed.

## Exercise 01 — Part C: Confirm the borrowing rules

The late-fee rule is settled. Next, we need to decide how borrowing works so the problem definition describes a consistent system.

Design question 2: How long should a member be allowed to borrow an item?

I suggest 14 calendar days for the initial version. For example, an item borrowed on October 1 would be due on October 15.

1\. Standard borrowing period

7 calendar days

14 calendar days (recommended for our first version)

30 calendar days

Another period — I'll specify it

2\. Should members be allowed to renew borrowed items?

No renewals for now — keep the rules simple

Yes, allow renewals

Confirm borrowing rules

We'll use your decisions to finalize the requirements, then review the complete `problem-definition.md` and its commit before beginning Exercise 02 — Use Cases.

## Stage 01 — Exercise 01: Requirements review

Your borrowing rules are now agreed upon. We'll keep the first version intentionally simple, so you can focus on applying the Phase 02 OOP concepts rather than managing complicated library policies.

### Decisions confirmed so far

Borrowing period

14 calendar days per borrowing transaction.

Renewals

Not allowed in the initial version.

Late fee

₱5 per overdue calendar day, starting the day after the due date. No grace period or fee cap.

Transaction history

Preserve the member, item, borrowing date, due date, and actual return date. Returning an item must not erase its borrowing record.

One detail we'll document explicitly: a borrowing transaction's due date is fixed when the item is borrowed. Because renewals are not allowed, the initial version won't change that date through a renewal operation.

## Part C — Decide what can be borrowed

Next, we need to define which library items members can borrow. This affects how we design `Book`, `Magazine`, and eventually the borrowing transaction.

My recommendation for the initial version is:

- Books and magazines can both be borrowed.
- Each physical library item can have only one active borrowing transaction at a time.
- An item can be borrowed again after it has been returned.
- An overdue item remains borrowed until it is actually returned. Overdue is a condition of the borrowing transaction, not a separate physical-item status.

For example, if a book is due on October 20 but is still with a member on October 23, the book is borrowed and overdue, not available. Its late fee is ₱15 as of October 23.

Your next design decision: Should both books and magazines be borrowable under the same 14-day period and ₱5 daily late-fee rule, or should magazines have different borrowing rules?

I'd recommend using the same rules for both in the first version to keep the design manageable. We will remain in Exercise 01 until the requirements are settled and documented.

Good. We'll apply the same borrowing rules to books and magazines in the initial version. That keeps the business rules consistent while still letting us practice inheritance and polymorphism later.

## Exercise 01 — Part D: Item and borrowing rules

The following decisions are now confirmed:

| Rule                   | Decision                                                                               |
| ---------------------- | -------------------------------------------------------------------------------------- |
| Borrowable items       | Books and magazines                                                                    |
| Loan period            | 14 calendar days                                                                       |
| Late fee               | ₱5 per overdue calendar day                                                            |
| Renewals               | Not allowed                                                                            |
| Simultaneous borrowing | One active transaction per physical item                                               |
| Re-borrowing           | Allowed after the item is returned                                                     |
| Overdue items          | Remain borrowed until actually returned                                                |
| Fee calculation        | Based on the transaction's due date and return date, or today's date if still borrowed |

Important distinction: “Overdue” is not the same as “returned late.” An item can be overdue while still borrowed. Once returned, its transaction retains the dates needed to calculate the final late fee.

## Part E — Define borrowing limits

We have one rule about each item: it can have only one active borrowing transaction at a time. But we haven't decided how many different items one member can borrow simultaneously.

Consider this example: a member borrows one book on Monday and wants to borrow two magazines on Tuesday. Should the system allow it?

My recommendation is to allow members to borrow multiple items, with no maximum borrowing limit in the initial version. This avoids introducing extra rules before we need them.

Which borrowing policy should we use?

No maximum per member in the initial version (recommended)

Maximum of 3 active items per member

Maximum of 5 active items per member

I'll define another limit

Confirm borrowing limit

After this, we'll review member registration and record management, item search and availability, overdue tracking, and what staff and members are allowed to view. Then we'll consolidate the decisions into the problem-definition document for your review and Git commit—without moving to Exercise 02 yet.

## Stage 01 — Exercise 01: Requirements review continues

Confirmed. Members can borrow multiple items, with no maximum number of active borrowings per member in the initial version. Each individual physical item can still have only one active borrowing transaction at a time.

Let's keep reviewing the requirements before drafting the final problem definition.

### Part F — Registration and record management

My recommendation is to keep registration and record management straightforward.

- Members: Staff can register members and update their basic information.
- Library items: Staff can add books and magazines and update their catalog information.
- Unique identification: Each member and each physical library item needs a unique identifier so records cannot be confused when titles or names are similar.
- Historical records: Staff can review past borrowing transactions, including returned items and their final late fees.
- Current records: Staff can see which items are available, borrowed, or overdue, without confusing an item's current status with its borrowing history.

A key design point: two physical copies of the same book title should be treated as two separately identifiable items if the library owns both. That lets the system track each copy's availability and borrowing history accurately.

### Part G — What happens when a record is no longer active?

We need one more rule to protect record accuracy.

Suppose a member leaves the library, or a book is damaged and removed from circulation. If we permanently delete the record, we could lose information needed to understand historical borrowing transactions.

I recommend the following approach:

- Staff can mark a member as inactive instead of permanently deleting the member's record.
- Staff can mark a library item as retired when it is no longer available for borrowing.
- Inactive members cannot start new borrowing transactions.
- Retired items cannot be borrowed again.
- Existing and historical transactions remain available for review.

This introduces a useful distinction between a record's existence and whether it can participate in new transactions.

Your decision: Should we use this deactivate/retire approach to preserve historical records, rather than allowing staff to permanently delete members and items that have borrowing history?

Confirmed. We'll use the deactivate/retire approach to protect historical borrowing records.

## Exercise 01 — Part G decision

- Members: Staff can mark a member inactive. Inactive members cannot borrow new items, but their records and borrowing history remain available.
- Library items: Staff can retire an item. Retired items cannot be borrowed again, but their records and transaction history remain available.
- Record integrity: Deactivating a member or retiring an item does not erase past borrowing transactions.

One important boundary for the initial version: we should prevent a member from becoming inactive or an item from being retired while it still has an active borrowing transaction. Staff must resolve the outstanding borrowing first. This keeps the system's records consistent and avoids creating transactions that cannot be properly completed.

## Part H — Search, visibility, and overdue information

Let's establish what staff and members can see. My recommendation is to keep their permissions separate.

### Library staff

- Search the catalog by title and identify each item's type.
- View current item availability and overdue borrowings.
- Register and manage members and catalog items.
- Record borrowing and return transactions.
- Review transaction history and late fees.

### Library members

- Search by title and identify whether an item is a book or magazine.
- Check whether an item is available.
- View their own borrowed items, due dates, and days remaining.
- View their own applicable late fees.
- They cannot change catalog records or borrowing transactions.

For due-date information, let's use these rules:

- Before the due date, show how many calendar days remain.
- On the due date, show that the item is due today.
- After the due date, show how many days overdue it is.
- After the item is returned, show its return date and final late fee instead of treating it as a current borrowing.

Design question: Do you agree with these visibility and due-date rules? If so, we'll review the remaining scope and constraints, then consolidate everything into the proposed `problem-definition.md` for your review. We will stay in Exercise 01 until you approve the document and its commit.

Excellent. The visibility rules and due-date behavior are now confirmed for the initial version.

## Exercise 01 — Part H decision

Members can see their own borrowing information and late fees, while staff can review borrowing records across the library. Members cannot modify catalog records or transactions.

Due-date information will be presented according to the transaction's current state:

- Not yet due: Display calendar days remaining.
- Due today: Display “Due today.”
- Overdue: Display calendar days overdue and the current late fee.
- Returned: Display the actual return date and final late fee.

We'll calculate the number of days using calendar dates, not elapsed hours. This makes the policy consistent even if an item is borrowed or returned at different times of day.

## Part I — Final scope and constraints

Before I assemble the problem-definition document, let's settle the last few project boundaries.

My recommendations for the initial version are:

| Area             | Proposed scope                                                                                    |
| ---------------- | ------------------------------------------------------------------------------------------------- |
| User interaction | Console-based Java application                                                                    |
| Storage          | In-memory records while the application runs; no database or file persistence yet                 |
| Authentication   | No login system in the initial version; staff and member actions will be separated conceptually   |
| Search           | Search catalog items by title; display item type and availability                                 |
| Item types       | Books and magazines                                                                               |
| Borrowing        | Record borrowing and return dates; 14-calendar-day loan period; no renewals                       |
| Late fees        | ₱5 per overdue calendar day, no grace period or cap                                               |
| Exclusions       | Online reservations, payments, notifications, multiple library branches, and database integration |

Using in-memory records means data will be lost when the application closes. That's acceptable for a first learning project, but we'll explicitly document it as a limitation rather than implying that records are permanently stored.

### Confirm the final scope

1\. Application interface

Console-based Java application (recommended)

Desktop graphical interface

Web application

2\. Data storage

In-memory only; data resets when the application closes (recommended)

Save records to files so they survive restarts

Use a database

3\. User authentication

No login system yet; keep staff and member permissions distinct in the design (recommended)

Implement login and separate access permissions

Confirm scope and prepare draft

Once you've confirmed these choices, I'll consolidate our agreed decisions into the complete `problem-definition.md` draft for your review. We'll check it against the requirements we've established, revise anything necessary, and then prepare the Git commit using your `commit-guide.md` conventions. We will not begin Exercise 02 until this deliverable is approved and committed.

I'll consolidate the decisions into a reviewable `problem-definition.md` draft. This is the document content for your repository—not a claim that I've created or saved a file on your computer.

The draft will capture the system's purpose, users, scope, business rules, record-integrity constraints, and limitations. We'll review it before considering Exercise 01 complete.

# Library Management System — Problem Definition

**Phase:** 02 — Object-Oriented Programming\
**Project:** Library Management System\
**Exercise:** Stage 01, Project Exercise 01 — Problem Definition\
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

## Your review checklist

Before we finalize this document, please check these three details in particular:

1. Due-date calculation: Borrowing date plus 14 calendar days. For example, borrowing on October 1 means the due date is October 15.
2. Deactivation and retirement: Neither is allowed while the member or item has an active borrowing transaction.
3. Storage limitation: All records are lost when the application closes; persistent storage is outside the initial scope.

If the draft looks correct, tell me that you approve it, or point out anything you'd like to change. After approval, we'll inspect `commit-guide.md` for your exact commit conventions, then prepare the Exercise 01 Git commit. We will not begin Exercise 02 yet.