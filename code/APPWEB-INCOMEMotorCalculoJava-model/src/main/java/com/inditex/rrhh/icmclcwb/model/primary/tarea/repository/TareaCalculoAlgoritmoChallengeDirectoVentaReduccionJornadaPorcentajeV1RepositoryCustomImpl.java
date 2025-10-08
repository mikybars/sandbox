package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustomImpl
    extends AbstractTareaCalculoChallengeDirectoVentaReduccionJornadaPorcentajeRepositoryCustom
    implements TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1Repository.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  /**
   * Constructor que inyecta las dependencias necesarias para el funcionamiento del repositorio.
   *
   * @param tareaCalculoPersonaService servicio para operaciones con personas
   * @param tipoDatoService servicio para operaciones con tipos de dato
   */
  public TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustomImpl(
      TareaCalculoPersonaService tareaCalculoPersonaService,
      TipoDatoService tipoDatoService) {
    super(tareaCalculoPersonaService, tipoDatoService);
  }

  /**
   * Implementación para algoritmo base: No necesita agregar parámetros adicionales.
   */

  // No es necesario implementar addSpecificMapValues() porque la implementación por defecto de la clase base es suficiente

}
