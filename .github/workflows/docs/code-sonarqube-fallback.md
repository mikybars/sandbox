# `code-sonarqube-fallback`

[`code-sonarqube-fallback.yml`](../code-sonarqube-fallback.yml) workflow allows to pass Required "SonarQube Code Analysis" Status Checks in pull request with changes outside the monitored paths:
- `code/**`
- `.github/workflows/code*`

Take a look to the related documentation: [Handling skipped but required checks](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/troubleshooting-required-status-checks#handling-skipped-but-required-checks)

## Trigger
Any pull request `opened` with only changes outside `code` folder or `code-*` workflows.

## Where does it run?

`RUNSON_SONARQUBE_GENERIC` repository variable (default: `citool-github__ubuntu24.04-medium`).

## Jobs

- ### `sonar-check`
This job is defined **exclusively** to fulfill the Required Status Check of **"SonarQube Code Analysis"**, and it **does not actually run** since it is enough to be skipped to comply with the required check (`if: 'false'`).
