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