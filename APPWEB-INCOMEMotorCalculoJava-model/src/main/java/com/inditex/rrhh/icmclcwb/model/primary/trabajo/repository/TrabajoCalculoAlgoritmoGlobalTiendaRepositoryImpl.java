package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TrabajoCalculoAlgoritmoGlobalTiendaRepositoryImpl implements TrabajoCalculoAlgoritmoGlobalTiendaRepository {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TrabajoCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTrabajo']}")
    private String sqlCalcularWhereIdTrabajo;

    @Value("#{primaryQuery['TrabajoCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTrabajo']} #{primaryQuery['TrabajoCalculoAlgoritmoGlobalTiendaRepository.calcular.AndIdTrabajoAndIdEmpleado']}")
    private String sqlCalcularWhereIdTrabajoAndIdEmpleado;

    @Override
    public void calcularByIdTrabajo(final Long idTrabajo) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, idTrabajo);
        namedParameterJdbcTemplate.update(sqlCalcularWhereIdTrabajo, arg);
    }

    @Override
    public void calcularByIdTrabajoAndIdsEmpleado(final Long idTrabajo, final List<String> idsEmpleados) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        idsEmpleados.forEach(idEmpleado -> {
            MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, idTrabajo);
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_EMPLEADO, idEmpleado);
            batchArgs.add(arg);
        });
        namedParameterJdbcTemplate.batchUpdate(sqlCalcularWhereIdTrabajoAndIdEmpleado,
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }

}
