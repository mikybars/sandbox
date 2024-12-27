package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.List;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface AlgoritmoRepositoryCustom {

  List<Integer> customFindAlgoritmosIdsByTarea(@NonNull @Positive final Long idTarea);

  Boolean checkDuplicatedActives();

}
