package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTipoHoraService;
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
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaEmpleadoPresenciaSeccionRepository;

@Service
@Validated
public class ProcesoRecolectarPtrPresenciaServiceImpl implements ProcesoRecolectarPtrPresenciaService {

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private ProcesoTiendaSeccionPresenciaService procesoTiendaSeccionPresenciaService;

    @Autowired
    private ProcesoTipoHoraService procesoTipoHoraSevice;

    @Autowired
    private ProcesoTiendaSeccionEmpleadoPresenciaService procesoTiendaSeccionEmpleadoPresenciaService;

    @Autowired
    private ProcesoMapper procesoMapper;

    @Autowired
    private ProcesoTiendaEmpleadoPresenciaSeccionRepository procesoTiendaEmpleadoPresenciaSeccionRepository;
    
    @Autowired
    @Qualifier("presenciasProperties")
    private Map<String, PtrPropertiesDto> presenciasProperties;

    @Auditoria
    @Override
    public void tiposHoras(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService.getTiposHoras(
                    PtrPresenciaTiposHorasRequestDto.builder().origen(Integer.parseInt(proceso.getIdPaisOrigen()))
                            .excluidoCalculo(Boolean.FALSE).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = cfData.get();
            if (data != null && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(procesoTipoHoraSevice.save(data.getTiposHoras(), proceso), cf);
                data.getTiposHoras().stream().forEach(item -> {
                    if (Boolean.FALSE.equals(item.getExcluidoCalculo())) {
                        runProcesoRecolectarBloque.getTipoHoraComisionable().add(item.getTipoHora());
                        if (Boolean.FALSE.equals(item.getExcluidoDenom())) {
                            runProcesoRecolectarBloque.getTipoHoraComisionableDenominador().add(item.getTipoHora());
                        }
                    }
                });
            } else {
                throw new PtrException(new StringBuilder("No hay tipos de hora comisionables para el origen: ")
                        .append(proceso.getIdPaisOrigen()).toString());
            }
        } catch (Exception e) {
//            AsyncUtils.cancel(cf);
//            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

    @Auditoria
    @Override
    public void presenciaTotalizadaTienda(@Valid ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runProcesoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getTiendaMtu(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_TOTAL_TIENDA_SECCION).getFilter().getMaxPageSize())) {
                    List<PtrPresenciaTiendaSeccionDto> tiendas = iter.stream()
                            .map(item -> PtrPresenciaTiendaSeccionDto.builder().tienda(Integer.valueOf(item)).build())
                            .collect(Collectors.toList());

                    PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = procesoMapper
                            .procesoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(proceso);
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
                        AsyncUtils.exceptionally(procesoTiendaSeccionPresenciaService
                                .save(data.getPresenciasTotalTiendaSeccion(), proceso), cf, cfPersist);
                    }
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
    public void presenciaDetalleEmpleado(@Valid ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            for (String cadena : runProcesoRecolectarBloque.getCadenaEmpresa()) {
                for (List<String> iter : StreamUtils.partition(runProcesoRecolectarBloque.getEmpleadoLocal(),
                        presenciasProperties.get(PtrConstants.PRESENCIA_DETALLE_COMISIONABLE).getFilter().getMaxPageSize())) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
                    PtrPresenciaDetalleComisionableRequestDto paramPresenciasDetalleComisionable = procesoMapper
                            .procesoDtoToPtrPresenciasDetalleComisionableRequestDto(proceso);
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
                                procesoTiendaSeccionEmpleadoPresenciaService.save(data.getPresenciasDetalleComisionable(), proceso),
                                cf, cfPersist);

                        if (CollectionUtils.isNotEmpty(proceso.getTiendas())
                                || CollectionUtils.isNotEmpty(proceso.getEmpleados())) {
                            runProcesoRecolectarBloque
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

            procesoTiendaEmpleadoPresenciaSeccionRepository.save(proceso);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw new IcmclcwbException(e.getMessage(), e);
        }
    }

}