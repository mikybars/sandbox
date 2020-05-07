package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Override
    public void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            PeriodoDto periodo = tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(tarea.getId());
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService
                        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(tarea.getId(),
                                tareaAmbito.getCclIdOrigen()),
                    ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                PtrVentaTotalizadoRequestDto request = tareaMapper
                    .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaTotalizadoRequestDto(tarea,
                            tareaAmbito, periodo, recolectarProperties);
                request.setTienda(iter.stream()
                    .map(IdLocalizacionLocalDto::getId)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));
                request.setEmpresa(Integer.valueOf(tarea.getStdIdLegEnt()));
                request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                request.setProducto(meta4IcmWsCalcIncomeSessionService
                    .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
                    .stream()
                    .map(e -> e.getIdProducto())
                    .collect(Collectors.toList()));

                CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                    .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaGeneralProperties
                    .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                    .getFilter()
                    .getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaLocalizacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea),
                        cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaFisicaCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            PeriodoDto periodo = tareaLocalizacionPresupuestoService.findPeriodoPresupuestoYTrabajo(tarea.getId());
            List<TareaAgrupacionCadenasDto> agrupaciones = tareaAgrupacionCadenaService.findAgrupacionesByTarea(tarea);
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService
                .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(), tareaAmbito.getCclIdOrigen());
            PtrVentaTotalizadoRequestDto request = tareaMapper
                .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                        tarea, tareaAmbito, periodo, recolectarProperties, cadenas);
            request.setEmpresa(Integer.valueOf(tarea.getStdIdLegEnt()));
            request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
            request.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
            request.setProducto(meta4IcmWsCalcIncomeSessionService
                .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
                .stream()
                .map(e -> e.getIdProducto())
                .collect(Collectors.toList()));

            CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                .ventaTotalizado(request);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);
            PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaGeneralProperties
                .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                .getFilter()
                .getMaxPersistenceSize());
            AsyncUtils.exceptionally(
                    tareaAgrupacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea, agrupaciones), cf,
                    cfPersist);
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }


    @Override
    public void ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (IdLocalizacionLocalPresupuestoDto iter : tareaLocalizacionHistoricoService
                .findTiendasPresupuestosByIdTarea(tarea.getId())) {
                PtrVentaTotalizadoRequestDto request = tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaTotalizadoRequestDto(
                            trabajo, tarea,
                            tareaAmbito, iter, recolectarProperties);
                request.setTienda(Arrays.asList(Integer.valueOf(iter.getId())));
                request.setEmpresa(Integer.valueOf(tarea.getStdIdLegEnt()));
                request.setAgrupacion(PtrGroupTypeEnum.OPERACION_TIENDA_SECCION);
                request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                request.setProducto(meta4IcmWsCalcIncomeSessionService
                    .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
                    .stream()
                    .map(e -> e.getIdProducto())
                    .collect(Collectors.toList()));

                CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                    .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaGeneralProperties
                    .get(PtrPropertiesConstants.VENTA_TOTALIZADO)
                    .getFilter()
                    .getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaTotalizadoResponse(data, iter, tarea),
                        cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
