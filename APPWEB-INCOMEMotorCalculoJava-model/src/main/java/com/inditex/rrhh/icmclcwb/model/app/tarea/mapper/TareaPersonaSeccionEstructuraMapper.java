package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import org.mapstruct.*;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPersonaSeccionEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaSeccionEstructura;

@Mapper(imports = org.apache.commons.lang3.StringUtils.class)
@DecoratedWith(value = TareaPersonaSeccionEstructuraDecorator.class)
public abstract class TareaPersonaSeccionEstructuraMapper {
    
    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPersonaSeccionEstructuraDto tareaPersonaSeccionEstructuraToTareaPersonaSeccionEstructuraDto(
            TareaPersonaSeccionEstructura src);
    
    @InheritInverseConfiguration
    public abstract TareaPersonaSeccionEstructura tareaPersonaSeccionEstructuraDtoToTareaPersonaSeccionEstructura(
            TareaPersonaSeccionEstructuraDto src);

    public abstract List<TareaPersonaSeccionEstructuraDto> tareaPersonaSeccionEstructuraToTareaPersonaSeccionEstructuraDto(
            List<TareaPersonaSeccionEstructura> src);

    public abstract List<TareaPersonaSeccionEstructura> tareaPersonaSeccionEstructuraDtoToTareaPersonaSeccionEstructura(
            List<TareaPersonaSeccionEstructuraDto> src);

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
    public abstract TareaPersonaSeccionEstructuraDto comisionEmpleadoResultItemDtoToTareaPersonaSeccionEstructuraDto(
        final ComisionEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaPersonaSeccionEstructuraDto> listaPorcentajesResultItemDtoToTareaPersonaSeccionEstructuraDto(
        final List<ListaPorcentajesResultItemDto> src, final ComisionEmpleadoResultItemDto comisionEmpleado, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaPersonaSeccionEstructuraDto> comisionEmpleadoResultItemDtoToTareaPersonaSeccionEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
