package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaPeriodoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPeriodo;

@Mapper
@DecoratedWith(TareaPeriodoDecorator.class)
public abstract class TareaPeriodoMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaPeriodoDto tareaPeriodoToTareaPeriodoDto(
            TareaPeriodo src);

    @InheritInverseConfiguration
    public abstract TareaPeriodo tareaPeriodoDtoToTareaPeriodo(
            TareaPeriodoDto src);

    public abstract List<TareaPeriodoDto> tareaPeriodoToTareaPeriodoDto(
            List<TareaPeriodo> src);

    public abstract List<TareaPeriodo> tareaPeriodoDtoToTareaPeriodo(
            List<TareaPeriodoDto> src);
    
    @Mapping(source = "src.idPeriodo", target = "idPeriodo")
    @Mapping(source = "src.fechaInicio", target = "fechaInicio")
    @Mapping(source = "src.fechaFin", target = "fechaFin")
    @Mapping(expression = "java(src.getNuevo().equals(\"1\"))", target = "nuevo")
    @Mapping(expression = "java(src.getBorrado().equals(\"1\"))", target = "borrado")
    @Mapping(expression = "java(src.getModificado().equals(\"1\"))", target = "modificado")
    @Mapping(expression = "java(src.getActivo().equals(\"1\"))", target = "activo")
    @Mapping(expression = "java(src.getAbierto().equals(\"1\"))", target = "abierto")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaPeriodo periodosResultItemDtoToTareaPeriodo( 
            PeriodosResultItemDto src, TareaDto tareaDto);

    public List<TareaPeriodo> periodosResultItemDtoToTareaPeriodo(
            List<PeriodosResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
