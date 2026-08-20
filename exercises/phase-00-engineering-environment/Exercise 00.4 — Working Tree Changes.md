## Next: Exercise 00.4 — Working Tree Changes

Now we're going to deliberately modify an **already tracked file**.

This is where you'll see the difference between:

> **untracked file**

and

> **modified tracked file**

For the next exercise, we'll use:

```text
evidence/environment.md
```

Open it and make **one small change**.

For example, add this at the bottom:

```markdown
## Inspection Status

Environment inspected on 2026-08-19.
```

**Don't run `git add` yet.**

After saving the file, run:

```bash
git status
```

and:

```bash
git diff
```

Paste both outputs.

This time, we're going to study what happens when a file already exists in Git history and you modify it.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

no changes added to commit (use "git add" and/or "git commit -a")
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
diff --git a/evidence/environment.md b/evidence/environment.md
index 2d5f024..8686481 100644
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@ -71,4 +71,8 @@ gradle --version
 Output:

 'gradle' is not recognized as an internal or external command,
-operable program or batch file.
\ No newline at end of file
+operable program or batch file.
+
+## Inspection Status
+

Excellent. ✅ This is the exact state we wanted.

You've now moved from **untracked files** to **modifying a tracked file**.

## What `git status` tells us

Git says:

```text
modified: evidence/environment.md
```

This is different from what we saw earlier.

Earlier:

```text
Untracked files:
    evidence/
```

meant Git had **never committed the file**.

Now:

```text
Changes not staged for commit:
    modified: evidence/environment.md
```

means:

> Git already knows about `environment.md`, but the working-tree version is different from the version in the latest commit.

---

## What `git diff` tells us

This part is especially important:

```text
@@ -71,4 +71,8 @@
```

Git is showing the difference between:

```text
HEAD / last commit
        ↓
working tree
```

You can see the original ending:

```text
-operable program or batch file.
```

and the newly added content:

```text
+operable program or batch file.

+## Inspection Status
```

The `+` means **new content in your working tree**.

So right now:

```text
Git History
    │
    │ version A
    ▼
Staging Area
    │
    └── empty

Working Tree
    │
    │ version B
    └── environment.md modified
```

### Notice something important

Your staging area is empty.

You changed the file **after the previous commit**, but you haven't staged that change yet.

Therefore:

```text
git diff
```

shows the modification.

And if you ran:

```text
git diff --cached
```

right now, it would show nothing.

---

# Your turn — checkpoint

Before we stage this change, answer:

**Q1.** Is `environment.md` tracked by Git?

**Q2.** Where is your new `## Inspection Status` change right now?

**Q3.** Is that change staged?

**Q4.** Is that change already part of the latest commit?

Answer those four in your own words.
You're **3 out of 4 correct**. 👍

The only issue is **Q1**, and this distinction is very important.

### Q1. Is `environment.md` tracked?

You answered:

> not yet tracked

❌ **It is already tracked.**

Remember, we committed and pushed it earlier:

```text
417bc4b docs: record development environment
```

That commit contains:

```text
evidence/environment.md
```

So Git already knows about the file.

The current state is:

```text
environment.md
        │
        ├── tracked by Git ✅
        │
        └── modified in working tree ⚠️
```

---

### Q2. Where is the new change?

You answered:

> working tree

✅ Correct.

The `## Inspection Status` addition currently exists only in the working tree.

---

### Q3. Is it staged?

> not yet

✅ Correct.

Your `git status` explicitly says:

```text
Changes not staged for commit:
    modified: evidence/environment.md
```

---

### Q4. Is it in the latest commit?

> no

✅ Correct.

The latest commit is still:

```text
417bc4b
```

and it contains the **previous version** of `environment.md`.

---

## The key distinction

This is the mental model I want you to keep:

```text
              environment.md

Git History
    │
    │  tracked version
    │
    ▼
Working Tree
    │
    │  modified version
    │
    └── "Inspection Status" ← NEW
```

