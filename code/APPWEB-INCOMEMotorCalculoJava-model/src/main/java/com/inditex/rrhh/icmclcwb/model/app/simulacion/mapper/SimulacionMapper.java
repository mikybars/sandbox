package com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class SimulacionMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "esVentaUltimoCalculo",
      expression = "java(src != null && src.getIdTipoVentaLocalizacionSimulacion() != null && src.getIdTipoVentaLocalizacionSimulacion().getId() != null  && src.getIdTipoVentaLocalizacionSimulacion().getId() == 1 ?"
          + " Boolean.TRUE : Boolean.FALSE)")
  @Mapping(target = "esPresenciaEmpleadoUltimoCalculo",
      expression = "java(src != null && src.getIdTipoPresenciaPersonaSimulacion() != null && src.getIdTipoPresenciaPersonaSimulacion().getId() != null  && src.getIdTipoPresenciaPersonaSimulacion().getId() == 1 ?"
          + " Boolean.TRUE : Boolean.FALSE)")
  @Mapping(target = "esPresenciaTiendaUltimoCalculo",
      expression = "java(src != null && src.getIdTipoPresenciaLocalizacionSimulacion() != null && src.getIdTipoPresenciaLocalizacionSimulacion().getId() != null  && src.getIdTipoPresenciaLocalizacionSimulacion().getId() == 1 ?"
          + " Boolean.TRUE : Boolean.FALSE)")
  public abstract SimulacionDto simulacionToSimulacionDto(Simulacion src);
}
