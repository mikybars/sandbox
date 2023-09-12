# paas-gossip_analysis

[`paas-gossip_analysis.yml`](../paas-gossip_analysis.yml) workflow allows running a **Gossip** analysis for PaaS projects.

## Trigger

Any pull request `merged` to `main` branch when there are changes into `code` or `paas` path.

## Where does it run?

[github-runners](https://github.com/inditex/github-runners) self hosted.

## Steps

### Clean tmp folders

Remove temporaly folders

### Launch Gossip Config Generator

[Gossip config](https://github.com/inditex/gha-sreactions/tree/gossip-v3/gossip/gossip-config) action that trigger the next task:

#### Create configmap and secret file to analyzer
#### Configure HTML Template for report result
#### Create temporal folders(result, target, rules)
#### Create data.json configuration file

### Merge Config Files

 Create different config files by environment, tenant, slot

### Download CEPH Rules

 Download last version rules from CEPH

### Parse application metadata

Parse application metadata from `application.yml` to extract `project-key`.

### Get Macrodomain from Application Map

Retrieve macrodomain of project-key from Application Map

### Configure Rules Namespace

Create rules namespace from macrodomain info

### Gossip analyze

Create report result


### Upload Gossip Analysis reports

Upload artifacts on workflow summary view.

### Send Report Event

[Gossip event](https://github.com/inditex/gha-sreactions/tree/gossip-v3/gossip/gossip-event) action that send report result.
