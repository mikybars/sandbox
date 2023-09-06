# authz-process

[`authz-process.yml`](../authz-process.yml) workflow upload and process `authz` configuration.

## Trigger

* Any pull request `merged` to `main` branch when there are changes into
  `authz` directory.

* Workflow dispatch with supraenvironments as input.

## Where does it run?

A `common` runner of the self-hosted
[github-runners](https://github.com/inditex/github-runners).

## Steps

### `Get Metadata`

Parse `application.yml` to extract the project metadata.

### `Get Supraenvironments`

Extract the supraenvironments from the file names that changed in `authz/` if
it is `pull_request` event, or directly from the input if is a
`workflow_dispatch` event.

### `Authz Process`

[Authz process files](https://github.com/inditex/actions/tree/main/authz/process-files)
action that deploys the `authz` configuration for the given supraenvironments.

All supraenvironments are separated in steps that are falible since we want to
run them all. However, we add a last step to check if any of them have failed
to set the workflow as failed and provide a summary.
