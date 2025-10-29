package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueante;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueanteFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(SpringExtension.class)
class RunValidacionesAgrupadasServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunValidacionNoBloqueanteFactory runValidacionNoBloqueanteFactory;

  @Mock
  private AccionService accionService;

  @Mock
  private MailService mailService;

  @Mock
  private MailEntornoService mailEntornoService;

  @Mock
  private RunValidacionNoBloqueante runValidacionNoBloqueante;

  @InjectMocks
  private RunValidacionesAgrupadasServiceImpl service;

  @Test
  void ejecutarValidacionesNoBloqueantesShouldExecuteSuccessfully() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(32)
        .peso(10)
        .build();

    final List<TareaFaseAccionDto> accionesList = List.of(tareaFaseAccion);

    final ValidacionDto validacion = ValidacionDto.builder()
        .result(Boolean.FALSE)
        .reaccionPeso(1)
        .idPersonaLocal(List.of("123"))
        .build();

    final List<ValidacionDto> validaciones = List.of(validacion);

    ReflectionTestUtils.setField(this.service, "environment", "PRE");

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(accionesList);
    when(this.accionService.findAccionDtoById(32))
        .thenReturn(AccionDto.builder().nombre("ValidacionExcedido").build());
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante(anyString()))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueante.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class)))
        .thenReturn(CompletableFuture.completedFuture(validaciones));
    when(this.mailEntornoService.findEsActivoByEntorno("PRE")).thenReturn(Boolean.TRUE);
    doNothing().when(this.mailService).sendMail(any(), any(RunTareaDto.class));

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.tareaFaseAccionService, times(1))
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
            anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId()));
    verify(this.mailService, times(1)).sendMail(any(), eq(runTareaDto));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldNotSendMailWhenNoValidationsFailed() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(33)
        .peso(10)
        .build();

    final ValidacionDto validacion = ValidacionDto.builder()
        .result(Boolean.TRUE)
        .reaccionPeso(1)
        .build();

    final List<ValidacionDto> validaciones = List.of(validacion);

    ReflectionTestUtils.setField(this.service, "environment", "PRE");

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(List.of(tareaFaseAccion));
    when(this.accionService.findAccionDtoById(33))
        .thenReturn(AccionDto.builder().nombre("ValidacionPendiente").build());
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante(anyString()))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueante.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class)))
        .thenReturn(CompletableFuture.completedFuture(validaciones));

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.mailService, never()).sendMail(any(), any(RunTareaDto.class));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldReturnWhenNoAcciones() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(Collections.emptyList());

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.accionService, never()).findAccionDtoById(anyInt());
    verify(this.mailService, never()).sendMail(any(), any(RunTareaDto.class));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldHandleMultipleValidaciones() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto accion1 = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(32)
        .peso(10)
        .build();

    final TareaFaseAccionDto accion2 = TareaFaseAccionDto.builder()
        .id(2L)
        .idAccion(33)
        .peso(5)
        .build();

    final ValidacionDto validacion1 = ValidacionDto.builder()
        .result(Boolean.FALSE)
        .reaccionPeso(2)
        .idPersonaLocal(List.of("123"))
        .build();

    final ValidacionDto validacion2 = ValidacionDto.builder()
        .result(Boolean.FALSE)
        .reaccionPeso(1)
        .idPersonaLocal(List.of("456"))
        .build();

    ReflectionTestUtils.setField(this.service, "environment", "PRO");

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(List.of(accion1, accion2));
    when(this.accionService.findAccionDtoById(32))
        .thenReturn(AccionDto.builder().nombre("ValidacionExcedido").build());
    when(this.accionService.findAccionDtoById(33))
        .thenReturn(AccionDto.builder().nombre("ValidacionPendiente").build());
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante("ValidacionExcedido"))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante("ValidacionPendiente"))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueante.execute(runTareaDto, accion1))
        .thenReturn(CompletableFuture.completedFuture(List.of(validacion1)));
    when(this.runValidacionNoBloqueante.execute(runTareaDto, accion2))
        .thenReturn(CompletableFuture.completedFuture(List.of(validacion2)));
    when(this.mailEntornoService.findEsActivoByEntorno("PRO")).thenReturn(Boolean.TRUE);
    doNothing().when(this.mailService).sendMail(any(), any(RunTareaDto.class));

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.accionService, times(1)).findAccionDtoById(32);
    verify(this.accionService, times(1)).findAccionDtoById(33);
    verify(this.mailService, times(1)).sendMail(any(), eq(runTareaDto));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldNotSendMailWhenEntornoNotActive() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(34)
        .peso(10)
        .build();

    final ValidacionDto validacion = ValidacionDto.builder()
        .result(Boolean.FALSE)
        .reaccionPeso(1)
        .build();

    ReflectionTestUtils.setField(this.service, "environment", "PRE");

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(List.of(tareaFaseAccion));
    when(this.accionService.findAccionDtoById(34))
        .thenReturn(AccionDto.builder().nombre("ValidacionPorcentajeCero").build());
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante(anyString()))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueante.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class)))
        .thenReturn(CompletableFuture.completedFuture(List.of(validacion)));
    when(this.mailEntornoService.findEsActivoByEntorno("PRE")).thenReturn(Boolean.FALSE);

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.mailService, never()).sendMail(any(), any(RunTareaDto.class));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldHandleExceptionInValidation() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(32)
        .peso(10)
        .build();

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(List.of(tareaFaseAccion));
    when(this.accionService.findAccionDtoById(32))
        .thenThrow(new RuntimeException("Error al buscar acción"));

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.mailService, never()).sendMail(any(), any(RunTareaDto.class));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldHandleExceptionInMailSending() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(32)
        .peso(10)
        .build();

    final ValidacionDto validacion = ValidacionDto.builder()
        .result(Boolean.FALSE)
        .reaccionPeso(1)
        .idPersonaLocal(List.of("789"))
        .build();

    ReflectionTestUtils.setField(this.service, "environment", "PRE");

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(List.of(tareaFaseAccion));
    when(this.accionService.findAccionDtoById(32))
        .thenReturn(AccionDto.builder().nombre("ValidacionExcedido").build());
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante(anyString()))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueante.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class)))
        .thenReturn(CompletableFuture.completedFuture(List.of(validacion)));
    when(this.mailEntornoService.findEsActivoByEntorno("PRE")).thenReturn(Boolean.TRUE);
    doThrow(new RuntimeException("Error al enviar correo"))
        .when(this.mailService).sendMail(any(), any(RunTareaDto.class));

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.mailService, times(1)).sendMail(any(), eq(runTareaDto));
  }

  @Test
  void ejecutarValidacionesNoBloqueantesShouldFilterOnlyNonBlockingActions() {
    final RunTareaDto runTareaDto = this.createRunTareaDto();
    final FaseDto faseDto = new FaseDto(1);

    final TareaFaseAccionDto accionBloqueante = TareaFaseAccionDto.builder()
        .id(1L)
        .idAccion(99)
        .peso(10)
        .build();

    final TareaFaseAccionDto accionNoBloqueante = TareaFaseAccionDto.builder()
        .id(2L)
        .idAccion(32)
        .peso(5)
        .build();

    final ValidacionDto validacion = ValidacionDto.builder()
        .result(Boolean.FALSE)
        .reaccionPeso(1)
        .idPersonaLocal(List.of("999"))
        .build();

    ReflectionTestUtils.setField(this.service, "environment", "PRE");

    when(this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        anyLong(), anyInt(), eq(PuntoEjecucionEnum.DESPUES.getId())))
            .thenReturn(List.of(accionBloqueante, accionNoBloqueante));
    when(this.accionService.findAccionDtoById(32))
        .thenReturn(AccionDto.builder().nombre("ValidacionExcedido").build());
    when(this.runValidacionNoBloqueanteFactory.getRunValidacionNoBloqueante(anyString()))
        .thenReturn(this.runValidacionNoBloqueante);
    when(this.runValidacionNoBloqueante.execute(any(RunTareaDto.class), any(TareaFaseAccionDto.class)))
        .thenReturn(CompletableFuture.completedFuture(List.of(validacion)));
    when(this.mailEntornoService.findEsActivoByEntorno("PRE")).thenReturn(Boolean.TRUE);
    doNothing().when(this.mailService).sendMail(any(), any(RunTareaDto.class));

    this.service.ejecutarValidacionesNoBloqueantes(runTareaDto, faseDto);

    verify(this.accionService, times(1)).findAccionDtoById(32);
    verify(this.accionService, never()).findAccionDtoById(99);
    verify(this.mailService, times(1)).sendMail(any(), eq(runTareaDto));
  }

  private RunTareaDto createRunTareaDto() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    tarea.setIdTrabajo(100L);

    final RunTareaDto runTarea = new RunTareaDto();
    runTarea.setTarea(tarea);

    return runTarea;
  }
}
