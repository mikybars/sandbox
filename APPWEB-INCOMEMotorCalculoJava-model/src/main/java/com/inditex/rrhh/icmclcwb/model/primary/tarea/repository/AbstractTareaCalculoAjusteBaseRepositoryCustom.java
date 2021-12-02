package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.SqlParamsUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractTareaCalculoAjusteBaseRepositoryCustom
        implements TareaCalculoAjusteBaseRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected abstract String getSqlAjustar();

    protected abstract String getSqlAjustarBase();

    protected abstract Map<String, Object> getMapValues(AlgoritmoAjusteDto algoritmoAjuste, TareaDto tarea,
            IdPersonaLocalDto persona);

    @Override
    public void ajustar(final AlgoritmoAjusteDto algoritmoAjuste) {
        if (this.getSqlAjustar() != null) {
            final MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO_AJUSTE, algoritmoAjuste.getId());
            params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
            this.namedParameterJdbcTemplate.update(this.getSqlAjustar(), params);
        }
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
