---
name: Themis - Database deploy
about: 'Themis - Database deploy'
title: '[Themis] Database deploy version X.Y.Z'
labels: 'themis/deploy'
assignees: ''

---

/deploy-database --version `X.Y.Z` --supraenv `supraenvironment` --env `environment` --model `my-model` --datasource `my-datasource`

### Write above your deploy command :rocket:

---

### Example
**Deploy with simple parameters**
> /deploy-database --supraenv dev --env dev --model THEMIS_MODEL --datasource themis-datasource --version 0.0.1
