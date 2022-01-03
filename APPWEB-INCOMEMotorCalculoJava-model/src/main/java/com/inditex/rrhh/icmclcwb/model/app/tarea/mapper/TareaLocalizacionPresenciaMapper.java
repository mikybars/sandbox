package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {TipoDato.class, TipoDatoEnum.class})
@DecoratedWith(TareaLocalizacionPresenciaDecorator.class)
public abstract class TareaLocalizacionPresenciaMapper {

  @Mapping(source = "pk.id", target = "id")
  @Mapping(source = "tarea.id", target = "idTarea")
  @Mapping(source = "src.cclIdSeccion", target = "cclIdSeccion")
  @Mapping(source = "src.cclIdCadena", target = "cclIdCadena")
  @Mapping(source = "src.fecha", target = "fecha")
  @Mapping(source = "src.minutos", target = "minutos")
  public abstract TareaLocalizacionPresenciaDto tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
      TareaLocalizacionPresencia src);

  public abstract List<TareaLocalizacionPresenciaDto> tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
      List<TareaLocalizacionPresencia> src);

  @InheritInverseConfiguration
  public abstract TareaLocalizacionPresencia tareaLocalizacionPresenciaDtoToTareaLocalizacionPresencia(
      TareaLocalizacionPresenciaDto src);

  public abstract List<TareaLocalizacionPresencia> tareaLocalizacionPresenciaDtoToLocalizacionPresencia(
      List<TareaLocalizacionPresenciaDto> src);

  @Mapping(source = "src.idLugarTrabajoMtu", target = "cclIdCodOrigen")
  @Mapping(source = "src.idSeccion", target = "cclIdSeccion")
  @Mapping(source = "src.idCadena", target = "cclIdCadena")
  @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
  @Mapping(source = "src.minutos", target = "minutos")
  @Mapping(source = "tareaDto.id", target = "tarea.id")
  @Mapping(target = "tipoDato",
      expression = "java(TipoDato.builder().id(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_INCLUIDODENOMINADOR.getId()).build())")
  @Mapping(target = "activo", expression = "java(Boolean.TRUE)")
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(source = "tareaDto.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaLocalizacionPresencia presenciaManualLocalizacionResultItemDtoToTareaLocalizacionPresencia(
      PresenciaManualWlocResultItemDto src, TareaDto tareaDto);

  public List<TareaLocalizacionPresencia> presenciaManualLocalizacionResultItemDtoToTareaLocalizacionPresencia(
      final List<PresenciaManualWlocResultItemDto> src, final TareaDto tareaDto) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
