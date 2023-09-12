package com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunLimpiezaService {

  void run(@NotNull @Valid final RunLimpiezaDto runLimpieza);

}
