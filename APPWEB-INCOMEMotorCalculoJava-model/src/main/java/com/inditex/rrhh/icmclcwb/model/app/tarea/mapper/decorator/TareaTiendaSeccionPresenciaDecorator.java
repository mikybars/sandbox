package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class TareaTiendaSeccionPresenciaDecorator extends TareaTiendaSeccionPresenciaMapper {

    @Autowired
    private TareaTiendaSeccionPresenciaMapper delegate;

    @Override
    public List<TareaTiendaSeccionPresencia> presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaTiendaSeccionPresencia> result = new ArrayList<>();
        src.forEach(x ->
            result.addAll(presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(x.getListaSeccion(), x, tareaDto)));
        return result;
    }

    @Override
    public List<TareaTiendaSeccionPresencia> presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(
        List<PtrSeccionPresenciasGenericType> listaSeccion, PtrPresenciaTotalizadoResultItemDto presenciaTotalizado, TareaDto tareaDto) {
        List<TareaTiendaSeccionPresencia> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(listaSeccion)) {
            listaSeccion.forEach(x -> {
                TareaTiendaSeccionPresencia presencia = delegate.presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(presenciaTotalizado, tareaDto);
                presencia.setIdSeccion(x.getSeccion().toString());
                presencia.setMinutos(x.getMinutos());
                result.add(presencia);
            });
        }
        return result;
    }
}
