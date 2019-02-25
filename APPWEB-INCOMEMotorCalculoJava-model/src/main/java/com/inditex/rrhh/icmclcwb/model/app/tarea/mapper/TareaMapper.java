package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

@Mapper
@DecoratedWith(value = TareaMapperDecorator.class)
public abstract class TareaMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract TareaDto tareaToTareaDto(Tarea src);

    @InheritInverseConfiguration
    public abstract Tarea tareaDtoToTarea(TareaDto src);

    public abstract List<TareaDto> tareaToTareaDto(List<Tarea> src);

    public abstract List<Tarea> tareaDtoToTarea(List<TareaDto> src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true /* expression = "java(java.time.LocalDateTime.now())" */)
    @Mapping(target = "fechaInicioTarea", ignore = true)
    @Mapping(target = "fechaFinTarea", ignore = true)
    @Mapping(target = "ambito", ignore = true)
    @Mapping(target = "persona", ignore = true)
    @Mapping(target = "localizacion", ignore = true)
    @Mapping(target = "idSociedad", source = "srcTrabajo.idSociedad")
    @Mapping(target = "idEmpresa", source = "srcTrabajoAmbitoEmpresa.idEmpresa")
    @Mapping(target = "idTrabajo", source = "srcTrabajo.id")
    public abstract TareaDto mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo);

    @AfterMapping
    protected void mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa,
            TrabajoDto srcTrabajo, @MappingTarget TareaDto tarea) {

        List<TareaAmbitoDto> ambito = new ArrayList<>();
        srcTrabajo.getOrigen().forEach(item -> ambito.add(TareaAmbitoDto.builder().idOrigen(item.getIdOrigen())
                .idCatalogo(/* TODO Cambiar por valor de Meta4 */item.getIdOrigen()).build()));
        tarea.setAmbito(ambito);

        List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
        srcTrabajo.getLocalizacion().stream()
                .filter(item -> item.getIdEmpresa().equals(srcTrabajoAmbitoEmpresa.getIdEmpresa()))
                .collect(Collectors.toList()).forEach(item -> localizacion.add(TareaAmbitoLocalizacionDto.builder()
                        .idLocalizacion(item.getIdLocalizacion()).idOrigen(item.getIdOrigen()).build()));
        tarea.setLocalizacion(localizacion);

        List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
        srcTrabajo.getPersona().stream()
                .filter(item -> item.getIdEmpresa().equals(srcTrabajoAmbitoEmpresa.getIdEmpresa()))
                .collect(Collectors.toList()).forEach(item -> persona.add(TareaAmbitoPersonaDto.builder()
                        .idPersona(item.getIdPersona()).idOrigen(item.getIdOrigen()).build()));
        tarea.setPersona(persona);
    }

    public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
