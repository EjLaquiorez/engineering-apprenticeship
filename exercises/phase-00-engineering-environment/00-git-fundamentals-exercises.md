# Phase 00 — Git Fundamentals Exercises

> A record of the Git exercises completed during the engineering apprenticeship.

## Exercise 00.1 — Git Environment and Repository State

### Concepts learned

Git has several important areas:

```text
Working Tree
     ↓ git add
Staging Area
     ↓ git commit
Git History
     ↓ git push
Remote Repository (GitHub)
```

### Key answers

1. **Working tree** — where files are currently modified.
2. **Staging area** — where selected changes are prepared for the next commit.
3. **Git history** — where committed changes are recorded.
4. `git add <file>` stages only the specified file.

### Commands practiced

```powershell
git remote -v
git branch -vv
git status
git diff
git diff --cached
git add evidence/environment.md
git commit -m "docs: record development environment"
git show --stat --oneline HEAD
git log --oneline --decorate -3
git push
```

### Important distinction

```text
git diff
```

Shows changes in the **working tree** that are not staged.

```text
git diff --cached
```

Shows changes in the **staging area** that are prepared for the next commit.

---

## Exercise 00.2 — Branch Basics

### Creating a branch

We created:

```powershell
git switch -c exercise/branch-basics
```

This created a new branch and switched to it.

The branch initially pointed to the same commit as `main`.

```text
4b6a0fa
├── main
└── exercise/branch-basics
```

### Important concept

A branch is essentially a movable reference to a commit.

Creating a branch does **not** copy the entire repository.

### Commands practiced

```powershell
git branch --show-current
git switch -c exercise/branch-basics
git branch -vv
git branch -a
git log --oneline --decorate --graph --all
git switch main
git switch exercise/branch-basics
```

---

## Exercise 00.3 — Branch-Specific Changes

We created a commit on the feature branch:

```text
02ce2f4 docs: demonstrate branch-specific change
```

At that point:

```text
exercise/branch-basics → 02ce2f4
main                   → 4b6a0fa
```

The feature branch had work that `main` did not have.

### Key lesson

A commit on one branch does not automatically appear on another branch.

---

## Exercise 00.4 — Fast-Forward Merge

We switched to `main` and merged:

```powershell
git switch main
git merge exercise/branch-basics
```

Git performed a **fast-forward merge**.

Before:

```text
main → 4b6a0fa

exercise/branch-basics → 02ce2f4
```

After:

```text
main
  ↓
02ce2f4
  ↑
exercise/branch-basics
```

No merge commit was necessary because `main` had no separate work after the branch was created.

---

## Exercise 00.5 — Divergent Branches

We then intentionally created different commits on both branches.

The history became:

```text
* c8abb6f (exercise/branch-basics)
| * 409445e (main)
|/
* 02ce2f4
```

This demonstrated that the branches had diverged.

### Key lesson

When both branches contain different work, Git cannot simply move one branch pointer forward.

---

## Exercise 00.6 — Merge Conflict

We attempted to merge the divergent feature branch:

```powershell
git switch main
git merge exercise/branch-basics
```

Git reported:

```text
CONFLICT (content): Merge conflict in evidence/environment.md
Automatic merge failed; fix conflicts and then commit the result.
```

### Why the conflict happened

Both branches modified overlapping content, and Git could not determine which final version was intended.

### Conflict resolution workflow

1. Inspect the conflict.
2. Edit the file and choose the intended final content.
3. Stage the resolved file:

```powershell
git add evidence/environment.md
```

4. Verify:

```powershell
git status
git diff --cached
```

5. Complete the merge:

```powershell
git commit -m "merge: resolve branch updates"
```

This produced:

```text
4483d9f merge: resolve branch updates
```

### Merge commit

The merge commit had **two parents**.

We verified this with:

```powershell
git show --no-patch --pretty=raw HEAD
```

The result showed:

```text
parent 409445e...
parent c8abb6f...
```

### Important lesson

A merge commit represents the point where two histories are joined.

---

## Exercise 00.7 — Remote Branches and Pull Requests

We examined local and remote branches:

```powershell
git branch -a
git branch -vv
git remote -v
```

Important terminology:

```text
origin
```

is the name of the remote repository.

```text
origin/main
```

is the local **remote-tracking reference** for the remote `main` branch.

```text
main
```

is our local branch.

### Pull Request workflow

We pushed the feature branch:

```powershell
git push
```

and used a Pull Request to merge the feature work into GitHub's `main`.

After fetching:

```powershell
git fetch origin
```

we observed:

```text
origin/main
```

move to the Pull Request merge commit.

### Important lesson

A Pull Request is a collaboration/review mechanism provided by GitHub.

It is not itself a Git command.

---

## Exercise 00.8 — Local `main` Divergence and Reset

After the Pull Request was merged remotely, our local `main` still contained separate local history.

We observed:

```text
Your branch and 'origin/main' have diverged,
and have 2 and 2 different commits each
```

We chose to make local `main` exactly match GitHub's `main`:

```powershell
git reset --hard origin/main
```

Git reported:

```text
HEAD is now at c28cef0 Merge pull request #1 ...
```

### Important lesson

`git reset --hard origin/main`:

1. Moves the current branch to the commit referenced by `origin/main`.
2. Updates the tracked working tree to match that commit.
3. Discards local tracked changes that are not part of the target commit.
4. Can make local commits unreachable from the branch.

Therefore, it should be used deliberately.

---

