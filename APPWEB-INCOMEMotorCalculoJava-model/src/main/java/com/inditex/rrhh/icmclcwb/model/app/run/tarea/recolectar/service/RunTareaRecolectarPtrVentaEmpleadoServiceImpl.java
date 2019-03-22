package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

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

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaRecolectarPtrVentaEmpleadoServiceImpl implements RunTareaRecolectarPtrVentaEmpleadoService {

    @Autowired
    private PtrVentaEmpleadoAsyncService ptrVentaEmpleadoAsyncService;
    
    @Autowired
    private TareaEmpleadoHistoricoService tareaEmpleadoHistoricoService; 
   
    @Autowired
    private TareaMapper tareaMapper;
    
    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;
    
    
    @Auditoria
    @Override
    public void ventaFisicaDetalleLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaFisicaDetalleLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaFisicaDetalleOperacionLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaFisicaDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaFisicaDetalleOperacionVendedorLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    @Auditoria
    @Override
    public void ventaFisicaDetalleVendedorLocalizacionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            ventaFisicaDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    
    private void ventaFisicaDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaEmpleadoHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                //TODO: Cambiar por OPERACION_FECHA_TIENDA cuando esté disponible.
//                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_FALSE);
                //TODO Se necesita la cadena
                paramGetVentaIndividualDetalle.setCadena(1);
                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
               //TODO: Persistir
                
                if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties
                            .get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                    // TODO PERSISTIR
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaFisicaDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
    @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaEmpleadoHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_FALSE);
                //TODO Se necesita la cadena
                paramGetVentaIndividualDetalle.setCadena(1);
                
                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
               //TODO: Persistir
                
                if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties
                            .get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
                    // TODO PERSISTIR
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaFisicaDetalleOperacionVendedorLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaEmpleadoHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_FALSE);
                //TODO Se necesita la cadena
                paramGetVentaIndividualDetalle.setCadena(1);
                
                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
               //TODO: Persistir
                
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    private void ventaFisicaDetalleLocalizacionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid TareaAmbitoDto tareaAmbito){
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(
                    tareaEmpleadoHistoricoService.findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(),
                            tareaAmbito.getIdOrigen()),
                    ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramGetVentaIndividualDetalle.setVendedores(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
                //TODO: Cambiar por FECHA_TIENDA cuando esté disponible.
//                paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_TIENDA);
                paramGetVentaIndividualDetalle.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_FALSE);
                paramGetVentaIndividualDetalle.setCadena(Integer.valueOf(1));

                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                        .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);
               //TODO: Persistir
                
                if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties
                            .get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
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
    public void ventaDetalleEmpleado(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    // TODO Filtrar por origen
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getEmpleadoLocal(),
                            ventaEmpleadoProperties.get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter()
                                    .getMaxPageSize())) {
                        List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                        PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = tareaMapper
                                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(
                                        trabajo, tarea, tareaAmbito);
                        paramGetVentaIndividualDetalle.setVendedores(empleados);
                        paramGetVentaIndividualDetalle.setCadena(Integer.valueOf(cadena));
                        paramGetVentaIndividualDetalle.setAgrupacion(PtrGroupSellerTypeEnum.FECHA_VENDEDOR_TIENDA);

                        CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaEmpleadoAsyncService
                                .ventaIndividualDetalle(paramGetVentaIndividualDetalle);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);

                        PtrVentaIndividualDetalleResponseDto data = cfData.get();

                        if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, ventaEmpleadoProperties
                                    .get(PtrConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPersistenceSize());
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
