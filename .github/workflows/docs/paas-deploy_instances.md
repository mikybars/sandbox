# paas-deploy-instances

[`paas-deploy_instances.yml`](../paas-deploy_instances.yml) workflow manages the deployment of several permutations at the same time.

## Trigger

`workflow_dispatch` from a `issue` with ChatBot. See [`/deploy-paas-instances`](https://chatbot.docs.inditex.dev/chatbot/latest/commands/deploy-paas-instances.html) documentation.

## Where does it run?

`ubuntu-20.04` GitHub cloud runner.

## Diagrams fot the workflow and actions

### deploy-paas-instances workflow

```mermaid
---
title: "Workflow: deploy-paas-instances"
---
flowchart LR
    subgraph Execution
        direction TB
        A --> B --> D
        C --> D --> E --> F --> G
        G --> |OK| H
        G --> |KO| I
        H --> J --> K
        I --> K
        L -..-> B
        M -....-> E
        A["
            Validate
            slots
        "]
        B("
            Filter permutations
            by Input
        ")
        C["
            Get Affected
            PRs
        "]
        D("
            Init comment
            on issue
        ")
        E("
            Get PRs
            information
            for action
        ")
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
        M(("
            Approve -> OPEN
            Restore -> MERGED
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

### Approve action

```mermaid
---
title: "Workflow: deploy-paas-instances --action approve"
---
flowchart LR
    subgraph Approve
        direction LR
        A --> C
        B --> C
        C --> |"
        Called N
        times
        for each
        affected PR
        "| 2-mimic
        I --> J --> K
        G --> J
        H --> J
        J -.- L
        L -.- M
        subgraph 1-prepare
            A["
                Get Mimic
                token
            "]
            B["
                Get user
                from comment
            "]
            C["For each PR"]
        end
        subgraph 2-mimic
            D --> E
            E --> F
            F --> |others| G
            F --> |428| H
            F --> |200| I
            D["
                Send approve
                request to
                mimic
            "]
            E["
                Get response
                from mimic
            "]
            F{"
                http
                code
            "}
            G["
               Generic error
               response
            "]
            H["
                'Authorization needed'
                response
            "]
            I["
                Success
                response
            "]
        end
        subgraph 3-summary
            J["
                Merge all
                responses
            "]
            K["
                Return
                responses
                summary
            "]
            L("
                Internally
                Store if
                Any Approve
                Failed
            ")
            M(("
                To use
                in Merge
                Workflow
            "))
        end
    end

```
### Merge action

```mermaid
---
title: "Workflow: deploy-paas-instances --action merge"
---
flowchart LR
    subgraph Merge
        direction LR
        A --> C
        B --> C
        P --> |"NO"| Z
        I --> J --> K
        G --> J
        H --> J
        subgraph 2-prepare
            Z["
                Start Mimic
                Operations
            "]
            A["
                Get Mimic
                token
            "]
            B["
                Get user
                from comment
            "]
            C["For each PR"]
        end
        C --> 3-approve
        Z --> A
        Z --> B
        subgraph 4-merge
            D --> E
            E --> F
            F --> |others| G
            F --> |428| H
            F --> |200| I
            D["
                Send Merge
                request to
                mimic
            "]
            E["
                Get response
                from mimic
            "]
            F{"
                http
                code
            "}
            G["
               Generic error
               response
            "]
            H["
                'Authorization needed'
                response
            "]
            I["
                Success
                response
            "]
        end
        subgraph 5-summary
            J["
                Merge all
                responses
            "]
            K["
                Return
                responses
                summary
            "]
        end
        subgraph 1-verify
            subgraph internal-verification
            direction LR
                L["
                    Check if 
                    review by codeowner
                    Required
                "]
                M["
                    Check if user
                    is codeowner
                "]
                N["
                    User has permissions
                "]
                O["
                    User in any
                    codeowner 
                    Group
                "]
                    OP["
                    User 
                    doesn't have 
                    permissions
                "]
            end
            P["
                Check if any
                missing permissions
                in any PR 
            "]
            P["
                Check if missing 
                permissions
                in any PR 
            "]
            Q["
                Break full workflow
            "]
            L --> |"yes"| N
            L --> |"no"| M
            M --> |"yes"| N
            M --> |"no"| O
            P --> |"yes"| Q
            P -.- |"Internally"| internal-verification
            O --> |"no"| OP
            O --> |"yes"| N
            Q --> |"Send error"| K
        end
        subgraph 3-approve
        R["
                Execute Regular
                approve workflow
        "]
        S["
                Any error
        "]
        T["
                Successful
        "]
        end
        R --> S
        R --> T
        S --> |"Send error"| K
        T -->  D
    end

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
