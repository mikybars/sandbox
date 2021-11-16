package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AlgoritmoRepositoryCustom {

  public List<Integer> customFindAlgoritmosIdsByTarea(@NotNull @Positive final Long idTarea);

  Boolean checkDuplicatedActives();

}
