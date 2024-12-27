package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoGlobalEmpresaService {

  void save(@Valid @NonNull @NotEmpty List<TareaAmbitoGlobalEmpresaDto> src, @Valid @NonNull TareaDto tarea);

  List<IdEmpresaDto> findIdEmpresaByIdTarea(@Valid @NonNull Long idTarea);

}
