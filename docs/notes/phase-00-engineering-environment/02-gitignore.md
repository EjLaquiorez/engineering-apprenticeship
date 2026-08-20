# .gitignore

**Date:** 2026-08-20  
**Phase:** 00 — Engineering Environment  
**Topics:** Ignore patterns, untracked vs ignored, staging, diff, selective commits

---

## 1. What `.gitignore` does

`.gitignore` contains patterns telling Git which **untracked files** should be ignored.

For example:

```gitignore
*.class
.env
target/
```

The basic idea:

```text
File exists
    ↓
Is it already tracked?
    │
    ├── Yes → .gitignore doesn't stop tracking it
    │
    └── No
         ↓
Does it match .gitignore?
         │
         ├── Yes → Ignored
         │
         └── No → Untracked
```

---

## 2. Untracked vs Ignored

You demonstrated this directly.

Your actual repository had untracked files such as:

```text
docs/lessons/phase-00-engineering-environment/...
exercises/phase-00-engineering-environment/
```

These weren't matched by `.gitignore`.

Therefore:

```text
UNTRACKED
```

You created:

```text
test.class
```

Because your `.gitignore` contained:

```gitignore
*.class
```

Git classified it as:

```text
IGNORED
```

---

## 3. `git status --ignored`

You learned that:

```powershell
git status
```

shows normal untracked files.

While:

```powershell
git status --ignored
```

also shows ignored files.

You used this successfully and saw:

```text
Ignored files:
    test.class
```

---

## 4. `.env` and `.env.*`

Your `.gitignore` contains:

```gitignore
.env
.env.*
```

So you tested:

```text
.env
.env.local
```

Both were ignored.

The pattern:

```gitignore
.env.*
```

means `.env.` followed by additional characters.

Examples:

```text
.env.local
.env.test
.env.production
.env.development
```

---

## 5. File extension patterns

You learned:

```gitignore
*.log
```

matches `.log` files at different directory levels.

For example:

```text
app.log
logs/app.log
src/test/debug.log
```

all match.

But:

```text
README.md
debug.txt
```

do not.

Similarly:

```gitignore
*.class
```

matches:

```text
Main.class
User.class
example.class
```

---

## 6. Directory patterns

You learned:

```gitignore
target/
```

matches directories named `target`.

For example:

```text
target/
src/target/
temp/target/
```

The important distinction is:

```gitignore
target/
```

versus:

```gitignore
/target/
```

### `target/`

Can match `target` directories at different levels.

### `/target/`

The leading `/` anchors it to the repository root.

So:

```text
/target/
```

matches:

```text
repository-root/target/
```

but not:

```text
repository-root/src/target/
```

---

## 7. Root directory

You learned what "repository root" means.

Your repository root is:

```text
C:\Users\ejlqr\Desktop\engineering-apprenticeship
```

So:

```text
engineering-apprenticeship/target/
```

is a root `target`.

Whereas:

```text
engineering-apprenticeship/src/target/
```

is a nested `target`.

---

## 8. Negation with `!`

You learned that:

```gitignore
*.log
!important.log
```

means:

```text
Ignore .log files
       ↓
Except important.log
```

So:

```text
app.log          → ignored
error.log        → ignored
important.log    → NOT ignored
```

The `!` means:

> Re-include this path / make an exception to an earlier ignore rule.

---

## 9. `git check-ignore`

You learned how to ask Git **why** a file is ignored.

Basic:

```powershell
git check-ignore filename
```

Verbose:

```powershell
git check-ignore -v filename
```

You tested:

```powershell
git check-ignore -v target/root.class
```

and Git returned:

```text
.gitignore:2:target/    target/root.class
```

Then you tested:

```powershell
git check-ignore -v example.class
```

and got:

```text
.gitignore:6:*.class    example.class
```

So you learned how to identify the exact `.gitignore` rule responsible.

---

## 10. Already-tracked files

This was one of the most important concepts.

Suppose:

```text
secret.txt
```

is already committed.

Then you add:

```gitignore
secret.txt
```

Git **continues tracking it**.

`.gitignore` does not automatically untrack an existing file.

To stop tracking it while keeping the local file:

```powershell
git rm --cached secret.txt
```

We demonstrated this with:

```text
tracked-example.txt
```

and then cleaned up the temporary experiment.

---

## 11. Testing a new `.gitignore` rule

You practiced a complete real-world workflow with:

```gitignore
*.tmp
```

First:

```text
test.tmp
```

was untracked.

After adding:

```gitignore
*.tmp
```

it became ignored.

Then:

```powershell
git check-ignore -v test.tmp
```

confirmed:

```text
.gitignore:43:*.tmp    test.tmp
```

---

## 12. Inspecting `.gitignore` changes

You learned:

```powershell
git diff -- .gitignore
```

shows changes to `.gitignore` that haven't been staged.

You also encountered whitespace changes and learned that Git can detect seemingly insignificant changes such as extra blank lines or a missing final newline.

---

## 13. Staging `.gitignore`

You deliberately staged only `.gitignore`:

```powershell
git add .gitignore
```

Your other files remained untracked.

That demonstrated **selective staging**:

```text
.gitignore
    ↓
STAGED

docs/...
    ↓
UNTRACKED

exercises/...
    ↓
UNTRACKED
```

---

## 14. Inspecting staged changes

You learned:

```powershell
git diff --cached
```

or:

```powershell
git diff --cached -- .gitignore
```

shows what is currently staged.

You verified that the only staged change was:

```diff
+*.tmp
```

---

## 15. Committing `.gitignore`

You committed the legitimate change:

```text
de28063 chore: ignore temporary files
```

Then verified it with:

```powershell
git log --oneline -3
```

and:

```powershell
git show --stat --oneline HEAD
```

The result showed:

```text
.gitignore | 1 +
1 file changed, 1 insertion(+)
```

This proved that **only `.gitignore` was included in the commit**.

---

## Core knowledge

You should now be able to explain:

- What `.gitignore` is
- Untracked vs ignored
- How `.gitignore` affects untracked files
- Why it doesn't automatically untrack committed files
- `*.extension` patterns
- Directory patterns
- `/` and repository-root anchoring
- `!` negation patterns
- `git status --ignored`
- `git check-ignore -v`
- `git diff`
- `git diff --cached`
- Selective staging
- Committing `.gitignore`
- Verifying a commit with `git show`

---

## Repository state at time of writing

At the end of the `.gitignore` work:

```text
main
 │
 ├── de28063 chore: ignore temporary files
 │
 └── origin/main → c28cef0
```

Local `main` was **1 commit ahead of `origin/main`**, and lesson/exercise files remained untracked.
