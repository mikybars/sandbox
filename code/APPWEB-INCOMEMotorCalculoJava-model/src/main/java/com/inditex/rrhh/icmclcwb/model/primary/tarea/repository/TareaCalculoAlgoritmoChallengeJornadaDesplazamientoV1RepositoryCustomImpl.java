package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Getter
@Repository
public class TareaCalculoAlgoritmoChallengeJornadaDesplazamientoV1RepositoryCustomImpl
    extends TareaCalculoAlgoritmoChallengeJornadaV1RepositoryCommon
    implements TareaCalculoAlgoritmoChallengeJornadaDesplazamientoV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeJornadaDesplazamientoV1RepositoryCustom.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.whereSinTareaPresencia']}")
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeJornadaDesplazamientoV1RepositoryCustom.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.whereSinTareaPresencia']}")
  private String sqlCalcularBase;

}
