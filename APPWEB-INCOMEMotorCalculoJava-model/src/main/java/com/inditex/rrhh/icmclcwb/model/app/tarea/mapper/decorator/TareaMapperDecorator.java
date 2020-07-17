package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import org.apache.commons.collections.CollectionUtils;

public abstract class TareaMapperDecorator extends TareaMapper {

    @Autowired
    private TareaMapper delegate;

    @Override
    public TareaDto mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            final TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa, final TrabajoDto srcTrabajo) {
        final TareaDto tarea = this.delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
                srcTrabajoAmbitoEmpresa,
                srcTrabajo);
        final List<TareaAmbitoDto> ambito = new ArrayList<>();
        srcTrabajo.getOrigen()
            .forEach(item -> ambito.add(TareaAmbitoDto.builder()
                .cclIdOrigen(item.getCclIdOrigen())
                .build()));
        tarea.setAmbito(ambito);

        final List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
        srcTrabajo.getLocalizacion()
            .stream()
            .filter(item -> item.getStdIdLegEnt().equals(srcTrabajoAmbitoEmpresa.getStdIdLegEnt()))
            .collect(Collectors.toList())
            .forEach(item -> localizacion.add(TareaAmbitoLocalizacionDto.builder()
                .stdIdWorkLocat(item.getStdIdWorkLocat())
                .cclIdOrigen(item.getCclIdOrigen())
                .build()));
        tarea.setLocalizacion(localizacion);

        final List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
        srcTrabajo.getPersona()
            .stream()
            .filter(item -> item.getStdIdLegEnt().equals(srcTrabajoAmbitoEmpresa.getStdIdLegEnt()))
            .collect(Collectors.toList())
            .forEach(item -> persona.add(TareaAmbitoPersonaDto.builder()
                .cclIdPerson(item.getCclIdPerson())
                .stdOrHrPeriod(item.getStdOrHrPeriod())
                .cclIdOrigen(item.getCclIdOrigen())
                .build()));
        tarea.setPersona(persona);
        return tarea;
    }

    @Override
    public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            final List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, final TrabajoDto srcTrabajo) {
        final List<TareaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
            srcTrabajoAmbitoEmpresa.forEach(
                    item -> result.add(this.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(item, srcTrabajo)));
        }
        return result;
    }

    @Override
    public PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
            final TrabajoDto srcTrabajo, final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito,
            final RecolectarPropertiesDto srcRecolectarProperties, final List<IdCadenaDto> cadenas) {
        final PtrVentaOnlineEntregaDomicilioRequestDto ptrVentaOnlineEntregaDomicilioRequestDto = this.delegate
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                    srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
        ptrVentaOnlineEntregaDomicilioRequestDto.setCadena(cadenas.stream()
            .map(IdCadenaDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        return ptrVentaOnlineEntregaDomicilioRequestDto;
    }

    @Override
    public PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
            final TrabajoDto srcTrabajo, final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito,
            final RecolectarPropertiesDto srcRecolectarProperties, final List<IdCadenaDto> cadenas) {
        final PtrVentaTotalizadoRequestDto ptrVentaTotalizadoRequestDto = this.delegate
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                    srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
        ptrVentaTotalizadoRequestDto.setCadena(cadenas.stream()
            .map(IdCadenaDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        return ptrVentaTotalizadoRequestDto;
    }

    @Override
    public PtrVentaTotalizadoRequestDto mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
            final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito, final PeriodoDto periodo,
            final RecolectarPropertiesDto srcRecolectarProperties, final List<IdCadenaDto> cadenas) {
        final PtrVentaTotalizadoRequestDto ptrVentaTotalizadoRequestDto = this.delegate
            .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                    srcTarea, srcTareaAmbito, periodo, srcRecolectarProperties, cadenas);
        ptrVentaTotalizadoRequestDto.setCadena(cadenas.stream()
            .map(IdCadenaDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        return ptrVentaTotalizadoRequestDto;
    }

    @Override
    public PtrPresenciaEmpleadosTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
            final TrabajoDto srcTrabajo, final TareaDto srcTarea, final TareaAmbitoDto srcTareaAmbito,
            final List<IdLocalizacionLocalDto> srcLocalizaciones) {
        final PtrPresenciaEmpleadosTiendaRequestDto result = this.delegate
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(srcTrabajo, srcTarea,
                    srcTareaAmbito, srcLocalizaciones);
        if ((result != null) && (srcLocalizaciones != null)) {
            final List<Integer> localizaciones = srcLocalizaciones.stream()
                .map(IdLocalizacionLocalDto::getId)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
            result.setTienda(localizaciones);
        }
        return result;
    }

}
