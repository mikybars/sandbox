package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;

@Repository
public class TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeV1RepositoryCustomImpl
        implements TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeV1RepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;
    
    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    public void calcular(AlgoritmoDto algoritmo, TareaDto tarea, List<TareaCalculoPersonaDto> personas) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        // TODO Auto-generated method stub
        return null;
    }

}
