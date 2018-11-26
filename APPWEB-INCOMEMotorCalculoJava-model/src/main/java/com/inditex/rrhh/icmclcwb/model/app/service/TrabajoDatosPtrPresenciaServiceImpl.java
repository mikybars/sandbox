package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiendaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEmpleadoPresenciaSeccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoCustomRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaPresenciaSeccionRepository;

@Service
@Validated
public class TrabajoDatosPtrPresenciaServiceImpl implements TrabajoDatosPtrPresenciaService {

    @Autowired
    private PtrPresenciaMockAsyncService ptrPresenciaMockAsyncService;

    @Autowired
    private TrabajoTiendaSeccionPresenciaService trabajoTiendaSeccionPresenciaService;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaService trabajoTiendaSeccionEmpleadoPresenciaService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;
    
    @Autowired
    private TrabajoTiendaEstadoCustomRepository trabajoTiendaEstadoCustomRepository;

    @Autowired
    private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

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
        Random random = new Random();
        LongStream ls = random.longs(1000, 5000);
        long time = ls.findFirst().getAsLong();
        ls.close();
        Thread.sleep(time);
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaTotalizadaTienda(@Valid TrabajoDto trabajo,
            @NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();

        List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(TipoTrabajoTiendaDto::getId)
                .collect(Collectors.toList());

        Page<TrabajoTiendaEstado> page;
        Pageable pageable = new PageRequest(0, presenciasTotalTiendaSeccionDto.getFilter().getMaxPageSize());
        do {
            page = trabajoTiendaEstadoRepository.findByTrabajoIdAndEstadoIdAndTipoIdIn(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), tipoTrabajoTiendaId, pageable);

            if (CollectionUtils.isNotEmpty(page.getContent())) {

                List<PtrPresenciasMockTiendaSeccionDto> tiendas = page.getContent().stream()
                        .map(t -> new PtrPresenciasMockTiendaSeccionDto(Integer.valueOf(t.getIdTienda()), null))
                        .collect(Collectors.toList());

                List<Integer> cadenas = trabajo.getCadenasEmpresa().stream().map(Integer::valueOf)
                        .collect(Collectors.toList());

                PtrPresenciasMockTotalTiendaSeccionRequestDto paramPresenciasTotalTiendaSeccion = trabajoMapper
                        .trabajoDtoToPresenciasTotalTiendaSeccionRequestDto(trabajo);
                paramPresenciasTotalTiendaSeccion.setCadena(cadenas);
                paramPresenciasTotalTiendaSeccion.setTiendaSeccion(tiendas);
                // TODO (PENDIENTE ANALIZAR) Enviar la lista de horas comisionables y cambiar el
                // objeto a una lista
                // paramPresenciasTotalTiendaSeccion.setTipo(tipo);

                CompletableFuture<List<PtrPresenciasMockTotalTiendaSeccionResponseDto>> cfData = ptrPresenciaMockAsyncService
                        .presenciasTotalTiendaSeccion(paramPresenciasTotalTiendaSeccion);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);
                
                List<PtrPresenciasMockTotalTiendaSeccionResponseDto> data = cfData.get();
                if (CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                            presenciasTotalTiendaSeccionDto.getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(trabajoTiendaSeccionPresenciaService.save(data), cf, cfPersist);
                }
                pageable = page.nextPageable();
            }
        } while (page.hasNext());

        AsyncUtils.waitAllOfIsOk(cf, cf);

        if (RunUtils.isPivot(trabajo, tipoTrabajoTienda)) {
            trabajoTiendaPresenciaSeccionRepository.save(trabajo);
        }
    }

    @AuditoriaTrabajo
    @Override
    public void presenciaDetalleEmpleado(@Valid TrabajoDto trabajo) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();

        Page<TrabajoEmpleadoEstado> page;
        Pageable pageable = new PageRequest(0, presenciasDetalleDto.getFilter().getMaxPageSize());
        Set<Integer> idsTiendas = new HashSet<>();
        
        do {
            page = trabajoEmpleadoEstadoRepository.findByTrabajoIdAndEstadoId(trabajo.getId(),
                    AppConstants.EstadoTrabajoTiendaEnum.PENDIENTE.getId(), pageable);

            if (CollectionUtils.isNotEmpty(page.getContent())) {

                List<Integer> empleados = page.getContent().stream().map(s -> Integer.valueOf(s.getIdEmpleado()))
                        .collect(Collectors.toList());

                List<Integer> cadenas = trabajo.getCadenasEmpresa().stream().map(Integer::valueOf)
                        .collect(Collectors.toList());

                PtrPresenciasMockDetalleRequestDto paramPresenciasDetalle = trabajoMapper
                        .trabajoDtoToPresenciasDetalleRequestDto(trabajo);
                paramPresenciasDetalle.setPersonas(empleados);
                paramPresenciasDetalle.setCadena(cadenas);

                CompletableFuture<List<PtrPresenciasMockDetalleResponseDto>> cfData = ptrPresenciaMockAsyncService
                        .presenciasDetalle(paramPresenciasDetalle);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                List<PtrPresenciasMockDetalleResponseDto> data = cfData.get();
                if (data != null && CollectionUtils.isNotEmpty(data)) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, presenciasDetalleDto.getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(trabajoTiendaSeccionEmpleadoPresenciaService.save(data, trabajo), cf,
                            cfPersist);

                    if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                            || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                    	
                        // TODO Recuperar los ids de tienda sin repetidos de las presencias, para
                        // procesarlas posteriormente
                    	idsTiendas.addAll(data.stream().map(e -> e.getTienda()).collect(Collectors.toSet()));
                    }

                }
            }
            pageable = page.nextPageable();
        } while (page.hasNext());

        AsyncUtils.waitAllOfIsOk(cf, cf);

        // TODO Revisar si las tiendas recuperadas de las presencias estan en las
        // tiendas de BBDD
        // Si no estan consultar a Meta4 e insertar los datos
        
        
        if (CollectionUtils.isNotEmpty(idsTiendas)) {
			List<Integer> idsTiendasMeta4 = trabajoTiendaEstadoCustomRepository
					.customFindByIdTiendaNotExists(idsTiendas);
			
			
		}
		

        // TODO Pivotado de la informacion

        trabajoTiendaEmpleadoPresenciaSeccionRepository.save(trabajo);
        
    }

}