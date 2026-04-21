package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersonaPrecioHora;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoPersonaPrecioHoraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoPersonaPrecioHora>
    implements TareaCalculoPersonaPrecioHoraRepositoryCustom {

    @Value("#{primaryQuery['TareaCalculoPersonaPrecioHoraRepositoryCustom.insertPrecioHora']}")
    private String sqlInsertPrecioHora;

    @Value("#{primaryQuery['TareaCalculoPersonaPrecioHoraRepositoryCustom.getIds']}")
    private String sqlIds;

    @Override
    public List<IdPersonaLocalDto> ids(final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return this.query(this.sqlIds, parameters, (rs, rowNum) -> {
            final IdPersonaLocalDto dto = new IdPersonaLocalDto();
            dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
            return dto;
        });
    }

    @Override
    public CompletableFuture<Void> insertPrecioHora(final Long idTarea, final Long icmIdPeriodo, final List<String> cclIdPersonList) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO, icmIdPeriodo);

        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, cclIdPersonList);

        this.query(this.sqlInsertPrecioHora, parameters, null);

        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
