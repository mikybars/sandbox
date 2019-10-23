package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
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
    private Logger log;
    
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
    private TipoDatoService tipoDatoService;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Override
    public void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<IdTipoDatoDto> idsTipoDato = tipoDatoService
                    .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    tareaLocalizacionHistoricoService
                            .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(tarea.getId(),
                                    tareaAmbito.getCclIdOrigen(),
                                    idsTipoDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList())),
                    ventaGeneralProperties.get(PtrPropertiesConstants.VENTA_TOTALIZADO).getFilter().getMaxPageSize())) {
                PtrVentaTotalizadoRequestDto request = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaTotalizadoRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                request.setTienda(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf)
                        .collect(Collectors.toList()));
                request.setEmpresa(Integer.valueOf(tarea.getStdIdLegEnt()));
                request.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                request.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                
                // TODO [DAVIDTSO] Eliminar log y simplificar llamada
                log.info("Inicio :: ConfiguracionProductoVenta :: ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
                List<ConfiguracionProductoVentaResultItemDto> configuracionProductoVenta = meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen());
                log.info("ConfiguracionProductoVenta :: ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Meta4 :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), configuracionProductoVenta);
                List<Integer> producto = configuracionProductoVenta.stream().map(e -> e.getIdProducto()).collect(Collectors.toList());
                log.info("ConfiguracionProductoVenta :: ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: List :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), producto);
                request.setProducto(producto);
                log.info("ConfiguracionProductoVenta :: ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Request :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), request);
                log.info("Fin :: ConfiguracionProductoVenta :: ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
                
                CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                        .ventaTotalizado(request);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaGeneralProperties
                        .get(PtrPropertiesConstants.VENTA_TOTALIZADO).getFilter().getMaxPersistenceSize());
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
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<TareaAgrupacionCadenasDto> agrupaciones = tareaAgrupacionCadenaService.findAgrupacionesByTarea(tarea);
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService
                    .findIdCadenaDtoByIdTareaAndCclIdOrigen(tarea.getId(), tareaAmbito.getCclIdOrigen());
            PtrVentaTotalizadoRequestDto request = tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(trabajo,
                            tarea, tareaAmbito, recolectarProperties, cadenas);
            request.setEmpresa(Integer.valueOf(tarea.getStdIdLegEnt()));
            request.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
            request.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
            
            // TODO [DAVIDTSO] Eliminar log y simplificar llamada
            log.info("Inicio :: ConfiguracionProductoVenta :: ventaFisicaCadenaByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
            List<ConfiguracionProductoVentaResultItemDto> configuracionProductoVenta = meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen());
            log.info("ConfiguracionProductoVenta :: ventaFisicaCadenaByRunTareaAndTareaAmbito :: {} :: {} :: Meta4 :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), configuracionProductoVenta);
            List<Integer> producto = configuracionProductoVenta.stream().map(e -> e.getIdProducto()).collect(Collectors.toList());
            log.info("ConfiguracionProductoVenta :: ventaFisicaCadenaByRunTareaAndTareaAmbito :: {} :: {} :: List :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), producto);
            request.setProducto(producto);
            log.info("ConfiguracionProductoVenta :: ventaFisicaCadenaByRunTareaAndTareaAmbito :: {} :: {} :: Request :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), request);
            log.info("Fin :: ConfiguracionProductoVenta :: ventaFisicaCadenaByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
            
            CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaGeneralAsyncService
                    .ventaTotalizado(request);
            AsyncUtils.exceptionally(cfData, cf, cfPersist);
            PtrVentaTotalizadoResponseDto data = AsyncUtils.get(cfData);
            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaGeneralProperties
                    .get(PtrPropertiesConstants.VENTA_TOTALIZADO).getFilter().getMaxPersistenceSize());
            AsyncUtils.exceptionally(
                    tareaAgrupacionVentaAsyncService.savePtrVentaTotalizadoResponse(data, tarea, agrupaciones), cf,
                    cfPersist);
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
