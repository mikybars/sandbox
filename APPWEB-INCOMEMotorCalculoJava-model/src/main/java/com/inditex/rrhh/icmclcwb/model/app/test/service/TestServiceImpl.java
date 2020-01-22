package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import org.apache.http.HttpStatus;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppTestConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

@Service
@Validated
public class TestServiceImpl implements TestService {

    private static final String CONTROLLED_TIMEOUT = "Controlled timeout";
    private static final String CODE = "Code";
    private static final String EXCEPTION = "Exception";
    private static final String OK = "OK";
    private static final String KO = "KO";

    private static final Map<Integer, List<Integer>> EMPRESAS = new HashMap<Integer, List<Integer>>() {
        {
            put(5, Arrays.asList(134, 151, 154, 162, 170, 171, 193, 194, 202, 319, 328, 358, 472, 54)); //Italia
            put(6, Arrays.asList(146, 153, 159, 205, 431, 440, 46)); //UK
            put(7, Arrays.asList(139, 160, 161, 174, 191, 339, 528)); //Irlanda
            put(404, Arrays.asList(362, 395, 97)); //Canada
            put(400, Arrays.asList(122, 175, 18, 327, 380, 383, 405, 415, 522)); //EE.UU.
            put(11, Arrays.asList()); //España
        }
    };

    @Autowired
    private Logger log;

    @Autowired
    private TestExceptionService testExceptionService;

    @Autowired
    private TestExceptionAsyncService testExceptionAsyncService;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private RunTareaAmbitoRecolectarPtrVentaEcommerceService runTareaAmbitoRecolectarPtrVentaEcommerceService;

    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;

    @Autowired
    @Qualifier("meta4ClientPool")
    private Meta4ClientPool meta4ClientPool;

    @Override
    public RelojDto reloj() {
        return new RelojDto();
    }

    @Override
    public SsoDto sso() {
        return SsoDto.builder().result(SsoUtils.getUserSSO().toString()).build();
    }

    @Override
    public void errorSync() {
        testExceptionService.icmclcwbException();
    }

    @Override
    public void errorAsync() {
        CompletableFuture<Void> cfErrorAsync1 = testExceptionAsyncService.icmclcwbException();
        AsyncUtils.exceptionally(cfErrorAsync1, new ArrayList<>());

        CompletableFuture<Void> cfErrorAsync2 = testExceptionAsyncService.icmclcwbException();
        AsyncUtils.exceptionally(cfErrorAsync2, new ArrayList<>());

        CompletableFuture<Void> cfErrorAsyncAllOf = CompletableFuture.allOf(cfErrorAsync1, cfErrorAsync2);
        AsyncUtils.exceptionally(cfErrorAsyncAllOf, new ArrayList<>());
        cfErrorAsyncAllOf.join();
    }

