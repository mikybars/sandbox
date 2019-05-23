package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ListaPorcentajesResultItemDto;
import org.mapstruct.*;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaEmpleadoSeccionEstructuraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoSeccionEstructura;

@Mapper(imports = org.apache.commons.lang3.StringUtils.class)
@DecoratedWith(value = TareaEmpleadoSeccionEstructuraDecorator.class)
public abstract class TareaEmpleadoSeccionEstructuraMapper {
    
    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaEmpleadoSeccionEstructuraDto tareaEmpleadoSeccionEstructuraToTareaEmpleadoSeccionEstructuraDto(
            TareaEmpleadoSeccionEstructura src);
    
    @InheritInverseConfiguration
    public abstract TareaEmpleadoSeccionEstructura tareaEmpleadoSeccionEstructuraDtoToTareaEmpleadoSeccionEstructura(
            TareaEmpleadoSeccionEstructuraDto src);

    public abstract List<TareaEmpleadoSeccionEstructuraDto> tareaEmpleadoSeccionEstructuraToTareaEmpleadoSeccionEstructuraDto(
            List<TareaEmpleadoSeccionEstructura> src);

    public abstract List<TareaEmpleadoSeccionEstructura> tareaEmpleadoSeccionEstructuraDtoToTareaEmpleadoSeccionEstructura(
            List<TareaEmpleadoSeccionEstructuraDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idTarea", source = "tarea.id")
    @Mapping(target = "idEmpleado", source = "src.idEmpleado")
    @Mapping(target = "orEmpleado", source = "src.orEmpleado")
    @Mapping(target = "idEmpleadoLocal", source = "src.idEmpleadoLocal")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "idOrigen", defaultValue = "38")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "idTipoCalculo", source = "src.idTipoCalculo")
    @Mapping(target = "idTipoComision", source = "src.idTipoComision")
    @Mapping(target = "valor", ignore = true)
    @Mapping(target = "idSeccionEfectiva", ignore = true)
    @Mapping(target = "idSeccionEstructura", ignore = true)
    public abstract TareaEmpleadoSeccionEstructuraDto comisionEmpleadoResultItemDtoToTareaEmpleadoSeccionEstructuraDto(
        final ComisionEmpleadoResultItemDto src, TareaDto tarea);

    public List<TareaEmpleadoSeccionEstructuraDto> listaPorcentajesResultItemDtoToTareaEmpleadoSeccionEstructuraDto(
        final List<ListaPorcentajesResultItemDto> src, final ComisionEmpleadoResultItemDto comisionEmpleado, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    public List<TareaEmpleadoSeccionEstructuraDto> comisionEmpleadoResultItemDtoToTareaEmpleadoSeccionEstructuraDto(
            List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
