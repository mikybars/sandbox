package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
@DecoratedWith(value = TareaAgrupacionPresenciaDecorator.class)
public abstract class TareaAgrupacionPresenciaMapper {

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(target = "idAgrupacion", ignore = true)
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipoDato", ignore = true)
    @Mapping(target = "idSeccion", ignore = true)
    public abstract TareaAgrupacionPresencia presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);

    public List<TareaAgrupacionPresencia> presenciasTotalizadoResponseDtoToTareaAgrupacionPresencia(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto, List<TareaAgrupacionCadenasDto> agrupaciones) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaAgrupacionPresencia tareaCadenaPresencia,
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto) {
        tareaCadenaPresencia.setTipoDato(new TipoDato());
        tareaCadenaPresencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES.getId());
        tareaCadenaPresencia.setActivo(Boolean.TRUE);
        tareaCadenaPresencia.setIdSeccion(AppConstants.SECCION_4.toString());
    }
}
