package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaCoeficienteService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaCoeficienteMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaCoeficienteRepositoryCustom;

@Service
@Validated
public class TareaPersonaCoeficienteServiceImpl implements TareaPersonaCoeficienteService {

    @Autowired
    private TareaPersonaCoeficienteRepositoryCustom tareaPersonaCoeficienteRepositoryCustom;
    
    @Autowired
    private TareaPersonaCoeficienteMapper tareaPersonaCoeficienteMapper;

    @Override
    public void save(@NotNull final List<GenericEmpleadoResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaPersonaCoeficienteRepositoryCustom.save(tareaPersonaCoeficienteMapper
                .genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(src, tareaDto));
    }
    
}
