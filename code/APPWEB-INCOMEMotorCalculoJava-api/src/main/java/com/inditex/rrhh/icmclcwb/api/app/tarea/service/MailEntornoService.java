package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import jakarta.validation.constraints.NotNull;

public interface MailEntornoService {

  Boolean findEsActivoByEntorno(@NotNull String entorno);
}
