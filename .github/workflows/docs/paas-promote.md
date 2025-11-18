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

All inputs are accept a single string and are detailed in their description exept one, ADDITIONAL_ARGS, which it's expecting a json with three values:

```json
{
  "STRATEGY": "",
  "PERCENTAGE": "",
  "CONFIG_REF": "",
  "TRIGGER": ""
}
```
