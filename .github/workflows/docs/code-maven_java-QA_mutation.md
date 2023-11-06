# code-maven_java-QA_mutation

[`code-maven_java-QA_mutation.yml`](../code-maven_java-QA_mutation.yml) workflow allows to **execute mutation tests**.

## Trigger

- Manually with `workflow_dispatch` invoked from a ChatBot command. See ChatBot official documentation here: [ChatBot documentation](https://chatbot.docs.inditex.dev/chatbot/latest/commands/test-qa.html)

## Versions used

`asdf` and any `Java`, `Maven` and `Node` versions supported by [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling).

## Where does it run?

This workflow relies on [IVM's asdf plugin](https://github.com/inditex/cac-asdftooling) to automatically load any tool version defined on the project's `code/.tool-versions` file.

## Jobs

- ### `mutation-testing-execution`

  - **Steps**
    - Checkout of `source code`
    - Set up the IVM environment
    - Retrieve project `configuration` (key, name, version, etc...) using [resolvers/config-resolver](https://github.com/inditex/actions/tree/main/resolvers/config-resolver) action
    - Run the mutation tests invoking a `maven` command with `pitest:mutationCoverage` goal
    - Display basic test info as `summary annotations` using [testing/results-summary-annotations](https://github.com/inditex/actions/tree/main/testing/results-summary-annotations) action
    - Publish `test report` to [jfrog](https://inditex.jfrog.io/ui/repos/tree/General/distributables/gh-artifacts) using [upload-artifact](https://github.com/inditex/actions/tree/main/upload-artifact) action
    - Publish metrics information to `devins` using [clr-adam](https://github.com/inditex/clr-adam)

## Configuration files

- ### `code/config_test/config_test.yml`

  Location of the reports supported by this workflow, to be able to:
  - Display basic test info as `summary annotations`
  - Publish `test report` to `JFrog`

  Supported reports:
  - Pitest
    - Requires Pitest plugins configuration

  ```yaml
  pitest:
    # Folders/Paths where the PITEST - MUTATION - results are stored or to be stored, from the root path of the repo
    results:
      pitest_report_folder:
        path: "code/target/pit-reports"
        artifact-name: "<APPKEY>-pitest"
        upload: true
        summary-type: pitest
  ```

## Additional information

### Mutation Test in Maven projects

Mutation testing is a form of white box testing in which testers change specific components of an application's source code to ensure a software test suite will be able to detect the changes.
Changes introduced to the software are intended to cause errors in the program. Mutation testing is directed to ensure the quality of a software testing suite, not the applications the suite will go on to test.

### Requirements
The PIT plugin for mutation testing needs to be configured in pom.xml, an example is shown below:
```xml
<build>
...
  <pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.6.4</version>
        <dependencies> <!--!! needed if using junit5 !! --><dependency>
          <groupId>org.pitest</groupId>
          <artifactId>pitest-junit5-plugin</artifactId>
          <version>0.14</version>
          </dependency>
        </dependencies>
        <configuration><!--The number of threads to use when mutation testing. By default a single thread will be used. -->
          <threads>4</threads>
          <timeoutFactor>3.0</timeoutFactor>
          <timeoutConstant>60000</timeoutConstant>
          <outputFormats>
            <outputFormat>XML</outputFormat>
            <outputFormat>HTML</outputFormat> <!--OPTIONAL -->
            <outputFormat>CSV</outputFormat>  <!--OPTIONAL -->
          </outputFormats>
          <exportLineCoverage>true</exportLineCoverage>
          <failWhenNoMutations>false</failWhenNoMutations>
          <timestampedReports>false</timestampedReports>
          <excludedTestClasses>
            <param>com.inditex.**.*IT</param>
          </excludedTestClasses>
          <targetClasses>
            <param>com.inditex.<YOUR_PACKAGE>.*</param>
          </targetClasses>
          <excludedClasses>
            <param>**.*DTO</param>
            <param>**.*DTO$*</param> <!--needed if inner class -->
            <param>**.*dto</param>
            <param>**.*Dto</param>
            <param>**.*VO</param>
            <param>**.*vo</param>
            <param>**.*Vo</param>
            <param>**.dto.*</param>
            <param>**.api.*Api</param>
            <param>**.rest.client.*</param>
            <param>**.model.entity.*</param>
            <param>**.model.entity.id.*</param>
            <param>**.config.*Configuration</param>
            <param><SPECIFIC_EXCLUSION_1></param>
            <param><SPECIFIC_EXCLUSION_2></param>
          </excludedClasses>
          <verbose>false</verbose> <!--OPTIONAL -->
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
  ...
</build>
```
