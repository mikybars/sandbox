package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Getter
@Repository
public class TareaCalculoAlgoritmoChallengeJornadaV1RepositoryCustomImpl extends TareaCalculoAlgoritmoChallengeJornadaV1RepositoryCommon
    implements TareaCalculoAlgoritmoChallengeJornadaV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeJornadaV1RepositoryCustom.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.whereTareaChallenge']}")
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengeJornadaV1RepositoryCustom.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.whereTareaChallenge']}")
  private String sqlCalcularBase;

}
