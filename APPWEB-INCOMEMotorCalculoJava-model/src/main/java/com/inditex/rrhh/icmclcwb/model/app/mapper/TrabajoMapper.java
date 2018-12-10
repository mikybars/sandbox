package com.inditex.rrhh.icmclcwb.model.app.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;

@Mapper
public abstract class TrabajoMapper {

	@Mapping(target = "idProgramacion", source = "programacion.id")
    public abstract TrabajoDto trabajoToTrabajoDto(Trabajo src);

	@InheritInverseConfiguration
    public abstract Trabajo trabajoDtoToTrabajo(TrabajoDto src);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    public abstract TrabajoDto programacionDtoToTrabajoDto(ProgramacionDto src);

    @Mapping(target = "id", ignore = true)
    public abstract TrabajoTiendaDto programacionTiendaDtoToTrabajoTiendaDto(ProgramacionTiendaDto src);

    @Mapping(target = "id", ignore = true)
    public abstract TrabajoEmpleadoDto programacionEmpleadoDtoToTrabajoEmpleadoDto(ProgramacionEmpleadoDto src);

    @Mapping(target = "fechaInicio", source = "fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "fechaFinPeriodo")
    public abstract EmpleadosTiendaFilterDto trabajoDtotoEmpleadosTiendaFilterDto(TrabajoDto src);

    @Mapping(target = "fechaInicio", source = "fechaInicioPeriodo")
    @Mapping(target = "fechaFin", source = "fechaFinPeriodo")
    @Mapping(target = "idOrigen", source = "idPaisOrigen")
    @Mapping(target = "idEmpresa", source = "idEmpresa")
    public abstract GenericFilterDto trabajoDtoToGenericFilterDto(TrabajoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaTotalizadoRequestDto trabajoDtoToPtrVentaTotalizadoRequestDto(TrabajoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "pais", source = "idPaisOrigen")
    @Mapping(target = "tienda", ignore = true)
    public abstract PtrVentaIndividualDetalleRequestDto trabajoDtoToPtrVentaIndividualDetalleRequestDto(TrabajoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaTotalTiendaSeccionRequestDto trabajoDtoToPtrPresenciasTotalTiendaSeccionRequestDto(
            TrabajoDto src);

    @Mapping(target = "fechaDesde", source = "fechaInicioPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "fechaHasta", source = "fechaFinPeriodo", dateFormat = PtrConstants.PTR_DATE)
    @Mapping(target = "origen", source = "idPaisOrigen")
    public abstract PtrPresenciaDetalleRequestDto trabajoDtoToPtrPresenciasDetalleRequestDto(TrabajoDto src);

}