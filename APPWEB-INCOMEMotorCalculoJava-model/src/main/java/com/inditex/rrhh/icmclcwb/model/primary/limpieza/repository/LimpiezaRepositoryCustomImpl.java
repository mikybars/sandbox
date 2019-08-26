package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

@Repository
public class LimpiezaRepositoryCustomImpl implements LimpiezaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['LimpiezaRepositoryCustom.limpieza.tarea']}")
    private String sqlLimpiezaTarea;


    @Override
    public void limpieza(@NotNull @Valid final TareaDto tarea) {
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
    public void consolidar(@NotNull @Valid final TareaDto tarea) {
        // TODO Una vez se borre todo correctamente, se registra que la tarea ya ha sido limpiada
    }

}
