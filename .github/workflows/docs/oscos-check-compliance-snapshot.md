# oscos-check-compliance-snapshot

[oscos-check-compliance-snapshot.yml](../oscos-check-compliance-snapshot.yml)

## Trigger

Triggered when any of the following workflows complete successfully: `code-make-build-snapshot`, `code-poetry-build-snapshot`, `code-dotnet-build-snapshot`, `code-gradle-build-snapshot`.

## Where does it run?

Runs on `citool-icr__code-ubuntu24.04-large`.

## Jobs

### `check-compliance`: Check compliance using sbom and wsc-oscodeps

#### Steps

- **action-checkout**: Checks out the repository code.
- **setup-jfrog-cli**: Sets up the JFrog CLI tool.
- **setup-node-version**: Sets up the specified Node.js version using IVM.
- **setup-npm**: Configures the NPM environment.
- **setup-cdxgen**: Installs the CDXGEN tool for SBOM generation.
- **generate-sbom**: Generates the SBOM using CDXGEN and outputs the SBOM path.
- **credentials-resolver**: Resolves credentials using CyberArk and retrieves the S3 storage secrets.
- **get-project-key**: Extracts the project key from the repository metadata.
- **process-go-project**: Processes the Go project by extracting the version from the Makefile if applicable.
- **set-unique-s3-object-name**: Generates a unique S3 object name using the project key and timestamp.
- **upload-s3-file**: Uploads the generated SBOM file to the specified S3 bucket.
- **check-curation-file**: Checks if the `curation.yml` file exists in the repository.
- **validation-project-curation-file**: Validates the `curation.yml` file against the specified schema if it exists.
- **check-compliance**: Checks compliance using the OSCODEP API with the uploaded SBOM, curation file, and project version.
- **check-result**: Retrieves the compliance check result from the OSCODEP API.
- **generate-summary**: Generates a compliance summary based on the API results.
- **action-status-exist**: Fails the workflow if the compliance result is `FAILURE` or if there was an invocation error.
