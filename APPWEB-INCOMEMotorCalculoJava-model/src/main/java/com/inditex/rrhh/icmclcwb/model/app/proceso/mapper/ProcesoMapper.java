package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.Proceso;

@Mapper
public abstract class ProcesoMapper {

    @Mapping(target = "idTrabajo", source = "trabajo.id")
    public abstract ProcesoDto procesoToProcesoDto(Proceso src);

    @InheritInverseConfiguration
    public abstract Proceso procesoDtoToProceso(ProcesoDto src);

    public abstract List<ProcesoDto> procesoToProcesoDto(List<Proceso> src);

    public abstract List<Proceso> procesoDtoToProceso(List<ProcesoDto> src);

//    @AfterMapping
//    protected void controlProgramacion(ProcesoDto dto, @MappingTarget Proceso result) {
//        if (dto.getIdProgramacion() == null) {
//            result.setProgramacion(null);
//        }
//    }

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "fechaCreacion", ignore = true)
//    @Mapping(target = "idProgramacion", source = "id")
//    public abstract ProcesoDto programacionDtoToProcesoDto(ProgramacionDto src);
//
//    @Mapping(target = "id", ignore = true)
//    public abstract ProcesoTiendaDto programacionTiendaDtoToProcesoTiendaDto(ProgramacionTiendaDto src);
//
//    @Mapping(target = "id", ignore = true)
//    public abstract ProcesoEmpleadoDto programacionEmpleadoDtoToProcesoEmpleadoDto(ProgramacionEmpleadoDto src);

    @Mapping(target = "fechaInicio", source = "fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "fechaFinPeriodo")
    @Mapping(target = "idOrigen", source = "idPaisOrigen")
    @Mapping(target = "idEmpresa", source = "idEmpresa")
    public abstract GenericFilterDto procesoDtoToGenericFilterDto(ProcesoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaTotalizadoRequestDto procesoDtoToPtrVentaTotalizadoRequestDto(ProcesoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaIndividualDetalleRequestDto procesoDtoToPtrVentaIndividualDetalleRequestDto(ProcesoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaTotalTiendaSeccionRequestDto procesoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(
            ProcesoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaDetalleRequestDto procesoDtoToPtrPresenciasDetalleRequestDto(ProcesoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaDetalleComisionableRequestDto procesoDtoToPtrPresenciasDetalleComisionableRequestDto(
            ProcesoDto src);

}
