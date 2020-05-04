package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TareaMapperDecorator extends TareaMapper {

    @Autowired
    private TareaMapper delegate;

    @Override
    public TareaDto mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            TrabajoAmbitoEmpresaDto srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        TareaDto tarea = delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(srcTrabajoAmbitoEmpresa,
                srcTrabajo);
        List<TareaAmbitoDto> ambito = new ArrayList<>();
        srcTrabajo.getOrigen()
            .forEach(item -> ambito.add(TareaAmbitoDto.builder()
                .cclIdOrigen(item.getCclIdOrigen())
                .build()));
        tarea.setAmbito(ambito);

        List<TareaAmbitoLocalizacionDto> localizacion = new ArrayList<>();
        srcTrabajo.getLocalizacion()
            .stream()
            .filter(item -> item.getStdIdLegEnt().equals(srcTrabajoAmbitoEmpresa.getStdIdLegEnt()))
            .collect(Collectors.toList())
            .forEach(item -> localizacion.add(TareaAmbitoLocalizacionDto.builder()
                .stdIdWorkLocat(item.getStdIdWorkLocat())
                .cclIdOrigen(item.getCclIdOrigen())
                .build()));
        tarea.setLocalizacion(localizacion);

        List<TareaAmbitoPersonaDto> persona = new ArrayList<>();
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
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        List<TareaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
            srcTrabajoAmbitoEmpresa.forEach(
                    item -> result.add(mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(item, srcTrabajo)));
        }
        return result;
    }

    @Override
    public PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas) {
        PtrVentaOnlineEntregaDomicilioRequestDto ptrVentaOnlineEntregaDomicilioRequestDto = delegate
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
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas) {
        PtrVentaTotalizadoRequestDto ptrVentaTotalizadoRequestDto = delegate
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
                    srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
        ptrVentaTotalizadoRequestDto.setCadena(cadenas.stream()
            .map(IdCadenaDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        return ptrVentaTotalizadoRequestDto;
    }

    @Override
    public PtrPresenciaEmpleadosTiendaRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            List<IdLocalizacionLocalDto> srcLocalizaciones) {
        PtrPresenciaEmpleadosTiendaRequestDto result = delegate
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrPresenciaEmpleadosTiendaRequestDto(srcTrabajo, srcTarea,
                    srcTareaAmbito, srcLocalizaciones);
        if (result != null && srcLocalizaciones != null) {
            List<Integer> localizaciones = srcLocalizaciones.stream()
                .map(IdLocalizacionLocalDto::getId)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
            result.setTienda(localizaciones);
        }
        return result;
    }

}
