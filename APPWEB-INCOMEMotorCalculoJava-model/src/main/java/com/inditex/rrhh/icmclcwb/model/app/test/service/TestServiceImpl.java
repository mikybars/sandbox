package com.inditex.rrhh.icmclcwb.model.app.test.service;

import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.test.dto.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
        //itemGetempleados.setIdlugartrabajo("T57");
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
    
    

}