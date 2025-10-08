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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl
    extends AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom
    implements TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom {

  /**
   * Constructor que inyecta las dependencias necesarias para el funcionamiento del repositorio.
   *
   * @param tareaCalculoPersonaService servicio para operaciones con personas
   * @param tipoDatoService servicio para operaciones con tipos de dato
   */
  public TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustomImpl(
      TareaCalculoPersonaService tareaCalculoPersonaService,
      TipoDatoService tipoDatoService) {
    super(tareaCalculoPersonaService, tipoDatoService);
  }

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery["
      + "'TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['"
      + "TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  /**
   * Implementación específica para desplazamiento base: Agrega el parámetro específico de indicador de desplazamiento base. El resto de
   * lógica está en la clase padre.
   */
  @Override
  protected void addSpecificMapValues(Map<String, Object> map, AlgoritmoDTO algoritmo, TareaDto tarea, IdPersonaLocalDto persona) {
    map.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_INDICADOR_DESPLAZAMIENTO_BASE,
        TipoDatoEnum.INDICADOR_LOCALIZACION_PERSONA_TIPOHORA_DESPLAZAMIENTO_BASE.getId());
  }
}
