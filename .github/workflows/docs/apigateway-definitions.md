# apigateway-definitions

[`apigateway-definitions.yml`](../apigateway-definitions.yml) workflow allows to
**load** definitions on apigateway folder for v2 deployment and templates.

## Trigger

Any pull request or push into main branch when there are changes into `apigateway` path.

## Where does it run?

[apigateway
github-runners](https://github.com/inditex/iac-githubrunners/tree/main/code/runners/github/products/apigateway)
self hosted.

## Jobs

- ### `load-definitions`

  - **Steps**

    - get changes on `apigateway` path
    - send kafka event with this changes
