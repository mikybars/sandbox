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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaCalculoAlgoritmoGlobalTiendaRepositoryCustomImpl
        implements TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoGlobalTiendaRepository.calcular']}")
    private String sqlCalcular;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        // TODO Hay que cambiarlo para obtener las personas relacionadas con el
        // algoritmo
        return tareaCalculoPersonaService.findByTarea(tarea);
    }

    @Override
    public void calcular(AlgoritmoDto algoritmo, TareaDto tarea, List<TareaCalculoPersonaDto> persona) {
        List<MapSqlParameterSource> batchArgs = new ArrayList<>();
        persona.forEach(idPersona -> {
            MapSqlParameterSource arg = new MapSqlParameterSource();
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PERSONA, idPersona.getIdPersona());
            arg.addValue(SqlPrimaryConstants.SQL_PARAM_OR_PERSONA, idPersona.getOrPersona());
            batchArgs.add(arg);
        });
        namedParameterJdbcTemplate.batchUpdate(sqlCalcular,
                batchArgs.toArray(new MapSqlParameterSource[batchArgs.size()]));
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        return sqlCalcular;
    }

}
