package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeService {

	@Autowired
	private Logger log;

	@Autowired
	private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

	@Autowired
	private TrabajoTiendaHistoricoAsyncService trabajoTiendaHistoricoAsyncService;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Autowired
	private TrabajoTiendaHistoricoMapper trabajoTiendaHistoricoMapper;

	@Autowired
	private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

	@Autowired
	private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

	@Autowired
	private TrabajoEmpleadoHistoricoMapper trabajoEmpleadoHistoricoMapper;

	@Autowired
	private TrabajoEmpleadoEstructuraMapper trabajoEmpleadoEstructuraMapper;

	@Autowired
	private TrabajoEmpleadoHistoricoAsyncService trabajoEmpleadoHistoricoAsyncService;

	@Autowired
	private TrabajoEmpleadoEstructuraAsyncService trabajoEmpleadoEstructuraAsyncService;

	@Autowired
	@Qualifier("getTiendasEmpleadoDto")
	private Meta4PropertiesDto getTiendasEmpleadoDto;

	@Autowired
	@Qualifier("searchTiendasDto")
	private Meta4PropertiesDto searchTiendasDto;

	@Autowired
	@Qualifier("getTiendasDto")
	private Meta4PropertiesDto getTiendasDto;

	@Autowired
	@Qualifier("searchEmpleadosDto")
	private Meta4PropertiesDto searchEmpleadosDto;

	@Autowired
	@Qualifier("getComisionEmpleadoDto")
	private Meta4PropertiesDto getComisionEmpleadoDto;

	@Autowired
	@Qualifier("getEmpleadosDto")
	private Meta4PropertiesDto getEmpleadosDto;

	@AuditoriaTrabajo
	@Override
	public void tiendasHistorico(@Valid final TrabajoDto trabajo,
			@Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			Set<String> tiendas = new HashSet<>();
			if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
				SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
				searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
				searchEmpleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
				searchEmpleadosRequest.getData().getItem()
						.addAll(trabajo
								.getEmpleados().stream().map(item -> GenericFilterParametersDto.builder()
										.idEmpleado(item.getIdEmpleado()).orEmpleado(item.getOrEmpleado()).build())
								.collect(Collectors.toList()));

				List<CompletableFuture<?>> cfPersist = new ArrayList<>();
				boolean hasNext = false;
				do {
					CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
							.searchEmpleados(searchEmpleadosRequest);
					AsyncUtils.exceptionally(cfData, cf);
					List<GenericEmpleadoResultItemDto> data = cfData.get();

					if (CollectionUtils.isNotEmpty(data)) {
						List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico = trabajoEmpleadoHistoricoMapper
								.genericEmpleadoResultItemDtoToTrabajoEmpleadoHistoricoDto(data);
						if (CollectionUtils.isNotEmpty(trabajoEmpleadoHistorico)) {
							AsyncUtils.checkAsyncAvaliable(cfPersist,
									searchEmpleadosDto.getFilter().getMaxPersistenceSize());
							CompletableFuture<Void> cfSave = trabajoEmpleadoHistoricoAsyncService
									.save(trabajoEmpleadoHistorico, trabajo);
							AsyncUtils.exceptionally(cfSave, cf, cfPersist);
						}

						trabajoRunDatosBloque.getEmpleado().addAll(trabajoEmpleadoEstadoMapper
								.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo));
					}

					tiendas.addAll(data.stream().map(GenericEmpleadoResultItemDto::getIdLugarTrabajo)
							.collect(Collectors.toSet()));
					hasNext = searchEmpleadosRequest.nextPage();
				} while (hasNext);
				if (CollectionUtils.isEmpty(tiendas)) {
					throw new ApplicationException("Los empleados no tienen tiendas asociadas");
				}
			} else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
				tiendas.addAll(
						trabajo.getTiendas().stream().map(TrabajoTiendaDto::getIdTienda).collect(Collectors.toSet()));
			}

			SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
			searchTiendasRequest.setPage(searchTiendasDto.getPage());
			searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
			if (CollectionUtils.isNotEmpty(tiendas)) {
				searchTiendasRequest.getData().getItem()
						.addAll(tiendas.stream()
								.map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
								.collect(Collectors.toList()));
			}

			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			boolean hasNext = false;
			do {
				CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
						.searchTiendas(searchTiendasRequest);
				AsyncUtils.exceptionally(cfData, cf);
				List<GenericTiendaResultItemDto> data = cfData.get();
				if (CollectionUtils.isNotEmpty(data)) {
					List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
							.genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(data);
					if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService.save(trabajoTiendaHistorico,
								trabajo);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}

					data.stream().forEach(item -> {
						if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
							trabajoRunDatosBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
						} else {
							log.error(
									"TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
									item);
						}
						if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
							trabajoRunDatosBloque.getTiendaMtu().add(item.getIdTiendaMtu());
						} else {
							log.error(
									"TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
									item);
						}
						if (StringUtils.isNotBlank(item.getIdCadena())) {
							trabajoRunDatosBloque.getCadenaEmpresa().add(item.getIdCadena());
						} else {
							log.error(
									"TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.tiendasHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
									item);
						}
					});

					trabajoRunDatosBloque.getTienda()
							.addAll(trabajoTiendaEstadoMapper.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data,
									AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto()));
				}
				hasNext = searchTiendasRequest.nextPage();
			} while (hasNext);

			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	@Override
	public void tiendasPresencia(@Valid final TrabajoDto trabajo,
			@Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			final AtomicInteger counter = new AtomicInteger(0);
			for (List<String> iter : trabajoRunDatosBloque.getTiendaPresencia().stream()
					.collect(Collectors
							.groupingBy(item -> counter.getAndIncrement() / getTiendasDto.getFilter().getMaxPageSize()))
					.values()) {
				SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
				searchTiendasRequest.setPage(searchTiendasDto.getPage());
				searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
				searchTiendasRequest.getData().getItem()
						.addAll(iter.stream()
								.map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
								.collect(Collectors.toList()));

				boolean hasNextTienda = false;
				do {
					CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
							.searchTiendas(searchTiendasRequest);
					AsyncUtils.exceptionally(cfData, cf);
					List<GenericTiendaResultItemDto> data = cfData.get();
					if (CollectionUtils.isNotEmpty(data)) {
						List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
								.genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(data);
						if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
							AsyncUtils.checkAsyncAvaliable(cfPersist,
									searchTiendasDto.getFilter().getMaxPersistenceSize());
							CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService
									.save(trabajoTiendaHistorico, trabajo);
							AsyncUtils.exceptionally(cfSave, cf, cfPersist);

							trabajoRunDatosBloque.getTienda().addAll(
									trabajoTiendaEstadoMapper.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data,
											AppConstants.TipoTrabajoTiendaEnum.PRESENCIA.getDto()));
						}
					}
					hasNextTienda = searchTiendasRequest.nextPage();
				} while (hasNextTienda);
			}
			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	@Override
	public void tiendasEmpleadoHistorico(@Valid TrabajoDto trabajo,
			@Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
				final AtomicInteger counter = new AtomicInteger(0);
				for (List<TrabajoTiendaDto> iter : trabajo.getTiendas().stream()
						.collect(Collectors.groupingBy(
								item -> counter.getAndIncrement() / getTiendasEmpleadoDto.getFilter().getMaxPageSize()))
						.values()) {
					TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
					tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
					tiendasEmpleadoRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
					tiendasEmpleadoRequest.getData().getItem()
							.addAll(iter.stream().map(
									e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTienda()).build())
									.collect(Collectors.toList()));

					Set<String> tiendas = new HashSet<>();
					boolean hasNext = false;
					do {
						CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
								.getTiendasEmpleado(tiendasEmpleadoRequest);
						AsyncUtils.exceptionally(cfData, cf);
						List<GenericTiendaResultItemDto> data = cfData.get();
						if (CollectionUtils.isNotEmpty(data)) {
							tiendas.addAll(data.stream().map(GenericTiendaResultItemDto::getIdLugarTrabajo)
									.collect(Collectors.toSet()));
						}
						hasNext = tiendasEmpleadoRequest.nextPage();
					} while (hasNext);

					if (CollectionUtils.isNotEmpty(tiendas)) {
						SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
						searchTiendasRequest.setPage(searchTiendasDto.getPage());
						searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
						searchTiendasRequest.getData().getItem()
								.addAll(tiendas.stream()
										.map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
										.collect(Collectors.toList()));

						List<CompletableFuture<?>> cfPersist = new ArrayList<>();
						boolean hasNextTienda = false;
						do {
							CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
									.searchTiendas(searchTiendasRequest);
							AsyncUtils.exceptionally(cfData, cf);
							List<GenericTiendaResultItemDto> data = cfData.get();
							if (CollectionUtils.isNotEmpty(data)) {
								List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
										.genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(data);
								if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
									AsyncUtils.checkAsyncAvaliable(cfPersist,
											searchTiendasDto.getFilter().getMaxPersistenceSize());
									CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService
											.save(trabajoTiendaHistorico, trabajo);
									AsyncUtils.exceptionally(cfSave, cf, cfPersist);
								}

								data.stream().forEach(item -> {
			                        if (StringUtils.isNotBlank(item.getIdLugarTrabajo())) {
			                            trabajoRunDatosBloque.getTiendaMeta4().add(item.getIdLugarTrabajo());
			                        } else {
			                            log.error(
			                                    "TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdLugarTrabajo() :: null :: {}",
			                                    item);
			                        }
			                        if (StringUtils.isNotBlank(item.getIdTiendaMtu())) {
			                            trabajoRunDatosBloque.getTiendaMtu().add(item.getIdTiendaMtu());
			                        } else {
			                            log.error(
			                                    "TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdTiendaMtu() :: null :: {}",
			                                    item);
			                        }
			                        if (StringUtils.isNotBlank(item.getIdCadena())) {
			                            trabajoRunDatosBloque.getCadenaEmpresa().add(item.getIdCadena());
			                        } else {
			                            log.error(
			                                    "TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.tiendasEmpleadoHistorico() :: GenericTiendaResultItemDto :: getIdCadena() :: null :: {}",
			                                    item);
			                        }
			                    });
								
								trabajoRunDatosBloque.getTienda()
										.addAll(trabajoTiendaEstadoMapper
												.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data,
														AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto()));
							}
							hasNextTienda = searchTiendasRequest.nextPage();
						} while (hasNextTienda);
					}
				}
				AsyncUtils.waitAllOfIsOk(cf);
			}
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	@Override
	public void condicionesEmpleados(@Valid final TrabajoDto trabajo,
			@Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			final AtomicInteger counter = new AtomicInteger(0);
			for (List<String> iter : trabajoRunDatosBloque.getEmpleadoLocal().stream()
					.collect(Collectors.groupingBy(
							item -> counter.getAndIncrement() / getComisionEmpleadoDto.getFilter().getMaxPageSize()))
					.values()) {
				ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
				comisionEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
				comisionEmpleadoRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
				comisionEmpleadoRequest.getData().getItem()
						.addAll(iter.stream().map(item -> GenericFilterParametersDto.builder().idEmpleado(item).build())
								.collect(Collectors.toList()));

				CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
						.getComisionEmpleado(comisionEmpleadoRequest);
				AsyncUtils.exceptionally(cfData, cf);
				List<GenericEmpleadoResultItemDto> data = cfData.get();
				if (CollectionUtils.isNotEmpty(data)) {
					List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoEstructura = trabajoEmpleadoEstructuraMapper
							.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstructuraDto(data, trabajo);
					if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstructura)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist,
								getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoEmpleadoEstructuraAsyncService
								.save(trabajoEmpleadoEstructura, trabajo);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}
				}
			}

			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}

	}

	@AuditoriaTrabajo
	@Override
	public void tiendasComisionable(@Valid final TrabajoDto trabajo,
			@Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			final AtomicInteger counter = new AtomicInteger(0);
			for (List<String> iter : trabajoRunDatosBloque.getTiendaMeta4().stream()
					.collect(Collectors
							.groupingBy(item -> counter.getAndIncrement() / getTiendasDto.getFilter().getMaxPageSize()))
					.values()) {
				TiendasRequestDto tiendasRequest = new TiendasRequestDto();
				tiendasRequest.setPage(getTiendasDto.getPage());
				tiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
				tiendasRequest.getData().getItem()
						.addAll(iter.stream().map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e).build())
								.collect(Collectors.toList()));
				boolean hasNext = false;
				do {
					CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
							.getTiendas(tiendasRequest);
					AsyncUtils.exceptionally(cfData, cf);
					List<GenericTiendaResultItemDto> data = cfData.get();
					if (CollectionUtils.isNotEmpty(data)) {
						// TODO PERSISTIR TIENDAS COMISION HISTORICO
					}
					hasNext = tiendasRequest.nextPage();
				} while (hasNext);
			}
			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	@Override
	public void empleadosTienda(@Valid final TrabajoDto trabajo,
			@Valid final TrabajoRunDatosBloqueDto trabajoRunDatosBloque) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			if (CollectionUtils.isEmpty(trabajo.getEmpleados())) {
				EmpleadosRequestDto empleadosRequest = new EmpleadosRequestDto();
				empleadosRequest.setPage(getEmpleadosDto.getPage());
				empleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
				if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
					empleadosRequest.getData().getItem()
							.addAll(trabajo.getTiendas().stream().map(
									e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTienda()).build())
									.collect(Collectors.toList()));
				}

				List<CompletableFuture<?>> cfPersist = new ArrayList<>();
				boolean hasNext = false;
				do {
					CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
							.getEmpleados(empleadosRequest);
					AsyncUtils.exceptionally(cfData, cf);
					List<GenericEmpleadoResultItemDto> data = cfData.get();
					if (CollectionUtils.isNotEmpty(data)) {
						SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
						searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
						searchEmpleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
						searchEmpleadosRequest.getData().getItem()
								.addAll(data
										.stream().map(e -> GenericFilterParametersDto.builder()
												.idEmpleado(e.getIdEmpleado()).orEmpleado(e.getOrEmpleado()).build())
										.collect(Collectors.toList()));

						CompletableFuture<List<GenericEmpleadoResultItemDto>> cfHistoricoEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
								.searchEmpleados(searchEmpleadosRequest);
						AsyncUtils.exceptionally(cfHistoricoEmpleados, cf);
						List<GenericEmpleadoResultItemDto> dataHistorico = cfHistoricoEmpleados.get();
						if (CollectionUtils.isNotEmpty(dataHistorico)) {
							List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico = trabajoEmpleadoHistoricoMapper
									.genericEmpleadoResultItemDtoToTrabajoEmpleadoHistoricoDto(dataHistorico);
							AsyncUtils.checkAsyncAvaliable(cfPersist,
									searchTiendasDto.getFilter().getMaxPersistenceSize());
							CompletableFuture<Void> cfSave = trabajoEmpleadoHistoricoAsyncService
									.save(trabajoEmpleadoHistorico, trabajo);
							AsyncUtils.exceptionally(cfSave, cf, cfPersist);

							dataHistorico.stream().forEach(item -> {
								if (StringUtils.isNotBlank(item.getIdEmpleadoLocal())) {
									trabajoRunDatosBloque.getEmpleadoLocal().add(item.getIdEmpleadoLocal());
								} else {
									log.error(
											"TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleadoLocal() :: null :: {}",
											item);
								}
								if (StringUtils.isNotBlank(item.getIdEmpleado())
										&& StringUtils.isNotBlank(item.getOrEmpleado())) {
									trabajoRunDatosBloque.getEmpleadoUniversal()
											.add(new StringBuilder(item.getIdEmpleado())
													.append(AppConstants.SEPARATOR_DATA).append(item.getOrEmpleado())
													.toString());
								} else {
									log.error(
											"TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl.empleadosTienda() :: GenericTiendaResultItemDto :: getIdEmpleado() getOrEmpleado()  :: null :: {}",
											item);
								}
							});

							trabajoRunDatosBloque.getEmpleado().addAll(trabajoEmpleadoEstadoMapper
									.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo));
						}
					}
					hasNext = empleadosRequest.nextPage();
				} while (hasNext);
				AsyncUtils.waitAllOfIsOk(cf);
			}
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

}