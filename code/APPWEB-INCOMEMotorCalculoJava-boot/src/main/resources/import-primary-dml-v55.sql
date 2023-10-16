-- Se cambian los tipos de venta sin devolución y devolución a sección
UPDATE TIPO_DATO SET NOMBRE = 'DEVOLUCION_LOCALIZACION_SECCION', DESCRIPCION = 'Devolucion fisica y iPod [localizacion|seccion]' WHERE ID_TIPO_DATO = 3029;
UPDATE TIPO_DATO SET NOMBRE = 'VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION', DESCRIPCION = 'Venta fisica y iPod sin devolucion [localizacion|seccion]' WHERE ID_TIPO_DATO = 3034;

-- Se crea el tipo de devolución localización
INSERT INTO TIPO_DATO (ID_TIPO_DATO, ES_PROCESADO, NOMBRE, DESCRIPCION) VALUES (3047, 1, 'DEVOLUCION_LOCALIZACION', 'Devolucion fisica y iPod [localizacion]');

