# `code-maven-PR_verify`

[`code-maven_java-PR_verify.yml`](../code-maven_java-PR_verify.yml) workflow allows to **run** different types of tests.

## Trigger

Any pull request `opened` with changes about `code` or `paas` folder.

## Where does it run?

[github-runners](https://github.com/inditex/iac-githubrunners) self hosted.

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) and the [`setup-environment` action](https://github.com/inditex/gha-ivmactions/tree/develop/setup-environment) to automatically **load a given tool version and any needed extra environment variable** (i.e. `$JAVA_HOME` or `$NODE_HOME`) defined on the project's `code/.tool-versions` file.

## Jobs

- ### `unit-tests`

  - **Steps**
    - [`Get runner resources`](https://github.com/inditex/gha-citool/tree/develop/get-runner-resources): This step exposes the total number of CPUs and the total amount of memory accessible during job execution, populating `TOTAL_CPUS` and `TOTAL_MEMORY` environment variables. These variables are provided to the development team so they can optimize and accelerate their execution processes.

      The action uses the [configuration variable](https://github.blog/changelog/2023-01-10-github-actions-support-for-configuration-variables-in-workflows/) `RUNNER_TOTAL_MEMORY_MAGNITUDE` (with value 'MB' by default and adjustable at project level) to determine the magnitude used for the `TOTAL_MEMORY` output.

    - `mvn verify -DskipITs`
    - Dispatch report to Sonar

- ### `integration-tests` (optional)

  - **Steps**
    - Run integration tests with `perses` in Openshift
    - `mvn verify`
