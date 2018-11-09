package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PTRVentaService;

@Service
@Validated
public class PTRVentaServiceImpl implements PTRVentaService {

	@Autowired
	private Logger LOG;

	@Autowired
	@Qualifier("ptrClientVenta")
	private RestClient ptrClientVenta;
	
	@Autowired
	@Qualifier("ptrClientVentaDto")
	private PtrPropertiesDto ptrClientVentaDto;

	@Override
	public CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(
			@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) throws Exception {
		GetVentaTotalizadoResponseDTO result = null;
		LOG.info("Consultando: " + ptrClientVentaDto.getEndpoint());
		ResponseEntity<GetVentaTotalizadoResponseDTO> response = ptrClientVenta.postForEntity(
				ptrClientVentaDto.getEndpoint(), getVentaTotalizadoRequest,
				GetVentaTotalizadoResponseDTO.class);
		if (response.getStatusCode().value() == HttpStatus.SC_OK) {
			LOG.info("Ha funcionado (PTR): " + response.getBody().getVentaTotalizado().size());
			result = response.getBody();
		} else {
			LOG.info("Ha fallado (PTR): " + response.getStatusCode().value());
		}
		return CompletableFuture.completedFuture(result);
	}
	

}