/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
public interface CalculoAjusteCarenciaAsyncService {

    @Async("ajusteExecutor")
    CompletableFuture<Void> ajustar(final AlgoritmoAjusteDto algoritmoAjusteDto, final TareaDto tarea,
            final List<IdPersonaLocalDto> personas);

}
