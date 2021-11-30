/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
@Validated
public abstract class AbstractCalculoAjusteBaseService {

    protected abstract void precondiciones(@NotNull TareaDto tarea,
            @NotNull @NotEmpty List<IdPersonaLocalDto> personas);

    protected abstract void ajustar(@NotNull AlgoritmoAjusteDto algoritmoAjuste);

    protected abstract void postcondiciones();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public final void ajustar(@NotNull final AlgoritmoAjusteDto algoritmoAjuste, @NotNull final TareaDto tarea,
            @NotNull @NotEmpty final List<IdPersonaLocalDto> personas) {
        try {
            this.precondiciones(tarea, personas);
            this.ajustar(algoritmoAjuste);
        } finally {
            this.postcondiciones();
        }
    }

}
