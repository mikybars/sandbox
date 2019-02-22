package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.proceso.TipoProcesoTiendaEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.TipoProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

@Component
public class RunUtils {

    private RunUtils() {
    }

    public static boolean isPresenciaTienda(final ProcesoDto proceso) {
        return CollectionUtils.isNotEmpty(proceso.getTiendas()) || CollectionUtils.isNotEmpty(proceso.getEmpleados());
    }

    public static boolean isTipoProcesoTiendaPresencia(final List<TipoProcesoTiendaDto> tipoProcesoTienda) {
        return tipoProcesoTienda.contains(TipoProcesoTiendaEnum.PRESENCIA.getDto());
    }

    public static boolean isPivot(final ProcesoDto proceso, final List<TipoProcesoTiendaDto> tipoProcesoTienda) {
        return !RunUtils.isPresenciaTienda(proceso) || RunUtils.isTipoProcesoTiendaPresencia(tipoProcesoTienda);
    }
    
    public static boolean isPivot(final ProcesoDto proceso) {
        return !RunUtils.isPresenciaTienda(proceso);
    }


}
