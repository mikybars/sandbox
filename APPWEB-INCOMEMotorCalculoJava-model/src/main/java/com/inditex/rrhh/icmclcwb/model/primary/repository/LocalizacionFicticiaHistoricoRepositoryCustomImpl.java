package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.LocalizacionFicticiaHistorico;

@Repository
public class LocalizacionFicticiaHistoricoRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<LocalizacionFicticiaHistorico>
        implements LocalizacionFicticiaHistoricoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.localizacion-ficticia-historico: 0}")
    private int batchSize;

    @Value("#{primaryQuery['LocalizacionFicticiaHistoricoRepositoryCustom.findLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha']}")
    private String sqlFindLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha;

    @Override
    public List<LocalizacionFicticiaHistorico> findLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha(
            final TareaDto tarea,
            final TareaAmbitoDto ambito) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, ambito.getCclIdOrigen());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, tarea.getStdIdLegEnt());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));

        return this.query(
                this.sqlFindLocalizacionFicticiaHistoricoByIdOrigenAndIdEmpresaAndFecha,
                parameters, new RowMapper<LocalizacionFicticiaHistorico>() {
                    @Override
                    public LocalizacionFicticiaHistorico mapRow(final ResultSet rs, final int rowNum)
                            throws SQLException {
                        final LocalizacionFicticiaHistorico dto = new LocalizacionFicticiaHistorico();
                        dto.setStdIdWorkLocat(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
                        return dto;
                    }
                });
    }

}
