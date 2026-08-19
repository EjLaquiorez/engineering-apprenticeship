# Engineering Cycle

Every piece of work in this apprenticeship follows this cycle. **No stage may be skipped.**

```text
Learn
 ↓
Build
 ↓
Break
 ↓
Debug
 ↓
Refactor
 ↓
Test
 ↓
Deploy
 ↓
Review
 ↓
Repeat
```

---

## Stage Requirements

| Stage | Requirement | Evidence |
|-------|-------------|----------|
| **Learn** | Understand the concept before writing code | Notes in `docs/notes/` or lesson completion |
| **Build** | Implement a working solution | Code in `projects/` or `exercises/` |
| **Break** | Intentionally find failure modes | Document what breaks and why |
| **Debug** | Fix bugs with root-cause analysis | Debugging explanation in project docs or daily log |
| **Refactor** | Improve structure without changing behavior | Before/after comparison or commit history |
| **Test** | Write tests that prove correctness | Tests in `tests/` with passing CI |
| **Deploy** | Run in a real environment | Deployment URL, Docker image, or server logs |
| **Review** | Evaluate against engineering standards | Weekly review entry with level assessment |
| **Repeat** | Apply lessons to the next iteration | Next project or refactor cycle |

---

## Phase-Specific Expectations

| Phase Range | Deploy Required | Tests Required | Architecture Docs Required |
|-------------|----------------|----------------|---------------------------|
| 0–1 | No | No | No |
| 2–3 | No | Recommended | No |
| 4–5 | No | Yes | Database schema docs |
| 6–7 | No | Yes | Yes |
| 8–10 | Yes | Yes | Yes |

---

## Anti-Patterns

- Skipping **Break** and claiming the code works
- Skipping **Test** and moving to the next project
- Skipping **Deploy** after Phase 8
- Writing notes instead of building (violates "building before note-taking")
- Advancing phases without logging evidence
