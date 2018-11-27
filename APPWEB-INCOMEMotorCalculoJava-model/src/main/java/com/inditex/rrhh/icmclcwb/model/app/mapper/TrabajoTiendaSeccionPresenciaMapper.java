package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionPresencia;

@Mapper
public abstract class TrabajoTiendaSeccionPresenciaMapper {
	
	public abstract TrabajoTiendaSeccionPresencia trabajoTiendaSeccionPresenciaDtoToTrabajoTiendaSeccionPresencia(TrabajoTiendaSeccionPresenciaDto src);

	public abstract List<TrabajoTiendaSeccionPresencia> trabajoTiendaSeccionPresenciasDtoToTrabajoTiendaSeccionPresencias(List<TrabajoTiendaSeccionPresenciaDto> src);

	public abstract TrabajoTiendaSeccionPresenciaDto trabajoTiendaSeccionPresenciaToTrabajoTiendaSeccionPresenciaDto(TrabajoTiendaSeccionPresencia src);

	public abstract List<TrabajoTiendaSeccionPresenciaDto> trabajoTiendaSeccionPresenciasToTrabajoTiendaSeccionPresenciasDto(List<TrabajoTiendaSeccionPresencia> src);
	
	@Mappings({ @Mapping(source = "fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE),
		@Mapping(source = "tienda", target = "idTienda"),
		@Mapping(source = "seccion", target = "idSeccion"),
		@Mapping(source = "minutos", target = "minutos")
	})
	public abstract TrabajoTiendaSeccionPresencia presenciasTotalTiendaSeccionResponseDtoToTrabajoTiendaSeccionPresencia(PtrPresenciasTotalTiendaSeccionResultItemDto src);

	public abstract List<TrabajoTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtosDtoToTrabajoTiendaSeccionPresencias(List<PtrPresenciasTotalTiendaSeccionResultItemDto> src);

}
