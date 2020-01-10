package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraPoliticaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

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

    @InheritInverseConfiguration
    public abstract TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
            TareaPersonaEstructuraPolitica src);

    public List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
            List<TareaPersonaEstructuraPoliticaDto> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
            List<TareaPersonaEstructuraPolitica> src) {
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
    @Mapping(source = "src.fechaInicio", target = "pk.fechaInicioPeriodo")
    public abstract TareaPersonaEstructuraPolitica comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
            ComisionEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaPersonaEstructuraPolitica> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
            List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
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
    @Mapping(source = "tarea.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
    public abstract TareaPersonaEstructuraPolitica estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
            EstructurasPolResultItemDto src, TareaDto tarea);

    public List<TareaPersonaEstructuraPolitica> estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
            List<EstructurasPolResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public TareaPersonaEstructuraPolitica estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
            EstructurasPolResultItemDto src, ListaCondicionesPoliticasResultItemDto condiciones,
            ListaValoresPoliticasResultItemDto valores, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
