package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

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

    @ApiOperation("Transformaciones de fechas")
    @GetMapping(path = "/reloj/")
    public RelojDto reloj() {
        return testService.reloj();
    }

    @ApiOperation("Datos del usuario conectado en el SSO")
    @GetMapping(path = "/sso/")
    public SsoDto sso() {
        return testService.sso();
    }

    @ApiOperation("Error en sincronía")
    @GetMapping(path = "/error/sync/")
    public void errorSync() throws Exception {
        testService.errorSync();
    }

    @ApiOperation("Error en asincronía")
    @GetMapping(path = "/error/async/")
    public void errorAsync() throws Exception {
        testService.errorAsync();
    }

    @ApiOperation("Validación de la sesión de Meta4")
    @GetMapping(path = "/sesion/")
    public void sesion() throws Exception {
        testService.sesion();
    }

    @GetMapping(path = "/ptr/presencia/path")
    @ApiOperation("Conectividad con ptr de presencia")
    public String testPathPTRPresecnias(@Valid @NotBlank String path) throws Exception {
        String pathD = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
        return ptrPresenciaClient.getForObject(pathD, String.class);
    }

    @GetMapping(path = "/ptr/venta/path")
    @ApiOperation("Conectividad con ptr de venta")
    public String testPathPTRVentas(@Valid @NotBlank String path) throws Exception {
        String pathD = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
        return ptrVentaClient.getForObject(pathD, String.class);
    }

}
