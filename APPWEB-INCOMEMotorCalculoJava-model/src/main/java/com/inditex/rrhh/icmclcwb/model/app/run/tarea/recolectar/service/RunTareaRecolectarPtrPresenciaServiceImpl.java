package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

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

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEmpleadoPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaServiceImpl implements RunTareaRecolectarPtrPresenciaService {

    @Autowired
    private Logger log;

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaTiendaPresenciaSeccionAsyncService tareaTiendaPresenciaSeccionAsyncService;

    @Autowired
    private TareaTipoHoraAsyncService tareaTipoHoraAsyncSevice;

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionAsyncService tareaTiendaEmpleadoPresenciaSeccionAsyncService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Auditoria
    @Override
    public void tiposHorasByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            tiposHorasByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    @Auditoria
    @Override
    public void tiposHorasByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService.tiposHoras(
                    PtrPresenciaTiposHorasRequestDto.builder().origen(Integer.parseInt(tareaAmbito.getIdCatalogo()))
                            .excluidoCalculo(Boolean.FALSE).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = AsyncUtils.get(cfData);
            if (data != null && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(tareaTipoHoraAsyncSevice.save(data.getTiposHoras(), tarea), cf);
            } else {
                // TODO No esta devolviendo tipos de hora para los origenes de la fase 1
                log.warn(new StringBuilder("No hay tipos de hora comisionables para el origen: ")
                        .append(tareaAmbito.getIdCatalogo()).toString());
//                    throw new PtrException(new StringBuilder("No hay tipos de hora comisionables para el origen: ")
//                            .append(tareaAmbito.getIdCatalogo()).toString());
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void presenciaTotalizadaTienda(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    // TODO Filtrar por origen
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA).getFilter()
                                    .getMaxPageSize())) {
                        List<Integer> tiendas = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                        PtrPresenciaTotalTiendaRequestDto paramPresenciasTotalTienda = tareaMapper
                                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasTotalTiendaRequestDto(
                                        trabajo, tarea, tareaAmbito);
                        paramPresenciasTotalTienda.setCadena(Integer.valueOf(cadena));
                        paramPresenciasTotalTienda.setTienda(tiendas);
//                        paramPresenciasTotalTienda.setAgruparSeccion(PtrConstants.AGRUPAR_SECCION_TRUE);+

                        CompletableFuture<PtrPresenciaTotalTiendaResponseDto> cfData = ptrPresenciaAsyncService
                                .presenciasTotalTienda(paramPresenciasTotalTienda);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);

                        PtrPresenciaTotalTiendaResponseDto data = cfData.get();
                        if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTotalTienda())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasProperties
                                    .get(PtrConstants.PRESENCIA_TOTAL_TIENDA).getFilter().getMaxPersistenceSize());
                        }
                    }
                }
            }

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void presenciaTotalizadaTiendaSeccion(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                    // TODO Filtrar por origen
                    for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                            presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter()
                                    .getMaxPageSize())) {
                        List<PtrPresenciaTiendaSeccionDto> tiendas = iter.stream().map(
                                item -> PtrPresenciaTiendaSeccionDto.builder().tienda(Integer.valueOf(item)).build())
                                .collect(Collectors.toList());
                        PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = tareaMapper
                                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(
                                        trabajo, tarea, tareaAmbito);
                        paramPresenciasTotalTiendaSeccion.setCadena(Integer.valueOf(cadena));
                        paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                        paramPresenciasTotalTiendaSeccion.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_TRUE);
                        // TODO Obtener las presencias comisionables por tipo de hora y excluido
                        // denominador

                        CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> cfData = ptrPresenciaAsyncService
                                .presenciasTotalTiendaSeccion(paramPresenciasTotalTiendaSeccion);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);

                        PtrPresenciaTotalTiendaSeccionResponseDto data = cfData.get();
                        if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTotalTiendaSeccion())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter()
                                            .getMaxPersistenceSize());
                            AsyncUtils.exceptionally(tareaTiendaPresenciaSeccionAsyncService
                                    .save(data.getPresenciasTotalTiendaSeccion(), tarea), cf, cfPersist);
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
    public void presenciaDetalleComisionable(@Valid final RunTareaDto runTarea,
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
                            presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter()
                                    .getMaxPageSize())) {
                        List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                        PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = tareaMapper
                                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleComisionableRequestDto(
                                        trabajo, tarea, tareaAmbito);
                        paramPresenciasDetalleComisionable.setPersona(empleados);
                        paramPresenciasDetalleComisionable.setCadena(Integer.valueOf(cadena));
                        paramPresenciasDetalleComisionable.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_TRUE);

                        CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> cfData = ptrPresenciaAsyncService
                                .presenciasDetalleComisionable(paramPresenciasDetalleComisionable);
                        AsyncUtils.exceptionally(cfData, cf, cfPersist);

                        PtrPresenciaDetalleComisionableResponseDto data = cfData.get();
                        if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalleComisionable())) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist,
                                    presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter()
                                            .getMaxPersistenceSize());
                            AsyncUtils.exceptionally(tareaTiendaEmpleadoPresenciaSeccionAsyncService
                                    .save(data.getPresenciasDetalleComisionable(), tarea), cf, cfPersist);

                            if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())
                                    || CollectionUtils.isNotEmpty(tarea.getPersona())) {
                                runTareaRecolectarBloque.getTiendaPresencia()
                                        .addAll(data.getPresenciasDetalleComisionable().stream()
                                                .map(item -> new StringBuilder(AppConstants.PREFIJO_TIENDA_META4)
                                                        .append(item.getTienda()).toString())
                                                .collect(Collectors.toSet()));
                            }
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

    @Override
    public void personaPresenciaDetalleComisionableByAmbitoAndLocalizacion(@Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {

                PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleComisionableRequestDto(
                                trabajo, tarea, tareaAmbito);
                CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasDetalleComisionable(paramPresenciasDetalleComisionable);
                AsyncUtils.exceptionally(cfData, cf);

                PtrPresenciaDetalleComisionableResponseDto data = AsyncUtils.get(cfData);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}