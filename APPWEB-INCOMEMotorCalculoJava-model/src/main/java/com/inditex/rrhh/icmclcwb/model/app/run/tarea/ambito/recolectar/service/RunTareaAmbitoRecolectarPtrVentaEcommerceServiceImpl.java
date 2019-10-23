package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionesAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl
        implements RunTareaAmbitoRecolectarPtrVentaEcommerceService {

    @Autowired
    private Logger log;
    
    @Autowired
    private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

    @Autowired
    private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

    @Autowired
    private TareaAgrupacionVentaAsyncService tareaAgrupacionVentaAsyncService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private TareaAgrupacionCadenaService tareaAgrupacionCadenaService;
    
    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("ventaEcommerceProperties")
    protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Override
    public void ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<TareaAgrupacionCadenasDto> agrupaciones = tareaAgrupacionCadenaService.findAgrupacionesByTarea(tarea);
            Long idTarea = runTarea.getTarea().getId();
            String cclIdOrigen = tareaAmbito.getCclIdOrigen();
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea,
                    cclIdOrigen);
            if (CollectionUtils.isNotEmpty(cadenas)) {
       
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties, cadenas);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
                paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
                
                // TODO [DAVIDTSO] Eliminar log y simplificar llamada
                log.info("Inicio :: ConfiguracionProductoVenta :: ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
                List<ConfiguracionProductoVentaResultItemDto> configuracionProductoVenta = meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen());
                log.info("ConfiguracionProductoVenta :: ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito :: {} :: {} :: Meta4 :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), configuracionProductoVenta);
                List<Integer> producto = configuracionProductoVenta.stream().map(e -> e.getIdProducto()).collect(Collectors.toList());
                log.info("ConfiguracionProductoVenta :: ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito :: {} :: {} :: List :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), producto);
                paramVentaOnlineEntregaDomicilio.setProducto(producto);
                log.info("ConfiguracionProductoVenta :: ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito :: {} :: {} :: Request :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), paramVentaOnlineEntregaDomicilio);
                log.info("Fin :: ConfiguracionProductoVenta :: ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
    
                CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);
    
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
    
                PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);
    
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaAgrupacionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data,
                        tarea, agrupaciones), cf, cfPersist);
    
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(
                    tarea.getId(), tareaAmbito.getCclIdOrigen(), TipoVentaConceptoEnum.ENTREGA_TIENDA.getId());

            LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(runTarea.getTrabajo().getTipoAmbito().getId());
            
            if(TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
                      || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
                localizaciones.setLocalizaciones(tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen()));
            }
                        
            if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
   
                paramVentaOnlineEntregaTienda.setCadena(
                        cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineEntregaTienda.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineEntregaTienda.setTienda(localizaciones.getLocalizaciones());
                
                // TODO [DAVIDTSO] Eliminar log y simplificar llamada
                log.info("Inicio :: ConfiguracionProductoVenta :: ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
                List<ConfiguracionProductoVentaResultItemDto> configuracionProductoVenta = meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen());
                log.info("ConfiguracionProductoVenta :: ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Meta4 :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), configuracionProductoVenta);
                List<Integer> producto = configuracionProductoVenta.stream().map(e -> e.getIdProducto()).collect(Collectors.toList());
                log.info("ConfiguracionProductoVenta :: ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: List :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), producto);
                paramVentaOnlineEntregaTienda.setProducto(producto);
                log.info("ConfiguracionProductoVenta :: ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Request :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), paramVentaOnlineEntregaTienda);
                log.info("Fin :: ConfiguracionProductoVenta :: ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());

                CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaTienda(paramVentaOnlineEntregaTienda);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineEntregaTiendaResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaLocalizacionVentaAsyncService.savePtrVentaOnlineEntregaTiendaResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(
                    tarea.getId(), tareaAmbito.getCclIdOrigen(), TipoVentaConceptoEnum.SINT.getId());

            LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(runTarea.getTrabajo().getTipoAmbito().getId());
            
            if(TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
                      || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
                localizaciones.setLocalizaciones(tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen()));
            }
            
            if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlinePicking.setCadena(
                        cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlinePicking.setTienda(localizaciones.getLocalizaciones());
                
                // TODO [DAVIDTSO] Eliminar log y simplificar llamada
                log.info("Inicio :: ConfiguracionProductoVenta :: ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
                List<ConfiguracionProductoVentaResultItemDto> configuracionProductoVenta = meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen());
                log.info("ConfiguracionProductoVenta :: ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Meta4 :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), configuracionProductoVenta);
                List<Integer> producto = configuracionProductoVenta.stream().map(e -> e.getIdProducto()).collect(Collectors.toList());
                log.info("ConfiguracionProductoVenta :: ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: List :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), producto);
                paramVentaOnlinePicking.setProducto(producto);
                log.info("ConfiguracionProductoVenta :: ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Request :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), paramVentaOnlinePicking);
                log.info("Fin :: ConfiguracionProductoVenta :: ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());

                CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlinePicking(paramVentaOnlinePicking);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlinePickingResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaLocalizacionVentaAsyncService.savePtrVentaOnlinePickingResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndCclIdOrigen(
                    tarea.getId(), tareaAmbito.getCclIdOrigen(), TipoVentaConceptoEnum.IPOD.getId());
            LocalizacionesAmbitoDto localizaciones = new LocalizacionesAmbitoDto(runTarea.getTrabajo().getTipoAmbito().getId());
            
            if(TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
                      || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
                localizaciones.setLocalizaciones(tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
                    runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen()));
            }
            if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlineIpod.setCadena(
                        cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineIpod.setTienda(localizaciones.getLocalizaciones());
                
                // TODO [DAVIDTSO] Eliminar log y simplificar llamada
                log.info("Inicio :: ConfiguracionProductoVenta :: ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());
                List<ConfiguracionProductoVentaResultItemDto> configuracionProductoVenta = meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen());
                log.info("ConfiguracionProductoVenta :: ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Meta4 :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), configuracionProductoVenta);
                List<Integer> producto = configuracionProductoVenta.stream().map(e -> e.getIdProducto()).collect(Collectors.toList());
                log.info("ConfiguracionProductoVenta :: ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: List :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), producto);
                paramVentaOnlineIpod.setProducto(producto);
                log.info("ConfiguracionProductoVenta :: ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {} :: Request :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen(), paramVentaOnlineIpod);
                log.info("Fin :: ConfiguracionProductoVenta :: ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito :: {} :: {}", tarea.getId(), tareaAmbito.getCclIdOrigen());

                CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPod(paramVentaOnlineIpod);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaLocalizacionVentaAsyncService.savePtrVentaOnlineIpodResponse(data, tarea),
                        cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
