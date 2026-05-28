# monit-deep-validation

[`monit-deep-validation.yml`](../monit-deep-validation.yml) workflow allows the user to perform deep validation of subscriptions, inhibitions and mailing list.

## Trigger

Only manual dispatch.

## Where does it run?

The `linter` job runs in `citool-github__ubuntu24.04-medium` internal runners (configurable via `vars.RUNSON_ALERTHUB_DOCKER`).
The `monit` job runs in [github-runners](https://github.com/inditex/github-runners) self hosted (configurable via `vars.RUNSON_ALERTHUB_ONPREM`).

## Steps

### `Parse application metadata`

Parse application metadata from `application.yml` to extract `project-key`.

### `Monit`

[Monit](https://github.com/inditex/actions/tree/main/monit) action that validates without deploying the subscriptions, inhibitions and mail-list defined in `monit` folder in **Alerthub**.
