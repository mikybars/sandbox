package com.inditex.rrhh.icmclcwb.model.app.mapper.poc;

import java.util.List;

import org.mapstruct.Mapper;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.poc.PocTienda;

@Mapper
public abstract class PocTiendaMapper {

	public abstract PocTiendaDto pocTiendaToPocTiendaDto(PocTienda src);

	public abstract List<PocTiendaDto> pocTiendaToPocTiendaDto(List<PocTienda> src);

}