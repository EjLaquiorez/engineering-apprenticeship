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

Step 3 approved! ✅ That completes the content review for Exercise 02 — Use Cases.

Before moving on, we need to consolidate the three approved sections into one complete file and commit it to Git, just as we did for Exercise 01.

## Step 4 — Consolidate and save `use-cases.md`

Your destination file is:

`projects/phase-02-object-oriented-programming/library-management-system/docs/requirements/use-cases.md`

Make sure the file contains all three approved sections:

- Step 1: Purpose, scope, actors, and 11 use cases.
- Step 2: Constraints, business rules, and record integrity.
- Step 3: Future enhancements and completion criteria.

You can keep the three sections in the same Markdown file, in that order. Don't create separate files for each step.

## Step 5 — Review and commit

From Git Bash, run these commands from your repository root:

```
cd ~/Desktop/engineering-apprenticeship

git status
git diff --check
```

If the file is new and untracked, stage it before reviewing the complete diff:

```
git add projects/phase-02-object-oriented-programming/library-management-system/docs/requirements/use-cases.md

git diff --cached --check
git diff --cached
```

Read the staged diff and confirm that all approved sections are present. Then commit:

```
git commit -m "docs(02-library-management-system): define use cases"
git push origin main
```

Finally, verify:

```
git status
git log -1 --oneline
```

## Current project progress

Exercise 01 — Problem Definition

Approved and pushed · Commit `a1161a7`

Exercise 02 — Use Cases

Content approved · Save and Git verification pending

Stage 02 — Domain Modeling

Not started; we'll begin after Exercise 02 is committed and verified.

Your next action: save the complete file, then share the output of `git status` and `git log -1 --oneline`. I'll verify the result before we proceed.

Excellent! ✅ Your latest commit confirms that Exercise 02 has been committed and pushed to `origin/main`.

## Exercise 02 — Use Cases

Commit and push verified

Commit: `be5de5e`

`docs(02-library-management-system): define use cases`

Completed

- Purpose, scope, and actors documented.
- All 11 use cases defined.
- Business rules and constraints documented.
- Future enhancements identified.
- Commit exists on both `main` and `origin/main`.

One detail: your output verifies the commit and remote tracking, but doesn't confirm whether your working tree is clean. You can check that with `git status` when convenient.

## Project roadmap progress

Stage 01 — Requirements

Exercises 01 and 02 completed

### 2/2

Stage 02 — Domain Modeling

Next: identify the important domain concepts and their relationships.

## Next: Stage 02 — Domain Modeling

We'll begin by identifying the real-world concepts our library system needs to represent, such as library items, members, and borrowing transactions.

We'll start with concepts, not Java classes. I'll guide you through the reasoning, and we'll review your answers before creating `docs/design/domain-model.md`.

Ready to begin Stage 02, Exercise 03 — Identify Domain Concepts?

# Stage 02 — Domain Modeling

## Exercise 03: Identify Domain Concepts

Welcome to Stage 02 of your Library Management System project! We've completed the requirements and use cases, so now we'll identify the important concepts our software needs to represent.

Remember our apprenticeship rule: you do the thinking; I'll guide you, review your answers, and explain mistakes before we move forward. No Java code yet.

## 1. Roadmap preview

Stage 01 — Requirements

Completed · Exercises 01–02

Stage 02 — Domain Modeling

Current stage · Exercise 03

1. Identify domain concepts — today's task
2. Determine the information each concept needs
3. Identify relationships between concepts
4. Review and document the domain model

## 2. Lesson: What is a domain concept?

A domain concept is an important thing, person, event, or idea in the real-world problem our software solves.

For example, consider this requirement:

> A library member borrows a book, and the system records the borrowing date and due date.

Possible domain concepts include:

- Member — the person borrowing an item.
- Book — a type of library item.
- Borrowing transaction — the record of an item being borrowed.

Notice that a borrowing transaction is not a physical object, but it is still an important concept because the system must track it.

Also, don't confuse a domain concept with a programming detail. A `for` loop or an array is an implementation choice, not a core library domain concept.

## 3. Exercise 03A — Identify the concepts

Based on our approved requirements, think about what the system must keep track of.

Here are three questions to guide you:

1. What things does the library manage in its catalog?
2. What information must the library keep about people who use the library?
3. What record must exist to track which person borrowed which item, when it was borrowed, and when it should be returned?

Your task: list the domain concepts you think we need for Version 1. Aim for around 5–8 concepts to start.

Use this format:

1. Concept name — why the system needs it.
2. Concept name — why the system needs it.
3. Continue with your ideas.

Don't worry about getting everything right on your first attempt. I'll review your choices and help you distinguish essential domain concepts from attributes, statuses, and implementation details.

Absolutely. Let's slow down and work through the reasoning together. You don't need to guess the right answers — I want you to learn how to discover domain concepts from requirements so you can do it independently in future projects.

## 1. The technique: Find the important nouns

A useful starting point is to read a requirement and ask:

- Who is involved?
- What thing is being managed?
- What event or activity must be recorded?
- What information must the system remember?

Let's use a requirement from your library project.

Example requirement

"A library member borrows a book. The system records the borrowing date, due date, and return date."

Step 1: Find the nouns

Member · Book · Borrowing date · Due date · Return date

Step 2: Ask what each noun represents

- Member: a person the library keeps a record of.
- Book: an item the library manages.
- Borrowing date, due date, return date: information about a borrowing event.

Step 3: Identify the concepts

- Member — the system needs to identify who borrowed an item.
- Library Item — the system needs to identify which physical item was borrowed.
- Borrowing Transaction — the system needs to record the borrowing event and its dates.

Notice something important: the dates are attributes of a borrowing transaction, not necessarily separate domain concepts. Finding nouns is a starting point, not a rule that every noun must become a concept.

