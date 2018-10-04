package com.inditex.rrhh.icmclcwb.model.service.ptr;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.service.ptr.PTRPresenciasService;
import com.inditex.rrhh.icmclcwb.api.ws.ptr.dto.venta.GetVentaTotalizadoResponseDTO;

public class PTRPresenciasServiceImpl implements PTRPresenciasService{

	@Autowired
	private Logger LOG;

	@Autowired
	@Qualifier("ptrClientPresencia")
	private RestClient ptrClientPresencia;
	
	
	
	@Override
	public PresenciasDetalleResponseDTO getVentaTotalizado(@Valid PresenciasDetalleRequestDTO presencias)
			throws Exception {
		PresenciasDetalleResponseDTO result = null;
		LOG.info("Consultando: " + "/ventaGeneralService/getVentaTotalizado");
		ResponseEntity<PresenciasDetalleResponseDTO> response = ptrClientPresencia.postForEntity(
						"/ventaGeneralService/getVentaTotalizado", presencias,
						PresenciasDetalleResponseDTO.class);
		if (response.getStatusCode().value() == HttpStatus.SC_OK) {
			LOG.info("Ha funcionado (PTR): " + response.getBody().getPersona().intValue());
			result = response.getBody();
		} else {
			LOG.info("Ha fallado (PTR): " + response.getStatusCode().value());
		}
		return result;
	}

}
