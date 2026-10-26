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

Great. We'll treat the `problem-definition.md` draft as approved, with the agreed borrowing period, late-fee policy, item rules, record-preservation requirements, and technical constraints.

Our next step is to finalize the deliverable in your repository and prepare its commit. I'll keep us on Stage 01 — Exercise 01; we won't begin Use Cases yet.

## Finalization checklist

- Define the problem and project objectives.
- Identify staff and member responsibilities.
- Agree on the 14-day borrowing period and ₱5 daily late fee.
- Define availability, overdue status, and transaction history.
- Agree on deactivation and retirement rules.
- Confirm console interface, in-memory storage, and no login initially.
- Review and approve the problem-definition draft.
- Save the approved document in the repository.
- Review the changes and commit them.
- Verify Git status and commit history.

## Git workflow — Save and commit Exercise 01

From your repository root:

`C:\Users\ejlqr\Desktop\engineering-apprenticeship`

### 1. Create the file

Create the directory and open the new Markdown file in Git Bash:

```
cd ~/Desktop/engineering-apprenticeship

mkdir -p projects/phase-02-object-oriented-programming/library-management-system/docs/requirements

code projects/phase-02-object-oriented-programming/library-management-system/docs/requirements/problem-definition.md
```

Paste the approved draft into the file and save it with `Ctrl + S`.

### 2. Review your changes

```
git status
git diff --check
git diff -- projects/phase-02-object-oriented-programming/library-management-system/docs/requirements/problem-definition.md
```

Because this is a new, untracked file, `git diff` won't show its contents until you stage it. That's normal.

### 3. Stage and commit

Once you've reviewed the saved file, use this commit message, following your documentation commit convention:

```
git add projects/phase-02-object-oriented-programming/library-management-system/docs/requirements/problem-definition.md

git diff --cached --check

git diff --cached

git commit -m "docs(02-library-management-system): add problem definition"
```

### 4. Verify the commit

```
git status
git log -1 --oneline
```

Ideally, `git status` should show a clean working tree, and the latest commit should display your problem-definition commit.

I haven't executed these commands or modified your local repository. Once you've completed the steps, share the terminal output if you'd like me to review it.

Stage 01 progress: Exercise 01's requirements are approved. We'll mark it complete once the document is saved and the commit is verified. We will not start Exercise 02 until that is done.

# Stage 01 — Requirements

## Exercise 02: Use Cases

We'll continue the Library Management System project using the requirements we already established in Exercise 01.

Our goal: identify what each type of user needs to do with the system, without designing Java classes or writing code yet.

### Roadmap preview

Exercise 01 — Problem Definition

Approved and pushed to `origin/main`

Exercise 02 — Use Cases

Current exercise: identify actors and their goals

Next: Domain Modeling

We'll move forward only after Exercise 02 is reviewed and completed.

## Lesson 1: What is a use case?

A use case describes a goal a user wants to accomplish by interacting with a system.

For example:

- Actor: Staff member
- Goal: Register a new library member
- Use case: Register Member

An actor is a person or external role interacting with the system. A use case describes the goal, not the internal code that implements it.

## Your first task: Identify the actors and use cases

From our approved problem definition, we have two actors:

- Staff — manages library records and borrowing transactions.
- Member — searches the catalog and checks their own borrowing information.

Here are two examples to help you distinguish goals from implementation details:

| Actor  | Goal / use case               |
| ------ | ----------------------------- |
| Staff  | Register a new member         |
| Member | View currently borrowed items |

Notice that “create a `Member` object” is not a use case. That's an implementation detail we'll consider later when we design the Java classes.

### Exercise 02A — Your turn

Without worrying about perfect wording, identify three additional use cases for Staff and three for Members.

Use this template in your reply:

Staff

1. ...
2. ...
3. ...

Member

1. ...
2. ...
3. ...

Use only features included in Exercise 01. I'll review your six answers, explain any corrections, and help you build the complete use-case list before we create `docs/requirements/use-cases.md`.

Remember: you're designing the system, not coding it yet.\

Good start! You're thinking about what each user needs to accomplish. Let's review your answers as your mentor, then refine them using the requirements we approved in Exercise 01.

