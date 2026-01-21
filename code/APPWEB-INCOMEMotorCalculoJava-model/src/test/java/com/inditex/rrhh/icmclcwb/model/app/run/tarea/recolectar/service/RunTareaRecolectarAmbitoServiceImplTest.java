package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class RunTareaRecolectarAmbitoServiceImplTest {

  @Spy
  @InjectMocks
  private RunTareaRecolectarAmbitoServiceImpl runTareaRecolectarAmbitoService;

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

  @Mock
  private SimulacionService simulacionService;

  @Mock
  private TrabajoDTO trabajoDTO;

  final RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  @ParameterizedTest
  @ValueSource(longs = {1L, 2L, 3L, 4L, 5L})
  void runTest(final long arg) {
    this.runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.ORIGEN.getDto());
    this.common();

    this.runTareaRecolectarAmbitoService.run(this.runTarea);

    verify(this.runTareaRecolectarAmbitoService, times(1))
        .run(this.runTarea);

    verify(this.tareaAmbitoGlobalLocalizacionAsyncService, times(1))
        .mergeLocalizacion(this.runTarea);

  }

  @Test
  public void runShouldHandleSociedadAmbito() {
    this.common();
    this.runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.SOCIEDAD.getDto());
    this.runTareaRecolectarAmbitoService.run(this.runTarea);
    verify(this.runTareaRecolectarAmbitoService, times(1)).run(this.runTarea);
  }

  @Test
  public void runShouldHandleOrigenAmbito() {
    this.common();
    this.runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.ORIGEN.getDto());
    this.runTareaRecolectarAmbitoService.run(this.runTarea);
    verify(this.runTareaRecolectarAmbitoService, times(1)).run(this.runTarea);
  }

  @Test
  public void runShouldHandleEmpresaAmbito() {
    this.common();
    this.runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
    this.runTareaRecolectarAmbitoService.run(this.runTarea);
    verify(this.runTareaRecolectarAmbitoService, times(1)).run(this.runTarea);
  }

  @Test
  public void runShouldHandleLocalizacionAmbito() {
    this.common();
    this.runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.LOCALIZACION.getDto());
    this.runTareaRecolectarAmbitoService.run(this.runTarea);
    verify(this.runTareaRecolectarAmbitoService, times(1)).run(this.runTarea);
  }

  @Test
  public void runShouldHandlePersonaAmbito() {
    this.common();
    this.runTarea.getTrabajo().setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
    this.runTareaRecolectarAmbitoService.run(this.runTarea);
    verify(this.runTareaRecolectarAmbitoService, times(1)).run(this.runTarea);
  }

  @Test
  public void runShouldThrowExceptionForUnsupportedAmbito() {
    this.common();
    when(this.trabajoDTO.getTipoAmbito()).thenReturn(null);
    assertThrows(IcmclcwbException.class, () -> this.runTareaRecolectarAmbitoService.run(this.runTarea));
  }

  private void common() {
    final CompletableFuture<Void> completableFuture = CompletableFuture.completedFuture(AsyncConstants.NIL);
    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .personaByRunTarea(this.runTarea);
    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .localizacionByRunTarea(this.runTarea);
    doReturn(completableFuture).when(this.runTareaRecolectarPtrPresenciaAsyncService)
        .presenciaEmpleadoTiendaByRunTarea(this.runTarea);
    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .empleadosPresenciaByRunTarea(this.runTarea);
    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .empleadosDesplazamientoByRunTarea(this.runTarea);
    doReturn(completableFuture).when(this.tareaAmbitoGlobalLocalizacionPersonaAsyncService)
        .mergePersonaLocalizacion(this.runTarea);
    doReturn(completableFuture).when(this.tareaAmbitoGlobalPersonaAsyncService)
        .mergePersona(this.runTarea);
    doReturn(completableFuture).when(this.tareaAmbitoGlobalLocalizacionAsyncService)
        .mergeLocalizacion(this.runTarea);
  }

}
