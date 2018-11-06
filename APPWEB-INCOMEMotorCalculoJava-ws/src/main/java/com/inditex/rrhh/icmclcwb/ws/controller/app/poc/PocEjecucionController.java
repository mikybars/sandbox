package com.inditex.rrhh.icmclcwb.ws.controller.app.poc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocEjecucionDto;
import com.inditex.rrhh.icmclcwb.api.app.service.poc.PocEjecucionService;
import com.inditex.rrhh.icmclcwb.api.app.util.poc.PocConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/poc/ejecucion")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class PocEjecucionController {

	@Autowired
	private PocEjecucionService pocEjecucionService;

	@GetMapping
	@ApiOperation("Obtiene todas las ejecuciones")
	public List<PocEjecucionDto> findAll() {
		return pocEjecucionService.findAll();
	}

	@GetMapping(value = { "/java/{periodo}/{idPais}/{idCadena}", "/java/{periodo}/{idPais}/{idCadena}/{tiendas}" })
	public PocEjecucionDto java(@PathVariable(name = "periodo") String periodo,
			@PathVariable(name = "idPais") String idPais, @PathVariable(name = "idCadena") String idCadena,
			@PathVariable(name = "tiendas", required = false) Optional<List<String>> tiendas) {
		PocEjecucionDto result = new PocEjecucionDto();
		result.setSistema(PocConstants.PocSistemaEnum.JAVA.getSistema());
		result.setPeriodo(periodo);
		result.setIdPais(idPais);
		result.setIdCadena(idCadena);
		result.setTiendas(tiendas.orElse(new ArrayList<>()));
		result.setIdPais(idPais);
		result = pocEjecucionService.createPocEjecucion(result);
		return result;
	}

	@GetMapping(value = { "/meta4/{periodo}/{idPais}/{idCadena}", "/meta4/{periodo}/{idPais}/{idCadena}/{tiendas}" })
	public PocEjecucionDto meta4(@PathVariable(name = "periodo") String periodo,
			@PathVariable(name = "idPais") String idPais, @PathVariable(name = "idCadena") String idCadena,
			@PathVariable(name = "tiendas", required = false) Optional<List<String>> tiendas) {
		PocEjecucionDto result = new PocEjecucionDto();
		result.setSistema(PocConstants.PocSistemaEnum.META4.getSistema());
		result.setPeriodo(periodo);
		result.setIdPais(idPais);
		result.setIdCadena(idCadena);
		result.setTiendas(tiendas.orElse(new ArrayList<>()));
		result.setIdPais(idPais);
		result = pocEjecucionService.createPocEjecucion(result);
		return result;
	}

}