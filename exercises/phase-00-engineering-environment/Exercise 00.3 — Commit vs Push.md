# Exercise 00.3 — Commit vs Push

Before touching the terminal, answer these in your own words:

**Q1.** Where does `git commit` create the new commit?

**Q2.** Where does `git push` send commits?

**Q3.** Based on your current `git status`, is `417bc4b` already on GitHub?

**Q4.** If you deleted the `.git` folder right now, would the committed history still exist in your local project folder?

Take your time. These four questions are more important than memorizing the commands.

Good. **Q1–Q3 are correct.** Q4 is the one we need to clarify.

### Q1 — `git commit`

> "put it on Git history"

✅ Correct.

More precisely:

```text
git commit
    ↓
creates a new commit
    ↓
in your LOCAL Git repository
```

---

### Q2 — `git push`

> "put it to GitHub"

✅ Correct.

More precisely:

```text
Local Git history
       │
       │ git push
       ▼
Remote repository
(GitHub)
```

---

### Q3 — Is `417bc4b` on GitHub?

> "not yet"

✅ Correct.

Git told us:

```text
Your branch is ahead of 'origin/main' by 1 commit.
```

So:

```text
Local main       417bc4b  ← exists
GitHub main      598dcc5  ← doesn't have it yet
```

---

### Q4 — What happens if `.git` is deleted?

You answered:

> "I don't know, maybe no"

That's a good instinct. **The answer is essentially no.**

The `.git` directory contains the repository's Git database: commits, branches, references, and other Git metadata.

Your project would still contain:

```text
engineering-apprenticeship/
├── docs/
├── exercises/
├── evidence/
└── ...
```

But without `.git`, Git would no longer recognize that folder as the repository containing your history.

So:

```text
Project files
    ≠
Git history
```

The project files are your working tree.

The `.git` directory is what makes that folder a Git repository and stores its local history.

### A useful mental model

```text
engineering-apprenticeship/
│
├── your actual project files
│   ├── docs/
│   ├── exercises/
│   └── evidence/
│
└── .git/                 ← Git's database
    ├── commits
    ├── branches
    ├── references
    └── repository metadata
```

So your current situation is:

```text
                LOCAL COMPUTER
┌──────────────────────────────────────┐
│                                      │
│  Working files                       │
│       +                              │
│  .git/                               │
│       │                              │
│       └── 417bc4b                    │
│                                      │
└──────────────────┬───────────────────┘
                   │
                   │ git push
                   ▼
              GitHub / origin
```

## Exercise 00.3 — Next step

Now let's **prove** the commit isn't on GitHub yet without pushing.

Run:

```bash
git status
```

You've already seen the result, but this time focus specifically on:

```text
Your branch is ahead of 'origin/main' by 1 commit.
```

Then run:

```bash
git log --oneline --decorate --all
```

Paste the output.

We'll use it to visualize **local `main` vs `origin/main`** before we perform the push.

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
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate --all
417bc4b (HEAD -> main) docs: record development environment
598dcc5 (origin/main) initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Exactly. ✅ This output gives us a very clear picture.

### `git status`

The key line is:

```text
Your branch is ahead of 'origin/main' by 1 commit.
```

So Git knows:

```text
Local main       → 417bc4b
origin/main      → 598dcc5
```

### `git log --oneline --decorate --all`

This makes the relationship even clearer:

```text
417bc4b (HEAD -> main) docs: record development environment
598dcc5 (origin/main) initial repo structure
```

Let's decode the labels.

**`HEAD -> main`**

```text
HEAD
 ↓
main
 ↓
417bc4b
```

You're currently on local `main`, and it points to `417bc4b`.

**`origin/main`**

```text
origin/main
     ↓
  598dcc5
```

Your local record of the remote GitHub branch still points to the older commit.

So:

```text
                 LOCAL                    REMOTE

              main                       origin/main
                │                            │
                ▼                            ▼
             417bc4b                       598dcc5
                │                            │
                └───────────┐    ┌───────────┘
                            │    │
                         history
```

The local branch has **one additional commit**.

---

# Now we can push

This is the first time we're going to synchronize local Git history with GitHub.

Run:

```bash
git push
```

Don't add any other options.

You may see output showing Git sending the new commit to GitHub.

After it finishes, run:

```bash
git status
```

Then:

```bash
git log --oneline --decorate --all
```

Paste both outputs.

We're looking for the transition from:

```text
ahead of 'origin/main' by 1 commit
```

to:

```text
Your branch is up to date with 'origin/main'.
```

That will complete our practical demonstration of:

**working tree → staging → commit → push → GitHub**.

PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git push
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (4/4), 678 bytes | 678.00 KiB/s, done.
Total 4 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/EjLaquiorez/engineering-apprenticeship.git
   598dcc5..417bc4b  main -> main
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git status
On branch main
Your branch is up to date with 'origin/main'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
        docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
        exercises/phase-00-engineering-environment/

nothing added to commit but untracked files present (use "git add" to track)
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> git log --oneline --decorate --all
417bc4b (HEAD -> main, origin/main) docs: record development environment
598dcc5 initial repo structure
PS C:\Users\ejlqr\Desktop\engineering-apprenticeship> 

Excellent. 🎯 **You have now completed the full Git repository lifecycle.**

Your push was successful:

```text
598dcc5..417bc4b  main -> main
```

And your status now says:

```text
Your branch is up to date with 'origin/main'.
```

Most importantly, your log now says:

```text
417bc4b (HEAD -> main, origin/main) docs: record development environment
598dcc5 initial repo structure
```

Notice the difference from before:

### Before `git push`

```text
417bc4b (HEAD -> main)
598dcc5 (origin/main)
```

Local `main` was ahead.

### After `git push`

```text
417bc4b (HEAD -> main, origin/main)
598dcc5
```

Both now point to the same commit.

```text
              LOCAL              GITHUB
                │                   │
                ▼                   ▼
             main ─────────── origin/main
                │                   │
                └──── 417bc4b ─────┘
```

## 🎓 What you just learned

You have now physically performed:

```text
Working Tree
     │
     │ git add
     ▼
Staging Area
     │
     │ git commit
     ▼
Local Git History
     │
     │ git push
     ▼
GitHub
```

And you experienced why each stage exists.

### Your current state

| Layer         | State                                           |
| ------------- | ----------------------------------------------- |
| Working tree  | `environment.md` tracked; other files untracked |
| Staging area  | Empty                                           |
| Local history | `417bc4b`                                       |
| GitHub        | `417bc4b`                                       |
| Branch        | `main`                                          |
| Remote        | `origin/main`                                   |

The three remaining untracked paths are **not a problem**:

```text
docs/lessons/phase-00-engineering-environment/00-git-fundamentals.md
docs/lessons/phase-00-engineering-environment/PHASE-00-ENGINEERING-ENVIRONMENT.md
exercises/phase-00-engineering-environment/
```

We deliberately haven't touched them.

---

# Exercise 00.3 — COMPLETE ✅

You've demonstrated:

* `git status`
* `git remote`
* `git branch -vv`
* working tree
* staging area
* `git diff`
* `git diff --cached`
* `git diff --cached --check`
* `git add`
* `git commit`
* `git log`
* `git show`
* local vs remote history
* `git push`
* selective staging

That's substantially more valuable than simply memorizing Git commands.

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
