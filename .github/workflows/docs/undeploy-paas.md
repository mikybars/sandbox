# undeploy-paas

[undeploy-paas.yml](../undeploy-paas.yml) workflow manages the deletion of several deployment permutations at the same time.

## Trigger

`workflow_dispatch` from a `issue` with ChatBot. See [`/undeploy-paas`](https://chatbot.docs.inditex.dev/chatbot/latest/commands/delete-paas-instances.html) documentation.


## Where does it run?

`ubuntu-24.04` GitHub cloud runner.

## Diagrams for the workflow and actions

### undeploy-paas workflow

```mermaid
---
title: "Workflow: undeploy-paas"
---
flowchart LR
    subgraph Execution
        direction TB
        A --> B --> C --> D --> |KO| E
        C --> |OK| F --> G --> |KO| E
        G --> |OK| H --> I
        I --> J
        subgraph filter-permutations
            A["Prepare JSON list with permutations"]
        end
        subgraph create-delete-prs
            B["Checkout repository"]
            C["Create PR for Folder Deletion"]
            D["Save result of PR creation"]
            E["Handle errors or already existing PRs"]
            F["Create new deletion PR"]
        end
        subgraph generate-comment
            G["Restore artifact results"]
            H["Set output"]
            I["Generate status comment"]
            J["End of workflow"]
        end
    end
```