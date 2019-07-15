package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaPresenciaDecorator.class)
public abstract class TareaLocalizacionPersonaPresenciaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionPersonaPresenciaDto tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
            TareaLocalizacionPersonaPresencia src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionPersonaPresencia tareaLocalizacionPersonaPresenciaDtoToTareaLocalizacionPersonaPresencia(
            TareaLocalizacionPersonaPresenciaDto src);

    public abstract List<TareaLocalizacionPersonaPresenciaDto> tareaLocalizacionPersonaPresenciaToTareaLocalizacionPersonaPresenciaDto(
            List<TareaLocalizacionPersonaPresencia> src);

    public abstract List<TareaLocalizacionPersonaPresencia> tareaLocalizacionPersonaPresenciaDtoToLocalizacionPersonaPresencia(
            List<TareaLocalizacionPersonaPresenciaDto> src);
    
    @Mapping(source = "src.idLugarTrabajoMtu", target = "idLocalizacion")
    @Mapping(source = "src.idOrigen", target = "idOrigen")
    @Mapping(source = "src.idEmpleadoLocal", target = "idPersona")
    @Mapping(source = "src.idSeccion", target = "idSeccion")
    @Mapping(source = "src.idEmpresa", target = "idEmpresa")
    @Mapping(source = "src.idCadena", target = "idCadena")
    @Mapping(source = "src.fecha", target = "fecha")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "src.idTipoHora", target = "idTipoHora")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaPresencia genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia( 
            GenericEmpleadoResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersonaPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.persona", target = "idPersona")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "src.cadena", target = "idCadena")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.DATE_FORMAT)
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaPresencia presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia( 
            PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaPresencia tareaLocalizacionPersonaPresencia,
            GenericEmpleadoResultItemDto src) {
        tareaLocalizacionPersonaPresencia.setActivo(Boolean.TRUE);
        tareaLocalizacionPersonaPresencia.setTipoDato(new TipoDato());
        tareaLocalizacionPersonaPresencia.getTipoDato().setId(TipoDatoEnum.PRESENCIA_MANUAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());
    }    
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaPresencia tareaLocalizacionPersonaPresencia,
            PtrPresenciaDetalleResultItemDto src) {
        tareaLocalizacionPersonaPresencia.setActivo(Boolean.TRUE);
    }   
    
}
