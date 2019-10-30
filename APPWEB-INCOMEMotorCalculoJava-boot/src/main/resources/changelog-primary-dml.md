# Changelog changelog-primary-dml.md

## [v3][2019-09-09]

### Added

- [JAVIEREV] Añadidos nuevos tipos de datos para las ventas trasladadas, separadas por tipo de venta online.
- [JAVIEREV] Añadidos los tipos de datos anteriores en el grupo correspondiente para ser usada por los 
algoritmos de cálculo.

### Changed

### Removed


## [v4][2019-10-08]

### Added

-[MARCELORF] Añadidos datos actualizados en la tabla que relaciona los algoritmos con los tipos de dato

### Changed

### Removed

-[MARCELORF] Eliminados datos de la tabla que relaciona los algoritmos con los tipos de dato

## [v5][2019-09-18]

### Added

- [JAVIEREV] Estados trabajo
```sql
INSERT INTO ESTADO_TRABAJO (ID_ESTADO_TRABAJO, NOMBRE, PESO, ID_ESTADO_TAREA) VALUES (1, 'PENDIENTE', 100, 1);
INSERT INTO ESTADO_TRABAJO (ID_ESTADO_TRABAJO, NOMBRE, PESO, ID_ESTADO_TAREA) VALUES (2, 'EN CURSO', 200, 1);
INSERT INTO ESTADO_TRABAJO (ID_ESTADO_TRABAJO, NOMBRE, PESO, ID_ESTADO_TAREA) VALUES (3, 'OK', 400, 5);
INSERT INTO ESTADO_TRABAJO (ID_ESTADO_TRABAJO, NOMBRE, PESO, ID_ESTADO_TAREA) VALUES (4, 'KO', 300, 5);
```

### Changed

- [JAVIEREV] Peso en ESTADO_TAREA
```sql
UPDATE ESTADO_TAREA SET PESO = 100 WHERE ID_ESTADO_TAREA = 1;
UPDATE ESTADO_TAREA SET PESO = 200 WHERE ID_ESTADO_TAREA = 2;
UPDATE ESTADO_TAREA SET PESO = 500 WHERE ID_ESTADO_TAREA = 3;
UPDATE ESTADO_TAREA SET PESO = 400 WHERE ID_ESTADO_TAREA = 4;
UPDATE ESTADO_TAREA SET PESO = 300 WHERE ID_ESTADO_TAREA = 5;
```

- [JAVIEREV] Peso en ESTADO_TAREA_PERSONA
```sql
UPDATE ESTADO_TAREA_PERSONA SET PESO = 100 WHERE ID_ESTADO_TAREA_PERSONA = 1;
UPDATE ESTADO_TAREA_PERSONA SET PESO = 300 WHERE ID_ESTADO_TAREA_PERSONA = 2;
UPDATE ESTADO_TAREA_PERSONA SET PESO = 200 WHERE ID_ESTADO_TAREA_PERSONA = 3;
```

### Removed