    @Override
    public void sesion() {
        final IcmParametrosentradaBlock filterGetempleados = new IcmParametrosentradaBlock();
        filterGetempleados.setFechainicio("2017-07-01T00:00:00.000Z");
        filterGetempleados.setFechafin("2017-12-31T00:00:00.000Z");
        filterGetempleados.setIdorigen("11");
        filterGetempleados.setIdempresa("8");
        IcmParametrosentradaRecord itemGetempleados = new IcmParametrosentradaRecord();
        // itemGetempleados.setIdlugartrabajo("T57");
        filterGetempleados.getIcmParametrosentradaRecordSet().add(itemGetempleados);

        final IcmParametrospaginacionBlock pageGetempleados = new IcmParametrospaginacionBlock();
        pageGetempleados.setCampoorden("idempleado");
        pageGetempleados.setNumeropagina("1");
        pageGetempleados.setNumeroregistrospagina("200");
        pageGetempleados.setTipoorden("DESC");
        pageGetempleados.setIdbusqueda(StringUtils.EMPTY);
        pageGetempleados.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        GetempleadosOutput outputGetempleados;
        outputGetempleados = meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
        log.info("outputGetempleados: {}", outputGetempleados.getReturn());
        outputGetempleados = meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
        log.info("outputGetempleados: {}", outputGetempleados.getReturn());
        outputGetempleados = meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
        log.info("outputGetempleados: {}", outputGetempleados.getReturn());

        final IcmParametrosentradaBlock filterSearchtiendas = new IcmParametrosentradaBlock();
        filterSearchtiendas.setFechainicio("2017-07-01T00:00:00.000Z");
        filterSearchtiendas.setFechafin("2017-12-31T00:00:00.000Z");
        filterSearchtiendas.setIdorigen("11");
        filterSearchtiendas.setIdempresa("8");
        IcmParametrosentradaRecord itemSearchtiendas = new IcmParametrosentradaRecord();
        itemSearchtiendas.setIdlugartrabajo("T57");
        filterSearchtiendas.getIcmParametrosentradaRecordSet().add(itemSearchtiendas);

        final IcmParametrospaginacionBlock pageSearchtiendas = new IcmParametrospaginacionBlock();
        pageSearchtiendas.setCampoorden("idempleado");
        pageSearchtiendas.setNumeropagina("1");
        pageSearchtiendas.setNumeroregistrospagina("200");
        pageSearchtiendas.setTipoorden("DESC");
        pageSearchtiendas.setIdbusqueda(StringUtils.EMPTY);
        pageSearchtiendas.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        SearchtiendasOutput outputSearchtiendas;
        outputSearchtiendas = meta4ClientPool.searchtiendas(filterSearchtiendas, pageSearchtiendas);
        log.info("outputGetempleados: {}", outputSearchtiendas.getReturn());
        outputSearchtiendas = meta4ClientPool.searchtiendas(filterSearchtiendas, pageSearchtiendas);
        log.info("outputGetempleados: {}", outputSearchtiendas.getReturn());
        outputSearchtiendas = meta4ClientPool.searchtiendas(filterSearchtiendas, pageSearchtiendas);
        log.info("outputGetempleados: {}", outputSearchtiendas.getReturn());

        log.error("Test sesion()");
    }

    @Override
    //TODO: Rehacer este test
    public void programacionBatch() {
        programacionService.activa();
        for (int x = 1; x <= 100; x++) {
            programacionService.reset();
//            runProgramacionService.run();
        }
    }
    
    @Override
    public Boolean testUrl(@NotBlank String url) {
        int code = HttpStatus.SC_OK;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod(HttpMethod.POST.name());
            connection.setConnectTimeout(30000);
            connection.connect();
            code = connection.getResponseCode();
            
            switch (code) {
                case HttpStatus.SC_REQUEST_TIMEOUT:
                case HttpStatus.SC_GATEWAY_TIMEOUT:
                case 598:
                case 524:
                    log.error(new StringBuilder(url).append(": ")
                            .append(KO).append(", ")
                            .append(CONTROLLED_TIMEOUT).append(", ")
                            .append(CODE).append(": ").append(code).toString());
                    return Boolean.FALSE;
            default:
                break;
            }
            
        } catch (Exception e) {
            log.error(new StringBuilder(url).append(": ")
                    .append(KO).append(", ")
                    .append(EXCEPTION).append(": ").append(e).toString());
            return Boolean.FALSE;
        }
        