## Exercise 02A — Review

### Staff

1\. Create new item in the library

Correct. Let's make it more specific: Add Library Item. Staff can add books and magazines.

2\. Manage items

This is valid but too broad for a clear use-case list. Based on our requirements, it could mean:

- Update item details
- Search the catalog and check availability
- Retire a library item

3\. Manage schedules/fee

We haven't defined a scheduling feature. Fees are in scope, though. Consider two separate goals:

- Record a borrowing or return
- Review overdue borrowings and late fees

### Member

1\. Borrow book

Borrowing is a valid goal, but in our current design, staff record borrowing and returns. Members can search the catalog and view their borrowing information. We haven't given members permission to borrow items directly through the system.

2\. Create user

Member registration is a staff responsibility. Members cannot create their own accounts, and the initial system has no login or authentication.

3\. Pay fees

Payment processing is explicitly excluded from the initial project. Members can view their late fees, but they cannot pay through the system.

## Lesson: A use case must match the system's scope

The important distinction is between what a person might do in a real library and what this particular software will support.

For example, a member may physically borrow a book from the library, but in our current requirements, the software records that transaction through the staff workflow. We should not add a member-facing borrowing feature unless we deliberately revise the requirements.

## Exercise 02B — Refine your member use cases

Let's practice making the member goals specific. Choose three use cases that belong to the Member actor and fit our approved requirements.

Member use case 1Choose a use case

Member use case 2Choose a use case

Member use case 3Choose a use case

Submit answers

Choose the three that best match the approved requirements. After reviewing those, we'll do the same for Staff and build the use-case document together.

Good work on Exercise 02B! You correctly identified two member use cases. Let's review the third against our approved project scope.

## Exercise 02B — Review

1\. Search the library catalog

Correct

Members can search by title and see the item type and availability.

2\. View currently borrowed items

Correct

Members can view their borrowed items and relevant due-date information.

3\. Process a fee payment

Out of scope

Payment processing is excluded from the initial version. Members can view their late fees, but the system won't accept or process payments.

### Your next step

Replace use case 3 with Check due dates and overdue fees.

This is a valid member goal because members should be able to see:

- Days remaining until an item's due date.
- Whether an item is overdue and how many days late it is.
- The current late fee, or the final fee after the item is returned.

One important distinction: calculating and displaying a fee is not the same as processing a payment.

Exercise 02B status: 2 of 3 confirmed. Once you confirm the replacement, we'll move on to the Staff use cases.

Excellent! All three Member use cases are now correct and match our approved requirements.

## Exercise 02B — Passed

Member use cases · 3 of 3 confirmed

UC-M01: Search Library Catalog

Search by title and see item type and availability.

UC-M02: View Currently Borrowed Items

See the member's active borrowings and their details.

UC-M03: Check Due Dates and Overdue Fees

See days remaining, overdue days, and applicable late fees.

## Exercise 02C — Staff use cases

Now let's refine the Staff side. Staff have broader responsibilities because they manage library records and borrowing transactions.

Select five use cases that fit our approved requirements.

Staff use case 1Choose a use case

Staff use case 2Choose a use case

Staff use case 3Choose a use case

Staff use case 4Choose a use case

Staff use case 5Choose a use case

Submit Staff use cases

Mentor tip: Choose goals that the system supports, not features that sound useful but were excluded from the initial scope. I'll review your choices and explain any mistakes before we draft `use-cases.md`.

Good effort! You selected three valid Staff use cases, and two that we need to correct based on the approved requirements. Let's review them.

## Exercise 02C — Staff use cases review

1\. Add library items

Correct

Staff can add books and magazines to the catalog.

2\. Update library item details

Correct

Staff can update existing item records.

3\. Register and update members

Correct

Staff can register members and update their records.

4\. Process online fee payments

Out of scope

Our initial system calculates and displays late fees, but payment processing is excluded.

5\. Create member login accounts

Out of scope

Login and authentication are excluded from this version.

You have 3 of 5 correct. The two incorrect choices are useful examples of why we must follow the requirements rather than add features just because a real library might use them.

## Exercise 02C — Revision

Replace use cases 4 and 5 with two supported Staff goals.

