-- Poner el DELAY adecuado para dos acciones que tienen un valor incorrecto
UPDATE ACCION SET REACCION_REINTENTO_DELAY = 180000 WHERE ID_ACCION IN (18,19);