## 2. Use these four questions for your project

A. Who does the system keep records about?

Think about the people involved in the library. What information does the system need to remember about them?

B. What does the library manage?

Think about the things in the catalog. What must the system identify and track availability for?

C. What activities must the system remember?

If an item is borrowed and returned, what record would let staff know who borrowed it, which item was involved, and when it was due?

D. What must the system calculate or track?

Think about what happens when an item is returned late. What information must be tracked, and what value must be calculated?

## 3. Your turn — one concept at a time

Let's start with question A only. We won't tackle all four at once.

Imagine a new person joins the library. Staff registers that person, and later the system must show the person's borrowing history.

## Exercise 03A — Question 1

What would you call the concept representing that person, and why does the system need it?

Concept name

Purpose

Submit answer

Tip: Your concept name should describe what the thing is, while its purpose explains why the system needs to represent it. Don't worry about technical terms or perfect wording yet.

Correct! ✅ You've identified the right concept and its purpose.

## Exercise 03A — Question 2 Review

### Library Item

Correct

Your purpose: “The system needs to identify the items inside the library and their status.”

Exactly! `Library Item` is a good general concept because it can represent both books and magazines.

A stronger explanation:

The system needs to uniquely identify each physical library item, track its details and availability, and determine whether it can be borrowed.

### Mentor insight

Remember our example of two copies of Clean Code? Each physical copy needs its own unique ID. Even if both copies share the same title and author, their availability can differ.

Also, availability is information about the item, not necessarily a separate domain concept. We'll examine attributes and statuses in a later exercise.

## Question 3 — What records the borrowing event?

Imagine this sequence:

1. Member `M001` borrows library item `I015`.
2. The borrowing date is October 10.
3. The due date is October 24.
4. The item is returned on October 27.

Later, staff need to know who borrowed the item, which item was borrowed, and whether it was returned late.

Your turn: What domain concept should represent this event, and why does the system need it?

Use this format:

- Concept name: ...
- Purpose: The system needs this concept because ...

Hint: The member and library item already exist as concepts. We need something that connects them and records the dates of the event.
First, your corrected answer is right:

- Concept name: Borrowing Transaction
- Purpose: The system needs to record the borrowing event and its dates.

And I want you to pay attention to something: you arrived at the correct answer after we broke the problem down together. That's progress.

About what you shared: I think you've identified a real learning gap, and we should adjust our apprenticeship to address it rather than simply push you through the exercises.

You're not expected to invent good software designs from nothing. Software engineers build their reasoning from requirements, examples, established patterns, and practice. Experience gives you more patterns to recognize; it doesn't magically make ideas appear.

Right now, you're learning Java and also learning how to think about software problems. Those are two different skills, and we're asking you to develop both. It's completely reasonable to need more guidance on the second one.

## 1. Let's give you a method you can reuse

Instead of staring at a blank page and trying to invent concepts, use this process every time you start a software project.

## 1

Understand the problem

Ask: What is the software supposed to help people do?

Our example: A library needs to track books, members, and borrowing.

## 2

Identify the actors

Ask: Who interacts with the system?

Our example: Staff and Member.

## 3

Identify the actions and events

Ask: What do people do, and what happens that the system must keep track of?

Our example: Register a member, add an item, borrow an item, return an item.

## 4

Identify the domain concepts

Ask: What things, people, and records must the software represent to support those actions?

Our example: Member, Library Item, Borrowing Transaction.

## 5

Explain why each concept exists

Use the sentence: “The system needs this concept because…”

If you can't explain its purpose, investigate it before deciding whether it belongs in your model.

This is a starting framework, not a rigid formula. Sometimes you discover a missing concept while examining the rules or relationships. That's normal.

## 2. Understand the difference between the terms

These ideas are related, but they answer different questions.

### Use case

What does a user want to accomplish?

Example: Record a book return.

### Actor

Who interacts with the system?

Example: Staff.

### Domain concept

What important thing or record does the system need to represent?

Example: Borrowing Transaction.

### Attribute

What information describes a concept?

Example: A transaction's borrowing date and due date.

You don't need to memorize every definition today. You need practice recognizing which question you're answering.

## 3. Let's use a worked example before asking you to think independently

Imagine a small expense-tracking application. A user records that they spent ₱150 on lunch on October 27.

Here's how an engineer might reason about it:

| Question                        | Reasoning                                                           |
| ------------------------------- | ------------------------------------------------------------------- |
| What does the user want to do?  | Record an expense.                                                  |
| Who does it?                    | User.                                                               |
| What must the system represent? | An Expense record.                                                  |
| Why?                            | To keep track of the amount, date, and description of each expense. |
| What information describes it?  | Amount, date, description.                                          |

Notice that the engineer didn't invent the concept out of thin air. The need to record a specific spending event suggested the concept.

Now apply the same reasoning to your library project. You've already identified three concepts:

- Member — identifies the person associated with a borrowing.
- Library Item — identifies the physical item and its status.
- Borrowing Transaction — records the borrowing event and its dates.

Those are three legitimate domain concepts. You're building a foundation.

## 4. Let's continue with guided practice

For now, I won't ask you to generate another concept entirely on your own. I'll give you a scenario and help you reason through it.

Imagine staff adds a magazine to the library. The system needs to record its title and item type. Later, staff retires that magazine, but the historical borrowing records must remain intact.

Which question would help you discover whether something is a domain concept?

Choose the strongest starting question.

A. What Java class name sounds good for the magazine?

B. What information and behavior must the system represent to manage this magazine throughout its lifecycle?

C. Which Java data structure should store all the magazines?

Check my answer

We'll build your confidence through this sequence: worked examples → guided reasoning → partially independent practice → independent practice. We won't rush you to the last step before you're ready.

