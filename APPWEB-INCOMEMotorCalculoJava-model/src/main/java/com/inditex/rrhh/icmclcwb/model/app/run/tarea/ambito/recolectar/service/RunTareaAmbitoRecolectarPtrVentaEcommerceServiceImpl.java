package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
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

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
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
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
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
<<<<<<< HEAD

=======
>>>>>>> branch 'autodeploy.v1hito2' of https://axinic.central.inditex.grp/bitbucket/scm/icmclcwb/main.git
import lombok.Getter;

<<<<<<< HEAD
=======
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

>>>>>>> branch 'autodeploy.v1hito2' of https://axinic.central.inditex.grp/bitbucket/scm/icmclcwb/main.git
@Service
@Validated
public class RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl
        implements RunTareaAmbitoRecolectarPtrVentaEcommerceService {

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
            String idOrigen = tareaAmbito.getIdOrigen();
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndIdOrigen(idTarea,
                    idOrigen, TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId());
            if (CollectionUtils.isNotEmpty(cadenas)) {
<<<<<<< HEAD
       
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties, cadenas);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
                paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
                paramVentaOnlineEntregaDomicilio.setProducto(meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getIdCatalogo()).stream().map(e -> e.getIdProducto()).collect(Collectors.toList()));
    
                CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                        .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);
    
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
    
                PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);
    
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                        .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaAgrupacionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data,
                        tarea, agrupaciones), cf, cfPersist);
    
=======
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaDomicilioRequestDto paramVentaOnlineEntregaDomicilio = tareaMapper
                    .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                        trabajo, tarea, tareaAmbito, recolectarProperties, cadenas);
                paramVentaOnlineEntregaDomicilio.setAgrupacion(PtrGroupTypeEnum.FECHA_CADENA);
                paramVentaOnlineEntregaDomicilio.setAgruparSeccion(PtrAgruparSeccionEnum.FALSE.getValue());
                paramVentaOnlineEntregaDomicilio.setProducto(AppConstants.PRODUCTOS_COMISIONABLES);

                CompletableFuture<PtrVentaOnlineEntregaDomicilioResponseDto> cfData = ptrVentaEcommerceAsyncService
                    .ventaOnlineEntregaDomicilio(paramVentaOnlineEntregaDomicilio);

                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaOnlineEntregaDomicilioResponseDto data = AsyncUtils.get(cfData);

                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEcommerceProperties
                    .get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_DOMICILIO).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaAgrupacionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(data,
                    tarea, agrupaciones), cf, cfPersist);

>>>>>>> branch 'autodeploy.v1hito2' of https://axinic.central.inditex.grp/bitbucket/scm/icmclcwb/main.git
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
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndIdOrigen(
                    tarea.getId(), tareaAmbito.getIdOrigen(), TipoVentaConceptoEnum.ENTREGA_TIENDA.getId());
            LocalizacionesAmbito localizaciones = findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea,
                    tareaAmbito);
            
            if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineEntregaTiendaRequestDto(trabajo,
                                tarea, tareaAmbito, recolectarProperties);
   
                paramVentaOnlineEntregaTienda.setCadena(
                        cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineEntregaTienda.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineEntregaTienda.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineEntregaTienda.setProducto(meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getIdCatalogo()).stream().map(e -> e.getIdProducto()).collect(Collectors.toList()));
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
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndIdOrigen(
                    tarea.getId(), tareaAmbito.getIdOrigen(), TipoVentaConceptoEnum.SINT.getId());
            LocalizacionesAmbito localizaciones = findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea,
                    tareaAmbito);

            if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlinePickingRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlinePicking.setCadena(
                        cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlinePicking.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlinePicking.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlinePicking.setProducto(meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getIdCatalogo()).stream().map(e -> e.getIdProducto()).collect(Collectors.toList()));
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
            List<IdCadenaDto> cadenas = tareaLocalizacionHistoricoService.findIdCadenaDtoByIdTareaAndIdOrigen(
                    tarea.getId(), tareaAmbito.getIdOrigen(), TipoVentaConceptoEnum.IPOD.getId());
            LocalizacionesAmbito localizaciones = findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(runTarea,
                    tareaAmbito);
            if (CollectionUtils.isNotEmpty(cadenas) && localizaciones.hasData()) {
                PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaOnlineIpodRequestDto(trabajo, tarea,
                                tareaAmbito, recolectarProperties);
                paramVentaOnlineIpod.setCadena(
                        cadenas.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
                paramVentaOnlineIpod.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
                paramVentaOnlineIpod.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaOnlineIpod.setProducto(meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getIdCatalogo()).stream().map(e -> e.getIdProducto()).collect(Collectors.toList()));
                paramVentaOnlineIpod.setTienda(localizaciones.getLocalizaciones());

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

    private LocalizacionesAmbito findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(RunTareaDto runTarea,
            TareaAmbitoDto tareaAmbito) {
        LocalizacionesAmbito result = new LocalizacionesAmbito(runTarea.getTrabajo().getTipoAmbito().getId());
        if (result.obtenerLocalizaciones()) {
            result.setLocalizaciones(
                    tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(
                            runTarea.getTarea().getId(), tareaAmbito.getIdOrigen()));
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
                localizaciones = ids.stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf)
                        .collect(Collectors.toList());
            }
        }

        public boolean obtenerLocalizaciones() {
            return TipoAmbitoEnum.PERSONA.getId().equals(idAmbito)
                    || TipoAmbitoEnum.LOCALIZACION.getId().equals(idAmbito);
        }

        public boolean hasData() {
            return !obtenerLocalizaciones() || CollectionUtils.isNotEmpty(localizaciones);
        }

    }

}
