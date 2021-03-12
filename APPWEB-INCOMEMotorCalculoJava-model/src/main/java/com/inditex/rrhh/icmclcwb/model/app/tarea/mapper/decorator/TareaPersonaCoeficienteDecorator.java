package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaCoeficienteMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;

public abstract class TareaPersonaCoeficienteDecorator extends TareaPersonaCoeficienteMapper {

    @Autowired
    private TareaPersonaCoeficienteMapper delegate;

    @Override
    public List<TareaPersonaCoeficiente> genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(
            List<GenericEmpleadoResultItemDto> srcTareaPersonaHistorico, TareaDto srcTarea) {
        List<TareaPersonaCoeficiente> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTareaPersonaHistorico)) {
            srcTareaPersonaHistorico.stream()
                .filter(e -> Integer.valueOf(e.getCoefJornada()) > 0)
                .forEach(item -> result.add(
                        delegate.genericEmpleadoResultItemDtoToTareaPersonaCoeficiente(item, srcTarea)));
        }
        return result;
    }

}
