package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaCalculoAlgoritmoGlobalTiendaRepositoryCustomImpl implements TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTarea']}")
    private String sqlCalcularWhereIdTarea;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.WhereIdTarea']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular.AndIdTareaAndIdEmpleado']}")
    private String sqlCalcularWhereIdTareaAndIdEmpleado;

    @Override
    public void calcularByIdTarea(final Long idTarea, final AlgoritmoDto algoritmo) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
        namedParameterJdbcTemplate.update(sqlCalcularWhereIdTarea, arg);
    }

    @Override
    public void calcularByIdTareaAndIdsEmpleado(final Long idTarea, final AlgoritmoDto algoritmo, final List<String> idsEmpleados) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        idsEmpleados.forEach(idEmpleado -> {
            MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_EMPLEADO, idEmpleado);
            batchArgs.add(arg);
        });
        namedParameterJdbcTemplate.batchUpdate(sqlCalcularWhereIdTareaAndIdEmpleado,
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }

}
