package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.TiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Tienda;

import org.mapstruct.Mapper;

@Mapper
public interface TiendaMapper {

	TiendaDto TiendaToTiendaDto(Tienda src);

	Tienda TiendaDtoToTienda(TiendaDto src);

}