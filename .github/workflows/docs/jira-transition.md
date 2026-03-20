# jira-transition

[`jira-transition.yml`](../jira-transition.yml) workflow runs [Jira Transition Action](https://github.com/inditex/gha-jiratransition)
to transit JIRA issues from GitHub pull request states.

## Trigger
Any `pull_request` events.

### Where does it run?
- `jira-transition` job runs on `citool-icr-aks__ubuntu24.04-small` or the value of the `var.RUNSON_JIRATRANSITION_GENERIC` repository variable if it is set.
- `jira-transition-release` job runs on `citool-icr-aks__ubuntu24.04-small` or the value of the `var.RUNSON_JIRATRANSITION_DOCKER` repository variable if it is set.

### Service user
The workflow uses the specific `vars.SRVCJIRATRANSIT_USERNAME` (**srvcjiratransitad**) and its `secrets.SRVCJIRATRANSIT_PASSWORD` secrets to authenticate with the Jira API.

### Jobs
- #### `jira-transition`
  - **Steps**
    - Executes the GitHub Action located in [inditex/gha-jiratransition](https://github.com/inditex/gha-jiratransition)
  using its config file located in `.github/workflows/config/jira-transition.yml`, and transits issues to "In Review" status when a pull request is opened or updated, and to "Done" status when a pull request is merged.

- #### `jira-transition-release`
  - **Steps**
    - Executes the GitHub Action located in [inditex/gha-jiratransition](https://github.com/inditex/gha-jiratransition) using its config file located in `.github/workflows/config/jira-transition-release.yml` to transit issues to "Released" status when a pull request is merged.
