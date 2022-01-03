package com.inditex.rrhh.icmclcwb.api.app.run.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface RunAlgoritmoService {

  RunAlgoritmoDTO findById(@NotNull @Positive Integer id);

  List<RunAlgoritmoDTO> findAll();

}
