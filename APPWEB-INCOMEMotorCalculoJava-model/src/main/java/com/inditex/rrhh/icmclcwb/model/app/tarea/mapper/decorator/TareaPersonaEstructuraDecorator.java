package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaPersonaEstructuraDecorator extends TareaPersonaEstructuraMapper {

    @Autowired
    private TareaPersonaEstructuraMapper delegate;

    @Override
    public List<TareaPersonaEstructuraDto> listaPorcentajesResultItemDtoToTareaPersonaEstructuraDto(
            List<ListaPorcentajesResultItemDto> src, ComisionEmpleadoResultItemDto comisionEmpleado, TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> {
                Integer seccion = Integer.valueOf(x.getIdSeccion());
                // Si la seccion es la 4 quiere decir que las tres secciones tienen el mismo
                // porcentaje, por lo que se crean las tres secciones por separado (se guarda el
                // original en id_seccion_estructura)
                if (AppConstants.SECCION_4.equals(seccion)) {
                    for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                        result.add(createTareaEmpleadoSeccionEstructuraDto(idSeccionEfectiva.toString(),
                                x.getIdSeccion(), x.getPorcentaje(), comisionEmpleado, tarea));
                    }
                } else {
                    result.add(createTareaEmpleadoSeccionEstructuraDto(x.getIdSeccion(), x.getIdSeccion(),
                            x.getPorcentaje(), comisionEmpleado, tarea));
                }
            });
        }
        return result;
    }

    @Override
    public List<TareaPersonaEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        List<TareaPersonaEstructuraDto> result = new ArrayList<>();
        src.forEach(x -> result.addAll(
                listaPorcentajesResultItemDtoToTareaPersonaEstructuraDto(x.getIcmListaPorcentajes(), x, tarea)));
        return result;
    }

    private TareaPersonaEstructuraDto createTareaEmpleadoSeccionEstructuraDto(final String idSeccionEfectiva,
            final String idSeccionEstructura, final String valor, final ComisionEmpleadoResultItemDto comisionEmpleado,
            final TareaDto tarea) {
        TareaPersonaEstructuraDto result = delegate
                .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(comisionEmpleado, tarea);
        result.setCclIdSeccionEfectiva(idSeccionEfectiva);
        result.setCclIdSeccionEstructura(idSeccionEstructura);
        result.setValor(valor);
        return result;
    }

}
