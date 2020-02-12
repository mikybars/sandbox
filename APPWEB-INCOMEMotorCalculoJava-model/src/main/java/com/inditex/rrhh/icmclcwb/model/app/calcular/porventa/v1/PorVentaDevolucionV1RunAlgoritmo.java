package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AbstractTareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeV1RepositoryCustom;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PorVentaDevolucionV1RunAlgoritmo
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeV1RepositoryCustom {

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeV1Repository.calcular']}")
    @Getter
    private String sqlCalcular;

    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeV1Repository.calcular']}")
    @Getter
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, TareaCalculoPersonaDto persona) {
        return null;
    }

    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }
}
