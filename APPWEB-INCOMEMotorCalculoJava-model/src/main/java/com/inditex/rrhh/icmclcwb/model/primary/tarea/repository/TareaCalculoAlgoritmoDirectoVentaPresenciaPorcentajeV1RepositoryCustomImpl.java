package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeV1RepositoryCustomImpl
        extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
        implements TareaCalculoAlgoritmoDirectoVentaPresenciaPorcentajeV1RepositoryCustom {

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    //TODO sustituir estos getters por las consultas SQL correspondientes con @Autowired y @Getter
    @Override
    protected String getSqlCalcular() {
        return null;
    }

    @Override
    protected String getSqlCalcularBase() {
        return null;
    }

    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, TareaCalculoPersonaDto persona) {
        //TODO rellenar los parametros de las consultas SQL
        Map<String, Object> map = new HashMap<>();
        return map;
    }
}
