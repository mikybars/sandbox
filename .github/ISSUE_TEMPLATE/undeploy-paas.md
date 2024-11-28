---
name: Undeploy PaaS permutation
about: Undeploy permutation from deployment branch
title: '[Undeploy PaaS Permutation]'
labels: 'undeployment'
assignees: ''

---

/undeploy-paas --supraenv `supraenvironment` --env `environments` --platform `platforms` --tenant `tenants` --slot `slots`

### Write above your permutations to undeploy

---

### Examples
**Undeploy a single permutation**
> /undeploy-paas --supraenv pro --env pro --platform ssccarteixo --tenant global -- slot default

**Undeploy multiple permutations**
> /undeploy-paas --supraenv pro --env pro --platform meccanointerxion2,meccanotelecity2 --tenant za,pb,bk

### Further information
- [ChatBot to deploy in PaaS](https://chatbot.docs.inditex.dev/chatbot/latest/commands/paas/undeploy-paas.html)
