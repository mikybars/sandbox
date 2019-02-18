package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
public class TareaCalculoAlgoritmoGlobalTiendaRepositoryImpl implements TareaCalculoAlgoritmoGlobalTiendaRepository {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTarea']}")
    private String sqlCalcularWhereIdTarea;

    @Value("#{primaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTarea']} #{primaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.AndIdTareaAndIdEmpleado']}")
    private String sqlCalcularWhereIdTareaAndIdEmpleado;

    @Override
    public void calcularByIdTarea(final Long idTarea) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        namedParameterJdbcTemplate.update(sqlCalcularWhereIdTarea, arg);
    }

    @Override
    public void calcularByIdTareaAndIdsEmpleado(final Long idTarea, final List<String> idsEmpleados) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        idsEmpleados.forEach(idEmpleado -> {
            MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_EMPLEADO, idEmpleado);
            batchArgs.add(arg);
        });
        namedParameterJdbcTemplate.batchUpdate(sqlCalcularWhereIdTareaAndIdEmpleado,
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }

}
