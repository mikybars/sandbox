# paas-promote

[`paas-promote.yml`](../paas-promote.yml) workflow generates K8s templates, promotes Docker Image to internal registries and creates `deployment` pull requests.

## Trigger
- `workflow_call` from deploy-snapshots workflow

- `workflow_dispatch` from:

  - `deploy-snapshots` workflow
  - GitHub issue when you want deploy a release version.

## Where does it run?

[paasfeature](https://github.com/inditex/app-cdtool/tree/main/icr/github/paasfeature) self hosted runners.

## Jobs

- ### `promote`

  - **Steps**

    - Generate `K8s` templates with [Sentinel Forge action](https://github.com/inditex/gha-paasdeployment/tree/main/generate-manifests)
    - Promote images to `K8s` internal registries.
    - For MLOps projects, promote the ML models to the cluster local storage (S3 Bucket)
    - Check if Traffic Parrot mappings should be stored in PVC. If so, copy them into an S3 bucket to be used later on in the deployment stage.
    - Create PIPE users for the affected environments.
    - Create `deployment` pull requests. For those pull requests labeled as `manual-approval`, creates a list with their PR numbers to be _"Shepherd Checked"_ by the following job.

- ### `shepherd-check`

  - **Steps**

    - Call the _reusable workflow_ [paas-shepherd_check.yml]((../paas-shepherd_check.yml)) for each PR in the list gathered by the `promote` job (if any).

## Inputs

| Input           | Required | Default   | Description                                                                                                     |
|-----------------|----------|-----------|---------------------------------------------------------------------------------------------------------------- |
| SUPRAENVS       | No       | des       | Supra environments to generate manifest files. See [SUPRAENVS default behaviour](#supraenvs-default-behaviour). |
| ENVS            | No       | —         | Environments to generate manifest files.                                                                        |
| PLATFORMS       | No       | —         | Platforms to generate manifest files.                                                                           |
| TENANTS         | No       | —         | Tenants to generate manifest files.                                                                             |
| SLOTS           | No       | default   | Slots to generate manifest files.                                                                               |
| LABELS          | Yes      | —         | Labels to set in the deployment pull requests.                                                                  |
| VERSION         | No       | —         | Version to deploy.                                                                                              |
| ISSUE_NUMBER    | No       | —         | ID number of the associated issue or pull request.                                                              |
| ADDITIONAL_ARGS | No       | See below | Additional args not common to all pipelines.                                                                    |

### SUPRAENVS default behaviour

The effective value of `SUPRAENVS` depends on how the workflow is invoked:

- **Called from `paas-deploy_snapshots` (via `workflow_call`) without specifying `SUPRAENVS`**: defaults to `des,pre,pro`. This applies to both the `autodeploy` label scenario (PR synchronize/labeled events) and the `merge_to` scenario (merged PR event). In both cases the `paas-deploy_snapshots` `identify-changes` job hardcodes `des,pre,pro` and passes it to this workflow.
- **Triggered manually via `workflow_dispatch` without specifying `DESTINATIONS` nor `SUPRAENVS`**: defaults to `des`.

### ADDITIONAL_ARGS

`ADDITIONAL_ARGS` is a JSON with the following fields:

```json
{
  "STRATEGY": "",
  "PERCENTAGE": "",
  "CONFIG_REF": "",
  "TRIGGER": "",
  "TARGET_BRANCH": "",
  "CHECKOUT_REF": "",
  "FAST_TRACK": "",
  "BULK_ID": "",
  "DESTINATIONS": ""
}
```

When `DESTINATIONS` is provided, it takes precedence over `SUPRAENVS`/`ENVS`/`PLATFORMS`/`TENANTS` and is passed directly to the Sentinel Forge manifest generation step as the list of deployment destinations.

The `DESTINATIONS` value must be a single comma-separated string, for example:
`tenant-env-platform-slot,tenant1-env1-platform1-slot1`.

This precedence is also reflected in the workflow `run-name` (shows `destinations=...` instead of `supraenvs=...`).
