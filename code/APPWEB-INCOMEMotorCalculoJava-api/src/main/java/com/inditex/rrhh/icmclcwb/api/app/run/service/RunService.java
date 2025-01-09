package com.inditex.rrhh.icmclcwb.api.app.run.service;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface RunService {

  void runTrabajo(@NonNull @Positive final Long id);

  void runTarea(@NonNull @Positive final Long id);

  void runLimpieza(@NonNull @Positive final Long id);

  void runProgramacion(@NonNull @Positive final Long id);

}
