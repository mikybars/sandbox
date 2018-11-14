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
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;

@Service
@Validated
public class PtrVentaServiceImpl implements PtrVentaService {

	@Autowired
	private Logger LOG;

	@Autowired
	@Qualifier("ptrClientVenta")
	private RestClient ptrClientVenta;
	
	@Autowired
	@Qualifier("ventaTotalizadoDto")
	private PtrPropertiesDto ventaTotalizadoDto;

	@Autowired
	@Qualifier("ventaIndividualDetalleDto")
	private PtrPropertiesDto ventaIndividualDetalleDto;
	
	@Override
	public CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(
			@Valid final GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) throws Exception {
		GetVentaTotalizadoResponseDTO result = null;
		LOG.info("Consultando: " + ventaTotalizadoDto.getEndpoint());
		ResponseEntity<GetVentaTotalizadoResponseDTO> response = ptrClientVenta.postForEntity(
				ventaTotalizadoDto.getEndpoint(), getVentaTotalizadoRequest,
				GetVentaTotalizadoResponseDTO.class);
		if (response.getStatusCode().value() == HttpStatus.SC_OK) {
			if (response.getBody() != null) {
				LOG.info("Ha funcionado (PTR): " + response.getBody().getVentaTotalizado().size());
				result = response.getBody();
			}else{
				LOG.info("Ha funcionado (PTR): Sin resultados");
			}
		} else {
			LOG.info("Ha fallado (PTR): " + response.getStatusCode().value());
		}
		return CompletableFuture.completedFuture(result);
	}
	
	@Override
	public CompletableFuture<GetVentaIndividualDetalleResponseDTO> getVentaIndividualDetalle(
			@Valid final GetVentaIndividualDetalleRequestDTO getVentaIndividualDetalleRequestDto) throws Exception {
		GetVentaIndividualDetalleResponseDTO result = null;
		LOG.info("Consultando: " + ventaIndividualDetalleDto.getEndpoint());
		ResponseEntity<GetVentaIndividualDetalleResponseDTO> response = ptrClientVenta.postForEntity(
				ventaIndividualDetalleDto.getEndpoint(), getVentaIndividualDetalleRequestDto,
				GetVentaIndividualDetalleResponseDTO.class);
		if (response.getStatusCode().value() == HttpStatus.SC_OK) {
			if (response.getBody() != null) {
				LOG.info("Ha funcionado (PTR): " + response.getBody().getVentaIndividualDetalle().size());
				result = response.getBody();
			}else{
				LOG.info("Ha funcionado (PTR): Sin resultados");
			}
		} else {
			LOG.info("Ha fallado (PTR): " + response.getStatusCode().value());
		}
		return CompletableFuture.completedFuture(result);
	}
	

}