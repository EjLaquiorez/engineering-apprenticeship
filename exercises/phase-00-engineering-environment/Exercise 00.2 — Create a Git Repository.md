# Exercise 00.2 — Create a Git Repository

Before we start, there's an interesting situation:

Your apprenticeship folder is **already a Git repository**:

```text
engineering-apprenticeship
        │
        └── .git/
```

So we **should not run `git init` here**. Doing so would be unnecessary and would undermine the exercise.

Instead, we'll use this existing repository to inspect how Git was initialized and connected to GitHub.

Run:

```bash
git remote -v
```

Paste the output here.

**Don't change anything yet.** We're going to inspect the repository before manipulating it.


Perfect. ✅ This confirms your local repository is connected to a GitHub remote.

You have:

```text
origin  https://github.com/EjLaquiorez/engineering-apprenticeship.git (fetch)
origin  https://github.com/EjLaquiorez/engineering-apprenticeship.git (push)
```

### What this means

`origin` is simply the conventional name Git gives to the remote repository.

You currently have:

```text
Local repository
C:\Users\ejlqr\Desktop\engineering-apprenticeship
        │
        │ origin
        ▼
GitHub repository
EjLaquiorez/engineering-apprenticeship
```

And there are **two directions**:

* `fetch` → retrieve information/commits from GitHub
* `push` → send your local commits to GitHub

### One important distinction

Earlier, Git told you:

```text
Your branch is up to date with 'origin/main'.
```

That means your **current local `main` branch and the tracked remote `origin/main` are synchronized** with respect to commits.

It does **not** mean your untracked files are automatically on GitHub.

Your `environment.md` is still only in your working tree.

---

## Let's inspect one more thing

Run:

```bash
git branch -vv
```

This will show us:

* your current branch
* which remote branch it tracks
* whether Git considers it ahead/behind

Paste the output here.

Then we'll have a much clearer picture of the repository before we make our first intentional commit.

Excellent. ✅ This gives us the complete picture.

Your output:

```text id="q8j7j8"
* main 598dcc5 [origin/main] initial repo structure
```

### Let's decode it

```text
* main
```

The `*` means **you are currently on the `main` branch**.

```text
598dcc5
```

That's the abbreviated commit ID of your current commit.

```text
[origin/main]
```

Your local `main` branch is tracking the GitHub branch `origin/main`.

```text
initial repo structure
```

That's the commit message of your current commit.

So your repository currently looks like:

```text id="w7u9d5"
                    GitHub
                origin/main
                    │
                    │
                    ▼
Local main ──── 598dcc5
                    │
                    │ initial repo structure
                    │
                    ▼
               Git history
```

And separately, you have untracked files in your working tree:

```text id="4d9q1u"
Working Tree
├── docs/.../00-git-fundamentals.md
├── docs/.../PHASE-00-ENGINEERING-ENVIRONMENT.md
├── evidence/
└── exercises/phase-00-engineering-environment/
```

### This is a very good state for learning

You can now see the difference between:

**Repository history**

```text
598dcc5
initial repo structure
```

and

**Current working tree**

```text
new/untracked files
```

Those new files haven't magically become part of Git history just because they exist inside the repository folder.

---

# Checkpoint — Exercise 00.2

Before we continue, answer these:

**Q1.** What branch are you currently on?

**Q2.** What remote branch does it track?

**Q3.** What is the commit ID of your current commit?

**Q4.** Does `environment.md` exist in the current Git history?

Answer in your own words.
1. main
2. origin/main
3. 598dcc5
4. No, environment.md is not in Git history yet.

Great. Let's proceed. 🔧

## Exercise 00.2 — Staging a Specific File

We currently have several untracked items:

```text
docs/...
evidence/
exercises/...
```

But we **do not** want to stage everything.

Our target is only:

```text
evidence/environment.md
```

This is our first practical exercise in **selective staging**.

### Step 1 — Stage only `environment.md`

Run:

```bash
git add evidence/environment.md
```

