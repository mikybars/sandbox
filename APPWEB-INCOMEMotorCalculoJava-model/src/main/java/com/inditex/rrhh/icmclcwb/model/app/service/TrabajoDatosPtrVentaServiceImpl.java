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
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaVentaSeccionRepository;

@Service
@Validated
public class TrabajoDatosPtrVentaServiceImpl implements TrabajoDatosPtrVentaService {

    @Autowired
    private PtrVentaAsyncService ptrVentaAsyncService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaSeccionVentaAsyncService trabajoTiendaSeccionVentaAsyncService;

    @Autowired
    private TrabajoTiendaVentaSeccionRepository trabajoTiendaVentaSeccionRepository;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @Autowired
    @Qualifier("ventaTotalizadoDto")
    private PtrPropertiesDto ventaTotalizadoDto;

    @Autowired
    @Qualifier("ventaIndividualDetalleDto")
    private PtrPropertiesDto ventaIndividualDetalleDto;

    @AuditoriaTrabajo
    @Override
    public void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();

            final AtomicInteger counter = new AtomicInteger(0);
            for (List<String> iter : trabajoRunDatosBloque.getTiendaMtu().stream()
                    .collect(Collectors.groupingBy(
                            item -> counter.getAndIncrement() / ventaTotalizadoDto.getFilter().getMaxPageSize()))
                    .values()) {
                PtrVentaTotalizadoRequestDto paramGetVentaTotalizado = trabajoMapper
                        .trabajoDtoToPtrVentaTotalizadoRequestDto(trabajo);
                paramGetVentaTotalizado.setTienda(iter);
                paramGetVentaTotalizado.getCadena().addAll(trabajoRunDatosBloque.getCadenaEmpresa());
                paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);

                CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaAsyncService
                        .getVentaTotalizado(paramGetVentaTotalizado);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaTotalizadoResponseDto data = cfData.get();

                if (data != null && CollectionUtils.isNotEmpty(data.getVentaTotalizado())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist, ventaTotalizadoDto.getFilter().getMaxPersistenceSize());
                    AsyncUtils.exceptionally(
                            trabajoTiendaSeccionVentaAsyncService.save(data.getVentaTotalizado(), trabajo), cf,
                            cfPersist);
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
            if (trabajoRunDatosBloque.isPivot()) {
                trabajoTiendaVentaSeccionRepository.save(trabajo);
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

    @AuditoriaTrabajo
    @Override
    public void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo,
            @Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            List<CompletableFuture<?>> cfPersist = new ArrayList<>();
            final AtomicInteger counter = new AtomicInteger(0);
            for (List<String> iter : trabajoRunDatosBloque.getEmpleadoLocal().stream()
                    .collect(Collectors.groupingBy(
                            item -> counter.getAndIncrement() / ventaIndividualDetalleDto.getFilter().getMaxPageSize()))
                    .values()) {
                List<Integer> empleados = iter.stream().map(Integer::valueOf).collect(Collectors.toList());

                PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = trabajoMapper
                        .trabajoDtoToPtrVentaIndividualDetalleRequestDto(trabajo);
                paramGetVentaIndividualDetalle.setVendedores(empleados);
                paramGetVentaIndividualDetalle.getCadena().addAll(trabajoRunDatosBloque.getCadenaEmpresa());
                paramGetVentaIndividualDetalle.setAgrupacion(PtrConstants.AGRUPACION_INDIVIDUAL);

                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = ptrVentaAsyncService
                        .getVentaIndividualDetalle(paramGetVentaIndividualDetalle);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaIndividualDetalleResponseDto data = cfData.get();

                if (data != null && CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                            ventaIndividualDetalleDto.getFilter().getMaxPersistenceSize());
                    // TODO PERSISTIR
                }
            }

            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}