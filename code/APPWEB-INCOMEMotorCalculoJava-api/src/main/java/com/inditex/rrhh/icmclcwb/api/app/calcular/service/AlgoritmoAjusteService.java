package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface AlgoritmoAjusteService {

  List<Long> customFindAjustePesosByTarea(@NotNull @Positive Long id);

  AlgoritmoAjusteDto findById(@NotNull @Positive Integer id);

  List<AlgoritmoAjusteDto> findByPeso(@NotNull @Positive Long id);

  List<Integer> customFindAjusteIdsByTareaAndPeso(@NotNull @Positive Long idTarea, @NotNull @Positive Long peso);

}
