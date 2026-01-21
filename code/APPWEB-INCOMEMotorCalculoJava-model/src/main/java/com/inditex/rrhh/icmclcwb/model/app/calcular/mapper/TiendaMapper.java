package com.inditex.rrhh.icmclcwb.model.app.calcular.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiendaResponseDTO;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TiendaMapper {

  @Mapping(target = "idOrigen", source = "cclIdOrigen")
  @Mapping(target = "idLugarTrabajo", source = "source.stdIdWorkLocat")
  @Mapping(target = "idLugarTrabajoMtu", source = "source.cclIdCodOrigen")
  @Mapping(target = "fechaInicio", expression = "java(source.getFechaInicio().atStartOfDay())")
  @Mapping(target = "fechaFin", expression = "java(source.getFechaFin().atStartOfDay())")
  @Mapping(target = "idPais", source = "source.stdIdCountry")
  @Mapping(target = "idProvincia", source = "source.stdIdSubGeoDiv")
  @Mapping(target = "idEmpresa", source = "source.stdIdLegEnt")
  @Mapping(target = "idCadena", source = "source.cclIdCadena")
  GenericTiendaResultItemDto toGenericTiendaResultItemDto(TiendaResponseDTO source, String cclIdOrigen);

  List<GenericTiendaResultItemDto> toGenericTiendaResultItemDtoList(List<TiendaResponseDTO> source,
      @Context String cclIdOrigen);

  default GenericTiendaResultItemDto mapContext(TiendaResponseDTO car, @Context String cclIdOrigen) {
    return this.toGenericTiendaResultItemDto(car, cclIdOrigen);
  }
}
