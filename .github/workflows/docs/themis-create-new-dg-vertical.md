# themis-create-new-dg-vertical

[`themis-create-new-dg-vertical.yml`](../themis-create-new-dg-vertical.yml) workflow allows to
**Create** a new vertical in datagravity.

## Trigger

`create-new-dg-vertical` is invoked via github actions.


## Where does it run?

[database github-runners](https://github.com/inditex/app-themis/blob/main/icr/github/database/runner.yml) self hosted.

## Jobs

- ### `Launch vertical creation`

  - **Steps**

    - This step is going to create a new vertical in `pre` and `pro` depending of the vertical that the repo belongs.
