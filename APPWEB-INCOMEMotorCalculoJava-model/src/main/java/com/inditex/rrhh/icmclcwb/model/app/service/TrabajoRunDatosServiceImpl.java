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
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaAsyncService;
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
    private TrabajoDatosMeta4IcmWsIncomeAsyncService trabajoDatosMeta4IcmWsIncomeAsyncService;
    
    @Autowired
    private TrabajoDatosMeta4IcmWsCalcIncomeAsyncService trabajoDatosMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private TrabajoDatosPtrVentaAsyncService trabajoDatosPtrVentaAsyncService;

    @Autowired
    private TrabajoDatosPtrPresenciaAsyncService trabajoDatosPtrPresenciaAsyncService;

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

            CompletableFuture<Void> cfTiendasParametro = trabajoDatosMeta4IcmWsIncomeAsyncService.tiendasParametro(trabajo);
            AsyncUtils.exceptionally(cfTiendasParametro, cf);

            CompletableFuture<Void> cfTiendasHistorico = trabajoDatosMeta4IcmWsIncomeAsyncService.tiendasHistorico(trabajo);
            AsyncUtils.exceptionally(cfTiendasHistorico, cf);

            CompletableFuture<Void> cfTiposHoras = trabajoDatosPtrPresenciaAsyncService.tiposHoras(trabajo);
            AsyncUtils.exceptionally(cfTiposHoras, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfTiendasParametro, cfTiendasHistorico);
            /*-------------------------------------------------------------*/

            trabajo.setCadenasEmpresa(
                    trabajoTiendaEstadoRepository.findIdCadenaByIdPaisOrigenAndIdEmpresaGroupByIdCadena(
                            trabajo.getIdPaisOrigen(), trabajo.getIdEmpresa()));

            CompletableFuture<Void> cfEmpleados = trabajoDatosMeta4IcmWsIncomeAsyncService.empleadosTienda(trabajo);
            AsyncUtils.exceptionally(cfEmpleados, cf);

            CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoDatosPtrVentaAsyncService.ventaTotalizadaTienda(
                    trabajo,
                    Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                            AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                            AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
            AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

            CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoDatosPtrPresenciaAsyncService
                    .presenciaTotalizadaTienda(trabajo,
                            Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
                                    AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
                                    AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
            AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoDatosPtrPresenciaAsyncService
                    .presenciaDetalleEmpleado(trabajo);
            AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

            CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoDatosPtrVentaAsyncService
                    .ventaDetalleEmpleado(trabajo);
            AsyncUtils.exceptionally(cfVentaDetalleEmpleado, cf);

            CompletableFuture<Void> cfCondicionesEmpleados = trabajoDatosMeta4IcmWsIncomeAsyncService
                    .condicionesEmpleados(trabajo);
            AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

            if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                    || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfPresenciaDetalleEmpleado);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoDatosPtrVentaAsyncService
                        .ventaTotalizadaTienda(trabajo,
                                Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoDatosPtrPresenciaAsyncService
                        .presenciaTotalizadaTienda(trabajo,
                                Arrays.asList(AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
                AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
            }

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto(), trabajo);
        }
        return trabajo;
    }

}