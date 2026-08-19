# Engineering Apprenticeship

A structured backend engineering apprenticeship workspace. This repository tracks learning, building, and shipping real software across eleven phases—from engineering environment setup to distributed systems.

You are an apprentice, not a student. Progress requires evidence, not claims.

---

## Program Goal

Become a backend software engineer capable of building, deploying, maintaining, debugging, and scaling real software—not someone who memorizes Java syntax.

---

## Engineering Cycle

Every piece of work follows this cycle. No stage may be skipped.

```text
Learn → Build → Break → Debug → Refactor → Test → Deploy → Review → Repeat
```

See [docs/program/engineering-cycle.md](docs/program/engineering-cycle.md) for stage requirements.

---

## Repository Structure

| Directory | Purpose |
|-----------|---------|
| `docs/program/` | Apprenticeship rules, mentor framework, engineering cycle |
| `docs/lessons/` | Phase-based theory and guided learning (Phase 0–10) |
| `docs/notes/` | Personal study notes—never mixed with source code |
| `docs/references/` | Books, documentation, external resources |
| `docs/diagrams/` | Architecture diagrams, sequence diagrams, ERDs |
| `docs/cheatsheets/` | Quick-reference guides (Git, Java, SQL, Docker, etc.) |
| `projects/` | Applications organized by apprenticeship phase |
| `exercises/` | Small, focused drills completable in one session |
| `assets/` | Static media for documentation |
| `templates/` | Reusable project scaffolds |
| `progress/` | Daily logs, reviews, skill matrix, evidence log |
| `archive/` | Retired or superseded material |

---

## Learning Path

| Phase | Name | Duration | Goal | Status |
|-------|------|----------|------|--------|
| 0 | [Engineering Environment](docs/lessons/phase-00-engineering-environment/) | 2–3 weeks | Work like a developer | 🔴 Not started |
| 1 | [Java Foundations](docs/lessons/phase-01-java-foundations/) | 6–8 weeks | Write clean procedural Java | 🔴 Not started |
| 2 | [Object-Oriented Programming](docs/lessons/phase-02-object-oriented-programming/) | 4–6 weeks | Think in objects | 🔴 Not started |
| 3 | [Professional Java](docs/lessons/phase-03-professional-java/) | 4–6 weeks | Write production-quality Java | 🔴 Not started |
| 4 | [Databases](docs/lessons/phase-04-databases/) | 5–7 weeks | Understand data modeling and persistence | 🔴 Not started |
| 5 | [Networking](docs/lessons/phase-05-networking/) | 2–3 weeks | Understand backend communication | 🔴 Not started |
| 6 | [Spring Boot](docs/lessons/phase-06-spring-boot/) | 8–10 weeks | Build real backend applications | 🔴 Not started |
| 7 | [Testing](docs/lessons/phase-07-testing/) | 3–4 weeks | Write reliable software | 🔴 Not started |
| 8 | [DevOps](docs/lessons/phase-08-devops/) | 4–5 weeks | Become deployment-capable | 🔴 Not started |
| 9 | [System Design](docs/lessons/phase-09-system-design/) | 8–10 weeks | Design systems that scale | 🔴 Not started |
| 10 | [Distributed Systems](docs/lessons/phase-10-distributed-systems/) | 8–12+ weeks | Understand large-scale architectures | 🔴 Not started |

**Status legend:** ✓ Complete · 🟡 In Progress · 🔴 Not started

Advancement requires evidence logged in [progress/evidence-log.md](progress/evidence-log.md).

---

## Projects

| Project | Phase | Status | Location |
|---------|-------|--------|----------|
| Calculator | 1 | 🔴 Planned | `projects/phase-01-java-foundations/calculator/` |
| Expense Tracker | 1 | 🔴 Planned | `projects/phase-01-java-foundations/expense-tracker/` |
| Student Management System | 1 | 🔴 Planned | `projects/phase-01-java-foundations/student-management-system/` |
| Library Management System | 2 | 🔴 Planned | `projects/phase-02-object-oriented-programming/library-management-system/` |
| Inventory Management System | 3 | 🔴 Planned | `projects/phase-03-professional-java/inventory-management-system/` |
| Banking Database | 4 | 🔴 Planned | `projects/phase-04-databases/banking-database/` |
| Inventory Database | 4 | 🔴 Planned | `projects/phase-04-databases/inventory-database/` |
| Task Management API | 6 | 🔴 Planned | `projects/phase-06-spring-boot/task-management-api/` |
| URL Shortener | 9 | 🔴 Planned | `projects/phase-09-system-design/url-shortener/` |
| Chat Application | 9 | 🔴 Planned | `projects/phase-09-system-design/chat-application/` |

---

## Technologies

| Category | Technologies |
|----------|-------------|
| Language | Java 17+ |
| Build | Maven, Gradle |
| Framework | Spring Boot |
| Database | PostgreSQL, JDBC |
| Testing | JUnit, Mockito |
| DevOps | Docker, CI/CD, Linux |
| System Design | Redis, Kafka, load balancing, message queues |
| Tooling | Git, GitHub, terminal, IDE |

---

## Progress Requirements

Do not advance phases without evidence. Accepted evidence:

- Working code
- Tests
- Documentation
- Deployments
- Architecture diagrams
- Debugging explanations

"I understand it" is not evidence. Log proof in [progress/evidence-log.md](progress/evidence-log.md).

---

## Daily Check-In

At the start of every session, answer these in [progress/daily-log.md](progress/daily-log.md):

1. What did you build yesterday?
2. What did you learn yesterday?
3. What bug did you fix yesterday?
4. What are you building today?
5. What will you ship this week?

---

## References

### Books
- _Effective Java_ — Joshua Bloch
- _Clean Code_ — Robert C. Martin
- _Designing Data-Intensive Applications_ — Martin Kleppmann

### Documentation
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)

---

## Getting Started

1. Read [docs/program/mentor-framework.md](docs/program/mentor-framework.md)
2. Begin Phase 0: [docs/lessons/phase-00-engineering-environment/](docs/lessons/phase-00-engineering-environment/)
3. Copy `templates/project-scaffold/` when starting a new project
4. Log daily work and evidence after every session
