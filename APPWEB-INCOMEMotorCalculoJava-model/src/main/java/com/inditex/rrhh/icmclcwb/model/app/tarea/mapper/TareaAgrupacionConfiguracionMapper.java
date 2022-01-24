package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionAgrupacionConfiguracionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {TipoVentaConcepto.class, TipoVentaConceptoEnum.class})
@DecoratedWith(TareaAgrupacionAgrupacionConfiguracionDecorator.class)
public abstract class TareaAgrupacionConfiguracionMapper {

  @Mapping(source = "src.fechaInicio", target = "fechaInicio")
  @Mapping(source = "src.fechaFin", target = "fechaFin")
  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(source = "src.porcentaje", target = "porcentajeInclusion")
  @Mapping(source = "src.idAgrupacion", target = "icmIdAgrupacionOnline")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tipoVentaConcepto", ignore = true)
  public abstract TareaAgrupacionConfiguracion getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
      ConfiguracionVentaOnlineResultItemDto src, TareaDto tareaDto);

  public List<TareaAgrupacionConfiguracion> getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
      List<ConfiguracionVentaOnlineResultItemDto> src, TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(source = "src.tarea.id", target = "idTarea")
  @Mapping(target = "tipoVentaConcepto", ignore = true)
  public abstract TareaAgrupacionConfiguracionDto getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
      TareaAgrupacionConfiguracion src);

  public List<TareaAgrupacionConfiguracionDto> getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
      List<TareaAgrupacionConfiguracion> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
