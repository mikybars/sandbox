package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface AlgoritmoAjusteService {

  List<Long> customFindAjustePesosByTarea(@NonNull @Positive Long id);

  AlgoritmoAjusteDto findById(@NonNull @Positive Integer id);

  List<AlgoritmoAjusteDto> findByPeso(@NonNull @Positive Long id);

  List<Integer> customFindAjusteIdsByTareaAndPeso(@NonNull @Positive Long idTarea, @NonNull @Positive Long peso);

}
