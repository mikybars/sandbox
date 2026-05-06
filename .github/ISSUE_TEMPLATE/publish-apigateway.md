---
name: Publish APIGateway
about: Publish an apigateway on Janus
title: '[Publish APIGateway]'
labels: 'apigateway'
assignees: ''

---

/deploy-apigateway --publication `publication-type` --supraenv `supraenvironment` --env `environments` --platform `platforms` --tenant `tenants`

### Write above your permutations to publish :rocket:

---

### Examples
**Example with simple parameters**
> /deploy-apigateway --publication `INTERNAL` --supraenv pro --env pro --platform ssccarteixo --tenant global

**Example with multiple parameters**
> /deploy-apigateway --publication `EXTERNAL` --supraenv pro --env pro --platform meccanointerxion2,meccanotelecity2 --tenant za,pb,bk

### More information
- [ChatBot to publish APIGateway](https://chatbot.docs.inditex.dev/chatbot/latest/commands/publish-apigateway.html)
