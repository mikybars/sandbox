package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class IdPersonaLocalExternaMapper {

  @Mapping(source = "idPersonaLocal", target = "idPersonaLocal")
  @Mapping(source = "fechaDesde", target = "fechaDesde")
  @Mapping(source = "fechaHasta", target = "fechaHasta")
  public abstract IdPersonaLocalExternaDto empleadoExternoDTOtoIdPersonaLocalExternaDto(
      EmpleadoExternoDTO src);

  public abstract List<IdPersonaLocalExternaDto> empleadoExternoDTOtoIdPersonaLocalExternaDto(
      List<EmpleadoExternoDTO> src);

}
