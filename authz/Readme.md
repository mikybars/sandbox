## AsCode AuthZ Repo

## Introduction:

This repository should contain 3 files, one per environment, that define the authorization of your application. These files will be named as: 

	* authz_des.yml 
	* authz_pre.yml 
	* authz_pro.yml 

With these files, your application will be created at the management access system (one per environment). Once the application is created, you can go to our management access system and assign roles to any existing user at Inditex AD. The Inditex management access system is available at: 

	* DEV: https://axdeswas17.central.inditex.grp:9443/AQSWAdministracionSSO/aplicaciones/index.html#init/ 
	* PRE: https://axpreweb1.central.inditex.grp/AQSWAdministracionSSO/aplicaciones/index.html#init/ 
	* PRO: https://axinwebnospnego.central.inditex.grp/AQSWAdministracionSSO/aplicaciones/index.html#init/ 

The application will be created with your JIRA code as the identifier. So, to find it at the management access system or to configure your service security, you have to use the JIRA code.  

### How to Complete your Authz Information?

Maintenance over permissions and attributes is enabled via an "AsCode" mechanism provided through an API inside the COMMAND component, defining the entire model in YML format for each application/service.

Each section of the file is explained below:

Defining an application:
```

- name: Name of the project
- appDescription: Project description
- platform: Application platform. At the time of writing this readme, the following platforms are available from the production environment:
    - AS400   
    - Acceso_Directo                          
    - Batch   
    - C/S     
    - Epo     
    - Gestor Aplicaciones                     
    - Grp
    - Local   
    - SGA-Central                             
    - SGA-Instalación                        
    - SGA-SGA_Físico                         
    - SIN     
    - SIN_PLATAFORMA                          
    - Screen  
    - Screen-Parent                           
    - TGT     
    - TS      
    - VisualFoxPro                            
    - WS      
    - Web
    - Windows Mobile 6.1
    - Windows Mobile 6.5
    - Windows Mobile 6.5.3
    - Windows Mobile Genérico
    - nodejs
- category: Project category. At the time of writing this readme, the following categories are available from the production environment:
    - Administracion
    - Aereo
    - Aplicaciones Locales Bershka
    - Aplicaciones Locales Dutti
    - Aplicaciones Locales Tempe
    - Auditoria Interna
    - Automatización y sistemas logística
    - Comercial-Producto-Distribución
    - Compras y Contrataciones
    - Comunicación
    - Expansión
    - Financiero
    - Fábricas
    - Incidencias
    - Información Proveedores
    - Integracion
    - Jurídico
    - Lanzadera Aplicaciones Extranet
    - Logistica-Corporativa
    - Logística-Administración
    - Logística-Operaciones
    - Maestros
    - Normativa
    - Ofimática
    - RRHH
    - SIN_CATEGORIA
    - Secretaría General
    - Seguridad de la Información
    - Servicios Centrales
    - Sistemas
    - Supply Chain
    - TGT
    - Terrestre
    - Tienda
    - Utilidades
    - comunes
- link: Application url.
```

The following section (authInfo) provides functionality to define application roles, permissions associated with those roles, attributes, and relations between applications.

The "roles" subsection allows defining a list of roles with their associated permissions. An example would be:
```
authzInfo:
  roles:
  - roleName: "admin"
    permissions:
    - "ACTUATOR"
    - "upload_authz"
    - "read_app_data"
  - roleName: "writer"
    permissions:
    - "upload_authz"sto
  - roleName: "reader"
    permissions:
    - "read_app_data"
```

The subsection "attributes" allows creating attributes for the application:
```
authzInfo:
  attributes:
  - attributeName: "country"
  - attributeName: "storeId"
```

The final subsection, "relations", which is the most recent one, allows connecting roles and attributes between two applications. This mechanism solves the problems derived from having to manage the assignment of permissions and attributes to users in each application separately. It does so by creating rules to assign roles and attributes to a user in an application and this action will assign those roles in the related applications for which this set of rules may apply.

A classic example would be to have a SPA (expressed as A) and a Backend (expressed as B) in which we only want to assign roles and attributes to users from SPA but without having to replicate the operation inside the backend.

This way, if we want a user from the SPA-A to have permissions over Backend-B, the owner of B will be asked to create a new rule in his AsCode according to which a user with the role X in SPA-A will automatically have the role Y in the Backend-B.
```
  relations:
    roleRelations:
    - roleName: "test_srvc_admin"
      foreignRoles:
      - foreignApplication: "SPATEST"
        foreignRoleName: "test_spa_admin"
```

There is another typical case in which the service request is not made by a user, but by another service. In this case, the requesting service (Service-A) must identify against Service-B to obtain the required roles or attributes.
To define this, and inside the AuthZ file of Service-B, the user from Service-A must be included in the "foreignApplications" list.
```
  relations:
    roleRelations:
    - roleName: "test_srvc_admin"
      foreignApplications: 
      - "serviceA_client"  
```

Here is a full example, for a fictitious app, of a document defining: a set of roles with permissions, a set of attributes, and the rules that apply to this application:

```
---
project:
  name: "ServiceTest"
  appDescription: "This is a service test"
  platform: "Web"
  category: "Sistemas"
  link: example.app.inditex.com
authzInfo:
  roles:
  - roleName: "test_srvc_admin"
    permissions:
    - "p11"
    - "p12"
    - "p13"
  - roleName: "test_srvc_viewer"
    permissions:
    - "p13"
  attributes:
  - attributeName: "test_srvc_i18n"
  relations:
    roleRelations:
    - roleName: "test_srvc_admin"
      foreignRoles:
      - foreignApplication: "SPATEST"
        foreignRoleName: "test_spa_admin"
      foreignApplications: 
      - "serviceA_client"  
    - roleName: "test_srvc_viewer"
      foreignRoles:
      - foreignApplication: "SPATEST"
        foreignRoleName: "test_spa_viewer"     
    attributeRelations:
    - attributeName: "test_srvc_i18n"
      foreignAttributes:
      - foreignApplication: "SPATEST"
        foreignAttributeName: "test_spa_i18n"
      foreignApplications: 
      - foreignApplication: "serviceA_client"
        values:
        - "za"            
```