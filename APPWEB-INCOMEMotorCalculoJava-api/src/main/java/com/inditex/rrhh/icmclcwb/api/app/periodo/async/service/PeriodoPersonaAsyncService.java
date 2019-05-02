package com.inditex.rrhh.icmclcwb.api.app.periodo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoPersonaDto;

@Async("repositoryPrimaryExecutor")
public interface PeriodoPersonaAsyncService {

    CompletableFuture<Void> save(@Valid final List<PeriodoPersonaDto> src);

}
