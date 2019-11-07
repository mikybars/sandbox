# Changelog changelog-primary-ddl.md

## [v1][2019-08-29]

### Added

### Changed

- [DAVIDTSO] PK de PERIODO_CALCULO_PERSONA añadir ordinal empleado

### Removed

## [v2][2019-09-09]

### Changed

- [DAVIDTSO] TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO Nomenclatura campos

> ICM_ID_WLOC_DESTINO → STD_ID_WORK_LOCAT_DESTINO (META4: STD_WORK_LOCATION.STD_ID_WORK_LOCAT)

- [DAVIDTSO] TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO Nomenclatura campos

> ICM_ID_PUESTO_DESTINO → CCL_ID_PUESTO_DESTINO (STD_JOB.STD_ID_JOB_CODE)

## [v3][2019-09-18]

### Added

- [JAVIEREV] Tabla ESTADO_TRABAJO

### Changed

- [JAVIEREV] Columna PESO en la tabla ESTADO_TAREA_PERSONA
```sql
ALTER TABLE ESTADO_TAREA_PERSONA ADD COLUMN PESO INTEGER;
```
- [JAVIEREV] Columna PESO en la tabla ESTADO_TAREA
```sql
ALTER TABLE ESTADO_TAREA ADD COLUMN PESO INTEGER;
```
- [JAVIEREV] Join con la tabla ESTADO_TRABAJO en la tabla TRABAJO

### Removed
