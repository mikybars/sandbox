package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import org.jspecify.annotations.NonNull;

public interface MailEntornoService {

  Boolean findEsActivoByEntorno(@NonNull String entorno);
}