Then immediately run:

```bash
git status
```

### What we're looking for

We expect Git to show something conceptually like:

```text
Changes to be committed:
    new file: evidence/environment.md

Untracked files:
    docs/...
    exercises/...
```

That would demonstrate that Git can move **one specific file** from:

```text
Working Tree → Staging Area
```

without staging the other files.

**Don't commit yet.**

Run those two commands and paste the complete `git status` output here.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git add evidence/environment.md
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 


Excellent. ✅ **This is exactly the result we wanted.**

You just performed **selective staging** successfully.

### Let's read your `git status`

Git says:

```text id="8j0y4x"
Changes to be committed:
    new file: evidence/environment.md
```

This means:

> `environment.md` has moved from the **working tree → staging area**.

At the same time, Git still says:

```text id="8v0e5m"
Untracked files:
    docs/...
    exercises/...
```

Those files are **still only in the working tree**.

### Your repository state now

```text id="j9z8z6"
WORKING TREE
├── docs/...                         ← untracked
├── exercises/...                    ← untracked
└── evidence/environment.md          ← staged
                 │
                 │
                 ▼
          STAGING AREA
          └── environment.md
                 │
                 │ git commit
                 ▼
          GIT HISTORY
          └── not there yet
```

This is the exact Git state you were describing earlier in theory.

Now you're actually manipulating it. 🎯

---

## Important question

Before we commit anything, let's verify **what exactly is staged**.

Run:

```bash id="5i5gk6"
git diff --cached
```

The `--cached` option means:

> "Show me the changes currently in the staging area."

Look through the output.

Then paste it here.

**Don't commit yet.** We're going to inspect the staged content before allowing it into Git history.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff --cached
diff --git a/evidence/environment.md b/evidence/environment.md
new file mode 100644
index 0000000..9817a1d
--- /dev/null
+++ b/evidence/environment.md
@@ -0,0 +1,83 @@
+# Environment Inspection
+
+## Operating System
+
+Windows
+
+## IDE
+
+VS Code
+
+## Git
+
+Command:
+
+```bash
+git --version
+````
+
+Output:
+
+git version 2.53.0.windows.2
+
+## Java
+
+Command:
+
+```bash
+java --version
+```
+
+Output:
+
+java 21.0.11 2026-04-21 LTS
+Java(TM) SE Runtime Environment (build 21.0.11+9-LTS-211)
+Java HotSpot(TM) 64-Bit Server VM (build 21.0.11+9-LTS-211, mixed mode, sharing)
+
+
+## Java Compiler
+
+Command:
+
+```bash
+javac --version
+```
+
+Output:
+
+javac 21.0.11
+
+
+## Maven
+
+Command:
+
+```bash
+mvn --version
+```
+
+Output:
+
+'mvn' is not recognized...
+
+## Gradle
+
+Command:
+
+```bash
+gradle --version
+```
+
+Output:
+
+'gradle' is not recognized as an internal or external command,
+operable program or batch file.
+
+```
+
+**Do not invent or manually type the version numbers. Copy the actual terminal output.**
+
+Then show me the results.
+
+I will inspect them with you and we'll determine whether your environment is actually ready before moving to **Exercise 00.2 — Create a Git Repository**.
+```
(END)

Excellent. **Your understanding is correct.** ✅

You've just demonstrated an important Git concept.

### Q1 — `git diff`

You got:

> nothing

✅ Correct.

Why?

Because there are **no unstaged changes** to `environment.md`.

The file's current contents in your working tree match what's currently staged.

---

### Q2 — `git diff --cached`

You got the full diff for:

```text
evidence/environment.md
```

✅ Correct.

That command shows what is **currently staged and therefore would be included in the next commit**.

So your state is:

```text
Working Tree
    │
    │  same as staged version
    ▼
Staging Area
    │
    └── evidence/environment.md
             │
             │ next: git commit
             ▼
Git History
    └── not there yet
