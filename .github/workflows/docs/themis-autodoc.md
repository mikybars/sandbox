# themis-autodoc

[`themis-autodoc.yml`](../themis-autodoc.yml) workflow allows to add
**metadata** to database objects.

## Trigger

`workflow_dispatch` invoked on demand, only from the `main` branch.


## Where does it run?

[database
github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/database)
self hosted.

## Jobs

- ### `Autodoc ID`

  - **Steps**

    - This step is going to execute Autodoc outside of Themis flow.
