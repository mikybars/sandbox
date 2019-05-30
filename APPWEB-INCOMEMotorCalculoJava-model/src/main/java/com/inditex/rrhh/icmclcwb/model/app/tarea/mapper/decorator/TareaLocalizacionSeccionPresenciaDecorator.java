package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionPresencia;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaLocalizacionSeccionPresenciaDecorator extends TareaLocalizacionSeccionPresenciaMapper {

    @Autowired
    private TareaLocalizacionSeccionPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionSeccionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionSeccionPresencia> result = new ArrayList<>();
        src.forEach(x ->
            result.addAll(presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(x.getListaSeccion(), x, tareaDto)));
        return result;
    }

    @Override
    public List<TareaLocalizacionSeccionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion, PtrPresenciaTotalizadoResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        List<TareaLocalizacionSeccionPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(listaSeccion)) {
            listaSeccion.forEach(x -> {
                TareaLocalizacionSeccionPresencia presencia = delegate.presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(presenciaTotalizado, tareaDto);
                presencia.setIdSeccion(x.getSeccion().toString());
                presencia.setMinutos(x.getMinutos());
                result.add(presencia);
            });
        }
        return result;
    }
}
