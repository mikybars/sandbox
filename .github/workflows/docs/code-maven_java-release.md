# `code-maven-release`

[`code-maven_java-release.yml`](../code-maven_java-release.yml) workflow releases a new version to Distribution Platform and also generates the associated release in GitHub.

## Triggers

- Any `closed` pull request to `main` branch on `code` path, if no `skip-release` label and no `butler/feature-provision` label were set.
- A manual dispatch (`workflow_dispatch`) invoked from the GitHub UI.

## Where does it run?

`ubuntu-20.04` GitHub infrastructure.

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) to automatically load any tool version defined on the project's `code/.tool-versions` file.

## Jobs

- ### `release`

  - **Steps**

    - Get release version from `changelog-drafter`
    - Goal Maven with `mvn release`
      - `mvn deploy` artifacts into Distribution Platform
      - `git tag` on GitHub with final version setted by `changelog-drafter`
      - Prepare the possible next version in the `pom.xml` files
    - Publish release on GitHub