```

### One thing I noticed

Your `environment.md` contains some of the instructional text at the bottom:

```text
**Do not invent or manually type the version numbers...**
...
I will inspect them with you...
```

That came from the example I gave you earlier.

**Don't worry about it—we caught it before committing.** This is exactly why we're practicing:

> **Stage → Inspect → Commit**

You should remove those instructional lines so the evidence file contains **only your environment evidence**.

Also, I noticed this:

```text
```

```
```

around the Git section. Your Markdown fence has an extra backtick. Let's clean that up too.

### Do this now

Edit `evidence/environment.md` and remove:

* The instructional text after the Gradle output.
* The extra/mismatched Markdown backticks.

Then save the file.

Because the file is **already staged**, your working tree will now differ from the staged version.

Run:

```bash
git status
```

Then:

```bash
git diff
```

This time, **I expect `git diff` to show your cleanup**, while `git diff --cached` will still show the old staged version.

That's our next lesson:

**A staged file can be modified again without automatically changing the staging area.**


this is git diff PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
diff --git a/evidence/environment.md b/evidence/environment.md
index 9817a1d..2d5f024 100644
--- a/evidence/environment.md
+++ b/evidence/environment.md
@@ -71,13 +71,4 @@ gradle --version
 Output:

 'gradle' is not recognized as an internal or external command,
-operable program or batch file.
-
-```
-
-**Do not invent or manually type the version numbers. Copy the actual terminal output.**
-
:

this is git diff --cached

diff --git a/evidence/environment.md b/evidence/environment.md
new file mode 100644
index 0000000..9817a1d
--- /dev/null
+++ b/evidence/environment.md
@@ -0,0 +1,83 @@
+# Environment Inspection
+
+## Operating System
+
+Windows
+
+## IDE
+
:

Yes. **This is exactly the behavior we wanted you to observe.** ✅

You've just encountered one of the most important Git concepts in practice.

## What happened?

You had this sequence:

```text
1. environment.md created
        ↓
2. git add environment.md
        ↓
3. Staging area contains version A
        ↓
4. You edited environment.md
        ↓
5. Working tree now contains version B
```

Git therefore sees **two versions**:

```text
Working Tree
    │
    │ version B ← your cleaned-up file
    │
    ▼
Staging Area
    │
    │ version A ← older staged version
    │
    ▼
Git History
    │
    └── nothing yet
```

That's why:

### `git diff`

shows:

````text
-operable program or batch file.
-
-```
-
-**Do not invent...
````

Those lines exist in the **staged version**, but you removed them from the **working tree**.

So `git diff` is essentially saying:

> "Your working tree is different from what's staged."

---

### `git diff --cached`

still shows the old 83-line version.

That's because:

> **Editing a file does NOT automatically update the staging area.**

The staging area is a **snapshot**.

---

# Now let's fix the staging area

You've cleaned the file, so we want the staging area to contain the new version.

Run:

```bash
git add evidence/environment.md
```

Then:

```bash
git status
```

Then:

```bash
git diff
```

And finally:

```bash
git diff --cached
```

### What we expect

After `git add`:

```text
git diff
```

should show **nothing**.

And:

```text
git diff --cached
```

should show the **cleaned version**.

This demonstrates:

```text
Working Tree
     │
     │ git add
     ▼
Staging Area
```

Once you've run those three checks, paste the results here.

**Still don't commit yet.** We're going to inspect the final staged snapshot first.


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git add evidence/environment.md
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   evidence/environment.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git diff --cached
diff --git a/evidence/environment.md b/evidence/environment.md
new file mode 100644
index 0000000..2d5f024
--- /dev/null
+++ b/evidence/environment.md
@@ -0,0 +1,74 @@
+# Environment Inspection
+
+## Operating System
+
+Windows
+
+## IDE
+
:

Perfect. ✅ **You executed that correctly.**

And now you can see the complete staging workflow in action.

### Your current state

`git diff` produced nothing:

```text
git diff
PS ...
```

That means:

> **Working tree = staging area**

There are no unstaged modifications.

Then `git diff --cached` shows:

```text
new file mode 100644
...
@@ -0,0 +1,74 @@
+# Environment Inspection
```

That means:

> **This 74-line version of `environment.md` is the exact snapshot currently staged for the next commit.**

So your state is now:

```text id="y1q7y0"
              WORKING TREE
                    │
                    │ identical
                    ▼
             STAGING AREA
                    │
             environment.md
                    │
                    │ git commit
                    ▼
               GIT HISTORY
                    │
                    └── not yet committed
