/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */

public abstract class AbstractCalculoAjusteBaseService {

    protected abstract void precondiciones(TareaDto tarea, List<IdPersonaLocalDto> personas);

    protected abstract void ajustar(AlgoritmoAjusteDto algoritmoAjuste);

    protected abstract void postcondiciones();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public final void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
            final List<IdPersonaLocalDto> personas) {
        try {
            this.precondiciones(tarea, personas);
            this.ajustar(algoritmoAjuste);
        } finally {
            this.postcondiciones();
        }
    }

}
