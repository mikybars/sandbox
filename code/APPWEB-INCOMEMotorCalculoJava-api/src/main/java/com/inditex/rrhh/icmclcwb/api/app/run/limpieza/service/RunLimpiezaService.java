package com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunLimpiezaService {

  void run(@NonNull @Valid final RunLimpiezaDto runLimpieza);

}
