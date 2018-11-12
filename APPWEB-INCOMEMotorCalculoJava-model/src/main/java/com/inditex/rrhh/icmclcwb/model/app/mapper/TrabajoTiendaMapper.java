package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

@Mapper
public abstract class TrabajoTiendaMapper {

	public abstract TrabajoTiendaDto trabajoTiendaToTrabajoTiendaDto(TrabajoTienda src);

	public abstract TrabajoTienda trabajoTiendaDtoToTrabajoTienda(TrabajoTiendaDto src);
	
	public abstract List<TrabajoTiendaDto> trabajoTiendaToTrabajoTiendaDto(List<TrabajoTienda> src);

	public abstract List<TrabajoTienda> trabajoTiendaDtoToTrabajoTienda(List<TrabajoTiendaDto> src);

	@BeforeMapping
	protected void beforeTrabajoTienda(TrabajoTienda src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			Trabajo trabajoId = new Trabajo();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
		}
	}

	@BeforeMapping
	protected void beforeTrabajoTiendaDto(TrabajoTiendaDto src) {
		if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
			TrabajoDto trabajoId = new TrabajoDto();
			trabajoId.setId(src.getTrabajo().getId());
			src.setTrabajo(trabajoId);
		}
	}

}