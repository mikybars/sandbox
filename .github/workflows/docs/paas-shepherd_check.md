# paas-shepherd-check

[`paas-shepherd_check.yml`](../paas-shepherd_check.yml) workflow allows to trigger a preliminar deployment check in Shepherd for deployment pull requests before merging them. This works only for PRs labeled as _manual-approval_ and has no efect for the rest. 

## Trigger

This workflow is triggered as part of the `paas-promote`workflow. A new job `shepherd-check`dependant on the `promote`job _uses_ this new workflow.


## Where does it run?

[github-runners](https://github.com/inditex/github-runners) self hosted [common].

## Jobs

- ### `get-details`

  - **Steps**
    - Extract required information from PR and builds a matrix with the affected PRs to be iterated by the following job.
    
- ### `shepherd-check`
  - **Steps** (_for each PR in the get-detail output matrix_)
    - Read the `info.yml` file from the repository to extract additional info.
    - Call the action [`shepherd-check`](https://github.com/inditex/actions/tree/main/deployment/shepherd-check) to start the Sphepherd Check processing.
    - Add comments in case of failure.