package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TiendaMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

  @InjectMocks
  private RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl runTareaRecolectarMeta4IcmWsCalcIncomeService;

  @Mock
  private TiendaMapper tiendaMapper;

  @Mock
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Mock
  private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

  @Test
  void fechaAmbitoAndEmpresaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.fechaAmbitoAndEmpresaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void personaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.personaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .personaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void localizacionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.localizacionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .localizacionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void empleadosPresenciaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.empleadosPresenciaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .empleadosPresenciaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void coefJornadaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.coefJornadaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .coefJornadaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void flagCalculaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.flagCalculaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .flagCalculaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void presenciaManualByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.presenciaManualByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .presenciaManualByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void presenciaManualLocalizacionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.presenciaManualLocalizacionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .presenciaManualWlocByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void ventaManualLocalizacionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.ventaManualLocalizacionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .ventaManualWlocByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void estructurasComByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.estructurasComByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .estructurasComByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void estructurasPolByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.estructurasPolByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .estructurasPolByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void tiendasComisionableByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionableByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .tiendasComisionableByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void configuracionVentaOnlineByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.configuracionVentaOnlineByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .configuracionVentaOnlineByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void agrupacionesCadenaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.agrupacionesCadenaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .agrupacionesCadenaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void localizacionesOnlineByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.localizacionesOnlineByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .localizacionesOnlineByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void empleadosDesplazamientoByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.empleadosDesplazamientoByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .empleadosDesplazamientoByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void ausenciasByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.ausenciasByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .ausenciasByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void configuracionesTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.configuraciones(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .configuracionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void confChallengeDiasMinimosByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.confChallengeDiasMinimosByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .confChallengeDiasMinimosByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void presupuestosWlocByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosWlocByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .presupuestosWlocByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void confPrecioHoraByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.confPrecioHoraByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .confPrecioHoraByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void confChallengeTipoVentaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.confChallengeTipoVentaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .confChallengeTipoVentaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void presupuestosRangoByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosRangoByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .presupuestosRangoByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void ventaCongeladaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.ventaCongeladaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .ventaCongeladaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void desplazamientoRealByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.desplazamientoRealByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .desplazamientoRealByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void localizacionCadenaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());
    when(this.tiendaMapper.toGenericTiendaResultItemDtoList(any(), anyString())).thenReturn(new ArrayList<>());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.localizacionCadenaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .localizacionCadenaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void estructurasPolCadenaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.estructurasPolCadenaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .estructurasPolCadenaByRunTareaAndAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void empleadosCadenaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.empleadosCadenaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .empleadosCadenaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void tiposHoraByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.tiposHoraByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .tiposHoraByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void testPresupuestosWlocByRunTareaAndTareaAmbito() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(TareaAmbitoDto.builder().build());

    this.runTareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosWlocByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService, times(1))
        .presupuestosWlocByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }
}
