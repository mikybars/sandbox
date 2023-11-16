# `code-maven-deploy_snapshots`

[`code-maven_java-deploy_snapshots.yml`](../code-maven_java-deploy_snapshots.yml) workflow allows to deploy any snapshot version in DEV environment.

## Trigger

- Any pull request `opened` or `closed` from branches `bugfix/`, `features/`, `hotfix/` to `develop*` or `main*` branches about `code` or `paas` path. This workflow will **only runs** when a pull request is tagged with `autodeploy` label or merged to `develop` branch, if using [GitFlow branching strategy](https://github-cicd.docs.inditex.dev/githubcicd/stable/development/branching.html#gitflow).
- `workflow_dispatch` from PRs comments with [ChatBot](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-in-paas.html).

## Where does it run?

`ubuntu-20.04` GitHub infrastructure.

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) to automatically load any tool version defined on the project's `code/.tool-versions` file.

## Jobs

- ### `identify-changes`

  [identify-changes](https://github.com/inditex/actions/tree/main/deployment/identify-changes) action allows to detect in a workflow if a developer has changed code, configuration or both.

- ### `build-and-promote`

   It'll run when `identify-changes` have finished.

  - **Steps**
    - Build and push the related **Docker image** to the [Distribution Platform](https://inditex.jfrog.io).
    - Run [paas-promote](paas-promote.md) workflow with the corresponding input parameters.
