# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [4.71.0] - 2025-01-20

### Added

- [INCOME-1367](https://jira.inditex.com/jira/browse/INCOME-1367) Optimización consulta localizaciones
- [INCOME-658](https://jira.inditex.com/jira/browse/INCOME-658) [ICMCLCWB] Incidencias Sonar
- [INCOME-1436](https://jira.inditex.com/jira/browse/INCOME-1436) Docker compose - Redis
- [INCOME-1424](https://jira.inditex.com/jira/browse/INCOME-1424) ICMCLCWB - Corrección errores afectados por la migración a JSpecify
- [INCOME-1319](https://jira.inditex.com/jira/browse/INCOME-1319) ICMCLCWB - JSpecify para anotaciones null
- [INCOME-1350](https://jira.inditex.com/jira/browse/INCOME-1350) Docker Compose
- [INCOME-1309](https://jira.inditex.com/jira/browse/INCOME-1309) GR - Empleados con importe negativo
- [INCOME-1026](https://jira.inditex.com/jira/browse/INCOME-1026) Actualizar cache a Redis

### Dependencies

- [#456](https://github.com/inditex/mic-incomemotorcalculojava/issues/456) Bump com.inditex.amigafwk:amiga-framework from 5.11.2 to 5.12.0 in /code

### Fixed

- [INCOME-1290](https://jira.inditex.com/jira/browse/INCOME-1290) Venta challenge en pantalla web

## [4.70.0] - 2024-12-19

### Added

- [INCOME-734](https://jira.inditex.com/jira/browse/INCOME-734) Aprovisionamiento y configuración PIPE
- [INCOME-300](https://jira.inditex.com/jira/browse/INCOME-300) Tests INCOMEMotorCalculoJava-model
- [INCOME-946](https://jira.inditex.com/jira/browse/INCOME-946) Challenge Jornada - Contabilizar horas de todos los empleados con posición en la tienda
- [INCOME-1199](https://jira.inditex.com/jira/browse/INCOME-1199) Modificación cadenas de conexión - ICMCLCWB - DES
- [INCOME-1024](https://jira.inditex.com/jira/browse/INCOME-1024) Migración Artemis
- [ICMWEB-1549](https://jira.inditex.com/jira/browse/ICMWEB-1549) Optimizacion de consultas
- [INCOME-1266](https://jira.inditex.com/jira/browse/INCOME-1266) Actualizacion version arquetipo
- [INCOME-1194](https://jira.inditex.com/jira/browse/INCOME-1194) Modificación consulta que envia datos vía pipe
- [INCOME-1077](https://jira.inditex.com/jira/browse/INCOME-1077) Procesado de presencias manuales/reales
- [#362](https://github.com/inditex/mic-incomemotorcalculojava/issues/362) [Darwin Bot] Update `.drafterconfig` to use `jira.inditex.com`
- [INCOME-278](https://jira.inditex.com/jira/browse/INCOME-278) Configuración de política de baja it en el motor de cálculo
- [INCOME-996](https://jira.inditex.com/jira/browse/INCOME-996) [ICMCLCWB] Refactorización validación externos
- [INCOME-782](https://jira.inditex.com/jira/browse/INCOME-782) Validación PRE Configuración de política de baja it en el motor de cálculo
- [INCOME-1034](https://jira.inditex.com/jira/browse/INCOME-1034) Validaciones PRE envío mensajes a PIPE

### Fixed

- [INCOME-979](https://jira.inditex.com/jira/browse/INCOME-979) Corrección de configuración baja it en el proceso de normalización

## [4.69.0] - 2024-11-13

### Added

- [INCOME-1130](https://axinic.central.inditex.grp/jira/browse/INCOME-1130) Modificar la recuperación de empleados externos para tener en cuenta el tipo de empleado

## [4.68.0] - 2024-10-15

### Added

- [INCOME-1019](https://axinic.central.inditex.grp/jira/browse/INCOME-1019) Revision empleado 98438

### Dependencies

- [#299](https://github.com/inditex/mic-incomemotorcalculojava/issues/299) Bump com.inditex.amigafwk:amiga-framework from 5.10.1 to 5.10.2 in /code

## [4.67.0] - 2024-10-14

### Added

- [INCOME-969](https://axinic.central.inditex.grp/jira/browse/INCOME-969) Eliminación de validación de externos en Personal para España
- [#305](https://github.com/inditex/mic-incomemotorcalculojava/issues/305) Main to develop
- [#302](https://github.com/inditex/mic-incomemotorcalculojava/issues/302) Revert "Prepare release"
- [#301](https://github.com/inditex/mic-incomemotorcalculojava/issues/301) Prepare release

## [4.66.0] - 2024-10-09

### Added

- [INCOME-993](https://axinic.central.inditex.grp/jira/browse/INCOME-993) Recuperación de tramos del siguiente periodo en validacion de bajas

### Dependencies

- [#283](https://github.com/inditex/mic-incomemotorcalculojava/issues/283) Bump com.inditex.amigafwk:amiga-framework from 5.10.0 to 5.10.1 in /code

## [4.65.0] - 2024-09-16

### Added

- [INCOME-486](https://axinic.central.inditex.grp/jira/browse/INCOME-486) [ICMCLCWB] Total de % por reducción en incidenciasSil - VALIDACION

### Dependencies

- [#260](https://github.com/inditex/mic-incomemotorcalculojava/issues/260) Bump com.inditex.amigafwk:amiga-framework from 5.6.6 to 5.10.0 in /code

## [4.64.0] - 2024-09-09

### Added

- [INCOME-484](https://axinic.central.inditex.grp/jira/browse/INCOME-484) Cálculo Álava - Datos intermedios y nuevo algoritmo

## [4.63.1] - 2024-08-14

### Fixed

- [INCOME-668](https://axinic.central.inditex.grp/jira/browse/INCOME-668) Totalizado de presencias a 0 en tienda 3040 FR

## [4.63.0] - 2024-05-28

### Added

- [#172](https://github.com/inditex/mic-incomemotorcalculojava/issues/172) Subida primera parte del codigo migracion amiga 5
- [INCOME-235](https://axinic.central.inditex.grp/jira/browse/INCOME-235) Test para artefacto del cálculo

## [4.62.2] - 2024-04-09

## [4.62.1] - 2024-03-21

## [4.62.0] - 2024-03-07

### Added

- [ICMWEB-1539](https://axinic.central.inditex.grp/jira/browse/ICMWEB-1539) Cálculo. Análisis de cambios

## [4.61.0] - 2023-11-21

### Added

- [ICMWEB-1502](https://axinic.central.inditex.grp/jira/browse/ICMWEB-1502) Cálculo. Nueva lógica para el reparto
- [#59](https://github.com/inditex/mic-incomemotorcalculojava/issues/59) [ICMPRD-934] Validacion personas sil
- [ICMWEB-1510](https://axinic.central.inditex.grp/jira/browse/ICMWEB-1510) Revisar validación de bajas
- [ICMPRD-934](https://axinic.central.inditex.grp/jira/browse/ICMPRD-934) Revisar validacion de personas con clase empleados (correo)

### Dependencies

- [#87](https://github.com/inditex/mic-incomemotorcalculojava/issues/87) chore(deps): bump com.inditex.aqsw.framework.amiga:amiga-framework from 4.15.11 to 4.15.13 in /code
- [#54](https://github.com/inditex/mic-incomemotorcalculojava/issues/54) build(deps): bump com.inditex.darwin.telemetry:darwin-telemetry-maven-extension from 2.2.0 to 2.3.0 in /code
- [#72](https://github.com/inditex/mic-incomemotorcalculojava/issues/72) build(deps): bump com.inditex.aqsw.amiga.javaformat:amiga-javaformat-maven-plugin from 2.7.0 to 2.8.0 in /code

## [4.60.0] - 2023-11-10

### Added

- [#78](https://github.com/inditex/mic-incomemotorcalculojava/issues/78) Totalizacion Fracia - Fix date

## [4.59.0] - 2023-11-06

### Added

- [#46](https://github.com/inditex/mic-incomemotorcalculojava/issues/46) Feature/exportacion francia
- [ICMCLCWB-1394](https://axinic.central.inditex.grp/jira/browse/ICMCLCWB-1394) Modificaciones cálculo
- [ICMWEB-1509](https://axinic.central.inditex.grp/jira/browse/ICMWEB-1509) Correcciones colas AMQ

## [4.58.0] - 2023-10-16

### Added

- [ICMWEB-1493](https://axinic.central.inditex.grp/jira/browse/ICMWEB-1493) Migraciones cálculo

### Refactored

- [#1](https://github.com/inditex/mic-incomemotorcalculojava/issues/1) Adapt project to GitHub reference configuration

## [4.57.0] - 2023-08-21

## [4.56.0] - 2023-07-31

## [4.55.0] - 2023-07-14

## [4.54.0] - 2023-07-11

## [4.53.0] - 2023-07-06

## [4.52.0] - 2023-07-05

## [4.51.0] - 2023-06-20

## [4.50.0] - 2023-06-19

## [4.49.0] - 2023-06-07

## [4.48.0] - 2023-05-23

## [4.47.0] - 2023-05-09

## [4.46.0] - 2023-04-27

## [4.45.0] - 2023-04-18

## [4.44.0] - 2023-04-14

## [4.43.0] - 2023-03-22

## [4.42.0] - 2023-03-10

## [4.41.0] - 2023-03-09

## [4.40.0] - 2023-02-13

## [4.39.0] - 2023-02-01

## [4.38.0] - 2023-01-13

## [4.37.0] - 2023-01-11

## [4.36.0] - 2022-12-13

## [4.35.0] - 2022-11-29

## [4.34.0] - 2022-11-15

## [4.33.0] - 2022-11-07

## [4.32.0] - 2022-10-18

## [4.31.0] - 2022-10-06

## [4.30.0] - 2022-10-05

## [4.29.0] - 2022-09-20

## [4.28.0] - 2022-09-16

## [4.27.0] - 2022-09-09

## [4.26.0] - 2022-09-05

## [4.25.0] - 2022-08-26

## [4.24.0] - 2022-08-22

## [4.23.0] - 2022-08-18

## [4.22.0] - 2022-08-16

## [4.21.0] - 2022-08-11

## [4.20.0] - 2022-08-11

## [4.19.0] - 2022-08-10

## [4.18.0] - 2022-08-08

## [4.17.0] - 2022-08-04

## [4.16.0] - 2022-08-03

## [4.15.0] - 2022-07-26

## [4.14.0] - 2022-07-11

## [4.13.0] - 2022-07-08

## [4.12.3] - 2022-07-07

## [4.12.2] - 2022-06-23

## [4.12.1] - 2022-06-22

## [4.12.0] - 2022-06-07

## [4.11.3] - 2022-06-02

## [4.11.2] - 2022-05-13

## [4.11.1] - 2022-05-06

## [4.11.0] - 2022-05-05

## [4.10.12] - 2022-03-31

## [4.10.11] - 2022-03-31

## [4.10.10] - 2022-03-23

## [4.10.9] - 2022-03-11

## [4.10.8] - 2022-03-03

## [4.10.7] - 2022-02-15

## [4.10.6] - 2022-02-10

## [4.10.5] - 2022-02-09

## [4.10.4] - 2022-01-20

## [4.10.3] - 2022-01-19

## [4.10.2] - 2021-12-21

## [4.10.1] - 2021-12-20

## [4.10.0] - 2021-12-16

## [4.9.0] - 2021-12-15

## [4.8.0] - 2021-12-09

## [4.7.0] - 2021-12-09

## [4.6.0] - 2021-11-30

## [4.5.0] - 2021-11-25

## [4.4.0] - 2021-11-18

## [4.3.0] - 2021-11-10

## [4.2.0] - 2021-11-09

## [4.1.0] - 2021-10-28

## [4.0.0] - 2021-10-21

## [3.6.0] - 2021-12-16

## [3.5.9] - 2021-12-15

## [3.5.8] - 2021-12-09

## [3.5.7] - 2021-12-09

## [3.5.6] - 2021-11-30

## [3.5.5] - 2021-11-25

## [3.5.4] - 2021-11-18

## [3.5.3] - 2021-11-10

## [3.5.2] - 2021-11-09

## [3.5.1] - 2021-10-28

## [3.5.0] - 2021-10-21

## [3.4.7] - 2021-10-08

## [3.4.6] - 2021-10-06

## [3.4.5] - 2021-10-05

## [3.4.4] - 2021-10-04

## [3.4.3] - 2021-10-04

## [3.4.2] - 2021-10-01

## [3.4.1] - 2021-10-01

## [3.4.0] - 2021-09-29

## [3.3.0] - 2021-09-27

## [3.2.5] - 2021-09-23

## [3.2.4] - 2021-09-15

## [3.2.3] - 2021-09-07

## [3.2.2] - 2021-09-06

## [3.2.1] - 2021-09-06

## [3.2.0] - 2021-09-03

## [3.1.1] - 2021-09-01

## [3.1.0] - 2021-08-27

## [3.0.4] - 2021-08-26

## [3.0.3] - 2021-08-24

## [3.0.2] - 2021-08-19

## [3.0.1] - 2021-08-18

## [3.0.0] - 2021-08-16

## [2.9.9] - 2021-08-10

## [2.9.8] - 2021-08-10

## [2.9.7] - 2021-07-22

## [2.9.6] - 2021-07-16

## [2.9.5] - 2021-07-12

## [2.9.4] - 2021-07-06

## [2.9.3] - 2021-07-05

## [2.9.2] - 2021-06-29

## [2.9.1] - 2021-06-17

## [2.9.0] - 2021-06-15

## [2.8.9] - 2021-06-14

## [2.8.8] - 2021-06-14

## [2.8.7] - 2021-06-10

## [2.8.6] - 2021-06-04

## [2.8.5] - 2021-06-03

## [2.8.4] - 2021-06-02

## [2.8.3] - 2021-05-24

## [2.8.2] - 2021-05-11

## [2.8.1] - 2021-04-27

## [2.8.0] - 2021-04-27

## [2.7.9] - 2021-04-20

## [2.7.8] - 2021-04-16

## [2.7.7] - 2021-04-15

## [2.7.6] - 2021-04-12

## [2.7.5] - 2021-04-08

## [2.7.4] - 2021-03-30

## [2.7.3] - 2021-03-26

## [2.7.2] - 2021-03-25

## [2.7.1] - 2021-03-25

## [2.7.0] - 2021-03-25

## [2.6.0] - 2021-02-10

## [2.5.1] - 2020-12-15

## [2.5.0] - 2020-11-11

## [2.4.5] - 2020-10-29

## [2.4.4] - 2020-10-26

## [2.4.3] - 2020-10-20

## [2.4.2] - 2020-10-19

## [2.4.1] - 2020-10-13

## [2.4.0] - 2020-08-12

## [2.3.3] - 2020-08-05

## [2.3.2] - 2020-07-31

## [2.3.1] - 2020-07-30

## [2.3.0] - 2020-07-27

## [2.2.1] - 2020-07-20

## [2.2.0] - 2020-07-15

## [2.1.0] - 2020-07-02

## [2.0.4] - 2020-05-11

## [2.0.3] - 2020-04-29

## [2.0.2] - 2020-04-23

## [2.0.1] - 2020-02-27

## [2.0.0] - 2020-02-20

## [1.1.3] - 2020-02-18

## [1.1.2] - 2020-02-14

## [1.1.1] - 2020-02-11

## [1.1.0] - 2020-01-14

## [1.0.6] - 2019-12-17

## [1.0.5] - 2019-12-16

## [1.0.4] - 2019-12-04

## [1.0.3] - 2019-12-02

## [1.0.2] - 2019-11-25

## [1.0.1] - 2019-11-13

## [1.0.0] - 2019-10-30

[Unreleased]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.71.0...main
[4.71.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.70.0...4.71.0
[4.70.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.69.0...4.70.0
[4.69.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.68.0...4.69.0
[4.68.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.67.0...4.68.0
[4.67.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.66.0...4.67.0
[4.66.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.65.0...4.66.0
[4.65.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.64.0...4.65.0
[4.64.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.63.1...4.64.0
[4.63.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.63.0...4.63.1
[4.63.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.62.2...4.63.0
[4.62.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.62.1...4.62.2
[4.62.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.62.0...4.62.1
[4.62.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.61.0...4.62.0
[4.61.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.60.0...4.61.0
[4.60.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.59.0...4.60.0
[4.59.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.58.0...4.59.0
[4.58.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.57.0...4.58.0
[4.57.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.56.0...4.57.0
[4.56.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.55.0...4.56.0
[4.55.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.54.0...4.55.0
[4.54.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.53.0...4.54.0
[4.53.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.52.0...4.53.0
[4.52.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.51.0...4.52.0
[4.51.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.50.0...4.51.0
[4.50.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.49.0...4.50.0
[4.49.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.48.0...4.49.0
[4.48.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.47.0...4.48.0
[4.47.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.46.0...4.47.0
[4.46.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.45.0...4.46.0
[4.45.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.44.0...4.45.0
[4.44.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.43.0...4.44.0
[4.43.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.42.0...4.43.0
[4.42.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.41.0...4.42.0
[4.41.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.40.0...4.41.0
[4.40.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.39.0...4.40.0
[4.39.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.38.0...4.39.0
[4.38.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.37.0...4.38.0
[4.37.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.36.0...4.37.0
[4.36.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.35.0...4.36.0
[4.35.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.34.0...4.35.0
[4.34.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.33.0...4.34.0
[4.33.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.32.0...4.33.0
[4.32.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.31.0...4.32.0
[4.31.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.30.0...4.31.0
[4.30.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.29.0...4.30.0
[4.29.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.28.0...4.29.0
[4.28.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.27.0...4.28.0
[4.27.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.26.0...4.27.0
[4.26.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.25.0...4.26.0
[4.25.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.24.0...4.25.0
[4.24.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.23.0...4.24.0
[4.23.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.22.0...4.23.0
[4.22.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.21.0...4.22.0
[4.21.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.20.0...4.21.0
[4.20.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.19.0...4.20.0
[4.19.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.18.0...4.19.0
[4.18.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.17.0...4.18.0
[4.17.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.16.0...4.17.0
[4.16.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.15.0...4.16.0
[4.15.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.14.0...4.15.0
[4.14.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.13.0...4.14.0
[4.13.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.12.3...4.13.0
[4.12.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.12.2...4.12.3
[4.12.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.12.1...4.12.2
[4.12.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.12.0...4.12.1
[4.12.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.11.3...4.12.0
[4.11.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.11.2...4.11.3
[4.11.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.11.1...4.11.2
[4.11.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.11.0...4.11.1
[4.11.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.12...4.11.0
[4.10.12]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.11...4.10.12
[4.10.11]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.10...4.10.11
[4.10.10]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.9...4.10.10
[4.10.9]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.8...4.10.9
[4.10.8]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.7...4.10.8
[4.10.7]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.6...4.10.7
[4.10.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.5...4.10.6
[4.10.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.4...4.10.5
[4.10.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.3...4.10.4
[4.10.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.2...4.10.3
[4.10.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.1...4.10.2
[4.10.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.10.0...4.10.1
[4.10.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.9.0...4.10.0
[4.9.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.8.0...4.9.0
[4.8.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.7.0...4.8.0
[4.7.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.6.0...4.7.0
[4.6.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.5.0...4.6.0
[4.5.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.4.0...4.5.0
[4.4.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.3.0...4.4.0
[4.3.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.2.0...4.3.0
[4.2.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.1.0...4.2.0
[4.1.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/4.0.0...4.1.0
[4.0.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.6.0...4.0.0
[3.6.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.9...3.6.0
[3.5.9]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.8...3.5.9
[3.5.8]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.7...3.5.8
[3.5.7]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.6...3.5.7
[3.5.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.5...3.5.6
[3.5.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.4...3.5.5
[3.5.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.3...3.5.4
[3.5.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.2...3.5.3
[3.5.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.1...3.5.2
[3.5.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.5.0...3.5.1
[3.5.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.7...3.5.0
[3.4.7]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.6...3.4.7
[3.4.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.5...3.4.6
[3.4.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.4...3.4.5
[3.4.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.3...3.4.4
[3.4.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.2...3.4.3
[3.4.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.1...3.4.2
[3.4.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.4.0...3.4.1
[3.4.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.3.0...3.4.0
[3.3.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.2.5...3.3.0
[3.2.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.2.4...3.2.5
[3.2.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.2.3...3.2.4
[3.2.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.2.2...3.2.3
[3.2.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.2.1...3.2.2
[3.2.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.2.0...3.2.1
[3.2.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.1.1...3.2.0
[3.1.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.1.0...3.1.1
[3.1.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.0.4...3.1.0
[3.0.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.0.3...3.0.4
[3.0.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.0.2...3.0.3
[3.0.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.0.1...3.0.2
[3.0.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/3.0.0...3.0.1
[3.0.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.9...3.0.0
[2.9.9]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.8...2.9.9
[2.9.8]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.7...2.9.8
[2.9.7]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.6...2.9.7
[2.9.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.5...2.9.6
[2.9.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.4...2.9.5
[2.9.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.3...2.9.4
[2.9.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.2...2.9.3
[2.9.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.1...2.9.2
[2.9.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.9.0...2.9.1
[2.9.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.9...2.9.0
[2.8.9]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.8...2.8.9
[2.8.8]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.7...2.8.8
[2.8.7]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.6...2.8.7
[2.8.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.5...2.8.6
[2.8.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.4...2.8.5
[2.8.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.3...2.8.4
[2.8.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.2...2.8.3
[2.8.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.1...2.8.2
[2.8.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.8.0...2.8.1
[2.8.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.9...2.8.0
[2.7.9]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.8...2.7.9
[2.7.8]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.7...2.7.8
[2.7.7]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.6...2.7.7
[2.7.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.5...2.7.6
[2.7.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.4...2.7.5
[2.7.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.3...2.7.4
[2.7.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.2...2.7.3
[2.7.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.1...2.7.2
[2.7.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.7.0...2.7.1
[2.7.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.6.0...2.7.0
[2.6.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.5.1...2.6.0
[2.5.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.5.0...2.5.1
[2.5.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.4.5...2.5.0
[2.4.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.4.4...2.4.5
[2.4.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.4.3...2.4.4
[2.4.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.4.2...2.4.3
[2.4.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.4.1...2.4.2
[2.4.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.4.0...2.4.1
[2.4.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.3.3...2.4.0
[2.3.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.3.2...2.3.3
[2.3.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.3.1...2.3.2
[2.3.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.3.0...2.3.1
[2.3.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.2.1...2.3.0
[2.2.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.2.0...2.2.1
[2.2.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.1.0...2.2.0
[2.1.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.0.4...2.1.0
[2.0.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.0.3...2.0.4
[2.0.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.0.2...2.0.3
[2.0.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.0.1...2.0.2
[2.0.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/2.0.0...2.0.1
[2.0.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.1.3...2.0.0
[1.1.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.1.2...1.1.3
[1.1.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.1.1...1.1.2
[1.1.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.1.0...1.1.1
[1.1.0]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.6...1.1.0
[1.0.6]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.5...1.0.6
[1.0.5]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.4...1.0.5
[1.0.4]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.3...1.0.4
[1.0.3]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.2...1.0.3
[1.0.2]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.1...1.0.2
[1.0.1]: https://github.com/inditex/mic-incomemotorcalculojava/compare/1.0.0...1.0.1
[1.0.0]: https://github.com/inditex/mic-incomemotorcalculojava/commits/1.0.0
