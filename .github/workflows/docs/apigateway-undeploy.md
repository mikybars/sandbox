# apigateway-undeploy

[`apigateway-undeploy.yml`](../apigateway-undeploy.yml) workflow allows to
**undeploy** unpublish janus services.

## Trigger

`workflow_dispatch` invoked from a ChatBot command `/undeploy-apigateway` as
described in [ChatBot documentation](https://chatbot.docs.inditex.dev/chatbot/latest/commands/api-gateway/unpublish-apigateway.html)

## Where does it run?

[apigateway
github-runners](https://github.com/inditex/iac-githubrunners/tree/main/code/runners/github/products/apigateway)
self hosted.

## Jobs

- ### `get-path`

  - **Steps**

    - Check the number of supraenvironments provided: only one is allowed
    - Get path from supraenvironment: allows to define diferent binary
      locations for _des, pre_ and _pro_.

- ### `unpublish-apigateway`

  - **Steps**

    - unpublish APIGateway, uses this [apigateway unpublish action](https://github.com/inditex/actions/tree/main/apigateway/unpublish)
      to run the apigateway client.
