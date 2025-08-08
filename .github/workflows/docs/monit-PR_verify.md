# monit-PR_verify

[`monit-PR_verify.yml`](../monit-PR_verify.yml) workflow allows to **validate** any syntax error about json files of `monit` folder and to run a series of tests in the alert definitions.

## Trigger

Any pull request `opened` with changes about `monit` files.

## Where does it run?

The `linter` job runs in `ubuntu-24.04` GitHub infrastructure.
The `alert_checker` job runs in [github-runners](https://github.com/inditex/github-runners) self hosted.

## Jobs

Both jobs can be skipped in draft PRs by setting the repository variable `PR_VERIFY_RUNS_ON_DRAFT` to `false`. If you want to run it in a draft PR when this variable is set to `false`, you can use the `pr-verify/force-on-draft` label.

### `linter`

This job validates with the action [super-linter](https://github.com/github/super-linter) if there is any syntax error in json files.

### `alert_checker`

This jobs validates with the [monit action](https://github.com/inditex/actions/tree/main/audit) if there is any known issue with the alert definitions that would break the deployment.
