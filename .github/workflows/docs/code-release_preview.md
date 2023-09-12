# `code-release_preview`

[`code-release_preview.yml`](../code-release_preview.yml) generates a `CHANGELOG.md` preview in a comment pull request.

## Trigger

Any pull request `labeled` to `main` branch about `code` path with `release-type/` or `release-preview` labels.

## Where does it run?

`ubuntu-20.04` GitHub infrastructure.

## Jobs

- ### `release-preview`

  - **Steps**

    - Get release type from a label on the pull request. In case Trunk Based Development flow is used, the version is inferred by changelog-drafter.
    - `changelog-drafter` generates with `whats-changed` command the `CHANGELOG.md` for this version.
    - Add a PR comment with the `CHANGELOG.md` on the open pull request.
    - In case GitFlow development is used, if no release labels are set, an error message is shown.
    - In case no changes were done in `code/`, a message is shown warning that the release will not be generated.
