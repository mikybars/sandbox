package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPresupuesto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaPresupuestoDecorator extends TareaPresupuestoMapper {

    @Autowired
    private TareaPresupuestoMapper delegate;

    @Override
    public List<TareaPresupuesto> presupuestosWlocResultItemDtoToTareaPresupuesto(List<PresupuestosWlocResultItemDto> src, TareaDto tarea) {
        ArrayList<TareaPresupuesto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate.presupuestosWlocResultItemDtoToTareaPresupuesto(item, tarea)));
        }
        return result;
    }
}
