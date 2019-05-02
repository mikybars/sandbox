package com.inditex.rrhh.icmclcwb.model.app.periodo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.periodo.async.service.PeriodoLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class PeriodoLocalizacionAsyncServiceImpl implements PeriodoLocalizacionAsyncService {

    @Autowired
    private PeriodoLocalizacionService periodoLocalizacionService;
    
    @Override
    public CompletableFuture<Void> save(@Valid final List<PeriodoLocalizacionDto> src) {
        periodoLocalizacionService.save(src);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
