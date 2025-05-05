# code-maven_java-snyk_analysis

[`code-maven_java-snyk_analysis.yml`](../code-maven_java-snyk_analysis.yml) workflow allows to **execute Software Composition Analysis** with the [Snyk CLI tool](https://snyk.io/)

## Trigger
- Manually with `workflow_dispatch` invoked from a ChatBot command. See ChatBot official documentation here: [ChatBot documentation](https://chatbot.docs.inditex.dev/chatbot/latest/commands/test-qa.html)
- Any `closed` pull request with changes either in the `code` folder or the workflow file itself.
- Any published `release`.

## Where does it run?

Self-hosted runner: [iac-githubrunners/testing-ivm](https://githubrunners.docs.inditex.dev/githubrunners/latest/custom-runners/testing-ivm.html)

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) and the [`setup-environment` action](https://github.com/inditex/gha-ivmactions/tree/develop/setup-environment) to automatically **load a given tool version and any needed extra environment variable** (i.e. `$NODE_HOME`) defined on the project's `code/.tool-versions` file.

This workflow can be skipped in draft PRs by setting the repository variable `PR_VERIFY_RUNS_ON_DRAFT` to `false`. If you want to run it in a draft PR when this variable is set to `false`, you can use the `pr-verify/force-on-draft` label.

## Jobs

- ### `snyk-analysis-execution`

  - **Steps**

    - Checkout of `source code`
    - Setup `ivm`
    - Resolve secrets through `creds-resolver-cloud`
    - Build project (`maven install`)
    - Retrieve `metadata` (key, name, version, etc...) from the project
    - Setup `ivm-node`
    - Execute `snyk test` action
    - Execute `snyk monitor` action
    - Import `Snyk data to DefectDojo`. (Only in `workflow_dispatch` or merged `pull_request`)
    - Check [Quality Gate](https://snyk.docs.inditex.dev/snykdoc/stable/home.html#snyk-quality-gate)
    - Add Snyk feedback
    - Attach `Snyk report` with the analysis results
