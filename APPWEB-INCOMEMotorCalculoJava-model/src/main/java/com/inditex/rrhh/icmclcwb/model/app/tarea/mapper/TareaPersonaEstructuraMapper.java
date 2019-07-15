package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import org.mapstruct.*;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

@Mapper(imports = org.apache.commons.lang3.StringUtils.class)
@DecoratedWith(value = TareaPersonaEstructuraDecorator.class)
public abstract class TareaPersonaEstructuraMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaEstructuraDto tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            TareaPersonaEstructura src);

    @InheritInverseConfiguration
    public abstract TareaPersonaEstructura tareaPersonaEstructuraDtoToTareaPersonaEstructura(
            TareaPersonaEstructuraDto src);

    public abstract List<TareaPersonaEstructuraDto> tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            List<TareaPersonaEstructura> src);

    public abstract List<TareaPersonaEstructura> tareaPersonaEstructuraDtoToTareaPersonaEstructura(
            List<TareaPersonaEstructuraDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "idPersona", source = "src.idEmpleado")
    @Mapping(target = "orPersona", source = "src.orEmpleado")
    @Mapping(target = "idPersonaLocal", source = "src.idEmpleadoLocal")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "idOrigen", defaultValue = "38")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "idTipoCalculo", source = "src.idTipoCalculo")
    @Mapping(target = "idTipoComision", source = "src.idTipoComision")
    @Mapping(target = "valor", ignore = true)
    @Mapping(target = "idSeccionEfectiva", ignore = true)
    @Mapping(target = "idSeccionEstructura", ignore = true)
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

}
