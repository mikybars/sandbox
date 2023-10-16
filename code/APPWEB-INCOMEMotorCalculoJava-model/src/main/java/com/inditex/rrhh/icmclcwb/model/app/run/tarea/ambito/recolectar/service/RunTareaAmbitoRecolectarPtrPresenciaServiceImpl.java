package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrPresenciaServiceImpl
    extends AbstractRunTareaAmbitoRecolectarPtrPresenciaService
    implements RunTareaAmbitoRecolectarPtrPresenciaService {

  @Autowired
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Autowired
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

  @Autowired
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Autowired
  private TareaMapper tareaMapper;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  private TareaTipoHoraService tareaTipoHoraService;

  @Autowired
  @Qualifier("presenciasProperties")
  private Map<String, PtrPropertiesDto> presenciasProperties;

  @Autowired
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Override
  protected String getFechaInicioPeriodo(final TareaDto tarea) {
    return tarea.getFechaInicioPeriodo().format(DateTimeFormatter.ofPattern(PtrConstants.DATE_FORMAT));
  }

  @Override
  public void presenciaDetallePersonaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.presenciasProperties
          .get(PtrPropertiesConstants.PRESENCIA_DETALLE)
          .getFilter();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      empresasAmbito.add(PtrConstants.EMPRESA_0);
      final List<IdLocalizacionLocalDto> ficticias = this.tareaLocalizacionHistoricoService
          .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(tareaAmbito.getCclIdOrigen(), PtrConstants.EMPRESA_0);
      final List<IdLocalizacionLocalDto> localizaciones = this.tareaLocalizacionHistoricoService
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
              tarea.getId(), tareaAmbito.getCclIdOrigen(), empresasAmbito);
      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          Stream.concat(localizaciones.stream(), ficticias.stream())
              .collect(Collectors.toList()),
          filter.getMaxPageSize())) {
        for (final PeriodoDto periodo : this.tareaLocalizacionPresupuestoService
            .findListaPeriodosPresupestoYTrabajo(
                tarea.getId(), filter, this.recolectarProperties)) {
          final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
          final PtrPresenciaDetalleRequestDto paramPresenciasDetalle = this.tareaMapper
              .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(tarea,
                  tareaAmbito, periodo);
          paramPresenciasDetalle
              .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
          paramPresenciasDetalle.setTienda(iter.stream()
              .map(IdLocalizacionLocalDto::getId)
              .map(Integer::valueOf)
              .collect(Collectors.toList()));
          paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
          paramPresenciasDetalle
              .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
          final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = this.ptrPresenciaAsyncService
              .presenciasDetalle(paramPresenciasDetalle);
          AsyncUtils.exceptionally(cfData, cf, cfPersist);

          final PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
          if ((data != null) && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
            AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
            AsyncUtils.exceptionally(this.tareaLocalizacionPersonaPresenciaAsyncService
                .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea,
                    TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()),
                cf, cfPersist);
          }
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }

  }

  @Override
  public void presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(
      @NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.presenciasProperties
          .get(PtrPropertiesConstants.PRESENCIA_DETALLE)
          .getFilter();
      final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(),
              tareaAmbito.getCclIdOrigen(),
              Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
      if (CollectionUtils.isNotEmpty(cadenas)) {
        for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
            this.tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(
                    tarea.getId(), tareaAmbito.getCclIdOrigen(),
                    cadenas.stream().map(IdCadenaDto::getId).collect(Collectors.toList())),
            filter.getMaxPageSize())) {
          for (final PeriodoDto periodo : this.tareaLocalizacionPresupuestoService
              .findListaPeriodosPresupestoYTrabajo(
                  tarea.getId(), filter, this.recolectarProperties)) {
            final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            final PtrPresenciaDetalleRequestDto paramPresenciasDetalle = this.tareaMapper
                .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(tarea,
                    tareaAmbito, periodo);
            paramPresenciasDetalle
                .setCadena(
                    cadenas.stream().map(a -> Integer.valueOf(a.getId())).collect(Collectors.toList()));
            paramPresenciasDetalle.setTienda(iter.stream()
                .map(IdLocalizacionLocalDto::getId)
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
            paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
            paramPresenciasDetalle
                .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
            final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = this.ptrPresenciaAsyncService
                .presenciasDetalle(paramPresenciasDetalle);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);

            final PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
            if ((data != null) && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
              AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
              AsyncUtils.exceptionally(this.tareaLocalizacionPersonaPresenciaAsyncService
                  .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea,
                      TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA_INCLUIDOECOMMERCE
                          .getId()),
                  cf, cfPersist);
            }
          }
        }
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }

  }

  @Override
  public void presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(
      @NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TareaDto tarea = runTarea.getTarea();
      final PtrFilterPropertiesDto filter = this.presenciasProperties
          .get(PtrPropertiesConstants.PRESENCIA_DETALLE)
          .getFilter();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      // Obtencion de tipos de hora con flag repartido provincia
      final List<TareaTipoHoraDto> tiposHoras = this.tareaTipoHoraService
          .findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(tarea);
      // Obtencion de localizaciones que coincidan en cadena y provincia de las localizaciones del ambito
      final List<IdLocalizacionLocalDto> localizaciones = this.tareaLocalizacionHistoricoService
          .findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
              tarea.getId(),
              tareaAmbito.getCclIdOrigen(), empresasAmbito);
      final List<PeriodoDto> periodos = this.tareaLocalizacionPresupuestoService
          .findListaPeriodosPresupestoYTrabajo(
              tarea.getId(), filter, this.recolectarProperties);
      if (CollectionUtils.isNotEmpty(tiposHoras) && CollectionUtils.isNotEmpty(localizaciones)) {
        for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(localizaciones,
            filter.getMaxPageSize())) {
          for (final PeriodoDto periodo : periodos) {
            final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            // Obtencion de las presencias, unicamente las de tipo repartido provincia (horas
            // sindicales)
            final PtrPresenciaDetalleRequestDto paramPresenciasDetalle = this.tareaMapper
                .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(tarea,
                    tareaAmbito, periodo);
            paramPresenciasDetalle
                .setEmpresa(
                    empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
            paramPresenciasDetalle.setTienda(iter.stream()
                .map(IdLocalizacionLocalDto::getId)
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
            paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
            paramPresenciasDetalle.setTipo(tiposHoras.stream()
                .map(TareaTipoHoraDto::getIdTipoHora)
                .collect(Collectors.toList()));
            paramPresenciasDetalle
                .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
            final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = this.ptrPresenciaAsyncService
                .presenciasDetalle(paramPresenciasDetalle);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);

            final PtrPresenciaDetalleResponseDto data = AsyncUtils.get(cfData);
            if ((data != null) && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
              AsyncUtils.checkAsyncAvaliable(cfPersist, filter.getMaxPersistenceSize());
              AsyncUtils.exceptionally(this.tareaLocalizacionPersonaPresenciaAsyncService
                  .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea,
                      TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA_REPARTIDOPROVINCIA
                          .getId()),
                  cf, cfPersist);
            }

          }
        }
      }

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
