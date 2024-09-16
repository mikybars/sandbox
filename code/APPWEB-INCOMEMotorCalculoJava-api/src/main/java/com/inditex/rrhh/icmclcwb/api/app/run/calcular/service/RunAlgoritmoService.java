package com.inditex.rrhh.icmclcwb.api.app.run.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface RunAlgoritmoService {

  RunAlgoritmoDTO findById(@NotNull @Positive Integer id);

  List<RunAlgoritmoDTO> findAll();

}
