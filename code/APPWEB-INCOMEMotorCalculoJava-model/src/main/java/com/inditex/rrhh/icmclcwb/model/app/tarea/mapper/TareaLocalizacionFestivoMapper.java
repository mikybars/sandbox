package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionFestivoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.util.HorarioComercialPropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionFestivoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionFestivoDecorator.class)
public abstract class TareaLocalizacionFestivoMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaLocalizacionFestivoDto tareaLocalizacionFestivoToTareaLocalizacionFestivoDto(
      TareaLocalizacionFestivo src);

  public abstract List<TareaLocalizacionFestivoDto> tareaLocalizacionFestivoToTareaLocalizacionFestivoDto(
      List<TareaLocalizacionFestivo> src);

  @InheritInverseConfiguration
  public abstract TareaLocalizacionFestivo tareaLocalizacionFestivoDtoToTareaLocalizacionFestivo(
      TareaLocalizacionFestivoDto src);

  public abstract List<TareaLocalizacionFestivo> tareaLocalizacionFestivoDtoToLocalizacionFestivo(
      List<TareaLocalizacionFestivoDto> src);

  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(source = "src.idTienda", target = "cclIdCodOrigen")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "fecha", source = "src.fecha",
      dateFormat = HorarioComercialPropertiesConstants.DATE_FORMAT)
  public abstract TareaLocalizacionFestivo horarioComercialFestivoDocDtoToTareaLocalizacionFestivo(
      HorarioComercialFestivoDocDto src, TareaDto tareaDto);

  public List<TareaLocalizacionFestivo> horarioComercialFestivoDocDtoToTareaLocalizacionFestivo(
      final List<HorarioComercialFestivoDocDto> src, final TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
