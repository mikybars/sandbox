package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;

public interface MailService {

  void sendMailMotivos(final RunTareaDto runTarea, List<ValidacionDto> fallidas);

  /**
   * Some javadoc.
   *
   * @param tareaFase Some javadoc.
   * @param fallidas Some javadoc.
   * @param runTarea Some javadoc.
   */
  void sendMail(TareaFaseDto tareaFase, List<ValidacionDto> fallidas, RunTareaDto runTarea);

}
