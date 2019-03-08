package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaRecolectarPtrVentaEcommerceServiceImpl implements RunTareaRecolectarPtrVentaEcommerceService {

    @Autowired
    private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("ventaEcommerceProperties")
    protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;
    
    @Auditoria
    @Override
    public void ventaOnlineIpodIndividualDetalle(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    //TODO: Se particiona por tienda? ¿Nos traeremos tiendas online ?
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter()
                                    .getMaxPageSize())) {
                        //TODO : Parametrizar correctamente la request.
                        PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = 
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(trabajo, tarea, tareaAmbito);
                        paramVentaOnlineIpodIndividualDetalle.setCadena(Integer.valueOf(cadena));
                        //TODO: Ver si funciona con tienda + tiendaOnline, etc
                        paramVentaOnlineIpodIndividualDetalle.setTienda(iter.stream().map(Integer::valueOf).collect(Collectors.toList()));
                        //TODO: Ver agrupación entre: OPERACION_FECHA_VENDEDOR_TIENDA y OPERACION_FECHA_VENDEDOR_TIENDA_SECCION
                        paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA);
                        CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> cfData = ptrVentaEcommerceAsyncService
                                .ventaOnlineiPodIndividualDetalle(paramVentaOnlineIpodIndividualDetalle);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);

                        PtrVentaOnlineIpodIndividualDetalleResponseDto data = cfData.get();

                        if (data != null && CollectionUtils.isNotEmpty(data.getVentaOnlineIpodIndividual())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                                    .get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                            // TODO PERSISTIR
                        }
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineiPod(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    //TODO: Se particiona por tienda?
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD).getFilter()
                                    .getMaxPageSize())) {
                        //TODO : Parametrizar correctamente la request.
                        PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea, tareaAmbito);
                        paramVentaOnlineIpod.setCadena(Integer.valueOf(cadena));
                        //TODO: Ver si funciona con tienda + tiendaOnline, etc
                        paramVentaOnlineIpod.setTienda(iter.stream().map(Integer::valueOf).collect(Collectors.toList()));
                        //TODO: Ver agrupación correcta.
                        paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                        
                        CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = ptrVentaEcommerceAsyncService
                                .ventaOnlineiPod(paramVentaOnlineIpod);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);
                        
                        PtrVentaOnlineIpodResponseDto data = cfData.get();

                        if (data != null && CollectionUtils.isNotEmpty(data.getVentaOnline())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                                    .get(PtrConstants.VENTA_ONLINE_IPOD).getFilter().getMaxPersistenceSize());
                            // TODO PERSISTIR
                        }
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlinePicking(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    //TODO: Se particiona por tienda?
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_PICKING).getFilter()
                                    .getMaxPageSize())) {
                        //TODO : Parametrizar correctamente la request.
                        PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = 
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea, tareaAmbito);
                        paramVentaOnlinePicking.setCadena(Integer.valueOf(cadena));
                        //TODO: Ver si funciona con tienda + tiendaOnline, etc
                        paramVentaOnlinePicking.setTienda(iter.stream().map(Integer::valueOf).collect(Collectors.toList()));
                        //TODO: Ver agrupación correcta.
                        paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                        
                        CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = ptrVentaEcommerceAsyncService
                                .ventaOnlinePicking(paramVentaOnlinePicking);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);
                        
                        PtrVentaOnlinePickingResponseDto data = cfData.get();
                        
                        if (data != null && CollectionUtils.isNotEmpty(data.getVentaOnline())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                                    .get(PtrConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPersistenceSize());
                            // TODO PERSISTIR
                        }
                        
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineEntregaTienda(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    //TODO: Se particiona por tienda?
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter()
                                    .getMaxPageSize())) {
                        //TODO : Parametrizar correctamente la request.
                        PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = 
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo, tarea, tareaAmbito);
                        paramVentaOnlineEntregaTienda.setCadena(Integer.valueOf(cadena));
                        //TODO: Ver si funciona con tienda + tiendaOnline, etc
                        paramVentaOnlineEntregaTienda.setTienda(iter.stream().map(Integer::valueOf).collect(Collectors.toList()));
                        //TODO: Ver agrupación correcta.
                        paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                        
                        CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData = ptrVentaEcommerceAsyncService
                                .ventaOnlineEntregaTienda(paramVentaOnlineEntregaTienda);
                        
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);
                        
                        PtrVentaOnlineEntregaTiendaResponseDto data = cfData.get();
                        
                        if (data != null && CollectionUtils.isNotEmpty(data.getVentaOnline())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                                    .get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPersistenceSize());
                            // TODO PERSISTIR
                        }
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineEntregaDomicilio(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    //TODO: Se particiona por tienda?
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter()
                                    .getMaxPageSize())) {
                        //TODO : Parametrizar correctamente la request.
                        PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = 
                                tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(trabajo, tarea, tareaAmbito);
                        paramVentaOnlineEntregaDomicilio.setCadena(Integer.valueOf(cadena));
                        //TODO: Ver si funciona con tiendaOnline, etc
                        //TODO: Ver agrupación correcta.
                        paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                    
                        CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                                .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);
                        
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);
                        
                        PtrVentaOnlineEntregaDomicilioResponseDto data = cfData.get();
                        
                        if (data != null && CollectionUtils.isNotEmpty(data.getVentaOnline())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                                    .get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPersistenceSize());
                            // TODO PERSISTIR
                        }
                    }
                }
                AsyncUtils.waitAllOfIsOk(cf, cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}
