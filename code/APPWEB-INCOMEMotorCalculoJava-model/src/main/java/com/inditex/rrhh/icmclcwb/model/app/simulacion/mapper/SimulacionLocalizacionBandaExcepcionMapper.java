package com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionLocalizacionBandaExcepcionDto;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.SimulacionLocalizacionBandaExcepcion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class SimulacionLocalizacionBandaExcepcionMapper {

  @Mapping(target = "esExcepcionBanda0", expression = "java(src != null && src.getBanda() == 0 ? Boolean.TRUE : Boolean.FALSE)")
  @Mapping(target = "esExcepcionBanda1", expression = "java(src != null && src.getBanda() == 1 ? Boolean.TRUE : Boolean.FALSE)")
  @Mapping(target = "esExcepcionBanda2", expression = "java(src != null && src.getBanda() == 2 ? Boolean.TRUE : Boolean.FALSE)")
  public abstract SimulacionLocalizacionBandaExcepcionDto simulacionLocalizacionBandaExcepcionToDto(
      SimulacionLocalizacionBandaExcepcion src);

  public abstract List<
      SimulacionLocalizacionBandaExcepcionDto> simulacionLocalizacionBandaExcepcionToDto(
          List<SimulacionLocalizacionBandaExcepcion> src);

}
