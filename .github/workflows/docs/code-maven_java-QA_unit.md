# code-maven_java-QA_unit

[`code-maven_java-QA_unit.yml`](../code-maven_java-QA_unit.yml) workflow allows to **execute unit tests**.

## Trigger
- Manually with `workflow_dispatch` invoked from a ChatBot command. See ChatBot official documentation here: [ChatBot documentation](https://chatbot.docs.inditex.dev/chatbot/latest/commands/test-qa.html)
- Any `closed` pull request against `develop` branch (using GitFlow), and any `closed` pull request against `main` branch (using Trunk Based Development) with changes either in the `code` folder or the workflow file itself.
- Any published `release`.

## Where does it run?

Self-hosted runner: [iac-githubrunners/testing-ivm](https://githubrunners.docs.inditex.dev/githubrunners/latest/custom-runners/testing-ivm.html)

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## How does it work?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) and the [`setup-environment` action](https://github.com/inditex/gha-ivmactions/tree/develop/setup-environment) to automatically **load a given tool version and any needed extra environment variable** (i.e. `$NODE_HOME`) defined on the project's `code/.tool-versions` file.

## Jobs

- ### `unit-tests`

  - **Steps**

    - Check and set the default branch, depending on the development flow used.
    - Checkout of `source code`
    - Retrieve `metadata` (key, name, version, etc...) from the project
    - Run the unit tests invoking a `maven` command
    - Attach `report` to github run
    - Run `sonar-scanner` tool
    - Publish metric information to `devins`

## Configuration files

- ### `code/config_test/config_test.yml`

  Location of the reports supported by this workflow, to be able to:
  - Display basic test info as `summary annotations`
  - Publish `test report` to `JFrog`

  Supported reports:
  - Jacoco
    - Requires Jacoco plugins configuration
  - Surefire xml
    - Path to surefire xml's used for DEVINS publication - Not uploadable
  - Surefire html - OPTIONAL -
    - Requires **maven-surefire-report-plugin** and **maven-site-plugin** (See example configuration below)

  ```yaml
  junit:
    unit:
      # Folders/Paths where the JUNIT - UNIT - results are stored or to be stored, from the root path of the repo
      results:
        jacoco_report_folder:
          path: "code/jacoco-report-aggregate/target/site/jacoco-aggregate"
          artifact-name: "<APPKEY>-junit-unit"
          upload: true
          summary-type: jacoco
        surefire_xml_report_path:
          path: "target/surefire-reports" # Path to surefire xml's used for DEVINS publication - Not uploadable
          upload: false
        surefire_html_report_folder:
          path: "code/target/surefire-html-report"
          artifact-name: "<APPKEY>-junit-unit"
          upload: true
          summary-type: surefire
  ```

  Configuration for **maven-surefire-report-plugin** and **maven-site-plugin**

  ```xml
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-report-plugin</artifactId>
      <version>${maven-surefire-report-plugin.version}</version>
      <configuration>
          <outputDirectory>${project.build.directory}/surefire-html-report</outputDirectory>
          <aggregate>true</aggregate>
      </configuration>
  </plugin>
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-site-plugin</artifactId>
      <version>${maven-site-plugin.version}</version>
      <configuration>
          <outputDirectory>${project.build.directory}/surefire-html-report</outputDirectory>
      </configuration>
  </plugin>
  ```

  The minimum versions tested of these plugins are:

  ```xml
  <maven-surefire-report-plugin.version>2.22.2</maven-surefire-report-plugin.version>
  <maven-site-plugin.version>3.10.0</maven-site-plugin.version>
  ```

  **This configuration should be applied on the main pom of the project**

  The command to locally test this implementation is:

  ```bash
  mvn -f code surefire-report:report-only site:site -DoutputName=index -DalwaysGenerateSurefireReport=true -DgenerateReports=false
  ```
