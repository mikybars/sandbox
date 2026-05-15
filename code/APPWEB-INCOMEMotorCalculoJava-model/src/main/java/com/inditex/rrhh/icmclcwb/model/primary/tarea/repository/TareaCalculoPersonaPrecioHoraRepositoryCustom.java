package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalSimpleDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoPersonaPrecioHoraRepositoryCustom {

  List<IdPersonaLocalSimpleDto> getEmployeeLocalIds(@NotNull Long idTarea, @NotNull String cclIdOrigen);

  void insertPrecioHora(@NotNull Long idTarea, @NotNull Long icmIdPeriodo, @NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt, @NotNull List<String> cclIdPersonList);

}
