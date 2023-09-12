# monit-deploy

[`monit-deploy.yml`](../monit-deploy.yml) workflow allows deploying alerts in **Alerthub**.

## Trigger

Any pull request `merged` to `main` branch when there are changes into `monit` path.

## Where does it run?

[github-runners](https://github.com/inditex/github-runners) self hosted.

## Steps

### `Parse application metadata`

Parse application metadata from `application.yml` to extract `project-key`.

### `Monit`

[Monit](https://github.com/inditex/actions/tree/main/monit) action that deploys the alerts defined in `monit` folder in **Alerthub**.
