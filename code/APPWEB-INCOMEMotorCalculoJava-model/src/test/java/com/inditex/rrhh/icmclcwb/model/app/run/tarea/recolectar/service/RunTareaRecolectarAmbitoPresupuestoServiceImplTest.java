package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service.LimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaPresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

  @InjectMocks
  private RunTareaRecolectarAmbitoPresupuestoServiceImpl runTareaRecolectarAmbitoPresupuestoService;

  @Test
  void runTestSociedad() {
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO ambito = new TipoAmbitoDTO();
    ambito.setId(1L);
    trabajo.setTipoAmbito(ambito);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);

    final TareaLocalizacionPresupuestoListDto presupuestos = new TareaLocalizacionPresupuestoListDto();
    presupuestos.esAmbitoAmpliado(tarea);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(presupuestos);
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

    this.runTareaRecolectarAmbitoPresupuestoService.run(runTarea);

    assertEquals(cf, this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(runTarea));
  }

  @Test
  void runTestOrigen() {
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);
    final TareaDto tarea = new TareaDto();
    final TareaLocalizacionPresupuestoListDto presupuestos = new TareaLocalizacionPresupuestoListDto();
    presupuestos.esAmbitoAmpliado(tarea);
    final RunTareaDto runTarea = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO ambito = new TipoAmbitoDTO();
    ambito.setId(2L);
    trabajo.setTipoAmbito(ambito);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(presupuestos);
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

    this.runTareaRecolectarAmbitoPresupuestoService.run(runTarea);

    assertEquals(cf, this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(runTarea));
  }

  @Test
  void runTestEmpresa() {
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO ambito = new TipoAmbitoDTO();
    ambito.setId(3L);
    trabajo.setTipoAmbito(ambito);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);

    final TareaLocalizacionPresupuestoListDto presupuestos = new TareaLocalizacionPresupuestoListDto();
    presupuestos.esAmbitoAmpliado(tarea);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(presupuestos);
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

    this.runTareaRecolectarAmbitoPresupuestoService.run(runTarea);

    assertEquals(cf, this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(runTarea));
  }

  @Test
  void runTestLocalizacion() {
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO ambito = new TipoAmbitoDTO();
    ambito.setId(4L);
    trabajo.setTipoAmbito(ambito);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);

    final TareaLocalizacionPresupuestoListDto presupuestos = new TareaLocalizacionPresupuestoListDto();
    presupuestos.esAmbitoAmpliado(tarea);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(presupuestos);
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

    this.runTareaRecolectarAmbitoPresupuestoService.run(runTarea);

    assertEquals(cf, this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(runTarea));
  }

  @Test
  void runTestPersona() {
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);

    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO ambito = new TipoAmbitoDTO();
    ambito.setId(5L);
    trabajo.setTipoAmbito(ambito);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);

    final TareaLocalizacionPresupuestoListDto presupuestos = new TareaLocalizacionPresupuestoListDto();
    presupuestos.esAmbitoAmpliado(tarea);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(presupuestos);
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

    this.runTareaRecolectarAmbitoPresupuestoService.run(runTarea);

    assertEquals(cf, this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(runTarea));
  }

  @Test
  void runTestException() {
    final RunTareaDto runTarea = new RunTareaDto();

    doThrow(new IcmclcwbException("")).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .estructurasComByRunTarea(any(RunTareaDto.class));

    assertThrows(IcmclcwbException.class, () -> this.runTareaRecolectarAmbitoPresupuestoService.run(runTarea));
  }
}
