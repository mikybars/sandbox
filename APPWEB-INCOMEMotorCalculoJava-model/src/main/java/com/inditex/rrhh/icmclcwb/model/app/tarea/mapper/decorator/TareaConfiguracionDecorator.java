package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;

public abstract class TareaConfiguracionDecorator extends TareaConfiguracionMapper {

    @Autowired
    private TareaConfiguracionMapper delegate;

    @Override
    public List<TareaConfiguracion> getConfiguracionItemDtoToTareaConfiguracion(List<ConfiguracionItemDto> src, TareaDto tarea) {
        List<TareaConfiguracion> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> {
                TareaConfiguracion item = delegate.getConfiguracionItemDtoToTareaConfiguracion(x, tarea);
                item.setIcmIdConfig(0);
                result.add(item);
            });
        }
        return result;
    }
}
