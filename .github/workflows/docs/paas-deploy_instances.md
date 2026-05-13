# paas-deploy-instances

[`paas-deploy_instances.yml`](../paas-deploy_instances.yml) workflow manages the deployment of several permutations at the same time.

## Trigger

`workflow_dispatch` from a `issue` with ChatBot. See [`/deploy-paas-instances`](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-paas-instances.html) documentation.

## Where does it run?

- `RUNSON_PAAS_GENERIC` (default: `citool-github__ubuntu24.04-medium`)

## Diagrams fot the workflow and actions

### deploy-paas-instances workflow

```mermaid
---
title: "Workflow: deploy-paas-instances"
---
flowchart LR
    subgraph Execution
        direction TB
        A --> B --> F
        C --> F --> G
        G --> |OK| H
        G --> |KO| I
        H --> J --> K
        I --> K
        L -..-> B

        A["
            Validate slots
        "]
        B("
            Filter permutations by coordinates
        ")
        C["
            Get affected PRs by issue
        "]
        F("
            Action flow
            (see action diagrams)
        ")
        G{Success}
        H["
            Prepare
            summary
        "]
        I["
            Error comment
            on issue
        "]
        J("
            Summary comment
            on issue
        ")
        K("
            Workflow
            end
        ")
        L(("
            All permutations
            if coordinates
            are empty
        "))
    end

    subgraph Inputs
        direction LR
        newline1 --> id1
        newline2 --> id2
        rollout --> id3
        subgraph Action
            newline1["all actions"]
            newline2["
                approve
                restore
                cancel
                continue
                rollback
                retry
            "]
            rollout
        end

        subgraph Parameters
            id1[["
                issue-number
                comment-id
                action
            "]]
            id2[["
                supraenv
                envs
                platforms
                tenants
                slots
            "]]
            id3[["
                skips
            "]]
        end
    end
    Inputs --> Execution
```

### Restore action

```mermaid
---
title: "Workflow: deploy-paas-instances --action restore"
---
flowchart LR
    subgraph Restore
        direction LR
        1-init --> |"
            Called N times
            for each PR
            in Workflow matrix
        "| 2-restore --> |"
            When all parallel
            executions finish
        "| 3-summary
        subgraph 1-init
            A --> B
            A["
                Create issue to
                link restore PRs
            "]
            B["For each PR"]
        end
        subgraph 2-restore
            C --> D --> E --> F
            C["
                Recover last
                commit data
                form permutation
            "]
            D["
                Create new branch
                with restored data
            "]
            E["
                Create PR
                from new brnach
                to deployments
            "]
            F["
               Upload artifact
               with operation
               results
               (success or error)
            "]
        end
        subgraph 3-summary
            G --> H --> J
            G --> I --> J
            G["
                Download all
                artifacts
            "]
            H["
                Prepare response
                from success
                artifacts
            "]
            I["
                Prepare response
                from error
                artifacts
            "]
            J["
                Comment on
                restore issue
                with results
            "]
        end
    end
```

### Cancel, merge & approve commands using MIMIC

```mermaid
---
title: "Cancel, merge & approve commands using MIMIC"
---

flowchart LR
    subgraph Mimic Actions : close - merge - approve
        direction LR
        1-init-mimic --> |"
            Called N times
            for each PR
            in Workflow matrix
        "| 2-execute-mimic --> |"
            When all
            executions finish
        "| 3-summary-mimic
        subgraph 1-init-mimic
            A --> |OK| B --> C --> D -->|OK| E
            A --> |KO| F
            D --> |KO| F
            A["Verify Comment Association"]
            B["Get Affected PRs information"]
            C["Get user"]
            D["
                   Check Pr permissions
               (only cancel - merge commands)
               "]
            E["Add comment with started status"]
            F["Add comment with error status"]
        end
        subgraph 2-execute-mimic
            G --> H --> I --> J --> K
            G["Get MIMIC token"]
            H["Call Mimic approve previously if comand action is merge"]
            I["
                Call Mimic for action
              (close - merge - approve)
              "]
            J["Delete deployment branch if comand action is cancel"]
            K["Upload operation results"]
        end
        subgraph 3-summary-mimic
            L --> M --> N
            L["
                Download all
                artifacts
            "]
            M["
                Prepare response
                from
                artifacts
            "]
            N["
                Generate comment
                with summary results
            "]
        end
    end
```
