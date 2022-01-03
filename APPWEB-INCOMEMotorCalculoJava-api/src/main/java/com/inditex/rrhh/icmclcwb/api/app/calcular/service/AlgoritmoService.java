package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AlgoritmoService {

  AlgoritmoDTO findByTipoCalculoId(@NotNull @Positive Long id);

  AlgoritmoDTO findByTipoCalculoIdAndTipoComisionId(@NotNull @Positive Long idTipoCalculo,
      @NotNull @Positive Long idTipoComision);

  AlgoritmoDTO findById(@NotNull @Positive Integer id);

  List<AlgoritmoDTO> findAll();

  List<Integer> customFindAlgoritmosIdsByTarea(@NotNull @Positive Long id);

  Boolean checkDuplicatedActives();

}
