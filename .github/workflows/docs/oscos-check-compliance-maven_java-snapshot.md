# oscos-check-compliance-maven_java-snapshot

[oscos-check-compliance-maven_java-snapshot.yml](../oscos-check-compliance-maven_java-snapshot.yml)

## Trigger

Triggered when the `code-maven-build-snapshot` workflow completes successfully.

## Where does it run?

Runs on `citool-icr__code-ubuntu24.04-large`.

## Jobs

### `check-compliance`: Check compliance using sbom and wsc-oscodeps

#### Steps

- **action-checkout**: Checks out the repository code.
- **download-sbom-artifact**: Downloads the SBOM artifact from the previous workflow run.
- **credentials-resolver**: Resolves credentials using CyberArk and retrieves the S3 storage secrets.
- **get-project-key**: Extracts the project key from the repository metadata.
- **set-unique-s3-object-name**: Generates a unique S3 object name using the project key and timestamp.
- **upload-s3-file**: Uploads the SBOM file to the specified S3 bucket.
- **check-curation-file**: Checks if the `curation.yml` file exists in the repository.
- **validation-project-curation-file**: Validates the `curation.yml` file against the specified schema if it exists.
- **check-compliance**: Checks compliance using the OSCODEP API with the uploaded SBOM and curation file.
- **check-result**: Retrieves the compliance check result from the OSCODEP API.
- **generate-summary**: Generates a compliance summary based on the API results.
- **action-status-exist**: Fails the workflow if the compliance result is `FAILURE` or if there was an invocation error.