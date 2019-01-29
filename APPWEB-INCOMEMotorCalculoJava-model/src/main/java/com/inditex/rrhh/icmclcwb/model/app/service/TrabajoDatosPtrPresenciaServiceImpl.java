package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEmpleadoPresenciaSeccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaPresenciaSeccionRepository;

@Service
@Validated
public class TrabajoDatosPtrPresenciaServiceImpl implements TrabajoDatosPtrPresenciaService {

    @Autowired
    private PtrPresenciaAsyncService ptrPresenciaAsyncService;

    @Autowired
    private TrabajoTiendaSeccionPresenciaService trabajoTiendaSeccionPresenciaService;

    @Autowired
    private TrabajoTipoHoraService trabajoTipoHoraSevice;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaService trabajoTiendaSeccionEmpleadoPresenciaService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaPresenciaSeccionRepository trabajoTiendaPresenciaSeccionRepository;

    @Autowired
    private TrabajoTiendaEmpleadoPresenciaSeccionRepository trabajoTiendaEmpleadoPresenciaSeccionRepository;

    @Autowired
    @Qualifier("presenciasTotalTiendaSeccionDto")
    private PtrPropertiesDto presenciasTotalTiendaSeccionDto;

    @Autowired
    @Qualifier("presenciasDetalleDto")
    private PtrPropertiesDto presenciasDetalleDto;

    @AuditoriaTrabajo
    @Override
    public void tiposHoras(@Valid final TrabajoDto trabajo) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfData = ptrPresenciaAsyncService
                    .getTiposHoras(PtrPresenciaTiposHorasRequestDto.builder()
                            .origen(Integer.parseInt(trabajo.getIdPaisOrigen())).build());
            AsyncUtils.exceptionally(cfData, cf);
            PtrPresenciaTiposHorasResponseDto data = cfData.get();
            if (data != null && CollectionUtils.isNotEmpty(data.getTiposHoras())) {
                AsyncUtils.exceptionally(trabajoTipoHoraSevice.save(data.getTiposHoras(), trabajo), cf);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();

            for(String cadena : trabajoRunDatosBloque.getCadenaEmpresa()) {

                final AtomicInteger counter = new AtomicInteger(0);
                for (List<String> iter : trabajoRunDatosBloque.getTiendaMtu().stream().collect(Collectors.groupingBy(
                        item -> counter.getAndIncrement() / presenciasTotalTiendaSeccionDto.getFilter().getMaxPageSize()))
                        .values()) {
                    List<PtrPresenciaTiendaSeccionDto> tiendas = iter.stream()
                            .map(item -> PtrPresenciaTiendaSeccionDto.builder().tienda(Integer.valueOf(item)).build())
                            .collect(Collectors.toList());
    
                    PtrPresenciaTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
                            .trabajoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(trabajo);
                    paramPresenciasTotalTiendaSeccion.setCadena(Integer.valueOf(cadena));
                    paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                    // TODO PENDIENTE TIPO HORA
    
                    CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasTotalTiendaSeccionDto(paramPresenciasTotalTiendaSeccion);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);
    
                    PtrPresenciaTotalTiendaSeccionResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasTotalTiendaSeccion())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist,
                                presenciasTotalTiendaSeccionDto.getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(trabajoTiendaSeccionPresenciaService.save(data.getPresenciasTotalTiendaSeccion(), trabajo), cf, cfPersist);
                    }
                }
                
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaDetalleEmpleado(@Valid TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();

            for(String cadena : trabajoRunDatosBloque.getCadenaEmpresa()) {

                final AtomicInteger counter = new AtomicInteger(0);
                for (List<String> iter : trabajoRunDatosBloque.getEmpleadoLocal().stream()
                        .collect(Collectors.groupingBy(
                                item -> counter.getAndIncrement() / presenciasDetalleDto.getFilter().getMaxPageSize()))
                        .values()) {
                    List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());
    
                    PtrPresenciaDetalleRequestDto paramPresenciasDetalle = trabajoMapper
                            .trabajoDtoToPtrPresenciasDetalleRequestDto(trabajo);
                    paramPresenciasDetalle.setPersona(empleados);
                    paramPresenciasDetalle.setCadena(Integer.valueOf(cadena));
    
                    CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = ptrPresenciaAsyncService
                            .getPresenciasDetalleDto(paramPresenciasDetalle);
                    AsyncUtils.exceptionally(cfData, cf, cfPersist);
    
                    PtrPresenciaDetalleResponseDto data = cfData.get();
                    if (data != null && CollectionUtils.isNotEmpty(data.getPresenciasDetalle())) {
                        AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasDetalleDto.getFilter().getMaxPersistenceSize());
                        AsyncUtils.exceptionally(trabajoTiendaSeccionEmpleadoPresenciaService.save(data.getPresenciasDetalle(), trabajo),
                                cf, cfPersist);
    
                        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                                || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                            trabajoRunDatosBloque.getTiendaPresencia().addAll(data.getPresenciasDetalle().stream().map(
                                    item -> new StringBuilder(AppConstants.PREFIJO_TIENDA_META4).append(item.getTienda()).toString())
                                    .collect(Collectors.toSet()));
                        }
                    }
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);

            trabajoTiendaEmpleadoPresenciaSeccionRepository.save(trabajo);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}