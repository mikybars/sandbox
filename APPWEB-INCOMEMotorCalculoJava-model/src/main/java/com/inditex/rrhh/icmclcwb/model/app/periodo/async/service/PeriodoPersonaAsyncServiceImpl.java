package com.inditex.rrhh.icmclcwb.model.app.periodo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.async.service.PeriodoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class PeriodoPersonaAsyncServiceImpl implements PeriodoPersonaAsyncService {

    @Autowired
    private PeriodoPersonaService periodoPersonaService;

    @Override
    public CompletableFuture<Void> save(@Valid final List<PeriodoPersonaDto> src) {
        periodoPersonaService.save(src);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
