package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionFestivoMapper;

public abstract class TareaLocalizacionFestivoDecorator extends TareaLocalizacionFestivoMapper {

    @Autowired
    private TareaLocalizacionFestivoMapper delegate;

}
