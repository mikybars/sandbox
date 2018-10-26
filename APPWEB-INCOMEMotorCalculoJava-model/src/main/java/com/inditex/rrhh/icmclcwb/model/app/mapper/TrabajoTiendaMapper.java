package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;
import org.mapstruct.Mapper;

@Mapper
public interface TrabajoTiendaMapper {

	TrabajoTiendaDto trabajoTiendaToTrabajoTiendaDto(TrabajoTienda src);

	TrabajoTienda trabajoTiendaDtoToTrabajoTienda(TrabajoTiendaDto src);

}