Replacement for use case 4Retire library items

Replacement for use case 5Mark members inactive

Submit revisions

After these are confirmed, we'll consolidate the complete use-case list, review any remaining Staff responsibilities, and prepare the requirements document together. We won't move to domain modeling until this exercise is complete.

Good revision! All five use cases are valid and within the approved project scope. ✅

However, we still need to account for two important Staff responsibilities: recording borrowing and returns, and reviewing overdue borrowings and late fees. We'll include those in the full list rather than leave them out.

## Exercise 02C — Passed

## Staff use cases confirmed

Add library items

Update library item details

Register and update members

Retire library items

Mark members inactive

## Exercise 02D — Consolidate the use-case list

Before creating `docs/requirements/use-cases.md`, let's make sure our list covers the entire system.

Here is the proposed consolidated list based on Exercise 01 and your approved answers.

### Staff

| ID     | Use case                                |
| ------ | --------------------------------------- |
| UC-S01 | Add library items                       |
| UC-S02 | Update library item details             |
| UC-S03 | Register and update members             |
| UC-S04 | Retire library items                    |
| UC-S05 | Mark members inactive                   |
| UC-S06 | Record borrowing and returns            |
| UC-S07 | Review overdue borrowings and late fees |
| UC-S08 | Search catalog and check availability   |

### Member

| ID     | Use case                         |
| ------ | -------------------------------- |
| UC-M01 | Search library catalog           |
| UC-M02 | View currently borrowed items    |
| UC-M03 | Check due dates and overdue fees |

### Your design-review task

One important detail: our requirements say that staff cannot mark a member inactive or retire an item while it has an active borrowing transaction. The transaction must be resolved first.

Do you agree that this consolidated list covers the main goals for both actors, or do you think any use case is missing or needs changing?

Once you confirm, we'll draft the use-case document and review it before you commit it to Git.

My recommendation is: let members borrow books and magazines in real life, but have staff record and manage the borrowing transactions in the initial version of our software. We can add member-initiated borrowing later if the project needs it.

Here's why I recommend that approach for your Java apprenticeship project.

## Option comparison

### Option A — Staff-managed borrowing

Recommended

Staff records when a member borrows or returns an item. Members search the catalog and view their own borrowing information.

Advantages: simpler initial scope, clear responsibilities, and a good way to practice encapsulation, interfaces, polymorphism, and class relationships.

### Option B — Members initiate borrowing in the software

Members can request or complete a borrowing action through the system themselves.

Trade-offs: we'd need to define member identification, borrowing eligibility, item availability checks, and how to prevent two members from borrowing the same physical copy. Login and authentication are currently excluded, so we'd need another carefully defined way to identify members—or revise the scope.

## Recommended design for version 1

Let's distinguish the real-world activity from the software use case:

- Member: borrows and returns physical library items through the library's normal process; can search the catalog and view their own borrowing records and fees in the software.
- Staff: records borrowing and returns, manages member and item records, and reviews overdue transactions and fees.
- System: tracks item availability, calculates due dates and late fees, and preserves transaction history.

This keeps the first version achievable without preventing us from extending it later.

## How this affects our use-case list

For the current version, keep these use cases:

| Actor  | Use case                                |
| ------ | --------------------------------------- |
| Staff  | Record borrowing and returns            |
| Staff  | Review overdue borrowings and late fees |
| Member | Search the library catalog              |
| Member | View currently borrowed items           |
| Member | Check due dates and overdue fees        |

We should not add “Borrow Item” as a member software use case yet, because it would contradict our current scope.

One question before we finalize Exercise 02: Are you happy to keep staff-managed borrowing for version 1, with the possibility of adding member-initiated borrowing in a future version?

Let's proceed with Exercise 02E — Document the Use Cases. We'll create `use-cases.md` in sections, review it, then you'll save and commit it to Git. We're still in Stage 01: Requirements; no Java code yet.

## Step 1 — Create the document structure

Create or open this file in VS Code:

`projects/phase-02-object-oriented-programming/library-management-system/docs/requirements/use-cases.md`

If the `requirements` folder already exists, you don't need to create it again.

