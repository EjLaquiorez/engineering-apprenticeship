# Domain Model

## 1. Domain Overview

The Library Management System is designed to help library staff manage library items, registered members, and borrowing transactions.

The system focuses on maintaining accurate records of physical library items, including books and magazines, tracking their availability, and recording borrowing and return activities.

The domain consists of three core concepts:

- **Member** — Represents a registered person who can borrow library items.
- **Library Item** — Represents an individual physical book or magazine managed by the library.
- **Borrowing Transaction** — Represents one borrowing event involving a member and a specific library item.

These concepts work together to support catalog management, member management, borrowing records, return tracking, and overdue fee calculations.

## 2. Core Domain Concepts

### 2.1 Member

Represents a person registered in the library system who is eligible to borrow library items.

**Attributes:**
- `memberId` — Unique identifier assigned to each member.
- `name` — Full name of the registered member.
- `status` — Indicates whether the member is active or inactive.

A member can exist in the system without having any borrowing transactions. An inactive member cannot start new borrowing transactions.

### 2.2 Library Item

Represents an individual physical book or magazine managed by the library.

**Attributes:**
- `itemId` — Unique identifier assigned to each physical library item.
- `title` — Title of the book or magazine.
- `itemType` — Identifies whether the item is a book or magazine.
- `status` — Indicates whether the item is available, borrowed, or retired.

Each physical copy has its own unique identifier, even when multiple copies share the same title.

### 2.3 Borrowing Transaction

Represents one borrowing event involving exactly one member and one physical library item.

**Information associated with the transaction:**
- `borrowDate` — Date the item was borrowed.
- `dueDate` — Date the item must be returned.
- `returnDate` — Actual date the item was returned; remains unset while the item is still borrowed.

Each borrowing transaction preserves its own history. A member borrowing multiple items creates a separate transaction for each item.

Late fees are calculated using the transaction's due date, return date (or current date for an active borrowing), and the applicable late-fee rule. A separate Late Fee domain concept is not required for Version 1.

## 3. Relationships and Cardinalities

### 3.1 Member and Borrowing Transaction

- One member can have zero or many borrowing transactions.
- Each borrowing transaction must belong to exactly one member.

**Cardinality:** Member `1` → Borrowing Transaction `0..*`

### 3.2 Library Item and Borrowing Transaction

- One library item can have zero or many borrowing transactions throughout its lifetime.
- Each borrowing transaction must involve exactly one library item.

**Cardinality:** Library Item `1` → Borrowing Transaction `0..*`

### 3.3 Borrowing Transaction Rules

- Each transaction represents the borrowing of exactly one physical library item.
- A member borrowing multiple items must have a separate transaction for each item.
- A physical library item can have only one active borrowing transaction at a time.
- A new borrowing transaction for an item can only be created after its previous active transaction has been returned and closed.

These relationships preserve borrowing history and allow each item to have its own due date, return date, and late-fee calculation.

## 4. Business Rules

### 4.1 Member Rules

- Every registered member must have a unique member ID.
- A member can have either an active or inactive status.
- Only active members can start new borrowing transactions.
- A member can borrow multiple library items.
- A member cannot be marked inactive while they have active borrowing transactions.

### 4.2 Library Item Rules

- Every physical library item must have a unique item ID.
- Each item must be identified as either a book or a magazine.
- An item can have one of the following statuses:
  - Available
  - Borrowed
  - Retired
- Only available items can be borrowed.
- An item cannot be retired while it has an active borrowing transaction.
- A retired item cannot be borrowed again.
- Multiple physical copies of the same title must have separate item IDs.

### 4.3 Borrowing Transaction Rules

- Each borrowing transaction must involve exactly one member and one physical library item.
- Each borrowing event must have its own transaction record.
- Each item can have only one active borrowing transaction at a time.
- A new transaction for an item can only be created after its previous active transaction has been returned.
- Renewals are not allowed in Version 1.
- Borrowing transactions must preserve historical records, even after an item is returned.

### 4.4 Borrowing Period and Late Fee Rules

- The standard borrowing period is 14 calendar days.
- The due date is calculated by adding 14 calendar days to the borrow date.
- An item becomes overdue starting the calendar day after its due date.
- The late fee is ₱5 per overdue calendar day, per item.
- There is no grace period and no maximum late-fee limit.
- For an active overdue transaction, the fee is calculated through the current calendar date.
- For a returned item, the final fee is calculated through its actual return date.
- No borrowing fee is charged; only late fees apply.

### 4.5 Record Integrity Rules

- Borrowing history must remain available after an item is returned.
- A returned transaction must retain its borrow date, due date, and actual return date.
- An item's current status must be maintained separately from its borrowing history.
- Members and library items must not be permanently deleted when doing so would compromise existing borrowing records.