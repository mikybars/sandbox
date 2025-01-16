package com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunLimpiezaService {

  void run(@NotNull @Valid final RunLimpiezaDto runLimpieza);

}
