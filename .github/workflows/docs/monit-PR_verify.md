# monit-PR_verify

[`monit-PR_verify.yml`](../monit-PR_verify.yml) workflow allows to **validate** any syntax error about json files of `monit` folder and to run a series of tests in the alert definitions.

## Trigger

Any pull request `opened` with changes about `monit` files.

## Where does it run?

The `linter` job runs in `ubuntu-20.04` GitHub infrastructure.  
The `alert_checker` job runs in [github-runners](https://github.com/inditex/github-runners) self hosted.

## Jobs

### `linter`

This job validates with the action [super-linter](https://github.com/github/super-linter) if there is any syntax error in json files.

### `alert_checker`

This jobs validates with the [monit action](https://github.com/inditex/actions/tree/main/audit) if there is any known issue with the alert definitions that would break the deployment.
