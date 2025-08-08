# themis-datasets-deploy

[`themis-datasets-deploy.yml`](../themis-datasets-deploy.yml) workflow allows to
**Deploy** datasets to datagravity.

## Trigger

`datasets-deploy` is invoked via github actions.


## Where does it run?

[database github-runners](https://github.com/inditex/app-themis/blob/main/icr/github/database/runner.yml) self hosted.

## Jobs

- ### `Deploy datasets`

  - **Steps**

    - This step is going to deploy the selected datasets to datagravity .
