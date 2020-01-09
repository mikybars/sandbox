package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;

public abstract class AbstractTareaCalculoPostProcesarBaseRepositoryCustom
        implements TareaCalculoPostProcesarBaseRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    protected abstract String getSqlPostProcesarBase();
    
    protected abstract Map<String, Object> getMapValues(TareaDto tarea,
            TareaCalculoPersonaDto persona);

    @Override
    public void postProcesar(TareaDto tarea, List<TareaCalculoPersonaDto> personas) {
        if (getSqlPostProcesar() != null) {
            List<MapSqlParameterSource> batchArgs = new ArrayList<>();
            personas.forEach(persona -> {
                Map<String, Object> values = getMapValues(tarea, persona);
                MapSqlParameterSource arg = new MapSqlParameterSource();
                values.forEach((paramName, value) -> arg.addValue(paramName, value));
                batchArgs.add(arg);
            });
            namedParameterJdbcTemplate.batchUpdate(getSqlPostProcesar(),
                    batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
        }
    }

    @Override
    public String getSqlPostProcesar() {
        String sql = getSqlPostProcesarBase();
        if (sql != null) {
            sql = SqlParamsUtils.replaceValues(sql, getMapValues(null, null));
        }
        return StringUtils.normalizeSpace(sql);
    }

}