# Exercise 00.9 — Fetch, Pull, Reset

This exercise focused on remote synchronization.

## `git fetch`

```powershell
git fetch origin
```

Meaning:

> Update my remote-tracking information so I can inspect what changed remotely without changing my current branch.

Example:

```text
Before fetch:

main        → A
origin/main → A
```

If GitHub advances:

```text
main        → A
origin/main → A
```

After:

```powershell
git fetch origin
```

the local view becomes:

```text
main        → A
origin/main → D
```

The local `main` remains at `A`.

### Inspect remote-only commits

```powershell
git log main..origin/main --oneline
```

This means:

> Show commits reachable from `origin/main` that are not reachable from `main`.

---

## `git pull`

Conceptually:

```text
git pull
    =
git fetch
    +
integrate remote changes
```

`git pull` fetches remote changes and then attempts to integrate them into the current branch.

The exact integration behavior can depend on the repository configuration and Git options.

### Mental model

```text
git fetch
    ↓
"What's new remotely?"
```

```text
git pull
    ↓
"Get the remote changes and integrate them."
```

---

## `git reset --hard origin/main`

Mental model:

```text
"I have decided that my current local branch
should exactly match origin/main."
```

Example:

```text
Before:

main        → X
origin/main → D
```

After:

```powershell
git reset --hard origin/main
```

```text
main        → D
origin/main → D
```

This is fundamentally different from `fetch`.

---

# Exercise 00.10 — Local Commit → Push

We practiced the complete local-to-remote workflow.

### Step 1 — Local change

A change was made to:

```text
evidence/environment.md
```

Initially:

```text
Working Tree
```

### Step 2 — Stage

```powershell
git add evidence/environment.md
```

The change moved to:

```text
Staging Area
```

### Step 3 — Verify

```powershell
git diff
```

showed nothing because there were no unstaged changes.

```powershell
git diff --cached
```

showed the staged change.

### Step 4 — Commit

```powershell
git commit -m "docs: practice local synchronization"
```

Created:

```text
bf0e25d docs: practice local synchronization
```

At this point:

```text
local branch
    ↓
bf0e25d

origin/exercise/branch-basics
    ↓
485bec3
```

The local branch was ahead by one commit.

### Step 5 — Push

```powershell
git push
```

After pushing:

```text
exercise/branch-basics
        ↓
     bf0e25d
        ↑
origin/exercise/branch-basics
```

Both local and remote branch references pointed to the same commit.

---

# Git Command Mental Model

## Working with local changes

```text
git status
```

> What is the state of my repository?

```text
git diff
```

> What changed but isn't staged?

```text
git add
```

> Put selected changes into the staging area.

```text
git diff --cached
```

> What am I about to commit?

```text
git commit
```

> Record the staged snapshot in Git history.

---

## Working with branches

```text
git branch
```

> What branches exist?

```text
git branch --show-current
```

> Which branch am I on?

```text
git switch <branch>
```

> Move to another branch.

```text
git switch -c <branch>
```

> Create and switch to a new branch.

```text
git merge <branch>
```

> Integrate another branch into the current branch.

---

## Working with remotes

```text
git remote -v
```

> Where is my remote repository?

```text
git fetch origin
```

> Update my knowledge of the remote.

```text
git push
```

> Send my local commits to the remote.

```text
git pull
```

> Fetch remote changes and integrate them.

```text
git reset --hard origin/main
```

> Deliberately make the current branch and tracked working tree match `origin/main`.

---

# Core Principles Learned

### Principle 1 — A commit is not a push

```text
git commit
```

creates a commit locally.

```text
git push
```

publishes commits to the remote.

---

### Principle 2 — `git add` does not commit

```text
git add
```

only stages changes.

The commit doesn't exist until:

```text
git commit
```

---

### Principle 3 — Branches are references to commits

A branch is not a separate copy of your project.

```text
main → commit
```

```text
feature → commit
```

Branches can point to different commits in the same repository history.

---

### Principle 4 — `fetch` doesn't move your current branch

```text
git fetch
```

updates:

```text
origin/main
```

but does not automatically move:

```text
main
```

---

### Principle 5 — Merges join histories

A normal merge commit can have:

```text
parent 1
parent 2
```

This is why we saw:

```text
*   4483d9f
|| * c8abb6f
* | 409445e
|/
```

---

### Principle 6 — Conflicts require human decisions

Git can often combine changes automatically.

But when both branches modify overlapping content in incompatible ways:

```text
CONFLICT
```

Git stops and asks you to resolve the intended final state.

Then:

```text
git add <resolved-file>
git commit
```

concludes the merge.

---

# Final Git Workflow

The complete workflow you've practiced is:

```text
                    ┌──────────────┐
                    │ Working Tree │
                    └──────┬───────┘
                           │
                       git add
                           ▼
                    ┌──────────────┐
                    │ Staging Area  │
                    └──────┬───────┘
                           │
                      git commit
                           ▼
                    ┌──────────────┐
                    │ Local History│
                    └──────┬───────┘
                           │
                       git push
                           ▼
                    ┌──────────────┐
                    │    GitHub    │
                    └──────┬───────┘
                           │
                      git fetch
                           ▼
                    ┌──────────────┐
                    │origin/main   │
                    └──────────────┘
```

And when branches need to come together:

```text
feature branch
      │
      └──────┐
             ▼
           merge
             │
             ▼
            main
```

This is a good checkpoint to keep in your repository as your **Phase 00 Git Fundamentals exercise record**.
