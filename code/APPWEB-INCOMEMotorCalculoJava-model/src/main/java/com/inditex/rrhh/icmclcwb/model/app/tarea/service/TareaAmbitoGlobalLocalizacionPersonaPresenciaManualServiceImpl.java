package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl
    implements TareaAmbitoGlobalLocalizacionPersonaPresenciaManualService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom;

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper tareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto) {
    tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom.save(
        tareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper
            .genericEmpleadoResultItemDtoToTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(src, tareaDto));
  }

}
