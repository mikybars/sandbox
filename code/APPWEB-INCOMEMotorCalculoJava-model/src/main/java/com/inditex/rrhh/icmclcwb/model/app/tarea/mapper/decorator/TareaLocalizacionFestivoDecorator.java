package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionFestivoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionFestivoDecorator extends TareaLocalizacionFestivoMapper {

  @Autowired
  private TareaLocalizacionFestivoMapper delegate;

  /*
   * Este codigo esta desactivado porque solo funciona en DES
   *
   * @Override public TareaLocalizacionFestivo horarioComercialFestivoDocDtoToTareaLocalizacionFestivo( final HorarioComercialFestivoDocDto
   * src, final TareaDto tareaDto) { final TareaLocalizacionFestivo tareaLocalizacionFestivo = this.delegate
   * .horarioComercialFestivoDocDtoToTareaLocalizacionFestivo(src, tareaDto); try { tareaLocalizacionFestivo .setFecha(new
   * SimpleDateFormat(HorarioComercialPropertiesConstants.DATE_FORMAT_RESULT, Locale.ENGLISH) .parse(src.getFecha())); } catch (final
   * ParseException e) { throw new SlrhorcomsIcmclcwbException(e.getMessage(), e); } return tareaLocalizacionFestivo; }
   */
  @Override
  public List<TareaLocalizacionFestivo> horarioComercialFestivoDocDtoToTareaLocalizacionFestivo(
      final List<HorarioComercialFestivoDocDto> src,
      final TareaDto tareaDto) {
    final List<TareaLocalizacionFestivo> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> result
          .add(this.horarioComercialFestivoDocDtoToTareaLocalizacionFestivo(item, tareaDto)));
    }
    return result;
  }

}
