package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Validated
@RestController
@RequestMapping(path = "/test")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}), tags = { "TestController" })
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/reloj/")
    @ApiOperation("Transformaciones de fechas")
    public RelojDto reloj() {
        return this.testService.reloj();
    }

    @GetMapping("/sso/")
    @ApiOperation("Datos del usuario conectado en el SSO")
    public SsoDto sso() {
        return this.testService.sso();
    }

    @GetMapping("/error/sync/")
    @ApiOperation("Error en sincronía")
    public void errorSync() {
        this.testService.errorSync();
    }

    @GetMapping("/error/async/")
    @ApiOperation("Error en asincronía")
    public void errorAsync() {
        this.testService.errorAsync();
    }

    @GetMapping("/sesion/")
    @ApiOperation("Validación de la sesión de Meta4")
    public void sesion() {
        this.testService.sesion();
    }

    @GetMapping("/programacion/batch")
    @ApiOperation("Lanza todas las programaciones N veces")
    public void programacionBatch() {
        this.testService.programacionBatch();
    }

    @PostMapping(path = "/trabajo/test/{limit}")
    @ApiOperation("Test bloqueos. Genera un número de trabajos para distintos tipos de ámbito (1 - 5) para AT/38/95/Localizacion/Persona en 03/2015")
    public void testConcurrencia(@PathVariable @Valid @NotNull @Positive final Long limit) {
        this.testService.testBloqueos(limit);
    }

    @PostMapping(path = "/test/url")
    @ApiOperation("Test urls")
    public Boolean testUrl(@RequestBody @NotBlank final String url) {
        return this.testService.testUrl(url);
    }

    @GetMapping("/trabajo/fase1a")
    @ApiOperation("Crea los trabajos para todos los origenes y empresas de la fase 1a")
    public void trabajoFase1a() {
        this.testService.trabajoFase1a();
    }

    @PostMapping(path = "/sql/formatter", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation("Formatea una consulta")
    public String sqlformatter(@RequestBody @NotBlank final String sql) {
        return this.testService.sqlFormatter(sql);
    }
    
    @GetMapping("/mail/send")
    @ApiOperation("Envia un correo de prueba")
    public void sendMail() {
        this.testService.sendMail();
    }

}
