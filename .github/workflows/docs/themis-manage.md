# themis-manage

[`themis-manage.yml`](../themis-deploy.yml) workflow allows to
**drop** objects on a database.

## Trigger

`database-manage` is invoked after a chatbot command in a PR or ISSUE.


## Where does it run?

[database github-runners](https://github.com/inditex/app-themis/blob/main/icr/github/database/runner.yml) self hosted.

## Jobs

- ### `orchestrate`

  - **Steps**

    - This step is going to orchestrate the deployment of the database over a runner.

- ### `drop object`

  - **Steps**

    - This step is going to check or execute the drop based on the value of the param `mode`.
