package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionPersonaPresenciaManualService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoLocalizacionPersonaPresenciaManualRepositoryCustom;

@Service
@Validated
public class TareaAmbitoLocalizacionPersonaPresenciaManualServiceImpl
        implements TareaAmbitoLocalizacionPersonaPresenciaManualService {

    @Autowired
    TareaAmbitoLocalizacionPersonaPresenciaManualRepositoryCustom tareaLocalizacionPersonaPresenciaManualRepositoryCustom;
    
    @Autowired
    TareaAmbitoLocalizacionPersonaPresenciaManualMapper tareaLocalizacionPersonaPresenciaManualMapper;
    
    @Override
    public void save(@NotNull final List<GenericEmpleadoResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaManualRepositoryCustom.save(
                tareaLocalizacionPersonaPresenciaManualMapper.genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
    }
}
