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

## Jobs

- ### `snyk-analysis-execution`

  - **Steps**

    - Determine `artifact version` to upload results to DefectDojo. (Only in `release` or `workflow_dispatch` trigger events)
    - Determine `ref` to checkout.
    - Checkout of `source code` and actions
    - Build project (`maven install`)
    - Retrieve `metadata` (key, name, version, etc...) from the project
    - Execute `snyk test` action
    - Import `Snyk data to DefectDojo`. (Only in `release` or `workflow_dispatch`)
    - Execute `snyk monitor` action (results are sent to Snyk **only** if `org-id` is defined. [More info](https://snyk.docs.inditex.dev/snykdoc/stable/home.html#enable-monitor-to-team-organizations))
    - Check [Quality Gate](https://snyk.docs.inditex.dev/snykdoc/stable/home.html#snyk-quality-gate)
    - Add Snyk feedback
    - Attach `Snyk report` with the analysis results
