# `code-PR_sync_to_develop`

[`code-PR_sync_to_develop.yml`](../code-PR_sync_to_develop.yml) generates an automated pull request from main to develop (only applicable with GitFlow development flow).

## Trigger

Any pull request `merged` with `non-code` changes.

## Where does it run?

`citool-github__ubuntu24.04-medium` self hosted runners.

## Jobs

- ### `sync-to-develop`

  - **Steps**

    - Create a pull request with the changes merged in `main`.
