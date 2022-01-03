package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaAmbitoGlobalEmpresaService {

  void save(@Valid @NotNull @NotEmpty List<TareaAmbitoGlobalEmpresaDto> src, @Valid @NotNull TareaDto tarea);

  List<IdEmpresaDto> findIdEmpresaByIdTarea(@Valid @NotNull Long idTarea);

}
