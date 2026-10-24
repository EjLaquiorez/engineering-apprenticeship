# Git Commit Guide — Engineering Apprenticeship

## 1. Commit Message Convention

Use this format:

```bash
git commit -m "TYPE(SCOPE): description"
```

| Type | Purpose | Example |
|---|---|---|
| `exercise` | Add or update lesson exercises | `exercise(06-interfaces): add Lesson 34 exercises` |
| `docs` | Add or update lessons, READMEs, or design documents | `docs(06-interfaces): add 06.4 interface polymorphism lesson` |
| `feat` | Implement a new application feature | `feat(library): add book registration` |
| `fix` | Fix a bug or incorrect behavior | `fix(library): prevent borrowing unavailable items` |
| `test` | Add or update tests | `test(library): cover overdue loan scenarios` |
| `refactor` | Improve code structure without changing intended behavior | `refactor(library): separate loan responsibilities` |
| `diagram` | Add or update design diagrams | `diagram(library): add initial class diagram` |
| `build` | Change build configuration or project tooling | `build(library): configure application build` |

**Rules**
- Use lowercase scope names.
- Keep descriptions short and action-oriented.
- Use the actual lesson, topic, or project stage in the scope.
- Commit only related changes together.
- Do not claim a change in the commit message if the files do not contain that change.

---

# Part I — Phase 02: Object-Oriented Programming

## Topic 1 — Classes and Objects

**Scope:** `01-classes-and-objects`

```bash
git commit -m "exercise(01-classes-and-objects): add Lesson 01 exercises"
git commit -m "docs(01-classes-and-objects): add 01.1 object-oriented programming lesson"
```

Replace the lesson number, exercise range, and lesson title for each subsequent lesson.

## Topic 2 — Encapsulation

**Scope:** `02-encapsulation`

```bash
git commit -m "exercise(02-encapsulation): add Lesson 10 exercises"
git commit -m "docs(02-encapsulation): add 02.1 why encapsulation exists lesson"
```

## Topic 3 — Inheritance

**Scope:** `03-inheritance`

```bash
git commit -m "exercise(03-inheritance): add Lesson 16 exercises"
git commit -m "docs(03-inheritance): add 03.1 inheritance fundamentals lesson"
```

## Topic 4 — Polymorphism

**Scope:** `04-polymorphism`

```bash
git commit -m "exercise(04-polymorphism): add Lesson 22 exercises"
git commit -m "docs(04-polymorphism): add 04.1 polymorphism fundamentals lesson"
```

## Topic 5 — Abstraction

**Scope:** `05-abstraction`

```bash
git commit -m "exercise(05-abstraction): add Lesson 27 exercises"
git commit -m "docs(05-abstraction): add 05.1 introduction to abstraction lesson"
```

## Topic 6 — Interfaces

**Scope:** `06-interfaces`

```bash
git commit -m "exercise(06-interfaces): add Lesson 34 exercises"
git commit -m "docs(06-interfaces): add 06.4 interface polymorphism lesson"
```

### Example: multiple exercise files in one lesson

For Lesson 34, with exercises 34A–34D, one commit can include all four exercise files:

```bash
git add exercises/02-object-oriented-programming/06-interfaces/
git commit -m "exercise(06-interfaces): add Lesson 34 exercises"
```

Adjust the path to match your actual repository structure. If the lesson files are in separate locations or you want smaller commits, stage only the relevant files.

---

# Part II — Library Management System Project

**Project path:**

```text
projects/
└── phase-02-object-oriented-programming/
    └── library-management-system/
```

Use `library` as the scope for application features, fixes, tests, and refactoring. Use a stage-specific scope for requirements and design documentation when that makes the change clearer.

## Stage 01 — Requirements

```bash
git commit -m "docs(library-requirements): define project problem and users"
git commit -m "docs(library-requirements): document system use cases"
```

## Stage 02 — Domain Modeling

```bash
git commit -m "docs(library-domain): identify domain objects"
git commit -m "docs(library-domain): define class responsibilities"
git commit -m "docs(library-domain): remove unnecessary domain classes"
```

## Stage 03 — Class Design

```bash
git commit -m "docs(library-design): define class fields"
git commit -m "docs(library-design): define class methods"
git commit -m "docs(library-design): document constructor decisions"
git commit -m "docs(library-design): define access modifiers"
```

## Stage 04 — Class Diagram

```bash
git commit -m "diagram(library): add initial class diagram"
git commit -m "docs(library-design): review class diagram against Java design"
```

## Stage 05 — Core Classes

```bash
git commit -m "feat(library): implement core domain classes"
git commit -m "feat(library): create initial domain objects"
git commit -m "test(library): verify initial object state"
```

## Stage 06 — Encapsulation

```bash
git commit -m "feat(library): protect domain object state"
git commit -m "feat(library): add controlled access to object data"
git commit -m "fix(library): enforce domain business rules"
```

## Stage 07 — Relationships

```bash
git commit -m "feat(library): model domain object relationships"
git commit -m "test(library): verify object relationships"
git commit -m "diagram(library): update class relationships"
```

## Stage 08 — Inheritance

```bash
git commit -m "docs(library-design): justify inheritance decisions"
git commit -m "feat(library): implement justified inheritance"
```

Only use the implementation commit if inheritance is appropriate for the final design.

## Stage 09 — Polymorphism

```bash
git commit -m "feat(library): implement polymorphic behavior"
git commit -m "test(library): verify runtime method dispatch"
```

## Stage 10 — Abstraction

```bash
git commit -m "docs(library-design): document abstraction decisions"
git commit -m "feat(library): implement appropriate abstractions"
```

## Stage 11 — Interfaces

```bash
git commit -m "docs(library-design): identify shared capabilities"
git commit -m "feat(library): implement required interfaces"
```

## Stage 12 — User Interaction

```bash
git commit -m "feat(library): add user interaction for library operations"
```

## Stage 13 — Validation

```bash
git commit -m "feat(library): validate library operation inputs"
git commit -m "test(library): cover invalid input and business rules"
```

## Stage 14 — Testing

```bash
git commit -m "test(library): cover normal library operations"
git commit -m "test(library): cover invalid and boundary cases"
```

## Stage 15 — Refactoring

```bash
git commit -m "refactor(library): improve class responsibilities"
git commit -m "refactor(library): remove duplicated logic"
```

## Stage 16 — Final Documentation

```bash
git commit -m "docs(library): document setup and usage"
git commit -m "docs(library): finalize project design and testing evidence"
```

---

# Part III — Recommended Commit Workflow

For each lesson or project exercise:

```bash
git status
git diff
git add <specific-file-or-folder>
git diff --cached
git commit -m "TYPE(SCOPE): description"
git status
```

1. **Inspect:** Check which files changed.
2. **Review:** Read the diff before staging.
3. **Stage:** Add only files related to the task.
4. **Verify:** Review the staged diff.
5. **Commit:** Use the matching commit convention.
6. **Confirm:** Check that the working tree is clean or understand what remains.

## When to use one commit or multiple commits

- Use one commit when several files form one coherent change, such as exercises 34A–34D.
- Use separate commits when exercises, documentation, and implementation represent distinct changes.
- Do not create empty commits just to follow the guide.
- Do not commit code that you have not reviewed or that you know does not compile, unless you are deliberately preserving a clearly identified work-in-progress checkpoint.

## Important distinction

A **commit guide is a naming reference**, not a requirement to execute every example. Use only the commands that correspond to actual completed work. Change lesson numbers, paths, scopes, and descriptions to match the files you created.