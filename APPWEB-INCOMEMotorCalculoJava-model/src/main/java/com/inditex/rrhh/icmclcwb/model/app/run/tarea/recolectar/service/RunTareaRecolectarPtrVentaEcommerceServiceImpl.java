package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

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

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaOperacionLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
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
    private TareaTiendaVentaSeccionAsyncService tareaTiendaVentaSeccionAsyncService;
    
    @Autowired
    private TareaTiendaSeccionVentaAsyncService tareaTiendaSeccionVentaAsyncService;

    @Autowired
    private TareaLocalizacionVentaAsyncService tareaTiendaVentaAsyncService;

    @Autowired
    private TareaPersonaLocalizacionVentaAsyncService tareaPersonaLocalizacionVentaAsyncService;

    @Autowired
    private TareaOperacionLocalizacionVentaAsyncService tareaOperacionLocalizacionVentaAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("ventaEcommerceProperties")
    protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

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

    private void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(
            @Valid final RunTareaDto runTarea, @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter()
                            .getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineEntregaDomicilio.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaDomicilio.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                        .getFilter().getMaxPersistenceSize());
                //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                AsyncUtils.exceptionally(tareaTiendaVentaSeccionAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data, tarea), cf,
                        cfPersist);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                        .getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaTiendaSeccionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlineEntregaDomicilioLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter()
                            .getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaDomicilioRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrPropertiesConstants.BOOLEAN_INTEGER_FALSE);
                paramVentaOnlineEntregaDomicilio.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaDomicilio.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                        .getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaTiendaVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter()
                            .getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineEntregaTienda.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineEntregaTienda.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineEntregaTienda.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaTienda(paramVentaOnlineEntregaTienda);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineEntregaTiendaResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPersistenceSize());
                //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                AsyncUtils.exceptionally(
                        tareaTiendaVentaSeccionAsyncService.savePtrVentaOnlineEntregaTiendaResponse(data, tarea), cf,
                        cfPersist);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaTiendaSeccionVentaAsyncService.savePtrVentaOnlineEntregaTiendaResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlineEntregaTiendaLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter()
                            .getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineEntregaTienda.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                paramVentaOnlineEntregaTienda.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaTienda(paramVentaOnlineEntregaTienda);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineEntregaTiendaResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaTiendaVentaAsyncService.savePtrVentaOnlineEntregaTiendaResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlinePicking
                        .setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlinePicking.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlinePicking(paramVentaOnlinePicking);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlinePickingResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPersistenceSize());
                //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                AsyncUtils.exceptionally(
                        tareaTiendaVentaSeccionAsyncService.savePtrVentaOnlinePickingResponse(data, tarea), cf,
                        cfPersist);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaTiendaSeccionVentaAsyncService.savePtrVentaOnlinePickingResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlinePickingLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlinePicking
                        .setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                paramVentaOnlinePicking.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlinePicking(paramVentaOnlinePicking);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlinePickingResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_PICKING).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaTiendaVentaAsyncService.savePtrVentaOnlinePickingResponse(data, tarea),
                        cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlineIpodLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getFilter().getMaxPageSize())) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlineIpod.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA);
                paramVentaOnlineIpod.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPod(paramVentaOnlineIpod);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
                        .getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaTiendaVentaAsyncService.savePtrVentaOnlineIpodResponse(data, tarea), cf,
                        cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    private void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD).getFilter().getMaxPageSize())) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlineIpod.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineIpod.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPod(paramVentaOnlineIpod);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
                        .getFilter().getMaxPersistenceSize());
                //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                AsyncUtils.exceptionally(
                        tareaTiendaVentaSeccionAsyncService.savePtrVentaOnlineIpodResponse(data, tarea), cf, cfPersist);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
                        .getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaTiendaSeccionVentaAsyncService.savePtrVentaOnlineIpodResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void ventaOnlineIpodDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter()
                            .getMaxPageSize())) {
                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(
                        iter.stream().map(e -> e.getId()).map(e -> Integer.valueOf(e)).collect(Collectors.toList()));
                paramVentaOnlineIpodIndividualDetalle.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);

                CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPodIndividualDetalle(paramVentaOnlineIpodIndividualDetalle);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaPersonaLocalizacionVentaAsyncService
                        .savePtrVentaOnlineIpodIndividualDetalleResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void ventaOnlineIpodDetalleLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter()
                            .getMaxPageSize())) {
                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpodIndividualDetalle.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_TIENDA);

                CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPodIndividualDetalle(paramVentaOnlineIpodIndividualDetalle);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                //TODO Las dos siguientes líneas son respectivamente el guardado pivotado y sin pivotar
                AsyncUtils.exceptionally(tareaTiendaVentaSeccionAsyncService
                        .savePtrVentaOnlineIpodIndividualDetalleResponse(data, tarea), cf, cfPersist);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaTiendaSeccionVentaAsyncService
                        .savePtrVentaOnlineIpodIndividualDetalleResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    public void ventaOnlineIpodDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            // TODO Recuperar tiendas online
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                    Arrays.asList("4037", "9724").stream().map(e -> new IdLocalizacionLocalDto(e))
                            .collect(Collectors.toList()),
                    ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter()
                            .getMaxPageSize())) {
                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpodIndividualDetalle.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                // TODO: NO AGRUPA / DEVUELVE TIENDA

                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_TIENDA);
                paramVentaOnlineIpodIndividualDetalle.setAgruparSeccion(PtrPropertiesConstants.BOOLEAN_INTEGER_FALSE);
                CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPodIndividualDetalle(paramVentaOnlineIpodIndividualDetalle);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaOnlineIpodIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
                // TODO: Queda pendiente de agrupar
                // TODO: Agrupa bien pero no devuelve la tienda
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE)
                        .getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaOperacionLocalizacionVentaAsyncService.savePtrVentaOnlineIpodIndividualDetalleResponse(data, tarea), cf,
                        cfPersist);

            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
