# themis-database-restoredb

[`themis-restore.yml`](../themis-restore.yml) workflow allows to
**restore** the last production backup in your configured preproduction **cluster**.

## Trigger

- On demand by any issue `labeled` using the `issue template` provided.
- By github `scheduling` (comming soon).

## How to use

Follow [**official documentation**](https://dataportal.inditex.com/docs/products/themis/dbutils/dbrestore/)

## Where does it run?

[database github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/database) self hosted.

## Jobs

- ### `dbrestore`

  - **Steps**

    - Verify the user requesting the restore has `admin` privilege on the repository.
    - Verify the cluster being restored is owned by the project requesting it.
    - Dispatch the workflow run
