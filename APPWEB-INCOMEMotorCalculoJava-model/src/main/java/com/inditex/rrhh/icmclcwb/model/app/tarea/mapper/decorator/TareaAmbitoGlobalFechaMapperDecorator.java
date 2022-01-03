package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalFechaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalFecha;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAmbitoGlobalFechaMapperDecorator extends TareaAmbitoGlobalFechaMapper {

  @Autowired
  private TareaAmbitoGlobalFechaMapper delegate;

  @Override
  public List<TareaAmbitoGlobalFecha> tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(
      final List<TareaAmbitoGlobalFechaDto> src, final TareaDto tarea) {
    final List<TareaAmbitoGlobalFecha> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      for (final TareaAmbitoGlobalFechaDto item : src) {
        // Se guarda lo que venga como período ampliado (independientemente de que sea el mismo que el del
        // cálculo)
        final TareaAmbitoGlobalFecha periodoAmpliado = this.delegate
            .tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(item);
        periodoAmpliado.setTipoDato(TipoDato.builder().id(TipoDatoEnum.PERIODO_AMPLIADO.getId()).build());
        result.add(periodoAmpliado);

        // Y también el del cálculo
        final TareaAmbitoGlobalFecha periodoCalculo = this.delegate
            .tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(item);
        periodoCalculo.setTipoDato(TipoDato.builder().id(TipoDatoEnum.PERIODO.getId()).build());
        periodoCalculo.setFechaInicio(TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        periodoCalculo.setFechaFin(TimeUtils.toDate(tarea.getFechaFinPeriodo()));
        result.add(periodoCalculo);
      }
    }
    return result;
  }

}