        log.info(new StringBuilder(url).append(": ")
                .append(OK).append(", ")
                .append(CODE).append(": ").append(code).toString());
        return Boolean.TRUE;
    }

    @Override
    public void trabajoFase1a() {
        AppTestConstants.FASE_1A.stream().forEach(item -> {
            String[] values = StringUtils.split(item, ",");
            String sociedad = values[0];
            String origen = values[1];
            String empresa = values[2];
            for (int x = 0; x < 70; x++) {
                TrabajoDto trabajo = new TrabajoDto();
                LocalDate fechaInicio = TimeUtils.nowLocalDate().minusMonths(x)
                        .with(TemporalAdjusters.firstDayOfMonth())
                        .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
                LocalDate fechaFin = TimeUtils.nowLocalDate().minusMonths(x)
                        .with(TemporalAdjusters.lastDayOfMonth())
                        .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
                trabajo.setIcmIdPeriodo(0L);
                trabajo.setFechaInicioPeriodo(fechaInicio);
                trabajo.setFechaFinPeriodo(fechaFin);
                trabajo.setIdOrganization(sociedad);
                TrabajoAmbitoOrigenDto trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDto();
                trabajoAmbitoOrigenDto.setCclIdOrigen(origen);
                trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigenDto));
                TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDto();
                trabajoAmbitoEmpresa.setStdIdLegEnt(empresa);
                trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
                trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
                trabajoService.create(trabajo);
            }
        });
    }

    @Override
    public void testBloqueos(@NotNull final Long limit) {
        AppTestConstants.TEST.stream().collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
            Collections.shuffle(collected);
            return collected.stream();
        })).limit(limit).collect(Collectors.toList()).forEach(item -> {
            String[] values = StringUtils.split(item, ",");
            String sociedad = values[0];
            String origen = values[1];
            String empresa = values[2];
            String localizacion = values[3];
            String persona = values[4];
            String orPersona = values[5];
            Random rand = new Random();
            Integer tipo = rand.nextInt(5) + 1;
            TrabajoDto trabajo = new TrabajoDto();
            switch (tipo) {
            case 1:
                testSociedad(sociedad, trabajo);
                trabajo.setTipoAmbito(TipoAmbitoEnum.SOCIEDAD.getDto());
                break;
            case 2:
                testOrigen(sociedad, origen, trabajo);
                trabajo.setTipoAmbito(TipoAmbitoEnum.ORIGEN.getDto());
                break;
            case 3:
                testEmpresa(sociedad, origen, empresa, trabajo);
                trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
                break;
            case 4:
                testLocalizacion(sociedad, origen, empresa, localizacion, trabajo);
                trabajo.setTipoAmbito(TipoAmbitoEnum.LOCALIZACION.getDto());
                break;
            case 5:
                testPersona(sociedad, origen, empresa, localizacion, persona, orPersona, trabajo);
                trabajo.setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
                break;
            default:
                break;
            }

            trabajoService.create(trabajo);
        });
    }
    
    @Override
    public String sqlFormatter(@NotBlank String sql) {
        return new BasicFormatterImpl().format(StringUtils.normalizeSpace(StringUtils.trim(sql)));
    }

    private void testSociedad(String sociedad, TrabajoDto trabajo) {
        trabajo.setIcmIdPeriodo(1L);
        trabajo.setFechaInicioPeriodo(LocalDate.of(2015, 3, 1));
        trabajo.setFechaFinPeriodo(LocalDate.of(2015, 3, 31));
        trabajo.setIdOrganization(sociedad);
    }

    private void testOrigen(String sociedad, String origen, TrabajoDto trabajo) {
        testSociedad(sociedad, trabajo);
        TrabajoAmbitoOrigenDto trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDto();
        trabajoAmbitoOrigenDto.setCclIdOrigen(origen);
        trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigenDto));
    }

    private void testEmpresa(String sociedad, String origen, String empresa, TrabajoDto trabajo) {
        testOrigen(sociedad, origen, trabajo);
        TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDto();
        trabajoAmbitoEmpresa.setStdIdLegEnt(empresa);
        trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    }

    private void testLocalizacion(String sociedad, String origen, String empresa, String localizacion,
            TrabajoDto trabajo) {
        testEmpresa(sociedad, origen, empresa, trabajo);
        TrabajoAmbitoLocalizacionDto trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDto();
        trabajoAmbitoLocalizacion.setStdIdWorkLocat(localizacion);
        trabajoAmbitoLocalizacion.setStdIdLegEnt(empresa);
        trabajoAmbitoLocalizacion.setCclIdOrigen(origen);
        trabajo.setLocalizacion(Arrays.asList(trabajoAmbitoLocalizacion));
    }

    private void testPersona(String sociedad, String origen, String empresa, String localizacion, String persona,
            String orPersona, TrabajoDto trabajo) {
        testEmpresa(sociedad, origen, empresa, trabajo);
        TrabajoAmbitoPersonaDto trabajoAmbitoPersona = new TrabajoAmbitoPersonaDto();
        trabajoAmbitoPersona.setCclIdPerson(persona);
        trabajoAmbitoPersona.setStdOrHrPeriod(orPersona);
        trabajoAmbitoPersona.setStdIdLegEnt(empresa);
        trabajoAmbitoPersona.setCclIdOrigen(origen);
        trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));
    }

    @Override
    public void buscarPorVenta(@NotNull @Positive Integer idPais) {

        if (!EMPRESAS.containsKey(idPais)) {
            throw new UnsupportedOperationException("Pais no soportado, usar: [5,6,7,11,400,404]");
        }

        EMPRESAS.get(idPais).forEach(idEmpresa ->
            runTareaAmbitoRecolectarPtrVentaEcommerceService.ventaOnlineIpodLocalizacionPersonaBusquedaPorVenta(idPais, idEmpresa));

    }
}
