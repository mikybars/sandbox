package com.inditex.rrhh.icmclcwb.api.app.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface CalculoAjusteMaximoGarantizadoService {

  void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
      final List<IdPersonaLocalDto> personas);

}
