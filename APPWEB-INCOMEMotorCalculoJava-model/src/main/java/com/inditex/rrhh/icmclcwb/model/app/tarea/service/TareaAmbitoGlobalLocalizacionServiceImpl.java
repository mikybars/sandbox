package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionRepositoryCustom;

@Service
@Validated
public class TareaAmbitoGlobalLocalizacionServiceImpl implements TareaAmbitoGlobalLocalizacionService {

    @Autowired
    private TareaAmbitoGlobalLocalizacionRepositoryCustom tareaAmbitoGlobalLocalizacionRepositoryCustom;

    @Override
    public void mergeLocalizacion(RunTareaDto runTareaDto) {
        tareaAmbitoGlobalLocalizacionRepositoryCustom.mergeLocalizacion(runTareaDto);
    }

}
