package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface AlgoritmoService {

  AlgoritmoDTO findById(@NonNull @Positive Integer id);

  List<AlgoritmoDTO> findAll();

  List<Integer> customFindAlgoritmosIdsByTarea(@NonNull @Positive Long id);

  Boolean checkDuplicatedActives();

}
