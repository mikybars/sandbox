package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionTienda;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;

@Mapper
public abstract class TrabajoMapper {

    public abstract TrabajoDto trabajoToTrabajoDto(Trabajo src);

    public abstract Trabajo trabajoDtoToTrabajo(TrabajoDto src);

    @Mappings({ @Mapping(target = "id", ignore = true), @Mapping(target = "fechaCreacion", ignore = true) })
    public abstract TrabajoDto programacionDtoToTrabajoDto(ProgramacionDto src);

    @Mappings({ @Mapping(target = "id", ignore = true) })
    public abstract TrabajoTiendaDto programacionTiendaDtoToTrabajoTiendaDto(ProgramacionTiendaDto src);

    @Mappings({ @Mapping(target = "id", ignore = true) })
    public abstract TrabajoEmpleadoDto programacionEmpleadoDtoToTrabajoEmpleadoDto(ProgramacionEmpleadoDto src);

    @Mappings({ @Mapping(source = "fechaInicioPeriodo", target = "fechaInicio"),
            @Mapping(source = "fechaFinPeriodo", target = "fechaFin") })
    public abstract EmpleadosTiendaFilterDto trabajoDtotoEmpleadosTiendaFilterDto(TrabajoDto src);

    @Mappings({ @Mapping(source = "fechaInicioPeriodo", target = "fechaDesde", dateFormat = PtrConstants.PTR_DATE),
            @Mapping(source = "fechaFinPeriodo", target = "fechaHasta", dateFormat = PtrConstants.PTR_DATE),
            @Mapping(source = "idPaisOrigen", target = "pais"), @Mapping(target = "tienda", ignore = true) })
    public abstract GetVentaTotalizadoRequestDTO trabajoDtoToGetVentaTotalizadoRequestDTO(TrabajoDto src);

    @Mappings({ @Mapping(source = "fechaInicioPeriodo", target = "fechaDesde", dateFormat = PtrConstants.PTR_DATE),
            @Mapping(source = "fechaFinPeriodo", target = "fechaHasta", dateFormat = PtrConstants.PTR_DATE),
            @Mapping(source = "idPaisOrigen", target = "pais"), @Mapping(target = "tienda", ignore = true) })
    public abstract GetVentaIndividualDetalleRequestDTO trabajoDtoToGetVentaIndividualDetalleRequestDTO(TrabajoDto src);

    @Mappings({ @Mapping(source = "fechaInicioPeriodo", target = "fechaDesde", dateFormat = PtrConstants.PTR_DATE),
            @Mapping(source = "fechaFinPeriodo", target = "fechaHasta", dateFormat = PtrConstants.PTR_DATE),
    		@Mapping(source = "idPaisOrigen", target = "origen")})
    public abstract PresenciasTotalTiendaSeccionRequestDto trabajoDtoToPresenciasTotalTiendaSeccionRequestDto(
            TrabajoDto src);

    @Mappings({ @Mapping(source = "fechaInicioPeriodo", target = "fechaDesde", dateFormat = PtrConstants.PTR_DATE),
		@Mapping(source = "fechaFinPeriodo", target = "fechaHasta", dateFormat = PtrConstants.PTR_DATE),
		@Mapping(source = "idPaisOrigen", target = "origen")})
	public abstract PresenciasDetalleRequestDto trabajoDtoToPresenciasDetalleRequestDto(TrabajoDto src);
	
    protected List<String> mapEmpleados(List<TrabajoEmpleadoDto> trabajoEmpleadosDto) {
        List<String> empleados = new ArrayList<>();
        for (TrabajoEmpleadoDto empleado : trabajoEmpleadosDto) {
            empleados.add(empleado.getIdEmpleado());
        }
        return empleados;
    }

    protected List<String> mapTiendas(List<TrabajoTiendaDto> trabajoTiendasDto) {
        List<String> tiendas = new ArrayList<>();
        for (TrabajoTiendaDto tienda : trabajoTiendasDto) {
            tiendas.add(tienda.getIdTienda());
        }
        return tiendas;
    }

    @AfterMapping
    protected void afterProgramacionDtoToTrabajoDto(ProgramacionDto src, @MappingTarget TrabajoDto target) {
        if (src != null) {
            ProgramacionDto programacionId = new ProgramacionDto();
            programacionId.setId(src.getId());
            target.setProgramacion(programacionId);
            target.setFechaCreacion(LocalDateTime.now());
            target.setEstado(AppConstants.EstadoTrabajoEnum.PENDIENTE_DATOS.getDto());
        }
    }

    @BeforeMapping
    protected void beforeTrabajoDto(TrabajoDto src) {
        if (src != null && src.getId() != null) {
            TrabajoDto trabajoId = new TrabajoDto();
            trabajoId.setId(src.getId());
            if (CollectionUtils.isNotEmpty(src.getTiendas())) {
                src.getTiendas().stream().forEach(item -> item.setTrabajo(trabajoId));
            }
            if (CollectionUtils.isNotEmpty(src.getEmpleados())) {
                src.getEmpleados().stream().forEach(item -> item.setTrabajo(trabajoId));
            }
        }
    }

    @BeforeMapping
    protected void beforeTrabajoTienda(TrabajoTienda src) {
        if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
            Trabajo trabajoId = new Trabajo();
            trabajoId.setId(src.getTrabajo().getId());
            src.setTrabajo(trabajoId);
        }
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
    protected void beforeTrabajoTiendaDto(TrabajoTiendaDto src) {
        if (src != null && src.getTrabajo() != null && src.getTrabajo().getId() != null) {
            TrabajoDto trabajoId = new TrabajoDto();
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

    @BeforeMapping
    protected void beforeProgramacionDto(ProgramacionDto src) {
        if (src != null && src.getId() != null) {
            ProgramacionDto programacionId = new ProgramacionDto();
            programacionId.setId(src.getId());
            if (CollectionUtils.isNotEmpty(src.getTiendas())) {
                src.getTiendas().stream().forEach(item -> item.setProgramacion(programacionId));
            }
            if (CollectionUtils.isNotEmpty(src.getEmpleados())) {
                src.getEmpleados().stream().forEach(item -> item.setProgramacion(programacionId));
            }
        }
    }

    @BeforeMapping
    protected void beforeProgramacionTienda(ProgramacionTienda src) {
        if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
            Programacion programacionId = new Programacion();
            programacionId.setId(src.getProgramacion().getId());
            src.setProgramacion(programacionId);
        }
    }

    @BeforeMapping
    protected void beforeProgramacionEmpleado(ProgramacionEmpleado src) {
        if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
            Programacion programacionId = new Programacion();
            programacionId.setId(src.getProgramacion().getId());
            src.setProgramacion(programacionId);
        }
    }

    @BeforeMapping
    protected void beforeProgramacionTiendaDto(ProgramacionTiendaDto src) {
        if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
            ProgramacionDto programacionId = new ProgramacionDto();
            programacionId.setId(src.getProgramacion().getId());
            src.setProgramacion(programacionId);
        }
    }

    @BeforeMapping
    protected void beforeProgramacionEmpleadoDto(ProgramacionEmpleadoDto src) {
        if (src != null && src.getProgramacion() != null && src.getProgramacion().getId() != null) {
            ProgramacionDto programacionId = new ProgramacionDto();
            programacionId.setId(src.getProgramacion().getId());
            src.setProgramacion(programacionId);
        }
    }

}