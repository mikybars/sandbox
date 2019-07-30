package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaAgrupacionAgrupacionConfiguracionDecorator extends TareaAgrupacionConfiguracionMapper {

    @Autowired
    private TareaAgrupacionConfiguracionMapper delegate;

    @Override
    public List<TareaAgrupacionConfiguracion> getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
        List<ConfiguracionVentaOnlineResultItemDto> src, TareaDto tareaDto) {
        List<TareaAgrupacionConfiguracion> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x ->
                result.add(delegate.getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(x, tareaDto)));
        }
        return result;
    }

    @Override
    public List<TareaAgrupacionConfiguracionDto> getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
        List<TareaAgrupacionConfiguracion> src) {
        List<TareaAgrupacionConfiguracionDto> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x ->
                result.add(delegate.getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(x)));
        }
        return result;
    }
}
