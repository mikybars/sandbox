package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class TareaAgrupacionPresenciaRepositoryCustomImpl
        implements TareaAgrupacionPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaAgrupacionPresenciaRepositoryCustom.totalizar']}")
    private String sqlTotalizar;

    @Override
    public void calcularPresenciasTotalesAgrupacion(TareaDto tarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        // FILTROS
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
                Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
                TipoDatoEnum.PRESENCIA_LOCALIZACION_SECCION_INCLUIDOECOMMERCE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
                SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);

        // VALORES ESTABLECIDOS
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
                TipoDatoEnum.PRESENCIA_AGRUPACIONONLINE_INCLUIDOECOMMERCE.getId());

        namedParameterJdbcTemplate.update(sqlTotalizar, parameters);
    }

}
