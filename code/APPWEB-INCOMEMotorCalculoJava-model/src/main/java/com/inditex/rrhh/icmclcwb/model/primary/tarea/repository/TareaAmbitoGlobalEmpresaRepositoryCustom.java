package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalEmpresa;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoGlobalEmpresaRepositoryCustom {

  List<TareaAmbitoGlobalEmpresa> save(List<TareaAmbitoGlobalEmpresa> src);

  List<IdEmpresaDto> findIdEmpresaByIdTarea(@NonNull @Positive Long idTarea);

}
