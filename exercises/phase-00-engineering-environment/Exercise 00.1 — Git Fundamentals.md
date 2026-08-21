Correct. **All 3 answers are correct.**

You're now demonstrating the actual Git mental model rather than just remembering commands.

## Topic 00.1 — Git Fundamentals

```text
Status
[✓] Working tree
[✓] Staging area
[✓] Commit / Git history
[✓] Selective staging
[→] Git repository lifecycle
[ ] Branches
[ ] Merging
[ ] Merge conflicts
[ ] GitHub
[ ] Pull requests
[ ] Terminal
[ ] Linux
[ ] Maven
[ ] Gradle
[ ] VS Code workflow

Exercises
[→] 00.1 Inspect the environment
[ ] 00.2 Create a Git repository
[ ] 00.3 Commit a project
...

Progress: ~8%

Current objective:
Verify your actual development environment before
we start manipulating repositories.
```

### Your answer to #3

After the commit, Git would report something conceptually like:

```text
Changes not staged for commit:
    modified: README.md
```

So your wording:

> "README.md is not staged yet"

is correct.

One subtle improvement:

**Git isn't merely telling you that README is "not staged."**

It's telling you that there is a difference between:

* the version in your last commit, and
* the current version in your working tree.

That's a more useful way to think about `git status`.

---

# Now we move from theory → evidence

This is **Exercise 00.1 — Inspect the Environment**.

Your environment currently sounds like:

* Windows ✅
* Git installed ✅
* GitHub account ✅
* VS Code ✅
* Java/JDK installed ✅
* Terminal experience ✅
* Basic Git experience ✅

But we don't accept assumptions.

We need **evidence**.

## Exercise 00.1

Open **PowerShell** or **Command Prompt**.

Run these one at a time:

```bash
git --version
```

Then:

```bash
java --version
```

Then:

```bash
javac --version
```

Then check Maven:

```bash
mvn --version
```

And Gradle:

```bash
gradle --version
```

### Important

If Maven or Gradle says something like:

```text
'mvn' is not recognized...
```

or:

```text
'gradle' is not recognized...
```

**don't immediately try to fix it.**

That's useful evidence.

We're trying to discover the state of your environment first.

---

## Your evidence

Create this file in your apprenticeship repository:

```text
evidence/environment.md
```

Put something like:

````markdown
# Environment Inspection

## Operating System

Windows

## IDE

VS Code

## Git

Command:

```bash
git --version
````

Output:

git version 2.53.0.windows.2

## Java

Command:

```bash
java --version
```

Output:

java 21.0.11 2026-04-21 LTS
Java(TM) SE Runtime Environment (build 21.0.11+9-LTS-211)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.11+9-LTS-211, mixed mode, sharing)


## Java Compiler

Command:

```bash
javac --version
```

Output:

javac 21.0.11


## Maven

Command:

```bash
mvn --version
```

Output:

'mvn' is not recognized...

## Gradle

Command:

```bash
gradle --version
```

Output:

'gradle' is not recognized as an internal or external command,
operable program or batch file.

```

**Do not invent or manually type the version numbers. Copy the actual terminal output.**

Then show me the results.

I will inspect them with you and we'll determine whether your environment is actually ready before moving to **Exercise 00.2 — Create a Git Repository**.
```


Exactly. ✅ **This is definitive evidence that `4483d9f` is a merge commit.**

Your output contains:

```text
parent 409445e...
parent c8abb6f...
```

There are **two parent commits**.

That is the key technical distinction.

---
