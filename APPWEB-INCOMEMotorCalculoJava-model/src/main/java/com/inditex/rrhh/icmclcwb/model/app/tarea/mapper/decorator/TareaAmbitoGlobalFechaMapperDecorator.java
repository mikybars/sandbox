package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalFechaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalFecha;
import org.apache.commons.collections.CollectionUtils;


public abstract class TareaAmbitoGlobalFechaMapperDecorator extends TareaAmbitoGlobalFechaMapper {

    @Autowired
    private TareaAmbitoGlobalFechaMapper delegate;

    @Override
    public List<TareaAmbitoGlobalFecha> tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(
            final List<TareaAmbitoGlobalFechaDto> src, final TareaDto tarea) {
        final List<TareaAmbitoGlobalFecha> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(src)) {
            for (final TareaAmbitoGlobalFechaDto item : src) {
                final TareaAmbitoGlobalFecha fecha = this.delegate
                    .tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(item);
                if (!fecha.getFechaInicio().equals(tarea.getFechaInicioPeriodo())) {
                    final TareaAmbitoGlobalFecha ampliado = this.delegate
                        .tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(item);
                    final TipoDato tipoDato = new TipoDato();
                    tipoDato.setId(TipoDatoEnum.PERIODO_AMPLIADO.getId());
                    ampliado.setTipoDato(tipoDato);
                    result.add(ampliado);
                }
                final TipoDato tipoDato = new TipoDato();
                tipoDato.setId(TipoDatoEnum.PERIODO.getId());
                fecha.setTipoDato(tipoDato);
                fecha.setFechaInicio(TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
                fecha.setFechaFin(TimeUtils.toDate(tarea.getFechaFinPeriodo()));
                result.add(fecha);
            }
        }
        return result;
    }

}
