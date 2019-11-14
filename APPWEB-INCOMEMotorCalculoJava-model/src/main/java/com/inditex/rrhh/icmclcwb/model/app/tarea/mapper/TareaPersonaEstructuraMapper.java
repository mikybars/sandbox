package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaEstructuraDesplazamientosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

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

    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
    @Mapping(target = "stdIdHr", source = "src.idEmpleado")
    @Mapping(target = "stdOrHrPeriod", source = "src.orEmpleado")
    @Mapping(target = "icmIdEstrComisionPadre", source = "src.idEstructura")
    @Mapping(target = "cclIdPerson", source = "src.idEmpleadoLocal")
    @Mapping(target = "valor", source = "src.importe")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "icmIdTpEstructura", source = "src.idTpEstructura")
    @Mapping(target = "icmIdEstrComisionBase", ignore = true)
    @Mapping(target = "icmIdEstrComision", ignore = true)
    @Mapping(target = "icmIdTpCalculo", ignore = true)
    @Mapping(target = "icmIdTpComision", ignore = true)
    @Mapping(target = "cclIdSeccionEfectiva", ignore = true)
    @Mapping(target = "cclIdSeccionEstructura", ignore = true)
    @Mapping(target = "desplazamiento", ignore = true)
    @Mapping(target = "desplazamientoBase", ignore = true)
    @Mapping(target = "estructuraDesplazamiento", ignore = true)
    @Mapping(target = "id", ignore = true)
    // TODO [COMUN] PARTICIONADO
    // @Mapping(source = "src.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
    public abstract TareaPersonaEstructuraDto estructurasComResultItemDtoToTareaPersonaEstructuraDto(
            final EstructurasComResultItemDto src, TareaDto tarea);

    public List<TareaPersonaEstructuraDto> listaCondicionesBaseResultItemDtoToTareaPersonaEstructuraDto(
            final EstructurasComResultItemDto comisionEmpleado, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaPersonaEstructuraDto> estructurasComResultItemDtoToTareaPersonaEstructuraDto(
            List<EstructurasComResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "idTipoOpcionCalculoEstructura", ignore = true)
    @Mapping(target = "idTipoOpcionCalculoEfectiva", ignore = true)
    @Mapping(target = "stdIdWorkLocatDestino", source = "idLugarTrabajoDestino")
    @Mapping(target = "cclIdCodOrigenDestino", source = "idLugarTrabajoDestinoMtu")
    @Mapping(target = "idMotivoDesplazamiento", source = "idMotivoDesplazamiento")
    @Mapping(target = "cclIdPuestoDestino", source = "idPuestoDestino")
    @Mapping(target = "cclIdSeccionDestino", source = "idSeccionDestino")
    @Mapping(target = "icmIdTpReqCom", source = "idTipoReqComision")
    @Mapping(target = "icmIdEstrComision", source = "idEstructuraDestino")
    @Mapping(target = "horasDestino", source = "horasDestino")
    @Mapping(target = "horasOrigen", source = "horasOrigen")
    @Mapping(target = "icmIdEstructuraAmbito", source = "idEstructuraAmbito")
    public abstract TareaPersonaEstructuraDesplazamientoDto listaCondicionesDestinoResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(
            ListaCondicionesDestinoResultItemDto src);

    public List<TareaPersonaEstructuraDesplazamientoDto> listaEstructuraDesplazamientosResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(
            List<ListaEstructuraDesplazamientosResultItemDto> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaPersonaEstructuraDesplazamientoDto> listaCondicionesDestinoResultItemDtoToTareaPersonaEstructuraDesplazamientoDto(
            EstructurasComResultItemDto src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Mapping(target = "tarea", ignore = true)
    @Mapping(target = "tipoOpcionCalculoEstructura", ignore = true)
    @Mapping(target = "tipoOpcionCalculoEfectiva", ignore = true)
    @Mapping(target = "fechaInicio", source = "src.estructuraDesplazamiento.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.estructuraDesplazamiento.fechaFin")
    @Mapping(target = "cclIdPuestoDestino", source = "src.estructuraDesplazamiento.cclIdPuestoDestino")
    @Mapping(target = "cclIdSeccionDestino", source = "src.estructuraDesplazamiento.cclIdSeccionDestino")
    @Mapping(target = "cclIdCodOrigenDestino", source = "src.estructuraDesplazamiento.cclIdCodOrigenDestino")
    @Mapping(target = "stdIdWorkLocatDestino", source = "src.estructuraDesplazamiento.stdIdWorkLocatDestino")
    @Mapping(target = "icmIdTpReqCom", source = "src.estructuraDesplazamiento.icmIdTpReqCom")
    @Mapping(target = "horasOrigen", source = "src.estructuraDesplazamiento.horasOrigen")
    @Mapping(target = "horasDestino", source = "src.estructuraDesplazamiento.horasDestino")
    @Mapping(target = "ordinalEstructura", source = "src.estructuraDesplazamiento.ordinalEstructura")
    @Mapping(target = "pk.id", ignore = true)
    // TODO [COMUN] PARTICIONADO
    // @Mapping(source = "src.fechaInicioPeriodo", target = "pk.fechaInicioPeriodo")
    public abstract TareaPersonaEstructuraDesplazamiento tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(
            TareaPersonaEstructuraDto src);

    public abstract List<TareaPersonaEstructuraDesplazamiento> tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(
            List<TareaPersonaEstructuraDto> src);

}
