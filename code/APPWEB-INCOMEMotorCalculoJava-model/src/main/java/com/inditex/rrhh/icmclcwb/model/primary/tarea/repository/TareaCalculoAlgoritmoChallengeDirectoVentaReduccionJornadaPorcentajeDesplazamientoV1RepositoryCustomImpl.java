package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustomImpl
    extends AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom
    implements TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1Repository.calcular']}"
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  /**
   * Constructor que inyecta las dependencias necesarias para el funcionamiento del repositorio.
   *
   * @param tareaCalculoPersonaService servicio para operaciones con personas
   * @param tipoDatoService servicio para operaciones con tipos de dato
   */
  @Autowired
  public TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustomImpl(
      TareaCalculoPersonaService tareaCalculoPersonaService,
      TipoDatoService tipoDatoService) {
    super(tareaCalculoPersonaService, tipoDatoService);
  }

  /**
   * Implementación específica para desplazamiento base: Agrega el parámetro específico de indicador de desplazamiento. El resto de lógica
   * está en la clase padre.
   */
  @Override
  protected void addSpecificMapValues(Map<String, Object> map, AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_PRESENCIA_DESPLAZAMIENTO,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO.getId());
  }
}
