# pipe-service_account

[`pipe-service_account.yml`](../pipe-service_account.yml) workflow allows to **deploy** confluent cloud services-accounts defined in configuration files of `pipe` folder.

## Trigger
`workflow_dispatch` invoked on demand.


### Where does it run?

[pipe github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/pipe) self hosted.
This workflow depends on the Pipe python scripts located on the project [clr-pipeoperations](https://github.com/inditex/clr-pipeoperations)

### Jobs

- #### `service-account`

  - **Steps**

    - Get project-key from application.yml.
    - Deploy Service Accounts in Confluent Cloud, use this [Pipe service account action](https://github.com/inditex/actions/tree/main/pipe/service-account) to run the pipe clr scripts for creating the services accounts.
