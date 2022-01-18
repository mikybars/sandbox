package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaConfiguracionDecorator.class)
public abstract class TareaConfiguracionMapper {

  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.fechaInicio", target = "fechaInicio")
  @Mapping(source = "src.fechaFin", target = "fechaFin")
  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(source = "src.idTipoHora", target = "codTipoHora")
  @Mapping(source = "src.icmCkVentaImpuestos", target = "icmCkVentaImpuestos")
  @Mapping(source = "src.icmCkIncIvaEvalPtpo", target = "icmCkIncIvaEvalPtpo")
  @Mapping(source = "src.icmCkRedJornada", target = "icmCkRedJornada")
  public abstract TareaConfiguracion getConfiguracionItemDtoToTareaConfiguracion(
      ConfiguracionItemDto src, TareaDto tarea);

  public List<TareaConfiguracion> getConfiguracionItemDtoToTareaConfiguracion(
      final List<ConfiguracionItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
