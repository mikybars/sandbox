package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalEmpresa;

public interface TareaAmbitoGlobalEmpresaRepositoryCustom {

    List<TareaAmbitoGlobalEmpresa> save(List<TareaAmbitoGlobalEmpresa> src);

    List<IdEmpresaDto> findIdEmpresaByIdTarea(@NotNull @Positive Long idTarea);

}
