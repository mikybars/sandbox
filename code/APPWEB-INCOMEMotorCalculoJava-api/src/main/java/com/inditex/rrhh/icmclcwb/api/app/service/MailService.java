package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface MailService {

  void sendMailMotivos(final RunTareaDto runTarea, List<ValidacionDto> fallidas);

  /**
   * Some javadoc.
   *
   * @param fallidas Some javadoc.
   * @param runTarea Some javadoc.
   */
  void sendMail(List<ValidacionDto> fallidas, RunTareaDto runTarea);

  void sendMailValidacionesAgrupadas(List<ValidacionDto> validacionesParaNotificar, RunTareaDto runTarea);

}
