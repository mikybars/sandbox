package com.inditex.rrhh.icmclcwb.ws.controller.ptr.mock;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;
import com.inditex.rrhh.icmclcwb.api.service.ptr.PTRPresenciasServiceMock;

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

	
	@ApiOperation(value = "GetPresenciasDetalleComisionable")
	@GetMapping(path = "/presenciasDetalleComisionable")
	public PresenciasDetalleComisionableResponseDTO presenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO  presencias){
		return this.presenciasService.PresenciasDetalleComisionable(presencias);
	}
	
	@ApiOperation(value = "GetPresenciasDetalle")
	@GetMapping(path = "/presenciasDetalle/{id}")
	public PresenciasDetalleResponseDTO presenciasDetalle(@PathVariable final Integer  id){
		return this.presenciasService.PresenciasDetalle(id);
	}
	
	
	@ApiOperation(value = "GetPresenciasTotalTienda")
	@GetMapping(path = "/presenciasTotalTienda")
	public PresenciasTotalTiendaResponseDTO presenciasTotalTienda(PresenciasTotalTiendaRequestDTO  presencias){
		return this.presenciasService.PresenciasTotalTienda(presencias);
	}
	
	@ApiOperation(value = "GetPresenciasTotalTiendaSeccion")
	@GetMapping(path = "/presenciasTotalTiendaSeccion")
	public PresenciasTotalTiendaSeccionResponseDTO presenciasTiendaSeccion( PresenciasTotalTiendaSeccionRequestDTO  presencias){
		return this.presenciasService.PresenciasTotalTiendaSeccion(presencias);
	}
	
	
	@ApiOperation(value = "GetTiposHoras")
	@GetMapping(path = "/tiposHoras")
	public TiposHorasResponseDTO tiposHoras (TiposHorasRequestDTO tiposHoras){
		return this.presenciasService.TiposHoras(tiposHoras);
	}
}
