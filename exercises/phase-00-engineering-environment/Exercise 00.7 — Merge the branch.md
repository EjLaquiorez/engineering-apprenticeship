
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