And we'll continue using the actual requirements of your Library Management System as our reference, so you always have a concrete basis for your decisions.&#x20;

Correct! ✅ B is the strongest answer.

You chose to understand what the system needs to represent before deciding how to implement it. That's an important software-engineering habit.

## Why B is correct

> What information and behavior must the system represent to manage this magazine throughout its lifecycle?

Let's apply that question to our library project.

Scenario: A magazine is added

The system needs to identify the physical magazine, record its title and type, and track whether it's available, borrowed, or retired.

Our reasoning

These requirements point toward the existing domain concept Library Item. We don't need to invent a separate concept just because this particular item is a magazine.

What comes later

When we design Java classes, we'll decide how `LibraryItem`, `Book`, and `Magazine` should be represented. We don't need to settle that implementation question during this exercise.

## Next: Learn how to recognize a missing concept

Here's a useful clue: sometimes the business rules reveal concepts that a list of nouns doesn't make obvious.

Consider this rule from our requirements:

> The system charges ₱5 for each overdue calendar day, per item.

Rather than guessing a concept name, let's reason through what the system must do.

Imagine two members return their items late. The system needs to calculate each item's fee, and staff needs to review overdue transactions.

Which piece of information is most important for calculating the fee correctly?

The member's name only

The number of overdue days for each borrowing transaction

The total number of books in the library

Check my answer

Don't worry about finding a new domain concept yet. First, identify the information the system needs. We'll use that answer to decide what belongs in the domain model.

Exactly right. Your reasoning is correct: the `Borrowing Transaction` already contains the information needed to calculate the late fee.

You identified an important domain-modeling principle: don't create a separate concept when an existing concept can already represent the information and responsibility.

## Why your reasoning works

### Borrowing Transaction

Stores:

- Borrow date
- Due date
- Actual return date, if returned

### Calculated information

- Overdue days
- Late fee

For example, if the due date is October 20 and the item is returned on October 23, the transaction provides the dates needed to calculate a late fee of ₱15.

One important distinction: we might eventually create a `LateFeeCalculator` class or method, but that doesn't automatically mean `Late Fee` must be a separate domain concept. We'll make those design decisions later, when we reach class design.

## Exercise 03A — Review

You've now identified three core domain concepts:

| Concept                 | Purpose                                                                                            |
| ----------------------- | -------------------------------------------------------------------------------------------------- |
| `Member`                | Identifies a library member and connects them to their borrowing history.                          |
| `Library Item`          | Represents each physical book or magazine and its current status.                                  |
| `Borrowing Transaction` | Records a borrowing event, its dates, and information needed to determine overdue status and fees. |

These are good initial concepts for our system. We haven't finalized the entire domain model yet.

## Exercise 03B — Distinguish concepts from attributes

Let's practice one more skill before moving forward.

The system needs to identify each member. Each member has a unique ID, a name, and a status such as active or inactive.

Which option best describes `member ID`, `name`, and `status`?

Choose one answer.

A. Three separate domain concepts

B. Attributes that describe the `Member` concept

C. Three use cases that the member can perform

Submit answer

Take your time. The goal is to learn how to recognize the difference between the thing the system represents and the information that describes that thing.

Correct! B. Attributes that describe the `Member` concept.

You're applying the distinction correctly.

- Domain concept: `Member` — the person represented in the system.
- Attributes: `memberId`, `name`, and `status` — information that describes that member.
- Use cases: Actions such as `Register Member` or `Update Member Details`.

For example, imagine this member record:

| Attribute  | Example value |
| ---------- | ------------- |
| `memberId` | M001          |
| `name`     | Maria Santos  |
| `status`   | Active        |

These values describe one `Member`. They don't need to become three separate domain concepts.

## Exercise 03C — Identify another concept or attribute

Let's use a situation from your actual project.

A member borrows a book. The system records the borrowing date, due date, and actual return date. The system must also preserve this information after the book is returned.

Which is the best way to model this information at the domain-concept level?

A. Create separate domain concepts for borrow date, due date, and return date.

B. Treat `Borrowing Transaction` as a domain concept and its dates as attributes.

C. Store all dates as attributes of `Library Item`, because the book is being borrowed.

Submit answer

Hint: Ask yourself, what event must the system remember, and which information describes that event?

Correct! B. Treat `Borrowing Transaction` as a domain concept and its dates as attributes.

You're getting the hang of identifying concepts versus attributes. Let's look at why this matters for our Library Management System.

## Why B is the best choice

A `Borrowing Transaction` represents an event that the system must remember, even after the book is returned.

## Borrowing Transaction

Example record

Member

Maria Santos

Library item

Clean Code

Borrow date

October 1

Due date

October 15

Return date

October 18

The transaction preserves the borrowing history and supports a late-fee calculation.

Why not put all those dates in `Library Item`? Because the same physical book can be borrowed many times. If the book itself stored just one borrow date and one return date, a new borrowing could overwrite the previous transaction's history.

That's an important design insight: the item and the borrowing event are different concepts.

## Exercise 03 — Progress review

So far, we've identified these core concepts and their purposes:

| Domain concept          | What it represents                                 |
| ----------------------- | -------------------------------------------------- |
| `Member`                | A person registered in the library system          |
| `Library Item`          | A physical book or magazine managed by the library |
| `Borrowing Transaction` | A borrowing event and its historical dates         |

We've also learned that:

- IDs, names, and statuses are attributes.
- Transaction dates are attributes.
- Overdue days and late fees can be calculated from transaction dates.
- One physical item can have many borrowing transactions over time.

These are strong foundations. We still need to examine whether any additional concepts are necessary before finalizing the domain model.

## Next: Exercise 03D — Discover a missing concept

Consider this requirement from our project:

