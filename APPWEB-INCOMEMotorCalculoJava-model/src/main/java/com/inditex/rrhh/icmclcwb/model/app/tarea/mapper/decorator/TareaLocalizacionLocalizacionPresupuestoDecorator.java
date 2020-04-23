package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaLocalizacionLocalizacionPresupuestoDecorator extends TareaLocalizacionPresupuestoMapper {

    @Autowired
    private TareaLocalizacionPresupuestoMapper delegate;

    @Override
    public List<TareaLocalizacionPresupuesto> presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(List<PresupuestosWlocResultItemDto> src, TareaDto tarea) {
        ArrayList<TareaLocalizacionPresupuesto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(item -> result.add(delegate.presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(item, tarea)));
        }
        return result;
    }
}
