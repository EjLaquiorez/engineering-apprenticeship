# Exercise 00.5 — Create Your First Branch

Before creating the branch, verify where you are:

```bash
git branch --show-current
```

You should get:

```text
main
```

Then run:

```bash
git switch -c exercise/branch-basics
```

Git should report something similar to:

```text
Switched to a new branch 'exercise/branch-basics'
```

Then run:

```bash
git branch -vv
```

and:

```bash
git log --oneline --decorate -3
```

**Don't make any commits yet.**

Paste both outputs here. We'll inspect exactly what changed—and what **didn't** change—when you created the branch.


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is ahead of 'origin/main' by 1 commit.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

nothing added to commit but untracked files present (use "git add" to track)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
4b6a0fa (HEAD -> main) docs: record environment inspection status
417bc4b (origin/main) docs: record development environment
598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git push
Enumerating objects: 7, done.
Counting objects: 100% (7/7), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (4/4), 419 bytes | 419.00 KiB/s, done.
Total 4 (delta 2), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/EjLaquiorez/engineering-apprenticeship.git
   417bc4b..4b6a0fa  main -> main
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
Your branch is up to date with 'origin/main'.
Untracked files:
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md

nothing added to commit but untracked files present (use "git add" to track)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate -3
4b6a0fa (HEAD -> main, origin/main) docs: record environment inspection status
417bc4b docs: record development environment
598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git branch --show-current
main
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git switch -c exercise/branch-basics
Switched to a new branch 'exercise/branch-basics'
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git branch -vv
* exercise/branch-basics 4b6a0fa docs: record environment inspection status
  main                   4b6a0fa [origin/main] docs: record environment inspection status
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate -3
4b6a0fa (HEAD -> exercise/branch-basics, origin/main, main) docs: record environment inspection status
417bc4b docs: record development environment
598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Excellent. ✅ You performed the branch creation correctly, and your output gives us a very clean demonstration of how branches work.

First, one small observation: you correctly pushed `4b6a0fa` before creating the branch, so your local `main` and GitHub are synchronized.

## What changed?

Before:

```text
main ─────────────► 4b6a0fa
origin/main ──────► 4b6a0fa
```

After:

```text
exercise/branch-basics ─► 4b6a0fa
main ───────────────────► 4b6a0fa
origin/main ────────────► 4b6a0fa
```

Your `git branch -vv` proves this:

```text
* exercise/branch-basics 4b6a0fa
  main                   4b6a0fa [origin/main]
```

The `*` means:

> **This is the branch you're currently on.**

So now:

```text
HEAD
 ↓
exercise/branch-basics
 ↓
4b6a0fa
```

And your log confirms:

```text
4b6a0fa (HEAD -> exercise/branch-basics, origin/main, main)
```

All three references currently point to the **same commit**.

---

# Important: the branch didn't copy your files

You didn't get:

```text
engineering-apprenticeship/
engineering-apprenticeship-feature/
```

Instead, Git created another reference to the existing commit.

That's why creating the branch was almost instantaneous.

---

# Now let's make the branches diverge

This is where branches become useful.

You're currently on:

```text
exercise/branch-basics
```

We are going to create a small change **only on this branch**.

Open:

```text
evidence/environment.md
```

Add this at the bottom:

```markdown
## Branch Exercise

This change exists on the branch-basics branch.
```

Save it.

Then run:

```bash
git status
```

and:

```bash
git diff
```

**Do not commit yet.**

Paste both outputs.

We're going to observe the first step of branch divergence:

```text
main
  │
  ▼
4b6a0fa
  │
  └── exercise/branch-basics
          │
          ▼
       working-tree change
```

The key question we'll answer next is:

> **What happens to `main` when you make a change on `exercise/branch-basics`?**
