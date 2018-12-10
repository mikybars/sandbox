package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepositoryCustom;

@Service
@Validated
public class TrabajoDatosMeta4IcmWsCalcIncomeServiceImpl implements TrabajoDatosMeta4IcmWsCalcIncomeService {

	@Autowired
	private Meta4IcmWsCalcIncomeSessionAsyncService meta4IcmWsCalcIncomeSessionAsyncService;

	@Autowired
	private TrabajoTiendaEstadoAsyncService trabajoTiendaEstadoAsyncService;

	@Autowired
	private TrabajoTiendaHistoricoAsyncService trabajoTiendaHistoricoAsyncService;

	@Autowired
	private TrabajoEmpleadoEstadoAsyncService trabajoEmpleadoEstadoAsyncService;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Autowired
	private TrabajoTiendaHistoricoMapper trabajoTiendaHistoricoMapper;

	@Autowired
	private TrabajoTiendaEstadoMapper trabajotiendaEstadoMapper;

	@Autowired
	private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

	@Autowired
	private TrabajoTiendaEstadoRepositoryCustom trabajoTiendaEstadoRepositoryCustom;

	@Autowired
	private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

	@Autowired
	private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

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
	public void tiendasHistorico(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			Set<String> tiendasParam = new HashSet<>();
			if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
				SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
				searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
				searchEmpleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
				searchEmpleadosRequest.getData().getItem()
						.addAll(trabajo
								.getEmpleados().stream().map(item -> GenericFilterParametersDto.builder()
										.idEmpleado(item.getIdEmpleado()).orEmpleado(item.getOrEmpleado()).build())
								.collect(Collectors.toList()));
				boolean hasNext;
				do {
					hasNext = false;
					CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
							.searchEmpleados(searchEmpleadosRequest);
					AsyncUtils.exceptionally(cfDataEmpleados, cf);
					List<GenericEmpleadoResultItemDto> dataEmpleados = cfDataEmpleados.get();
					tiendasParam.addAll(dataEmpleados.stream().map(GenericEmpleadoResultItemDto::getIdTiendaMtu)
							.collect(Collectors.toSet()));
					hasNext = searchEmpleadosRequest.nextPage();
				} while (hasNext);
			} else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
				tiendasParam.addAll(
						trabajo.getTiendas().stream().map(TrabajoTiendaDto::getIdTienda).collect(Collectors.toSet()));
			}

			SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
			searchTiendasRequest.setPage(searchTiendasDto.getPage());
			searchTiendasRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
			if (CollectionUtils.isNotEmpty(tiendasParam)) {
				searchTiendasRequest.getData().getItem()
						.addAll(tiendasParam.stream()
								.map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item).build())
								.collect(Collectors.toList()));
			}

			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			boolean hasNext;
			do {
				hasNext = false;
				CompletableFuture<List<GenericTiendaResultItemDto>> cfDataTiendas = meta4IcmWsCalcIncomeSessionAsyncService
						.searchTiendas(searchTiendasRequest);
				AsyncUtils.exceptionally(cfDataTiendas, cf);
				List<GenericTiendaResultItemDto> dataTiendas = cfDataTiendas.get();
				if (CollectionUtils.isNotEmpty(dataTiendas)) {
					List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico = trabajoTiendaHistoricoMapper
							.genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(dataTiendas);
					if (CollectionUtils.isNotEmpty(trabajoTiendaHistorico)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoTiendaHistoricoAsyncService.save(trabajoTiendaHistorico,
								trabajo);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}
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
	public void tiendasPresencia(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {
		trabajoRunDatos.getTiendasPresenciaNuevas().addAll(trabajoTiendaEstadoRepositoryCustom
				.customFindByIdTiendaNotExists(trabajoRunDatos.getTiendasPresencia()));

		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {

			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

			SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
			searchTiendasRequest.setPage(searchTiendasDto.getPage());
			searchTiendasRequest.setData(filter);

			filter.getItem()
					.addAll(trabajoRunDatos.getTiendasPresenciaNuevas().stream()
							.map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(String.valueOf(e)).build())
							.collect(Collectors.toList()));

			boolean hasNext = false;
			do {
				// Consultamos en meta4 los empleados por tienda de forma paginada.
				CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
						.searchTiendas(searchTiendasRequest);
				AsyncUtils.exceptionally(cfData, cf);
				List<GenericTiendaResultItemDto> dataTiendas = cfData.get();

				if (CollectionUtils.isNotEmpty(dataTiendas)) {

					List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
							.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(dataTiendas);
					if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist, searchTiendasDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
								trabajo);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}
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
	public void tiendasEmpleadoHistorico(@Valid TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			TiendasEmpleadoRequestDto tiendasEmpleadoRequest = new TiendasEmpleadoRequestDto();
			tiendasEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
			tiendasEmpleadoRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));
			tiendasEmpleadoRequest.getData().getItem()
					.addAll(trabajo.getTiendas().stream()
							.map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTienda()).build())
							.collect(Collectors.toList()));

			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			boolean hasNext;
			do {
				hasNext = false;
				CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
						.getTiendasEmpleado(tiendasEmpleadoRequest);
				AsyncUtils.exceptionally(cfData, cf);
				List<GenericTiendaResultItemDto> data = cfData.get();

				for (GenericTiendaResultItemDto tienda : data) {
					for (TrabajoTiendaDto tiendaTrabajo : trabajo.getTiendas()) {
						if (tiendaTrabajo.getId().equals(tienda.getIdLugarTrabajo())) {
							data.remove(tienda);
						}
					}
				}

				// TODO PENDIENTE Hay que persistir los datos de las tiendas en historico con sus fechas de inicio y fin consultando el servicio
				
				if (CollectionUtils.isNotEmpty(data)) {
					List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
							.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(data);
					if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist,
								getTiendasEmpleadoDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
								trabajo);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}
				}

				hasNext = tiendasEmpleadoRequest.nextPage();
			} while (hasNext);

			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	@Override
	public void condicionesEmpleados(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			// TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + empresa y pais !!
			// Cuando tengamos tiendas de tipo parametro se busca directamente, sino podemos
			// decidir si usar las tiendas o buscar directamente por pais/empresa

			List<CompletableFuture<?>> cfPersist = new ArrayList<>();

			// Request para la consulta de tiendas
			Pageable pageable = new PageRequest(0, getComisionEmpleadoDto.getFilter().getMaxPageSize());
			Page<TrabajoEmpleadoEstado> empleadosPage;

			// Request para la consulta en meta4
			GenericFilterDto comisionEmpleadoFilter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);
			ComisionEmpleadoRequestDto comisionEmpleadoRequest = new ComisionEmpleadoRequestDto();
			comisionEmpleadoRequest.setPage(getTiendasEmpleadoDto.getPage());
			comisionEmpleadoRequest.setData(comisionEmpleadoFilter);

			do {
				// Se recuperan los empleados.
				empleadosPage = trabajoEmpleadoEstadoRepository.findByTrabajoId(trabajo.getId(), pageable);
				if (CollectionUtils.isNotEmpty(empleadosPage.getContent())) {
					// Consultamos en meta4 los empleados comisionables
					CompletableFuture<List<GenericEmpleadoResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
							.getComisionEmpleado(comisionEmpleadoRequest);
					AsyncUtils.exceptionally(cfData, cf);

					List<GenericEmpleadoResultItemDto> data = cfData.get();
					if (CollectionUtils.isNotEmpty(data)) {
						List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado = trabajoEmpleadoEstadoMapper
								.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo);
						if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
							AsyncUtils.checkAsyncAvaliable(cfPersist,
									getComisionEmpleadoDto.getFilter().getMaxPersistenceSize());
							CompletableFuture<Void> cfSave = trabajoEmpleadoEstadoAsyncService
									.save(trabajoEmpleadoEstado);
							AsyncUtils.exceptionally(cfSave, cf, cfPersist);
						}
					}
				}
				pageable = empleadosPage.nextPageable();
			} while (empleadosPage.hasNext());

			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}

	}

	@AuditoriaTrabajo
	@Override
	public void tiendasComisionable(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {

		List<CompletableFuture<?>> cf = new ArrayList<>();
		List<CompletableFuture<?>> cfPersist = new ArrayList<>();

		GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

		try {
			TiendasRequestDto tiendasRequest = new TiendasRequestDto();
			tiendasRequest.setPage(getTiendasDto.getPage());
			tiendasRequest.setData(filter);

			Pageable pageable = new PageRequest(0, getTiendasEmpleadoDto.getFilter().getMaxPageSize());

			List<Long> tipoTrabajoTiendaId = Stream
					.of(AppConstants.TipoTrabajoTiendaEnum.INICIAL.getDto(),
							AppConstants.TipoTrabajoTiendaEnum.PARAMETRO.getDto(),
							AppConstants.TipoTrabajoTiendaEnum.HISTORICO.getDto())
					.map(TipoTrabajoTiendaDto::getId).collect(Collectors.toList());

			Page<TrabajoTiendaEstado> tiendasPage;

			do {
				tiendasPage = trabajoTiendaEstadoRepository.findByTrabajoIdAndTipoIdIn(trabajo.getId(),
						tipoTrabajoTiendaId, pageable);

				filter.getItem()
						.addAll(tiendasPage.getContent().stream().map(
								e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTiendaMeta4()).build())
								.collect(Collectors.toList()));

				boolean hasNext = false;
				do {
					if (filter.getItem().size() > 0) {
						CompletableFuture<List<GenericTiendaResultItemDto>> cfDataTC = meta4IcmWsCalcIncomeSessionAsyncService
								.getTiendas(tiendasRequest);
						AsyncUtils.exceptionally(cfDataTC, cf);
						List<GenericTiendaResultItemDto> dataTiendasComisionables = cfDataTC.get();

						if (CollectionUtils.isNotEmpty(dataTiendasComisionables)) {

							List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
									.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(dataTiendasComisionables);
							if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
								AsyncUtils.checkAsyncAvaliable(cfPersist,
										searchTiendasDto.getFilter().getMaxPersistenceSize());
								// TODO: Persistir comisionables
							}
						}

						hasNext = tiendasRequest.nextPage();
					}
				} while (hasNext);

			} while (tiendasPage.hasNext());

			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	public void searchEmpleados(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {

		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {

			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			GenericFilterDto filter = trabajoMapper.trabajoDtoToGenericFilterDto(trabajo);

			if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
				filter.setIdEmpresa(null);
				filter.setIdOrigen(null);
				filter.setItem(trabajo.getEmpleados().stream()
						.map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
						.collect(Collectors.toList()));
			}

			SearchEmpleadosRequestDto searchEmpleadosRequest = new SearchEmpleadosRequestDto();
			searchEmpleadosRequest.setPage(searchEmpleadosDto.getPage());
			searchEmpleadosRequest.setData(filter);

			SearchTiendasRequestDto searchTiendasRequest = new SearchTiendasRequestDto();
			searchTiendasRequest.setPage(searchTiendasDto.getPage());
			searchTiendasRequest.setData(filter);

			TiendasRequestDto tiendasRequest = new TiendasRequestDto();
			tiendasRequest.setPage(getTiendasDto.getPage());
			tiendasRequest.setData(filter);

			boolean hasNext = false;
			do {
				// Consultamos en meta4 los empleados por tienda de forma paginada.
				CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
						.searchEmpleados(searchEmpleadosRequest);
				AsyncUtils.exceptionally(cfDataEmpleados, cf);

				List<GenericEmpleadoResultItemDto> dataE = cfDataEmpleados.get();

				filter.setItem(dataE.stream()
						.map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
						.collect(Collectors.toList()));

				CompletableFuture<List<GenericTiendaResultItemDto>> cfDataTiendas = meta4IcmWsCalcIncomeSessionAsyncService
						.searchTiendas(searchTiendasRequest);
				AsyncUtils.exceptionally(cfDataTiendas, cf);

				List<GenericTiendaResultItemDto> dataT = cfDataTiendas.get();

				filter.setItem(dataT.stream()
						.map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdLugarTrabajo()).build())
						.collect(Collectors.toList()));

				CompletableFuture<List<GenericTiendaResultItemDto>> cfData = meta4IcmWsCalcIncomeSessionAsyncService
						.getTiendas(tiendasRequest);
				AsyncUtils.exceptionally(cfData, cf);

				List<GenericTiendaResultItemDto> dataTC = cfDataTiendas.get();

				if (CollectionUtils.isNotEmpty(dataTC)) {
					List<TrabajoTiendaEstadoDto> trabajoTiendaEstado = trabajotiendaEstadoMapper
							.genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(dataTC);
					if (CollectionUtils.isNotEmpty(trabajoTiendaEstado)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist,
								searchEmpleadosDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoTiendaEstadoAsyncService.save(trabajoTiendaEstado,
								trabajo);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}
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
	public void empleadosTienda(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			trabajoRunDatos.getTiendasPresenciaNuevas().addAll(trabajoTiendaEstadoRepositoryCustom
					.customFindByIdTiendaNotExists(trabajoRunDatos.getTiendasPresencia()));
			List<CompletableFuture<?>> cfPersist = new ArrayList<>();

			EmpleadosRequestDto empleadosRequest = new EmpleadosRequestDto();
			empleadosRequest.setPage(getEmpleadosDto.getPage());
			empleadosRequest.setData(trabajoMapper.trabajoDtoToGenericFilterDto(trabajo));

			if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
				empleadosRequest.getData().getItem()
						.addAll(trabajo.getEmpleados().stream()
								.map(e -> GenericFilterParametersDto.builder().idEmpleado(e.getIdEmpleado()).build())
								.collect(Collectors.toList()));
			} else if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
				empleadosRequest.getData().getItem()
						.addAll(trabajo.getTiendas().stream()
								.map(e -> GenericFilterParametersDto.builder().idLugarTrabajo(e.getIdTienda()).build())
								.collect(Collectors.toList()));
			}

			boolean hasNext;
			do {
				hasNext = false;
				CompletableFuture<List<GenericEmpleadoResultItemDto>> cfDataEmpleados = meta4IcmWsCalcIncomeSessionAsyncService
						.getEmpleados(empleadosRequest);
				AsyncUtils.exceptionally(cfDataEmpleados, cf);

				List<GenericEmpleadoResultItemDto> data = cfDataEmpleados.get();
				if (CollectionUtils.isNotEmpty(data)) {
					List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado = trabajoEmpleadoEstadoMapper
							.genericEmpleadoResultItemDtoToTrabajoEmpleadoEstadoDto(data, trabajo);
					if (CollectionUtils.isNotEmpty(trabajoEmpleadoEstado)) {
						AsyncUtils.checkAsyncAvaliable(cfPersist, getEmpleadosDto.getFilter().getMaxPersistenceSize());
						CompletableFuture<Void> cfSave = trabajoEmpleadoEstadoAsyncService.save(trabajoEmpleadoEstado);
						AsyncUtils.exceptionally(cfSave, cf, cfPersist);
					}
				}
				hasNext = empleadosRequest.nextPage();
			} while (hasNext);
			AsyncUtils.waitAllOfIsOk(cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

}