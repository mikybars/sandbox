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

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.JobRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.JobService;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.JobMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JobRepository;
import com.inditex.rrhh.icmclcwb.ms.Sender;

@Service
@Validated
public class JobServiceImpl implements JobService {

	@Autowired
	private Logger LOG;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private ChunkService chunkService;

	@Autowired
	private Sender sender;

	@Override
	public JobDto createJob(@Valid JobDto job) {
		JobDto result = new JobDto();
		LOG.info("Inicio :: JobService.createJob(): {}", job);
		result = jobMapper.jobToJobDto(jobRepository.save(jobMapper.jobDtoToJob(job)));
		sender.send(result);
		LOG.info("Fin :: JobService.createJob(): {}", result);
		return result;
	}

	@Override
	public JobRunDto run(Long id) throws Exception {
		JobRunDto result = new JobRunDto();
		Boolean resultOp = Boolean.FALSE;
		LOG.info("Job[{}] :: Inicio :: JobService.run()", id);

		LOG.info("Job[{}] :: Inicio :: Bloque :: Validaciones y cargas iniciales", id);

		LOG.info("Job[{}] :: Inicio :: jobRepository.findOne()", id);
		JobDto job = jobMapper.jobToJobDto(jobRepository.findOne(id));
		if (job != null) {
			LOG.info("Job[{}] :: Fin :: jobRepository.findOne(): {}", id, job);

			// TODO Cambiar el estado del Job a en curso (Historificar cambio de estado)
			LOG.info("Job[{}] :: Inicio :: jobRepository.save(): {}", id, job);
			// job.setIdEstado(Constants.JobStatusEnum.ESTADO_JOB_EN_CURSO_VALIDACIONES_INICIALES.getId());
			job = jobMapper.jobToJobDto(jobRepository.save(jobMapper.jobDtoToJob(job)));
			LOG.info("Job[{}] :: Fin :: jobRepository.save(): {}", id, job);

			LOG.info("Job[{}] :: Fin :: Bloque :: Validaciones y cargas iniciales", id);

			LOG.info("Job[{}] :: Inicio :: Bloque :: Carga de de datos intermedios", id);

			// Se recuperan los tipos de horas de forma asincrona
			// TODO

			// Se recuperan/procesan las tiendas
			Set<String> tiendas = new HashSet<>();
			if (StringUtils.isNotBlank(job.getIdEmpleado())) {
				// TODO Empleado :: Obtener las tiendas comisionables en las que ha estado el
				// empleado
			} else if (StringUtils.isNotBlank(job.getIdTienda())) {
				// TODO Tienda :: Directamente se usa la tienda enviada
				LOG.info("Job[{}] :: Inicio :: tiendas.putIfAbsent(): {}", id, job.getIdTienda());
				tiendas.add(job.getIdTienda());
				LOG.info("Job[{}] :: Fin :: tiendas.putIfAbsent(): {}", id, tiendas);
			} else if (StringUtils.isNotBlank(job.getIdPais()) && StringUtils.isNotBlank(job.getIdCadena())) {
				// TODO Pais + Cadena :: Se obtienen las tiendas
			} else if (StringUtils.isNotBlank(job.getIdPais())) {
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
			CompletableFuture<List<EmpleadosTiendaResultItemDTO>> cfEmpleados = chunkService
					.getEmpleadosTienda(job);
			LOG.info("Job[{}] :: Inicio :: CompletableFuture.allOf()", id);
			CompletableFuture<Void> cfDatosIntermedios = CompletableFuture.allOf(cfEmpleados);
			LOG.info("Job[{}] :: Inicio :: CompletableFuture.allOf()", id);

			// TODO Cuanto termine 'cfEmpleados' se lanza la obtención de datos de empleados
			CompletableFuture.allOf(cfEmpleados);

			List<EmpleadosTiendaResultItemDTO> empleados = cfEmpleados.get();
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

			LOG.info("Job[{}] :: Fin :: Bloque :: Carga de de datos intermedios", id);

			LOG.info("Job[{}] :: Inicio :: Bloque :: Ejecución del cálculo", id);
			// TODO
			LOG.info("Job[{}] :: Fin :: Bloque :: Ejecución del cálculo", id);

			LOG.info("Job[{}] :: Inicio :: Bloque :: Validaciones y cargas finales", id);
			// TODO
			result.setJob(job);
			result.setResult(resultOp);
			LOG.info("Job[{}] :: Inicio :: Bloque :: Validaciones y cargas finales", id);
		} else {
			LOG.error("No existe el job");
		}

		LOG.info("Fin :: JobService.run(): " + result.toString());
		return result;
	}

}