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
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.authenticate.dto.AuthenticateDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.authenticate.dto.AuthenticateResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.exception.SlrhorcomsIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercial.dto.RootHorarioComercialDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.slf4j.Logger;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.aqsw.framework.service.aaa.userdetails.sso.util.SsoUtils;

@Service
@Validated
public class TestServiceImpl implements TestService {

    private static final String CONTROLLED_TIMEOUT = "Controlled timeout";

    private static final String CODE = "Code";

    private static final String EXCEPTION = "Exception";

    private static final String OK = "OK";

    private static final String KO = "KO";

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
    private MailSender mailSender;

    @Autowired
    private ComisService comisService;

    @Autowired
    private PtrService ptrService;

    @Autowired
    @Qualifier("slrhorcomsClient")
    private RestClient slrhorcomsClient;

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
        this.testExceptionService.icmclcwbException();
    }

    @Override
    public void errorAsync() {
        final CompletableFuture<Void> cfErrorAsync1 = this.testExceptionAsyncService.icmclcwbException();
        AsyncUtils.exceptionally(cfErrorAsync1, new ArrayList<>());

        final CompletableFuture<Void> cfErrorAsync2 = this.testExceptionAsyncService.icmclcwbException();
        AsyncUtils.exceptionally(cfErrorAsync2, new ArrayList<>());

        final CompletableFuture<Void> cfErrorAsyncAllOf = CompletableFuture.allOf(cfErrorAsync1, cfErrorAsync2);
        AsyncUtils.exceptionally(cfErrorAsyncAllOf, new ArrayList<>());
        cfErrorAsyncAllOf.join();
    }

    @Override
    public void sesion() {
        final IcmParamcalempleadosRecord itemGetempleados = new IcmParamcalempleadosRecord();
        itemGetempleados.setFechainicio("2017-07-01T00:00:00.000Z");
        itemGetempleados.setFechafin("2017-12-31T00:00:00.000Z");
        itemGetempleados.setIdorigen("11");
        itemGetempleados.setIdempresa("8");
        final IcmParamcalempleadosBlock filterGetempleados = new IcmParamcalempleadosBlock();
        // itemGetempleados.setIdlugartrabajo("T57");
        filterGetempleados.getIcmParamcalempleadosRecordSet().add(itemGetempleados);

        final IcmParametrospaginacionBlock pageGetempleados = new IcmParametrospaginacionBlock();
        pageGetempleados.setCampoorden("idempleado");
        pageGetempleados.setNumeropagina("1");
        pageGetempleados.setNumeroregistrospagina("200");
        pageGetempleados.setTipoorden("DESC");
        pageGetempleados.setIdbusqueda(StringUtils.EMPTY);
        pageGetempleados.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        GetempleadosOutput outputGetempleados;
        outputGetempleados = this.meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
        this.log.info("outputGetempleados: {}", outputGetempleados.getReturn());
        outputGetempleados = this.meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
        this.log.info("outputGetempleados: {}", outputGetempleados.getReturn());
        outputGetempleados = this.meta4ClientPool.getempleados(filterGetempleados, pageGetempleados);
        this.log.info("outputGetempleados: {}", outputGetempleados.getReturn());

        final IcmParamcaltiendasBlock filterSearchTiendas = new IcmParamcaltiendasBlock();
        final IcmParamcaltiendasRecord itemSearchTiendas = new IcmParamcaltiendasRecord();
        itemSearchTiendas.setFechainicio("2017-07-01T00:00:00.000Z");
        itemSearchTiendas.setFechafin("2017-12-31T00:00:00.000Z");
        itemSearchTiendas.setIdorigen("11");
        itemSearchTiendas.setIdempresa("8");
        itemSearchTiendas.setIdlugartrabajo("T57");
        filterSearchTiendas.getIcmParamcaltiendasRecordSet().add(itemSearchTiendas);

        final IcmParametrospaginacionBlock pageSearchtiendas = new IcmParametrospaginacionBlock();
        pageSearchtiendas.setCampoorden("idempleado");
        pageSearchtiendas.setNumeropagina("1");
        pageSearchtiendas.setNumeroregistrospagina("200");
        pageSearchtiendas.setTipoorden("DESC");
        pageSearchtiendas.setIdbusqueda(StringUtils.EMPTY);
        pageSearchtiendas.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());

        SearchtiendasOutput outputSearchtiendas;
        outputSearchtiendas = this.meta4ClientPool.searchtiendas(filterSearchTiendas, pageSearchtiendas);
        this.log.info("outputGetempleados: {}", outputSearchtiendas.getReturn());
        outputSearchtiendas = this.meta4ClientPool.searchtiendas(filterSearchTiendas, pageSearchtiendas);
        this.log.info("outputGetempleados: {}", outputSearchtiendas.getReturn());
        outputSearchtiendas = this.meta4ClientPool.searchtiendas(filterSearchTiendas, pageSearchtiendas);
        this.log.info("outputGetempleados: {}", outputSearchtiendas.getReturn());

        this.log.error("Test sesion()");
    }

    @Override
    // TODO [COMUN] Rehacer este test
    public void programacionBatch() {
        this.programacionService.activa();
        for (int x = 1; x <= 100; x++) {
            this.programacionService.reset();
            // runProgramacionService.run();
        }
    }

    @Override
    public Boolean testUrl(@NotBlank final String url) {
        int code = HttpStatus.SC_OK;
        try {
            final URL siteURL = new URL(url);
            final HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod(HttpMethod.POST.name());
            connection.setConnectTimeout(30000);
            connection.connect();
            code = connection.getResponseCode();

            switch (code) {
                case HttpStatus.SC_REQUEST_TIMEOUT:
                case HttpStatus.SC_GATEWAY_TIMEOUT:
                case 598:
                case 524:
                    this.log.error(new StringBuilder(url).append(": ")
                        .append(KO)
                        .append(", ")
                        .append(CONTROLLED_TIMEOUT)
                        .append(", ")
                        .append(CODE)
                        .append(": ")
                        .append(code)
                        .toString());
                    return Boolean.FALSE;
                default:
                    break;
            }

        } catch (final Exception e) {
            this.log.error(new StringBuilder(url).append(": ")
                .append(KO)
                .append(", ")
                .append(EXCEPTION)
                .append(": ")
                .append(e)
                .toString());
            return Boolean.FALSE;
        }

        this.log.info(new StringBuilder(url).append(": ")
            .append(OK)
            .append(", ")
            .append(CODE)
            .append(": ")
            .append(code)
            .toString());
        return Boolean.TRUE;
    }

    @Override
    public void trabajoFase1a() {
        AppTestConstants.getFASE_1A().stream().forEach(item -> {
            final String[] values = StringUtils.split(item, ",");
            final String sociedad = values[0];
            final String origen = values[1];
            final String empresa = values[2];
            for (int x = 0; x < 70; x++) {
                final TrabajoDto trabajo = new TrabajoDto();
                final LocalDate fechaInicio = TimeUtils.nowLocalDate()
                    .minusMonths(x)
                    .with(TemporalAdjusters.firstDayOfMonth())
                    .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
                final LocalDate fechaFin = TimeUtils.nowLocalDate()
                    .minusMonths(x)
                    .with(TemporalAdjusters.lastDayOfMonth())
                    .with(ChronoField.NANO_OF_DAY, LocalTime.MIN.toNanoOfDay());
                trabajo.setIcmIdPeriodo(0L);
                trabajo.setFechaInicioPeriodo(fechaInicio);
                trabajo.setFechaFinPeriodo(fechaFin);
                trabajo.setIdOrganization(sociedad);
                final TrabajoAmbitoOrigenDto trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDto();
                trabajoAmbitoOrigenDto.setCclIdOrigen(origen);
                trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigenDto));
                final TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDto();
                trabajoAmbitoEmpresa.setStdIdLegEnt(empresa);
                trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
                trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
                this.trabajoService.create(trabajo);
            }
        });
    }

    @Override
    public void testBloqueos(@NotNull final Long limit) {
        AppTestConstants.getTEST().stream().collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
            Collections.shuffle(collected);
            return collected.stream();
        })).limit(limit).collect(Collectors.toList()).forEach(item -> {
            final String[] values = StringUtils.split(item, ",");
            final String sociedad = values[0];
            final String origen = values[1];
            final String empresa = values[2];
            final String localizacion = values[3];
            final String persona = values[4];
            final String orPersona = values[5];
            final Integer tipo = 4;
            final TrabajoDto trabajo = new TrabajoDto();
            switch (tipo) {
                case 1:
                    this.testSociedad(sociedad, trabajo);
                    trabajo.setTipoAmbito(TipoAmbitoEnum.SOCIEDAD.getDto());
                    break;
                case 2:
                    this.testOrigen(sociedad, origen, trabajo);
                    trabajo.setTipoAmbito(TipoAmbitoEnum.ORIGEN.getDto());
                    break;
                case 3:
                    this.testEmpresa(sociedad, origen, empresa, trabajo);
                    trabajo.setTipoAmbito(TipoAmbitoEnum.EMPRESA.getDto());
                    break;
                case 4:
                    this.testLocalizacion(sociedad, origen, empresa, localizacion, trabajo);
                    trabajo.setTipoAmbito(TipoAmbitoEnum.LOCALIZACION.getDto());
                    break;
                case 5:
                    this.testPersona(sociedad, origen, empresa, persona, orPersona, trabajo);
                    trabajo.setTipoAmbito(TipoAmbitoEnum.PERSONA.getDto());
                    break;
                default:
                    break;
            }

            this.trabajoService.create(trabajo);
        });
    }

    @Override
    public String sqlFormatter(@NotBlank final String sql) {
        return new BasicFormatterImpl().format(StringUtils.normalizeSpace(StringUtils.trim(sql)));
    }

    private void testSociedad(final String sociedad, final TrabajoDto trabajo) {
        trabajo.setIcmIdPeriodo(1L);
        trabajo.setFechaInicioPeriodo(LocalDate.of(2015, 3, 1));
        trabajo.setFechaFinPeriodo(LocalDate.of(2015, 3, 31));
        trabajo.setIdOrganization(sociedad);
    }

    private void testOrigen(final String sociedad, final String origen, final TrabajoDto trabajo) {
        this.testSociedad(sociedad, trabajo);
        final TrabajoAmbitoOrigenDto trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDto();
        trabajoAmbitoOrigenDto.setCclIdOrigen(origen);
        trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigenDto));
    }

    private void testEmpresa(final String sociedad, final String origen, final String empresa,
            final TrabajoDto trabajo) {
        this.testOrigen(sociedad, origen, trabajo);
        final TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDto();
        trabajoAmbitoEmpresa.setStdIdLegEnt(empresa);
        trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    }

    private void testLocalizacion(final String sociedad, final String origen, final String empresa,
            final String localizacion,
            final TrabajoDto trabajo) {
        this.testEmpresa(sociedad, origen, empresa, trabajo);
        final TrabajoAmbitoLocalizacionDto trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDto();
        trabajoAmbitoLocalizacion.setStdIdWorkLocat(localizacion);
        trabajoAmbitoLocalizacion.setStdIdLegEnt(empresa);
        trabajoAmbitoLocalizacion.setCclIdOrigen(origen);
        trabajo.setLocalizacion(Arrays.asList(trabajoAmbitoLocalizacion));
    }

    private void testPersona(final String sociedad, final String origen, final String empresa, final String persona,
            final String orPersona, final TrabajoDto trabajo) {
        this.testEmpresa(sociedad, origen, empresa, trabajo);
        final TrabajoAmbitoPersonaDto trabajoAmbitoPersona = new TrabajoAmbitoPersonaDto();
        trabajoAmbitoPersona.setCclIdPerson(persona);
        trabajoAmbitoPersona.setStdOrHrPeriod(orPersona);
        trabajoAmbitoPersona.setStdIdLegEnt(empresa);
        trabajoAmbitoPersona.setCclIdOrigen(origen);
        trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));
    }

    @Override
    public void sendMail() {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@inditex.com");
        message.setTo("income-java@vectoritcgroup.com");
        message.setSubject("Lorem ipsum");
        message.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        this.mailSender.send(message);
    }

    @Override
    public void comisTest() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        runTareaDto.setTarea(tareaDto);
        final TrabajoDto trabajoDto = new TrabajoDto();
        runTareaDto.setTrabajo(trabajoDto);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen("38");
        this.comisService.findMotivoDesplazamiento(runTareaDto, tareaAmbitoDto);
    }

    @Override
    public void ptrTest() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        runTareaDto.setTarea(tareaDto);
        final TrabajoDto trabajoDto = new TrabajoDto();
        runTareaDto.setTrabajo(trabajoDto);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen("38");
        tareaDto.setFechaInicioPeriodo(LocalDate.of(2015, 3, 1));
        tareaDto.setFechaFinPeriodo(LocalDate.of(2015, 3, 31));
        this.ptrService.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
    }

    @Override
    public void slrhorcomsTest() {
        // Token datagrid -> OK -> Refrescar -> OK -> Guardar datagrid y Devolver
        // Token datagrid -> OK -> Refrescar -> KO -> {/authenticate}
        // Token datagrid -> KO -> /authenticate -> OK -> Devolver
        // {/authenticate} -> OK -> Guardar datagrid y Devolver
        // {&} -> /authenticate -> OK -> Excepción
        final AuthenticateDto authenticateDto = this.slrhorcomsAuthenticateTest();
        final ResponseEntity<RootHorarioComercialDto> responseHorarioComercial = this.slrhorcomsClient
            .getForEntity("/slrhorcoms/openapi-rest/HorarioComercial/list?q=*&rows=100",
                    RootHorarioComercialDto.class);
        this.log.info("responseHorarioComercial: {}",
                responseHorarioComercial);
        this.log.info("responseHorarioComercial: {}", responseHorarioComercial);
    }

    private AuthenticateDto slrhorcomsAuthenticateTest() {

        final ResponseEntity<AuthenticateResponseDto> responseAuthenticate = this.slrhorcomsClient
            .postForEntity("/authenticate", null, AuthenticateResponseDto.class);
        this.log.info("responseAuthenticate: {}", responseAuthenticate);
        if (responseAuthenticate.getStatusCode().value() != HttpStatus.SC_OK) {
            throw new SlrhorcomsIcmclcwbException("Error en login slrhorcomsI");
        }
        return AuthenticateDto.builder()
            .message(responseAuthenticate.getBody().getMessage())
            .accessToken(responseAuthenticate.getHeaders().getFirst("access-token"))
            .refreshToken(responseAuthenticate.getHeaders().getFirst("refresh-token"))
            .build();
    }

}
