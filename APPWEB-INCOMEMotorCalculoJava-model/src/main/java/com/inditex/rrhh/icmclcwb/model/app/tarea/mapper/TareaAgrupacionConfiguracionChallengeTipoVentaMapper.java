package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionConfiguracionChallengeTipoVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;

@Mapper
@DecoratedWith(TareaAgrupacionConfiguracionChallengeTipoVentaDecorator.class)
public abstract class TareaAgrupacionConfiguracionChallengeTipoVentaMapper {

    public abstract TareaAgrupacionConfiguracionChallengeTipoVenta tareaAgrupacionConfiguracionChallengeTipoVentaDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
            TareaAgrupacionConfiguracionChallengeTipoVentaDto src);

    public abstract List<TareaAgrupacionConfiguracionChallengeTipoVenta> tareaAgrupacionConfiguracionChallengeTipoVentaDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
            List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src);

    public abstract TareaAgrupacionConfiguracionChallengeTipoVentaDto tareaAgrupacionConfiguracionChallengeTipoVentaToTareaAgrupacionConfiguracionChallengeTipoVentaDto(
            TareaAgrupacionConfiguracionChallengeTipoVenta src);

    public abstract List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> tareaAgrupacionConfiguracionChallengeTipoVentaToTareaAgrupacionConfiguracionChallengeTipoVentaDto(
            List<TareaAgrupacionConfiguracionChallengeTipoVenta> src);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tarea.id", source = "tarea.id")
    @Mapping(target = "icmIdAgrupacionOnline", source = "src.idAgrupacion")
    @Mapping(target = "icmIdConceptoVenta", source = "src.idConceptoVenta")
    @Mapping(target = "fechaInicio", source = "src.fechaInicio")
    @Mapping(target = "fechaFin", source = "src.fechaFin")
    @Mapping(target = "cclIdOrigen", source = "src.idOrigen")
    public abstract TareaAgrupacionConfiguracionChallengeTipoVenta confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
            ConfChTpVentaResultItemDto src, TareaDto tarea);

    public List<TareaAgrupacionConfiguracionChallengeTipoVenta> confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
        List<ConfChTpVentaResultItemDto> src, TareaDto tarea) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
