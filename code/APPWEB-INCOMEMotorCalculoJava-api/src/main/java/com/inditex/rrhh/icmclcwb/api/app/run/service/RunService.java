package com.inditex.rrhh.icmclcwb.api.app.run.service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface RunService {

  void runTrabajo(@NotNull @Positive final Long id);

  void runTarea(@NotNull @Positive final Long id);

  void runLimpieza(@NotNull @Positive final Long id);

  void runProgramacion(@NotNull @Positive final Long id);

}
