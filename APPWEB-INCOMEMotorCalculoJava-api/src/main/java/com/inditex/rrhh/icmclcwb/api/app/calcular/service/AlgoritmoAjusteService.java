package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;

public interface AlgoritmoAjusteService {

    List<Integer> customFindAjusteIdsByTarea(@NotNull @Positive Long id);

    AlgoritmoAjusteDto findById(@NotNull @Positive Integer id);

}
