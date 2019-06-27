package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractTareaCalculoAlgoritmoBaseRepositoryCustom implements TareaCalculoAlgoritmoBaseRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected abstract String getSqlCalcular();

    protected abstract String getSqlCalcularBase();

    protected abstract Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, TareaCalculoPersonaDto persona);

    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo) {
        return getMapValues(algoritmo, null, null);
    }

    @Override
    public void calcular(AlgoritmoDto algoritmo, TareaDto tarea, List<TareaCalculoPersonaDto> personas) {
        if (getSqlCalcular() != null) {
            List<MapSqlParameterSource> batchArgs = new ArrayList<>();
            personas.forEach(persona -> {
                Map<String, Object> values = getMapValues(algoritmo, tarea, persona);
                MapSqlParameterSource arg = new MapSqlParameterSource();
                values.forEach((paramName, value) ->
                    arg.addValue(paramName, value));
                batchArgs.add(arg);
            });
            namedParameterJdbcTemplate.batchUpdate(getSqlCalcular(),
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
        }
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        String sql = getSqlCalcularBase();
        if (sql != null) {
            sql = SqlParamsUtils.replaceValues(sql, getMapValues(algoritmo));
        }
        return StringUtils.normalizeSpace(sql);
    }
}
