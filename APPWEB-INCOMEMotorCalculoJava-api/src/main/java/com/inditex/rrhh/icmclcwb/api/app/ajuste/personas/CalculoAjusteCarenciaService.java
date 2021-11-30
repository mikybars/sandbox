/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.ajuste.personas;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
public interface CalculoAjusteCarenciaService {

    void ajustar(@NotNull final AlgoritmoAjusteDto algoritmoAjuste, @NotNull final TareaDto tarea,
            @NotNull @NotEmpty final List<IdPersonaLocalDto> personas);

}
