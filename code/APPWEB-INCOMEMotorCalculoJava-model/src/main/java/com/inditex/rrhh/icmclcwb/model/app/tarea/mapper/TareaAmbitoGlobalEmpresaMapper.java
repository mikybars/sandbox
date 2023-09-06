package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalEmpresa;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TareaAmbitoGlobalEmpresaMapper {

  @Mapping(target = "tarea.id", source = "idTarea")
  public abstract TareaAmbitoGlobalEmpresa tareaAmbitoGlobalEmpresaDtoToTareaAmbitoGlobalEmpresa(
      TareaAmbitoGlobalEmpresaDto src);

  public abstract List<TareaAmbitoGlobalEmpresa> tareaAmbitoGlobalEmpresaDtoToTareaAmbitoGlobalEmpresa(
      List<TareaAmbitoGlobalEmpresaDto> src);

  @InheritInverseConfiguration
  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaAmbitoGlobalEmpresaDto tareaAmbitoGlobalEmpresaToTareaAmbitoGlobalEmpresaDto(
      TareaAmbitoGlobalEmpresa src);

  public abstract List<TareaAmbitoGlobalEmpresaDto> tareaAmbitoGlobalEmpresaToTareaAmbitoGlobalEmpresaDto(
      List<TareaAmbitoGlobalEmpresa> src);

}
