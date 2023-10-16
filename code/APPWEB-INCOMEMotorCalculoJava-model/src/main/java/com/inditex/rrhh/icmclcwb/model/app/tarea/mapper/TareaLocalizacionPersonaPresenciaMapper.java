package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {TipoDato.class, TipoDatoEnum.class})
@DecoratedWith(TareaLocalizacionPersonaPresenciaDecorator.class)
public abstract class TareaLocalizacionPersonaPresenciaMapper {

  @Mapping(target = "id", source = "pk.id")
  @Mapping(target = "idTarea", source = "tarea.id")
  @Mapping(target = "idTipoHora", source = "codTipoHora")
  public abstract TareaLocalizacionPersonaPresenciaDto tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
      TareaLocalizacionPersonaPresencia src);

  public abstract List<TareaLocalizacionPersonaPresenciaDto> tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
      List<TareaLocalizacionPersonaPresencia> src);

  @InheritInverseConfiguration
  @Mapping(target = "cclIdCadena", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  public abstract TareaLocalizacionPersonaPresencia tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
      TareaLocalizacionPersonaPresenciaDto src);

  public abstract List<TareaLocalizacionPersonaPresencia> tareaLocalizacionPersonaPresenciaDtoToLocalizacionPersonaPresencia(
      List<TareaLocalizacionPersonaPresenciaDto> src);

  @Mapping(source = "src.idLugarTrabajoMtu", target = "cclIdCodOrigen")
  @Mapping(source = "src.idOrigen", target = "cclIdOrigen")
  @Mapping(source = "src.idEmpleadoLocal", target = "cclIdPerson")
  @Mapping(source = "src.idSeccion", target = "cclIdSeccion")
  @Mapping(source = "src.idEmpresa", target = "stdIdLegEnt")
  @Mapping(source = "src.idCadena", target = "cclIdCadena")
  @Mapping(source = "src.fecha", target = "fecha")
  @Mapping(source = "src.minutos", target = "minutos")
  @Mapping(source = "src.idTipoHora", target = "codTipoHora")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "tipoDato",
      expression = "java(TipoDato.builder().id(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId()).build())")
  @Mapping(target = "activo", expression = "java(Boolean.TRUE)")
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(source = "tareaDto.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaLocalizacionPersonaPresencia genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
      GenericEmpleadoResultItemDto src, TareaDto tareaDto);

  public List<TareaLocalizacionPersonaPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
      final List<GenericEmpleadoResultItemDto> src, final TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(source = "src.tienda", target = "cclIdCodOrigen")
  @Mapping(source = "src.origen", target = "cclIdOrigen")
  @Mapping(source = "src.persona", target = "cclIdPerson")
  @Mapping(source = "src.seccion", target = "cclIdSeccion")
  @Mapping(source = "src.empresa", target = "stdIdLegEnt")
  @Mapping(source = "src.cadena", target = "cclIdCadena")
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(source = "src.minutos", target = "minutos")
  @Mapping(source = "src.tipo", target = "codTipoHora")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "activo", expression = "java(Boolean.TRUE)")
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(target = "tipoDato", ignore = true)
  @Mapping(source = "tareaDto.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaLocalizacionPersonaPresencia presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
      PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto, final Integer idTipoDato);

  public List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
      final List<PtrPresenciaDetalleResultItemDto> src, final TareaDto tareaDto, final Integer idTipoDato) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
