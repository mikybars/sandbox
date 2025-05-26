package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionPrecioHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaConfiguracionPrecioHoraDecorator.class)
public abstract class TareaConfiguracionPrecioHoraMapper {

  @Mapping(target = "tarea", ignore = true)
  public abstract TareaConfiguracionPrecioHora tareaConfiguracionPrecioHoraDtoToTareaConfiguracionPrecioHora(
      TareaConfiguracionPrecioHoraDto src);

  public abstract List<TareaConfiguracionPrecioHora> tareaConfiguracionPrecioHoraDtoToTareaConfiguracionPrecioHora(
      List<TareaConfiguracionPrecioHoraDto> src);

  @Mapping(target = "idTarea", ignore = true)
  public abstract TareaConfiguracionPrecioHoraDto tareaConfiguracionPrecioHoraToTareaConfiguracionPrecioHoraDto(
      TareaConfiguracionPrecioHora src);

  public abstract List<TareaConfiguracionPrecioHoraDto> tareaConfiguracionPrecioHoraToTareaConfiguracionPrecioHoraDto(
      List<TareaConfiguracionPrecioHora> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "icmCkTpHoraComis", expression = "java(src.getTipoHoraComision() != null && src.getTipoHoraComision() != 0)")
  @Mapping(target = "icmCkTpHoraIncPtpo", expression = "java(src.getTipoHoraInc() != null && src.getTipoHoraInc() != 0)")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  public abstract TareaConfiguracionPrecioHora configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(
      ConfiguracionPrecioHoraResponseDTO src, TareaDto tarea);

  public List<TareaConfiguracionPrecioHora> configuracionPrecioHoraResponseDTOToTareaConfiguracionPrecioHora(
      final List<ConfiguracionPrecioHoraResponseDTO> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
