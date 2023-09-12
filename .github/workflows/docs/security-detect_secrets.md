# security-detect_secrets

[`security-detect_secrets.yml`](../security-detect_secrets.yml) analyze each push to the repository
and checks if there is any secrets in the changes uploaded.

## Trigger

* All `push` events that are not present in a protected branch (`main` if using Trunk-Based Development, and `develop` if using Gitflow).
* Any `opened` pull request.

## Where does it run?

A `security` runner of the self-hosted
[github-runners](https://github.com/inditex/github-runners).

## Jobs

- ### `detect-secrets-pr`

  - **Steps**

    - Checkout of `source code` and actions
    - Check for changed files in PRs
    - Check changed files
    - Create file with changed files
    - `Detect secrets`, analyze the changes uploaded to the repository in order to find possible secrets.
    - `Archive the results` related to the analysis in GitHub.
    - `Notify the user`. In push events, if there is any finding notify the user with a comment in the latest commit of the push analyzed.

- ### `dsecrets-analysis-dojo`

  - **Steps**

    - Checkout of `source code` and actions
    - Retrieve `metadata` (key, name, version, etc...) from the project
    - Analyze source code secrets using `Detect Secrets scan`.
    - Import `Snyk data to DefectDojo`.

