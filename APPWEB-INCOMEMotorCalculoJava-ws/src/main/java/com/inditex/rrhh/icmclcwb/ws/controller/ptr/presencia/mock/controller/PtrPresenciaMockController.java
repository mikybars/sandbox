package com.inditex.rrhh.icmclcwb.ws.controller.ptr.presencia.mock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/presenciasMockService/presenciasService")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PtrPresenciaMockController {

	@Autowired
	private PtrPresenciaMockService ptrPresenciasServiceMock;

	@ApiOperation(value = "Busca presencias detalladas")
	@PostMapping(path = "/presenciasDetalle")
	public PtrPresenciaDetalleResponseDto presenciasDetalle(
			@Valid @RequestBody final PtrPresenciaDetalleRequestDto presencias) {
		return PtrPresenciaDetalleResponseDto.builder().list(ptrPresenciasServiceMock.presenciasDetalle(presencias))
				.build();
	}

	@ApiOperation(value = "Busca presencias comisionables")
	@PostMapping(path = "/presenciasDetalleComisionable")
	public PtrPresenciaDetalleComisionableResponseDto presenciasDetalleComisionable(
			@Valid @RequestBody final PtrPresenciaDetalleComisionableRequestDto presencias) {
		return PtrPresenciaDetalleComisionableResponseDto.builder()
				.list(ptrPresenciasServiceMock.presenciasDetalleComisionable(presencias)).build();
	}

	@ApiOperation(value = "Busca presencias por tienda")
	@PostMapping(path = "/presenciasTotalTienda")
	public PtrPresenciaTotalTiendaResponseDto presenciasTotalTienda(
			@Valid @RequestBody final PtrPresenciaTotalTiendaRequestDto presencias) {
		return PtrPresenciaTotalTiendaResponseDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTienda(presencias)).build();
	}

	@ApiOperation(value = "Busca presencias por tienda o seccion")
	@PostMapping(path = "/presenciasTotalTiendaSeccion")
	public PtrPresenciaTotalTiendaSeccionResponseDto presenciasTiendaSeccion(
			@Valid @RequestBody final PtrPresenciaTotalTiendaSeccionRequestDto presencias) {
		return PtrPresenciaTotalTiendaSeccionResponseDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTiendaSeccion(presencias)).build();
	}

	@ApiOperation(value = "Busca tipos horas ")
	@PostMapping(path = "/tiposHoras")
	public PtrPresenciaTiposHorasResponseDto tiposHoras(@Valid @RequestBody final PtrPresenciaTiposHorasRequestDto tiposHoras) {
		return PtrPresenciaTiposHorasResponseDto.builder().list(ptrPresenciasServiceMock.tiposHoras(tiposHoras)).build();
	}

}