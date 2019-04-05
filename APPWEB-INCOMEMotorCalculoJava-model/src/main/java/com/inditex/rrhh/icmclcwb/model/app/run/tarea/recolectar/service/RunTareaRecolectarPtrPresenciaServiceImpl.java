package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEmpleadoPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTipoHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResultItemDto;
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
    private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaTiendaPresenciaSeccionAsyncService tareaTiendaPresenciaSeccionAsyncService;

    @Autowired
    private TareaTipoHoraAsyncService tareaTipoHoraAsyncSevice;
    
    @Autowired
    private TareaEmpleadoHistoricoService tareaEmpleadoHistoricoService;
    
    @Autowired
    private TareaTiendaHistoricoService tareaTiendaHistoricoService;
    
    @Autowired
    private TareaTiendaHistoricoAsyncService tareaTiendaHistoricoAsyncService;

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionAsyncService tareaTiendaEmpleadoPresenciaSeccionAsyncService;

    @Autowired
    private TareaMapper tareaMapper;
    
    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;
    
    @Autowired
    @Qualifier(value="recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

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
                                        trabajo, tarea, tareaAmbito, recolectarProperties);
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
                                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasTotalTiendaSecceionRequestDto(trabajo, tarea, tareaAmbito, recolectarProperties);
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
                // TODO Filtrar por origen
                for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getEmpleadoLocal(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter()
                                .getMaxPageSize())) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                    PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = tareaMapper
                            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleComisionableRequestDto(
                                    trabajo, tarea, tareaAmbito);
                    paramPresenciasDetalleComisionable.setPersona(empleados);
                    paramPresenciasDetalleComisionable.setEmpresa(Integer.valueOf(tarea.getIdEmpresa()));
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

                AsyncUtils.waitAllOfIsOk(cf, cf);

            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void presenciaTotalLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaTotalLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void presenciaTotalLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdLocalizacionLocalDto> iter : StreamUtils.partition(tareaTiendaHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(),
                    tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasTotalTiendaSecceionRequestDto(
                                trabajo, tarea, tareaAmbito, recolectarProperties);
                paramPresenciasTotalTiendaSeccion.setTiendaSeccion(iter.stream().map(e -> PtrPresenciaTiendaSeccionDto.builder().tienda(Integer.valueOf(e.getId())).build()).collect(Collectors.toList()));
                paramPresenciasTotalTiendaSeccion.setAgruparSeccion(PtrConstants.BOOLEAN_INTEGER_TRUE);


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
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }
    
    
    @Auditoria
    @Override
    public void presenciaDetalleComisionablePersonaByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }

    private void presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(tareaEmpleadoHistoricoService
                    .findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();

                PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciasDetalleComisionableRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramPresenciasDetalleComisionable.setPersona(iter.stream().map(IdPersonaLocalDto::getIdPersonaLocal).map(Integer::valueOf).collect(Collectors.toList()));
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
    public void presenciaTiendaEmpleadoByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            presenciaTiendaEmpleadoByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    private void presenciaTiendaEmpleadoByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<Integer> idTiendasGuardadas = null;
            for (List<IdPersonaLocalDto> iter : StreamUtils.partition(tareaEmpleadoHistoricoService
                    .findIdPersonaLocalByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen()),
                    presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getFilter().getMaxPageSize())) {
                List<CompletableFuture<?>> cfPersist = new ArrayList<>();
                
                PtrPresenciaTiendasEmpleadoRequestDto paramPresenciaTiendaEmpleado = tareaMapper
                        .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaTiendasEmpleadoRequestDto(
                                trabajo, tarea, tareaAmbito);
                paramPresenciaTiendaEmpleado.setPersona(iter.stream().map(e -> Integer.valueOf(StringUtils.trim(e.getIdPersonaLocal()))).collect(Collectors.toList()));
                CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> cfData = ptrPresenciaAsyncService
                        .presenciasTiendasEmpleado(paramPresenciaTiendaEmpleado);
                
                PtrPresenciaTiendasEmpleadoResponseDto data = cfData.get();
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                
                if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTiendasEmpleado())) {
                    if (idTiendasGuardadas == null) {
                        idTiendasGuardadas = tareaTiendaHistoricoService
                                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen()).stream()
                                .map(x -> Integer.parseInt(x.getId())).collect(Collectors.toList());
                    }
                    List<Integer> idTiendasSinGuardar = new ArrayList<>();
                    for(PtrPresenciaTiendasEmpleadoResultItemDto presencia : data.getPresenciasTiendasEmpleado()) {
                        if (!idTiendasGuardadas.contains(presencia.getTienda()) && !idTiendasSinGuardar.contains(presencia.getTienda())) {
                            idTiendasSinGuardar.add(presencia.getTienda());
                        }
                    }
                    
                    if (CollectionUtils.isNotEmpty(idTiendasSinGuardar)) {
                        //Para las tiendas no guardadas se obtienen en Meta4 y se guardan
                        TiendasRequestDto tiendasRequest = new TiendasRequestDto();
                        tiendasRequest.setPage(meta4Properties.get(Meta4Constants.TIENDAS).getPage());
                        tiendasRequest.setData(tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToGenericFilterDto(trabajo, tarea, tareaAmbito));
                        tiendasRequest.getData().setItem(
                                idTiendasSinGuardar.stream()
                                .map(x -> {
                                    // No tenemos servicio para obtener tiendas a partir de id local, por lo que hacemos 
                                    // esta transformación bruta. En futuro tendremos un servicio a medida.
                                    StringBuilder sb = new StringBuilder("T").append(x);
                                    return GenericFilterParametersDto.builder().idLugarTrabajo(sb.toString()).build();
                                }).collect(Collectors.toList()));
                        // TODO Usamos el servicio de tiendas a partir de id universal, pero se sustituira en el futuro. 
                        // Este servicio no está devolviendo el origen, país o cadena.
                        CompletableFuture<List<GenericTiendaResultItemDto>> cfTiendas = meta4IcmWsCalcIncomeSessionAsyncService
                                .getTiendas(tiendasRequest);
                        AsyncUtils.exceptionally(cfTiendas, cf, cfPersist);
                        List<GenericTiendaResultItemDto> tiendas = cfTiendas.get();
                        if (CollectionUtils.isNotEmpty(tiendas)) {
                            AsyncUtils.checkAsyncAvaliable(cfPersist, 
                                    presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getFilter()
                                    .getMaxPersistenceSize());
                            CompletableFuture<Void> cfSave = tareaTiendaHistoricoAsyncService
                                    .saveGenericTiendaResultItemDto(tiendas, tarea);
                            AsyncUtils.exceptionally(cfSave, cf, cfPersist);
                            // Se pone en la lista de ids de tiendas guardadas, 
                            // para que no se guarden en la siguiente vuelta del bucle 
                            idTiendasGuardadas.addAll(idTiendasSinGuardar);
                        }
                    }
                    
                }
                
            }
            
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
        
    }
    
    @Auditoria
    @Override
    public void personaPresenciaDetalleComisionableByRunTarea(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        for (TareaAmbitoDto tareaAmbito : tarea.getAmbito()) {
            personaPresenciaDetalleComisionableByRunTareaAndTareaAmbito(runTarea, tareaAmbito);
        }
    }
    
    private void personaPresenciaDetalleComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea, 
            @NotNull @Valid final TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            //TODO llamada a nuevo metodo que devuelva las presencias de los empleados 
//            for (List<IdPersonaDto> iter : StreamUtils.partition(tareaEmpleadoHistoricoService
//                    .findIdPersonaByIdTareaAndIdOrigen(tarea.getId(), tareaAmbito.getIdOrigen()),
//                    presenciasProperties.get(PtrConstants.PRESENCIA_TIENDAS_EMPLEADO).getFilter().getMaxPageSize())) {
//                
//            }
            AsyncUtils.waitAllOfIsOk(cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}