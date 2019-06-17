package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionCadenaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaAgrupacionCadenaMapperDecorator extends TareaAgrupacionCadenaMapper {

    @Autowired
    private TareaAgrupacionCadenaMapper delegate;

    @Override
    public List<TareaAgrupacionCadena> getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(List<AgrupOnlineResultItemDto> src, TareaDto tarea) {
        List<TareaAgrupacionCadena> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> {
                TareaAgrupacionCadena agrupacion = delegate.getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(x, tarea);
                boolean multiple = src.stream().filter(y -> y.getIdOrigen().equals(x.getIdOrigen()) && y.getIdAgrupacion().equals(x.getIdAgrupacion())).count() > 1;
                agrupacion.setMultiple(multiple);
                result.add(agrupacion);
            });
        }
        return result;
    }

    @Override
    public List<TareaAgrupacionCadenaDto> getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(List<TareaAgrupacionCadena> src) {
        List<TareaAgrupacionCadenaDto> result = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> result.add(delegate.getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(x)));
        }
        return result;
    }
}
