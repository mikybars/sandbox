package com.inditex.rrhh.icmclcwb.model.app.programacion.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUser;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUtils;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.model.HeimdalUserDetails;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionAmbitoService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepositoryCustom;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ProgramacionServiceImplTest {

  @Mock
  private ProgramacionRepositoryCustom programacionRepositoryCustom;

  @Mock
  private ProgramacionRepository programacionRepository;

  @Mock
  private ProgramacionMapper programacionMapper;

  @Mock
  private ProgramacionAmbitoService programacionAmbitoService;

  @InjectMocks
  private ProgramacionServiceImpl programacionService;

  @Test
  void createTest() {

    final ProgramacionDTO programacion = new ProgramacionDTO();
    programacion.setProgramacionHuso(TimeUtils.ofZoneId());
    programacion.setNombreUsuario("aaaa");
    programacion.setAmbito(new ArrayList<>());
    programacion.getAmbito().add(new ProgramacionAmbitoDTO());
    programacion.setHoraProgramacion(OffsetDateTime.MAX);

    when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new Programacion());
    when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
    when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
    when(this.programacionAmbitoService.create(ArgumentMatchers.any(),
        any(ProgramacionDTO.class)))
            .thenReturn(new ArrayList<>());

    final ProgramacionDTO result = this.programacionService.create(programacion);
    final Date date = TimeUtils.nowDate(); // Generado aquí para que no se diferencien las fechas en los equals por 1 segudno
    assertNotNull(result);
    assertNotNull(result.getFechaHoraCreacion());
    assertEquals(DateUtils.truncate(date, Calendar.SECOND),
        DateUtils.truncate(
            Date.from(
                result.getFechaHoraCreacion().toLocalDateTime().atZone(TimeUtils.ofZone()).toInstant()),
            Calendar.SECOND));
    assertEquals(DateUtils.truncate(date, Calendar.SECOND),
        DateUtils.truncate(
            Date.from(
                result.getFechaHoraCreacion().toLocalDateTime().atZone(TimeUtils.ofZone()).toInstant()),
            Calendar.SECOND));
    assertEquals(programacion.getProgramacionHuso(), result.getProgramacionHuso());
    assertEquals(programacion.getNombreUsuario(), result.getNombreUsuario());
    assertEquals(programacion.getAmbito(), result.getAmbito());
    // Solo se comprueba si existe fecha, la comprobacion de la fecha correcta se hace en otro test de
    // esta clase
    assertNotNull(result.getFechaHoraSiguienteEjecucion());
  }

  @Disabled
  @Test
  void createTestSso() {
    final Authentication authentication = Mockito.mock(Authentication.class);
    // TODO [MDELRIO] Buscar manera de replicar este test con el nombre en blanco para cubrir test
    final HeimdalUserDetails user = new HeimdalUserDetails();
    final HeimdalUser heimdalUser = HeimdalUtils.getHeimdalUser();
    user.setLogin("login");
    when(authentication.getPrincipal())
        .thenReturn(heimdalUser);
    final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
    Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
    SecurityContextHolder.setContext(securityContext);

    when(HeimdalUtils.getHeimdalUser())
        .thenReturn(heimdalUser);
    when(HeimdalUtils.getHeimdalUser())
        .thenReturn(heimdalUser);

    final ProgramacionDTO programacion = new ProgramacionDTO();
    programacion.setProgramacionHuso(TimeUtils.ofZoneId());
    programacion.setAmbito(new ArrayList<>());
    programacion.getAmbito().add(new ProgramacionAmbitoDTO());
    programacion.setHoraProgramacion(OffsetDateTime.MAX);

    when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new Programacion());
    when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
    when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
    when(this.programacionAmbitoService.create(ArgumentMatchers.any(),
        any(ProgramacionDTO.class)))
            .thenReturn(new ArrayList<>());

    final ProgramacionDTO result = this.programacionService.create(programacion);
    assertNotNull(result);
    assertNotNull(result.getFechaHoraCreacion());
    // Como puede ocurrir que now y la fecha de creación varíe en un segundo, se comprueba que la
    // diferencia entre ambos no pase de 2 segundos (2000 milisegundos)
    final long ahoraMilisegundos = DateUtils.truncate(TimeUtils.nowDate(), Calendar.SECOND).getTime();

    final long fechaCreacionMilisegundos = DateUtils
        .truncate(Date.from(result.getFechaHoraCreacion().toLocalDateTime().atZone(TimeUtils.ofZone()).toInstant()),
            Calendar.SECOND)
        .getTime();
    assertTrue(ahoraMilisegundos - fechaCreacionMilisegundos < 2000L);
    assertEquals(programacion.getProgramacionHuso(), result.getProgramacionHuso());
    assertEquals(programacion.getNombreUsuario(), result.getNombreUsuario());
    assertEquals(programacion.getAmbito(), result.getAmbito());
    // Solo se comprueba si existe fecha, la comprobacion de la fecha correcta se hace en otro test de
    // esta clase
    assertNotNull(result.getFechaHoraSiguienteEjecucion());
  }

  @Test
  void createSinProgramacionHusoTest() {

    final ProgramacionDTO programacion = new ProgramacionDTO();
    programacion.setNombreUsuario("aaaa");
    programacion.setAmbito(new ArrayList<>());
    programacion.getAmbito().add(new ProgramacionAmbitoDTO());
    programacion.setHoraProgramacion(OffsetDateTime.MAX);

    when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new Programacion());
    when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
    when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
    when(this.programacionAmbitoService.create(ArgumentMatchers.any(),
        any(ProgramacionDTO.class)))
            .thenReturn(new ArrayList<>());

    final ProgramacionDTO result = this.programacionService.create(programacion);
    assertNotNull(result);
    assertEquals(TimeUtils.ofZoneId(), result.getProgramacionHuso());
  }

  @Test
  void modifyTest() {

    final ProgramacionDTO programacion = mock(ProgramacionDTO.class);

    when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new Programacion());
    when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
    when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
    when(this.programacionAmbitoService.findByProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new ArrayList<>());

    this.programacionService.modify(programacion);
    verify(this.programacionRepository, times(1)).save(any(Programacion.class));

  }

  @Test
  void fechaSiguienteEjecucionAntesProgramacionTest() {

    // Si el momento actual es anterior a la hora de programación, la fecha resultado debería ser hoy
    final ProgramacionDTO programacion = mock(ProgramacionDTO.class);
    when(programacion.getProgramacionHuso()).thenReturn(TimeUtils.ofZoneId());
    when(programacion.getHoraProgramacion()).thenReturn(OffsetDateTime.MAX);

    final LocalDateTime result = this.programacionService.fechaSiguienteEjecucion(programacion);
    assertTrue(DateUtils.isSameDay(new Date(), Date.from(result.atZone(TimeUtils.ofZone()).toInstant())));

  }

  private OffsetDateTime now(final int i) {
    final Duration duration = Duration.ofSeconds(Long.valueOf(i));
    return OffsetDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0).plus(duration), ZoneOffset.UTC);
  }

  @Test
  void fechaSiguienteEjecucionDespuesProgramacionTest() {

    // Si el momento actual es posterior a la hora de programación, la fecha resultado debería ser
    // mañana
    final ProgramacionDTO programacion = mock(ProgramacionDTO.class);
    when(programacion.getProgramacionHuso()).thenReturn(TimeUtils.ofZoneId());
    when(programacion.getHoraProgramacion()).thenReturn(this.now(0));

    final LocalDateTime result = this.programacionService.fechaSiguienteEjecucion(programacion);

    assertTrue(DateUtils.isSameDay(DateUtils.addDays(new Date(), 1),
        Date.from(result.atZone(TimeUtils.ofZone()).toInstant())));

  }

  @Test
  void findPendienteTest() {

    when(this.programacionMapper.programacionToProgramacionDto(ArgumentMatchers.<List<Programacion>>any()))
        .thenReturn(new ArrayList<>());
    when(this.programacionRepository.findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(any(LocalDateTime.class)))
        .thenReturn(new ArrayList<>());

    this.programacionService.findPendiente();
    verify(this.programacionRepository, times(1))
        .findByFechaHoraSiguienteEjecucionBeforeAndActivoTrue(any(LocalDateTime.class));

  }

  @Test
  void updateEjecucionTest() {

    final ProgramacionDTO programacion = new ProgramacionDTO();
    programacion.setHoraProgramacion(OffsetDateTime.now(ZoneId.systemDefault()));
    programacion.setProgramacionHuso(TimeUtils.ofZoneId());

    when(this.programacionMapper.programacionDtoToProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new Programacion());
    when(this.programacionMapper.programacionToProgramacionDto(any(Programacion.class))).thenReturn(programacion);
    when(this.programacionRepository.save(any(Programacion.class))).thenReturn(new Programacion());
    when(this.programacionAmbitoService.findByProgramacion(any(ProgramacionDTO.class)))
        .thenReturn(new ArrayList<>());

    this.programacionService.updateEjecucion(programacion);

    assertTrue(DateUtils.isSameDay(new Date(),
        Date.from(programacion.getFechaHoraUltimaEjecucion().toInstant())));
    verify(this.programacionRepository, times(1)).save(any(Programacion.class));
    verify(this.programacionMapper, times(1)).programacionDtoToProgramacion(programacion);
    verify(this.programacionMapper, times(1)).programacionToProgramacionDto(any(Programacion.class));

  }

  @Test
  void resetTest() {
    this.programacionService.reset();
    verify(this.programacionRepositoryCustom, times(1)).reset();
  }

  @Test
  void activaTest() {
    this.programacionService.activa();
    verify(this.programacionRepositoryCustom, times(1)).activa();
  }

  @Test
  void activaIdTest() {
    final Long id = 1L;
    this.programacionService.activa(id);
    verify(this.programacionRepositoryCustom, times(1)).activa(id);
  }

  @Test
  void desactivaTest() {
    this.programacionService.desactiva();
    verify(this.programacionRepositoryCustom, times(1)).desactiva();
  }

  @Test
  void desactivaIdTest() {
    final Long id = 1L;
    this.programacionService.desactiva(id);
    verify(this.programacionRepositoryCustom, times(1)).desactiva(id);
  }

  @Test
  void updateFechaSiguienteEjecucionTest() {

    final ProgramacionDTO programacion1 = new ProgramacionDTO();
    programacion1.setHoraProgramacion(OffsetDateTime.now(ZoneId.systemDefault()));
    programacion1.setProgramacionHuso(TimeUtils.ofZoneId());
    final ProgramacionDTO programacion2 = new ProgramacionDTO();
    programacion2.setHoraProgramacion(OffsetDateTime.now(ZoneId.systemDefault()));
    programacion2.setProgramacionHuso(TimeUtils.ofZoneId());
    final ProgramacionDTO programacion3 = new ProgramacionDTO();
    programacion3.setHoraProgramacion(OffsetDateTime.now(ZoneId.systemDefault()));
    programacion3.setProgramacionHuso(TimeUtils.ofZoneId());

    final List<ProgramacionDTO> programaciones = Arrays.asList(programacion1, programacion2, programacion3);
    assertDoesNotThrow(() -> this.programacionService.updateFechaSiguienteEjecucion(programaciones));

    final ArgumentCaptor<List<IdProgramacionDto>> idsCaptor = ArgumentCaptor.forClass(List.class);
    final ArgumentCaptor<LocalDateTime> dateCaptor = ArgumentCaptor.forClass(LocalDateTime.class);

    // verify(this.programacionRepositoryCustom, times(3))
    // .updateFechaSiguienteEjecucion(idsCaptor.capture(), dateCaptor.capture());

  }

}
