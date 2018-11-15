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

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunDatosService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;

@Service
@Validated
public class TrabajoRunDatosServiceImpl implements TrabajoRunDatosService {

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TrabajoRunAsyncService trabajoAsyncService;

    @AuditoriaTrabajo
    @Override
    public TrabajoDto run(@Valid final TrabajoDto trabajo) throws Exception {
        boolean result = true;
        List<CompletableFuture<?>> cf = new ArrayList<>();
        if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
            trabajo.setFechaInicioTrabajo(LocalDateTime.now());
            trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
            trabajoService.modifyTrabajo(trabajo);

            CompletableFuture<Void> cfTiendasParametro = trabajoAsyncService.tiendasParametro(trabajo);
            trabajoAsyncService.exceptionally(trabajo, cfTiendasParametro, cf);

            CompletableFuture<Void> cfTiendasHistorico = trabajoAsyncService.tiendasHistorico(trabajo);
            trabajoAsyncService.exceptionally(trabajo, cfTiendasHistorico, cf);

            cfTiendasParametro.get();
            if (trabajoAsyncService.isOk(trabajo, cf)) {
                CompletableFuture<Void> cfTiposHoras = trabajoAsyncService.tiposHoras(trabajo);
                trabajoAsyncService.exceptionally(trabajo, cfTiposHoras, cf);

                CompletableFuture<Void> cfEmpleados = trabajoAsyncService.empleadosTienda(trabajo);
                trabajoAsyncService.exceptionally(trabajo, cfEmpleados, cf);

                CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoAsyncService.ventaTotalizadaTienda(trabajo,
                        Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                                AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                                AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
                trabajoAsyncService.exceptionally(trabajo, cfVentaTotalizadaTienda, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoAsyncService.presenciaTotalizadaTienda(
                        trabajo,
                        Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                                AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                                AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
                trabajoAsyncService.exceptionally(trabajo, cfPresenciaTotalizadaTienda, cf);

                cfEmpleados.get();
                if (trabajoAsyncService.isOk(trabajo, cf)) {
                    CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoAsyncService
                            .presenciaDetalleEmpleado(trabajo);
                    trabajoAsyncService.exceptionally(trabajo, cfPresenciaDetalleEmpleado, cf);

                    CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoAsyncService.ventaDetalleEmpleado(trabajo);
                    trabajoAsyncService.exceptionally(trabajo, cfVentaDetalleEmpleado, cf);

                    CompletableFuture<Void> cfCondicionesEmpleados = trabajoAsyncService.condicionesEmpleados(trabajo);
                    trabajoAsyncService.exceptionally(trabajo, cfCondicionesEmpleados, cf);

                    cfPresenciaDetalleEmpleado.get();
                    if (trabajoAsyncService.isOk(trabajo, cf)) {
                        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                                || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                            // Si la ejecución es de un tipo que puede agregar tiendas adicionales se llama
                            // al proceso que recupera la informacion
                            CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoAsyncService
                                    .ventaTotalizadaTienda(trabajo,
                                            Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                            trabajoAsyncService.exceptionally(trabajo, cfVentaTotalizadaTiendaPresencia, cf);

                            CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoAsyncService
                                    .presenciaTotalizadaTienda(trabajo,
                                            Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                            trabajoAsyncService.exceptionally(trabajo, cfPresenciaTotalizadaTiendaPresencia, cf);
                        }

                        CompletableFuture.allOf(cf.toArray(new CompletableFuture[cf.size()]));
                        if (trabajoAsyncService.isOk(trabajo, cf)) {
                            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto(), trabajo);
                        } else {
                            result = false;
                        }
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        }
        if (!result) {
            throw new ApplicationException("Ha fallado la obtencion de datos");
        }
        return trabajo;
    }

}