package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrPresenciaServiceImpl
        extends AbstractRunTareaAmbitoRecolectarPtrPresenciaService
        implements RunTareaAmbitoRecolectarPtrPresenciaService {

    @Autowired
    private Logger log;

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaTipoHoraAsyncService tareaTipoHoraAsyncSevice;

    @Autowired
    private TareaLocalizacionHistoricoService tareaTiendaHistoricoService;

    @Autowired
    private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

    @Autowired
    private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeAsyncService;

    @Override
    protected String getFechaInicioPeriodo(final TareaDto tarea) {
        return tarea.getFechaInicioPeriodo().format(DateTimeFormatter.ofPattern(PtrConstants.DATE_FORMAT));
    }

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Override
    public void tiposHorasByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        Integer idCatalogo = null;
        try {
            final TareaDto tarea = runTarea.getTarea();
            // Si el origen es españa hay que obtener el id de catalogo y pasarlo al servicio PTR
            if (AppConstants.ID_ORIGEN_SPAIN.equals(tareaAmbito.getCclIdOrigen())) {
                final CompletableFuture<CatalogoResponseDto> cfCatalogo = this.meta4IcmWsCalcIncomeAsyncService
                    .getCatalogo(CatalogoRequestDto
                        .builder()
                        .cclIdOrigen(tareaAmbito.getCclIdOrigen())
                        .items(Arrays
                            .asList(CatalogoRequestItemDto
                                .builder()
                                .stdIdLegEnt(runTarea.getTarea().getStdIdLegEnt())
                                .build()))
                        .build());
                AsyncUtils.exceptionally(cfCatalogo, cf);
                final CatalogoResponseDto catalogo = AsyncUtils.get(cfCatalogo);
                if (catalogo != null && CollectionUtils.isNotEmpty(catalogo.getItems())
                        && StringUtils.isNotBlank(catalogo.getItems().get(0).getIdCatalogo())) {
                    idCatalogo = Integer.parseInt(catalogo.getItems().get(0).getIdCatalogo());
                }
            }

            final CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = this.ptrPresenciaAsyncService
                .tiposHoras(PtrPresenciaTiposHorasRequestDto.builder()
                    .origen(Integer.parseInt(tareaAmbito.getCclIdOrigen()))
                    .idCatalogAplicacion(idCatalogo)
                    .build());
            AsyncUtils.exceptionally(cfData, cf);
            final PtrPresenciaTiposHorasResponseDto data = AsyncUtils.get(cfData);
            if ((data != null) && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(this.tareaTipoHoraAsyncSevice.save(data.getTiposHoras(), tarea), cf);
            } else {
                this.log.warn("No hay tipos de hora comisionables para el origen: {}", tareaAmbito.getCclIdOrigen());
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
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
            final List<IdLocalizacionLocalDto> ficticias = this.tareaTiendaHistoricoService
                .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(tareaAmbito.getCclIdOrigen(), PtrConstants.EMPRESA_0);
            final List<IdLocalizacionLocalDto> localizaciones = this.tareaTiendaHistoricoService
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
                            .savePtrPresenciaDetalle(data.getPresenciasDetalle(), tarea), cf, cfPersist);
                    }
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }

    }

}
