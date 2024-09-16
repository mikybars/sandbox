package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface AlgoritmoService {

  AlgoritmoDTO findById(@NotNull @Positive Integer id);

  List<AlgoritmoDTO> findAll();

  List<Integer> customFindAlgoritmosIdsByTarea(@NotNull @Positive Long id);

  Boolean checkDuplicatedActives();

}
