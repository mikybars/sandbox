package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.service.PTRVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PTRVentaServiceImpl implements PTRVentaService {

	@Autowired
	private Logger LOG;

	@Autowired
	@Qualifier("ptrClientVenta")
	private RestClient ptrClientVenta;

	@Async
	@Override
	public GetVentaTotalizadoResponseDTO getVentaTotalizado(
					@Valid GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) throws Exception {
		GetVentaTotalizadoResponseDTO result = null;
		LOG.info("Consultando: " + "/ventaGeneralService/getVentaTotalizado");
		ResponseEntity<GetVentaTotalizadoResponseDTO> response = ptrClientVenta.postForEntity(
						"/ventaGeneralService/getVentaTotalizado", getVentaTotalizadoRequest,
						GetVentaTotalizadoResponseDTO.class);
		if (response.getStatusCode().value() == HttpStatus.SC_OK) {
			LOG.info("Ha funcionado (PTR): " + response.getBody().getVentaTotalizado().size());
			result = response.getBody();
		} else {
			LOG.info("Ha fallado (PTR): " + response.getStatusCode().value());
		}
		return result;
	}

}