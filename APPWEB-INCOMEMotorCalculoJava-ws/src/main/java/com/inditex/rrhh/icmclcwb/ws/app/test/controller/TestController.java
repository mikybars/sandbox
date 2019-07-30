package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/test")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ptrPresenciaClient")
    private RestClient ptrPresenciaClient;

    @GetMapping("/reloj/")
    @ApiOperation("Transformaciones de fechas")
    public RelojDto reloj() {
        return testService.reloj();
    }

    @GetMapping("/sso/")
    @ApiOperation("Datos del usuario conectado en el SSO")
    public SsoDto sso() {
        return testService.sso();
    }

    @GetMapping("/error/sync/")
    @ApiOperation("Error en sincronía")
    public void errorSync() {
        testService.errorSync();
    }

    @GetMapping("/error/async/")
    @ApiOperation("Error en asincronía")
    public void errorAsync() {
        testService.errorAsync();
    }

    @GetMapping("/sesion/")
    @ApiOperation("Validación de la sesión de Meta4")
    public void sesion() {
        testService.sesion();
    }

    @GetMapping("/ptr/presencia/path")
    @ApiOperation("Conectividad con ptr de presencia")
    public String testPathPTRPresecnias(@Valid @NotBlank String path) {
        return ptrPresenciaClient.getForObject(TestUtils.decode(path), String.class);
    }

    @GetMapping("/ptr/venta/path")
    @ApiOperation("Conectividad con ptr de venta")
    public String testPathPTRVentas(@Valid @NotBlank String path) {
        return ptrVentaClient.getForObject(TestUtils.decode(path), String.class);
    }

    @GetMapping("/programacion/batch")
    @ApiOperation("Lanza todas las programaciones N veces")
    public void programacionBatch() {
        testService.programacionBatch();
    }

    @PostMapping(path = "/trabajo/test/{limit}")
    @ApiOperation("Test bloqueos. Genera un número de trabajos para distintos tipos de ámbito (1 - 5) para AT/38/95/Localizacion/Persona en 03/2015")
    public void testConcurrencia(@PathVariable @Valid @NotNull @Positive Long limit) {
        testService.testBloqueos(limit);
    }
    
    @GetMapping("/trabajo/fase1a")
    @ApiOperation("Crea los trabajos para todos los origenes y empresas de la fase 1a")
    public void trabajoFase1a() {
        testService.trabajoFase1a();
    }
    
    @PostMapping(path = "/sql/formatter", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation("Formatea una consulta")
    public String sqlformatter(@RequestBody @NotBlank String sql) {
        return new BasicFormatterImpl().format(StringUtils.normalizeSpace(StringUtils.trim(sql)));
    }

}
