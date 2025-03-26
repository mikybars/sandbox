# `paas-maven-build_deployable`

[`paas-maven_java-build_deployable.yml`](../paas-maven_java-build_deployable.yml) workflow builds Docker Image and push it to Distribution Platform.

## Trigger

- `workflow_call`, called from the deploy_snapshots workflow with `version` as input parameter.
- `workflow_dispatch` with `version` as input parameter.
- Any `release` published

## Where does it run?

`ubuntu-24.04` GitHub infrastructure.

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) to automatically load any tool version defined on the project's `code/.tool-versions` file.

## Jobs

- ### `identify-changes`

  [identify-changes](https://github.com/inditex/gha-paasdeployment/tree/main/deployment/identify-changes) action allows to detect in a workflow if a developer has changed code, configuration or both.

- ### `build-deployable`

   It'll run when `identify-changes` have finished.

  - **Steps**
    - Builds the artifact if the deployable version is a snapshot one
    - Generates the Dockerfile with the [sentinel](https://github.com/inditex/gha-paasdeployment/tree/main/sentinel) action
    - Build Docker Image and push it to [Distribution Platform](https://inditex.jfrog.io)
