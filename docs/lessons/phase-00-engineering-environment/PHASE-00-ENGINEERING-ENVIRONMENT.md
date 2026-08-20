# Phase 00 — Engineering Environment

> **Apprenticeship goal:** Work like a developer.

This phase is the foundation of the apprenticeship. Before focusing on Java programming, we will build the habits and tools required to work in a professional development environment.

## Phase Objective

By the end of Phase 00, I should be able to:

- Work comfortably with Git.
- Work with GitHub.
- Use the terminal to navigate and operate on a project.
- Understand the role of Linux in software development.
- Understand how Maven and Gradle manage Java projects.
- Use an IDE effectively without depending on it for basic operations.
- Create branches.
- Make commits with meaningful history.
- Open pull requests.
- Resolve merge conflicts.

The apprenticeship requires evidence before advancing to the next phase. Evidence may include working code, tests, documentation, deployments, architecture diagrams, and debugging explanations. For Phase 00 specifically, the required deliverables include branching, pull requests, and merge-conflict resolution.

---

# 1. Engineering Environment Mental Model

A professional developer does not only write source code.

A typical workflow involves:

```text
Computer
   ↓
Terminal / Shell
   ↓
Project files
   ↓
Git
   ↓
GitHub
   ↓
Build tool
(Maven / Gradle)
   ↓
IDE
   ↓
Application
```

Each tool solves a different problem.

We will learn the tools as engineering tools rather than memorizing commands.

---

# 2. Git

## What Git is

Git is a distributed version control system.

Its job is to track changes to a project over time.

Git allows developers to:

- Record changes.
- Inspect project history.
- Create branches.
- Experiment without immediately changing the main line of development.
- Merge changes.
- Recover previous versions.
- Collaborate with other developers.

## Core concepts

We will learn:

- Repository
- Working tree
- Staging area
- Commit
- Branch
- Merge
- Remote
- `origin`
- `HEAD`
- Pull request
- Merge conflict

## Core commands

Initial command set:

```bash
git status
git init
git add
git commit
git log
git branch
git switch
git merge
git remote
git push
git pull
git clone
```

Do not memorize these mechanically.

For every command, be able to explain:

1. What state is the repository currently in?
2. What does the command change?
3. Why would an engineer use it?

---

# 3. GitHub

Git and GitHub are not the same thing.

Git is the version-control system.

GitHub is a platform that hosts Git repositories and provides collaboration features.

We will practice:

- Creating repositories.
- Connecting local repositories to GitHub.
- Pushing changes.
- Pulling changes.
- Working with branches.
- Opening pull requests.
- Reviewing changes.
- Resolving merge conflicts.

---

# 4. Terminal

The terminal gives us direct control over the development environment.

You should become comfortable with:

```bash
pwd
ls
cd
mkdir
touch
```

On Windows, equivalent commands and PowerShell behavior may differ. We will learn what each command actually does instead of blindly copying commands.

The goal is not to become a terminal expert.

The goal is to avoid depending on the IDE for basic project operations.

---

# 5. Linux

Linux is part of the apprenticeship because backend applications commonly run in Linux-based environments.

We will learn the fundamentals needed to:

- Navigate files.
- Understand directories.
- Run programs.
- Work with permissions at a basic level.
- Understand processes at a basic level.
- Use a shell.

We do not need to master Linux in Phase 00.

We need enough understanding to operate in a development/server environment without being lost.

---

# 6. Maven

Maven is a Java build and project-management tool.

We will learn:

- What a build tool does.
- Project structure.
- Dependencies.
- `pom.xml`.
- Compile.
- Test.
- Package.
- Maven lifecycle.
- Running a Java project through Maven.

Example commands we will eventually use:

```bash
mvn compile
mvn test
mvn package
```

The important question is not:

> "What command should I type?"

It is:

> "What is Maven doing to my project?"

---

# 7. Gradle

Gradle is another build automation tool used in Java projects.

We will learn:

- Why build tools exist.
- How Gradle differs conceptually from Maven.
- Project structure.
- Dependencies.
- Build tasks.
- Testing.
- Packaging.

We will not attempt to master both Maven and Gradle simultaneously.

The objective is to understand the role of build automation and become operational with both.

---

# 8. IDE — VS Code

You currently use VS Code.

That is acceptable for our starting environment.

We will use the IDE as a productivity tool, but we will deliberately perform important operations through the terminal and Git.

You should understand what the IDE is doing when it:

- Runs Java.
- Builds a project.
- Runs tests.
- Detects dependencies.
- Uses Git.
- Opens files.
- Reports errors.

The goal is:

> **Use the IDE because it makes you faster, not because you cannot work without it.**

---

# 9. Professional Git Workflow

Our basic workflow will become:

```text
Update local repository
        ↓
Create a branch
        ↓
Make a change
        ↓
Inspect the change
        ↓
Stage the change
        ↓
Commit
        ↓
Push branch
        ↓
Open Pull Request
        ↓
Review
        ↓
Merge
        ↓
Update local repository
```

Later, we will introduce more sophisticated workflows when they become necessary.

---

# 10. Phase 00 Progress Tracker

This tracker is intentionally separate from the lesson material.

Update it as evidence is completed.

## Topics

- [ ] Git fundamentals
- [ ] Git repository lifecycle
- [ ] Branches
- [ ] Merging
- [ ] Merge conflicts
- [ ] GitHub
- [ ] Pull requests
- [ ] Terminal fundamentals
- [ ] Linux fundamentals
- [ ] Maven
- [ ] Gradle
- [ ] IDE workflow

## Required Evidence

- [ ] Create and manage a Git repository.
- [ ] Create and switch branches.
- [ ] Make meaningful commits.
- [ ] Push a branch to GitHub.
- [ ] Open a pull request.
- [ ] Merge a pull request.
- [ ] Intentionally create and resolve a merge conflict.
- [ ] Demonstrate basic terminal navigation.
- [ ] Build a Java project with Maven.
- [ ] Build a Java project with Gradle.

## Phase Completion

**Status:** Not started

**Advancement rule:** Do not advance to Phase 01 until the required evidence has been demonstrated.

---

# 11. Engineering Evidence Log

For each topic, record evidence rather than simply writing "understood."

Use this format:

```text
Topic:
Date:
What I built/did:
Commands/tools used:
What happened:
What I expected:
What actually happened:
Bug/problem encountered:
How I diagnosed it:
How I fixed it:
What I learned:
Evidence:
```

The important section is **what actually happened** and **how you diagnosed it**.

That is where engineering skill develops.

---

# 12. Mentor Rule

At the beginning of every new topic or exercise, the mentor will show:

```text
PHASE 00 — ENGINEERING ENVIRONMENT

Topics
[Current topic]
[Completed topics]
[Remaining topics]

Exercises
[Current exercise]
[Completed exercises]
[Remaining exercises]

Phase progress
[progress]

Current objective
[what we are trying to prove]
```

At the end of each topic or exercise, progress will be updated based on evidence.

We will not treat progress as "time spent."

We will treat progress as:

> **demonstrated capability.**

