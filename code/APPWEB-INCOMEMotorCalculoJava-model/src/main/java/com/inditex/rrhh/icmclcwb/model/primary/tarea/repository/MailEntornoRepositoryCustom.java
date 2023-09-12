package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailEntornoDto;

import javax.validation.constraints.NotBlank;

public interface MailEntornoRepositoryCustom {

  MailEntornoDto findMailEntornoDtoByEntorno(
      @NotBlank String entorno);
}