## Step 2 — Add the first section

Here's the proposed opening section. Review it for accuracy before we move on to the individual use cases.

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

| ID     | Use Case                                | Description                                                  |
| ------ | --------------------------------------- | ------------------------------------------------------------ |
| UC-S01 | Add Library Items                       | Add books and magazines to the catalog.                      |
| UC-S02 | Update Library Item Details             | Update information for existing library items.               |
| UC-S03 | Register and Update Members             | Create member records and update their information.          |
| UC-S04 | Retire Library Items                    | Mark items as retired so they cannot be borrowed again.      |
| UC-S05 | Mark Members Inactive                   | Mark a member as inactive so they cannot borrow items.       |
| UC-S06 | Record Borrowing and Returns            | Record when a member borrows an item or returns it.          |
| UC-S07 | Review Overdue Borrowings and Late Fees | Review overdue transactions and their current or final fees. |
| UC-S08 | Search Catalog and Check Availability   | Search library items and check whether they are available.   |

### Member Use Cases

| ID     | Use Case                         | Description                                                       |
| ------ | -------------------------------- | ----------------------------------------------------------------- |
| UC-M01 | Search Library Catalog           | Search items by title and view their type and availability.       |
| UC-M02 | View Currently Borrowed Items    | View the member's active borrowing transactions and item details. |
| UC-M03 | Check Due Dates and Overdue Fees | View days remaining, overdue days, and applicable late fees.      |

## Step 3 — Review before saving

Please check these three points:

1. Actor permissions: Staff record borrowing and returns; members only view their own borrowing information.
2. Version 1 scope: No login, online payments, or member-initiated borrowing.
3. Data retention: Records are held in memory and lost when the application closes.

If these are accurate, reply “Approve Step 1”. Then we'll add the remaining sections for use-case constraints, shared business rules, and future enhancements before you commit the complete document.

Step 1 approved! ✅ The purpose, scope, actors, and 11 use cases are accepted as our baseline.

## Exercise 02E — Step 2: Constraints and business rules

Next, we'll document the rules that apply across those use cases. These rules matter because they will guide our later domain model and Java class design.

Append the following section to the bottom of `use-cases.md`, after the use-case tables.

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

### Your review task

Before approving Step 2, consider this rule:

A member has an item due on October 20 and returns it on October 23. The system charges for October 21, 22, and 23: 3 overdue days × ₱5 = ₱15.

Does the rule set correctly represent the behavior we agreed on, including charging through the actual return date and preserving transaction history?

Reply “Approve Step 2” if everything is correct, or point out any rule you'd like to revise. We won't move to the final section until you've reviewed it.

Step 2 approved! ✅ The business rules and constraints are now confirmed.

We've documented item availability, member eligibility, borrowing periods, late fees, and historical record preservation. These rules will guide our later class design and testing.

## Exercise 02E — Step 3: Final notes and future enhancements

Append this final section to the bottom of `use-cases.md`.

## 6. Future Enhancements

The following features are excluded from Version 1 but may be considered in future versions:

- Member-initiated borrowing through the system.
- Login and authentication.
- Database or file-based persistence.
- Online reservations.
- Fee payment processing.
- Maximum borrowing limits and renewal rules.
- Notifications for upcoming due dates and overdue items.
- Support for multiple library branches.

These enhancements are not part of the current implementation requirements. Adding them would require reviewing and updating the requirements and design before implementation.

## 7. Completion Criteria

The use-case requirements document is complete when:

- The Staff and Member actors and their responsibilities are clearly defined.
- All 11 use cases have unique identifiers and concise descriptions.
- The use cases match the approved Version 1 scope.
- The business rules and constraints are documented.
- Excluded features and possible future enhancements are identified.
- The document is reviewed, saved, and committed to the project repository.

### Final review

Please confirm these three things:

1. The future enhancements are clearly marked as excluded from Version 1.
2. The completion criteria reflect what we need before moving to the next project stage.
3. No additional use cases or business rules need to be added.

Reply “Approve Step 3” if you're satisfied. After that, we'll consolidate the sections into one complete document, save it, review the Git diff, and commit it before advancing to Stage 02 — Domain Modeling.