Being **tracked** and being **staged** are two completely different concepts.

A file can be:

* tracked but unmodified
* tracked and modified
* tracked and staged
* tracked, staged, then modified again

You're now experiencing the second case:

> **tracked + modified + unstaged**

---

# Next experiment

Now stage the modification:

```bash
git add evidence/environment.md
```

Then run:

```bash
git status
```

and:

```bash
git diff
```

and:

```bash
git diff --cached
```

This time, I want you to observe the transition:

```text
Working Tree
    │
    │ git add
    ▼
Staging Area
```

**Don't commit yet.**

Paste the outputs, and we'll compare them to what you just saw.


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git add evidence/environment.md
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff --cached
diff --git a/evidence/environment.md b/evidence/environment.md
index 2d5f024..8686481 100644
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@ -71,4 +71,8 @@ gradle --version
 Output:

 'gradle' is not recognized as an internal or external command,
-operable program or batch file.
\ No newline at end of file
+operable program or batch file.
+
+## Inspection Status
+

Perfect. ✅ **You just demonstrated the tracked-file staging workflow correctly.**

Your outputs show a clean transition.

### Before `git add`

You had:

```text
Working Tree
└── environment.md ← modified

Staging Area
└── empty
```

So:

```bash
git diff
```

showed the modification.

---

### After `git add`

Git now says:

```text
Changes to be committed:
    modified: evidence/environment.md
```

And:

```bash
git diff
```

shows **nothing**.

That's because:

> The working tree and staging area now contain the same version.

Meanwhile:

```bash
git diff --cached
```

shows:

```text
+## Inspection Status
```

That means the modification is now **staged** and is ready to become part of the next commit.

---

## Notice the three versions

This is one of the most important Git concepts:

```text
                    environment.md

        HEAD              STAGING             WORKING TREE
         │                   │                     │
         │                   │                     │
         ▼                   ▼                     ▼
     old version        new version           new version
     417bc4b             staged               current
```

Or conceptually:

```text
HEAD
 │
 │ git add
 ▼
Staging Area
 │
 │ git commit
 ▼
New Git History
```

And right now you're here:

```text
HEAD
 │
 ├── old version
 │
 ▼
STAGING AREA
 └── new version ✅
        │
        ▼
WORKING TREE
 └── same new version ✅
```

### The really important lesson

`git add` does **not** mean:

> "Add this file permanently to Git."

It means:

> **"Take the current version of this file and place that snapshot into the staging area for the next commit."**

That's why you had to run `git add` again after modifying the file.

---

# One more Git experiment

We're going to make this even more interesting.

**Do not commit yet.**

With `environment.md` currently staged, make **another small change** to the file.

Add one more line underneath your `Inspection Status` section, for example:

```text
Maven and Gradle require installation before use.
```

Save the file.

Then run:

```bash
git status
```

and:

```bash
git diff
```

and:

```bash
git diff --cached
```

This will create the state:

```text
HEAD
 │
 │ old version
 ▼
Staging Area
 │
 │ first modification
 ▼
Working Tree
 │
 └── second modification
```

You'll see something that often surprises people when they first learn Git:

> **The same file can simultaneously have staged changes AND unstaged changes.**

That's the next concept I want you to experience firsthand.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
        modified:   evidence/environment.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

diff --git a/evidence/environment.md b/evidence/environment.md
index 8686481..bfaf884 100644
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@ -75,4 +75,5 @@ operable program or batch file.

 ## Inspection Status

-Environment inspected on 2026-08-19.
\ No newline at end of file
+Environment inspected on 2026-08-19.
+Maven and Gradle require installation before use.
\ No newline at end of file
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff --cached
diff --git a/evidence/environment.md b/evidence/environment.md
index 2d5f024..8686481 100644
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@ -71,4 +71,8 @@ gradle --version
 Output:

 'gradle' is not recognized as an internal or external command,
