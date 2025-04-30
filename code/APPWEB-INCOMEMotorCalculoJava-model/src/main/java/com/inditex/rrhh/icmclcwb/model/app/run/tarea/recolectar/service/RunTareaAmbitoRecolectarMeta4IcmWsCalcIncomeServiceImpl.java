package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.DesplazamientoRealDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHIstoricoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionCadenaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionConfiguracionChallengeTipoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionChallengeDiasMinimosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionPrecioHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionCalcularAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOnlineHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaAusenciaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaCoeficienteAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraDesplazamientoRealAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaEstructuraPoliticaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraDesplazamientoRealService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.PresupuestosWlocMapper;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TiendaMapper;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoChallengeMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiposVentaChallengeResponseDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl
    extends AbstractRunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
    implements RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.class);

  @Autowired
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Autowired
  @Qualifier("meta4Properties")
  private Map<String, Meta4PropertiesDto> meta4Properties;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

  @Autowired
  private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeAsyncService;

  @Autowired
  private TareaMapper tareaMapper;

  @Autowired
  private TareaPersonaHistoricoService tareaPersonaHistoricoService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Autowired
  private TareaLocalizacionHistoricoAsyncService tareaLocalizacionHistoricoAsyncService;

  @Autowired
  private TareaPersonaEstructuraAsyncService tareaPersonaEstructuraAsyncService;

  @Autowired
  private TareaLocalizacionComisionHistoricoAsyncService tareaLocalizacionComisionHistoricoAsyncService;

  @Autowired
  private TareaLocalizacionCalcularAsyncService tareaLocalizacionCalcularAsyncService;

  @Autowired
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaSeccionPresenciaAsyncService;

  @Autowired
  private TareaPersonaCoeficienteAsyncService tareaPersonaCoeficienteAsyncService;

  @Autowired
  private TareaAgrupacionConfiguracionAsyncService tareaAgrupacionConfiguracionAsyncService;

  @Autowired
  private TareaAgrupacionCadenaAsyncService tareaAgrupacionCadenaAsyncService;

  @Autowired
  private TareaLocalizacionOnlineHistoricoAsyncService tareaLocalizacionOnlineHistoricoAsyncService;

  @Autowired
  private TareaPersonaEstructuraPoliticaAsyncService tareaPersonaEstructuraPoliticaAsyncService;

  @Autowired
  private TareaPersonaAusenciaHistoricoAsyncService tareaPersonaAusenciaHistoricoAsyncService;

  @Autowired
  private TareaConfiguracionAsyncService tareaConfiguracionAsyncService;

  @Autowired
  private TareaLocalizacionPresupuestoAsyncService tareaLocalizacionPresupuestoAsyncService;

  @Autowired
  private TareaConfiguracionChallengeDiasMinimosAsyncService tareaConfiguracionChallengeDiasMinimosAsyncService;

  @Autowired
  private TareaConfiguracionPrecioHoraAsyncService tareaConfiguracionPrecioHoraAsyncService;

  @Autowired
  private TareaAgrupacionConfiguracionChallengeTipoVentaAsyncService tareaAgrupacionConfiguracionChallengeTipoVentaAsyncService;

  @Autowired
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Autowired
  private TareaLocalizacionPresupuestoVentaAsyncService tareaLocalizacionPresupuestoVentaAsyncService;

  @Autowired
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRealService tareaPersonaEstructuraDesplazamientoRealService;

  @Autowired
  private TareaPersonaEstructuraDesplazamientoRealAsyncService tareaPersonaEstructuraDesplazamientoRealAsyncService;

  @Autowired
  private TareaLocalizacionPresenciaAsyncService tareaLocalizacionPresenciaAsyncService;

  @Autowired
  private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

  @Autowired
  private TareaPersonaHistoricoAsyncService tareaPersonaHistoricoAsyncService;

  @Autowired
  private TareaTipoHoraAsyncService tareaTipoHoraAsyncService;

  @Autowired
  private TareaLocalizacionEstadoAsyncService tareaLocalizacionEstadoAsyncService;

  @Autowired
  private IncomeMetaService incomeMetaService;

  @Autowired
  private TipoVentaConceptoChallengeMapper tipoVentaConceptoChallengeMapper;

  @Autowired
  private TiendaMapper tiendaMapper;

  @Autowired
  private PresupuestosWlocMapper presupuestosWlocMapper;

  @Override
  protected LocalDateTime getFechaInicioPeriodo(final TareaDto tarea) {
    return TimeUtils.toLocalDateTime(tarea.getFechaInicioPeriodo());
  }

  @Override
  public void coefJornadaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
          this.tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
              tarea.getId(),
              tareaAmbito.getCclIdOrigen(),
              Collections.singletonList(TipoDatoEnum.PERSONA_COEFICIENTEREDUCCIONJORNADA.getId())),
          this.meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getFilter().getMaxPageSize())) {
        final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(
                tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData()
            .setItem(
                iter.stream()
                    .map(e -> GenericFilterParametersDto.builder()
                        .idEmpleado(e.getStdIdHr())
                        .orEmpleado(e.getStdOrHrPeriod())
                        .build())
                    .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getCoefJornada(request);
          AsyncUtils.exceptionally(cfData, cf);
          final List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist,
                this.meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA)
                    .getFilter()
                    .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaPersonaCoeficienteAsyncService.save(data,
                tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            hasNext = request.nextPage();
          }
        } while (hasNext);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void flagCalculaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdLocalizacionDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
              tarea.getId(),
              tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getFilter().getMaxPageSize())) {
        final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                .collect(Collectors.toList()));

        final CompletableFuture<List<GenericTiendaResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getFlagCalcula(request);
        AsyncUtils.exceptionally(cfData, cf);
        final List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaLocalizacionCalcularAsyncService.save(data,
              tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);

        }

        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void presenciaManualByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final List<IdLocalizacionEmpresaDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
                  tarea.getId(), tareaAmbito.getCclIdOrigen(), empresasAmbito),
          this.meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getFilter().getMaxPageSize())) {
        final PresenciaManualRequestDto request = new PresenciaManualRequestDto();
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(
                tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData().setItem(new ArrayList<>());
        request.getData().setIdsEmpresa(null);
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> GenericFilterParametersDto.builder()
                    .idLugarTrabajo(e.getId())
                    .idEmpresa(e.getStdIdLegEnt())
                    .build())
                .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getPresenciaManual(request);
          AsyncUtils.exceptionally(cfData, cf);
          final List<GenericEmpleadoResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
                .get(Meta4PropertiesConstants.PRESENCIA_MANUAL)
                .getFilter()
                .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionPersonaSeccionPresenciaAsyncService
                .save(data,
                    tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            hasNext = request.nextPage();
          }
        } while (hasNext);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void estructurasComByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdPersonaHIstoricoLocalizacionDto> iter : StreamUtils.partition(
          this.tareaPersonaHistoricoService.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
              tarea.getId(),
              tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_COM).getFilter().getMaxPageSize())) {
        final EstructurasComRequestDto estructurasComRequest = new EstructurasComRequestDto();
        estructurasComRequest.setData(this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToEstructurasComFilterDto(trabajo, tarea, tareaAmbito));
        estructurasComRequest.getData().setItem(new ArrayList<>());
        estructurasComRequest.getData()
            .getItem()
            .addAll(iter.stream()
                .map(
                    item -> EstructurasComFilterParametersDto.builder()
                        .idEmpleado(item.getStdIdHr())
                        .orEmpleado(item.getStdOrHrPeriod())
                        .build())
                .collect(Collectors.toList()));
        final CompletableFuture<List<EstructurasComResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getEstructurasCom(estructurasComRequest);
        AsyncUtils.exceptionally(cfData, cf);
        final List<EstructurasComResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
              .get(Meta4PropertiesConstants.ESTRUCTURAS_COM)
              .getFilter()
              .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaPersonaEstructuraAsyncService
              .saveEstructurasComResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void estructurasPolByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
          this.tareaPersonaHistoricoService.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(
              tarea.getId(),
              tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL).getFilter().getMaxPageSize())) {
        final EstructurasPolRequestDto estructurasPolRequest = new EstructurasPolRequestDto();
        estructurasPolRequest.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                this.tareaPersonaHistoricoService.findPeriodoByIdTareaDto(tarea.getId())));
        estructurasPolRequest.getData().setItem(new ArrayList<>());
        estructurasPolRequest.getData()
            .getItem()
            .addAll(iter.stream()
                .map(
                    item -> GenericFilterParametersDto.builder()
                        .idEmpleado(item.getStdIdHr())
                        .orEmpleado(item.getStdOrHrPeriod())
                        .build())
                .collect(Collectors.toList()));
        final CompletableFuture<List<EstructurasPolResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getEstructurasPol(estructurasPolRequest);
        AsyncUtils.exceptionally(cfData, cf);
        final List<EstructurasPolResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
              .get(Meta4PropertiesConstants.ESTRUCTURAS_POL)
              .getFilter()
              .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaPersonaEstructuraPoliticaAsyncService
              .saveEstructurasPolResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void estructurasPolCadenaByRunTareaAndAmbito(
      @NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdPersonaHistoricoDto> iter : StreamUtils.partition(
          this.tareaPersonaHistoricoService
              .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
                  tarea.getId(),
                  tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL).getFilter().getMaxPageSize())) {
        final EstructurasPolRequestDto estructurasPolRequest = new EstructurasPolRequestDto();
        estructurasPolRequest.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                this.tareaPersonaHistoricoService.findPeriodoByIdTareaDto(tarea.getId())));
        estructurasPolRequest.getData().setItem(new ArrayList<>());
        estructurasPolRequest.getData()
            .getItem()
            .addAll(iter.stream()
                .map(
                    item -> GenericFilterParametersDto.builder()
                        .idEmpleado(item.getStdIdHr())
                        .orEmpleado(item.getStdOrHrPeriod())
                        .build())
                .collect(Collectors.toList()));
        final CompletableFuture<List<EstructurasPolResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getEstructurasPol(estructurasPolRequest);
        AsyncUtils.exceptionally(cfData, cf);
        final List<EstructurasPolResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
              .get(Meta4PropertiesConstants.ESTRUCTURAS_POL)
              .getFilter()
              .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaPersonaEstructuraPoliticaAsyncService
              .saveEstructurasPolResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void configuracionVentaOnlineByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
      request.setData(this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDtoWithDates(tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()),
              this.recolectarProperties));
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE).getPage());

      boolean hasNext = false;
      do {
        final CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getConfiguracionVentaOnline(request);
        AsyncUtils.exceptionally(cfData, cf);
        final List<ConfiguracionVentaOnlineResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaAgrupacionConfiguracionAsyncService
              .saveAgrupacionConfiguracionDto(data, runTarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }
        hasNext = request.nextPage();
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void tiendasComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdLocalizacionDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
              tarea.getId(),
              tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS).getFilter().getMaxPageSize())) {
        final TiendasRequestDto tiendasRequest = new TiendasRequestDto();
        tiendasRequest.setPage(this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS).getPage());
        tiendasRequest.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        tiendasRequest.getData().setItem(new ArrayList<>());
        tiendasRequest.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<GenericTiendaResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getTiendas(tiendasRequest);
          AsyncUtils.exceptionally(cfData, cf);
          final List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist,
                this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS)
                    .getFilter()
                    .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionComisionHistoricoAsyncService
                .saveGenericTiendaResultItemDto(data, tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          }
          hasNext = tiendasRequest.nextPage();
        } while (hasNext);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void agrupacionesCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
      final TareaDto tarea = runTarea.getTarea();
      request.setData(this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));
      request.getData().setItem(new ArrayList<>());
      request.getData()
          .getItem()
          .add(GenericFilterParametersDto.builder().idOrigenReg(tareaAmbito.getCclIdOrigen()).build());
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE).getPage());
      boolean hasNext = false;
      do {
        final CompletableFuture<List<AgrupOnlineResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getAgrupacionesOnline(request);
        final List<AgrupOnlineResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaAgrupacionCadenaAsyncService.save(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          hasNext = request.nextPage();
        }
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void localizacionesOnlineByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdCadenaDto> cadenas : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(),
              tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE).getFilter().getMaxPageSize())) {

        final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE).getPage());
        final List<GenericFilterParametersDto> items = cadenas.stream()
            .map(x -> GenericFilterParametersDto.builder().idCadena(x.getId()).build())
            .collect(Collectors.toList());
        request.getData().setItem(items);
        boolean hasNext = false;
        do {
          final CompletableFuture<List<TiendaOnlineResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getTiendasOnline(request);
          final List<TiendaOnlineResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist,
                this.meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE)
                    .getFilter()
                    .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionOnlineHistoricoAsyncService
                .save(data, tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            hasNext = request.nextPage();
          }
        } while (hasNext);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }

  }

  @Override
  public void ausenciasByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final AusenciasRequestDto request = new AusenciasRequestDto();
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.AUSENCIAS).getPage());
      request.setData(this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToGenericFilterDto(tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));
      boolean hasNext = false;
      do {
        final CompletableFuture<List<AusenciasResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getAusencias(request);
        AsyncUtils.exceptionally(cfData, cf);
        final List<AusenciasResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
              .get(Meta4PropertiesConstants.AUSENCIAS)
              .getFilter()
              .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaPersonaAusenciaHistoricoAsyncService
              .saveAusenciaResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
          hasNext = request.nextPage();
        }
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void configuracionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final ConfiguracionesRequestDto request = this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfiguracionesRequestDto(
              tarea, tareaAmbito, this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
      final CompletableFuture<ConfiguracionesResponseDto> cfData = this.meta4IcmWsCalcIncomeAsyncService
          .getConfiguraciones(request);
      AsyncUtils.exceptionally(cfData, cf);
      final ConfiguracionesResponseDto data = AsyncUtils.get(cfData);
      if (CollectionUtils.isNotEmpty(data.getItems())) {
        AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
            .get(Meta4PropertiesConstants.CONFIGURACION)
            .getFilter()
            .getMaxPersistenceSize());
        final CompletableFuture<Void> cfSave = this.tareaConfiguracionAsyncService
            .saveConfiguracionItemDto(data.getItems(), tarea);
        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void confChallengeDiasMinimosByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.CONFCHALLENGEDIASMINIMOS).getPage());
      request.setData(this.tareaMapper
          .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfChDiasMinimosFilterDto(tarea, tareaAmbito,
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  tarea.getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId())));

      final CompletableFuture<List<ConfChDiasMinimosResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
          .getConfChallengeDiasMinimos(request);
      final List<ConfChDiasMinimosResultItemDto> data = AsyncUtils.get(cfData);
      if (CollectionUtils.isNotEmpty(data)) {
        AsyncUtils.checkAsyncAvaliable(cfPersist,
            this.meta4Properties.get(Meta4PropertiesConstants.CONFCHALLENGEDIASMINIMOS)
                .getFilter()
                .getMaxPersistenceSize());
        final CompletableFuture<Void> cfSave = this.tareaConfiguracionChallengeDiasMinimosAsyncService
            .saveConfChDiasMinimosResultItemDto(data, tarea);
        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void presupuestosWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<IdPersonaLocalDto> personasChallenge = this.tareaPersonaEstructuraService
          .findPersonasChallenge(tarea);
      final List<IdEmpresaDto> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId());
      if (CollectionUtils.isNotEmpty(personasChallenge)) {
        final List<Integer> listEmpresas = empresasAmbito.stream()
            .map(IdEmpresaDto::getStdIdLegEnt)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        final CompletableFuture<List<PresupuestosWlocResultItemDto>> cfData = CompletableFuture
            .completedFuture(
                this.presupuestosWlocMapper.toPresupuestosWlocResultItemDtoList(this.incomeMetaService.getPresupuestos(listEmpresas,
                    tarea.getFechaInicioPeriodo(), tarea.getFechaFinPeriodo(), tarea.getIdOrganization()), tareaAmbito.getCclIdOrigen()));
        AsyncUtils.exceptionally(cfData, cf);
        final List<PresupuestosWlocResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
              .get(Meta4PropertiesConstants.PRESUPUESTOSWLOC)
              .getFilter()
              .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaLocalizacionPresupuestoAsyncService.save(data,
              tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void confPrecioHoraByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.CONFPRECIOHORA).getPage());
      request.setData(this.tareaMapper.mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToConfPrecioHoraFilterDto(tarea,
          tareaAmbito, this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
              tarea.getId(),
              TipoDatoEnum.PERIODO_AMPLIADO.getId())));

      final CompletableFuture<List<ConfPrecioHoraResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
          .getConfPrecioHora(request);
      final List<ConfPrecioHoraResultItemDto> data = AsyncUtils.get(cfData);
      if (CollectionUtils.isNotEmpty(data)) {
        AsyncUtils.checkAsyncAvaliable(cfPersist,
            this.meta4Properties.get(Meta4PropertiesConstants.CONFPRECIOHORA)
                .getFilter()
                .getMaxPersistenceSize());
        final CompletableFuture<Void> cfSave = this.tareaConfiguracionPrecioHoraAsyncService
            .saveConfPrecioHoraResultItemDto(data, tarea);
        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
      }

      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void confChallengeTipoVentaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {

      final TareaDto tarea = runTarea.getTarea();

      final List<TiposVentaChallengeResponseDTO> listTiposVentaChallenge = this.incomeMetaService.getTiposVentaChallenge(
          tareaAmbito.getCclIdOrigen(), Integer.parseInt(tarea.getStdIdLegEnt()), tarea.getFechaInicioPeriodo(), tarea.getFechaFinPeriodo(),
          tarea.getIdOrganization());
      final CompletableFuture<List<ConfChTpVentaResultItemDto>> cfData = new CompletableFuture<>();
      cfData.complete(
          this.tipoVentaConceptoChallengeMapper.confChTpVentaResultItemDtoListToConfChTpVentaResultItemDtoList(listTiposVentaChallenge));
      final List<ConfChTpVentaResultItemDto> data = AsyncUtils.get(cfData);
      if (CollectionUtils.isNotEmpty(data)) {
        AsyncUtils.checkAsyncAvaliable(cfPersist,
            this.meta4Properties.get(Meta4PropertiesConstants.CONFCHALLENGETPVENTA)
                .getFilter()
                .getMaxPersistenceSize());
        final CompletableFuture<Void> cfSave = this.tareaAgrupacionConfiguracionChallengeTipoVentaAsyncService
            .saveConfChTpVentaResultItemDto(data, tarea);
        AsyncUtils.exceptionally(cfSave, cf, cfPersist);
      }

      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void presupuestosRangoByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final PresupuestosRangoRequestDto request = new PresupuestosRangoRequestDto();
      request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.PRESUPUESTOSRANGO).getPage());
      request.setData(this.tareaMapper
          .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPresupuestosRangoFilterDto(trabajo, tarea, tareaAmbito));
      request.getData()
          .setItem(Collections.singletonList(
              PresupuestosRangoFilterParametersDto.builder().idEmpresa(tarea.getStdIdLegEnt()).build()));
      boolean hasNext = false;
      do {
        final CompletableFuture<List<PresupuestosRangoResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getPresupuestosRango(request);
        final List<PresupuestosRangoResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.PRESUPUESTOSRANGO)
                  .getFilter()
                  .getMaxPersistenceSize());
          hasNext = request.nextPage();
        }
      } while (hasNext);
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void ventaCongeladaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdLocalizacionDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdLocalizacionByIdTarea(
              tarea.getId()),
          this.meta4Properties.get(Meta4PropertiesConstants.VENTACONGELADA).getFilter().getMaxPageSize())) {
        final VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.VENTACONGELADA).getPage());
        request.setData(this.tareaMapper
            .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToVentaCongeladaFilterDto(tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> VentaCongeladaFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<VentaCongeladaResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getVentaCongelada(request);
          final List<VentaCongeladaResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist,
                this.meta4Properties.get(Meta4PropertiesConstants.VENTACONGELADA)
                    .getFilter()
                    .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionPresupuestoVentaAsyncService
                .saveVentaCongeladaResultItemDto(data, runTarea.getTarea());
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            hasNext = request.nextPage();
          }
        } while (hasNext);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void desplazamientoRealByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      for (final List<DesplazamientoRealDto> iter : StreamUtils.partition(
          this.tareaPersonaEstructuraDesplazamientoRealService.findDesplazamientoReal(
              tarea),
          this.meta4Properties.get(Meta4PropertiesConstants.DESPLAZAMIENTO_REAL)
              .getFilter()
              .getMaxPageSize())) {
        final DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.DESPLAZAMIENTO_REAL).getPage());
        request.setData(this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToDesplazamientoRealFilterDto(trabajo,
                tarea,
                tareaAmbito));
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> DesplazamientoRealFilterParametersDto.builder()
                    .idEmpleado(e.getStdIdHr())
                    .orEmpleado(e.getStdOrHrPeriod())
                    .idOrigen(e.getCclIdOrigen())
                    .idEstructuraAmbito(e.getIdEstructuraAmbito())
                    .idEstructura(e.getIdEstructura())
                    .idEstructuraBase(e.getIdEstructuraBase())
                    .idEstructuraPadre(e.getIdEstructuraPadre())
                    .fechaInicio(TimeUtils.toLocalDateTime(e.getFechaInicio()))
                    .fechaFin(TimeUtils.toLocalDateTime(e.getFechaFin()))
                    .build())
                .collect(Collectors.toList()));

        final CompletableFuture<List<DesplazamientoRealResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
            .getDesplazReal(request);
        final List<DesplazamientoRealResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.DESPLAZAMIENTO_REAL)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaPersonaEstructuraDesplazamientoRealAsyncService
              .saveDesplazamientoRealResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void presenciaManualWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdLocalizacionDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
              tarea.getId(), tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL_WLOC)
              .getFilter()
              .getMaxPageSize())) {
        final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
        request.setPage(
            this.meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL_WLOC).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPresenciaManualWlocFilterDto(
                tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> PresenciaManualWlocFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<PresenciaManualWlocResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getPresenciaManualWloc(request);
          AsyncUtils.exceptionally(cfData, cf);
          final List<PresenciaManualWlocResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
                .get(Meta4PropertiesConstants.PRESENCIA_MANUAL_WLOC)
                .getFilter()
                .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionPresenciaAsyncService
                .save(data,
                    tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            hasNext = request.nextPage();
          }
        } while (hasNext);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void ventaManualWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      for (final List<IdLocalizacionDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
              tarea.getId(), tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.VENTA_MANUAL_WLOC)
              .getFilter()
              .getMaxPageSize())) {
        final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
        request.setPage(
            this.meta4Properties.get(Meta4PropertiesConstants.VENTA_MANUAL_WLOC).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToVentaManualWlocFilterDto(
                tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> VentaManualWlocFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<VentaManualWlocResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getVentaManualWloc(request);
          AsyncUtils.exceptionally(cfData, cf);
          final List<VentaManualWlocResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
                .get(Meta4PropertiesConstants.VENTA_MANUAL_WLOC)
                .getFilter()
                .getMaxPersistenceSize());
            final CompletableFuture<Void> cfSave = this.tareaLocalizacionVentaAsyncService
                .save(data,
                    tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
            hasNext = request.nextPage();
          }
        } while (hasNext);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void localizacionCadenaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final SearchTiendasRequestDto request = new SearchTiendasRequestDto();

      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(tarea.getId(),
              tareaAmbito.getCclIdOrigen(),
              Collections.singletonList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
      if (CollectionUtils.isNotEmpty(cadenas)) {

        final List<String> listaCadenas = cadenas.stream().map(IdCadenaDto::getId).collect(Collectors.toList());

        final List<GenericTiendaResultItemDto> listaTiendas =
            this.tiendaMapper.toGenericTiendaResultItemDtoList(this.incomeMetaService.getTiendas(
                tareaAmbito.getCclIdOrigen(), listaCadenas, false, tarea.getFechaInicioPeriodo(), tarea.getFechaFinPeriodo(),
                tarea.getIdOrganization()), tareaAmbito.getCclIdOrigen());
        final CompletableFuture<List<GenericTiendaResultItemDto>> cfData = CompletableFuture.completedFuture(listaTiendas);
        AsyncUtils.exceptionally(cfData, cf);
        final List<GenericTiendaResultItemDto> data = AsyncUtils.get(cfData);
        if (CollectionUtils.isNotEmpty(data)) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS)
                  .getFilter()
                  .getMaxPersistenceSize());
          final CompletableFuture<Void> cfSave = this.tareaLocalizacionHistoricoAsyncService
              .saveGenericTiendaResultItemDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);

        }
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void empleadosCadenaByRunTareaAndTareaAmbito(
      @NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();

      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(tarea.getId(),
              tareaAmbito.getCclIdOrigen(),
              Collections.singletonList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
      if (CollectionUtils.isNotEmpty(cadenas)) {
        request.setPage(this.meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtotoSearchEmpleadosFilterDto(tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData()
            .setIdsCadena(cadenas.stream().map(IdCadenaDto::getId).collect(Collectors.toList()));

        final List<EmpleadoDTO> data = this.incomeMetaService.searchEmpleados(request);

        if (CollectionUtils.isNotEmpty(data)) {
          final CompletableFuture<Void> cfSave = this.tareaPersonaHistoricoAsyncService.saveEmpleadoDto(data, tarea);
          AsyncUtils.exceptionally(cfSave, cf, cfPersist);
        }

      }
      AsyncUtils.waitAllOfIsOk(cf, cf);

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void tiposHoraByRunTareaAndTareaAmbito(
      @NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbitoDto) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    final TareaDto tarea = runTarea.getTarea();
    try {
      final TiposHoraRequestDto request = TiposHoraRequestDto
          .builder()
          .idOrigen(tareaAmbitoDto.getCclIdOrigen())
          .idsEmpresa(Collections.singletonList(tarea.getStdIdLegEnt()))
          .build();
      final CompletableFuture<TiposHoraResponseDto> cfData = this.meta4IcmWsCalcIncomeAsyncService
          .getTiposHora(request);
      AsyncUtils.exceptionally(cfData, cf, cfPersist);
      final TiposHoraResponseDto data = AsyncUtils.get(cfData);
      if ((data != null) && CollectionUtils.isNotEmpty(data.getItems())) {
        AsyncUtils.checkAsyncAvaliable(cfPersist,
            this.meta4Properties.get(Meta4PropertiesConstants.TIPOS_HORA)
                .getFilter()
                .getMaxPersistenceSize());
        AsyncUtils.exceptionally(
            this.tareaTipoHoraAsyncService.save(data, tarea), cf, cfPersist);
      } else {
        RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeServiceImpl.LOG.warn("No hay tipos de hora comisionables para el origen: {}",
            tareaAmbitoDto.getCclIdOrigen());
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

  @Override
  public void estadoWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();

      for (final List<IdLocalizacionDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(tarea.getId(),
              tareaAmbito.getCclIdOrigen()),
          this.meta4Properties.get(Meta4PropertiesConstants.ESTADO_WLOC).getFilter().getMaxPageSize())) {

        final EstadoWlocRequestDto request = new EstadoWlocRequestDto();
        request.setPage(
            this.meta4Properties.get(Meta4PropertiesConstants.ESTADO_WLOC).getPage());
        request.setData(this.tareaMapper
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToEstadoWlocFilterDto(
                tarea, tareaAmbito,
                this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                    tarea.getId(),
                    TipoDatoEnum.PERIODO_AMPLIADO.getId())));
        request.getData().setItem(new ArrayList<>());
        request.getData()
            .getItem()
            .addAll(iter.stream()
                .map(e -> EstadoWlocFilterParametersDto.builder().idLugarTrabajo(e.getId()).build())
                .collect(Collectors.toList()));
        boolean hasNext = false;
        do {
          final CompletableFuture<List<EstadoWlocResultItemDto>> cfData = this.meta4IcmWsCalcIncomeSessionAsyncService
              .getEstadoWloc(request);
          AsyncUtils.exceptionally(cfData, cf);
          final List<EstadoWlocResultItemDto> data = AsyncUtils.get(cfData);
          if (CollectionUtils.isNotEmpty(data)) {
            AsyncUtils.checkAsyncAvaliable(cfPersist, this.meta4Properties
                .get(Meta4PropertiesConstants.ESTADO_WLOC)
                .getFilter()
                .getMaxPersistenceSize());

            final CompletableFuture<Void> cfSave = this.tareaLocalizacionEstadoAsyncService.saveEstadoWlocResultItemDto(data, tarea);
            AsyncUtils.exceptionally(cfSave, cf, cfPersist);

            hasNext = request.nextPage();
          }
        } while (hasNext);
        AsyncUtils.waitAllOfIsOk(cf, cf);
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
