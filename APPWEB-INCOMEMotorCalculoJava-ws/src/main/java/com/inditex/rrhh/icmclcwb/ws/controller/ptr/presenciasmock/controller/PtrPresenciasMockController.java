package com.inditex.rrhh.icmclcwb.ws.controller.ptr.presenciasmock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockDetalleComisionableResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockDetalleResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockTotalTiendaResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockTotalTiendaSeccionResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PtrPresenciasMockTiposHorasResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;

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
	public PtrPresenciasMockDetalleResponseListDto presenciasDetalle(
			@Valid @RequestBody final PtrPresenciasMockDetalleRequestDto presencias) {
		return PtrPresenciasMockDetalleResponseListDto.builder().list(ptrPresenciasServiceMock.presenciasDetalle(presencias))
				.build();
	}

	@ApiOperation(value = "Busca presencias comisionables")
	@PostMapping(path = "/presenciasDetalleComisionable")
	public PtrPresenciasMockDetalleComisionableResponseListDto presenciasDetalleComisionable(
			@Valid @RequestBody final PtrPresenciasMockDetalleComisionableRequestDto presencias) {
		return PtrPresenciasMockDetalleComisionableResponseListDto.builder()
				.list(ptrPresenciasServiceMock.presenciasDetalleComisionable(presencias)).build();
	}

	@ApiOperation(value = "Busca presencias por tienda")
	@PostMapping(path = "/presenciasTotalTienda")
	public PtrPresenciasMockTotalTiendaResponseListDto presenciasTotalTienda(
			@Valid @RequestBody final PtrPresenciasMockTotalTiendaRequestDto presencias) {
		return PtrPresenciasMockTotalTiendaResponseListDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTienda(presencias)).build();
	}

	@ApiOperation(value = "Busca presencias por tienda o seccion")
	@PostMapping(path = "/presenciasTotalTiendaSeccion")
	public PtrPresenciasMockTotalTiendaSeccionResponseListDto presenciasTiendaSeccion(
			@Valid @RequestBody final PtrPresenciasMockTotalTiendaSeccionRequestDto presencias) {
		return PtrPresenciasMockTotalTiendaSeccionResponseListDto.builder()
				.list(ptrPresenciasServiceMock.presenciasTotalTiendaSeccion(presencias)).build();
	}

	@ApiOperation(value = "Busca tipos horas ")
	@PostMapping(path = "/tiposHoras")
	public PtrPresenciasMockTiposHorasResponseListDto tiposHoras(@Valid @RequestBody final PtrPresenciasMockTiposHorasRequestDto tiposHoras) {
		return PtrPresenciasMockTiposHorasResponseListDto.builder().list(ptrPresenciasServiceMock.tiposHoras(tiposHoras)).build();
	}

}