package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailAmbitoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.MailAmbitoRepositoryCustomImpl;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailAmbitoServiceImpl implements MailAmbitoService {

  @Autowired
  private MailAmbitoRepositoryCustomImpl mailAmbitoRepositoryCustom;

  @Override
  public List<String> getMailByCclIdOrigenAndStdIdLegEnt(@NotNull final String cclIdOrigen,
      @NotNull final String stdIdLegEnt) {

    final List<MailAmbitoDto> mailAmbitoDtoList = this.mailAmbitoRepositoryCustom
        .findMailByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    return mailAmbitoDtoList.stream().map(x -> x.getMail()).collect(Collectors.toList());
  }
}
