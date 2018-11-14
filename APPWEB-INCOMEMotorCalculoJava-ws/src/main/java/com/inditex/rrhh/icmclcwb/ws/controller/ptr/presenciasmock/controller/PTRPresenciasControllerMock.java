package com.inditex.rrhh.icmclcwb.ws.controller.ptr.presenciasmock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasDetalleResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaSeccionResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.TiposHorasResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasServiceMock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/presenciasServiceMock")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PTRPresenciasControllerMock {

	@Autowired
	private PtrPresenciasServiceMock ptrPresenciasServiceMock;

	@ApiOperation(value = "PostPresenciasDetalleComisionable")
	@PostMapping(path = "/presenciasDetalleComisionable")
	public PresenciasDetalleResponseListDto presenciasDetalleComisionable(
			@Valid @RequestBody final PresenciasDetalleRequestDto presencias) {
		return PresenciasDetalleResponseListDto.builder().list(ptrPresenciasServiceMock.presenciasDetalle(presencias))
				.build();
	}

	@ApiOperation(value = "PostPresenciasDetalle")
	@PostMapping(path = "/presenciasDetalle")
	public PresenciasDetalleResponseListDto presenciasDetalle(
			@Valid @RequestBody final PresenciasDetalleRequestDto presencias) {
		return PresenciasDetalleResponseListDto.builder().list(ptrPresenciasServiceMock.presenciasDetalle(presencias))
				.build();
	}

	@ApiOperation(value = "PostPresenciasTotalTienda")
	@PostMapping(path = "/presenciasTotalTienda")
	public PresenciasTotalTiendaResponseListDto presenciasTotalTienda(
			@Valid @RequestBody final PresenciasTotalTiendaRequestDto presencias) {
		return PresenciasTotalTiendaResponseListDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTienda(presencias)).build();
	}

	@ApiOperation(value = "PostPresenciasTotalTiendaSeccion")
	@PostMapping(path = "/presenciasTotalTiendaSeccion")
	public PresenciasTotalTiendaSeccionResponseListDto presenciasTiendaSeccion(
			@Valid @RequestBody final PresenciasTotalTiendaSeccionRequestDto presencias) {
		return PresenciasTotalTiendaSeccionResponseListDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTiendaSeccion(presencias)).build();
	}

	@ApiOperation(value = "PostTiposHoras")
	@PostMapping(path = "/tiposHoras")
	public TiposHorasResponseListDto tiposHoras(@Valid @RequestBody final TiposHorasRequestDto tiposHoras) {
		return TiposHorasResponseListDto.builder().list(ptrPresenciasServiceMock.tiposHoras(tiposHoras)).build();
	}

}