package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoTareaTiendaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoTareaTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

@Component
public class RunUtils {

    private RunUtils() {
    }

    public static boolean isPresenciaTienda(final TareaDto tarea) {
        return CollectionUtils.isNotEmpty(tarea.getTiendas()) || CollectionUtils.isNotEmpty(tarea.getEmpleados());
    }

    public static boolean isTipoTareaTiendaPresencia(final List<TipoTareaTiendaDto> tipoTareaTienda) {
        return tipoTareaTienda.contains(TipoTareaTiendaEnum.PRESENCIA.getDto());
    }

    public static boolean isPivot(final TareaDto tarea, final List<TipoTareaTiendaDto> tipoTareaTienda) {
        return !RunUtils.isPresenciaTienda(tarea) || RunUtils.isTipoTareaTiendaPresencia(tipoTareaTienda);
    }
    
    public static boolean isPivot(final TareaDto tarea) {
        return !RunUtils.isPresenciaTienda(tarea);
    }


}
