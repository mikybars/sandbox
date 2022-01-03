package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionPresenciaDecorator
    extends TareaLocalizacionPresenciaMapper {

  @Autowired
  private TareaLocalizacionPresenciaMapper delegate;

  @Override
  public List<TareaLocalizacionPresencia> presenciaManualLocalizacionResultItemDtoToTareaLocalizacionPresencia(
      final List<PresenciaManualWlocResultItemDto> src, final TareaDto tareaDto) {
    final List<TareaLocalizacionPresencia> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> {
        if (AppConstants.getSECCIONES_STRING().contains(item.getIdSeccion())) {
          result.add(
              this.delegate.presenciaManualLocalizacionResultItemDtoToTareaLocalizacionPresencia(item,
                  tareaDto));
        }
      });
    }
    return result;
  }

}
