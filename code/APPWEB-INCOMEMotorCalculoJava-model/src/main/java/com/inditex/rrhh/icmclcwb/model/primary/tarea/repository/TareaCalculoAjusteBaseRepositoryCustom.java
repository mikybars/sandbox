package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoAjusteBaseRepositoryCustom {

  List<IdPersonaLocalDto> ids(final TareaDto tarea);

  String getSqlAjustar(final AlgoritmoAjusteDto algoritmoAjuste);

  void ajustar(AlgoritmoAjusteDto algoritmoAjuste, TareaDto tareaDto);
}
