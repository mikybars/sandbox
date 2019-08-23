package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LimpiezaRepositoryCustomImpl implements LimpiezaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['LimpiezaRepositoryCustom.findMinId']}")
    private String sqlCustomFindMinId;

    @Value("#{primaryQuery['LimpiezaRepositoryCustom.findIds']}")
    private String sqlCheckFindIds;

    @Override
    public Long findMinId() {
        // TODO Tarea mínima que esté pendiente o en curso
/*
-- Tarea mínima que esté pendiente o en curso
SELECT MIN(T.ID_TAREA) FROM TAREA T WHERE T.ID_ESTADO_TAREA IN (1, 2) OR T.FECHA_HORA_INICIO_TAREA IS NULL OR T.FECHA_HORA_FIN_TAREA IS NULL;
-- Tarea máxima que no esté pendiente o en curso
SELECT MAX(T.ID_TAREA) FROM TAREA T WHERE T.ID_ESTADO_TAREA NOT IN (1, 2) AND T.FECHA_HORA_INICIO_TAREA IS NOT NULL AND T.FECHA_HORA_FIN_TAREA IS NOT NULL;
 */
        return NumberUtils.LONG_ZERO;
    }

    @Override
    public List<Long> findIds(@Positive @NotNull final Long id) {
        // TODO Tarea que no tenga datos consolidados
/*
-- Tarea que no tenga datos consolidados
SELECT
        T.ID_TAREA
FROM TAREA T
LEFT JOIN TAREA_CALCULO_PERSONA TCP
 ON TCP.ID_TAREA = T.ID_TAREA
-- Falta tabla donde tengamos las limpiezas ejecutadas
-- para ignorar las tareas ya borradas
WHERE TCP.ID_TAREA_CALCULO_PERSONA IS NULL
 */
        return Arrays.asList(NumberUtils.LONG_ZERO);
    }

    @Override
    public void limpieza(@Positive @NotNull final Long id) {
        // TODO Se eliminan los datos intermedios de toda la tarea
/*
-- Se eliminan los datos intermedios de toda la tarea
DELETE FROM TAREA_CALCULO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AGRUPACION_CADENA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AGRUPACION_CONFIGURACION WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AGRUPACION_PRESENCIA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AGRUPACION_VENTA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AMBITO_GLOBAL_LOCALIZACION WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AMBITO_GLOBAL_LOCALIZACION_PERSONA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AMBITO_GLOBAL_LOCALIZACION_PERSONA_DESPLAZAMIENTO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AMBITO_GLOBAL_LOCALIZACION_PERSONA_PRESENCIA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AMBITO_GLOBAL_LOCALIZACION_PERSONA_PRESENCIA_MANUAL WHERE ID_TAREA IN (4);
DELETE FROM TAREA_AMBITO_GLOBAL_PERSONA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_ABIERTA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_CALCULAR WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_COMISION_HISTORICO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_FESTIVO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_HISTORICO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_ONLINE_HISTORICO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_PERSONA_PRESENCIA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_PERSONA_VENTA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_PRESENCIA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_LOCALIZACION_VENTA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_PERSONA_COEFICIENTE WHERE ID_TAREA IN (4);
DELETE FROM TAREA_PERSONA_ESTRUCTURA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_PERSONA_ESTRUCTURA_POLITICA WHERE ID_TAREA IN (4);
DELETE FROM TAREA_PERSONA_HISTORICO WHERE ID_TAREA IN (4);
DELETE FROM TAREA_TIPO_HORA WHERE ID_TAREA IN (4);
 */
    }

    @Override
    public void consolidar(@Positive @NotNull final Long id) {
        // TODO Una vez se borre todo correctamente, se registra que la tarea ya ha sido limpiada y cuando TAREA_LIMPIEZA
    }

}
