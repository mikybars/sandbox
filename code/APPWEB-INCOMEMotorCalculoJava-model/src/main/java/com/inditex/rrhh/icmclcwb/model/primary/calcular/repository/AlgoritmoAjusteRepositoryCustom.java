package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AlgoritmoAjusteRepositoryCustom {

  List<Long> customFindAjustePesosByTarea(@NotNull @Positive Long idTarea);

  List<Integer> customFindAjusteIdsByTareaAndPeso(@NotNull @Positive Long idTarea, @NotNull @Positive Long peso);

}
