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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPersonaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPersonaSeccionPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaSeccion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaSeccionPresencia;

@Mapper
@DecoratedWith(TareaLocalizacionPersonaSeccionPresenciaDecorator.class)
public abstract class TareaLocalizacionPersonaSeccionPresenciaMapper {

    @Mapping(target = "idTarea", source = "tarea.id")
    public abstract TareaLocalizacionPersonaSeccionPresenciaDto tareaLocalizacionPersonaSeccionPresenciaToTareaLocalizacionPersonaSeccionPresenciaDto(
            TareaLocalizacionPersonaSeccionPresencia src);

    @InheritInverseConfiguration
    public abstract TareaLocalizacionPersonaSeccionPresencia tareaLocalizacionPersonaSeccionPresenciaDtoToTareaLocalizacionPersonaSeccionPresencia(
            TareaLocalizacionPersonaSeccionPresenciaDto src);

    public abstract List<TareaLocalizacionPersonaSeccionPresenciaDto> tareaLocalizacionPersonaSeccionPresenciaToTareaLocalizacionPersonaSeccionPresenciaDto(
            List<TareaLocalizacionPersonaSeccionPresencia> src);

    public abstract List<TareaLocalizacionPersonaSeccionPresencia> tareaLocalizacionPersonaSeccionPresenciaDtoToLocalizacionPersonaSeccionPresencia(
            List<TareaLocalizacionPersonaSeccionPresenciaDto> src);
    
    @Mapping(source = "src.idLugarTrabajo", target = "idLocalizacion")
    @Mapping(source = "src.idOrigen", target = "idOrigen")
    @Mapping(source = "src.idEmpleado", target = "idPersona")
    @Mapping(source = "src.idSeccion", target = "idSeccion")
    @Mapping(source = "src.idEmpresa", target = "idEmpresa")
    @Mapping(source = "src.fecha", target = "fecha")
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "src.idTipoHora", target = "idTipoHora")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaSeccionPresencia genericEmpleadoResultItemDtoToTareaLocalizacionPersonaSeccionPresencia( 
            GenericEmpleadoResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersonaSeccionPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaSeccionPresencia(
            List<GenericEmpleadoResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @Mapping(source = "src.tienda", target = "idLocalizacion")
    @Mapping(source = "src.origen", target = "idOrigen")
    @Mapping(source = "src.persona", target = "idPersona")
    @Mapping(source = "src.seccion", target = "idSeccion")
    @Mapping(source = "src.empresa", target = "idEmpresa")
    @Mapping(source = "src.fecha", target = "fecha", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(source = "src.minutos", target = "minutos")
    @Mapping(source = "src.tipo", target = "idTipoHora")
    @Mapping(source = "tareaDto.id", target = "tarea.id")
    @Mapping(target = "id", ignore = true)
    public abstract TareaLocalizacionPersonaSeccionPresencia presenciasDetalleResponseDtoToTareaLocalizacionPersonaSeccionPresencia( 
            PtrPresenciaDetalleResultItemDto src, TareaDto tareaDto);

    public List<TareaLocalizacionPersonaSeccionPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaSeccionPresencia(
            List<PtrPresenciaDetalleResultItemDto> src, TareaDto tareaDto) {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaSeccionPresencia tareaLocalizacionPersonaSeccionPresencia,
            GenericEmpleadoResultItemDto src) {
        tareaLocalizacionPersonaSeccionPresencia.setActivo(Boolean.TRUE);
        tareaLocalizacionPersonaSeccionPresencia.setTipoDato(new TipoDato());
        tareaLocalizacionPersonaSeccionPresencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_INDIVIDUAL_MANUAL.getId());
    }    
    
    @AfterMapping
    void afterMapping(@MappingTarget TareaLocalizacionPersonaSeccionPresencia tareaLocalizacionPersonaSeccionPresencia,
            PtrPresenciaDetalleResultItemDto src) {

        for (PtrSeccionPresenciasGenericType item : src.getListaSeccion()) {
            if (AppConstants.SECCION_1.equals(item.getSeccion())) {
                tareaLocalizacionPersonaSeccionPresencia.setIdSeccion(AppConstants.SECCION_1.toString());
                tareaLocalizacionPersonaSeccionPresencia.setMinutos(item.getMinutos());
            } else if (AppConstants.SECCION_2.equals(item.getSeccion())) {
                tareaLocalizacionPersonaSeccionPresencia.setIdSeccion(AppConstants.SECCION_2.toString());
                tareaLocalizacionPersonaSeccionPresencia.setMinutos(item.getMinutos());
            } else if (AppConstants.SECCION_3.equals(item.getSeccion())) {
                tareaLocalizacionPersonaSeccionPresencia.setIdSeccion(AppConstants.SECCION_3.toString());
                tareaLocalizacionPersonaSeccionPresencia.setMinutos(item.getMinutos());
            }
        }

        tareaLocalizacionPersonaSeccionPresencia.setActivo(Boolean.TRUE);
        tareaLocalizacionPersonaSeccionPresencia.setTipoDato(new TipoDato());
        tareaLocalizacionPersonaSeccionPresencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_INDIVIDUAL.getId());
    }   
    
}
