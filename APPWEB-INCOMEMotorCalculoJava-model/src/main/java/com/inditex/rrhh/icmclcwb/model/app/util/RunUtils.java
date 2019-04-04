package com.inditex.rrhh.icmclcwb.model.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoTareaTiendaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoTareaTiendaDto;

@Component
public class RunUtils {

    private RunUtils() {
    }

    public static boolean isPresenciaTienda(final TareaDto tarea) {
        return CollectionUtils.isNotEmpty(tarea.getLocalizacion()) || CollectionUtils.isNotEmpty(tarea.getPersona());
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
    
    public static String addDays(final LocalDateTime ldt, int number, String datePattern) {
        LocalDateTime date = LocalDateTime.of(ldt.getYear(),
                ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond());
        return date.plusDays(number).format(DateTimeFormatter.ofPattern(datePattern));
    }

}
