package com.inditex.rrhh.icmclcwb.ws.controller.ptr.presenciasmock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/presenciasServiceMock")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PtrPresenciasMockController {

	@Autowired
	private PtrPresenciaMockService ptrPresenciasServiceMock;

	@ApiOperation(value = "Busca presencias detalladas")
	@PostMapping(path = "/presenciasDetalle")
	public PtrPresenciasDetalleResponseDto presenciasDetalle(
			@Valid @RequestBody final PtrPresenciasDetalleRequestDto presencias) {
		return PtrPresenciasDetalleResponseDto.builder().list(ptrPresenciasServiceMock.presenciasDetalle(presencias))
				.build();
	}

	@ApiOperation(value = "Busca presencias comisionables")
	@PostMapping(path = "/presenciasDetalleComisionable")
	public PtrPresenciasDetalleComisionableResponseDto presenciasDetalleComisionable(
			@Valid @RequestBody final PtrPresenciasDetalleComisionableRequestDto presencias) {
		return PtrPresenciasDetalleComisionableResponseDto.builder()
				.list(ptrPresenciasServiceMock.presenciasDetalleComisionable(presencias)).build();
	}

	@ApiOperation(value = "Busca presencias por tienda")
	@PostMapping(path = "/presenciasTotalTienda")
	public PtrPresenciasTotalTiendaResponseDto presenciasTotalTienda(
			@Valid @RequestBody final PtrPresenciasTotalTiendaRequestDto presencias) {
		return PtrPresenciasTotalTiendaResponseDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTienda(presencias)).build();
	}

	@ApiOperation(value = "Busca presencias por tienda o seccion")
	@PostMapping(path = "/presenciasTotalTiendaSeccion")
	public PtrPresenciasTotalTiendaSeccionResponseDto presenciasTiendaSeccion(
			@Valid @RequestBody final PtrPresenciasTotalTiendaSeccionRequestDto presencias) {
		return PtrPresenciasTotalTiendaSeccionResponseDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTiendaSeccion(presencias)).build();
	}

	@ApiOperation(value = "Busca tipos horas ")
	@PostMapping(path = "/tiposHoras")
	public PtrPresenciasTiposHorasResponseDto tiposHoras(@Valid @RequestBody final PtrPresenciasTiposHorasRequestDto tiposHoras) {
		return PtrPresenciasTiposHorasResponseDto.builder().list(ptrPresenciasServiceMock.tiposHoras(tiposHoras)).build();
	}

}