-operable program or batch file.
\ No newline at end of file
+operable program or batch file.
+
+## Inspection Status

Excellent. 🎯 **You have just demonstrated one of the most important Git states: the same file can have both staged and unstaged changes at the same time.**

Your output proves it.

## Let's carefully read what Git is telling you

`git status` shows:

```text
Changes to be committed:
    modified: evidence/environment.md
```

AND:

```text
Changes not staged for commit:
    modified: evidence/environment.md
```

That is **not a contradiction**.

It means Git sees **two different changes** to the same file.

---

### What is staged?

Your `git diff --cached` shows:

```text id="7qjz6j"
+## Inspection Status
```

and:

```text id="o4by0x"
+Environment inspected on 2026-08-19.
```

Those changes are in the **staging area**.

They will be included if you commit right now.

---

### What is NOT staged?

Your `git diff` shows:

```text id="h1k2lm"
+Maven and Gradle require installation before use.
```

That change exists only in your **working tree**.

It will **NOT** be included if you commit right now.

---

# You now have three versions

This is the important mental model:

```text
                         environment.md

       HEAD              STAGING              WORKING TREE
        │                   │                     │
        ▼                   ▼                     ▼
   old version       Inspection Status     Inspection Status
                     + inspected date      + inspected date
                                          + Maven/Gradle line
```

More visually:

```text
Git History
    │
    │ old version
    ▼
Staging Area
    │
    │ + Inspection Status
    │ + inspected date
    ▼
Working Tree
    │
    │ + Maven/Gradle line
    ▼
current file
```

### This means something very important

If you ran:

```bash
git commit -m "..."
```

**right now**, Git would commit the staged version:

```text
Inspection Status
Environment inspected on 2026-08-19.
```

But **not**:

```text
Maven and Gradle require installation before use.
```

That second change would remain in your working tree.

---

# This is why the staging area exists

The staging area gives you control over **exactly what goes into the next commit**.

You could intentionally have:

```text
File A
 ├── changes staged
 └── more changes unstaged
```

and commit only the first set.

This is one reason professional Git workflows don't simply rely on:

```bash
git add .
```

without inspecting what they're doing.

---

## Checkpoint

Answer these four:

**Q1.** If you committed right now, would the Maven/Gradle sentence be included?

**Q2.** Where is the Maven/Gradle sentence currently?

**Q3.** Where is `Environment inspected on 2026-08-19.` currently?

**Q4.** Can the same file have both staged and unstaged changes?

Answer in your own words.

Excellent. **4/4 correct.** 🎯

You've now got the distinction that many beginners struggle with:

```text
HEAD
 │
 │ old committed version
 ▼
STAGING AREA
 │
 │ first set of changes
 ▼
WORKING TREE
 │
 │ additional changes
 ▼
current file
```

And your answers demonstrate that you understand it rather than just recognizing the commands.

### Your current repository state

```text
environment.md

HEAD
└── original committed version

STAGING AREA
├── ## Inspection Status
└── Environment inspected on 2026-08-19.

WORKING TREE
├── everything staged above
└── Maven and Gradle require installation before use.
```

This is a **real, useful Git state**.

---

# Exercise 00.4 — Selective commit

Now let's make the concept practical.

We want our next commit to contain the **staged changes**, but **not** the latest Maven/Gradle sentence.

So **do not run `git add` again**.

Instead, commit what is already staged:

```bash
git commit -m "docs: record environment inspection status"
```

Then run:

```bash
git status
```

### What should happen?

The commit should contain:

```text
## Inspection Status
Environment inspected on 2026-08-19.
```

But this should remain **unstaged**:

```text
Maven and Gradle require installation before use.
```

So after the commit, Git should report something like:

```text
Changes not staged for commit:
    modified: evidence/environment.md
```

That would prove that the commit used the **staging area snapshot**, not whatever happens to be in the working tree at commit time.

