package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionAgrupacionConfiguracionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
@DecoratedWith(TareaAgrupacionAgrupacionConfiguracionDecorator.class)
public abstract class TareaAgrupacionConfiguracionMapper {

    @Mapping(source = "src.fechaInicio", target = "fechaInicio")
    @Mapping(source = "src.fechaFin", target = "fechaFin")
    @Mapping(source = "src.idOrigen", target = "idOrigen")
    @Mapping(source = "src.porcentaje", target = "porcentajeInclusion")
    @Mapping(source = "src.idAgrupacion", target = "idAgrupacion")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoConceptoVenta", ignore = true)
    public abstract TareaAgrupacionConfiguracion getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
        ConfiguracionVentaOnlineResultItemDto src, TareaDto tareaDto);

    public List<TareaAgrupacionConfiguracion> getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
        List<ConfiguracionVentaOnlineResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    public void getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
        @MappingTarget TareaAgrupacionConfiguracion dest, ConfiguracionVentaOnlineResultItemDto src, TareaDto tareaDto) {
        dest.setTipoConceptoVenta(new TipoVenta());
        dest.getTipoConceptoVenta().setId(TipoVentaEnum.fromIdMeta4(src.getIdConcepto()).getId());
    }

    @Mapping(source = "src.tarea.id", target = "idTarea")
    @Mapping(target = "tipoConceptoVenta", ignore = true)
    public abstract TareaAgrupacionConfiguracionDto getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
        TareaAgrupacionConfiguracion src);

    @AfterMapping
    public void getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
        @MappingTarget TareaAgrupacionConfiguracionDto dest, TareaAgrupacionConfiguracion src) {
        dest.setTipoConceptoVenta(TipoVentaEnum.fromId(src.getTipoConceptoVenta().getId()));
    }

    public List<TareaAgrupacionConfiguracionDto> getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
        List<TareaAgrupacionConfiguracion> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
