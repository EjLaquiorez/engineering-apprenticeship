# Exercise 00.6 — Switching branches

Now we're going to **prove** your answer to Q5 instead of merely trusting it.

Run:

```bash
git switch main
```

Then:

```bash
git status
```

Then inspect the file:

```bash
Get-Content evidence/environment.md
```

You should find that the branch-specific section:

```text
## Branch Exercise

This change exists on the branch-basics branch.
```

is **not present**.

Then run:

```bash
git log --oneline --decorate -3
```

We want to see:

```text
4b6a0fa (HEAD -> main, origin/main)
417bc4b
598dcc5
```

### Important observation

When you switch from:

```text
exercise/branch-basics
```

to:

```text
main
```

Git changes the **working tree** to match the commit that `main` points to.

So:

```text
exercise/branch-basics
        │
        ▼
    02ce2f4
        │
        └── contains branch change


main
        │
        ▼
    4b6a0fa
        │
        └── does NOT contain branch change
```

Run those commands and paste the output of:

```bash
git status
Get-Content evidence/environment.md
git log --oneline --decorate -3
```

Then we'll switch back to the feature branch and introduce **merging**.


Switched to branch 'main'
Your branch is up to date with 'origin/main'.
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is up to date with 'origin/main'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

nothing added to commit but untracked files present (use "git add" to track)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> Get-Content evidence/environment.md
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


```bash
gradle --version
```

Output:

'gradle' is not recognized as an internal or external command,
operable program or batch file.

## Inspection Status

Environment inspected on 2026-08-19.
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate -3
4b6a0fa (HEAD -> main, origin/main) docs: record environment inspection status
417bc4b docs: record development environment
598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate -3

Excellent. ✅ Your output proves exactly what we wanted.

When you switched to `main`:

```text
HEAD -> main
```

and `main` points to:

```text
4b6a0fa
```

The file no longer contains:

```text
## Branch Exercise

This change exists on the branch-basics branch.
```

That proves your answer to Q5 was correct.

## What just happened?

You had:

```text
exercise/branch-basics
        │
        ▼
    02ce2f4
        │
        └── Branch Exercise exists


main
        │
        ▼
    4b6a0fa
        │
        └── Branch Exercise doesn't exist
```

After:

```bash
git switch main
```

Git changed your working tree to match `main`'s commit.

So your file changed back to the version represented by `4b6a0fa`.

---

# One subtle but important observation

Your `git status` says:

```text
Your branch is up to date with 'origin/main'.
```

That's because:

```text
main == origin/main == 4b6a0fa
```

The feature branch is separate:

```text
exercise/branch-basics == 02ce2f4
```

So GitHub's `main` is still completely unaffected by the branch-specific commit.

---

# Now: Merging 🌿 → 🌳

This is where branches become useful.

We have:

```text
main
  │
  ▼
4b6a0fa
  │
  └──────► 02ce2f4
             ▲
             │
      exercise/branch-basics
```

We want to bring the work from:

```text
exercise/branch-basics
```

into:

```text
main
```

Conceptually:

```text
Before:

main ───────────────► 4b6a0fa
                         \
                          02ce2f4 ◄── exercise/branch-basics


After merge:

main ───────────────────► merge commit
                           ▲
                          / \
                    4b6a0fa  02ce2f4
```

But Git may be able to perform this particular merge as a **fast-forward**, because `main` hasn't developed any new commits since the branch was created.

We'll deliberately observe that.

---

## Exercise 00.7 — Merge the branch

You're already on `main`. Verify:

```bash
git branch --show-current
```

It should say:

```text
main
```

Then run:

```bash
git merge exercise/branch-basics
```

**Stop there. Don't push yet.**

Then run:

```bash
git log --oneline --decorate --graph --all -5
```

and:

```bash
git status
```

Paste both outputs.

We're going to examine whether Git created a merge commit or performed a **fast-forward merge**, and *why*.