**Run the commit and `git status`, then paste both outputs.**

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git commit -m "docs: record environment inspection status"
[main 4b6a0fa] docs: record environment inspection status
 1 file changed, 5 insertions(+), 1 deletion(-)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is ahead of 'origin/main' by 1 commit.
  (use "git push" to publish your local commits)

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)       
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

no changes added to commit (use "git add" and/or "git commit -a")
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Exactly. 🎯 **This is a perfect demonstration of why the staging area exists.**

Your commit succeeded:

```text
4b6a0fa docs: record environment inspection status
```

And Git reports:

```text
1 file changed, 5 insertions(+), 1 deletion(-)
```

But immediately afterward, `git status` still says:

```text
Changes not staged for commit:
    modified: evidence/environment.md
```

That remaining modification is the **Maven/Gradle sentence** that you intentionally did not stage.

## What just happened

Before the commit:

```text
HEAD
└── 417bc4b

STAGING AREA
├── Inspection Status
└── Environment inspected on 2026-08-19

WORKING TREE
├── staged changes above
└── Maven and Gradle require installation before use.
```

You ran:

```bash
git commit -m "docs: record environment inspection status"
```

Git committed **only the staging area**:

```text
417bc4b
   │
   │ commit
   ▼
4b6a0fa
docs: record environment inspection status
```

The unstaged change stayed in your working tree.

### Your current state

```text
Git History
├── 4b6a0fa  ← latest local commit
└── 417bc4b

Staging Area
└── empty

Working Tree
└── environment.md
      └── Maven and Gradle require installation before use.
```

And your local branch is:

```text
ahead of origin/main by 1 commit
```

because we haven't pushed `4b6a0fa` yet.

---

# One subtle detail

Git says:

```text
5 insertions(+), 1 deletion(-)
```

Why a deletion?

Earlier, your file had:

```text
Environment inspected on 2026-08-19.
```

without a final newline, and your staged version corrected the file ending. Git therefore represented the change as a deletion/addition combination in the diff.

The important part isn't the exact `5/1` count. The important part is:

> **Only the staged snapshot became the commit.**

---

# Exercise 00.4 checkpoint

Let's verify exactly what the new commit contains.

Run:

```bash
git show --stat --oneline HEAD
```

Then:

```bash
git diff
```

Then:

```bash
git diff --cached
```

We expect:

* `git show` → the new commit
* `git diff` → the **Maven/Gradle sentence**
* `git diff --cached` → **nothing**

Paste the outputs, and we'll verify the result before deciding what to do with the remaining working-tree change.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git show --stat --oneline HEAD
4b6a0fa (HEAD -> main) docs: record environment inspection status
 evidence/environment.md | 6 +++++-
 1 file changed, 5 insertions(+), 1 deletion(-)
diff --git a/evidence/environment.md b/evidence/environment.md
index 8686481..bfaf884 100644
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@ -75,4 +75,5 @@ operable program or batch file.
 
 ## Inspection Status
 
-Environment inspected on 2026-08-19.
\ No newline at end of file
+Environment inspected on 2026-08-19.
+Maven and Gradle require installation before use.
\ No newline at end of file
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff --cached
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Excellent. ✅ **You verified the result exactly.**

There is one subtle point in your output that is worth understanding.

### 1. `git show --stat --oneline HEAD`

You got:

```text
4b6a0fa (HEAD -> main) docs: record environment inspection status
 evidence/environment.md | 6 +++++-
```

This confirms that `4b6a0fa` is your latest commit and it contains the staged changes.

---

### 2. `git diff`

Your output shows:

```text
+Maven and Gradle require installation before use.
```

This is the **remaining working-tree change**.

It was **not included** in `4b6a0fa`.

So:

```text
HEAD
└── 4b6a0fa
      └── does NOT contain Maven/Gradle sentence

Working Tree
└── DOES contain Maven/Gradle sentence
```

---

### 3. `git diff --cached`

You got:

```text
PS ...> git diff --cached
PS ...>
```

No output. ✅

That means:

