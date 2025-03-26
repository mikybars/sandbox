# paas-deploy-rollout-strategy

[`paas-deploy_rollout_strategy.yml`](../paas-deploy_rollout_strategy.yml) workflow allows to deploy with differents rollout strategies a service deployed in a Kubernetes cluster

## Trigger

`workflow_dispatch` from a `deployment` pull request with ChatBot. See [`/deploy-rollout-strategy`](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-rollout-strategy.html) documentation.

## Where does it run?

[paasfeature](https://github.com/inditex/app-cdtool/tree/main/icr/github/paasfeature) self hosted runners.

## Jobs

- ### `rollout-strategy`

  - **Steps**
    - [`rollout`](https://github.com/inditex/gha-paasdeployment/tree/main/deployment/rollout-strategy) action will send requests to cdmngmt to deploy the service step by step.
