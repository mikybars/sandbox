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
import java.util.Arrays;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResultItemDto;
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

  private static final String ORGANIZATION = "organization";

  private static final String ENVIRONMENT = "environment";

  private static final String DES = "DES";

  private static final String PRO = "PRO";

  public static final String TEXTO = "texto";

  public static final String USUARIO = "usuario";

  public static final String PERSONA = "persona";

  public static final String CCL_ID_ORIGEN = "61";

  public static final String MAIL = "mail";

  @Mock
  private MailSender mailSender;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private MailServiceImpl mailServiceImpl;

  @Test
  void sendMailBase() {
    this.sendMail(1);
  }

  @Test
  void sendMailPresencia() {
    this.sendMail(4);
  }

  @Test
  void sendMailFecha() {
    this.sendMail(3);
  }

  void sendMail(final Integer idAccion) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaFaseDto tareaFase = new TareaFaseDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();

    tarea.setIdOrganization(ORGANIZATION);
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario(USUARIO);
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add(PERSONA);
    final List<UsuarioResultItemDto> usuarios = new ArrayList<>();
    usuarios.add(UsuarioResultItemDto.builder().mail(MAIL).build());

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, DES);
    validaciones.add(ValidacionDto.builder().cclIdOrigen(CCL_ID_ORIGEN).idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    when(this.tareaFaseAccionService.findById(ArgumentMatchers.any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(idAccion).build());
    when(this.accionService.findAccionDtoById(ArgumentMatchers.any(Integer.class)))
        .thenReturn(AccionDto.builder().descripcion(TEXTO).id(idAccion).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(ArgumentMatchers.any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    this.mailServiceImpl.sendMail(tareaFase, validaciones, runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));

  }

  @Test
  void sendMailMotivosPRO() {
    this.sendMailMotivos(PRO);
  }

  @Test
  void sendMailMotivosDES() {
    this.sendMailMotivos(DES);
  }

  void sendMailMotivos(final String environment) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization(ORGANIZATION);
    runTareaDto.setTarea(tarea);
    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, environment);

    this.mailServiceImpl.sendMailMotivos(runTareaDto,
        Arrays.asList(ValidacionDto.builder().idMotivosDesplazamiento(Arrays.asList(1, 2)).build()));

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));
  }
}
