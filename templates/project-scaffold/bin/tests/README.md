# Tests

Unit tests, integration tests, and test utilities.

## Convention

```text
tests/
├── unit/           # Isolated unit tests
├── integration/    # Tests requiring Spring context or DB
└── fixtures/       # Shared test data and helpers
```

## Running Tests

```bash
mvn test              # All tests
mvn test -Dtest=ClassName  # Single test class
```
