package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTipoHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTipoHora;

@Mapper
@DecoratedWith(ProcesoTipoHoraDecorator.class)
public abstract class ProcesoTipoHoraMapper {

    public abstract ProcesoTipoHora procesoTipoHoraDtoToProcesoTipoHora(ProcesoTipoHoraDto src);

    public abstract List<ProcesoTipoHora> procesoTipoHoraDtoListToProcesoProcesoTipoHoraList(
            List<ProcesoTipoHoraDto> src);

    public abstract List<ProcesoTipoHoraDto> procesoProcesoTipoHoraListToprocesoTipoHoraDtoList(
            List<ProcesoTipoHora> src);

    public abstract ProcesoTipoHoraDto procesoTipoHoraToProcesoTipoHoraDto(ProcesoTipoHora src);

    @Mapping(source = "src.tipoHora", target = "idTipoHora")
    @Mapping(expression = "java(!src.getExcluidoCalculo())", target = "comisionable")
    @Mapping(source = "procesoDto.id", target = "proceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoTipoHora ptrPresenciasMockTiposHorasResponseDtoToProcesoTipoHoraDto(
            PtrPresenciaTiposHorasResultItemDto src, ProcesoDto procesoDto);

    public List<ProcesoTipoHora> ptrPresenciaTipoHoraResponsesDtoToProcesoTipoHoraDto(
            List<PtrPresenciaTiposHorasResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
