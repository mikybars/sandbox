package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTipoHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

@Mapper
@DecoratedWith(TareaTipoHoraDecorator.class)
public abstract class TareaTipoHoraMapper {

    public abstract TareaTipoHora tareaTipoHoraDtoToTareaTipoHora(TareaTipoHoraDto src);

    public abstract List<TareaTipoHora> tareaTipoHoraDtoListToTareaTareaTipoHoraList(
            List<TareaTipoHoraDto> src);

    public abstract List<TareaTipoHoraDto> tareaTareaTipoHoraListTotareaTipoHoraDtoList(
            List<TareaTipoHora> src);

    public abstract TareaTipoHoraDto tareaTipoHoraToTareaTipoHoraDto(TareaTipoHora src);

    @Mapping(source = "src.tipoHora", target = "idTipoHora")
    @Mapping(expression = "java(!src.getExcluidoCalculo())", target = "comisionable")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaTipoHora ptrPresenciasMockTiposHorasResponseDtoToTareaTipoHoraDto(
            PtrPresenciaTiposHorasResultItemDto src, TareaDto tareaDto);

    public List<TareaTipoHora> ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(
            List<PtrPresenciaTiposHorasResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
