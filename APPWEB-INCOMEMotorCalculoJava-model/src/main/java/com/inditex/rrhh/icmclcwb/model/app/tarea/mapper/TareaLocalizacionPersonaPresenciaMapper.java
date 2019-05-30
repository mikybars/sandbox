package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;


@Mapper
@DecoratedWith(TareaLocalizacionPersonaPresenciaDecorator.class)
public abstract class TareaLocalizacionPersonaPresenciaMapper {

    public abstract TareaLocalizacionPersonaPresencia tareaPersonaPresenciaDtoToTareaPersonaPresencia(
            TareaLocalizacionPersonaPresenciaDto src);

    public abstract List<TareaLocalizacionPersonaPresencia> tareaPersonaPresenciaDtoToTareaPersonaPresencia(
            List<TareaLocalizacionPersonaPresenciaDto> src);

    public abstract TareaLocalizacionPersonaPresenciaDto tareaPersonaPresenciaToTareaPersonaPresenciaDto(
            TareaLocalizacionPersonaPresencia src);

    public abstract List<TareaLocalizacionPersonaPresenciaDto> tareaPersonaPresenciaToTareaPersonaPresenciaDto(
            List<TareaLocalizacionPersonaPresencia> src);
    
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.persona", target = "idPersona")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaPresencia presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia( 
            PtrPresenciaDetalleResultItemDto src , TareaDto tareaDto);

    public List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaPresencia tareaLocalizacionPersonaPresencia,
            PtrPresenciaDetalleResultItemDto src) {
            tareaLocalizacionPersonaPresencia.setActivo(Boolean.TRUE);
            tareaLocalizacionPersonaPresencia.setTipoDato(new TipoDato());
            tareaLocalizacionPersonaPresencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_INDIVIDUAL_MANUAL.getId());
    }    
}
