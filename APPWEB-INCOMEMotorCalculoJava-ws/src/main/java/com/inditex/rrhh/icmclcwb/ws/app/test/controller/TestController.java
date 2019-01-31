package com.inditex.rrhh.icmclcwb.ws.app.test.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.TipoCalculoEnum;

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
    private RunTrabajoCalcularService runTrabajoCalcularService;

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("ptrPresenciaClient")
    private RestClient ptrPresenciaClient;

    @GetMapping(path = "/reloj/")
    public RelojDto reloj() {
        return testService.reloj();
    }

    @GetMapping(path = "/sso/")
    public SsoDto sso() {
        return testService.sso();
    }

    @GetMapping(path = "/error/sync/")
    public void errorSync() throws Exception {
        testService.errorSync();
    }

    @GetMapping(path = "/error/async/")
    public void errorAsync() throws Exception {
        testService.errorAsync();
    }

    @GetMapping(path = "/sesion/")
    public void sesion() throws Exception {
        testService.sesion();
    }

    @GetMapping(path = "/ptrPresencias/path")
    @ApiOperation("Test PTR Presencias path, GET")
    public String testPathPTRPresecnias(String path) throws Exception {
        String pathD = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
        return ptrPresenciaClient.getForObject(pathD, String.class);
    }

    @GetMapping(path = "/ptrVentas/path")
    @ApiOperation("Test PTR Ventas path, GET")
    public String testPathPTRVentas(String path) throws Exception {
        String pathD = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
        return ptrVentaClient.getForObject(pathD, String.class);

    }

    @GetMapping(path = "/calculo/trabajo")
    @ApiOperation("Test calculo trabajo, GET")
    public void testPathPTRVentas(Long trabajo) throws Exception {
        TrabajoDto trabajoDto = new TrabajoDto();
        trabajoDto.setId(trabajo);
        RunTrabajoDto trabajoRunDto = new RunTrabajoDto();
        trabajoRunDto.setTrabajoDto(trabajoDto);
        Set<Long> tiposCalculo = new HashSet<>();
        tiposCalculo.add(TipoCalculoEnum.GLOBAL_TIENDA.getId());
        EstadoTrabajoDto estado = new EstadoTrabajoDto(EstadoTrabajoEnum.PENDIENTE_CALCULO.getId());
        trabajoDto.setEstado(estado);
        trabajoRunDto.getRunTrabajoCalcular().setTiposCalculo(tiposCalculo);
        runTrabajoCalcularService.run(trabajoRunDto);
    }

}
