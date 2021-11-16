package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom {

  // TODO [COMUN] Substituir las consultas de las anotaciones @Value

  // @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1Repository.calcular']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDesplazamientoBaseRepository.calcular.where']}")
  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']}"
      + " #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1Repository.calcular']}")
  @Getter
  private String sqlCalcular;

  // @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1Repository.calcular']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1Repository.calcular.where']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDesplazamientoBaseRepository.calcular.where']}")
  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1Repository.calcular']}")
  @Getter
  private String sqlCalcularBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  protected Map<String, Object> getMapValues(AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    // TODO [COMUN] Definir los parametros de la consulta para el cálculo
    // PorVentaIndividualPorcentajeDiariaDesplazamientoBase
    return new HashMap<>();
  }

  @Override
  public List<IdPersonaLocalDto> ids(AlgoritmoDTO algoritmo, TareaDto tarea) {
    return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
  }

}
