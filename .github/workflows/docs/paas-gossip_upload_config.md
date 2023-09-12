# paas-gossip_upload_config

[`paas-gossip_upload_config.yml`](../paas-gossip_upload_config.yml) workflow allows upload Gossip config for this service (.gossip.yml file).

## Trigger

Push on `main` branch.

## Where does it run?

[github-runners](https://github.com/inditex/github-runners) self hosted.

## Steps

### Launch Gossip Server request

[Gossip upload](https://github.com/inditex/gha-sreactions/tree/gossip-v3/gossip/gossip-upload) action that send Gossip config file.

Find the .gossip.yml file from code folder and perform HTTP POST to gossip server

