# Phase 00 — Exercises

> Exercises are evidence of capability, not homework for the sake of completion.

## Rules

1. Do not skip exercises.
2. Do not copy solutions without understanding them.
3. When something breaks, investigate it before asking for the answer.
4. Record important bugs and how you diagnosed them.
5. Every completed exercise should leave evidence in the repository.
6. A task is not complete because you can follow a command. You must be able to explain what the command did.

---

# Progress Dashboard

## Topics

- [ ] Git fundamentals
- [ ] Repository lifecycle
- [ ] Branches
- [ ] Merging
- [ ] Merge conflicts
- [ ] GitHub
- [ ] Pull requests
- [ ] Terminal fundamentals
- [ ] Linux fundamentals
- [ ] Maven
- [ ] Gradle
- [ ] VS Code workflow

## Exercises

- [ ] Exercise 00.1 — Inspect the environment
- [ ] Exercise 00.2 — Create a Git repository
- [ ] Exercise 00.3 — Commit a project
- [ ] Exercise 00.4 — Create and use branches
- [ ] Exercise 00.5 — Push a branch to GitHub
- [ ] Exercise 00.6 — Open and merge a pull request
- [ ] Exercise 00.7 — Resolve a merge conflict
- [ ] Exercise 00.8 — Terminal navigation challenge
- [ ] Exercise 00.9 — Linux fundamentals challenge
- [ ] Exercise 00.10 — Create a Maven project
- [ ] Exercise 00.11 — Create a Gradle project
- [ ] Exercise 00.12 — Phase 00 integration challenge

---

# Exercise 00.1 — Inspect the Environment

## Objective

Establish exactly what development tools are installed on the machine.

## Tasks

Record the versions of:

- Git
- Java
- Java compiler
- Maven
- Gradle

Also record:

- Operating system
- Shell/terminal being used
- IDE

## Evidence

Create:

```text
evidence/environment.md
```

Include the commands you used and the output you received.

Do not manually invent version numbers.

---

# Exercise 00.2 — Create a Git Repository

## Objective

Understand the relationship between a project directory and a Git repository.

## Tasks

Create a small practice project.

Initialize Git.

Inspect the repository status.

## Questions

Answer in your evidence:

1. What changed after `git init`?
2. What does `git status` tell you?
3. What files does Git currently track?
4. What is the difference between a normal folder and a Git repository?

## Evidence

Create:

```text
evidence/git-repository.md
```

---

# Exercise 00.3 — Commit a Project

## Objective

Understand the basic Git lifecycle:

```text
Working tree
     ↓
Staging area
     ↓
Commit
```

## Tasks

Create a file.

Inspect its status.

Stage it.

Commit it.

Modify it.

Inspect the status again.

Commit the second change.

Inspect the history.

## Questions

Explain:

1. What is the working tree?
2. What is the staging area?
3. What is a commit?
4. Why does Git have a staging area?
5. What information does `git log` provide?

## Evidence

Create:

```text
evidence/git-commits.md
```

Include your commit history.

---

# Exercise 00.4 — Create and Use Branches

## Objective

Understand branches as independent lines of development.

## Tasks

Create a branch.

Switch to it.

Make a change.

Commit the change.

Switch back to the main branch.

Observe the difference.

## Questions

Explain:

1. Why would an engineer use a branch?
2. What changed when you switched branches?
3. Why should feature work usually happen on a separate branch?

## Evidence

Create:

```text
evidence/git-branches.md
```

---

# Exercise 00.5 — Push a Branch to GitHub

## Objective

Understand the relationship between the local repository and a remote repository.

## Tasks

Connect your local repository to GitHub.

Push your branch.

Verify the branch exists on GitHub.

## Questions

Explain:

1. What is a remote?
2. What is `origin`?
3. What is the difference between local and remote branches?
4. What does `git push` actually do?

## Evidence

Create:

```text
evidence/github-remote.md
```

---

# Exercise 00.6 — Open and Merge a Pull Request

## Objective

Experience a basic collaborative GitHub workflow.

## Tasks

Push a feature branch.

Open a pull request.

Review the changes.

Merge the pull request.

Update your local repository.

## Questions

Explain:

1. Why use a pull request instead of immediately merging locally?
2. What does a pull request allow a team to do?
3. What happens after the pull request is merged?

## Evidence

Create:

```text
evidence/pull-request.md
```

Include the pull request URL and a short explanation of what happened.

