# themis-deploy

[`themis-deploy.yml`](../themis-deploy.yml) workflow allows to
**deploy** models to a database.

## Trigger

`database-deploy` is invoked after a chatbot command in a PR or ISSUE.


## Where does it run?

[database
github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/database)
self hosted.

## Jobs

- ### `orchestrate`

  - **Steps**

    - This step is going to orchestrate the deployment of the database over a runner.

- ### `deploy database`

  - **Steps**

    - This step is going to deploy the model changes at selected database.
