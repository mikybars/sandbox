package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ReglaValidacionExcedidoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
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

@ExtendWith({SpringExtension.class})
public class MailServiceImplTest {

  private static final String ORGANIZATION = "organization";

  private static final String ENVIRONMENT = "environment";

  private static final String PRE = "PRE";

  private static final String PRO = "PRO";

  public static final String TEXTO = "texto";

  public static final String USUARIO = "usuario";

  public static final String PERSONA = "persona";

  public static final String CCL_ID_ORIGEN = "61";

  public static final String MAIL = "mail";

  public static final String ES = "ES";

  public static final String SRVCICMCLCWBAX = "srvcicmclcwbax";

  @Mock
  private MailSender mailSender;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private MailAmbitoService mailAmbitoService;

  @Mock
  private MailEntornoService mailEntornoService;

  @Mock
  private ReglaValidacionExcedidoService reglaValidacionExcedidoService;

  @InjectMocks
  private MailServiceImpl mailServiceImpl;

  @Test
  void sendMailBase() {
    this.sendMail(1, ORGANIZATION, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailBaseEs() {
    this.sendMail(1, ES, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailBaseEsUsuarioPRO() {
    this.sendMail(1, ES, SRVCICMCLCWBAX, Boolean.FALSE);
  }

  @Test
  void sendMailPresencia() {
    this.sendMail(4, ORGANIZATION, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailFecha() {
    this.sendMail(3, ORGANIZATION, USUARIO, Boolean.TRUE);
  }

  void sendMail(final Integer idAccion, final String idOrganization, final String nombreUsuario, final Boolean envioEntorno) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();

    tareaAmbito.setCclIdOrigen("60");
    tarea.setIdOrganization(idOrganization);
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario(nombreUsuario);
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add(PERSONA);
    final List<UsuarioResultItemDto> usuarios = new ArrayList<>();
    usuarios.add(UsuarioResultItemDto.builder().mail(MAIL).build());

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, PRE);
    validaciones.add(ValidacionDto.builder().cclIdOrigen(CCL_ID_ORIGEN).idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    when(this.tareaFaseAccionService.findById(ArgumentMatchers.any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(idAccion).build());
    when(this.accionService.findAccionDtoById(ArgumentMatchers.any(Integer.class)))
        .thenReturn(AccionDto.builder().descripcion(TEXTO).id(idAccion).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(ArgumentMatchers.any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    when(this.mailEntornoService.findEsActivoByEntorno(any())).thenReturn(envioEntorno);
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("1"));

    this.mailServiceImpl.sendMail(validaciones, runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));

  }

  @Test
  void sendMailMotivosPRO() {
    this.sendMailMotivos(PRO, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(Arrays.asList(1, 2)).build()),
        Boolean.TRUE);
  }

  @Test
  void sendMailMotivosDES() {
    this.sendMailMotivos(PRE, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(Arrays.asList(1, 2)).build()),
        Boolean.FALSE);
  }

  @Test
  void sendMailMotivosNullDES() {
    this.sendMailMotivos(PRE, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(null).build()), Boolean.TRUE);
  }

  @Test
  void sendMailMotivosEmptyDES() {
    this.sendMailMotivos(PRE, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(new ArrayList<>()).build()),
        Boolean.TRUE);
  }

  void sendMailMotivos(final String environment, final List<ValidacionDto> validaciones, final Boolean envioEntorno) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setIdOrganization(ORGANIZATION);
    runTareaDto.setTarea(tarea);
    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, environment);

    tareaAmbito.setCclIdOrigen("60");
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");

    when(this.mailEntornoService.findEsActivoByEntorno(any())).thenReturn(envioEntorno);
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("1"));

