package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl
    implements TareaAmbitoGlobalLocalizacionPersonaPresenciaService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom;

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper tareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;

  @Override
  public void save(@Valid @NotNull final PtrPresenciaEmpleadosTiendaResponseDto src,
      @Valid @NotNull final TareaDto tareaDto) {
    tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom
        .save(tareaAmbitoGlobalLocalizacionPersonaPresenciaMapper
            .presenciaEmpleadosTiendaResultItemDtoToTareaLocalizacionPersonaPresencia(
                src.getPresenciasTiendasEmpleado(), tareaDto));
  }

}
