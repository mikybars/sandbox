package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface AlgoritmoRepositoryCustom {

  List<Integer> customFindAlgoritmosIdsByTarea(@NotNull @Positive final Long idTarea);

  Boolean checkDuplicatedActives();

}
