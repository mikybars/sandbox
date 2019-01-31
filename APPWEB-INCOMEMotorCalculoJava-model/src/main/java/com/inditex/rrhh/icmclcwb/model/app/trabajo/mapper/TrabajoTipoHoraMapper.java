package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoTipoHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;

@Mapper
@DecoratedWith(TrabajoTipoHoraDecorator.class)
public abstract class TrabajoTipoHoraMapper {

    public abstract TrabajoTipoHora trabajoTipoHoraDtoToTrabajoTipoHora(TrabajoTipoHoraDto src);

    public abstract List<TrabajoTipoHora> trabajoTipoHoraDtoListToTrabajoTrabajoTipoHoraList(
            List<TrabajoTipoHoraDto> src);

    public abstract List<TrabajoTipoHoraDto> trabajoTrabajoTipoHoraListTotrabajoTipoHoraDtoList(
            List<TrabajoTipoHora> src);

    public abstract TrabajoTipoHoraDto trabajoTipoHoraToTrabajoTipoHoraDto(TrabajoTipoHora src);

    @Mapping(source = "src.tipoHora", target = "idTipoHora")
    @Mapping(expression = "java(!src.getExcluidoCalculo())", target = "comisionable")
    @Mapping(source = "trabajoDto.id", target = "trabajo.id")
    @Mapping(target = "id", ignore = true)
    public abstract TrabajoTipoHora ptrPresenciasMockTiposHorasResponseDtoToTrabajoTipoHoraDto(
            PtrPresenciaTiposHorasResultItemDto src, TrabajoDto trabajoDto);

    public List<TrabajoTipoHora> ptrPresenciaTipoHoraResponsesDtoToTrabajoTipoHoraDto(
            List<PtrPresenciaTiposHorasResultItemDto> src, TrabajoDto trabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
