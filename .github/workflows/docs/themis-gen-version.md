# themis-gen-version

[`themis-gen-version.yml`](../themis-gen-version.yml) workflow allows to
**generate version** of modified models.

## Trigger

`themis-gen-version` is invoked after a pull request `merge` against `main` branch with changes in one or many `database/*/dbmodel.yml` file.

## Where does it run?

[database
github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/database)
self hosted.

## Jobs

- ### `tagging`

  - **Steps**

    - This step is going to tag the model changes if a `dbmodel.yml` file has been modified.
