package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrVentaGeneralServiceImpl
        implements RunTareaAmbitoRecolectarPtrVentaGeneralService {

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;

    @Autowired
    @Qualifier("recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Autowired
    private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;

    @Autowired
    private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private TareaAgrupacionVentaAsyncService tareaAgrupacionVentaAsyncService;

    @Autowired
    private TareaAgrupacionCadenaService tareaAgrupacionCadenaService;

    @Autowired
    private TareaLocalizacionPresupuestoVentaAsyncService tareaLocalizacionPresupuestoVentaAsyncService;

    @Autowired
    private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

    @Autowired
    private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Override
    public void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
                .findPeriodoPresupuestoYTrabajo(tarea.getId());
            final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
                .findIdEmpresaByIdTarea(tarea.getId())
                .stream()
                .map(IdEmpresaDto::getStdIdLegEnt)
                .collect(Collectors.toList());
            for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    this.tareaLocalizacionHistoricoService
                        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(tarea.getId(),
                                tareaAmbito.getCclIdOrigen(), empresasAmbito),
                    this.ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                        .getFilter()
                        .getMaxPageSize())) {
                final PtrVentaTotalizadoRequestDto request = this.tareaMapper
                    .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaTotalizadoRequestDto(tarea,
                            tareaAmbito, periodo, this.recolectarProperties);
                request.setTienda(iter.stream()
                    .map(IdLocalizacionLocalDto::getId)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));
                request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
                request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                request.setProducto(this.meta4IcmWsCalcIncomeSessionService
                    .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
                    .stream()
                    .map(e -> e.getIdProducto())
                    .collect(Collectors.toList()));

                final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = this.ptrVentaGeneralAsyncService
                    .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                final PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaGeneralProperties
                    .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                    .getFilter()
                    .getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        this.tareaLocalizacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea),
                        cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaFisicaCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
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
            final PeriodoDto periodo = this.tareaLocalizacionPresupuestoService
                .findPeriodoPresupuestoYTrabajo(tarea.getId());
            final List<TareaAgrupacionCadenasDto> agrupaciones = this.tareaAgrupacionCadenaService
                .findAgrupacionesByTarea(tarea);
            final List<IdCadenaDto> cadenas = this.tareaLocalizacionHistoricoService
                .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(), tareaAmbito.getCclIdOrigen());
            final PtrVentaTotalizadoRequestDto request = this.tareaMapper
                .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                        tarea, tareaAmbito, periodo, this.recolectarProperties, cadenas);

            request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
            request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
            request.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
            request.setProducto(this.meta4IcmWsCalcIncomeSessionService
                .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
                .stream()
                .map(e -> e.getIdProducto())
                .collect(Collectors.toList()));

            final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = this.ptrVentaGeneralAsyncService
                .ventaTotalizado(request);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);
            final PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
            AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaGeneralProperties
                .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                .getFilter()
                .getMaxPersistenceSize());
            AsyncUtils.exceptionally(
                    this.tareaAgrupacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea, agrupaciones), cf,
                    cfPersist);
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }


    @Override
    public void ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
                .findIdEmpresaByIdTarea(tarea.getId())
                .stream()
                .map(IdEmpresaDto::getStdIdLegEnt)
                .collect(Collectors.toList());
            for (final IdLocalizacionLocalPresupuestoDto iter : this.tareaLocalizacionHistoricoService
                .findTiendasPresupuestosByStdIdLegEntAndIdTarea(empresasAmbito, tarea.getId())) {
                final PtrVentaTotalizadoRequestDto request = this.tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
                            trabajo, tarea,
                            tareaAmbito, iter);
                request.setTienda(Arrays.asList(Integer.valueOf(iter.getId())));
                request.setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
                request.setAgrupacion(PtrGroupTypeEnum.OPERACION_TIENDA_SECCION);
                request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                request.setProducto(this.meta4IcmWsCalcIncomeSessionService
                    .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
                    .stream()
                    .map(e -> e.getIdProducto())
                    .collect(Collectors.toList()));
                final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = this.ptrVentaGeneralAsyncService
                    .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                final PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, this.ventaGeneralProperties
                    .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                    .getFilter()
                    .getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaTotalizadoResponse(data,
                                iter,
                                tarea),
                        cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
