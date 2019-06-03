package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaSeccionCalculoAlgoritmoGlobalTiendaPorcentajeV1RepositoryCustomImpl implements TareaSeccionCalculoAlgoritmoGlobalTiendaPorcentajeV1RepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{calculoPrimaryQuery['TareaSeccionCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaSeccionCalculoAlgoritmoGlobalTiendaPorcentajeV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaSeccionCalculoAlgoritmoGlobalTiendaPorcentajeV1Repository.calcular']} #{calculoPrimaryQuery['TareaSeccionCalculoAlgoritmoBaseRepository.calcular.where']}")
    private String sqlCalcularBase;

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
        return StringUtils.normalizeSpace(sqlCalcularBase);
    }
}
