package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
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
    public List<TareaDto> mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(
            List<TrabajoAmbitoEmpresaDto> srcTrabajoAmbitoEmpresa, TrabajoDto srcTrabajo) {
        List<TareaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(srcTrabajoAmbitoEmpresa)) {
            srcTrabajoAmbitoEmpresa.forEach(
                    item -> result.add(delegate.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(item, srcTrabajo)));
        }
        return result;
    }

    @Override
    public GenericFilterDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
            TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito,
            List<TareaAmbitoLocalizacionDto> srcTareaAmbitoLocalizacion,
            List<TareaAmbitoPersonaDto> srcTareaAmbitoPersona) {
        GenericFilterDto result = delegate
                .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndTareaAmbitoLocalizacionDtoAndTareaAmbitoPersonaDtoToGenericFilterDto(
                        srcTrabajo, srcTarea, srcTareaAmbito, srcTareaAmbitoLocalizacion, srcTareaAmbitoPersona);
        if (TipoAmbitoEnum.LOCALIZACION.getId().equals(srcTrabajo.getTipoAmbito().getId())) {
            if (CollectionUtils.isNotEmpty(srcTareaAmbitoLocalizacion)) {
                List<GenericFilterParametersDto> resultItem = srcTareaAmbitoLocalizacion.stream()
                        .filter(item -> srcTareaAmbito.getCclIdOrigen().equals(item.getCclIdOrigen()))
                        .map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item.getStdIdWorkLocat())
                                .build())
                        .collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(resultItem)) {
                    result.getItem().addAll(resultItem);
                } else {
                    throw new IcmclcwbException(new StringBuilder(
                            "Parametrizacion por tipo ambito localizacion sin localizaciones para el origen: ")
                                    .append(srcTareaAmbito.getCclIdOrigen()).toString());
                }
            } else {
                throw new IcmclcwbException("Parametrizacion por tipo ambito localizacion sin localizaciones");
            }
        }
        if (TipoAmbitoEnum.PERSONA.getId().equals(srcTrabajo.getTipoAmbito().getId())) {
            if (CollectionUtils.isNotEmpty(srcTareaAmbitoPersona)) {
                List<GenericFilterParametersDto> resultItem = srcTareaAmbitoPersona.stream()
                        .filter(item -> srcTareaAmbito.getCclIdOrigen().equals(item.getCclIdOrigen()))
                        .map(item -> GenericFilterParametersDto.builder().idEmpleado(item.getCclIdPerson()).build())
                        .collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(resultItem)) {
                    result.getItem().addAll(resultItem);
                } else {
                    throw new IcmclcwbException(
                            new StringBuilder("Parametrizacion por persona sin personas para el origen: ")
                                    .append(srcTareaAmbito.getCclIdOrigen()).toString());
                }
            } else {
                throw new IcmclcwbException("Parametrizacion por tipo ambito persona sin personas");
            }
        }
        return result;
    }

    @Override
    public PtrVentaOnlineEntregaDomicilioRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas) {
        PtrVentaOnlineEntregaDomicilioRequestDto ptrVentaOnlineEntregaDomicilioRequestDto =
            delegate.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoAndIdCadenaDtoToPtrVentaOnlineEntregaDomicilioRequestDto(
                srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
        ptrVentaOnlineEntregaDomicilioRequestDto.setCadena(cadenas.stream().map(IdCadenaDto::getId)
            .map(Integer::valueOf).collect(Collectors.toList()));
        return ptrVentaOnlineEntregaDomicilioRequestDto;
    }

    @Override
    public PtrVentaTotalizadoRequestDto mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(TrabajoDto srcTrabajo, TareaDto srcTarea, TareaAmbitoDto srcTareaAmbito, RecolectarPropertiesDto srcRecolectarProperties, List<IdCadenaDto> cadenas) {
        PtrVentaTotalizadoRequestDto ptrVentaTotalizadoRequestDto =
            delegate.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdCadenaDtoToPtrVentaTotalizadoRequestDto(
            srcTrabajo, srcTarea, srcTareaAmbito, srcRecolectarProperties, cadenas);
        ptrVentaTotalizadoRequestDto.setCadena(cadenas.stream().map(IdCadenaDto::getId)
            .map(Integer::valueOf).collect(Collectors.toList()));
        return ptrVentaTotalizadoRequestDto;
    }
}
