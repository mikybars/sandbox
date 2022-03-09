package com.inditex.rrhh.icmclcwb.model.app.service;
/*
 * Copyright (c) 2022. Inditex
 */

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class MailServiceImplTest {

  @Mock
  private MailSender mailSender;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private MailServiceImpl mailServiceImpl;

  @Test
  void sendMail() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaFaseDto tareaFase = new TareaFaseDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();

    tarea.setIdOrganization("organization");
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario("usuario");
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add("persona");

    ReflectionTestUtils.setField(this.mailServiceImpl, "environment", "des");
    validaciones.add(ValidacionDto.builder().cclIdOrigen("61").idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    when(this.tareaFaseAccionService.findById(ArgumentMatchers.any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(1).build());
    when(this.accionService.findAccionDtoById(ArgumentMatchers.any(Integer.class)))
        .thenReturn(AccionDto.builder().descripcion("texto").id(1).build());

    this.mailServiceImpl.sendMail(tareaFase, validaciones, runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));

  }

  @Test
  void sendMailFechas() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaFaseDto tareaFase = new TareaFaseDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();

    tarea.setIdOrganization("organization");
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario("usuario");
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add("persona");

    ReflectionTestUtils.setField(this.mailServiceImpl, "environment", "des");
    validaciones.add(ValidacionDto.builder().cclIdOrigen("61").idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    when(this.tareaFaseAccionService.findById(ArgumentMatchers.any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(1).build());
    when(this.accionService.findAccionDtoById(ArgumentMatchers.any(Integer.class)))
        .thenReturn(AccionDto.builder().descripcion("texto").id(3).build());

    this.mailServiceImpl.sendMail(tareaFase, validaciones, runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));

  }

  @Test
  void sendMailPresencias() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaFaseDto tareaFase = new TareaFaseDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();

    tarea.setIdOrganization("organization");
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario("usuario");
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add("persona");

    ReflectionTestUtils.setField(this.mailServiceImpl, "environment", "des");
    validaciones.add(ValidacionDto.builder().cclIdOrigen("61").idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    when(this.tareaFaseAccionService.findById(ArgumentMatchers.any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(1).build());
    when(this.accionService.findAccionDtoById(ArgumentMatchers.any(Integer.class)))
        .thenReturn(AccionDto.builder().descripcion("texto").id(4).build());

    this.mailServiceImpl.sendMail(tareaFase, validaciones, runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));

  }

  @Test
  void sendMailMotivos() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("organization");
    runTareaDto.setTarea(tarea);
    ReflectionTestUtils.setField(this.mailServiceImpl, "environment", "des");

    this.mailServiceImpl.sendMailMotivos(runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));
  }
}
