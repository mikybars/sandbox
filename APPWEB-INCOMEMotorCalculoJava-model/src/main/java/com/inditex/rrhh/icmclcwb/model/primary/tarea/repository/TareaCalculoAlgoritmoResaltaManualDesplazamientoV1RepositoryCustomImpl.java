package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import lombok.Getter;

public class TareaCalculoAlgoritmoResaltaManualDesplazamientoV1RepositoryCustomImpl
        extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
        implements TareaCalculoAlgoritmoResaltaManualDesplazamientoV1RepositoryCustom {

    // TODO [javierev] Consultas algoritmo resalta manual desplazamiento

    @Getter
    private String sqlCalcular;

    @Getter
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public List<IdPersonaLocalDto> ids(final AlgoritmoDto algoritmo, final TareaDto tarea) {
        return this.tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    protected Map<String, Object> getMapValues(
            final AlgoritmoDto algoritmo, final TareaDto tarea, final IdPersonaLocalDto persona) {
        final Map<String, Object> map = new HashMap<>();
        // TODO [javierev] Map values resalta manual desplazamiento

        return map;
    }

}
