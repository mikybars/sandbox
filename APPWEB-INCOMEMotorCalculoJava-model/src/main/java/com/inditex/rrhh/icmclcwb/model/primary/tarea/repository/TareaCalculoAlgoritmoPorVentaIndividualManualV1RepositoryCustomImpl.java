package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TareaCalculoAlgoritmoPorVentaIndividualManualV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoPorVentaIndividualManualV1RepositoryCustom {

    //TODO [Comun] Substituir las consultas de las anotaciones @Value

    //    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualManualV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualManualV1Repository.calcular']}")
    @Getter
    private String sqlCalcular;

    //    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualManualV1Repository.calcular']} #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
    @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualManualV1Repository.calcular']}")
    @Getter
    private String sqlCalcularBase;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    protected Map<String, Object> getMapValues(AlgoritmoDto algoritmo, TareaDto tarea, TareaCalculoPersonaDto persona) {
        //TODO [COMUN] Definir los parametros de la consulta para el cálculo PorVentaIndividualManual
        return new HashMap<>();
    }

    @Override
    public List<TareaCalculoPersonaDto> ids(AlgoritmoDto algoritmo, TareaDto tarea) {
        return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
    }
}
