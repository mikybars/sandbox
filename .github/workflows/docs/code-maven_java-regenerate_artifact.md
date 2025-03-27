# `code-maven_java-regenerate_artifact`

[`code-maven_java-regenerate_artifact.yml`](../code-regenerate_artifact.yml) workflow allows to **regenerate artifacts** in JFrog after they have been purged.

## Trigger

A manual dispatch (`workflow_dispatch`) invoked from the GitHub UI.

## Where does it run?

`ubuntu-24.04` GitHub infrastructure.

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) to automatically load any tool version defined on the project's `code/.tool-versions` file.

## Jobs

- ### `regenerate-artifact`

  - **Steps**
    - `mvn deploy` artifacts into Distribution Platform
    - If the artifact deploys on PaaS, trigger the `build_deployable` workflow
