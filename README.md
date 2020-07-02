## [APPWEB-INCOMEMotorCalculoJava](https://axinic.central.inditex.grp/jira/browse/ICMCLCWB)

## Introducción

Permite calcular y enviar a pagos, la comisión por ciclo de pago de todo el personal de tienda de todas las cadenas y países en base a un modelo de reglas por agrupaciones y niveles jerárquicos (país, cadena, puestos, tienda…), de modo que se facilite la visión y el mantenimiento del comisionado.

### Documentación adicional

- [Confluence](https://axinic.central.inditex.grp/confluence/pages/viewpage.action?pageId=358252696)

### Proyectos relacionados
- [APPPRD-Income](https://axinic.central.inditex.grp/jira/browse/ICMPRD)
- [APPWEB-Income](https://axinic.central.inditex.grp/jira/browse/ICMWEB)
- [APPWSC-INCOME](https://axinic.central.inditex.grp/jira/browse/ICMWBSRV)
- [APPWSC-INCOMEMotorCalculo](https://axinic.central.inditex.grp/jira/browse/ICMCLCWS)

## Quickstart

### Dependencias

- [com.fasterxml.jackson](https://github.com/FasterXML/jackson)
- [org.projectlombok](https://projectlombok.org/)
- [org.apache.cxf](http://cxf.apache.org/)
- [com.github.chrisvest.stormpot](https://github.com/chrisvest/stormpot)
- [org.codehaus.mojo.jaxws-maven-plugin](https://www.mojohaus.org/jaxws-maven-plugin/)
- [org.jvnet.jaxb2_commons.jaxb2-basics](https://github.com/highsource/jaxb2-basics)
- [org.codehaus.mojo.wagon-maven-plugin](https://www.mojohaus.org/wagon-maven-plugin/)

### Instalación

> -Dspring.profiles.active=default,standalone,dev clean install

### Ejecución

> -Dspring.profiles.active=default,standalone clean spring-boot:run -Dspring-boot.run.fork=false

### API Quickstart

- /programacion/run/

## Tecnología

- Java 11
- Servicio Web (API REST)
- Openshift Intranet


## Diseño Técnico

### Diagrama de Arquitectura

En este apartado se incluirá un diagrama de arquitectura de alto nivel que refleje la relación entre los artefactos del proyecto y otros sistemas relacionados. (por ejemplo Bases de Datos, Servicios, Colas, etc.)

### Estructura del proyecto

En este apartado se incluirá la relación de modulos del proyecto y la descricpión de su contenido.

### Integración con otros Sistemas

En este apartado se describirá cómo accede la aplicación a otros sistemas . Debe recogerse la integración con cualquier sistema tanto interno como externo.

