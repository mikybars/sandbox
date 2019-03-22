package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
    public void ventaOnlineIpodDetalleLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineIpodDetalleLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineIpodDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineIpodDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineIpodLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineIpodLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineIpodLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlinePickingLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlinePickingLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlinePickingLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineEntregaTiendaLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineEntregaTiendaLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaOnlineEntregaDomicilioLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaOnlineEntregaDomicilioLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    private void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineEntregaDomicilio.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));

                //TODO Se necesita el producto
                paramVentaOnlineEntregaDomicilio.setProducto(Arrays.asList(1,2,3,4,5));

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
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlineEntregaDomicilioLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                paramVentaOnlineEntregaDomicilio.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));

                //TODO Se necesita el producto
                paramVentaOnlineEntregaDomicilio.setProducto(Arrays.asList(1,2,3,4,5));
                CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                
                PtrVentaOnlineEntregaDomicilioResponseDto data = cfData.get();
                
                //TODO: Ver como se reparte
                
                if (data != null && CollectionUtils.isNotEmpty(data.getVentaOnline())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                            .get(PtrConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPersistenceSize());
                    // TODO PERSISTIR
                }
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineEntregaTienda.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                
                //TODO Se necesita el producto
                paramVentaOnlineEntregaTienda.setProducto(Arrays.asList(1,2,3,4,5));
                
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
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlineEntregaTiendaLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineEntregaTienda.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                //TODO Se necesita el producto
                paramVentaOnlineEntregaTienda.setProducto(Arrays.asList(1,2,3,4,5));

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
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlinePicking.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                
                //TODO Se necesita el producto
                paramVentaOnlinePicking.setProducto(Arrays.asList(1,2,3,4,5));
                
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
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlinePickingLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlinePicking.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                //TODO Se necesita el producto
                paramVentaOnlinePicking.setProducto(Arrays.asList(1,2,3,4,5));
                
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
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlineIpodLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD).getFilter().getMaxPageSize())) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineIpod.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                //TODO Se necesita el producto
                paramVentaOnlineIpod.setProducto(Arrays.asList(1,2,3,4,5));
                
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD).getFilter().getMaxPageSize())) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineIpod.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer:: valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                
                //TODO Se necesita el producto
                paramVentaOnlineIpod.setProducto(Arrays.asList(1,2,3,4,5));
                
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
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
    
    
    public void ventaOnlineIpodDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea(); 
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(iter.stream().map(e->e.getId()).map(e->Integer.valueOf(e)).collect(Collectors.toList()));
                //TODO: Se necesita el producto
                paramVentaOnlineIpodIndividualDetalle.setProducto(Arrays.asList(1,2,3,4,5));
                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);
                    
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    public void ventaOnlineIpodDetalleLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                //TODO: Se necesita el producto
                paramVentaOnlineIpodIndividualDetalle.setProducto(Arrays.asList(1,2,3,4,5));
                //TODO: Cambiar por FECHA_TIENDA cuando exista
//                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_TIENDA);
                    
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
            
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    public void ventaOnlineIpodDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(Arrays.asList("4037", "9724").stream().map(e-> new IdLocalizacionLocalDto(e)).collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = 
                        tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(trabajo, tarea, tareaAmbito);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                //TODO: Se necesita el producto
                paramVentaOnlineIpodIndividualDetalle.setProducto(Arrays.asList(1,2,3,4,5));

                //TODO: Cambiar por OPERACION_FECHA_TIENDA cuando exista
//                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);
//                paramVentaOnlineIpodIndividualDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_TRUE);
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
            AsyncUtils.waitAllOfIsOk(cf, cf);
            
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
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
                        //TODO: Se necesita el producto
                        paramVentaOnlineEntregaTienda.setProducto(Arrays.asList(1,2,3,4,5));
                        
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
