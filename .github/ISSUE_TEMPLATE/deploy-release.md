---
name: Deploy Release
about: Deploy a version has been already released
title: '[Deploy Release] X.Y.Z version'
labels: 'deployment'
assignees: ''

---

/deploy-paas --version `X.Y.Z` --supraenv `supraenvironment` --env `environments` --platform `platforms` --tenant `tenants` --slot `slots` --label `deployment-label`

### Write above your permutations to deploy :rocket:

---

### Examples
**Deploy with simple parameters**
> /deploy-paas --version X.Y.Z --supraenv pro --env pro --platform ssccarteixo --tenant global

**Deploy with multiple parameters**
> /deploy-paas --version X.Y.Z --supraenv pro --env pro --platform meccanointerxion2,meccanotelecity2 --tenant za,pb,bk

**Deploy in a non-default slot**
> /deploy-paas --version X.Y.Z --supraenv pro --env pro --platform ssccarteixo --tenant global --slot other-slot

**Deploy forcing manual approval**
> /deploy-paas --version X.Y.Z --supraenv pro --env test --platform ssccarteixo --tenant global --label manual-approval

**Deploy with Blue/Green rollout strategy**
> /deploy-paas --version X.Y.Z --supraenv pro --env pro --platform meccanointerxion2,meccanotelecity2 --tenant za --strategy bluegreen

**Deploy with Blue/Green Canary rollout strategy and 10% traffic split**
> /deploy-paas --version X.Y.Z --supraenv pro --env pro --platform meccanointerxion2,meccanotelecity2 --tenant za --strategy bluegreen-canary --percentage 10

### Further information
- [ChatBot to deploy in PaaS](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-in-paas.html)
- [ChatBot to deploy in PaaS with different rollout strategies](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-rollout-strategy.html)