> Staff can register new members, update member details, and mark members inactive. The system must preserve borrowing history and must not allow a member to be marked inactive while they still have an active borrowing transaction.

Question: Based on this requirement, do we need a separate `Staff` domain concept just because staff members perform these actions, or can we represent the staff role without creating a `Staff` concept in our initial domain model?

Think about the distinction between an actor (who interacts with the system) and a domain concept (what the system needs to represent and track). You don't have to guess; explain your reasoning.

That's a good question. Let's pause the exercise for a moment because understanding domain will make the rest of our Library Management System project much easier.

## 1. What is a domain in software engineering?

A domain is the real-world area or problem that your software is designed to handle.

Think of it as the subject matter of your application.

For example:

[CERN Library's Renovation Works will start in September | SCE](https://images.openai.com/static-rsc-4/4rskGvbPgs-jU1__AwQR0hLwwcSRGswg22JCE7KClx0VfH5JzzvyGINxLFH2RFFcQ_ThqEjlm2CARrcXmrW-x-au1onL_RRMz_QTBt9XDa3FD4bg5fHdyy0TlR_USIWCiJR1GigJqoy1FOXfKA-w6Vjv2PiP4b-SDRESMJIjvhc?purpose=inline)

Library Management System

Domain: Library management

The system deals with members, books, borrowing, returns, and late fees.

[Young kitcheners are taking order from waiter](https://images.openai.com/static-rsc-4/WEpVcun9x1Fmz5v68pmPCJqocLDeqQnBDTZg2ENTxw4ZQmB2_LkvPIR80giRe9UvzUVf0ulgC8Xod_aD3vhcLOVqSuwgP1ULigyHl6wop5H3CVNGKLmfYZesGQfnu7vDopyYuJiF7sl17Gy1AhHvJeiIblVbpcb8yKc2kqehdw5pmUk0QNTcYj84oeyPc5TN?purpose=inline)

Restaurant Ordering System

Domain: Restaurant operations

The system deals with customers, menus, orders, and payments.

[Doctor talking with a senior patient at the hospital reception](https://images.openai.com/static-rsc-4/8XvdRZ4ofnkvURc6UuHlUgi-DB9tz6cHNXWGTNCazOkz08wQYSJowVO57O2xisVlLQjJzEO7LoBIq6yjkImBjNai4LMxFzvvfh1jClZdiKeBJtFAtrMu1Y0Y_VePoYbreedNjxPozH_bez21c3dW1KP0kl4qoT__Sbr8ijmEpiGL9uuwShFJmgYy4GUwT6aW?purpose=inline)

Hospital Management System

Domain: Healthcare operations

The system deals with patients, appointments, healthcare providers, and medical records.

The domain tells us what problem we're solving and what real-world rules we need to understand.

## 2. How does a domain connect to concepts?

Let's narrow this down using our library project.

## Domain

Library Management

Important things the system must represent

Member

Library Item

Borrowing Transaction

Attributes and rules

Member ID · Item status · Due date · 14-day borrowing period · ₱5 per overdue day

Here's the relationship:

- Domain: The area we're working in — library management.
- Domain concept: An important person, thing, or event in that area — `Member`, `Library Item`, `Borrowing Transaction`.
- Attribute: Information describing a concept — a member's name or a transaction's due date.
- Business rule: A rule the system must follow — borrowing lasts 14 calendar days.

These are different levels of thinking, and it's normal for them to feel confusing at first.

## 3. Why do we need domain modeling before writing Java?

Imagine we immediately started coding and created a `Book` class with a borrow date and return date.

Later, we discover that the same physical book can be borrowed 20 different times. Where would we preserve all 20 borrowing histories?

That question reveals a design problem. We need to represent the book itself separately from each borrowing transaction.

Domain modeling helps us understand the real-world problem first, so our Java classes reflect the problem instead of being invented randomly.

## Let's check your understanding

No coding needed. Just choose the best answer.

Our Library Management System has a domain of library management. Which option is a domain concept?

A. The entire library management problem

B. `Member`, which represents a person registered with the library

C. The member's name, such as Maria Santos

Submit answer

Once this distinction is clear, we'll return to our question about `Staff`. We'll keep building your understanding one small step at a time.

Not quite, but this is a useful mistake to learn from. Let's distinguish the two ideas.

A. The entire library management problem describes the domain, not a domain concept.

B. `Member` is the correct answer because it represents a specific person or entity the system needs to keep track of.

Think of it this way:

| Level          | Library example                  |
| -------------- | -------------------------------- |
| Domain         | Library management               |
| Domain concept | `Member`                         |
| Attribute      | Member's name                    |
| Business rule  | Borrowing lasts 14 calendar days |

Here's a simple analogy: if the domain is a whole library, a member is one of the important things within that domain, and the member's name describes that member.

The key distinction: The domain is the whole problem area; a domain concept is one important thing within that area.

Let's check the distinction once more with a different example.

A restaurant ordering system manages customers, food orders, and payments. Which one is the domain?

A. Customer

B. Customer's name

C. Restaurant operations and ordering

Submit answer

Take your time. We're building the foundation before continuing with the project.

Correct! C. Restaurant operations and ordering is the domain. ✅

You're getting the distinction now.

- Domain: Restaurant operations and ordering — the overall problem area.
- Domain concept: `Customer` — an important entity within that area.
- Attribute: Customer's name — information describing that entity.

## Let's return to our Library Management System

So far, we've identified three core domain concepts:

- `Member`
- `Library Item`
- `Borrowing Transaction`

Now let's revisit the question we paused earlier.

Staff members can register library members, update their information, and record borrowing and returns. Remember, our Version 1 does not include login or authentication, and staff actions are represented as use cases.

Do we need a separate `Staff` domain concept in our initial domain model?

My hint: just because someone interacts with the software doesn't automatically mean the software needs to store information about that person as a domain concept.

What do you think, and why?

Absolutely. Let's slow down and approach this differently. You don't need to figure everything out from intuition. There is a repeatable process you can follow to decide whether something should be a domain concept.

The confusion is understandable because `Staff` really is part of library management. The question isn't whether staff exists in the domain. The question is whether our software needs to represent staff as a concept.

## 1. Use this three-question method

Whenever you encounter a possible domain concept, ask these questions in order.

## 1

Does the system need to remember information about it?

For example, does it need to store a staff member's ID, name, or employment status?

## 2

Does it have its own identity or lifecycle?

For example, can a member be registered, updated, and marked inactive independently of other members?

## 3

Do the requirements need us to track or manage it?

For example, our requirements explicitly say that the system registers members and preserves borrowing history.

These are guiding questions, not rigid rules. A concept doesn't have to satisfy all three in every design. The important thing is whether representing it helps us meet the requirements.

## 2. Apply the method to our actual project

Let's compare two candidates.

## Candidate A: Member

Strong candidate

- The system stores member information.
- Each member has a unique ID.
- Members can be active or inactive.
- Borrowing transactions must be associated with the member who borrowed the item.

Conclusion: We clearly need a `Member` concept.

## Candidate B: Staff

Needs further justification

- Staff perform actions such as registering members.
- Version 1 does not require staff accounts or login.
- The requirements do not currently require storing staff IDs or names.
- Borrowing transactions do not currently need to record which staff member processed them.

Conclusion: For Version 1, we have no clear requirement that needs a `Staff` concept in the domain model.

See the difference? We aren't saying staff is unimportant. We're checking what the software actually needs to represent.

If a future requirement says, "Record which staff member processed each transaction," we would reconsider `Staff` because the system would now need to identify the staff member associated with that transaction.

## 3. A useful distinction: actor vs. domain concept

These terms answer different questions.

| Term           | Question it answers                      | Our example       |
| -------------- | ---------------------------------------- | ----------------- |
| Actor          | Who interacts with the system?           | Staff             |
| Domain concept | What must the system represent or track? | Member            |
| Attribute      | What information describes a concept?    | Member name       |
| Use case       | What does an actor do with the system?   | Register a member |

An actor can also be a domain concept. For example, if we add staff accounts and audit records, `Staff` may serve both roles. They simply aren't automatically the same thing.

## 4. Let's practice together

I'll give you a situation, and we'll reason through it one step at a time. Don't worry about making a final decision yet.

Our requirements say:

> Every physical book or magazine has a unique item ID. The system tracks its details, availability, and whether it has been retired. A retired item cannot be borrowed again, but its borrowing history must remain available.

Question 1: Does the system need to remember information about each physical library item?

Yes, it needs to track each item.

No, it only needs to know how many items exist.

I'm not sure yet.

Submit answer

We'll use your answer to work through Question 2 together. The goal is for you to understand why a concept belongs in the model, not just memorize a list of classes.

Correct! The system needs to track each physical library item individually. Let's look at why your answer is correct.

Our requirements say each item has a unique ID, its own availability, and a retired status. That means the system needs to distinguish one physical item from another.

For example, the library might own two physical copies of Clean Code:

| Information | Copy 1     | Copy 2     |
| ----------- | ---------- | ---------- |
| Item ID     | I001       | I002       |
| Title       | Clean Code | Clean Code |
| Status      | Available  | Borrowed   |

Even though the title is the same, the copies have different IDs and statuses.

Our conclusion: `Library Item` is a strong domain concept because the system must identify and manage each physical item separately.

## Question 2: Does it have its own identity or lifecycle?

Think about Copy 1. Over time, it might be:

Available → Borrowed → Available → Retired

It has its own identity (I001), and its status changes over time.

Does that give us a good reason to model `Library Item` as a domain concept?

Yes, because each item has its own ID and its status changes over time.

No, because all physical copies with the same title should be treated as one item.

I'm still unsure; I need another example.

Submit answer

Take your time. We're building the reasoning step by step.

Correct! Yes — `Library Item` should be a domain concept.

You gave the two important reasons:

- Each physical item has its own identity through its unique ID.
- Each item has a lifecycle: it can be available, borrowed, returned to availability, and eventually retired.

You're not just guessing anymore; you're using the requirements to justify a design decision.

## Question 3: Does the requirement need us to track or manage it?

Let's compare two examples from our project.

Example A — Library Item

The system must store each item's ID, title, type, and status. It must prevent retired items from being borrowed.

The system clearly needs to track and manage this.

Example B — Staff

Staff use the application to register members and record returns. But Version 1 doesn't need staff accounts, staff IDs, or staff details.

The system currently needs staff to perform actions, but doesn't need to track staff as data.

Now connect this to your earlier question about `Staff`.

Which candidate does the system clearly need to represent and manage as a domain concept under our current requirements?

A. `Library Item`, because the system must identify, track, and manage each physical item.

B. `Staff`, because staff members perform actions in the system.

C. Both are automatically required because both exist in the library domain.

Submit answer

After this, we'll apply the same reasoning to the remaining concepts and decide whether our initial domain model is complete enough to document.

Correct! A. `Library Item` is clearly a domain concept we need.

Your reasoning is now following a useful pattern:

1. The requirements say the system must track each physical item.
2. Each item has a unique ID and its own status.
3. The system must manage its lifecycle, including retirement.
4. Therefore, `Library Item` belongs in our domain model.

Notice that you justified your answer using the requirements, not just because books exist in a library. That's the habit we're building.

## Let's apply the same reasoning to `Staff`

Here is our current Version 1 requirement:

- Staff can register members and record borrowing and returns.
- The system does not have staff login or accounts.
- The system does not need to store staff names or IDs.
- The system does not need to record which staff member processed each transaction.

So, compare these statements:

- Statement 1: Staff interact with the system.
- Statement 2: The system must store and manage staff information.

In our current requirements, Statement 1 is true, but Statement 2 is not required.

My question for you: Based on that difference, would you include `Staff` as a domain concept in Version 1, or leave it out for now? Explain your answer in one sentence using the requirements as your reason.

Good reasoning! You've made the right decision for Version 1: we don't need `Staff` as a domain concept in our initial model.

Your explanation correctly identifies why `Library Item` belongs in the model. Let's sharpen the reasoning slightly so you can apply it to other concepts.

Your conclusion about `Staff` is based on these requirements:

- Staff can perform actions in the system.
- The system does not currently need to store staff information or identify which staff member performed an action.
- Therefore, we can treat `Staff` as an actor in our use cases without including it as a domain concept for Version 1.

One small correction: `Library Item` isn't the only domain concept we need. We've already identified `Member` and `Borrowing Transaction` too.

## Exercise 03A — Your initial domain concepts

1\. Member

Identifies a registered library member and connects them to their borrowing history.

2\. Library Item

Identifies and manages each physical book or magazine, including its status and lifecycle.

3\. Borrowing Transaction

Records which member borrowed which item, along with the borrowing, due, and return dates.

These are our three initial core domain concepts, not yet the final model. We'll check whether they cover the requirements before documenting the model.

## Next step — Exercise 03D: Check for missing concepts

We have one more important question to explore.

Our system must preserve borrowing history. A member can borrow multiple items, and the same physical item can be borrowed by different members at different times.

Why can't we simply store a `borrowed` status on `Member` and `Library Item` and rely on those two concepts alone?

Think about what happens when an item is returned and borrowed again. What information might we lose if we don't represent each borrowing event separately?

Take your time. This question will help us confirm why `Borrowing Transaction` is necessary before we finalize the domain model.

You're on the right track! Your idea of keeping records clearly and accurately is correct. Let's build on it together. You don't need to know the complete answer immediately.

## Let's walk through an example

Imagine the library has one physical copy of Clean Code, with item ID `I001`.

First borrowing

Member: Maria

- Borrowed: October 1
- Due date: October 15
- Returned: October 18
- Late fee: ₱15

Second borrowing

Member: John

- Borrowed: October 22
- Due date: November 5
- Returned: Not yet returned

Notice that the same physical item was borrowed twice, by two different members.

Now, let's think about the information the system needs to keep.

- Library Item tells us which physical book it is and its current status.
- Member tells us who the registered borrower is and their information.
- Borrowing Transaction records each separate borrowing event, including its dates and eventual late fee.

If we only updated the book's status from `Borrowed` to `Available` and back to `Borrowed`, what would happen to Maria's borrowing dates and her ₱15 late fee when John borrowed the book?

Choose the answer that makes the most sense to you.

A. The system would automatically preserve every borrowing event in the item's current status.

B. The system could lose or overwrite the earlier borrowing details unless it stored each borrowing event separately.

C. The system would no longer need to remember which member borrowed the book.

Check my reasoning

And don't worry about the phrase “borrowing history will repeat.” You're identifying the important idea: the same item can be borrowed repeatedly, so the system needs a separate record for each borrowing event. That's exactly what we're learning to recognize when identifying domain concepts.

Correct! ✅ Exercise 03D is complete.

Your explanation identifies the main reason we need a `Borrowing Transaction`: each time an item is borrowed, the system must preserve that specific event instead of overwriting an earlier record.

## Review: Our three core domain concepts

1\. Member

Represents a registered library member.

Identifies who is borrowing items and connects that person to their borrowing history.

2\. Library Item

Represents one physical book or magazine.

Tracks its identity, details, and current status, such as available, borrowed, or retired.

3\. Borrowing Transaction

Represents one borrowing event.

Records the member, item, borrow date, due date, return date, and information needed to determine the late fee.

These are our initial core concepts. We haven't finalized the domain model yet.

## Stage 02 roadmap — where we are now

Exercise 03A — Identify core concepts

Exercise 03B — Distinguish concepts from attributes

Exercise 03C — Assign borrowing dates to the correct concept

Exercise 03D — Explain why borrowing history needs separate records

Next: Exercise 04 — Identify concept attributes

Determine what information each concept needs to store.

## Exercise 04A — What information does a Member need?

Let's use a worked example before asking you to design anything independently.

Imagine a new member registers at the library. The system needs to identify that member, know whether they can borrow items, and connect them to their borrowing transactions.

Here are four possible pieces of information:

- A. Member ID
- B. Member name
- C. Membership status (active or inactive)
- D. The title of every book in the library

Which pieces of information should belong to the `Member` concept?

Select all that apply.

Member ID

Member name

Membership status

The title of every book in the library

Check my answer

Hint: Ask yourself, “Does this information describe one particular member, or does it describe something else in the library?” 

Excellent! Exercise 04A is correct — A, B, and C. You're applying the distinction between a concept and its attributes correctly.

## Why each choice is correct or incorrect

A. Member ID

Identifies a specific member. Two members might share the same name, but each member needs a unique ID.

Example: `M001`

B. Member name

Stores the member's name so staff can identify them easily.

Example: `Maria Santos`

C. Membership status

Records whether the member is active or inactive. This matters because inactive members cannot start new borrowing transactions under our requirements.

Example: `Active`

D. The title of every book in the library

This describes the library's items, not one particular member. The titles belong with the `Library Item` concept.

## The important distinction

A domain concept represents something important in the library system. An attribute describes that particular thing.

For example:

Concept

## Member

Attributes

memberId

name

status

One useful question to keep asking is: “Does this information describe one instance of this concept?”

For instance, `M001`, `Maria Santos`, and `Active` describe one member. They are not three separate domain concepts.

## Exercise 04B — Library Item attributes

Let's apply the same reasoning to our second concept.

Suppose the library has two physical copies of Clean Code. We need to distinguish them, know what kind of item each is, and track whether each copy can be borrowed.

Which pieces of information should belong to `Library Item`? Select all that apply.

Unique item ID (e.g., I001)

Title (e.g., Clean Code)

Item type (Book or Magazine)

Current item status (Available, Borrowed, or Retired)

Member's membership status (Active or Inactive)

Check my answer

Hint: Imagine looking at one physical copy of a book on a shelf. Which information tells you what that copy is and what its current condition is within the library system?

Correct! Exercise 04B: A, B, C, and D. You're consistently identifying which information belongs to each concept. Let's review why.

## Why your choices are correct

A. Unique item ID

Identifies each physical copy separately.

Example: `I001` and `I002` can represent two copies of Clean Code.

B. Title

Identifies the item's title, such as Clean Code or National Geographic.

C. Item type

Distinguishes books from magazines. Both can be represented by the broader `Library Item` concept.

D. Current item status

Tracks whether a physical item is `Available`, `Borrowed`, or `Retired`.

E. Member's membership status

This belongs to `Member`, not `Library Item`. It describes the member, not the physical item.

## A useful design insight

Notice that current status and borrowing history are different things.

- `Library Item` tells us the item's current status.
- `Borrowing Transaction` preserves the details of each borrowing event.

For example, item `I001` might currently be available, but it could have been borrowed ten times in the past. Its current status alone cannot tell us that history.

## Exercise 04C — Borrowing Transaction attributes

Now let's look at our third concept.

A borrowing transaction must preserve history and help the system calculate late fees. Remember our rule: the borrowing period is 14 calendar days, and the late fee is ₱5 per overdue calendar day.

Which pieces of information should belong to `Borrowing Transaction`? Select all that apply.

Member involved in the borrowing

Library item involved in the borrowing

Borrow date and due date

Actual return date

The member's home address

The item's current status

Check my answer

Hint: Ask yourself, “What must this specific borrowing record remember so that we can identify who borrowed what, when it was due, and whether it was returned late?”

Take your time. We're still doing domain modeling—no Java code yet.

Excellent! Exercise 04C is correct — A, B, C, and D. You're now identifying the attributes of all three core domain concepts. Let's review why each choice belongs there.

## Why your choices are correct

A. Member involved in the borrowing

The transaction must identify who borrowed the item. For example, Maria is the member associated with this transaction.

B. Library item involved in the borrowing

The transaction must identify the exact physical copy borrowed, not just the title.

C. Borrow date and due date

These dates tell us when the borrowing began and when the item should be returned. Our rule sets the due date to 14 calendar days after the borrow date.

D. Actual return date

This records when the item was actually returned. If it hasn't been returned yet, the return date remains unset.

E. Member's home address

This is information about a member, not a borrowing event. Our current requirements don't require storing a home address.

F. Item's current status

This belongs to `Library Item`. The transaction records what happened during one borrowing event; the item records its current status.

## One important distinction: attributes versus relationships

You chose the right information, but there's a subtle modeling detail worth learning now.

A transaction's member and library item are not ordinary text attributes like a name or date. They are relationships to other domain concepts.

### Borrowing Transaction

Information describing the event

- Borrow date
- Due date
- Actual return date

Connected to

Member

Who borrowed it

Library Item

What was borrowed

We can describe the member and item as information associated with a transaction, but later, when we draw our domain model, we'll show these as relationships rather than treating them as plain attributes.

Also, we don't necessarily need to store a separate late-fee attribute. We can calculate the fee from the due date and the actual return date—or today's date for an active overdue transaction—using our ₱5-per-day rule.

## Stage 02 progress

Exercise 03 — Identify core concepts

Exercise 04A — Member attributes

Exercise 04B — Library Item attributes

Exercise 04C — Borrowing Transaction attributes

Next: Exercise 04D — Review our model

Check whether our three concepts and their information cover the requirements before documenting them.

## Exercise 04D — Are we missing anything?

Imagine a member borrows a book, returns it late, and owes ₱15. Staff needs to review the transaction and determine the fee.

We already have `Member`, `Library Item`, and `Borrowing Transaction`.

Question: Based on our current requirements, do we need to introduce a separate `Late Fee` domain concept, or can the system calculate the fee using information already associated with the borrowing transaction?

A. Create a separate `Late Fee` concept because every calculated value must be its own concept.

B. Calculate the fee using the transaction's dates and the late-fee rule; a separate domain concept isn't necessary for Version 1.

C. Store the fee only on `Library Item`, because the item was returned late.

Check my answer

Hint: Think back to your earlier insight: the system already knows the due date, the return date (or today's date), and the fee per overdue day. Does it need another concept to represent the fee, or does it already have enough information to calculate it?

Correct! Exercise 04D: B. You're applying an important software-design principle: don't introduce a separate concept unless the requirements give you a good reason to represent it.

## Why B is correct

Our library system already has the information needed to calculate a late fee:

- Due date: October 15
- Actual return date: October 18
- Late fee: ₱5 per overdue calendar day

The calculation is:

\\[ \text{Late Fee} = \text{Overdue Days} \times ₱5 \\]

\\[ 3 \times ₱5 = ₱15 \\]

We can calculate that fee from the `Borrowing Transaction` and our business rule. We don't need a separate `Late Fee` domain concept just to perform this calculation.

One important distinction: we could later create a `LateFeeCalculator` class to organize the calculation. That would be a design decision, not proof that `Late Fee` must be a separate domain concept.

## Stage 02 — Exercise 04 review

Member

`memberId`, `name`, `status`

Library Item

`itemId`, `title`, `itemType`, `status`

Borrowing Transaction

`member`, `libraryItem`, `borrowDate`, `dueDate`, `returnDate`

Late fee

Calculated using the transaction dates and the ₱5-per-day rule. It doesn't need to be a separate domain concept in Version 1.

These are our provisional concepts and information, not yet the final class design. In particular, `member` and `libraryItem` represent relationships, not simple attributes.

## Next: Exercise 05 — Identify relationships

Before we document the domain model, we need to understand how our concepts connect.

Our roadmap for this next step:

1. Identify how `Member` connects to `Borrowing Transaction`.
2. Identify how `Library Item` connects to `Borrowing Transaction`.
3. Determine whether each concept can be associated with one or many instances of another concept.
4. Review the relationships against our business rules.

Let's begin with a concrete example.

A member named Maria borrows three items during the same week. The system creates a separate borrowing record for each item.

Exercise 05A: How many `Borrowing Transaction` records should be associated with Maria's borrowing activity?

A. One transaction, because Maria is one member.

B. Three transactions, one for each item borrowed.

C. One transaction for the entire library, regardless of how many members borrow items.

Check my answer

Remember the rule we established earlier: each borrowing event needs its own record so that dates, returns, and late fees remain accurate.

Correct! Exercise 05A: B — three borrowing transactions, one for each item borrowed. ✅

You're applying the rule we established earlier: every borrowing event needs its own record.

## Why this relationship works

Imagine Maria borrows three items:

## Member: Maria

One registered member

Has borrowing history recorded through

Transaction 1

Clean Code

Transaction 2

Java Basics

Transaction 3

Magazine

Maria is represented by one `Member` concept, but her borrowing history can contain many `Borrowing Transaction` records.

In domain modeling, we describe this as a one-to-many relationship:

- One member can have many borrowing transactions.
- Each borrowing transaction belongs to one member.

This relationship preserves each item's dates, return information, and late-fee calculation independently.

## Exercise 05B — What about Library Item?

Now let's reverse the perspective.

Suppose the physical copy `I001` of Clean Code is borrowed by Maria, returned, and then borrowed by John a week later.

Should the `Library Item` be associated with one or many `Borrowing Transaction` records over its lifetime?

A. One transaction only, because the physical item has one unique ID.

B. Many transactions over time, because the same physical item can be borrowed repeatedly.

C. No transactions, because the item already has its own status.

Check my answer

Hint: Remember that a unique item ID identifies the physical copy, not a single borrowing event. What happens to that same copy after it is returned and borrowed again?

Correct! Exercise 05B: B — one `Library Item` can be associated with many `Borrowing Transaction` records over time. ✅

You're now seeing both sides of the relationship.

## Why this is a one-to-many relationship

Consider physical item `I001`, a copy of Clean Code.

## Library Item: I001

Clean Code · One physical copy

Borrowing history over its lifetime

Transaction 1

Maria · Borrowed and returned

Transaction 2

John · Borrowed later

The item ID stays `I001` throughout. Each time the item is borrowed, the system creates a new transaction rather than overwriting the previous one.

So we have two one-to-many relationships:

- Member → Borrowing Transaction: one member can have many transactions.
- Library Item → Borrowing Transaction: one item can have many transactions over its lifetime.

An important restriction applies: the same physical item can have only one active borrowing transaction at a time. It cannot be borrowed again until the current transaction is returned and closed.

## Exercise 05C — Can a transaction involve multiple items?

Let's test one more important design decision.

Maria borrows three items at once. Our requirements say that each borrowing event needs its own dates and late-fee calculation.

Should we create:

A. One transaction containing all three items, with one shared due date and return date.

B. Three separate transactions, one per item, so each item has its own due date, return date, and late-fee calculation.

Check my answer

Hint: What if Maria returns two books on time but returns the magazine late? Which design lets the system track that accurately?

Once we finish this, we'll review the complete set of relationships before documenting the domain model.

Correct! Exercise 05C: B — create three separate borrowing transactions, one for each item. ✅

This matches our library system requirements, especially the rules for borrowing history, due dates, returns, and late fees.

## Why separate transactions are better

Suppose Maria borrows two books and one magazine on the same day.

Transaction 1 — Clean Code

Returned on time

Late fee: ₱0

Transaction 2 — Java Basics

Returned on time

Late fee: ₱0

Transaction 3 — Magazine

Returned 3 days late

Late fee: 3 × ₱5 = ₱15

If we used one transaction for all three items, a single return date would not accurately describe when each item was returned. We'd need extra complexity to handle the different dates and fees.

With separate transactions, each item has its own borrowing history. That's simpler and aligns with the requirements we've already established.

## Stage 02 — Exercise 05 review

We have identified these relationships:

| Relationship                         | Rule                                                                                       |
| ------------------------------------ | ------------------------------------------------------------------------------------------ |
| Member → Borrowing Transaction       | One member can have many transactions. Each transaction belongs to one member.             |
| Library Item → Borrowing Transaction | One item can have many transactions over its lifetime. Each transaction involves one item. |
| Borrowing Transaction → Library Item | Each transaction concerns exactly one physical item.                                       |
| Active borrowing                     | A physical item can have only one active borrowing transaction at a time.                  |

These rules describe the relationships between our three core concepts without introducing unnecessary concepts.

## Exercise 05D — Check your understanding

One final question before we document the domain model.

Suppose a member has never borrowed anything yet. Should the system still allow that member to exist in the system?

A. No. A member must have at least one borrowing transaction to be registered.

B. Yes. A member can exist without any borrowing transactions; borrowing is optional for that member.

C. No. Every member must borrow at least one item immediately after registration.

Check my answer

Hint: Our requirements let staff register a member before that member borrows anything. Think about what this means for the minimum number of transactions a member can have.