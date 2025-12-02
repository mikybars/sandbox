// CREACION NUEVA VALIDACION AGRUPADA NO BLOQUEANTE
// Esta validación ejecuta en paralelo validarCalculoPendienteV1, validarImporteExcedidoV1 y validarPorcentaje0V1
// y envía un único correo consolidado sin detener el flujo de cálculo

INSERT INTO ACCION (ID_ACCION, NOMBRE, DESCRIPCION, REACCION_PESO, ES_REACCION_ESPERAR, ES_REACCION_REINTENTO, REACCION_REINTENTO_MAX, REACCION_REINTENTO_DELAY) VALUES (95, 'validacionesAgrupadasV1', 'Validacion fake Execute grouped non-blocking validations and send consolidated email.', 100, 0, 0, 0, 0);

INSERT INTO FASE_ACCION (ID_FASE, ID_ACCION, ID_PUNTO_EJECUCION, PESO) VALUES (4, 95, 3, 100);

INSERT INTO ACCION_AMBITO (ID_ACCION, CCL_ID_ORIGEN, STD_ID_LEG_ENT, ES_ACTIVO) VALUES (95, 11, 11, 1);

