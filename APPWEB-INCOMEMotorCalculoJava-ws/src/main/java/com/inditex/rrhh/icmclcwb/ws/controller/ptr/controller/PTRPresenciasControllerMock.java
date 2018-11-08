package com.inditex.rrhh.icmclcwb.ws.controller.ptr.controller;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasDetalleResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaSeccionResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.TiposHorasResponseListDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasServiceMock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;



@Validated
@RestController
@RequestMapping(path = "/presenciasServiceMock")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PTRPresenciasControllerMock {

	@Autowired
	private Logger LOG;

    @Autowired
    private PtrPresenciasServiceMock presenciasService;
    
    
	@ApiOperation(value = "PostPresenciasDetalleComisionable")
	@PostMapping(path = "/presenciasDetalleComisionable")
	public PresenciasDetalleResponseListDto presenciasDetalleComisionable(@Valid @RequestBody final PresenciasDetalleRequestDto presencias){
		List<PresenciasDetalleResponseDto> list =this.presenciasService.PresenciasDetalle(presencias);
		PresenciasDetalleResponseListDto response =new PresenciasDetalleResponseListDto();
		response.setList(list);
		return response;
	}
	
	@ApiOperation(value = "PostPresenciasDetalle")
	@PostMapping(path = "/presenciasDetalle")
	public PresenciasDetalleResponseListDto presenciasDetalle(@Valid @RequestBody final PresenciasDetalleRequestDto presencias){
		List<PresenciasDetalleResponseDto> list =this.presenciasService.PresenciasDetalle(presencias);
		PresenciasDetalleResponseListDto response =new PresenciasDetalleResponseListDto();
		response.setList(list);
		return response;
	}
	
	
	@ApiOperation(value = "PostPresenciasTotalTienda")
	@PostMapping(path = "/presenciasTotalTienda")
	public PresenciasTotalTiendaResponseListDto presenciasTotalTienda(@Valid @RequestBody final PresenciasTotalTiendaRequestDto  presencias){
		PresenciasTotalTiendaResponseListDto lista = new PresenciasTotalTiendaResponseListDto();
		lista.setList(this.presenciasService.PresenciasTotalTienda(presencias));
		return lista;
	}
	
	@ApiOperation(value = "PostPresenciasTotalTiendaSeccion")
	@PostMapping(path = "/presenciasTotalTiendaSeccion")
	public PresenciasTotalTiendaSeccionResponseListDto presenciasTiendaSeccion(@Valid @RequestBody final PresenciasTotalTiendaSeccionRequestDto  presencias){
		PresenciasTotalTiendaSeccionResponseListDto lista = new PresenciasTotalTiendaSeccionResponseListDto();
		lista.setList(this.presenciasService.PresenciasTotalTiendaSeccion(presencias));
		return lista;	
	}
	
	
	@ApiOperation(value = "PostTiposHoras")
	@PostMapping(path = "/tiposHoras")
	public TiposHorasResponseListDto tiposHoras (@Valid @RequestBody final TiposHorasRequestDto tiposHoras){
		TiposHorasResponseListDto lista = new TiposHorasResponseListDto();
		lista.setLista(this.presenciasService.TiposHoras(tiposHoras));
		return lista;
	}
}
