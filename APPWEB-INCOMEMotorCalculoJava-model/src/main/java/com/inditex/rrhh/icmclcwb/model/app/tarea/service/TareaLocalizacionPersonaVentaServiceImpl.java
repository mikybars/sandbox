package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaVentaServiceImpl implements TareaLocalizacionPersonaVentaService {

    @Autowired
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;

}
