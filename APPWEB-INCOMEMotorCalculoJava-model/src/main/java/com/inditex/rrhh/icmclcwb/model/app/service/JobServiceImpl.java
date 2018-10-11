package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.JobService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.JobMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JobRepository;
import com.inditex.rrhh.icmclcwb.ms.Sender;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

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
		LOG.info("Inicio :: JobService.createJob(): " + job.toString());
		result = jobMapper.jobToJobDto(jobRepository.save(jobMapper.jobDtoToJob(job)));
		sender.send(result);
		LOG.info("Fin :: JobService.createJob(): " + result.toString());
		return result;
	}

	@Override
	public JobDto run(Long id) {
		JobDto result = new JobDto();
		LOG.info("Inicio :: JobService.run(): " + id);
		result = jobMapper.jobToJobDto(jobRepository.findOne(id));
		LOG.info("Fin :: JobService.run(): " + result.toString());
		return result;
	}

	//TODO ELIMINAR
	private Boolean test() {
		Boolean result = Boolean.FALSE;
		try {
			List<GetEmpleadosTiendaResultItemDTO> obtenerEmpleadosTiendaResult = new ArrayList<>();
			CompletableFuture<List<GetEmpleadosTiendaResultItemDTO>> obtenerEmpleadosTiendaResponse = chunkService
							.obtenerEmpleadosTienda("T160");
			CompletableFuture<Void> fin = CompletableFuture.allOf(obtenerEmpleadosTiendaResponse);
			obtenerEmpleadosTiendaResult = obtenerEmpleadosTiendaResponse.get();
			if (CollectionUtils.isNotEmpty(obtenerEmpleadosTiendaResult)) {
				LOG.info("Ha funcionado (obtenerEmpleadosTiendaRResult): " + obtenerEmpleadosTiendaResult.size());
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
				result = Boolean.TRUE;
			} else {
				LOG.info("No se han recuperado registros");
			}
		} catch (InterruptedException | ExecutionException e) {
			LOG.error("Error no controlado");
		}
		return result;
	}

}