---

# Exercise 00.7 — Resolve a Merge Conflict

## Objective

Learn how Git behaves when two branches modify the same part of a file differently.

## Tasks

Intentionally create conflicting changes.

Attempt to merge the branches.

Inspect the conflict.

Resolve it manually.

Complete the merge.

Verify the final result.

## Questions

Explain:

1. Why did Git refuse to automatically merge the changes?
2. What does a conflict marker mean?
3. How did you decide which content should remain?
4. Why is blindly choosing "ours" or "theirs" dangerous?

## Evidence

Create:

```text
evidence/merge-conflict.md
```

Include:

- What caused the conflict.
- What the conflict looked like.
- How you resolved it.
- How you verified the result.

---

# Exercise 00.8 — Terminal Navigation Challenge

## Objective

Operate on a project from the terminal instead of relying on the IDE.

## Tasks

Using the terminal:

- Navigate into a project.
- Create a directory.
- Create a file.
- List files.
- Move between directories.
- Return to the project root.

## Questions

Explain what each command did.

## Evidence

Create:

```text
evidence/terminal.md
```

---

# Exercise 00.9 — Linux Fundamentals Challenge

## Objective

Develop enough Linux familiarity to operate in a server-like environment.

## Tasks

We will perform this exercise in an appropriate Linux environment.

Practice:

- Directory navigation.
- File creation.
- File inspection.
- Basic permissions.
- Process inspection.

## Evidence

Create:

```text
evidence/linux.md
```

Record:

- Commands used.
- What each command did.
- One thing that surprised you.

---

# Exercise 00.10 — Create a Maven Project

## Objective

Understand what a Java build tool does.

## Tasks

Create a simple Java project using Maven.

Build it.

Run its tests.

Inspect the project structure.

Inspect `pom.xml`.

## Questions

Explain:

1. Why do we need a build tool?
2. What is `pom.xml`?
3. What is a dependency?
4. What happens during a Maven build?
5. What is the difference between compiling and packaging?

## Evidence

Create:

```text
evidence/maven.md
```

---

# Exercise 00.11 — Create a Gradle Project

## Objective

Understand a second Java build system.

## Tasks

Create a simple Java project using Gradle.

Build it.

Run its tests.

Inspect the project structure.

Inspect its Gradle configuration.

## Questions

Explain:

1. Why does Gradle exist if Maven already exists?
2. What is a Gradle task?
3. How is Gradle different from Maven at a high level?
4. What did Gradle actually do when you built the project?

## Evidence

Create:

```text
evidence/gradle.md
```

---

# Exercise 00.12 — Phase 00 Integration Challenge

## Objective

Demonstrate that the tools can be used together rather than as isolated commands.

## Challenge

Create a small Java project.

The project must:

- Use Git.
- Use a feature branch.
- Use Maven or Gradle.
- Contain meaningful commits.
- Be pushed to GitHub.
- Have a pull request.
- Include at least one intentional merge conflict that you resolve.
- Include documentation explaining how to build the project.

## Required documentation

Create:

```text
README.md
```

The README must explain:

1. What the project is.
2. How to clone it.
3. How to build it.
4. How to run it.
5. How to test it.
6. What build tool it uses.

## Final Evidence

Create:

```text
evidence/phase-00-review.md
```

Answer:

1. What can I now do that I could not do before Phase 00?
2. Which concept was hardest?
3. What bug or mistake taught me the most?
4. Which Git concept do I still find confusing?
5. Which terminal concept do I still find confusing?
6. What is Maven/Gradle responsible for?
7. What evidence proves I can work with GitHub?
8. What evidence proves I can resolve a merge conflict?

---

# Phase 00 Completion Criteria

Phase 00 is complete only when the mentor can verify the following:

- [ ] Git repository management demonstrated.
- [ ] Meaningful commits demonstrated.
- [ ] Branching demonstrated.
- [ ] Merging demonstrated.
- [ ] Merge conflict resolution demonstrated.
- [ ] GitHub remote workflow demonstrated.
- [ ] Pull request demonstrated.
- [ ] Terminal fundamentals demonstrated.
- [ ] Linux fundamentals demonstrated.
- [ ] Maven project built successfully.
- [ ] Gradle project built successfully.
- [ ] Integration challenge completed.
- [ ] Evidence documented.

**Phase status:** Not complete.

Do not advance to Phase 01 until the evidence has been reviewed.
