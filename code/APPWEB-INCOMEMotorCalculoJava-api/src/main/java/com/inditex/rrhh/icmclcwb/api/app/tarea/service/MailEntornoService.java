package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

public interface MailEntornoService {

  Boolean findEsActivoByEntorno(@NotNull String entorno);
}
