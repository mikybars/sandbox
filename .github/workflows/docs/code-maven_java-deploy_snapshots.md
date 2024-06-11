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

  - **Steps**
    - [identify-changes](https://github.com/inditex/actions/tree/main/deployment/identify-changes) action allows to detect in a workflow if a developer has changed code, configuration or both.
    - Check if last image exists in the DP via sentcli.
    - Set deployment configuration for the next jobs.

- ### `validate-slots`

  It'll run when `identify-changes` have finished.
  
  - **Steps**
    - Ensure slot is present
    - [validate-slots](https://github.com/inditex/actions/tree/main/deployment/validate-slots) action validates that the slots provided are correct to be deployed in PaaS.

- ### `build-deployable`
  It'll run when `validate-slots` have finished and if `identify-changes` detects code or configuration changes, or a latest image does not exist.

- ### `create-deployment-prs`
  It'll run if `identify-changes` and `validate-slots` have finished with a succesful result and also if `build-deployable` was skipped or finished succesfully.

- ### `clean-resources`

   It'll run when `create-deployment-prs` have finished and the trigger is by closed PR.

  - **Steps**
    - Clean up last build tag on closed PR.
    - Detect if it is BatchAsCode.
    - [Clean Up / Delete Folder Into Deployment Branch](https://github.com/inditex/actions/tree/main/deployment/delete-deployment-folder)
