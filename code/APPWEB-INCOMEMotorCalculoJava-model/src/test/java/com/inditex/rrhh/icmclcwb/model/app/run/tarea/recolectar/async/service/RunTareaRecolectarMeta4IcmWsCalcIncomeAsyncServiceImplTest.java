package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomeService tareaRecolectarMeta4IcmWsCalcIncomeService;

  @InjectMocks
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Test
  void fechaAmbitoAndEmpresaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.fechaAmbitoAndEmpresaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).fechaAmbitoAndEmpresaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void personaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.personaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).personaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void localizacionByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.localizacionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).localizacionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void estructurasComByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).estructurasComByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void estructurasPolByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).estructurasPolByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void tiendasComisionableByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.tiendasComisionableByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).tiendasComisionableByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presenciaManualByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presenciaManualByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).presenciaManualByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presenciaManualLocalizacionByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presenciaManualLocalizacionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).presenciaManualLocalizacionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaManualLocalizacionByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.ventaManualLocalizacionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).ventaManualLocalizacionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void empleadosPresenciaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.empleadosPresenciaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).empleadosPresenciaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void coefJornadaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.coefJornadaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).coefJornadaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void configuracionVentaOnlineByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.configuracionVentaOnlineByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).configuracionVentaOnlineByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void flagCalculaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.flagCalculaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).flagCalculaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void agrupacionesCadenaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.agrupacionesCadenaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).agrupacionesCadenaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void localizacionesOnlineByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.localizacionesOnlineByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).localizacionesOnlineByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void empleadosDesplazamientoByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.empleadosDesplazamientoByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).empleadosDesplazamientoByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ausenciasByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.ausenciasByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).ausenciasByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void configuracionesByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.configuracionesByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).configuraciones(any(RunTareaDto.class));
  }

  @Test
  void confChallengeDiasMinimosByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.confChallengeDiasMinimosByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).confChallengeDiasMinimosByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presupuestosWlocByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).presupuestosWlocByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void confPrecioHoraByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.confPrecioHoraByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).confPrecioHoraByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void confChallengeTipoVentaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.confChallengeTipoVentaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).confChallengeTipoVentaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presupuestosRangoByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosRangoByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).presupuestosRangoByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaCongeladaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.ventaCongeladaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).ventaCongeladaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void desplazamientoRealByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.desplazamientoRealByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).desplazamientoRealByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void localizacionCadenaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.localizacionCadenaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).localizacionCadenaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void estructurasPolByConfiguracionVentaOnlineEntregaDomicilioTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByConfiguracionVentaOnlineEntregaDomicilio(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).estructurasPolCadenaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void empleadosCadenaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.empleadosCadenaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).empleadosCadenaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void tiposHoraByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.tiposHoraByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).tiposHoraByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void estadoWlocByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estadoWlocByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarMeta4IcmWsCalcIncomeService, times(1)).estadoWlocByRunTarea(any(RunTareaDto.class));
  }
}
