package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;

@Mapper
public abstract class TareaMapper {

    @Mapping(target = "idProgramacion", source = "programacion.id")
    public abstract TareaDto tareaToTareaDto(Tarea src);

    @InheritInverseConfiguration
    public abstract Tarea tareaDtoToTarea(TareaDto src);

    public abstract List<TareaDto> tareaToTareaDto(List<Tarea> src);

    public abstract List<Tarea> tareaDtoToTarea(List<TareaDto> src);

    @AfterMapping
    protected void controlProgramacion(TareaDto dto, @MappingTarget Tarea result) {
        if (dto.getIdProgramacion() == null) {
            result.setProgramacion(null);
        }
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "idProgramacion", source = "id")
    public abstract TareaDto programacionDtoToTareaDto(ProgramacionDto src);

    @Mapping(target = "id", ignore = true)
    public abstract TareaTiendaDto programacionTiendaDtoToTareaTiendaDto(ProgramacionTiendaDto src);

    @Mapping(target = "id", ignore = true)
    public abstract TareaEmpleadoDto programacionEmpleadoDtoToTareaEmpleadoDto(ProgramacionEmpleadoDto src);

    @Mapping(target = "fechaInicio", source = "fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "fechaFinPeriodo")
    @Mapping(target = "idOrigen", source = "idPaisOrigen")
    @Mapping(target = "idEmpresa", source = "idEmpresa")
    public abstract GenericFilterDto tareaDtoToGenericFilterDto(TareaDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaTotalizadoRequestDto tareaDtoToPtrVentaTotalizadoRequestDto(TareaDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaIndividualDetalleRequestDto tareaDtoToPtrVentaIndividualDetalleRequestDto(TareaDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaTotalTiendaSeccionRequestDto tareaDtoToPtrPresenciasTotalTiendaSeccionRequestDto(
            TareaDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaDetalleRequestDto tareaDtoToPtrPresenciasDetalleRequestDto(TareaDto src);
    
    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaDetalleComisionableRequestDto tareaDtoToPtrPresenciasDetalleComisionableRequestDto(TareaDto src);

}
