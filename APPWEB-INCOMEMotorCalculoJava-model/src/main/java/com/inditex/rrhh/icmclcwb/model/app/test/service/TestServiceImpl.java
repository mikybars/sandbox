package com.inditex.rrhh.icmclcwb.model.app.test.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
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
    private RunProgramacionService runProgramacionService;

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
    public void programacionBatch() {
        programacionService.activa();
        for (int x = 1; x <= 100; x++) {
            programacionService.reset();
            runProgramacionService.run();
        }
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
                trabajo.setIdPeriodo(0L);
                trabajo.setFechaInicioPeriodo(fechaInicio);
                trabajo.setFechaFinPeriodo(fechaFin);
                trabajo.setIdSociedad(sociedad);
                TrabajoAmbitoOrigenDto trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDto();
                trabajoAmbitoOrigenDto.setIdOrigen(origen);
                trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigenDto));
                TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDto();
                trabajoAmbitoEmpresa.setIdEmpresa(empresa);
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

    private void testSociedad(String sociedad, TrabajoDto trabajo) {
        LocalDate fechaInicio = LocalDate.of(2015, 3, 1);
        LocalDate fechaFin = LocalDate.of(2015, 3, 31);
        trabajo.setIdPeriodo(1L);
        trabajo.setFechaInicioPeriodo(fechaInicio);
        trabajo.setFechaFinPeriodo(fechaFin);
        trabajo.setIdSociedad(sociedad);
    }

    private void testOrigen(String sociedad, String origen, TrabajoDto trabajo) {
        testSociedad(sociedad, trabajo);
        TrabajoAmbitoOrigenDto trabajoAmbitoOrigenDto = new TrabajoAmbitoOrigenDto();
        trabajoAmbitoOrigenDto.setIdOrigen(origen);
        trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigenDto));
    }

    private void testEmpresa(String sociedad, String origen, String empresa, TrabajoDto trabajo) {
        testOrigen(sociedad, origen, trabajo);
        TrabajoAmbitoEmpresaDto trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDto();
        trabajoAmbitoEmpresa.setIdEmpresa(empresa);
        trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    }

    private void testLocalizacion(String sociedad, String origen, String empresa, String localizacion,
            TrabajoDto trabajo) {
        testEmpresa(sociedad, origen, empresa, trabajo);
        TrabajoAmbitoLocalizacionDto trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDto();
        trabajoAmbitoLocalizacion.setIdLocalizacion(localizacion);
        trabajoAmbitoLocalizacion.setIdEmpresa(empresa);
        trabajoAmbitoLocalizacion.setIdOrigen(origen);
        trabajo.setLocalizacion(Arrays.asList(trabajoAmbitoLocalizacion));
    }

    private void testPersona(String sociedad, String origen, String empresa, String localizacion, String persona,
            String orPersona, TrabajoDto trabajo) {
        testEmpresa(sociedad, origen, empresa, trabajo);
        TrabajoAmbitoPersonaDto trabajoAmbitoPersona = new TrabajoAmbitoPersonaDto();
        trabajoAmbitoPersona.setIdPersona(persona);
        trabajoAmbitoPersona.setOrPersona(orPersona);
        trabajoAmbitoPersona.setIdEmpresa(empresa);
        trabajoAmbitoPersona.setIdOrigen(origen);
        trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));
    }

}