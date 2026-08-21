
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

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git branch --show-current
main
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git merge exercise/branch-basics
Updating 4b6a0fa..02ce2f4
Fast-forward
 evidence/environment.md | 6 +++++-
 1 file changed, 5 insertions(+), 1 deletion(-)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate --graph --all -5
* 02ce2f4 (HEAD -> main, exercise/branch-basics) docs: demonstrate branch-specific change
* 4b6a0fa (origin/main) docs: record environment inspection status
* 417bc4b docs: record development environment
* 598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is ahead of 'origin/main' by 1 commit.
  (use "git push" to publish your local commits)

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

nothing added to commit but untracked files present (use "git add" to track)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship>

Perfect. 🎯 You just performed your **first merge**, and Git showed you an important special case: **fast-forward merge**.

## What happened?

Git reported:

```text
Updating 4b6a0fa..02ce2f4
Fast-forward
```

This tells us there was **no merge commit**.

Why?

Because `main` had not moved forward since you created `exercise/branch-basics`.

Before the merge:

```text id="2f2j5e"
main
 │
 ▼
4b6a0fa
 │
 ▼
02ce2f4
 ▲
 │
exercise/branch-basics
```

`main` was simply behind the feature branch.

So Git could move `main` forward:

```text id="p4gk4j"
Before:

main ───────────────► 4b6a0fa

exercise/branch-basics ─► 02ce2f4
```

After:

```text id="7v0p1b"
main ───────────────► 02ce2f4
                       ▲
                       │
exercise/branch-basics ┘
```

That's why the log now says:

```text id="a8z2fc"
02ce2f4 (HEAD -> main, exercise/branch-basics)
```

Both branch names point to the same commit.

---

# Why didn't Git create a merge commit?

Because the history was linear:

```text id="5q5qha"
A ── B ── C
          ▲
          │
       feature
```

There was nothing to combine.

Git only needed to move:

```text id="3f0v7r"
main: B → C
```

This is called a **fast-forward**.

---

# Your current state

You have:

```text id="3l2xw9"
02ce2f4 (HEAD -> main, exercise/branch-basics)
4b6a0fa (origin/main)
417bc4b
598dcc5
```

So:

```text
Local main
    │
    ▼
02ce2f4

Feature branch
    │
    ▼
02ce2f4

GitHub main
    │
    ▼
4b6a0fa
```

Your local `main` is now **one commit ahead of GitHub**.

Notice something interesting:

> The branch has been merged, but the branch itself still exists.

That's completely normal.

---

# One important distinction

A merge does **not** necessarily mean:

> "Delete the feature branch."

Merging and deleting a branch are separate operations.

For now, **don't delete it**. We'll use it to demonstrate another scenario.

---

# Exercise 00.8 — Create a real divergence

Fast-forward merging was the easy case.

Now we're going to create the situation where Git actually has to **combine two lines of development**.

We'll do this carefully.

Your current state:

```text id="v6wqwl"
02ce2f4
 ▲   ▲
 │   │
main feature
```

First, make sure you're on `main`:

```bash id="r6d6s4"
git switch main
```

Then create a new commit on `main`.

Add this to `evidence/environment.md`:

```markdown id="w8j0hx"
## Main Branch Update

This change was made on main.
```

Then:

```bash id="a1d6dr"
git add evidence/environment.md
```

and:

```bash id="vnjy5k"
git commit -m "docs: update main branch"
```

**Do not push.**

Then switch to the feature branch:

```bash id="6v9n1h"
git switch exercise/branch-basics
```

Now make a **different** change to the same file:

```markdown id="7p1p4h"
## Feature Branch Update

This change was made on the feature branch.
```

Then:

```bash id="o3o7f0"
git add evidence/environment.md
git commit -m "docs: update feature branch"
```

Again, **do not push**.

Finally:

```bash id="3s8vva"
git log --oneline --decorate --graph --all -6
```

Paste that graph.

We're intentionally creating:

```text id="1r2j4h"
              ┌── main commit
             /
02ce2f4
             \
              └── feature commit
```

This time, when we merge, Git will have to deal with **two different histories**.

That's the foundation for understanding **merge conflicts**.