    this.mailServiceImpl.sendMailMotivos(runTareaDto, validaciones);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion32() {
    this.sendMailValidacionesAgrupadas(32, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion33() {
    this.sendMailValidacionesAgrupadas(33, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion34() {
    this.sendMailValidacionesAgrupadas(34, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion35() {
    this.sendMailValidacionesAgrupadasConLocalizacion(35, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion36() {
    this.sendMailValidacionesAgrupadasConLocalizacion(36, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion35SinLocalizaciones() {
    this.sendMailValidacionesAgrupadasConLocalizacionVacia(35, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasValidacion36SinLocalizaciones() {
    this.sendMailValidacionesAgrupadasConLocalizacionVacia(36, PRE, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasMultiplesValidaciones() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();
    final List<String> localizacionLocal = new ArrayList<>();

    tareaAmbito.setCclIdOrigen("60");
    tarea.setIdOrganization(ORGANIZATION);
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");
    tarea.setId(1L);
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario(USUARIO);
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add(PERSONA);
    localizacionLocal.add("LOC001");

    validaciones.add(ValidacionDto.builder().idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());
    validaciones.add(ValidacionDto.builder().idTareaFaseAccion(2L).idPersonaLocal(personaLocal).build());
    validaciones.add(ValidacionDto.builder().idTareaFaseAccion(3L).idPersonaLocal(personaLocal).build());
    validaciones.add(
        ValidacionDto.builder().idTareaFaseAccion(4L).idPersonaLocal(new ArrayList<>()).idLocalizacionLocal(localizacionLocal).build());
    validaciones.add(
        ValidacionDto.builder().idTareaFaseAccion(5L).idPersonaLocal(new ArrayList<>()).idLocalizacionLocal(localizacionLocal).build());

    final List<UsuarioResultItemDto> usuarios = new ArrayList<>();
    usuarios.add(UsuarioResultItemDto.builder().mail(MAIL).build());

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, PRE);

    when(this.tareaFaseAccionService.findById(1L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(32).build());
    when(this.tareaFaseAccionService.findById(2L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(33).build());
    when(this.tareaFaseAccionService.findById(3L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(34).build());
    when(this.tareaFaseAccionService.findById(4L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(36).build());
    when(this.tareaFaseAccionService.findById(5L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(37).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    when(this.mailEntornoService.findEsActivoByEntorno(any())).thenReturn(Boolean.TRUE);
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("test@inditex.com"));
    when(this.reglaValidacionExcedidoService.findByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of(
            ReglaValidacionExcedidoDto.builder().idTipoCalculo("001").importe(new BigDecimal("100")).build(),
            ReglaValidacionExcedidoDto.builder().idTipoCalculo("002").importe(new BigDecimal("200")).build()));

    this.mailServiceImpl.sendMailValidacionesAgrupadas(validaciones, runTareaDto);

    verify(this.mailSender, times(1)).send(any(SimpleMailMessage.class));
  }

  @Test
  void sendMailValidacionesAgrupadasPRO() {
    this.sendMailValidacionesAgrupadas(32, PRO, USUARIO, Boolean.TRUE);
  }

  @Test
  void sendMailValidacionesAgrupadasUsuarioSrvcicmclcwbax() {
    this.sendMailValidacionesAgrupadas(33, PRE, SRVCICMCLCWBAX, Boolean.FALSE);
  }

  void sendMailValidacionesAgrupadas(final Integer idAccion, final String environment,
      final String nombreUsuario, final Boolean envioEntorno) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> personaLocal = new ArrayList<>();

    tareaAmbito.setCclIdOrigen("60");
    tarea.setIdOrganization(ORGANIZATION);
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");
    tarea.setId(1L);
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario(nombreUsuario);
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    personaLocal.add(PERSONA);

    validaciones.add(ValidacionDto.builder().idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    final List<UsuarioResultItemDto> usuarios = new ArrayList<>();
    usuarios.add(UsuarioResultItemDto.builder().mail(MAIL).build());

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, environment);

    when(this.tareaFaseAccionService.findById(1L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(idAccion).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    when(this.mailEntornoService.findEsActivoByEntorno(any())).thenReturn(envioEntorno);
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("test@inditex.com"));
    when(this.reglaValidacionExcedidoService.findByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of(
            ReglaValidacionExcedidoDto.builder().idTipoCalculo("001").importe(new BigDecimal("100")).build(),
            ReglaValidacionExcedidoDto.builder().idTipoCalculo("002").importe(new BigDecimal("200")).build()));

    this.mailServiceImpl.sendMailValidacionesAgrupadas(validaciones, runTareaDto);

    verify(this.mailSender, times(1)).send(any(SimpleMailMessage.class));
  }

  void sendMailValidacionesAgrupadasConLocalizacion(final Integer idAccion, final String environment,
      final String nombreUsuario, final Boolean envioEntorno) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();
    final List<String> localizacionLocal = new ArrayList<>();

    tareaAmbito.setCclIdOrigen("60");
    tarea.setIdOrganization(ORGANIZATION);
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");
    tarea.setId(1L);
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario(nombreUsuario);
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);
    localizacionLocal.add("LOC001");
    localizacionLocal.add("LOC002");

    validaciones.add(ValidacionDto.builder()
        .idTareaFaseAccion(1L)
        .idPersonaLocal(new ArrayList<>())
        .idLocalizacionLocal(localizacionLocal)
        .build());

    final List<UsuarioResultItemDto> usuarios = new ArrayList<>();
    usuarios.add(UsuarioResultItemDto.builder().mail(MAIL).build());

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, environment);

    when(this.tareaFaseAccionService.findById(1L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(idAccion).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    when(this.mailEntornoService.findEsActivoByEntorno(any())).thenReturn(envioEntorno);
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("test@inditex.com"));

    this.mailServiceImpl.sendMailValidacionesAgrupadas(validaciones, runTareaDto);

    verify(this.mailSender, times(1)).send(any(SimpleMailMessage.class));
  }

  void sendMailValidacionesAgrupadasConLocalizacionVacia(final Integer idAccion, final String environment,
      final String nombreUsuario, final Boolean envioEntorno) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final List<ValidacionDto> validaciones = new ArrayList<>();

    tareaAmbito.setCclIdOrigen("60");
    tarea.setIdOrganization(ORGANIZATION);
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");
    tarea.setId(1L);
    trabajo.setFechaInicioPeriodo(OffsetDateTime.MIN);
    trabajo.setFechaFinPeriodo(OffsetDateTime.MAX);
    trabajo.setNombreUsuario(nombreUsuario);
    runTareaDto.setTrabajo(trabajo);
    runTareaDto.setTarea(tarea);

    validaciones.add(ValidacionDto.builder()
        .idTareaFaseAccion(1L)
        .idPersonaLocal(new ArrayList<>())
        .idLocalizacionLocal(null)
        .build());

    final List<UsuarioResultItemDto> usuarios = new ArrayList<>();
    usuarios.add(UsuarioResultItemDto.builder().mail(MAIL).build());

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, environment);

    when(this.tareaFaseAccionService.findById(1L))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(idAccion).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    when(this.mailEntornoService.findEsActivoByEntorno(any())).thenReturn(envioEntorno);
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("test@inditex.com"));

    this.mailServiceImpl.sendMailValidacionesAgrupadas(validaciones, runTareaDto);

    verify(this.mailSender, times(1)).send(any(SimpleMailMessage.class));
  }
}
