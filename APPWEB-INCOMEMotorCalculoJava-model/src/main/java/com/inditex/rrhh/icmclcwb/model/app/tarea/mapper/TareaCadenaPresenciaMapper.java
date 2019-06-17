package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCadenaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaCadenaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaPresencia;
import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
@DecoratedWith(value = TareaCadenaPresenciaDecorator.class)
public abstract class TareaCadenaPresenciaMapper {

    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "tipoDato", ignore = true)
    @Mapping(target = "idSeccion", ignore = true)
    public abstract TareaCadenaPresencia presenciasTotalizadoResponseDtoToTareaCadenaPresencia(
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto);

    public List<TareaCadenaPresencia> presenciasTotalizadoResponseDtoToTareaCadenaPresencia(
        List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @AfterMapping
    void afterMapping(@MappingTarget TareaCadenaPresencia tareaCadenaPresencia,
        PtrPresenciaTotalizadoResultItemDto src, TareaDto tareaDto) {
        tareaCadenaPresencia.setTipoDato(new TipoDato());
        tareaCadenaPresencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES.getId());
        tareaCadenaPresencia.setActivo(Boolean.TRUE);
        tareaCadenaPresencia.setIdSeccion(AppConstants.SECCION_4.toString());
    }

    @Mapping(source = "tarea.id", target = "idTarea")
    @Mapping(source = "tipoDato.id", target = "idTipoDato")
    public abstract TareaCadenaPresenciaDto tareaCadenaPresenciaToTareaCadenaPresenciaDto(TareaCadenaPresencia src);

    public List<TareaCadenaPresenciaDto> tareaCadenaPresenciaToTareaCadenaPresenciaDto(
        List<TareaCadenaPresencia> src) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
}
