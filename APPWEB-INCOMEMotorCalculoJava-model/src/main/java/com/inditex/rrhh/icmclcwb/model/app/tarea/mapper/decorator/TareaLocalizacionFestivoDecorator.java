package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionFestivoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

public abstract class TareaLocalizacionFestivoDecorator extends TareaLocalizacionFestivoMapper {

    @Autowired
    private TareaLocalizacionFestivoMapper delegate;
    
    @Override
    public List<TareaLocalizacionFestivo> genericTiendaResultItemDtoToTareaLocalizacionFestivo(
            List<GenericTiendaResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionFestivo> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> 
                result.add(
                        delegate.genericTiendaResultItemDtoToTareaLocalizacionFestivo(item, tareaDto))
            );
        }
        return result;
    }

}
