package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

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
public class ProcesoCalculoAlgoritmoGlobalTiendaRepositoryImpl implements ProcesoCalculoAlgoritmoGlobalTiendaRepository {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{calculoPrimaryQuery['ProcesoCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdProceso']}")
    private String sqlCalcularWhereIdProceso;

    @Value("#{calculoPrimaryQuery['ProcesoCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdProceso']} #{calculoPrimaryQuery['ProcesoCalculoAlgoritmoGlobalTiendaRepository.calcular.AndIdProcesoAndIdEmpleado']}")
    private String sqlCalcularWhereIdProcesoAndIdEmpleado;

    @Override
    public void calcularByIdProceso(final Long idProceso) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO, idProceso);
        namedParameterJdbcTemplate.update(sqlCalcularWhereIdProceso, arg);
    }

    @Override
    public void calcularByIdProcesoAndIdsEmpleado(final Long idProceso, final List<String> idsEmpleados) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        idsEmpleados.forEach(idEmpleado -> {
            MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO, idProceso);
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_EMPLEADO, idEmpleado);
            batchArgs.add(arg);
        });
        namedParameterJdbcTemplate.batchUpdate(sqlCalcularWhereIdProcesoAndIdEmpleado,
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }

}
