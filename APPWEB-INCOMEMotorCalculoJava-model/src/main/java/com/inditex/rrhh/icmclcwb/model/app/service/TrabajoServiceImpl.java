package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.ms.Sender;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private Logger LOG;

	@Autowired
	private TrabajoRepository trabajoRepository;

	@Autowired
	private TrabajoMapper trabajoMapper;

	@Autowired
	private ChunkService chunkService;

	@Autowired
	private Sender sender;

	@Override
	public TrabajoDto createTrabajo(@Valid TrabajoDto trabajo) {
		TrabajoDto result = new TrabajoDto();
		LOG.info("Inicio :: TrabajoService.createTrabajo(): {}", trabajo);
		result = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
		sender.send(result);
		LOG.info("Fin :: TrabajoService.createTrabajo(): {}", result);
		return result;
	}

	@Override
	public TrabajoRunDto run(Long id) throws Exception {
		TrabajoRunDto result = new TrabajoRunDto();
		Boolean resultOp = Boolean.FALSE;
		LOG.info("Trabajo[{}] :: Inicio :: TrabajoService.run()", id);

		LOG.info("Trabajo[{}] :: Inicio :: Bloque :: Validaciones y cargas iniciales", id);

		LOG.info("Trabajo[{}] :: Inicio :: trabajoRepository.findOne()", id);
		TrabajoDto trabajo = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id));
		if (trabajo != null) {
			LOG.info("Trabajo[{}] :: Fin :: trabajoRepository.findOne(): {}", id, trabajo);

			// TODO Cambiar el estado del Trabajo a en curso (Historificar cambio de estado)
			LOG.info("Trabajo[{}] :: Inicio :: trabajoRepository.save(): {}", id, trabajo);
			// trabajo.setIdEstado(Constants.EstadoTrabajoEnum.ESTADO_TRABAJO_EN_CURSO_VALIDACIONES_INICIALES.getId());
			trabajo = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
			LOG.info("Trabajo[{}] :: Fin :: trabajoRepository.save(): {}", id, trabajo);

			LOG.info("Trabajo[{}] :: Fin :: Bloque :: Validaciones y cargas iniciales", id);

			LOG.info("Trabajo[{}] :: Inicio :: Bloque :: Carga de de datos intermedios", id);

			// Se recuperan los tipos de horas de forma asincrona
			// TODO

			// Se recuperan/procesan las tiendas
			Set<String> tiendas = new HashSet<>();
			if (StringUtils.isNotBlank(trabajo.getIdEmpleado())) {
				// TODO Empleado :: Obtener las tiendas comisionables en las que ha estado el
				// empleado
			} else if (StringUtils.isNotBlank(trabajo.getIdTienda())) {
				// TODO Tienda :: Directamente se usa la tienda enviada
				LOG.info("Trabajo[{}] :: Inicio :: tiendas.putIfAbsent(): {}", id, trabajo.getIdTienda());
				tiendas.add(trabajo.getIdTienda());
				LOG.info("Trabajo[{}] :: Fin :: tiendas.putIfAbsent(): {}", id, tiendas);
			} else if (StringUtils.isNotBlank(trabajo.getIdPais()) && StringUtils.isNotBlank(trabajo.getIdCadena())) {
				// TODO Pais + Cadena :: Se obtienen las tiendas
			} else if (StringUtils.isNotBlank(trabajo.getIdPais())) {
				// TODO Pais :: Se obtienen las tiendas
			}
			// TODO Se valida si no se ha validado antes que las tiendas sean comisionables

			// Datos de tienda
			// TODO Obtener los datos de venta globales de las tiendas
			// TODO Obtener los datos de presencias totalizadas de las tiendas

			// Datos de empleado
			// Obtenemos o almacenamos en una tabla temporal la relación de Empleado ->
			// Tienda
			// TODO ¡¡ Deberíamos poder buscar por tienda/s, pais + cadena y pais !!
			// Obtenemos el IdBusqueda de la operación, luego cada operación de obtención de
			// datos en un sistema externo tiene que o usar la búsqueda o sino tenemos que
			// guardar en una tabla temporal el id de empleados y su tienda
			CompletableFuture<List<EmpleadosTiendaResultItemDto>> cfEmpleados = chunkService
					.getEmpleadosTienda(trabajo);
			LOG.info("Trabajo[{}] :: Inicio :: CompletableFuture.allOf()", id);
			CompletableFuture<Void> cfDatosIntermedios = CompletableFuture.allOf(cfEmpleados);
			LOG.info("Trabajo[{}] :: Inicio :: CompletableFuture.allOf()", id);

			// TODO Cuanto termine 'cfEmpleados' se lanza la obtención de datos de empleados
			CompletableFuture.allOf(cfEmpleados);

			List<EmpleadosTiendaResultItemDto> empleados = cfEmpleados.get();
			if (CollectionUtils.isNotEmpty(empleados)) {
				LOG.info("Ha funcionado (obtenerEmpleadosTiendaRResult): " + empleados.size());
				GetVentaTotalizadoRequestDTO paramGetVentaTotalizado = new GetVentaTotalizadoRequestDTO();
				paramGetVentaTotalizado.setFechaDesde("2017-11-01");
				paramGetVentaTotalizado.setFechaHasta("2017-11-30");
				paramGetVentaTotalizado.setPais("11");
				paramGetVentaTotalizado.setCadena("1");
				// paramGetVentaTotalizado.setTienda(Arrays.asList("160"));
				paramGetVentaTotalizado.setTienda(new ArrayList<>());
				CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizadoResponse = chunkService
						.getVentaTotalizado(paramGetVentaTotalizado);
				CompletableFuture<Void> finGetVentaTotalizado = CompletableFuture.allOf(getVentaTotalizadoResponse);
				GetVentaTotalizadoResponseDTO getVentaTotalizadoResult = getVentaTotalizadoResponse.get();
				if (getVentaTotalizadoResult != null
						&& CollectionUtils.isNotEmpty(getVentaTotalizadoResult.getVentaTotalizado())) {
					LOG.info("Ha funcionado (obtenerEmpleadosTiendaRResult): "
							+ getVentaTotalizadoResult.getVentaTotalizado().size());
				}
				resultOp = Boolean.TRUE;
			} else {
				LOG.info("No se han recuperado registros");
			}

			LOG.info("Trabajo[{}] :: Fin :: Bloque :: Carga de de datos intermedios", id);

			LOG.info("Trabajo[{}] :: Inicio :: Bloque :: Ejecución del cálculo", id);
			// TODO
			LOG.info("Trabajo[{}] :: Fin :: Bloque :: Ejecución del cálculo", id);

			LOG.info("Trabajo[{}] :: Inicio :: Bloque :: Validaciones y cargas finales", id);
			// TODO
			result.setTrabajo(trabajo);
			result.setResultado(resultOp);
			LOG.info("Trabajo[{}] :: Inicio :: Bloque :: Validaciones y cargas finales", id);
		} else {
			LOG.error("No existe el trabajo");
		}

		LOG.info("Fin :: TrabajoService.run(): " + result.toString());
		return result;
	}

}