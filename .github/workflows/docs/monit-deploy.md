# monit-deploy

[`monit-deploy.yml`](../monit-deploy.yml) workflow allows deploying alerts in **Alerthub**.

## Trigger

Any pull request `merged` to `main` branch when there are changes into `monit` path.

## Where does it run?

The `linter` job runs in `citool-github__ubuntu24.04-medium` internal runners (configurable via `vars.RUNSON_ALERTHUB_DOCKER`).
The `monit` job runs in [github-runners](https://github.com/inditex/github-runners) self hosted (configurable via `vars.RUNSON_ALERTHUB_ONPREM`).

## Steps

### `Parse application metadata`

Parse application metadata from `application.yml` to extract `project-key`.

### `Monit`

[Monit](https://github.com/inditex/actions/tree/main/monit) action that deploys the alerts defined in `monit` folder in **Alerthub**.
