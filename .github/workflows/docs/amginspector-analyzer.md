# amginspector-analyzer

[`amginspector-analyzer.yml`](../amginspector-analyzer.yml) Workflow that runs [Microsoft Application Inspector](https://github.com/Microsoft/ApplicationInspector) in the project and uploads to AMIGA Inspector API in order to exploit the data in [AMIGA Inspector web](https://sscc.central.inditex.grp/amginspect/web).

## Trigger

- Every **push** over `develop` and `main` branches.
- In a **pull request** with `amiga-inspector` label.
- Manual dispatch.

## Where does it run?

[github-runners](https://github.com/inditex/iac-githubrunners/tree/main/code/runners/github/inspector) inspector self hosted.


## Jobs

- ### `run-inspector`

  - **Steps**
    - Checkout repo.
    - Checkout [Inditex actions](https://github.com/inditex/actions) repo.  
    - Checkout [AMIGA inspector configuration](https://github.com/inditex/cac-amigainspectorrules) repo.  
    - Extract project name and key from `application.yml` file.
    - Extract config data from the configuration repo.
    - Extract branch name.
    - Run [`amiga/inspector/run`](https://github.com/inditex/actions/amiga/inspector/run) in order to run MS Application Inspector analyze over de project code.