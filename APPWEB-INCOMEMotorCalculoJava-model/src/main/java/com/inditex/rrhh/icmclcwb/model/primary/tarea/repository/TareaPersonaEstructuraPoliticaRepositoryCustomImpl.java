package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

@Repository
public class TareaPersonaEstructuraPoliticaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraPolitica>
        implements TareaPersonaEstructuraPoliticaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-estructura-politica:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaEstructuraPoliticaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaPersonaEstructuraPoliticaRepositoryCustom.updateImporteEstructuraPoliticas']}")
    private String sqlUpdateImporteEstructuraPoliticas;

    @Override
    public List<TareaPersonaEstructuraPolitica> save(final List<TareaPersonaEstructuraPolitica> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public void updateImporteEstructuraPoliticas(@NotNull final TareaDto tarea, @NotNull final TrabajoDto trabajoDto) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_POLITICA,
                TipoPoliticaEnum.MINIMO_GARANTIZADO.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        this.update(this.sqlUpdateImporteEstructuraPoliticas, parameters);
    }

}
