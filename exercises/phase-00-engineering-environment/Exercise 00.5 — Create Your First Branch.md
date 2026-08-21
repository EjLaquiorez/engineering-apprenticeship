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

Good. ✅ You're exactly where we expected.

Your `git status` shows:

```text
On branch exercise/branch-basics

Changes not staged for commit:
    modified: evidence/environment.md
```

And `git diff` produced no visible output in your message, so let's focus on the important state.

## Current state

You are on:

```text
exercise/branch-basics
```

and you have modified:

```text
evidence/environment.md
```

But the change is **not committed** and **not staged**.

So:

```text
main ───────────────────► 4b6a0fa
                           ▲
                           │
exercise/branch-basics ───┘
                           │
                           ▼
                     Working Tree
                     modified file
```

### Important point

**The branch itself hasn't diverged yet.**

Why?

Because branches diverge through **commits**, not merely through editing files.

Right now both branch names still point to:

```text
4b6a0fa
```

The working-tree modification isn't part of either branch's history yet.

---

## Let's commit the branch change

Now stage it:

```bash
git add evidence/environment.md
```

Then inspect:

```bash
git diff --cached
```

You should see your new section:

```text
+## Branch Exercise
+
+This change exists on the branch-basics branch.
```

If that looks correct, commit it:

```bash
git commit -m "docs: demonstrate branch-specific change"
```

Then run:

```bash
git log --oneline --decorate --graph --all -4
```

This is the important command.

It should show something conceptually like:

```text
* abc1234 (HEAD -> exercise/branch-basics) docs: demonstrate branch-specific change
* 4b6a0fa (origin/main, main) docs: record environment inspection status
* 417bc4b docs: record development environment
* 598dcc5 initial repo structure
```

Notice what will happen:

```text
main
  │
  ▼
4b6a0fa
  │
  ▼
history

exercise/branch-basics
  │
  ▼
abc1234
```

**That's actual branch divergence.**

Do those three steps:

```bash
git add evidence/environment.md
git diff --cached
git commit -m "docs: demonstrate branch-specific change"
```

Then:

```bash
git log --oneline --decorate --graph --all -4
```

Paste the output.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git commit -m "docs: demonstrate branch-specific change"
[exercise/branch-basics 02ce2f4] docs: demonstrate branch-specific change
 1 file changed, 5 insertions(+), 1 deletion(-)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate --graph --all -4
* 02ce2f4 (HEAD -> exercise/branch-basics) docs: demonstrate branch-specific change
* 4b6a0fa (origin/main, main) docs: record environment inspection status
* 417bc4b docs: record development environment
* 598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 


Excellent. 🎯 **This is your first real branch divergence.**

Your graph proves it:

```text
* 02ce2f4 (HEAD -> exercise/branch-basics) docs: demonstrate branch-specific change
* 4b6a0fa (origin/main, main) docs: record environment inspection status
* 417bc4b docs: record development environment
* 598dcc5 initial repo structure
```

## Read the graph from bottom to top

Before the branch:

```text
598dcc5
   │
417bc4b
   │
4b6a0fa
```

At `4b6a0fa`, both branches were pointing to the same commit:

```text
main ───────────────► 4b6a0fa
exercise/branch-basics ─► 4b6a0fa
```

Then you committed on `exercise/branch-basics`.

Now:

```text
main ───────────────► 4b6a0fa
                         │
                         ▼
                      02ce2f4 ◄── exercise/branch-basics
```

So the branches have diverged.

### Your `HEAD`

```text
HEAD -> exercise/branch-basics
```

means you're currently working on:

```text
exercise/branch-basics
```

and it points to:

```text
02ce2f4
```

### `main`

```text
main -> 4b6a0fa
```

It **doesn't contain** your new branch commit.

That's the key property of branches.

---

# Important observation

Your branch commit is currently **local only**:

```text
02ce2f4
```

GitHub doesn't have this branch yet.

Your remote currently has:

```text
origin/main -> 4b6a0fa
```

This is perfectly normal.

---

# Checkpoint — explain the situation

Answer these in your own words:

**Q1.** Which branch contains commit `02ce2f4`?

**Q2.** Does `main` contain `02ce2f4`?

**Q3.** What commit does `main` currently point to?

**Q4.** What commit does `exercise/branch-basics` currently point to?

**Q5.** If you switch to `main`, will the branch-specific change appear in the file?

Take your time here. This is the foundation for understanding **merging** next.

1. exercise/branch-basics
2. no
3. main -> 4b6a0fa
4. 02ce2f4  
5. No

Perfect. **5/5 correct.** 🎯

You now understand branch divergence.

Your repository currently looks like this:

```text
                  02ce2f4
                     ▲
                     │
exercise/branch-basics
                     │
                     │
4b6a0fa ◄────────────┘
   ▲
   │
 main
   │
 origin/main
```

More simply:

```text
main ─────────────────► 4b6a0fa

exercise/branch-basics ─► 02ce2f4
```

And because `02ce2f4` exists only on `exercise/branch-basics`, the branch-specific change is not present when looking at `main`.

---

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
