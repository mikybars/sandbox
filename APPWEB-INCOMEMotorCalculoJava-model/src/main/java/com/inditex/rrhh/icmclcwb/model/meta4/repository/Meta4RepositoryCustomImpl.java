package com.inditex.rrhh.icmclcwb.model.meta4.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlMeta4Constants;

@Repository
public class Meta4RepositoryCustomImpl
        extends JdbcBatchMeta4RepositoryAbstract<Integer>
        implements Meta4RepositoryCustom {

    @Value("#{ptrPrimaryQuery['Meta4RepositoryCustom.findMotivosDesplazamientoAux']}")
    private String sqlFindMotivosDesplazamientoAux;

    @Value("#{ptrPrimaryQuery['Meta4RepositoryCustom.findMotivosDesplazamientoGlobal']}")
    private String sqlFindMotivosDesplazamientoGlobal;

    @Override
    public List<MotivoDesplazamientoDto> findMotivosDesplazamientoAux(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlMeta4Constants.SQL_PARAM_ID_ORGANIZATION,
                tarea.getIdOrganization());

        return this.query(this.sqlFindMotivosDesplazamientoAux, map,
                (rs, rowNum) -> MotivoDesplazamientoDto
                    .builder()
                    .motivo(rs.getInt(SqlMeta4Constants.SQL_RESULT_MOTIVO_AUX))

                    .build());
    }

    @Override
    public List<MotivoDesplazamientoDto> findMotivosDesplazamientoGlobal(final TareaDto tarea) {
        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlMeta4Constants.SQL_PARAM_ID_ORGANIZATION,
                tarea.getIdOrganization());

        return this.query(this.sqlFindMotivosDesplazamientoAux, map,
                (rs, rowNum) -> MotivoDesplazamientoDto
                    .builder()
                    .motivo(rs.getInt(SqlMeta4Constants.SQL_RESULT_MOTIVO_GLOBAL))

                    .build());
    }

}
