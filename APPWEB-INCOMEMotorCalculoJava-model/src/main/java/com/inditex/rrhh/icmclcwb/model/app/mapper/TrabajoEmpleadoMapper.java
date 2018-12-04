package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoEmpleadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;

@Mapper
@DecoratedWith(TrabajoEmpleadoDecorator.class)
public abstract class TrabajoEmpleadoMapper {

    public abstract TrabajoEmpleadoDto trabajoEmpleadoToTrabajoEmpleadoDto(TrabajoEmpleado src);

    public abstract TrabajoEmpleado trabajoEmpleadoDtoToTrabajoEmpleado(TrabajoEmpleadoDto src);

    public abstract List<TrabajoEmpleadoDto> trabajoEmpleadoToTrabajoEmpleadoDto(List<TrabajoEmpleado> src);

    public abstract List<TrabajoEmpleado> trabajoEmpleadoDtoToTrabajoEmpleado(List<TrabajoEmpleadoDto> src);

    @Mapping(target = "id", source = "srcTrabajoEmpleadoDto.id")
    @Mapping(target = "idEmpleado", source = "srcTrabajoEmpleadoDto.idEmpleado")
    @Mapping(target = "trabajo.id", source = "srcTrabajoDto.id")
    public abstract TrabajoEmpleado mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(
            TrabajoEmpleadoDto srcTrabajoEmpleadoDto, TrabajoDto srcTrabajoDto);

    public List<TrabajoEmpleado> mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(
            List<TrabajoEmpleadoDto> srcTrabajoEmpleadoDto, TrabajoDto srcTrabajoDto) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @BeforeMapping
    protected void beforeTrabajoEmpleado(TrabajoEmpleado src) {
        if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
            Trabajo trabajoId = new Trabajo();
            trabajoId.setId(src.getTrabajo().getId());
            src.setTrabajo(trabajoId);
        }
    }

    @BeforeMapping
    protected void beforeTrabajoEmpleadoDto(TrabajoEmpleadoDto src) {
        if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
            TrabajoDto trabajoId = new TrabajoDto();
            trabajoId.setId(src.getTrabajo().getId());
            src.setTrabajo(trabajoId);
        }
    }

}