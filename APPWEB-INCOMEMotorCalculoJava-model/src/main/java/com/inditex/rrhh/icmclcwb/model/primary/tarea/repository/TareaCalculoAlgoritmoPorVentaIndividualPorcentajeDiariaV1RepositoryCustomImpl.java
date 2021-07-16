package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import lombok.Getter;

@Repository
public class TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1RepositoryCustomImpl
        extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
        implements TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1RepositoryCustom {

    // TODO [COMUN] Substituir las consultas de las anotaciones @Value

    // @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']}
    // #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1Repository.calcular']}
    // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1Repository.calcular']}")
    @Getter
    private String sqlCalcular;

    // @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1Repository.calcular']}
    // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaV1Repository.calcular']}")
    @Getter
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
        // TODO [COMUN] Definir los parametros de la consulta para el cálculo
        // PorVentaIndividualPorcentajeDiaria
        return new HashMap<>();
    }

    @Override
    public List<IdPersonaLocalDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }

}
