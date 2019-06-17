package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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

@Repository
public class TareaAgrupacionPresenciaRepositoryCustomImpl implements TareaAgrupacionPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['RunTareaProcesarService.procesarPresenciaAgrupacion']}")
    private String sqlSave;


    @Override
    public void procesarPresenciaAgrupacion(TareaDto tarea) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS_SUMA, TipoDatoEnum.MINUTOS_TOTALES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS, TipoDatoEnum.MINUTOS_TOTALES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
        namedParameterJdbcTemplate.update(sqlSave, params);
    }
}
