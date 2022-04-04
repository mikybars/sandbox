-- Eliminación de la relación entre algoritmo PorVentaSimplificado en todas sus variantes y tipo cálculo
DELETE FROM ALGORITMO_TIPO_CALCULO WHERE ID_ALGORITMO IN (8001,8002,8003,8006,8007,8008,8011,8012,8013);

-- Eliminación de la relación entre algoritmo PorVentaSimplificado en tdoas sus variantes y tipo comisión
DELETE FROM ALGORITMO_TIPO_COMISION WHERE ID_ALGORITMO IN (8001,8002,8003,8006,8007,8008,8011,8012,8013);

-- Eliminación de la relación entre algoritmo PorVentaSimplificado en todas sus variantes y tipo dato
DELETE FROM ALGORITMO_TIPO_DATO WHERE ID_ALGORITMO IN (8001,8002,8003,8006,8007,8008,8011,8012,8013);

-- Eliminación del propio algoritmo PorVentaSimplificado en todas sus variantes
DELETE FROM ALGORITMO WHERE ID_ALGORITMO IN (8001,8002,8003,8006,8007,8008,8011,8012,8013);

-- Tipos de dato relacionados con PorVentaSimplificado
DELETE FROM TIPO_DATO WHERE ID_TIPO_DATO IN (3032, 5013);
