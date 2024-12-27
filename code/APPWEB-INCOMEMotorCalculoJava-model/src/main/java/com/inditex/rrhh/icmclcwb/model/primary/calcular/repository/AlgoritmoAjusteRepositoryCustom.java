package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.List;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface AlgoritmoAjusteRepositoryCustom {

  List<Long> customFindAjustePesosByTarea(@NonNull @Positive Long idTarea);

  List<Integer> customFindAjusteIdsByTareaAndPeso(@NonNull @Positive Long idTarea, @NonNull @Positive Long peso);

}
