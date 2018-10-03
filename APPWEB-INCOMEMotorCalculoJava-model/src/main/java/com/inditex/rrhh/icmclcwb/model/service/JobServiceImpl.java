package com.inditex.rrhh.icmclcwb.model.service;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.dto.JobDTO;
import com.inditex.rrhh.icmclcwb.api.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.service.JobService;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;

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
    private ChunkService chunkService;
    
	@Override
	public Integer createJob(@Valid JobDTO job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteJob(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyJob(@Valid JobDTO job) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JobDTO findJob(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobDTO> findJobs(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GetEmpleadosTiendaResultItemDTO> test() {
		List<GetEmpleadosTiendaResultItemDTO> result = new ArrayList<GetEmpleadosTiendaResultItemDTO>();
		try {
			CompletableFuture<List<GetEmpleadosTiendaResultItemDTO>> obtenerEmpleadosTiendaResult = chunkService.obtenerEmpleadosTienda("T160");
			CompletableFuture<Void> fin = CompletableFuture.allOf(obtenerEmpleadosTiendaResult);
			result = obtenerEmpleadosTiendaResult.get();
			if (Boolean.TRUE.equals(result)) {
				LOG.info("Ha funcionado: " + result.size());
			} else {
				LOG.info("No se han recuperado registros");
			}
		} catch (InterruptedException | ExecutionException e) {
			LOG.error("Error no controlado");
		}
		return result;
	}

}