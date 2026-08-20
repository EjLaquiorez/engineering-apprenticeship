# Pull Requests, Branches, Commit vs Push

**Date:** 2026-08-20  
**Phase:** 00 — Engineering Environment  
**Topics:** Branches, merging, divergence, commit vs push, pull requests

---

## 1. Git repository structure

You worked with the idea that Git has several important areas:

```text
Working Tree
     ↓
Staging Area
     ↓
Git History
     ↓
Remote Repository (GitHub)
```

The commands that move changes through these areas are:

```powershell
git add
git commit
git push
```

### Working Tree

Your files as they currently exist on your computer.

### Staging Area

Files you've selected with `git add` for the next commit.

### Git History

Commits that have already been created with `git commit`.

### Remote Repository

The repository on GitHub, accessed through something like:

```text
origin
```

---

## 2. Commit vs Push

You practiced the distinction between:

```powershell
git commit
```

and:

```powershell
git push
```

### `git commit`

Creates a commit **locally**.

```text
Working Tree
    ↓
Staging Area
    ↓
git commit
    ↓
Local Git History
```

### `git push`

Sends your local commits to the remote repository.

```text
Local Git History
       ↓
   git push
       ↓
GitHub
```

Therefore:

> **Commit does not mean push.**

You can have commits locally that haven't been pushed to GitHub yet.

We actually encountered this during the `.gitignore` exercise:

```text
Your branch is ahead of 'origin/main' by 1 commit.
```

That means the commit exists locally but hasn't been pushed yet.

---

## 3. Branches

You practiced creating and switching branches.

The basic idea:

```text
main
 │
 ├── commit A
 ├── commit B
 │
 └── feature branch
       ├── commit C
       └── commit D
```

A branch is essentially a movable pointer to a line of development.

Instead of making changes directly on `main`, you can create a separate branch:

```powershell
git branch feature-name
```

and switch to it:

```powershell
git switch feature-name
```

A newer combined command is:

```powershell
git switch -c feature-name
```

which creates and switches to the branch.

---

## 4. Switching branches

You practiced switching between branches.

```powershell
git switch main
```

and:

```powershell
git switch feature-name
```

The important idea was:

> Your working environment follows whichever branch you currently have checked out.

You should know which branch you're on before making changes.

A useful command is:

```powershell
git branch
```

The current branch is marked with:

```text
*
```

---

## 5. Merging a branch

You also practiced merging.

The general workflow is:

```text
main
 │
 ├── A
 ├── B
 │
 └── feature
      ├── C
      └── D
```

You switch back to the branch receiving the changes:

```powershell
git switch main
```

Then:

```powershell
git merge feature
```

The changes from `feature` are incorporated into `main`.

The important rule you practiced:

> **You merge INTO the branch you're currently on.**

So if you're on `main`:

```powershell
git merge feature
```

means:

> Merge `feature` into `main`.

---

## 6. Divergence

You also worked on creating **real branch divergence**.

Divergence happens when two branches move forward independently:

```text
        C ── D       feature
       /
A ── B
       \
        E ── F       main
```

Now `main` and `feature` have different commits after their common ancestor.

This is important because Git must determine how the two lines of development should be combined.

---

## 7. Pull Requests

The Pull Request workflow connects your local Git workflow with GitHub collaboration.

A typical workflow is:

```text
main
  ↓
create feature branch
  ↓
make changes
  ↓
git add
  ↓
git commit
  ↓
git push
  ↓
GitHub
  ↓
Open Pull Request
  ↓
Review
  ↓
Merge Pull Request
```

A Pull Request is **not a Git commit**.

It is a GitHub collaboration mechanism used to propose changes from one branch into another.

For example:

```text
exercise/branch-basics
        │
        │ Pull Request
        ↓
      main
```

---

## 8. What you learned about the Pull Request workflow

The important distinction is:

```text
git commit
    ↓
creates local history

git push
    ↓
uploads branch/commits to GitHub

Pull Request
    ↓
asks GitHub to review/merge those changes
```

So:

> **Commit → Push → Pull Request → Review → Merge**

These are separate operations.

---

## 9. Your repository history

At the beginning of this work, your repository already had history involving the branch exercise.

We later saw:

```text
c28cef0 Merge pull request #1 from EjLaquiorez/exercise/branch-basics
485bec3 docs: address pull request feedback
```

That confirms that your branch-basics work had already gone through a Pull Request and was merged into `main`.

---

## Core knowledge

You should now be able to explain:

- What a branch is
- Why feature branches are useful
- How to create a branch
- How to switch branches
- How to merge a branch
- What branch divergence means
- Difference between commit and push
- What a Pull Request is
- How a feature branch gets into `main`
- Why a Pull Request is a GitHub collaboration mechanism rather than a Git command
