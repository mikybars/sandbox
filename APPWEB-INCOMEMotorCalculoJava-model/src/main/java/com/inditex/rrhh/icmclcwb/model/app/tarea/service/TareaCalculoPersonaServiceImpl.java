package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCalculoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepositoryCustom;

@Service
@Validated
public class TareaCalculoPersonaServiceImpl implements TareaCalculoPersonaService {

    @Autowired
    private TareaCalculoPersonaRepositoryCustom tareaCalculoPersonaRepositoryCustom;

    @Autowired
    private TareaCalculoPersonaMapper tareaCalculoPersonaMapper;
    
    @Override
    public void mergePersonaCalculo(RunTareaDto runTareaDto) {
        tareaCalculoPersonaRepositoryCustom.mergePersonaCalculo(runTareaDto);
    }
}
