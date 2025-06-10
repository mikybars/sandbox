package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service.LimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaPresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarAmbitoPresupuestoServiceImplTest {
  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;

  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Mock
  private TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

  @Mock
  private TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaAsyncService tareaAmbitoGlobalLocalizacionPersonaAsyncService;

  @Mock
  private RunTareaRecolectarPtrPresenciaPresupuestosAsyncService runTareaRecolectarPtrPresenciaPresupuestosAsyncService;

  @Mock
  private RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

  @Mock
  private RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

  @Mock
  private RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

  @Mock
  private LimpiezaAsyncService limpiezaAsyncService;

  @Mock
  private SimulacionService simulacionService;

  @InjectMocks
  private RunTareaRecolectarAmbitoPresupuestoServiceImpl runTareaRecolectarAmbitoPresupuestoService;

  private RunTareaDto runTarea;

  private TareaDto tarea;

  private TrabajoDTO trabajo;

  private TipoAmbitoDTO ambito;

  private TareaLocalizacionPresupuestoListDto presupuestos;

  @BeforeEach
  void setUp() {
    this.runTarea = new RunTareaDto();
    this.tarea = new TareaDto();
    this.trabajo = new TrabajoDTO();
    this.ambito = new TipoAmbitoDTO();
    this.presupuestos = spy(new TareaLocalizacionPresupuestoListDto());

    this.runTarea.setTarea(this.tarea);
    this.runTarea.setTrabajo(this.trabajo);
    this.trabajo.setTipoAmbito(this.ambito);

    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class))).thenReturn(this.presupuestos);
    when(this.presupuestos.esAmbitoAmpliado(any(TareaDto.class))).thenReturn(true);
  }

  @ParameterizedTest
  @ValueSource(longs = {1L, 2L, 3L, 4L, 5L, -1L})
  void runTest(final long arg) {
    this.ambito.setId(arg);
    final CompletableFuture<Void> cf = CompletableFuture.completedFuture(null);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(this.presupuestos);

    when(this.limpiezaAsyncService.limpiezaTareaAmbitoGlobalPersona(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaAmbitoLocalizacion(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaPersonaHistorico(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaLocalizacionHistorico(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaGlobalLocalizacionPersona(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(any(TareaDto.class))).thenReturn(cf);
    when(this.limpiezaAsyncService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(any(TareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.personaByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.localizacionByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarPtrPresenciaPresupuestosAsyncService.presenciaEmpleadoTiendaByRunTarea(any(RunTareaDto.class)))
        .thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.empleadosPresenciaByRunTarea(any(RunTareaDto.class)))
        .thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.empleadosDesplazamientoByRunTarea(any(RunTareaDto.class)))
        .thenReturn(cf);
    when(this.tareaAmbitoGlobalLocalizacionPersonaAsyncService.mergePersonaLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaAmbitoGlobalPersonaAsyncService.mergePersona(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaAmbitoGlobalLocalizacionAsyncService.mergeLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    doNothing().when(this.simulacionService).mergeEmpleadoSimulacion(any(TareaDto.class));

    if (arg != -1L) {
      this.runTareaRecolectarAmbitoPresupuestoService.run(this.runTarea);
    } else {
      assertThrows(IcmclcwbException.class, () -> this.runTareaRecolectarAmbitoPresupuestoService.run(this.runTarea));
    }

    if (TipoAmbitoEnum.SOCIEDAD.getId().equals(this.trabajo.getTipoAmbito().getId())
        || TipoAmbitoEnum.ORIGEN.getId().equals(this.trabajo.getTipoAmbito().getId())
        || TipoAmbitoEnum.EMPRESA.getId().equals(this.trabajo.getTipoAmbito().getId())) {
      verify(this.runTareaRecolectarByAmbitoService).run(this.runTarea);
    } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(this.trabajo.getTipoAmbito().getId())) {
      verify(this.runTareaRecolectarByAmbitoLocalizacionService).run(this.runTarea);
    } else if (TipoAmbitoEnum.PERSONA.getId().equals(this.trabajo.getTipoAmbito().getId())) {
      verify(this.runTareaRecolectarByAmbitoPersonaService).run(this.runTarea);
    }
  }

  @Test
  void runTestException() {
    doThrow(new IcmclcwbException("")).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .estructurasComByRunTarea(any(RunTareaDto.class));

    assertThrows(IcmclcwbException.class, () -> this.runTareaRecolectarAmbitoPresupuestoService.run(this.runTarea));
  }
}
