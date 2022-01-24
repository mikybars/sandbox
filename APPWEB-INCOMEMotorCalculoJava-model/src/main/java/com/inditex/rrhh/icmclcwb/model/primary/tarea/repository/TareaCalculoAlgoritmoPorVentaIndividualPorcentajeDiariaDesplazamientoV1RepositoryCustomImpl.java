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
public class TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1RepositoryCustom {

  // TODO [COMUN] Substituir las consultas de las anotaciones @Value

  // @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1Repository.calcular']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDesplazamientoBaseRepository.calcular.where']}")
  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1Repository.calcular']}")
  @Getter
  private String sqlCalcular;

  // @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1Repository.calcular']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1Repository.calcular.where']}
  // #{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseDesplazamientoBaseRepository.calcular.where']}")
  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoPorVentaIndividualPorcentajeDiariaDesplazamientoV1Repository.calcular']}")
  @Getter
  private String sqlCalcularBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  protected Map<String, Object> getMapValues(AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    // TODO [COMUN] Definir los parametros de la consulta para el cálculo
    // PorVentaIndividualPorcentajeDiariaDesplazamiento
    return new HashMap<>();
  }

  @Override
  public List<IdPersonaLocalDto> ids(AlgoritmoDTO algoritmo, TareaDto tarea) {
    return tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
  }

}