```

And the other files remain:

```text
Untracked:
docs/...
exercises/...
```

They are safely **not part of the staged snapshot**.

---

# Now we're ready to commit

But before doing so, I want you to perform one final professional habit:

```bash
git diff --cached --check
```

This checks the staged changes for common whitespace errors.

Run that command.

### If it produces no output

That's good. It means Git found no whitespace errors that this check detects.

Then **don't commit yet**—tell me what the command outputs, and we'll make the first commit together.


Exactly. ✅

**No output means the check passed.**

You've now completed the full inspection cycle:

```text
Create file
    ↓
git add
    ↓
Inspect staged content
    ↓
Edit file
    ↓
Notice staged ≠ working tree
    ↓
git add again
    ↓
Inspect staged content again
    ↓
git diff --cached --check
    ↓
READY TO COMMIT
```

## Your current Git state

```text
Working Tree
│
├── evidence/environment.md   ✅ clean
├── docs/...                  ⚠ untracked
└── exercises/...             ⚠ untracked
          │
          ▼
Staging Area
└── evidence/environment.md   ✅ staged
          │
          ▼
Git History
└── not committed yet
```

This is an excellent point to make your **first intentional commit**.

### Step 1 — Commit only the staged file

Run:

```bash
git commit -m "docs: record development environment"
```

Notice that we're **not** using:

```bash
git commit -am "..."
```

or:

```bash
git add .
```

because we deliberately want **only `environment.md`** in this commit.

After the commit finishes, run:

```bash
git status
```

Paste the **entire output of both commands** here.

Then we'll inspect the commit and verify that Git history now contains exactly what we intended.


PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git commit -m "docs: record development environment"
[main 417bc4b] docs: record development environment   
 1 file changed, 74 insertions(+)
 create mode 100644 evidence/environment.md
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

Excellent. 🎯 **You just created your first intentional commit in this apprenticeship.**

Your commit:

```text
417bc4b docs: record development environment
```

Git confirms:

```text
1 file changed, 74 insertions(+)
create mode 100644 evidence/environment.md
```

So exactly **one file** entered Git history.

## Your Git model is now real

Before the commit:

```text
Working Tree
    │
    ▼
Staging Area
    │
    │ git commit
    ▼
Git History
```

After the commit:

```text
Working Tree
    │
    └── clean for tracked files

Staging Area
    │
    └── empty

Git History
    │
    ├── 417bc4b  ← NEW
    │   docs: record development environment
    │
    └── 598dcc5  ← initial repo structure
```

And Git tells you:

```text
Your branch is ahead of 'origin/main' by 1 commit.
```

That means your **local history has one commit that GitHub doesn't have yet**.

We will **not push yet**. That's another concept we'll learn deliberately.

### Also notice this

These remain untracked:

```text
docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
exercises/phase-00-engineering-environment/
```

Your commit did **not** accidentally include them.

That's selective staging working exactly as intended.

---

# Exercise 00.2 — Final verification

Let's inspect the commit we just created.

Run:

```bash
git show --stat --oneline HEAD
```

Then:

```bash
git log --oneline -3
```

Paste both outputs.

We're going to verify that:

1. `417bc4b` is your latest commit.
2. The commit contains only `evidence/environment.md`.
3. `598dcc5` is still the previous commit.

Then we'll mark **Exercise 00.2 complete** and move into the next Git concept.
