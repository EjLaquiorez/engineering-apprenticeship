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