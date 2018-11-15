package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionEmpleadoPresencia;

@Mapper
public abstract class TrabajoTiendaSeccionEmpleadoPresenciaMapper {

	public abstract TrabajoTiendaSeccionEmpleadoPresencia trabajoTiendaSeccionEmpleadoPresenciaDtoToTrabajoTiendaSeccionEmpleadoPresencia(TrabajoTiendaSeccionEmpleadoPresenciaDto src);

	public abstract List<TrabajoTiendaSeccionEmpleadoPresencia> trabajoTiendaSeccionEmpleadoPresenciasDtoToTrabajoTiendaSeccionEmpleadoPresencias(List<TrabajoTiendaSeccionEmpleadoPresenciaDto> src);

	public abstract TrabajoTiendaSeccionEmpleadoPresenciaDto trabajoTiendaSeccionEmpleadoPresenciaToTrabajoTiendaSeccionEmpleadoPresenciaDto(TrabajoTiendaSeccionEmpleadoPresencia src);

	public abstract List<TrabajoTiendaSeccionEmpleadoPresenciaDto> trabajoTiendaSeccionEmpleadoPresenciasToTrabajoTiendaSeccionEmpleadoPresenciasDto(List<TrabajoTiendaSeccionEmpleadoPresencia> src);
	
	@Mappings({ @Mapping(source = "fecha", target = "fecha", dateFormat =  PtrConstants.PTR_DATE),
		@Mapping(source = "tienda", target = "idTienda"),
		@Mapping(source = "seccion", target = "idSeccion"),
		@Mapping(source = "tipo", target = "tipoHora.id"),
		@Mapping(source = "persona", target = "idEmpleado"),
		@Mapping(source = "minutos", target = "minutos"),
		@Mapping(target = "id", ignore = true)
	})
	public abstract TrabajoTiendaSeccionEmpleadoPresencia presenciasDetalleResponseDtoToTrabajoTiendaSeccionVenta(PresenciasDetalleResponseDto src);
	
	public abstract List<TrabajoTiendaSeccionEmpleadoPresencia> presenciasDetalleResponsesDtoToTrabajoTiendaSeccionVentas(List<PresenciasDetalleResponseDto> src);

}
