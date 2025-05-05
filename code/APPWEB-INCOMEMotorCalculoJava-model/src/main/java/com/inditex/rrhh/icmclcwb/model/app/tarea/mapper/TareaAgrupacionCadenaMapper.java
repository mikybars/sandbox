package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionCadenaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaAgrupacionCadenaMapperDecorator.class)
public abstract class TareaAgrupacionCadenaMapper {

  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.idAgrupacion", target = "icmIdAgrupacionOnline")
  @Mapping(source = "src.idCadena", target = "cclIdCadena")
  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "multiple", ignore = true)
  public abstract TareaAgrupacionCadena getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(
      AgrupOnlineResultItemDto src, TareaDto tarea);

  public List<TareaAgrupacionCadena> getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(
      List<AgrupOnlineResultItemDto> src, TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(source = "tarea.id", target = "idTarea")
  public abstract TareaAgrupacionCadenaDto getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(
      TareaAgrupacionCadena src);

  public List<TareaAgrupacionCadenaDto> getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(
      List<TareaAgrupacionCadena> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public List<TareaAgrupacionCadenasDto> getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto(
      List<TareaAgrupacionCadena> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(source = "tarea.id", target = "tarea.id")
  @Mapping(source = "src.idAgrupacionOnline", target = "icmIdAgrupacionOnline")
  @Mapping(source = "src.idCadena", target = "cclIdCadena")
  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "multiple", ignore = true)
  public abstract TareaAgrupacionCadena getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena(
      AgrupacionesOnlineResponseDTO src, TareaDto tarea);

  public List<TareaAgrupacionCadena> getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena(
      List<AgrupacionesOnlineResponseDTO> src, TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }
}
