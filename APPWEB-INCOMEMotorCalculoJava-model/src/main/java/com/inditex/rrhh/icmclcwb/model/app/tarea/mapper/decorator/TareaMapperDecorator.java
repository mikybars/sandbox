package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;

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
        if (CollectionUtils.isNotEmpty(srcTareaAmbitoLocalizacion)) {
            List<GenericFilterParametersDto> resultItem = srcTareaAmbitoLocalizacion.stream()
                    .filter(item -> srcTareaAmbito.getIdOrigen().equals(item.getIdOrigen()))
                    .map(item -> GenericFilterParametersDto.builder().idLugarTrabajo(item.getIdLocalizacion()).build())
                    .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(resultItem)) {
                result.getItem().addAll(resultItem);
            } else {
                throw new IcmclcwbException(
                        new StringBuilder("Parametrizacion por localizacion sin localizaciones para el origen: ")
                                .append(srcTareaAmbito.getIdOrigen()).toString());
            }
        }
        if (CollectionUtils.isNotEmpty(srcTareaAmbitoPersona)) {
            List<GenericFilterParametersDto> resultItem = srcTareaAmbitoPersona.stream()
                    .filter(item -> srcTareaAmbito.getIdOrigen().equals(item.getIdOrigen()))
                    .map(item -> GenericFilterParametersDto.builder().idEmpleado(item.getIdPersona()).build())
                    .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(resultItem)) {
                result.getItem().addAll(resultItem);
            } else {
                throw new IcmclcwbException(
                        new StringBuilder("Parametrizacion por persona sin personas para el origen: ")
                                .append(srcTareaAmbito.getIdOrigen()).toString());
            }
        }
        return result;
    }

}
