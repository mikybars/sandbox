package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaOperacionLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaOperacionPersonaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrVentaEmpleadoServiceImpl implements RunTareaAmbitoRecolectarPtrVentaEmpleadoService{

    @Autowired
    private PtrVentaEmpleadoAsyncService ptrVentaEmpleadoAsyncService;
    
    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoService; 
    
    @Autowired
    private TareaOperacionLocalizacionVentaAsyncService tareaOperacionLocalizacionVentaAsyncService;
   
    @Autowired
    private TareaOperacionPersonaLocalizacionVentaAsyncService tareaOperacionPersonaLocalizacionVentaAsyncService;

    @Autowired
    private TareaLocalizacionPersonaVentaAsyncService tareaLocalizacionPersonaVentaAsyncService;
    
    @Autowired
    private TareaMapper tareaMapper;
    
    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;
    
    @Override
    public void ventaFisicaDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrPropertiesConstants.BOOLEAN_INTEGER_FALSE);

                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaOperacionLocalizacionVentaAsyncService.savePtrVentaIndividualDetalleResponse(data, tarea), cf, cfPersist);

            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
    
    @Override
    public void ventaFisicaDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
    @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrPropertiesConstants.BOOLEAN_INTEGER_FALSE);
                
                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaLocalizacionPersonaVentaAsyncService.savePtrVentaIndividualDetalleResponseDto(data, tarea), cf, cfPersist);

            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
    
    @Override
    public void ventaFisicaDetalleOperacionVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaPersonaHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrPropertiesConstants.BOOLEAN_INTEGER_FALSE);

                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
                AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                AsyncUtils.exceptionally(tareaOperacionPersonaLocalizacionVentaAsyncService.savePtrVentaIndividualDetalleResponse(data, tarea), cf, cfPersist);
                
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
       
}
