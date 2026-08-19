# Projects

Applications organized by apprenticeship phase. Each project follows the standard layout in `templates/project-scaffold/`.

## Rules

- One folder per project using `kebab-case`
- Every project must include tests before it is considered complete
- Phases 8+ require deployment evidence
- Document architecture in `docs/` for Phase 6+ projects

## Phase Directories

| Directory | Projects |
|-----------|----------|
| [phase-00-engineering-environment/](phase-00-engineering-environment/) | Environment setup deliverables |
| [phase-01-java-foundations/](phase-01-java-foundations/) | Calculator, Expense Tracker, Student Management System |
| [phase-02-object-oriented-programming/](phase-02-object-oriented-programming/) | Library Management System |
| [phase-03-professional-java/](phase-03-professional-java/) | Inventory Management System |
| [phase-04-databases/](phase-04-databases/) | Banking Database, Inventory Database |
| [phase-05-networking/](phase-05-networking/) | Networking exercises |
| [phase-06-spring-boot/](phase-06-spring-boot/) | Task Management API |
| [phase-07-testing/](phase-07-testing/) | Test coverage applied to existing projects |
| [phase-08-devops/](phase-08-devops/) | Deployments of existing projects |
| [phase-09-system-design/](phase-09-system-design/) | URL Shortener, Chat Application |
| [phase-10-distributed-systems/](phase-10-distributed-systems/) | Distributed system projects |

## Adding a New Project

```powershell
Copy-Item -Recurse templates/project-scaffold projects/phase-XX-name/project-name
```

Update the project table in the root `README.md` and log evidence in `progress/evidence-log.md`.
