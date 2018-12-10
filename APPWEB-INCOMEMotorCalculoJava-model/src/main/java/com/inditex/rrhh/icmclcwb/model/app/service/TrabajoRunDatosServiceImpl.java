package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
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
	private TrabajoDatosMeta4IcmWsCalcIncomeAsyncService trabajoDatosMeta4IcmWsCalcIncomeAsyncService;

	@Autowired
	private TrabajoDatosPtrVentaAsyncService trabajoDatosPtrVentaAsyncService;

	@Autowired
	private TrabajoDatosPtrPresenciaAsyncService trabajoDatosPtrPresenciaAsyncService;

	@Autowired
	private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

	@CounterMetric
	@TimerMetric
	@AuditoriaTrabajoRun
	@Override
	public TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			final TrabajoDto trabajo = trabajoRun.getTrabajoDto();
			final TrabajoRunDatosDto trabajoRunDatos = trabajoRun.getTrabajoRunDatos();
			if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
				trabajo.setFechaInicioTrabajo(LocalDateTime.now());
				trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
				trabajoService.modifyTrabajo(trabajo);

				
				CompletableFuture<Void> cfTiendasHistorico = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
						.tiendasHistorico(trabajo, trabajoRunDatos);
				AsyncUtils.exceptionally(cfTiendasHistorico, cf);

				CompletableFuture<Void> cfTiendasEmpleadoHistorico = null;
				if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
					cfTiendasEmpleadoHistorico = trabajoDatosMeta4IcmWsCalcIncomeAsyncService.tiendasEmpleadoHistorico(trabajo,
							trabajoRunDatos);
					AsyncUtils.exceptionally(cfTiendasEmpleadoHistorico, cf);
				}

				CompletableFuture<Void> cfTiposHoras = trabajoDatosPtrPresenciaAsyncService.tiposHoras(trabajo);
				AsyncUtils.exceptionally(cfTiposHoras, cf);

				/*-------------------------------------------------------------*/
				AsyncUtils.waitAllOfIsOk(cf, cfTiendasHistorico, cfTiendasEmpleadoHistorico);
				/*-------------------------------------------------------------*/
				
				// TODO Revisar si son comisionables
				CompletableFuture<Void> cfTiendasComisionable = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
						.tiendasComisionable(trabajo, 
                                AppConstants.TipoTrabajoTiendaInicialHistoricoParamEnum.ALL,
                                trabajoRunDatos);
				AsyncUtils.exceptionally(cfTiendasComisionable, cf);

				trabajoRunDatos.getCadenasEmpresa().addAll(
						trabajoTiendaEstadoRepository.findIdCadenaByIdPaisOrigenAndIdEmpresaGroupByIdCadena(
								trabajo.getIdPaisOrigen(), trabajo.getIdEmpresa()));

				// TODO ICM_WS_CALC_INCOME :: GETEMPLEADOS
				CompletableFuture<Void> cfEmpleados = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
						.empleadosTienda(trabajo, trabajoRunDatos);
				AsyncUtils.exceptionally(cfEmpleados, cf);

				CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoDatosPtrVentaAsyncService
						.ventaTotalizadaTienda(trabajo,
                                AppConstants.TipoTrabajoTiendaInicialHistoricoParamEnum.ALL,
								trabajoRunDatos);
				AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

				CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoDatosPtrPresenciaAsyncService
						.presenciaTotalizadaTienda(trabajo, 
						        AppConstants.TipoTrabajoTiendaInicialHistoricoParamEnum.ALL,
								trabajoRunDatos);
				AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

				/*-------------------------------------------------------------*/
				AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
				/*-------------------------------------------------------------*/

				CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoDatosPtrPresenciaAsyncService
						.presenciaDetalleEmpleado(trabajo, trabajoRunDatos);
				AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

				CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoDatosPtrVentaAsyncService
						.ventaDetalleEmpleado(trabajo, trabajoRunDatos);
				AsyncUtils.exceptionally(cfVentaDetalleEmpleado, cf);

				// TODO ICM_WS_CALC_INCOME :: GETCOMISIONEMPLEADO
				CompletableFuture<Void> cfCondicionesEmpleados = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
						.condicionesEmpleados(trabajo, trabajoRunDatos);
				AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

				if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
						|| CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
					/*-------------------------------------------------------------*/
					AsyncUtils.waitAllOfIsOk(cf, cfPresenciaDetalleEmpleado);
					/*-------------------------------------------------------------*/

					if (CollectionUtils.isNotEmpty(trabajoRunDatos.getTiendasPresencia())) {
						// TODO ICM_WS_CALC_INCOME :: SEARCHTIENDAS -> GETTIENDASINCOME
						CompletableFuture<Void> cfTiendasPresencia = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
								.tiendasPresencia(trabajo, trabajoRunDatos);
						AsyncUtils.exceptionally(cfTiendasPresencia, cf);

						AsyncUtils.waitAllOfIsOk(cf, cfTiendasPresencia);
						
		                  if (CollectionUtils.isNotEmpty(trabajoRunDatos.getTiendasPresenciaNuevas())) {
                            // TODO Revisar si son comisionables
                            CompletableFuture<Void> cfTiendasComisionablePresencia = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                                    .tiendasComisionable(trabajo, AppConstants.TipoTrabajoTiendaPresenciaEnum.ALL,
                                            trabajoRunDatos);
                            AsyncUtils.exceptionally(cfTiendasComisionablePresencia, cf);
                            
                            trabajoRunDatos.getCadenasEmpresa().clear();
                            trabajoRunDatos.getCadenasEmpresa().addAll(
                                    trabajoTiendaEstadoRepository.findIdCadenaByIdPaisOrigenAndIdEmpresaGroupByIdCadena(
                                            trabajo.getIdPaisOrigen(), trabajo.getIdEmpresa()));
                           
                            CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoDatosPtrVentaAsyncService
                                    .ventaTotalizadaTienda(trabajo, AppConstants.TipoTrabajoTiendaPresenciaEnum.ALL,
                                            trabajoRunDatos);
                            AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);
                        
                            CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoDatosPtrPresenciaAsyncService
                                    .presenciaTotalizadaTienda(trabajo, AppConstants.TipoTrabajoTiendaPresenciaEnum.ALL,
                                            trabajoRunDatos);
                            AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
                        }
					}


				}

				/*-------------------------------------------------------------*/
				AsyncUtils.waitAllOfIsOk(cf, cf);
				/*-------------------------------------------------------------*/
				trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto(), trabajo);
			}
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
		return trabajoRun;
	}

}