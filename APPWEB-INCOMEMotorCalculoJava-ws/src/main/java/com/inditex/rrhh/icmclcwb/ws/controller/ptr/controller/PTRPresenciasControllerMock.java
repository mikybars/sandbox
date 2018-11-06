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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasDetalleResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.PresenciasTotalTiendaSeccionResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list.TiposHorasResponseListDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PTRPresenciasServiceMock;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;



@Validated
@RestController
@RequestMapping(path = "/presenciasServiceMock")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PTRPresenciasControllerMock {

	@Autowired
	private Logger LOG;

    @Autowired
    private PTRPresenciasServiceMock presenciasService;

	
	@ApiOperation(value = "PostPresenciasDetalleComisionable")
	@PostMapping(path = "/presenciasDetalleComisionable")
	public PresenciasDetalleResponseListDTO presenciasDetalleComisionable(@Valid @RequestBody final PresenciasDetalleRequestDTO presencias){
		List<PresenciasDetalleResponseDTO> list =this.presenciasService.PresenciasDetalle(presencias);
		PresenciasDetalleResponseListDTO response =new PresenciasDetalleResponseListDTO();
		response.setList(list);
		return response;
	}
	
	@ApiOperation(value = "PostPresenciasDetalle")
	@PostMapping(path = "/presenciasDetalle")
	public PresenciasDetalleResponseListDTO presenciasDetalle(@Valid @RequestBody final PresenciasDetalleRequestDTO presencias){
		List<PresenciasDetalleResponseDTO> list =this.presenciasService.PresenciasDetalle(presencias);
		PresenciasDetalleResponseListDTO response =new PresenciasDetalleResponseListDTO();
		response.setList(list);
		return response;
	}
	
	
	@ApiOperation(value = "PostPresenciasTotalTienda")
	@PostMapping(path = "/presenciasTotalTienda")
	public PresenciasTotalTiendaResponseListDTO presenciasTotalTienda(@Valid @RequestBody final PresenciasTotalTiendaRequestDTO  presencias){
		PresenciasTotalTiendaResponseListDTO lista = new PresenciasTotalTiendaResponseListDTO();
		lista.setList(this.presenciasService.PresenciasTotalTienda(presencias));
		return lista;
	}
	
	@ApiOperation(value = "PostPresenciasTotalTiendaSeccion")
	@PostMapping(path = "/presenciasTotalTiendaSeccion")
	public PresenciasTotalTiendaSeccionResponseListDTO presenciasTiendaSeccion(@Valid @RequestBody final PresenciasTotalTiendaSeccionRequestDTO  presencias){
		PresenciasTotalTiendaSeccionResponseListDTO lista = new PresenciasTotalTiendaSeccionResponseListDTO();
		lista.setList(this.presenciasService.PresenciasTotalTiendaSeccion(presencias));
		return lista;	
	}
	
	
	@ApiOperation(value = "PostTiposHoras")
	@PostMapping(path = "/tiposHoras")
	public TiposHorasResponseListDTO tiposHoras (@Valid @RequestBody final TiposHorasRequestDTO tiposHoras){
		TiposHorasResponseListDTO lista = new TiposHorasResponseListDTO();
		lista.setLista(this.presenciasService.TiposHoras(tiposHoras));
		return lista;
	}
}
