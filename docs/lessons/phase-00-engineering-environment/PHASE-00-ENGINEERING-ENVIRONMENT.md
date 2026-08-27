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

We learned:

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

For every command, the goal is to be able to explain:

1. What state is the repository currently in?
2. What does the command change?
3. Why would an engineer use it?

**Status: COMPLETE**

---

# 3. GitHub

Git and GitHub are not the same thing.

Git is the version-control system.

GitHub is a platform that hosts Git repositories and provides collaboration features.

We practiced:

- Connecting a local repository to GitHub.
- Pushing changes.
- Pulling changes.
- Working with branches.
- Opening pull requests.
- Reviewing changes.
- Resolving merge conflicts.

**Status: COMPLETE**

---

# 4. Terminal Fundamentals

The terminal gives us direct control over the development environment.

We practiced:

```text
pwd
ls
cd
mkdir
touch
```

We also practiced PowerShell equivalents and operations including:

```text
Get-Location
Get-ChildItem
New-Item
Set-Content
Add-Content
Get-Content
Copy-Item
Move-Item
Remove-Item
```

We learned:

- Basic navigation.
- Relative and absolute paths.
- Creating, reading, copying, moving, and deleting files.
- File redirection.
- PowerShell aliases.
- Basic process inspection.
- The difference between terminal commands and IDE operations.

The goal is not to become a terminal expert.

The goal is to avoid depending on the IDE for basic project operations.

**Status: COMPLETE**

---

# 5. Linux Fundamentals

Linux is part of the apprenticeship because backend applications commonly run in Linux-based environments.

We learned the fundamentals needed to:

- Navigate files.
- Understand directories.
- Understand absolute and relative paths.
- Work with files and directories.
- Read files.
- Use wildcards and pattern matching.
- Use pipes and redirection.
- Search using `grep`.
- Understand `find`.
- Understand basic permissions.
- Understand users and groups.
- Understand processes.
- Understand environment variables.
- Understand `PATH`.
- Understand shell basics.
- Understand basic troubleshooting concepts.

Our practice environment was Git Bash on Windows rather than a full Linux installation.

Important commands practiced included:

```bash
pwd
ls
cd
mkdir
cp
mv
rm
rmdir
cat
head
tail
less
grep
find
wc
```

We also practiced:

```bash
cat application.log | grep "ERROR"
grep -i "error" application.log
grep -v "ERROR" application.log
grep -c "ERROR" application.log
tail -f application.log
```

The objective was not to master Linux.

The objective was to become capable of operating in a Linux-like development/server environment without being lost.

**Status: COMPLETE**

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

Example commands:

```bash
mvn compile
mvn test
mvn package
```

The important question is not:

> "What command should I type?"

It is:

> "What is Maven doing to my project?"

**Status: NOT STARTED**

**Next topic.**

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

**Status: NOT STARTED**

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

**Status: NOT STARTED**

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

**Status: COMPLETE**

The workflow has been practiced through the Git, GitHub, branching, pull request, and merge-conflict exercises.

---

# 10. Phase 00 Progress Tracker

This tracker is intentionally separate from the lesson material.

Update it as evidence is completed.

## Topics

- [x] Git fundamentals
- [x] Git repository lifecycle
- [x] Branches
- [x] Merging
- [x] Merge conflicts
- [x] GitHub
- [x] Pull requests
- [x] Terminal fundamentals
- [x] Linux fundamentals
- [ ] Maven
- [ ] Gradle
- [ ] IDE workflow — VS Code

## Required Evidence

- [x] Create and manage a Git repository.
- [x] Create and switch branches.
- [x] Make meaningful commits.
- [x] Push a branch to GitHub.
- [x] Open a pull request.
- [x] Merge a pull request.
- [x] Intentionally create and resolve a merge conflict.
- [x] Demonstrate basic terminal navigation.
- [ ] Build a Java project with Maven.
- [ ] Build a Java project with Gradle.

## Current Progress

**Completed topics:** 9 / 12

**Progress:** **75%**

```text
Git fundamentals          ████████████████████ 100%
Git repository lifecycle  ████████████████████ 100%
Branches                  ████████████████████ 100%
Merging                   ████████████████████ 100%
Merge conflicts           ████████████████████ 100%
GitHub                    ████████████████████ 100%
Pull requests             ████████████████████ 100%
Terminal fundamentals     ████████████████████ 100%
Linux fundamentals        ████████████████████ 100%

Maven                     ░░░░░░░░░░░░░░░░░░░░ 0%
Gradle                    ░░░░░░░░░░░░░░░░░░░░ 0%
VS Code workflow          ░░░░░░░░░░░░░░░░░░░░ 0%

Overall: 75%
```

## Phase Completion

**Status:** In progress

**Next topic:** Maven

**Remaining topics:**

1. Maven
2. Gradle
3. IDE workflow — VS Code

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

The important sections are **what actually happened** and **how you diagnosed it**.

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

---

# Current Position

**Phase 00 — 75% complete**

**Completed:** Git, GitHub, Pull Requests, Terminal Fundamentals, Linux Fundamentals, and the associated workflow/evidence.

**Next:** Maven

**Goal of the next topic:** Understand what Maven does to a Java project and demonstrate that capability by building and working with a Maven project.
