package com.inditex.rrhh.icmclcwb.model.app.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;

public abstract class TrabajoTipoHoraDecorator extends TrabajoTipoHoraMapper {

	@Autowired
	TrabajoTipoHoraMapper delegate;

	@Override
	public List<TrabajoTipoHora> ptrPresenciaTipoHoraResponsesDtoToTrabajoTipoHoraDto(
			List<PtrPresenciaTiposHorasResultItemDto> src, TrabajoDto trabajoDto) {
		List<TrabajoTipoHora> dtoList = new ArrayList<>();
		for (PtrPresenciaTiposHorasResultItemDto childDto : src) {
			// crear este metodo en mapper
			TrabajoTipoHora dto = delegate.ptrPresenciasMockTiposHorasResponseDtoToTrabajoTipoHoraDto(childDto,
					trabajoDto);
			dtoList.add(dto);
		}

		return dtoList;
	}
}
