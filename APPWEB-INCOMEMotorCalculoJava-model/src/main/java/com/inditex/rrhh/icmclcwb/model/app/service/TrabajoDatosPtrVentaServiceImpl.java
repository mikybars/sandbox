package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
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
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;
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
	private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

	@Autowired
	private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

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
			@NotNull final List<TipoTrabajoTiendaDto> tipoTrabajoTienda,
			@Valid final TrabajoRunDatosDto trabajoRunDatos) throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			List<Long> tipoTrabajoTiendaId = tipoTrabajoTienda.stream().map(TipoTrabajoTiendaDto::getId)
					.collect(Collectors.toList());
			Page<TrabajoTiendaEstado> page;
			Pageable pageable = new PageRequest(0, ventaTotalizadoDto.getFilter().getMaxPageSize());
			do {
				page = trabajoTiendaEstadoRepository.findByTrabajoIdAndTipoIdIn(trabajo.getId(), tipoTrabajoTiendaId,
						pageable);
				if (CollectionUtils.isNotEmpty(page.getContent())) {
					List<String> tiendas = page.getContent().stream().map(TrabajoTiendaEstado::getIdTienda)
							.collect(Collectors.toList());

					PtrVentaTotalizadoRequestDto paramGetVentaTotalizado = trabajoMapper
							.trabajoDtoToPtrVentaTotalizadoRequestDto(trabajo);
					paramGetVentaTotalizado.setTienda(tiendas);
					paramGetVentaTotalizado.getCadena().addAll(trabajoRunDatos.getCadenasEmpresa());
					paramGetVentaTotalizado.setAgrupacion(PtrConstants.AGRUPACION_TOTALIZADA);

					CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = ptrVentaAsyncService
							.getVentaTotalizado(paramGetVentaTotalizado);
					AsyncUtils.exceptionally(cfData, cf, cfPersist);

					PtrVentaTotalizadoResponseDto data = cfData.get();

					if (data != null && CollectionUtils.isNotEmpty(data.getVentaTotalizado())) {
						AsyncUtils.checkAsyncAvaliable(cfPersist,
								ventaTotalizadoDto.getFilter().getMaxPersistenceSize());
						AsyncUtils.exceptionally(
								trabajoTiendaSeccionVentaAsyncService.save(data.getVentaTotalizado(), trabajo), cf,
								cfPersist);
					}
				}

				pageable = page.nextPageable();

			} while (page.hasNext());

			AsyncUtils.waitAllOfIsOk(cf, cf);

			if (RunUtils.isPivot(trabajo, tipoTrabajoTienda)) {
				trabajoTiendaVentaSeccionRepository.save(trabajo);
			}
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

	@AuditoriaTrabajo
	@Override
	public void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo, @Valid final TrabajoRunDatosDto trabajoRunDatos)
			throws Exception {
		List<CompletableFuture<?>> cf = new ArrayList<>();
		try {
			List<CompletableFuture<?>> cfPersist = new ArrayList<>();
			Page<TrabajoEmpleadoEstado> page;
			Pageable pageable = new PageRequest(0, ventaIndividualDetalleDto.getFilter().getMaxPageSize());
			do {

				page = trabajoEmpleadoEstadoRepository.findByTrabajoId(trabajo.getId(), pageable);

				if (CollectionUtils.isNotEmpty(page.getContent())) {

					List<Integer> empleados = page.getContent().stream().map(e -> Integer.valueOf(e.getIdEmpleado()))
							.collect(Collectors.toList());

					PtrVentaIndividualDetalleRequestDto paramGetVentaIndividualDetalle = trabajoMapper
							.trabajoDtoToPtrVentaIndividualDetalleRequestDto(trabajo);
					paramGetVentaIndividualDetalle.setVendedores(empleados);
					paramGetVentaIndividualDetalle.getCadena().addAll(trabajoRunDatos.getCadenasEmpresa());
					paramGetVentaIndividualDetalle.setTienda(new ArrayList<>());
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
				pageable = page.nextPageable();
			} while (page.hasNext());

			AsyncUtils.waitAllOfIsOk(cf, cf);
		} catch (Exception e) {
			AsyncUtils.cancel(cf);
			throw e;
		}
	}

}