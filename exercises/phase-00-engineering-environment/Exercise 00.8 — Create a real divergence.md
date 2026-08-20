## Exercise 00.8 — Create a real divergence

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


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git add evidence/environment.md
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git commit -m "docs: update main branch"
[main 409445e] docs: update main branch        
 1 file changed, 5 insertions(+), 1 deletion(-)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git switch exercise/branch-basics
Switched to branch 'exercise/branch-basics'
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git add evidence/environment.md
>> git commit -m "docs: update feature branch"
[exercise/branch-basics c8abb6f] docs: update feature branch
 1 file changed, 5 insertions(+), 1 deletion(-)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate --graph --all -6
* c8abb6f (HEAD -> exercise/branch-basics) docs: update feature branch
| * 409445e (main) docs: update main branch
|/  
* 02ce2f4 docs: demonstrate branch-specific change
* 4b6a0fa (origin/main) docs: record environment inspection status
* 417bc4b docs: record development environment
* 598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 


Excellent. 🎯 **This is the exact divergent history we wanted.**

Your graph is:

```text
* c8abb6f (HEAD -> exercise/branch-basics) docs: update feature branch
| * 409445e (main) docs: update main branch
|/
* 02ce2f4 docs: demonstrate branch-specific change
* 4b6a0fa (origin/main) docs: record development environment
...
```

## Read this graph carefully

At `02ce2f4`, both branches were together:

```text
             02ce2f4
             /      \
            /        \
         main       feature
```

Then each branch created its **own commit**:

```text
                 409445e ← main
                /
02ce2f4
                \
                 c8abb6f ← exercise/branch-basics
```

That's genuine branch divergence.

### Your current position

You're currently on:

```text id="8kh5bn"
exercise/branch-basics
```

because:

```text
HEAD -> exercise/branch-basics
```

points to:

```text id="6wqk0s"
c8abb6f
```

Meanwhile:

```text id="2p7r8c"
main -> 409445e
```

---

# Why this is different from the previous merge

Previously:

```text
A ── B ── C
         ▲
         └── feature
```

`main` could simply move forward to `C`.

That was a **fast-forward**.

Now:

```text
              409445e ← main
             /
02ce2f4
             \
              c8abb6f ← feature
```

Git cannot simply move one branch pointer forward without losing the other branch's commit.

Git now has to **combine two lines of development**.

That's the real purpose of merging.

---

# Now let's merge

We'll merge the feature branch into `main`.

First switch to `main`:

```bash id="w0lcv5"
git switch main
```

Verify:

```bash id="0b15p0"
git branch --show-current
```

It should say:

```text
main
```

Then:

```bash id="x4p3wa"
git merge exercise/branch-basics
```

### Important

**Stop immediately after `git merge`.**

Don't try to fix anything yet.

Git may produce a conflict because both branches changed the same file.

That's not a failure.

In fact, **that's exactly what we're trying to learn.**

If you see:

```text
CONFLICT
```

don't panic and don't run random commands.

Just paste the complete merge output here.

If Git successfully merges without a conflict, that's also useful evidence.

Run:

```bash id="l7j4om"
git switch main
git merge exercise/branch-basics
```

and show me the output.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git switch main
Switched to branch 'main'
Your branch is ahead of 'origin/main' by 2 commits.
  (use "git push" to publish your local commits)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git branch --show-current
main
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git merge exercise/branch-basics
Auto-merging evidence/environment.md
CONFLICT (content): Merge conflict in evidence/environment.md
Automatic merge failed; fix conflicts and then commit the result.
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Excellent. 🎯 **This is the exact divergent history we wanted.**

Your graph is:

```text
* c8abb6f (HEAD -> exercise/branch-basics) docs: update feature branch
| * 409445e (main) docs: update main branch
|/
* 02ce2f4 docs: demonstrate branch-specific change
* 4b6a0fa (origin/main) docs: record development environment
...
```

## Read this graph carefully

At `02ce2f4`, both branches were together:

```text
             02ce2f4
             /      \
            /        \
         main       feature
```

Then each branch created its **own commit**:

```text
                 409445e ← main
                /
02ce2f4
                \
                 c8abb6f ← exercise/branch-basics
```

That's genuine branch divergence.

### Your current position

You're currently on:

```text id="8kh5bn"
exercise/branch-basics
```

because:

```text
HEAD -> exercise/branch-basics
```

points to:

```text id="6wqk0s"
c8abb6f
```

Meanwhile:

```text id="2p7r8c"
main -> 409445e
```

---

# Why this is different from the previous merge

Previously:

```text
A ── B ── C
         ▲
         └── feature
```

`main` could simply move forward to `C`.

That was a **fast-forward**.

Now:

```text
              409445e ← main
             /
02ce2f4
             \
              c8abb6f ← feature
```

Git cannot simply move one branch pointer forward without losing the other branch's commit.

Git now has to **combine two lines of development**.

That's the real purpose of merging.

---

# Now let's merge

We'll merge the feature branch into `main`.

First switch to `main`:

```bash id="w0lcv5"
git switch main
```

Verify:

```bash id="0b15p0"
git branch --show-current
```

It should say:

