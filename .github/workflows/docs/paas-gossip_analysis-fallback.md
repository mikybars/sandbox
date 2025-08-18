# `code-gossip_analysis-fallback`

[`code-gossip_analysis-fallback.yml`](../code-gossip_analysis-fallback.yml) workflow allows to pass the Required Status Check in pull request with changes outside the monitored paths:
- 'paas/**'
- '.github/workflows/paas*'
- 'code/**'

Take a look to the related documentation: [Handling skipped but required checks](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/troubleshooting-required-status-checks#handling-skipped-but-required-checks)

## Trigger
Any pull request `opened` with only changes outside `code` or `paas` folder, or `paas-*` workflows.

## Where does it run?

`ubuntu-24.04` GitHub infrastructure.

## Jobs

- ### `gossip-analysis`
This job is defined **exclusively** to fulfill the required status check of **"Gossip / Analysis"**, and it **does not actually run**, since it is enough to be skipped to comply with the required check (`if: 'false'`).
