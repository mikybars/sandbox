package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarAmbitoServiceImplTest {

  @Mock
  private RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

  @Mock
  private RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

  @Mock
  private RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Mock
  private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

  @Mock
  private TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

  @Mock
  private TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaAsyncService tareaAmbitoGlobalLocalizacionPersonaAsyncService;

  @InjectMocks
  private RunTareaRecolectarAmbitoServiceImpl runTareaRecolectarAmbitoService;

  @ParameterizedTest
  @ValueSource(longs = {1L, 2L, 3L, 4L, 5L})
  void runTest(final long arg) {
    final RunTareaDto runTarea = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO ambito = new TipoAmbitoDTO();
    ambito.setId(arg);
    trabajo.setTipoAmbito(ambito);
    runTarea.setTrabajo(trabajo);

    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.personaByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.localizacionByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarPtrPresenciaAsyncService.presenciaEmpleadoTiendaByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.empleadosPresenciaByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.empleadosPresenciaByRunTarea(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaAmbitoGlobalLocalizacionPersonaAsyncService.mergePersonaLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaAmbitoGlobalPersonaAsyncService.mergePersona(any(RunTareaDto.class))).thenReturn(cf);
    when(this.tareaAmbitoGlobalLocalizacionAsyncService.mergeLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.empleadosDesplazamientoByRunTarea(any(RunTareaDto.class))).thenReturn(
        cf);

    this.runTareaRecolectarAmbitoService.run(runTarea);

    assertEquals(cf, this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.personaByRunTarea(runTarea));
  }

  @Test
  void runTestException() {
    final RunTareaDto runTarea = new RunTareaDto();

    doThrow(new IcmclcwbException("")).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .personaByRunTarea(any(RunTareaDto.class));

    assertThrows(IcmclcwbException.class, () -> this.runTareaRecolectarAmbitoService.run(runTarea));
  }
}
