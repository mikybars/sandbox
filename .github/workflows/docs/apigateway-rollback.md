# apigateway-rollback

[`apigateway-rollback.yml`](../apigateway-deploy.yml) workflow allows to
**rollback** the APIGateway configuration files of `apigateway` folder
into the environments specified in the parameters.

## Trigger

`workflow_dispatch` invoked from JanusAdmin

## Where does it run?

[apigateway
github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/apigateway)
self hosted.

## Jobs

- ### `get-path`

  - **Steps**

    - Check the number of supraenvironments provided: only one is allowed
    - Get path from supraenvironment: allows to define diferent binary
      locations for _des, pre_ and _pro_.

- ### `rollback-apigateway`

  In this job, a **concurrency group** is being used to block concurrent executions of `azfaas-deploy.yml` workflow and this job. This is set in order to let the `update-azfaas-key` job update the keys that `rollback-apigateway` use afterward. Basically, it has three behaviors:
  - If an environment is declared in GitHub, such as `des.testing`, it is using azfaas feature. Therefore, a concurrency group is used with this env.slot in order to block the concurrent deployments and run them sequentially.
  - If we are publishing to `staging` slot, a concurrency group is used with `default` slot in its name, since azfaas feature does not permit using `staging` slot but `default` slot option instead (the default behavior is to deploy to `staging` slot and swap to `production` slot).
  - If no GitHub environments are declared, the concurrency group does not affect to the `rollback-apigateway` job.

  **Steps**

  - Rollback APIGateway, uses this [apigateway rollback action](https://github.com/inditex/gha-janusactions/tree/main/rollback)
    to run the apigateway client.
