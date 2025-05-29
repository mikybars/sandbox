# pipe-PR_verify

[`pipe-PR_verify.yml`](../pipe-PR_verify.yml) workflow allows to **validate** the content and structure in configuration files of `pipe` folder.

## Trigger
Any pull request `opened` with changes about `pipe` files.

This workflow can be skipped in draft PRs by setting the repository variable `PR_VERIFY_RUNS_ON_DRAFT` to `false`. If you want to run it in a draft PR when this variable is set to `false`, you can use the `pr-verify/force-on-draft` label.

### Where does it run?

[pipe github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/pipe) self hosted.
This workflow depends on the Pipe python scripts located on the project [clr-pipeprver](https://github.com/inditex/clr-pipeprver)

### Jobs

- #### `pipe-verify`

  - **Steps**

    - Get TOKEN for the pipe user service account (defined on the runners environment variable `SRVC_PIPEAPPMAPAX_USERNAME`)
    - Verify Pipe configuration using [Pipe verify action](https://github.com/inditex/actions/tree/main/pipe/verify)
