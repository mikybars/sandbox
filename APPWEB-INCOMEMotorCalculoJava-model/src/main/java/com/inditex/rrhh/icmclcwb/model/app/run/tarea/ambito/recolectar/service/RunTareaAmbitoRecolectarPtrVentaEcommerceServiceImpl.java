package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAgrupacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionOperacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionCadenaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionOnlineHistoricoService;
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
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
public class RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl implements RunTareaAmbitoRecolectarPtrVentaEcommerceService{

    
    @Autowired
    private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

    @Autowired
    private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

    @Autowired
    private TareaAgrupacionVentaAsyncService tareaAgrupacionVentaAsyncService;
    
    @Autowired
    private TareaLocalizacionPersonaVentaAsyncService tareaLocalizacionPersonaVentaAsyncService;

    @Autowired

    private TareaLocalizacionOperacionVentaAsyncService tareaOperacionLocalizacionVentaAsyncService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private TareaLocalizacionOnlineHistoricoService tareaLocalizacionOnlineHistoricoService;

    @Autowired
    private TareaAgrupacionCadenaService tareaAgrupacionCadenaService;

    @Autowired
    private TareaMapper tareaMapper;
    
    @Autowired
    @Qualifier("ventaEcommerceProperties")
    protected Map<String, PtrPropertiesDto> ventaEcommerceProperties;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;
    
    @Override
    public void ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(
            @Valid final RunTareaDto runTarea, @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<TareaAgrupacionCadenasDto> agrupaciones = tareaAgrupacionCadenaService.findAgrupacionesByTarea(tarea);
            Long idTarea = runTarea.getTarea().getId();
            String idOrigen = tareaAmbito.getIdOrigen();
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndIdOrigen(idTarea, idOrigen,
                Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_AGRUPACION_CADENA.getId()));
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = tareaMapper
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(trabajo,
                    tarea, tareaAmbito, recolectarProperties, cadenas);
            paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
            paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
            paramVentaOnlineEntregaDomicilio.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

            CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);

            AsyncUtils.exceptionally(cfData, cf, cfPersist);

            PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);

            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO)
                .getFilter().getMaxPersistenceSize());
            AsyncUtils.exceptionally(tareaAgrupacionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data, tarea, agrupaciones), cf,
                cfPersist);

            AsyncUtils.waitAllOfIsOk(cf, cf);
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
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService
                .findIdCadenaDtoByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen(),
                    Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_TIENDA_LOCALIZACION_SECCION.getId()));
            LocalizacionesAmbito localizaciones = findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea, tareaAmbito);
            if (cadenas.size() > 0 && localizaciones.hasData()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineEntregaTienda
                    .setCadena(cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineEntregaTienda.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineEntregaTienda.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                paramVentaOnlineEntregaTienda.setTienda(localizaciones.getLocalizaciones());

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
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService
                .findIdCadenaDtoByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen(),
                    Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId()));
            LocalizacionesAmbito localizaciones = findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea, tareaAmbito);
            if (cadenas.size() > 0 && localizaciones.hasData()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlinePicking
                        .setCadena(cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlinePicking.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                paramVentaOnlinePicking.setTienda(localizaciones.getLocalizaciones());

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
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService
                .findIdCadenaDtoByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen(),
                    Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId()));
            LocalizacionesAmbito localizaciones = findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea, tareaAmbito);
            if (cadenas.size() > 0 && localizaciones.hasData()) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlineIpod.setCadena(cadenas.stream().map(IdCadenaDto::getId)
                        .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineIpod.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                paramVentaOnlineIpod.setTienda(localizaciones.getLocalizaciones());

                CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPod(paramVentaOnlineIpod);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD)
                        .getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(
                        tareaLocalizacionVentaAsyncService.savePtrVentaOnlineIpodResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaOnlineIpodDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                tareaLocalizacionOnlineHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(tarea.getId(), tareaAmbito.getIdOrigen(),
                    Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_PERSONA.getId())),
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
                AsyncUtils.exceptionally(tareaLocalizacionPersonaVentaAsyncService
                        .savePtrVentaOnlineIpodIndividualDetalleResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaOnlineIpodDetalleLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                tareaLocalizacionOnlineHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(tarea.getId(), tareaAmbito.getIdOrigen(),
                    Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_OPERACION_LOCALIZACION.getId())),
                ventaEcommerceProperties.get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter()
                    .getMaxPageSize())) {
                PtrVentaOnlineIpodIndividualDetalleRequestDto paramVentaOnlineIpodIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties);
                paramVentaOnlineIpodIndividualDetalle.setTiendaOnline(iter.stream().map(IdLocalizacionLocalDto::getId)
                    .map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpodIndividualDetalle.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);
                paramVentaOnlineIpodIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineIpodIndividualDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());

                CompletableFuture<PtrVentaOnlineIpodIndividualDetalleResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineiPodIndividualDetalle(paramVentaOnlineIpodIndividualDetalle);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineIpodIndividualDetalleResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_IPOD_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaLocalizacionVentaAsyncService
                        .savePtrVentaOnlineIpodIndividualDetalleResponse(data, tarea), cf, cfPersist);
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @Override
    public void ventaOnlineIpodDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
                tareaLocalizacionOnlineHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(tarea.getId(), tareaAmbito.getIdOrigen(),
                    Arrays.asList(TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.IMPORTE_VENTA_ONLINE_IPOD_INDIVIDUAL_OPERACION_LOCALIZACION.getId())),
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

    private LocalizacionesAmbito findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(RunTareaDto runTarea, TareaAmbitoDto tareaAmbito) {
        LocalizacionesAmbito result = new LocalizacionesAmbito(runTarea.getTrabajo().getTipoAmbito().getId());
        if (result.obtenerLocalizaciones()) {
            result.setLocalizaciones(tareaLocalizacionHistoricoService
                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea.getTarea().getId(), tareaAmbito.getIdOrigen()));
        }
        return result;
    }

    private class LocalizacionesAmbito {

        @Getter
        List<Integer> localizaciones = null;

        Long idAmbito;

        public LocalizacionesAmbito(Long idAmbito) {
            this.idAmbito = idAmbito;
        }

        public void setLocalizaciones(List<IdLocalizacionLocalDto> ids) {
            if (ids != null) {
                localizaciones = ids.stream().map(IdLocalizacionLocalDto::getId)
                    .map(Integer::valueOf).collect(Collectors.toList());
            }
        }

        public boolean obtenerLocalizaciones() {
            return TipoAmbitoEnum.PERSONA.getId().equals(idAmbito) ||
                TipoAmbitoEnum.LOCALIZACION.getId().equals(idAmbito);
        }

        public boolean hasData() {
            return !obtenerLocalizaciones() || (localizaciones != null && localizaciones.size() > 0);
        }

    }

}
