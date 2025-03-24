# oscos-check-compliance-release

[oscos-check-compliance-release.yml](../oscos-check-compliance-release.yml)

## Trigger

This workflow is triggered when a new release is published.

## Where does it run?

Runs on `citool-icr__code-ubuntu24.04-large`.

## Jobs

### `check-compliance`: Check compliance using SBOM and wsc-oscodeps

#### Steps

- **action-checkout**: Checks out the repository code.
- **setup-jfrog-cli**: Sets up the JFrog CLI tool.
- **setup-node-version**: Configures the specified Node.js version (`ivm-node` version `20`).
- **setup-npm**: Configures the NPM environment by adding Node.js binaries to the `PATH`.
- **setup-cdxgen**: Installs the `@cyclonedx/cdxgen` tool for generating SBOMs.
- **determine-language**: Determines the primary programming language of the repository based on metadata.
- **package-json-loader**: Extracts the `name` and `license` attributes from the `package.json` file (for JavaScript projects).
- **generate-sbom**: Generates the SBOM using `cdxgen` for non-JavaScript projects and outputs the SBOM path.
- **generate-sbom-javascript**: Generates the SBOM using `cdxgen` specifically for JavaScript projects and outputs the SBOM path.
- **customize-sbom**: Customizes the generated SBOM using attributes from the `package.json` file (for JavaScript projects).
- **credentials-resolver**: Resolves credentials using CyberArk and retrieves the S3 storage secrets.
- **get-project-key**: Extracts the project key from the `application.yml` file.
- **determinate-version**: Determines the project version either from the Makefile or the release tag (for Go and Makefile-based projects).
- **set-unique-s3-object-name**: Generates a unique S3 object name using the project key and a timestamp.
- **upload-s3-file**: Uploads the generated SBOM file to the specified S3 bucket.
- **check-curation-file**: Checks if a `curation.yml` or `oscos-curation.yml` file exists in the repository.
- **validation-project-curation-file**: Validates the `curation.yml` or `oscos-curation.yml` file against the specified schema, if it exists.
- **check-compliance**: Checks compliance using the OSCODEP API with the uploaded SBOM, curation file, and project version.
- **check-result**: Retrieves the compliance check result from the OSCODEP API.
- **generate-summary**: Generates a compliance summary based on the API results.
- **open-issue-report**: Opens a GitHub issue with the compliance summary report if the compliance result is `FAILURE`.
- **upload-sbom-asset**: Uploads the SBOM file as a release asset in GitHub Releases.
- **action-status-exist**: Fails the workflow if the compliance result is `FAILURE` or if there was an invocation error.
