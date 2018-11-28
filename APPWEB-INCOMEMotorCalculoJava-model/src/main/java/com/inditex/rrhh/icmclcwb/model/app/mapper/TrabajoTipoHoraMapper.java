package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoTipoHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTipoHoraDto;

@Mapper
@DecoratedWith(TrabajoTipoHoraDecorator.class)
public abstract class TrabajoTipoHoraMapper {

	public abstract TrabajoTipoHora trabajoTipoHoraDtoToTrabajoTipoHora(
			TrabajoTipoHoraDto src);

	public abstract List<TrabajoTipoHora> trabajoTipoHoraDtoListToTrabajoTrabajoTipoHoraList(
			List<TrabajoTipoHoraDto> src);

	public abstract List<TrabajoTipoHoraDto> trabajoTrabajoTipoHoraListTotrabajoTipoHoraDtoList(List<TrabajoTipoHora> src);

	public abstract TrabajoTipoHoraDto trabajoTipoHoraToTrabajoTipoHoraDto(TrabajoTipoHora src);
	 
	@Mappings({ @Mapping(source = "src.tipoHora", target = "idTipoHora"),
			@Mapping(expression = "java(!src.getExcluidoCalculo())", target = "comisionable"),
			@Mapping(source = "trabajoDto.id", target = "trabajo.id"), @Mapping(target = "id", ignore = true) })
	public abstract TrabajoTipoHora ptrPresenciasMockTiposHorasResponseDtoToTrabajoTipoHoraDto(
			PtrPresenciasMockTiposHorasResponseDto src, TrabajoDto trabajoDto);

	public List<TrabajoTipoHora> ptrPresenciasMockListTipoHoraResponsesDtoToTrabajoTipoHoraDto(
			List<PtrPresenciasMockTiposHorasResponseDto> src, TrabajoDto trabajoDto){
        throw new UnsupportedOperationException("Not implemented");
    }
}
