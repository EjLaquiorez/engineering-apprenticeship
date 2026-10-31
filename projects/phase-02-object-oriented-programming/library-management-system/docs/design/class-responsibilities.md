# Class Responsibilities

## 1. Purpose

This document defines the responsibilities of each class in the Library Management System.

Each class should have a clear purpose and should manage only the information and behavior related to that purpose.

The goal is to establish clear separation of responsibilities, reduce unnecessary dependencies, and make the system easier to maintain and extend.

## 2. Identified Classes

The system will initially contain the following classes:

| Class | Classification |
|---|---|
| `Member` | Core domain class |
| `LibraryItem` | Core domain class |
| `BorrowingTransaction` | Core domain class |
| `LateFeeCalculator` | Supporting class |

### 3.1 Member

**Purpose:**

Represents a registered person in the library system.

**Data owned:**
- `memberId`
- `name`
- `status`

**Responsibilities:**
- Maintain its unique member ID.
- Store and manage the member's name.
- Maintain the member's active or inactive status.
- Support status changes when permitted by the system's business rules.

**Responsibility boundaries:**
- Does not manage borrowing transactions.
- Does not calculate late fees.
- Does not manage library item information.

### 3.2 LibraryItem

**Purpose:**

Represents an individual physical book or magazine managed by the library.

**Data owned:**
- `itemId`
- `title`
- `itemType`
- `status`

**Responsibilities:**
- Maintain its unique item ID.
- Store and manage the item's title and type.
- Maintain the item's current status.
- Support status changes when permitted by the system's business rules.

**Responsibility boundaries:**
- Does not manage member information.
- Does not record borrowing transaction history.
- Does not calculate late fees.