> **Nothing is currently staged.**

So your current state is:

```text
                 Git History
                      │
                      ▼
                   4b6a0fa
                      │
                      │
                 Staging Area
                      │
                    EMPTY
                      │
                      ▼
                 Working Tree
                      │
                      └── Maven and Gradle sentence
```

You've now demonstrated that a commit takes its content from the **staging area**, not directly from the working tree.

---

# Exercise 00.4 — COMPLETE 🎯

You have successfully demonstrated:

* tracked vs untracked
* modified tracked files
* unstaged changes
* staged changes
* `git diff`
* `git diff --cached`
* staged + unstaged changes in the same file
* committing only staged changes

That's a major Git milestone.

## One cleanup decision

We now have this change sitting in your working tree:

```text
Maven and Gradle require installation before use.
```

Before we move on, **you decide what happens to it**.

There are two valid Git operations:

### Option A — Keep the change

Stage it:

```bash
git add evidence/environment.md
```

Then commit it.

### Option B — Discard the change

Restore the working tree version:

```bash
git restore evidence/environment.md
```

This would remove the Maven/Gradle sentence from the working tree and return the file to the version in `HEAD`.

**Don't run either yet.**

Which do you choose: **A (keep)** or **B (discard)**?

Good choice. **B — discard the change.** 👍

This is a good opportunity to learn that `git restore` works on the **working tree**.

Right now:

```text
HEAD
└── 4b6a0fa
      │
      │ does NOT contain Maven/Gradle sentence
      ▼
Working Tree
└── contains Maven/Gradle sentence ← discard this
```

Run:

```bash
git restore evidence/environment.md
```

Then verify with:

```bash
git status
```

and:

```bash
git diff
```

### Expected result

`git diff` should produce **no output**, because you've restored the working tree to match `HEAD`.

You should still see your other untracked files:

```text
docs/...
exercises/...
```

Those are unrelated and should remain untouched.

Paste the `git status` output here after running the restore.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git restore evidence/environment.md
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
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Perfect. ✅ **You restored the working tree successfully.**

Your results confirm:

```text
git diff
```

produces **no output**, meaning there are no modifications to tracked files.

### Your current state

```text id="o0v4li"
GitHub / origin/main
        │
        ▼
    417bc4b

Local main
        │
        ▼
    4b6a0fa  ← one commit ahead
        │
        ▼
Working Tree
    clean ✅
```

The only remaining items are untracked:

```text id="1u2c4v"
docs/...
exercises/...
```

Those are still untouched, which is exactly what we want.

### Important lesson from `git restore`

You just used:

```bash id="q2y6zn"
git restore evidence/environment.md
```

to say:

> **"Discard my working-tree changes and restore this tracked file to the version from the current `HEAD`."**

And because the change was **not staged**, this was safe in the context of our exercise.

A useful distinction:

```text id="zqk3v4"
git restore file
        ↓
restore WORKING TREE

git restore --staged file
        ↓
remove from STAGING AREA
```

We'll practice the second one later.

---

# Exercise 00.4 COMPLETE ✅

You have now learned the core local Git lifecycle:

```text
Create / modify
      ↓
Working Tree
      ↓ git add
Staging Area
      ↓ git commit
Local History
      ↓ git push
GitHub
```

And you've learned how to move backward:

```text
Working Tree change
      ↓
git restore
      ↓
discard working-tree change
```

---

## One remaining issue

Your local `main` is currently:

```text
ahead of 'origin/main' by 1 commit
```

because `4b6a0fa` hasn't been pushed.

We're **not going to push it immediately**. Instead, before publishing it, I want you to inspect your local history one more time.

Run:

```bash
git log --oneline --decorate -3
```

Then answer:

**Q1.** What commit is `HEAD` pointing to?

**Q2.** What commit is `origin/main` pointing to?

**Q3.** How many commits ahead is local `main`?

This will reinforce the difference between **local history** and **remote history** before we move into branches.