```text
main
```

Then:

```bash id="x4p3wa"
git merge exercise/branch-basics
```

### Important

**Stop immediately after `git merge`.**

Don't try to fix anything yet.

Git may produce a conflict because both branches changed the same file.

That's not a failure.

In fact, **that's exactly what we're trying to learn.**

If you see:

```text
CONFLICT
```

don't panic and don't run random commands.

Just paste the complete merge output here.

If Git successfully merges without a conflict, that's also useful evidence.

Run:

```bash id="l7j4om"
git switch main
git merge exercise/branch-basics
```

and show me the output.


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git switch main
Switched to branch 'main'
Your branch is ahead of 'origin/main' by 2 commits.
  (use "git push" to publish your local commits)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git branch --show-current
main
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git merge exercise/branch-basics
Auto-merging evidence/environment.md
CONFLICT (content): Merge conflict in evidence/environment.md
Automatic merge failed; fix conflicts and then commit the result.
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Excellent. 🎯 **You have just created a real merge conflict.**

And importantly: **nothing went wrong.**

This is exactly the scenario we intentionally created.

Git says:

```text
Auto-merging evidence/environment.md
CONFLICT (content): Merge conflict in evidence/environment.md
Automatic merge failed; fix conflicts and then commit the result.
```

Git is telling you:

> "Both branches changed the same part of the same file, and I cannot safely decide which version should win."

---

# First: understand the current state

Before the merge:

```text
              409445e ← main
             /
02ce2f4
             \
              c8abb6f ← exercise/branch-basics
```

You asked Git:

```text
merge exercise/branch-basics
```

while on `main`.

Git attempted:

```text
main
 │
 ▼
409445e
 │
 ├── changes from main
 │
 └── changes from feature
```

But both branches modified `evidence/environment.md` in the same area.

So Git stopped.

---

# What does "conflict" actually mean?

It does **not** mean:

> "Git is broken."

It means:

> **Git needs a human to decide what the final content should be.**

Git can usually combine changes automatically.

But imagine:

### `main` says:

```text
## Main Branch Update

This change was made on main.
```

while the feature branch says:

```text
## Feature Branch Update

This change was made on the feature branch.
```

Git cannot know whether you want:

### Choice A

```text
## Main Branch Update

This change was made on main.
```

### Choice B

```text
## Feature Branch Update

This change was made on the feature branch.
```

### Choice C

```text
## Main Branch Update

This change was made on main.

## Feature Branch Update

This change was made on the feature branch.
```

A developer has to decide.

---

# Step 1 — Inspect the conflict

**Do not edit the file yet.**

Run:

```bash id="5rmyq5"
git status
```

Then:

```bash id="r5t4r5"
git diff
```

The `git diff` output should contain conflict markers similar to:

```text id="d8w2qf"
<<<<<<< HEAD
## Main Branch Update

This change was made on main.
=======
## Feature Branch Update

This change was made on the feature branch.
>>>>>>> exercise/branch-basics
```

These markers are extremely important.

### What they mean

```text id="ujp8m4"
<<<<<<< HEAD
```

means:

> Start of the version from the branch you're currently on (`main`).

Then:

```text id="i8g4cj"
=======
```

means:

> Boundary between the two versions.

And:

```text id="j1t2qk"
>>>>>>> exercise/branch-basics
```

means:

> End of the incoming branch's version.

So:

```text id="2h7xq8"
<<<<<<< HEAD
        MAIN VERSION
=======
        FEATURE VERSION
>>>>>>> exercise/branch-basics
```

Git has essentially handed the decision to you.

---

## Your task

Run:

```bash id="o0p1q2"
git status
```

and:

```bash id="b3c4d5"
git diff
```

**Do not run `git add`, `git commit`, or `git merge --abort` yet.**

Paste the outputs.

Then we'll resolve the conflict **manually and deliberately**, rather than letting an editor or command hide what Git is actually doing.


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is ahead of 'origin/main' by 2 commits.
  (use "git push" to publish your local commits)

You have unmerged paths.
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

no changes added to commit (use "git add" and/or "git commit -a")
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
diff --cc evidence/environment.md
index 378374b,ef2325e..0000000
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@@ -81,6 -81,6 +81,12 @@@ Environment inspected on 2026-08-19

  This change exists on the branch-basics branch.

++<<<<<<< HEAD
 +## Main Branch Update
 +
- This change was made on main.
++This change was made on main.
++=======
:

Good. You're still in the **merge-conflict state**, and your output tells us something important:

### `git diff`

The conflict markers are no longer showing:

```text
<<<<<<< HEAD
=======
>>>>>>> exercise/branch-basics
```

So you've successfully edited the file and removed the conflict markers. ✅

But `git status` still says:

```text
You have unmerged paths.
```

That's expected.

Git does **not** automatically consider the conflict resolved just because you edited the file.

---

# The key distinction

Right now:

```text
Working tree
     │
     ▼
resolved file
     │
     │  BUT
     ▼
Git still says:
"unmerged"
```

You need to tell Git:

> "I have reviewed this file and this is the final version I want."

That's what `git add` means **during conflict resolution**.

---

## Step 1 — Stage the resolved file

