package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunDatosService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;

@Service
@Validated
public class TrabajoRunDatosServiceImpl implements TrabajoRunDatosService {

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TrabajoDatosAsyncService trabajoDatosAsyncService;

    @Autowired
    private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

    @AuditoriaTrabajo
    @Override
    public TrabajoDto run(@Valid final TrabajoDto trabajo) throws Exception {
        if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
            trabajo.setFechaInicioTrabajo(LocalDateTime.now());
            trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
            trabajoService.modifyTrabajo(trabajo);

            List<CompletableFuture<?>> cf = new ArrayList<>();

            CompletableFuture<Void> cfTiendasParametro = trabajoDatosAsyncService.tiendasParametro(trabajo);
            AsyncUtils.exceptionally(trabajo, cfTiendasParametro, cf);

            CompletableFuture<Void> cfTiendasHistorico = trabajoDatosAsyncService.tiendasHistorico(trabajo);
            AsyncUtils.exceptionally(trabajo, cfTiendasHistorico, cf);

            CompletableFuture<Void> cfTiposHoras = trabajoDatosAsyncService.tiposHoras(trabajo);
            AsyncUtils.exceptionally(trabajo, cfTiposHoras, cf);

            CompletableFuture.allOf(cfTiendasParametro, cfTiendasHistorico, cfTiposHoras);
            if (AsyncUtils.isOk(trabajo, cf)) {

                trabajo.setCadenasEmpresa(
                        trabajoTiendaEstadoRepository.findIdCadenaByIdPaisOrigenAndIdEmpresaGroupByIdCadena(
                                trabajo.getIdPaisOrigen(), trabajo.getIdEmpresa()));

                CompletableFuture<Void> cfEmpleados = trabajoDatosAsyncService.empleadosTienda(trabajo);
                AsyncUtils.exceptionally(trabajo, cfEmpleados, cf);

                CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoDatosAsyncService.ventaTotalizadaTienda(
                        trabajo,
                        Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                                AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                                AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
                AsyncUtils.exceptionally(trabajo, cfVentaTotalizadaTienda, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoDatosAsyncService
                        .presenciaTotalizadaTienda(trabajo,
                                Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                                        AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                                        AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
                AsyncUtils.exceptionally(trabajo, cfPresenciaTotalizadaTienda, cf);

                CompletableFuture.allOf(cfEmpleados);
                if (AsyncUtils.isOk(trabajo, cf)) {
                    CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoDatosAsyncService
                            .presenciaDetalleEmpleado(trabajo);
                    AsyncUtils.exceptionally(trabajo, cfPresenciaDetalleEmpleado, cf);

                    CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoDatosAsyncService
                            .ventaDetalleEmpleado(trabajo);
                    AsyncUtils.exceptionally(trabajo, cfVentaDetalleEmpleado, cf);

                    CompletableFuture<Void> cfCondicionesEmpleados = trabajoDatosAsyncService
                            .condicionesEmpleados(trabajo);
                    AsyncUtils.exceptionally(trabajo, cfCondicionesEmpleados, cf);

                    if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                            || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                        CompletableFuture.allOf(cfPresenciaDetalleEmpleado);
                        // Si la ejecución es de un tipo que puede agregar tiendas adicionales se llama
                        // al proceso que recupera la informacion
                        CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoDatosAsyncService
                                .ventaTotalizadaTienda(trabajo,
                                        Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                        AsyncUtils.exceptionally(trabajo, cfVentaTotalizadaTiendaPresencia, cf);

                        CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoDatosAsyncService
                                .presenciaTotalizadaTienda(trabajo,
                                        Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                        AsyncUtils.exceptionally(trabajo, cfPresenciaTotalizadaTiendaPresencia, cf);
                    }

                    CompletableFuture.allOf(cf.toArray(new CompletableFuture[cf.size()]));
                    if (AsyncUtils.isOk(trabajo, cf)) {
                        trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto(), trabajo);
                    }
                }
            }
        }
        return trabajo;
    }

}