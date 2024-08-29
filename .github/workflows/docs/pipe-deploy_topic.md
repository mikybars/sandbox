# pipe-deploy_topic

[`pipe-deploy_topic.yml`](../pipe-deploy_topic.yml) workflow allows to **deploy** the kafka topics defined in configuration files of `pipe` folder into the environments specified in the parameters.

## Trigger
`workflow_dispatch` invoked from a ChatBot command `/deploy-pipe-topic` as described in [ChatBot documentation](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-pipe-topic.html)


### Where does it run?

[pipe github-runners](https://github.com/inditex/github-runners/tree/main/images/self-hosted/pipe) self hosted.
This workflow depends on the Pipe python scripts located on the project [clr-kafkaautomation](https://github.com/inditex/clr-kafkaautomation)

### Jobs

- #### `get-path`

  - **Steps**

    - Check the number of supraenvironments provided: only one is allowed
    - Get path from supraenvironment: allows to define diferent binary locations for _des, pre_ and _pro_

- #### `deploy-topic`

  - **Steps**

    - Get TOKEN for the pipe user service account (defined on the runners environment variable `SRVC_PIPEAPPMAPAX_USERNAME`)
    - Verify Pipe configuration using [Pipe verify action](https://github.com/inditex/actions/tree/main/pipe/verify)
    - Check PR Verify result and cancel the workflow if failed, notifying it by adding a comment to the originating PR.
    - Deploy PIPE Topics, use this [Pipe deploy topic action](https://github.com/inditex/actions/tree/main/pipe/deploy-topic) to run the pipe client scripts for creating the kafka topics.
