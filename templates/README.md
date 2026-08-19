# Templates

Reusable scaffolds for projects and documentation. Copy these into the appropriate location—never edit templates in place.

## Available Templates

| Template | Location | Use Case |
|----------|----------|----------|
| Project scaffold | [project-scaffold/](project-scaffold/) | New application in `projects/` |
| Architecture docs | [project-scaffold/docs/](project-scaffold/docs/) | Requirements, architecture, design decisions |

## Usage

```bash
# Example: create a new beginner project
cp -r templates/project-scaffold projects/beginner/my-project-name
```

On Windows (PowerShell):

```powershell
Copy-Item -Recurse templates/project-scaffold projects/beginner/my-project-name
```

Then rename placeholders and fill in the README.
