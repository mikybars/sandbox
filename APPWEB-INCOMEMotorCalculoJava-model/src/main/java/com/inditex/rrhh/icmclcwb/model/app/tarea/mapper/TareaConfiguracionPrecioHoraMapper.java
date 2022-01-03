package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionPrecioHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;

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
  @Mapping(target = "icmCkTpHoraComis", source = "src.idTipoHoraComis")
  @Mapping(target = "icmCkTpHoraIncPtpo", source = "src.idTipoHoraIncptpo")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  public abstract TareaConfiguracionPrecioHora confPrecioHoraResultItemDtoToTareaConfiguracionPrecioHora(
      ConfPrecioHoraResultItemDto src, TareaDto tarea);

  public List<TareaConfiguracionPrecioHora> confPrecioHoraResultItemDtoToTareaConfiguracionPrecioHora(
      final List<ConfPrecioHoraResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
