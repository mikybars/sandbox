package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;

@Mapper
@DecoratedWith(TrabajoTiendaSeccionVentaDecorator.class)
public abstract class TrabajoTiendaSeccionVentaMapper {

	private static final String DATE_FORMAT = "yyyy-MM-dd"; 

	public abstract TrabajoTiendaSeccionVenta trabajoTiendaSeccionVentaDtoToTrabajoTiendaSeccionVenta(TrabajoTiendaSeccionVentaDto src);

	public abstract List<TrabajoTiendaSeccionVenta> trabajoTiendaSeccionVentasDtoToTrabajoTiendaSeccionVentas(List<TrabajoTiendaSeccionVentaDto> src);

	public abstract TrabajoTiendaSeccionVentaDto trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(TrabajoTiendaSeccionVenta src);

	public abstract List<TrabajoTiendaSeccionVentaDto> trabajoTiendaSeccionVentasToTrabajoTiendaSeccionVentasDto(List<TrabajoTiendaSeccionVenta> src);
	
	@Mappings({ @Mapping(source = "src.fecha", target = "fecha", dateFormat = DATE_FORMAT),
		@Mapping(source = "src.tienda", target = "idTienda"),
		@Mapping(source = "src.seccion", target = "idSeccion"),
		@Mapping(source = "src.importeSinIVA", target = "importe"),
		@Mapping(source = "trabajo.id", target = "trabajo.id"),
		@Mapping(target = "id", ignore = true)
	})
	public abstract TrabajoTiendaSeccionVenta getVentaTotalizadoResponseItemDTOToTrabajoTiendaSeccionVenta(GetVentaTotalizadoResponseItemDTO src, TrabajoDto trabajo);
	
	public List<TrabajoTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(List<GetVentaTotalizadoResponseItemDTO> src, TrabajoDto trabajoDto){
        throw new UnsupportedOperationException("Not implemented");
	}
}
