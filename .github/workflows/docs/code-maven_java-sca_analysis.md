# code-maven_java-sca_analysis

[`code-maven_java-sca_analysis.yml`](../code-maven_java-sca_analysis.yml) workflow allows to **execute Software Composition Analysis** with [JFrog XRay](https://jfrog.com/xray/)

## Trigger
- Manually with `workflow_dispatch` invoked from a ChatBot command. See ChatBot official documentation here: [ChatBot documentation](https://chatbot.docs.inditex.dev/chatbot/latest/commands/test-qa.html)
- Any `opened`, `synchronize`, or `closed` pull request with changes either in the `code` folder or the workflow file itself.

## Where does it run?

Self-hosted on-prem runner selected dynamically by the workflow through `vars.RUNSON_SCA_*_ONPREM`.
When no contingency variable is set, the workflow falls back to the default runner label `auditassistant-icr__sca-ubuntu24.04`.

## Versions used

`asdf` and any `Java`, `Maven`, `Poetry`, `uv`, `Android`, `Go` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) and the [`setup-environment` action](https://github.com/inditex/gha-ivmactions/tree/develop/setup-environment) to automatically **load a given tool version and any needed extra environment variable** (i.e. `$NODE_HOME`) defined on the project's `code/.tool-versions` file.

This workflow can be skipped in draft PRs by setting the repository variable `PR_VERIFY_RUNS_ON_DRAFT` to `false`. If you want to run it in a draft PR when this variable is set to `false`, you can use the `pr-verify/force-on-draft` label.

## Jobs

- ### `sca-analysis-execution`

  - **Steps**

    - Checkout of `source code`
    - Setup `ivm`
    - Resolve secrets through `creds-resolver-cloud`
    - Build project (`maven install`)
    - Execute `sca-scan` action
    - Upload `SCA data to DefectDojo`. (Only in `workflow_dispatch` or merged `pull_request`)
    - Check `SCA Analysis Status`
