# `code-maven-build_snapshot`

[`code-maven_java-build_snapshot.yml`](../code-maven_java-build_snapshot.yml) workflow deploys a snapshot version to the distribution platform

## Trigger

- Using GitFlow: Any push on `develop` / `develop-*` branches with changes in `code` path.
- Using TBD: Any push on `main` / `main-*` branches with changes in `code` path.

## Where does it run?

`citool-github__ubuntu24.04-medium` self hosted runners.

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) to automatically load any tool version defined on the project's `code/.tool-versions` file.

## Jobs

- ### `build-snapshot`
  - **Steps**
    - Get release commits
    - if (`is-release-commit` == false )
      - `mvn deploy`