Run:

```bash
git add evidence/environment.md
```

Then:

```bash
git status
```

You should now see something similar to:

```text
All conflicts fixed but you are still merging.
```

and:

```text
Changes to be committed:
    modified: evidence/environment.md
```

### Don't commit yet.

Paste the output of:

```bash
git status
```

Then we'll inspect the staged merge result before creating the merge commit.


Exactly right. ✅ **The conflict is now resolved and staged.**

Your status says:

```text
All conflicts fixed but you are still merging.
(use "git commit" to conclude merge)
```

This is an important Git state.

## Your repository right now

You had two histories:

```text
              409445e ◄── main
             /
02ce2f4
             \
              c8abb6f ◄── exercise/branch-basics
```

You resolved the conflicting file and staged the resolution.

Git is now ready to create a **merge commit**:

```text
              409445e
             /       \
            /         \
       02ce2f4       c8abb6f
            \         /
             \       /
              MERGE COMMIT
                    ▲
                    │
                   main
```

This is different from your earlier fast-forward merge.

### Earlier

```text
4b6a0fa ──► 02ce2f4
             ▲
             │
            main
```

No merge commit was needed.

### This time

```text
             409445e
            /       \
       02ce2f4      c8abb6f
            \       /
             MERGE
```

Git needs a new commit with **two parents** because there were two independent lines of development.

---

# Before committing: inspect the staged resolution

Run:

```bash
git diff --cached
```

This is especially important because you should always inspect what you're about to commit.

Look at the output and verify that the final version contains both:

```text
## Main Branch Update
```

and:

```text
## Feature Branch Update
```

and that there are **no conflict markers**:

```text
```

### Don't commit yet.

Paste the output of:

```bash
git diff --cached
```

Then I'll have you make the merge commit and we'll inspect its two-parent history.


Good. ✅ You inspected the **staged merge result** before committing.

Your `git diff --cached` shows the resolved version contains:

```text
## Main Branch Update

This change was made on main.
```

And importantly, there are **no conflict markers** such as:

```text
<<<<<<<
=======
>>>>>>>
```

So Git has a valid resolution staged.

One thing to notice: your staged diff output ends at the main-branch section, but that's okay—the feature-branch content already existed in the common file and therefore isn't necessarily shown as a new change in this particular diff.

## Now conclude the merge

Run:

```bash
git commit -m "merge: resolve branch updates"
```

Git may open an editor with a generated merge message, or it may accept the message directly depending on your configuration.

Then run:

```bash
git status
```

and:

```bash
git log --oneline --decorate --graph --all -6
```

**Do not push yet.**

We're going to inspect the resulting merge commit and, specifically, prove that it has **two parents**. That will complete your understanding of the difference between:

* fast-forward merge
* merge commit
* merge conflict
* conflict resolution

Excellent. 🎯 **You have successfully created a real merge commit.**

This graph is the most important result of this entire exercise:

```text
*   4483d9f (HEAD -> main) merge: resolve branch updates
|\
| * c8abb6f (exercise/branch-basics) docs: update feature branch
* | 409445e docs: update main branch
|/
* 02ce2f4 docs: demonstrate branch-specific change
* 4b6a0fa (origin/main) docs: record environment inspection status
```

## What `4483d9f` represents

Your merge commit:

```text
4483d9f
```

has **two parents**:

```text
        4483d9f
        /     \
       /       \
  409445e    c8abb6f
    main      feature
```

That's why the graph has:

```text
|\
```

instead of a straight line.

### Parent 1

```text
409445e
```

was the state of `main` before the merge.

### Parent 2

```text
c8abb6f
```

was the feature branch's state.

The merge commit combines both histories.

---

# Compare this with your fast-forward merge

Earlier you had:

```text
4b6a0fa → 02ce2f4
```

Git simply moved the `main` pointer.

No additional commit was necessary.

This time:

```text
       409445e
      /       \
02ce2f4       4483d9f
      \       /
       c8abb6f
```

Git needed a new commit because the histories had diverged.

---

# Your `git status` also tells us something

```text
Your branch is ahead of 'origin/main' by 4 commits.
```

That's expected.

Your local history contains commits that GitHub doesn't have yet:

```text
4b6a0fa  ← origin/main
   │
   ├── 02ce2f4
   ├── 409445e
   ├── c8abb6f
   └── 4483d9f
```

The **untracked files** are separate and have nothing to do with the merge:

```text
docs/...
exercises/...
```

We're deliberately leaving those alone for now.

---

# One final proof

Let's prove that the merge commit actually has two parents.

Run:

```bash
git show --no-patch --pretty=raw HEAD
```

You should see something similar to:

```text
commit 4483d9f...
tree ...

parent 409445e...
parent c8abb6f...
author ...
committer ...

    merge: resolve branch updates
```

Notice there are **two `parent` lines**.

That's the technical definition of what we just created.

Paste that output.

After that, we'll do a short checkpoint quiz covering:

1. working tree
2. staging
3. commits
4. branches
5. fast-forward merges
6. merge commits
7. merge conflicts
8. conflict resolution

Then we'll move forward to **GitHub branches and pull requests**.
