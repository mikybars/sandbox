package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaEstructuraDesplazamientosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(imports = org.apache.commons.lang3.StringUtils.class)
@DecoratedWith(value = TareaPersonaEstructuraDecorator.class)
public abstract class TareaPersonaEstructuraMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaEstructuraDto tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            TareaPersonaEstructura src);

    @InheritInverseConfiguration
    @Mapping(target = "tarea", ignore = true)
    public abstract TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
            TareaPersonaEstructuraDto src);

    public abstract List<TareaPersonaEstructuraDto> tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            List<TareaPersonaEstructura> src);

    public List<TareaPersonaEstructura> tareaPersonaEstructuraDtoToTareaPersonaEstructura(
            List<TareaPersonaEstructuraDto> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "stdIdHr", source = "src.idEmpleado")
    @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
    @Mapping(target = "cclIdPerson", source = "src.idEmpleadoLocal")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "icmIdTpCalculo", source = "src.idTipoCalculo")
    @Mapping(target = "icmIdTpComision", source = "src.idTipoComision")
    @Mapping(target = "icmIdEstrComision", source = "src.idEstructura")
    @Mapping(target = "valor", ignore = true)
    @Mapping(target = "cclIdSeccionEfectiva", ignore = true)
    @Mapping(target = "cclIdSeccionEstructura", ignore = true)
    @Mapping(target = "desplazamiento", ignore = true)
    @Mapping(target = "estructuraDesplazamiento", ignore = true)
    public abstract TareaPersonaEstructuraDto comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            final ComisionEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaPersonaEstructuraDto> listaPorcentajesResultItemDtoToTareaPersonaEstructuraDto(
            final List<ListaPorcentajesResultItemDto> src, final ComisionEmpleadoResultItemDto comisionEmpleado,
            TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaPersonaEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "idTipoOpcionCalculoEstructura", ignore = true)
    @Mapping(target = "idTipoOpcionCalculoEfectiva", ignore = true)
    @Mapping(target = "horasDestino", ignore = true)
    @Mapping(target = "horasOrigen", ignore = true)
    @Mapping(target = "stdIdWorkLocatDestino", source = "idLugarTrabajoDestino")
    @Mapping(target = "cclIdCodOrigenDestino", source = "idLugarTrabajoDestinoMtu")
    @Mapping(target = "cclIdPuestoDestino", source = "idPuestoDestino")
    @Mapping(target = "cclIdSeccionDestino", source = "idSeccionDestino")
    @Mapping(target = "icmIdTpCalculo", source = "idTipoCalculo")
    public abstract TareaPersonaEstructuraDesplazamientoDto listaEstructuraDesplazamientosResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(
        ListaEstructuraDesplazamientosResultItemDto src);

    public List<TareaPersonaEstructuraDesplazamientoDto> listaEstructuraDesplazamientosResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(
        List<ListaEstructuraDesplazamientosResultItemDto> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea", ignore = true)
    @Mapping(target = "tipoOpcionCalculoEstructura", ignore = true)
    @Mapping(target = "tipoOpcionCalculoEfectiva", ignore = true)
    @Mapping(target = "icmIdTpCalculo", source = "src.estructuraDesplazamiento.icmIdTpCalculo")
    @Mapping(target = "fechaInicio", source = "src.estructuraDesplazamiento.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.estructuraDesplazamiento.fechaFin")
    @Mapping(target = "cclIdPuestoDestino", source = "src.estructuraDesplazamiento.cclIdPuestoDestino")
    @Mapping(target = "cclIdSeccionDestino", source = "src.estructuraDesplazamiento.cclIdSeccionDestino")
    @Mapping(target = "cclIdCodOrigenDestino", source = "src.estructuraDesplazamiento.cclIdCodOrigenDestino")
    @Mapping(target = "stdIdWorkLocatDestino", source = "src.estructuraDesplazamiento.stdIdWorkLocatDestino")
    @Mapping(target = "valor", source = "src.estructuraDesplazamiento.valor")
    @Mapping(target = "cclIdSeccionEfectiva", source = "src.estructuraDesplazamiento.cclIdSeccionEfectiva")
    @Mapping(target = "cclIdSeccionEstructura", source = "src.estructuraDesplazamiento.cclIdSeccionEstructura")
    @Mapping(target = "horasOrigen", source = "src.estructuraDesplazamiento.horasOrigen")
    @Mapping(target = "horasDestino", source = "src.estructuraDesplazamiento.horasDestino")
    public abstract TareaPersonaEstructuraDesplazamiento tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(
        TareaPersonaEstructuraDto src);

    public abstract List<TareaPersonaEstructuraDesplazamiento> tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(
        List<TareaPersonaEstructuraDto> src);

}
