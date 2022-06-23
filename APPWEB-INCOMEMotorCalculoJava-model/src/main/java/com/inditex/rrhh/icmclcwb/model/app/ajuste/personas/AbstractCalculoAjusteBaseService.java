package com.inditex.rrhh.icmclcwb.model.app.ajuste.personas;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractCalculoAjusteBaseService {

  protected abstract void precondiciones(TareaDto tarea, List<IdPersonaLocalDto> personas);

  protected abstract void postcondiciones();

  protected abstract void ajustar(AlgoritmoAjusteDto algoritmoAjuste, TareaDto tarea);

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void ajustar(final AlgoritmoAjusteDto algoritmoAjuste, final TareaDto tarea,
      final List<IdPersonaLocalDto> personas) {
    try {
      this.precondiciones(tarea, personas);
      this.ajustar(algoritmoAjuste, tarea);
    } finally {
      this.postcondiciones();
    }
  }

}
