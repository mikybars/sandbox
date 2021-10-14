/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoAjusteComision;

/**
 * @author javierev
 */
@Repository
public class TareaCalculoAjusteComisionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoAjusteComision>
        implements TareaCalculoAjusteComisionRepositoryCustom {

    // TODO [javierev] crear la consulta normalizar ajuste comision
    // @Value("#{primaryQuery['TareaCalculoAjusteComisionRepositoryCustom.normalizarAjusteComision']}")
    private String sqlNormalizarAjusteComision;

    @Override
    public void normalizarAjusteComision(@NotNull final TareaDto runTarea) {

        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTarea.getId());
        this.update(this.sqlNormalizarAjusteComision, params);

    }

}
