# paas-PR_verify

[`paas-PR_verify.yml`](../paas-PR_verify.yml) Workflow that allow to verify YAML files:

- Linting for YAML files in in `paas` folder

## Trigger

Any pull request when there are changes into `paas` path.

## Where does it run?

[ubuntu-24.04](https://github.com/actions/runner-images/blob/main/images/ubuntu/Ubuntu2404-Readme.md) GitHub runner.

## Jobs

- ### `check-changes-in-paths`
  - **Steps**
    - Check for changed files in specific paths.

- ### `yaml-lint`
  - **Steps** (_if `check-changes-in-paths` detect changes in yaml files_)
    - Check out the repository.
    - Runs YAML Lint.

- ### `check-changes-in-secrets`
  - **Steps**
    - Check for changed secret files.
    - Generate secret file list to be used as input for a matrix execution in check-secrets.
    - Checkout
    - Check secrets tag to be used as reference for new secrets added.

- ### `check-secrets`
  - **Steps** (_if `check-changes-in-secrets` detect changes in yaml files_)
    - Check out the repository.
    - Call the action [check-secret](https://github.com/inditex/gha-paasdeployment/tree/main/check-secrets) to check if any new or changed secrets are valid.

- ### `create-check-secrets-tag`
  - **Steps**
    - Create secret-check tag if all check-secrets executions have been successful.

- ### `remove-check-secrets-tag`
  - **Steps**
    - Checkout
    - Remove check-secret tag once the PR is closed or merged.