package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionEstado;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(TareaLocalizacionEstadoDecorator.class)
public abstract class TareaLocalizacionEstadoMapper {

  @Mapping(target = "idTarea", source = "tarea.id")
  public abstract TareaLocalizacionEstadoDto tareaLocalizacionEstadoToTareaLocalizacionEstadoDto(
      TareaLocalizacionEstado src);

  public abstract List<TareaLocalizacionEstadoDto> tareaLocalizacionEstadoToTareaLocalizacionEstadoDto(
      List<TareaLocalizacionEstado> src);

  @InheritInverseConfiguration
  public abstract TareaLocalizacionEstado tareaLocalizacionEstadoDtoToTareaLocalizacionEstado(
      TareaLocalizacionEstadoDto src);

  public abstract List<TareaLocalizacionEstado> tareaLocalizacionEstadoDtoToTareaLocalizacionEstado(
      List<TareaLocalizacionEstadoDto> src);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "stdIdLegEnt", source = "src.idEmpresa")
  @Mapping(target = "stdIdWorkLocat", source = "src.idLugarTrabajo")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "icmIdEstado", source = "src.idEstado")
  @Mapping(target = "cclIdSeccion", source = "src.idSeccion")
  @Mapping(target = "idTarea", source = "srcTarea.id")
  @Mapping(target = "icmNumDias", source = "src.numDias")
  public abstract TareaLocalizacionEstadoDto estadoWlocResultItemDtoToTareaLocalizacionEstadoDto(
      EstadoWlocResultItemDto src, TareaDto srcTarea);

  public List<TareaLocalizacionEstadoDto> estadoWlocResultItemDtoToTareaLocalizacionEstadoDto(
      final List<EstadoWlocResultItemDto> src, final TareaDto srcTarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
