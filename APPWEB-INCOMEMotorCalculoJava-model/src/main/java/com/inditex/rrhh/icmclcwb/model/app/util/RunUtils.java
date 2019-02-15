package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.TipoTrabajoTiendaEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Component
public class RunUtils {

    private RunUtils() {
    }

    public static boolean isPresenciaTienda(final TrabajoDto trabajo) {
        return CollectionUtils.isNotEmpty(trabajo.getTiendas()) || CollectionUtils.isNotEmpty(trabajo.getEmpleados());
    }

    public static boolean isTipoTrabajoTiendaPresencia(final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) {
        return tipoTrabajoTienda.contains(TipoTrabajoTiendaEnum.PRESENCIA.getDto());
    }

    public static boolean isPivot(final TrabajoDto trabajo, final List<TipoTrabajoTiendaDto> tipoTrabajoTienda) {
        return !RunUtils.isPresenciaTienda(trabajo) || RunUtils.isTipoTrabajoTiendaPresencia(tipoTrabajoTienda);
    }
    
    public static boolean isPivot(final TrabajoDto trabajo) {
        return !RunUtils.isPresenciaTienda(trabajo);
    }


}
