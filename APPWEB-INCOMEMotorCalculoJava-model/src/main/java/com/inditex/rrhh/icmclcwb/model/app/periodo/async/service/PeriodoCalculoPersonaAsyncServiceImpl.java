package com.inditex.rrhh.icmclcwb.model.app.periodo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.async.service.PeriodoCalculoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class PeriodoCalculoPersonaAsyncServiceImpl implements PeriodoCalculoPersonaAsyncService {

    @Autowired
    private PeriodoCalculoPersonaService periodoCalculoPersonaService;
    
    @Override
    public CompletableFuture<Void> save(@Valid final List<PeriodoCalculoPersonaDto> src) {
        periodoCalculoPersonaService.save(src);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
