package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailAmbitoService;
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

  private static final String DES = "DES";

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

  @InjectMocks
  private MailServiceImpl mailServiceImpl;

  @Test
  void sendMailBase() {
    this.sendMail(1, ORGANIZATION, USUARIO);
  }

  @Test
  void sendMailBaseEs() {
    this.sendMail(1, ES, USUARIO);
  }

  @Test
  void sendMailBaseEsUsuarioPRO() {
    this.sendMail(1, ES, SRVCICMCLCWBAX);
  }

  @Test
  void sendMailPresencia() {
    this.sendMail(4, ORGANIZATION, USUARIO);
  }

  @Test
  void sendMailFecha() {
    this.sendMail(3, ORGANIZATION, USUARIO);
  }

  void sendMail(final Integer idAccion, final String idOrganization, final String nombreUsuario) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final TareaFaseDto tareaFase = new TareaFaseDto();
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

    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, DES);
    validaciones.add(ValidacionDto.builder().cclIdOrigen(CCL_ID_ORIGEN).idTareaFaseAccion(1L).idPersonaLocal(personaLocal).build());

    when(this.tareaFaseAccionService.findById(ArgumentMatchers.any(Long.class)))
        .thenReturn(TareaFaseAccionDto.builder().idAccion(idAccion).build());
    when(this.accionService.findAccionDtoById(ArgumentMatchers.any(Integer.class)))
        .thenReturn(AccionDto.builder().descripcion(TEXTO).id(idAccion).build());
    when(this.meta4IcmWsCalcIncomeService.getMail(ArgumentMatchers.any(UsuarioRequestDto.class)))
        .thenReturn(UsuarioResponseDto.builder().items(usuarios).build());
    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("1"));
    this.mailServiceImpl.sendMail(tareaFase, validaciones, runTareaDto);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));

  }

  @Test
  void sendMailMotivosPRO() {
    this.sendMailMotivos(PRO, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(Arrays.asList(1, 2)).build()));
  }

  @Test
  void sendMailMotivosDES() {
    this.sendMailMotivos(DES, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(Arrays.asList(1, 2)).build()));
  }

  @Test
  void sendMailMotivosNullDES() {
    this.sendMailMotivos(DES, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(null).build()));
  }

  @Test
  void sendMailMotivosEmptyDES() {
    this.sendMailMotivos(DES, Collections.singletonList(ValidacionDto.builder().idMotivosDesplazamiento(new ArrayList<>()).build()));
  }

  void sendMailMotivos(final String environment, final List<ValidacionDto> validaciones) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setIdOrganization(ORGANIZATION);
    runTareaDto.setTarea(tarea);
    ReflectionTestUtils.setField(this.mailServiceImpl, ENVIRONMENT, environment);

    tareaAmbito.setCclIdOrigen("60");
    tarea.setAmbito(List.of(tareaAmbito));
    tarea.setStdIdLegEnt("1");

    when(this.mailAmbitoService.getMailByCclIdOrigenAndStdIdLegEnt("60", "1"))
        .thenReturn(List.of("1"));

    this.mailServiceImpl.sendMailMotivos(runTareaDto, validaciones);

    verify(this.mailSender, times(1))
        .send(any(SimpleMailMessage.class));
  }
}
