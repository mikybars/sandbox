# Monit/Alerthub

Alerthub is a custom application developed by the architecture team to alert development and operation teams with time series information.

It replaces Kapacitor (influxdata opensource tool) to provide better integration into Inditex tool ecosystem as well as correct some issues related to late alert detection.

## Customising alert definitions
To use the Monit/Alerthub workflow you need to have created [this workflow](https://github.com/inditex/.github/blob/main/features/alerthub/workflows/monit-deploy.yml) for deployment and [this one](https://github.com/inditex/.github/blob/main/workflow-templates/monit-PR_verify.yml) for PR-Verify in the `.github/workflow` directory and have the **monit** directory in the repository.

To customise the project alerts it is necessary to create a pull request to the main branch in the monit directory containing a file with the **following naming convention**:
* alerts_[tenant:optional]\_[environment].json
* alerts_[environment].json

It is possible to have the files in subdirectories but the naming convention does not change, it has to be as above.

In this repository you can find examples of files to customise the alerts.

### Inhibitions definitions
#### What is an inhibition?
An inhibition is a period of time in which affected alerts will not be sent
#### Customising inhibitions
This same workflows also allows to configure inhibits in the monit directory. To do this (as for alerts) it is necessary to create a pull request to the main branch in the monit directory containing files with the **following naming convention**:
* inhibitions_[tenant:optional]\_[environment].json
* inhibitions_[environment].json

### Mail list definitions
#### What is a mail list?
Specify a mail list provide you to extract the mail definition from alerts*.json
#### Adding mail list
This same workflows also allows to configure mail list in the monit directory and reference the mail list into alerts file. To do this (as for alerts) it is necessary to create a pull request to the main branch in the monit directory containing files with the **following naming convention**:
* maillist_[tenant:optional]\_[environment].json
* maillist_[environment].json


## Additional Information
In this repository you can find examples of files to customise alerts, inhibitions and maillist.

[Official Alerthub Documentation](https://alerthub.docs.inditex.dev/alerthub/latest/home.html)