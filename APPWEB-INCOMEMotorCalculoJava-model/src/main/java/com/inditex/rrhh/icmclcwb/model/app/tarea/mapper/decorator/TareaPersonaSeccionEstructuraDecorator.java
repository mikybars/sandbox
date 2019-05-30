package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaSeccionEstructuraMapper;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaPersonaSeccionEstructuraDecorator extends TareaPersonaSeccionEstructuraMapper {

    @Autowired
    private TareaPersonaSeccionEstructuraMapper delegate;

    @Override
    public List<TareaPersonaSeccionEstructuraDto> listaPorcentajesResultItemDtoToTareaPersonaSeccionEstructuraDto
        (List<ListaPorcentajesResultItemDto> src, ComisionEmpleadoResultItemDto comisionEmpleado, TareaDto tarea) {

        List<TareaPersonaSeccionEstructuraDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            src.forEach(x -> {
                if (StringUtils.isNotBlank(x.getPorcentaje())) {
                    Integer seccion = Integer.valueOf(x.getIdSeccion());
                    // Si la seccion es la 4 quiere decir que las tres secciones tienen el mismo porcentaje,
                    // por lo que se crean las tres secciones por separado (se guarda el original en id_seccion_estructura)
                    if (AppConstants.SECCION_4 == seccion) {
                        for (Integer idSeccionEfectiva : AppConstants.SECCIONES) {
                            result.add(createTareaEmpleadoSeccionEstructuraDto(idSeccionEfectiva.toString(),
                                x.getIdSeccion(), x.getPorcentaje(), comisionEmpleado, tarea));
                        }
                    } else {
                        result.add(createTareaEmpleadoSeccionEstructuraDto(x.getIdSeccion(),
                            x.getIdSeccion(), x.getPorcentaje(), comisionEmpleado, tarea));
                    }
                }
            });
        }
        return result;
    }

    @Override
    public List<TareaPersonaSeccionEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaSeccionEstructuraDto(
        List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        List<TareaPersonaSeccionEstructuraDto> result = new ArrayList<>();
        src.forEach(x -> {
            result.addAll(listaPorcentajesResultItemDtoToTareaPersonaSeccionEstructuraDto(x.getIcmListaPorcentajes(), x, tarea));
        });
        return result;
    }

    private TareaPersonaSeccionEstructuraDto createTareaEmpleadoSeccionEstructuraDto(
        String idSeccionEfectiva, String idSeccionEstructura, String valor,
        ComisionEmpleadoResultItemDto comisionEmpleado, TareaDto tarea) {
        TareaPersonaSeccionEstructuraDto result = delegate.comisionEmpleadoResultItemDtoToTareaPersonaSeccionEstructuraDto(comisionEmpleado, tarea);
        result.setIdSeccionEfectiva(idSeccionEfectiva);
        result.setIdSeccionEstructura(idSeccionEstructura);
        result.setValor(valor);
        return result;
    }
}
