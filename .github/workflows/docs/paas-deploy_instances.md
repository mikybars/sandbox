# paas-deploy-instances

[`paas-deploy_instances.yml`](../paas-deploy_instances.yml) workflow manages the deployment of several permutations at the same time.

## Trigger

`workflow_dispatch` from a `issue` with ChatBot. See [`/deploy-paas-instances`](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-paas-instances.html) documentation.

## Where does it run?

`ubuntu-20.04` GitHub cloud runner.
