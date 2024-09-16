# themis-init

[`themis-init.yml`](../themis-init.yml) workflow allows to
**generate version** of modified models.

## Trigger

`themis-init` is invoked on demand to initialize the database model definition integrated with Themis.

Inputs:
* Supra environment to deploy: Supra environment where the database is going to be deployed.
* Keyvault name: Keyvault name where the secrets are stored.
* Server name: Target server name where the database is going to be deployed.
* Runner label: (optional) The label of the runner to run the job.

## Where does it run?

[database
github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/database)
self hosted.

## Jobs

- ### `init`

  - **Steps**

    - This step is going to initialize the database model definition integrated with Themis.
