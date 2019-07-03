package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

public abstract class TareaLocalizacionPresenciaDecorator extends TareaLocalizacionPresenciaMapper {

    @Autowired
    private TareaLocalizacionPresenciaMapper delegate;

    @Override
    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPresencia> result = new ArrayList<>();
        src.forEach(x ->
            result.addAll(presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(x.getListaSeccion(), x, tareaDto)));
        return result;
    }

    @Override
    public List<TareaLocalizacionPresencia> presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion, PtrPresenciaTotalizadoResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        List<TareaLocalizacionPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(listaSeccion)) {
            listaSeccion.forEach(x -> {
                TareaLocalizacionPresencia presencia = delegate.presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(presenciaTotalizado, tareaDto);
                presencia.setIdSeccion(x.getSeccion().toString());
                presencia.setMinutos(x.getMinutos());
                presencia.setTipoDato(new TipoDato());
                presencia.getTipoDato().setId(TipoDatoEnum.MINUTOS_TOTALES_SECCION.getId());
                result.add(presencia);
            });
        }
        return result;
    }
}
