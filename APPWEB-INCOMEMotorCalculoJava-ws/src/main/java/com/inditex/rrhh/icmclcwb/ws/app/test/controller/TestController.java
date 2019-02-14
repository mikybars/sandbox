package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

}
