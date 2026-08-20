Good. We begin **Phase 00**, and we're going to do it properly.

## PHASE 00 — ENGINEERING ENVIRONMENT

```text
Topics
[→] Git fundamentals
[ ] Git repository lifecycle
[ ] Branches
[ ] Merging
[ ] Merge conflicts
[ ] GitHub
[ ] Pull requests
[ ] Terminal fundamentals
[ ] Linux fundamentals
[ ] Maven
[ ] Gradle
[ ] VS Code workflow

Exercises
[→] 00.1 Inspect the environment
[ ] 00.2 Create a Git repository
[ ] 00.3 Commit a project
[ ] 00.4 Create and use branches
[ ] 00.5 Push a branch to GitHub
[ ] 00.6 Open and merge a pull request
[ ] 00.7 Resolve a merge conflict
[ ] 00.8 Terminal navigation
[ ] 00.9 Linux fundamentals
[ ] 00.10 Maven
[ ] 00.11 Gradle
[ ] 00.12 Phase 00 integration

Progress: 0%
Current objective:
Understand Git as a version-control system, not merely a
collection of commands.
```

Your apprenticeship says **concepts before syntax** and **understanding before memorization**. 

So I'm not going to start by saying:

> "Here are 20 Git commands. Memorize them."

We're going to understand the model first.

# Topic 00.1 — What Problem Does Git Solve?

Imagine you're building a Java application.

You have:

```text
Calculator.java
```

You write version 1.

Then you change it.

Then you change it again.

Then you realize:

> "The version from yesterday was better."

Without version control, you might have files like:

```text
Calculator.java
Calculator-final.java
Calculator-final2.java
Calculator-final-really.java
Calculator-final-really-this-time.java
```

That's obviously terrible.

Git solves a fundamental problem:

> **How can we reliably track the evolution of a project over time?**

Git records the history of your project.

Conceptually:

```text
Version 1
   ↓
Version 2
   ↓
Version 3
   ↓
Version 4
```

Each recorded state is called a **commit**.

---

# The First Mental Model

A Git repository has several important concepts.

For now, think about this:

```text
             YOUR PROJECT
                  │
                  ▼
            Working Tree
                  │
              git add
                  │
                  ▼
             Staging Area
                  │
            git commit
                  │
                  ▼
             Git History
```

This is **much more important** than memorizing commands.

Let's break it down.

---

## 1. Working Tree

This is essentially the project you're currently working on.

Suppose you have:

```text
my-project/
├── Main.java
└── README.md
```

You modify `Main.java`.

At this point, you've changed your **working tree**.

Git can see that something changed.

You can ask Git:

```bash
git status
```

and Git tells you about those changes.

---

# 2. Staging Area

Now you execute:

```bash
git add Main.java
```

What happened?

You have **not created a commit yet**.

You've told Git:

> "I want this particular change included in my next commit."

That's the purpose of the staging area.

Think:

```text
Working Tree
     │
     │ git add
     ▼
Staging Area
```

This distinction matters enormously.

You might modify five files:

```text
A.java
B.java
C.java
D.java
E.java
```

But perhaps only want to commit:

```text
A.java
B.java
```

You can stage only those changes.

That's one reason the staging area exists.

---

# 3. Commit

Then:

```bash
git commit -m "Add calculator input"
```

Now Git creates a recorded point in the project's history.

Conceptually:

```text
Working Tree
     ↓
Staging Area
     ↓
   Commit
     ↓
Git History
```

A commit is not simply:

> "I saved my file."

Your editor already saves files.

A commit means something closer to:

> **"Record this particular state/change as part of the project's version history."**

That's a much better mental model.

---

# Your First Test

Don't run commands yet.

I want to test your understanding.

### Scenario

You have:

```text
Main.java
```

You modify it.

Then you run:

```bash
git status
```

### Question 1

Where is the modification currently?

**A.** Staging area
**B.** Working tree
**C.** Git history
**D.** GitHub

---

### Question 2

You then run:

```bash
git add Main.java
```

Where is the change now?

**A.** Working tree only
**B.** Staging area
**C.** Git history
**D.** GitHub

---

### Question 3

You then run:

```bash
git commit -m "Update Main"
```

Where is the change now?

**A.** Staging area only
**B.** Working tree only
**C.** Git history
**D.** GitHub

---

### Question 4 — More important

Suppose you run:

```bash
git add Main.java
```

Then **before committing**, you modify `Main.java` again.

What do you think happens?

Don't Google it.

Think about the model we've just established.

**Answer these four questions in your own words.**

I will critique your reasoning rather than simply mark the answers right or wrong.
