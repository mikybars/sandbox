/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.personas;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.personas.CalculoAjusteMinimoGarantizadoService;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteMinimoGarantizadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

/**
 * @author javierev
 */
@Service
public class CalculoAjusteMinimoGarantizadoAsyncServiceImpl implements CalculoAjusteMinimoGarantizadoAsyncService {

    @Autowired
    private CalculoAjusteMinimoGarantizadoService calculoAjusteMinimoGarantizadoService;

    @Override
    public CompletableFuture<Void> ajustar(
            final AlgoritmoAjusteDto algoritmoAjusteDto,
            final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {
        this.calculoAjusteMinimoGarantizadoService.ajustar(algoritmoAjusteDto, tarea, personas);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
