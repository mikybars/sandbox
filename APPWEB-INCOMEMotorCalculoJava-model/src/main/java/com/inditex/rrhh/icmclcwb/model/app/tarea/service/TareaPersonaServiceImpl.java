package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaRepositoryCustom;

@Service
@Validated
public class TareaPersonaServiceImpl implements TareaPersonaService {

    @Autowired
    private TareaPersonaRepositoryCustom tareaPersonaRepositoryCustom;

    @Autowired
    private TareaPersonaMapper tareaPersonaMapper;
    
    @Override
    public void mergePersona(RunTareaDto runTareaDto) {
        tareaPersonaRepositoryCustom.mergePersona(runTareaDto);
    }

}
