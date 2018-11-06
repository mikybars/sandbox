package com.inditex.rrhh.icmclcwb.ws.controller.app.poc;

import java.util.ArrayList;
import java.util.List;
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

	@GetMapping("/java/{periodo}/{idPais}/{idCadena}")
	@ApiOperation("Lanza una ejecución en Java")
	public PocEjecucionDto javaByPaisAndCadena(@PathVariable(name = "periodo") String periodo,
			@PathVariable(name = "idPais") String idPais, @PathVariable(name = "idCadena") String idCadena) {
		PocEjecucionDto result = new PocEjecucionDto();
		result.setSistema(PocConstants.PocSistemaEnum.JAVA.getSistema());
		result.setPeriodo(periodo);
		result.setIdPais(idPais);
		result.setIdCadena(idCadena);
		result.setTiendas(new ArrayList<>());
		result.setIdPais(idPais);
		result = pocEjecucionService.createPocEjecucion(result);
		return result;
	}

	@GetMapping("/java/{periodo}/{idPais}/{idCadena}/{tiendas}")
	@ApiOperation("Lanza una ejecución en Java")
	public PocEjecucionDto javaByPaisAndCadenaAndTiendas(@PathVariable(name = "periodo") String periodo,
			@PathVariable(name = "idPais") String idPais, @PathVariable(name = "idCadena") String idCadena,
			@PathVariable(name = "tiendas") List<String> tiendas) {
		PocEjecucionDto result = new PocEjecucionDto();
		result.setSistema(PocConstants.PocSistemaEnum.JAVA.getSistema());
		result.setPeriodo(periodo);
		result.setIdPais(idPais);
		result.setIdCadena(idCadena);
		result.setTiendas(tiendas);
		result.setIdPais(idPais);
		result = pocEjecucionService.createPocEjecucion(result);
		return result;
	}

	@GetMapping("/java/{periodo}/{idPais}/{idCadena}")
	@ApiOperation("Lanza una ejecución en Meta4")
	public PocEjecucionDto meta4ByPaisAndCadena(@PathVariable(name = "periodo") String periodo,
			@PathVariable(name = "idPais") String idPais, @PathVariable(name = "idCadena") String idCadena) {
		PocEjecucionDto result = new PocEjecucionDto();
		result.setSistema(PocConstants.PocSistemaEnum.META4.getSistema());
		result.setPeriodo(periodo);
		result.setIdPais(idPais);
		result.setIdCadena(idCadena);
		result.setTiendas(new ArrayList<>());
		result.setIdPais(idPais);
		result = pocEjecucionService.createPocEjecucion(result);
		return result;
	}

	@GetMapping("/java/{periodo}/{idPais}/{idCadena}/{tiendas}")
	@ApiOperation("Lanza una ejecución en Meta4")
	public PocEjecucionDto meta4ByPaisAndCadenaAndTiendas(@PathVariable(name = "periodo") String periodo,
			@PathVariable(name = "idPais") String idPais, @PathVariable(name = "idCadena") String idCadena,
			@PathVariable(name = "tiendas") List<String> tiendas) {
		PocEjecucionDto result = new PocEjecucionDto();
		result.setSistema(PocConstants.PocSistemaEnum.META4.getSistema());
		result.setPeriodo(periodo);
		result.setIdPais(idPais);
		result.setIdCadena(idCadena);
		result.setTiendas(tiendas);
		result.setIdPais(idPais);
		result = pocEjecucionService.createPocEjecucion(result);
		return result;
	}

}