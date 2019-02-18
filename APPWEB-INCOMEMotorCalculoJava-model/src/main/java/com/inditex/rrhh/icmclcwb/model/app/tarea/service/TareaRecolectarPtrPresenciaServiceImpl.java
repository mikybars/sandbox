package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

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

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.TareaAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.exception.PtrException;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaEmpleadoPresenciaSeccionRepository;

@Service
@Validated
public class TareaRecolectarPtrPresenciaServiceImpl implements TareaRecolectarPtrPresenciaService {

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TareaTiendaSeccionPresenciaService tareaTiendaSeccionPresenciaService;

    @Autowired
    private TareaTipoHoraService tareaTipoHoraSevice;

    @Autowired
    private TareaTiendaSeccionEmpleadoPresenciaService tareaTiendaSeccionEmpleadoPresenciaService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaTiendaEmpleadoPresenciaSeccionRepository tareaTiendaEmpleadoPresenciaSeccionRepository;
    
    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @TareaAuditoria
    @Override
    public void tiposHoras(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService.getTiposHoras(
                    PtrPresenciaTiposHorasRequestDto.builder().origen(Integer.parseInt(tarea.getIdPaisOrigen()))
                            .excluidoCalculo(Boolean.FALSE).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = cfData.get();
            if (data != null && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(tareaTipoHoraSevice.save(data.getTiposHoras(), tarea), cf);
                data.getTiposHoras().stream().forEach(item -> {
                    if (Boolean.FALSE.equals(item.getExcluidoCalculo())) {
                        runTareaRecolectarBloque.getTipoHoraComisionable().add(item.getTipoHora());
                        if (Boolean.FALSE.equals(item.getExcluidoDenom())) {
                            runTareaRecolectarBloque.getTipoHoraComisionableDenominador().add(item.getTipoHora());
                        }
                    }
                });
            } else {
                throw new PtrException(new StringBuilder("No hay tipos de hora comisionables para el origen: ")
                        .append(tarea.getIdPaisOrigen()).toString());
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @TareaAuditoria
    @Override
    public void presenciaTotalizadaTienda(@Valid TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getTiendaMtu(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxPageSize())) {
                    List<PtrPresenciaTiendaSeccionDto> tiendas = iter.stream()
                            .map(item -> PtrPresenciaTiendaSeccionDto.builder().tienda(Integer.valueOf(item)).build())
                            .collect(Collectors.toList());

                    PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = tareaMapper
                            .tareaDtoToPtrPresenciasTotalTiendaSeccionRequestDto(tarea);
                    paramPresenciasTotalTiendaSeccion.setCadena(Integer.valueOf(cadena));
                    paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                    // TODO Obtener las presencias comisionables por tipo de hora y excluido
                    // denominador

                    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasTotalTiendaSeccionDto(paramPresenciasTotalTiendaSeccion);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaTotalTiendaSeccionResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTotalTiendaSeccion())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(tareaTiendaSeccionPresenciaService
                                .save(data.getPresenciasTotalTiendaSeccion(), tarea), cf, cfPersist);
                    }
                }

            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @TareaAuditoria
    @Override
    public void presenciaDetalleEmpleado(@Valid TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runTareaRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runTareaRecolectarBloque.getEmpleadoLocal(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter().getMaxPageSize())) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                    PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = tareaMapper
                            .tareaDtoToPtrPresenciasDetalleComisionableRequestDto(tarea);
                    paramPresenciasDetalleComisionable.setPersona(empleados);
                    paramPresenciasDetalleComisionable.setCadena(Integer.valueOf(cadena));

                    CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasDetalleComisionableDto(paramPresenciasDetalleComisionable);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);

                    PtrPresenciaDetalleComisionableResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalleComisionable())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(
                                tareaTiendaSeccionEmpleadoPresenciaService.save(data.getPresenciasDetalleComisionable(), tarea),
                                cf, cfPersist);

                        if (CollectionUtils.isNotEmpty(tarea.getTiendas())
                                || CollectionUtils.isNotEmpty(tarea.getEmpleados())) {
                            runTareaRecolectarBloque
                                    .getTiendaPresencia().addAll(
                                            data.getPresenciasDetalleComisionable().stream()
                                                    .map(item -> new StringBuilder(AppConstants.PREFIJO_TIENDA_META4)
                                                            .append(item.getTienda()).toString())
                                                    .collect(Collectors.toSet()));
                        }
                    }
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);

            tareaTiendaEmpleadoPresenciaSeccionRepository.save(tarea);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}