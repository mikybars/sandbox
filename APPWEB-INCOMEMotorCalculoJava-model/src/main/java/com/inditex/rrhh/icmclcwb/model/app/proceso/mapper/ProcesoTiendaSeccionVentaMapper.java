package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaSeccionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaSeccionVenta;

@Mapper
@DecoratedWith(ProcesoTiendaSeccionVentaDecorator.class)
public abstract class ProcesoTiendaSeccionVentaMapper {

    public abstract ProcesoTiendaSeccionVenta procesoTiendaSeccionVentaDtoToProcesoTiendaSeccionVenta(
            ProcesoTiendaSeccionVentaDto src);

    public abstract List<ProcesoTiendaSeccionVenta> procesoTiendaSeccionVentasDtoToProcesoTiendaSeccionVentas(
            List<ProcesoTiendaSeccionVentaDto> src);

    public abstract ProcesoTiendaSeccionVentaDto procesoTiendaSeccionVentaToProcesoTiendaSeccionVentaDto(
            ProcesoTiendaSeccionVenta src);

    public abstract List<ProcesoTiendaSeccionVentaDto> procesoTiendaSeccionVentasToProcesoTiendaSeccionVentasDto(
            List<ProcesoTiendaSeccionVenta> src);

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.tienda", target = "idTienda")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.importeSinIVA", target = "importe")
    @Mapping(source = "proceso.id", target = "proceso.id")
    @Mapping(target = "id", ignore = true)
    public abstract ProcesoTiendaSeccionVenta getVentaTotalizadoResponseItemDtoToProcesoTiendaSeccionVenta(
            PtrVentaTotalizadoResultItemDto src, ProcesoDto proceso);

    public List<ProcesoTiendaSeccionVenta> getVentaTotalizadoReponseItemsDtoToProcesoTiendaSeccionVentas(
            List<PtrVentaTotalizadoResultItemDto> src, ProcesoDto procesoDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
