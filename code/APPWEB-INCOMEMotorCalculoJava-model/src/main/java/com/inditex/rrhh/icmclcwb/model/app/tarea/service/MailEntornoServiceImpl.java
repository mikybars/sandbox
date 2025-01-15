package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailEntornoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.MailEntornoRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailEntornoServiceImpl implements MailEntornoService {

  @Autowired
  private MailEntornoRepositoryCustom mailEntornoRepositoryCustom;

  @Override
  public Boolean findEsActivoByEntorno(@NotNull final String entorno) {

    final MailEntornoDto mailEntornoDto = this.mailEntornoRepositoryCustom
        .findMailEntornoDtoByEntorno(entorno);

    return mailEntornoDto != null && mailEntornoDto.getActivo() != null && mailEntornoDto.getActivo() ? Boolean.TRUE : Boolean.FALSE;
  }
}
