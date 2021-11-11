package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractTareaCalculoAjusteBaseRepositoryCustom
        implements TareaCalculoAjusteBaseRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected abstract String getSqlAjustar();

    protected abstract String getSqlAjustarBase();

    protected Map<String, Object> getMapValues(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
            final IdPersonaLocalDto persona) {
        // Aquí se establecen los parámetros básicos (id tarea, persona, id algoritmo ajuste, inactivo)
        // si alguna implementación necesita más parámetros deben sobreescribir el método usando
        // super.getMapValues(...)
        final Map<String, Object> map = new HashMap<>();
        if (tarea != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        }
        if (persona != null) {
            map.put(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, persona.getIdPersonaLocal());
            map.put(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, persona.getStdOrHrPeriod());
        }
        map.put(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
        map.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

        return map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public final CompletableFuture<Void> ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {
        if (this.getSqlAjustar() != null) {
            final List<MapSqlParameterSource> batchArgs = new ArrayList<>();
            personas.forEach(persona -> {
                final MapSqlParameterSource arg = new MapSqlParameterSource();
                arg.addValues(this.getMapValues(algoritmoAjuste, tarea, persona));
                batchArgs.add(arg);
            });
            this.namedParameterJdbcTemplate.batchUpdate(this.getSqlAjustar(),
                    batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
        }
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public String getSqlAjustar(final AlgoritmoAjusteDto algoritmoAjuste) {
        String sql = this.getSqlAjustarBase();
        if (sql != null) {
            sql = SqlParamsUtils.replaceValues(sql, this.getMapValues(algoritmoAjuste, null, null));
        }
        return StringUtils.normalizeSpace(sql);
    }

}
