package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionServiceImpl implements TareaLocalizacionService {

    @Autowired
    private TareaLocalizacionRepositoryCustom tareaLocalizacionRepositoryCustom;

    @Autowired
    private TareaLocalizacionMapper tareaLocalizacionMapper;
    
    @Override
    public void mergeLocalizacion(RunTareaDto runTareaDto) {
        tareaLocalizacionRepositoryCustom.mergeLocalizacion(runTareaDto);
    }
}
