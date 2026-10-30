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