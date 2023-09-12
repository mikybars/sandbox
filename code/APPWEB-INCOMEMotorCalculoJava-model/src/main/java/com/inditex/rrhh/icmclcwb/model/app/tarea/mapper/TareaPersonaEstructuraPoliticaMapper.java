package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraPoliticaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(value = TareaPersonaEstructuraPoliticaDecorator.class)
public abstract class TareaPersonaEstructuraPoliticaMapper {

  @Mapping(target = "tarea.id", source = "idTarea")
  @Mapping(target = "cclIdOrigen", source = "cclIdOrigen")
  @Mapping(target = "stdIdHr", source = "stdIdHr")
  @Mapping(target = "stdOrHrPeriod", source = "stdOrHrPeriod")
  @Mapping(target = "cclIdPerson", source = "cclIdPerson")
  @Mapping(target = "idEstructuraPolitica", source = "idEstructuraPolitica")
  @Mapping(target = "fechaInicio", source = "fechaInicio")
  @Mapping(target = "fechaFin", source = "fechaFin")
  @Mapping(target = "excluidoDenominador", source = "excluidoDenominador")
  @Mapping(target = "tipoUnidadTiempo.id", source = "idTipoUnidadTiempo")
  @Mapping(target = "numeroUnidades", source = "numeroUnidades")
  @Mapping(target = "valor", source = "valor")
  @Mapping(target = "importe", source = "importe")
  @Mapping(target = "numMesesCalcMedia", source = "numMesesCalcMedia")
  @Mapping(target = "numHoras", source = "numHoras")
  @Mapping(target = "idMotivoBaja", source = "idMotivoBaja")
  @Mapping(target = "tramo", source = "tramo")
  @Mapping(target = "tipoPolitica", ignore = true)
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(source = "src.fechaInicio", target = "pk.fechaInicioPeriodo")
  public abstract TareaPersonaEstructuraPolitica tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
      TareaPersonaEstructuraPoliticaDto src);

  public List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
      final List<TareaPersonaEstructuraPoliticaDto> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @InheritInverseConfiguration
  @Mapping(target = "id", source = "pk.id")
  @Mapping(target = "idTipoPolitica", source = "tipoPolitica.id")
  public abstract TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
      TareaPersonaEstructuraPolitica src);

  public List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
      final List<TareaPersonaEstructuraPolitica> src) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "stdIdHr", source = "src.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "src.idEmpleadoLocal")
  @Mapping(target = "idEstructuraPolitica", source = "src.idEstructura")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "excluidoDenominador", ignore = true)
  @Mapping(target = "tipoPolitica", ignore = true)
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(target = "tipoUnidadTiempo", ignore = true)
  @Mapping(target = "numeroUnidades", ignore = true)
  @Mapping(target = "valor", ignore = true)
  @Mapping(target = "tramo", ignore = true)
  @Mapping(target = "numMesesCalcMedia", ignore = true)
  @Mapping(source = "src.fechaInicio", target = "pk.fechaInicioPeriodo")
  public abstract TareaPersonaEstructuraPolitica comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
      ComisionEmpleadoResultItemDto src, TareaDto tarea);

  public List<TareaPersonaEstructuraPolitica> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
      final List<ComisionEmpleadoResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Mapping(target = "tarea.id", source = "tarea.id")
  @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
  @Mapping(target = "stdIdHr", source = "src.idEmpleado")
  @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
  @Mapping(target = "cclIdPerson", source = "src.idEmpleadoLocal")
  @Mapping(target = "idEstructuraPolitica", source = "src.idEstructura")
  @Mapping(target = "fechaInicio", source = "src.fechaInicio")
  @Mapping(target = "fechaFin", source = "src.fechaFin")
  @Mapping(target = "excluidoDenominador", ignore = true)
  @Mapping(target = "tipoPolitica", ignore = true)
  @Mapping(target = "pk.id", ignore = true)
  @Mapping(target = "tipoUnidadTiempo", ignore = true)
  @Mapping(target = "numeroUnidades", ignore = true)
  @Mapping(target = "valor", ignore = true)
  @Mapping(target = "tramo", ignore = true)
  @Mapping(target = "numMesesCalcMedia", ignore = true)
  @Mapping(target = "numHoras", ignore = true)
  @Mapping(target = "idMotivoBaja", ignore = true)
  @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
  public abstract TareaPersonaEstructuraPolitica estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
      EstructurasPolResultItemDto src, TareaDto tarea);

  public List<TareaPersonaEstructuraPolitica> estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
      final List<EstructurasPolResultItemDto> src, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  public TareaPersonaEstructuraPolitica estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
      final EstructurasPolResultItemDto src, final ListaCondicionesPoliticasResultItemDto condiciones,
      final ListaValoresPoliticasResultItemDto valores, final TareaDto tarea) {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

}
