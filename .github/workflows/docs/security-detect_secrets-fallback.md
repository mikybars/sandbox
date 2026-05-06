# `security-detect_secrets-fallback`

[`security-detect_secrets-fallback`](../security-detect_secrets-fallback.yml) workflow allows to pass Required "DSecrets / PR" Status Checks in pull request with changes outside the monitored paths:
- `**`

Take a look to the related documentation: [Handling skipped but required checks](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/troubleshooting-required-status-checks#handling-skipped-but-required-checks)

## Trigger
Any pull request `opened` with empty commits.

## Where does it run?

`RUNSON_DSECRETS_ONPREM` repository variable (default: `citool-github__ubuntu24.04-medium`) defines the label of the internal/self-hosted runner used by this workflow (not GitHub-hosted runners).
