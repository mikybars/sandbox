package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraDesplazamientoRealMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamientoReal;


public abstract class TareaPersonaEstructuraDesplazamientoRealDecorator
        extends TareaPersonaEstructuraDesplazamientoRealMapper {

    @Autowired
    private TareaPersonaEstructuraDesplazamientoRealMapper delegate;

    @Override
    public List<TareaPersonaEstructuraDesplazamientoReal> desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(
            final List<DesplazamientoRealResultItemDto> src, final TareaDto tarea) {
        final List<TareaPersonaEstructuraDesplazamientoReal> result = new ArrayList<>();
        src.forEach(x -> {
            final TareaPersonaEstructuraDesplazamientoReal desplazamiento = this.delegate
                .desplazamientoRealResultItemDtoToTareaPersonaEstructuraDesplazamientoReal(x, tarea);
            if (desplazamiento.getFechaFin() == null) {
                desplazamiento
                    .setFechaFin(
                            Date.from(tarea.getFechaFinPeriodo().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            result.add(desplazamiento);
        });
        return result;
    }

}
