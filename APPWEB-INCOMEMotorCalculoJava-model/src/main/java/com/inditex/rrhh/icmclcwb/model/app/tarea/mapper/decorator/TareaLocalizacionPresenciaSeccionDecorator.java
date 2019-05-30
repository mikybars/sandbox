package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresenciaSeccion;

public abstract class TareaLocalizacionPresenciaSeccionDecorator extends TareaLocalizacionPresenciaSeccionMapper {

    @Autowired
    private TareaLocalizacionPresenciaSeccionMapper delegate;
    
    @Override
    public List<TareaLocalizacionPresenciaSeccion> presenciasTotalLocalizacionSeccionResponseDtoToTareaLocalizacionPresenciaSeccion(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalTiendaSeccionResultItemDto childDto : src) {
            TareaLocalizacionPresenciaSeccion dto = delegate.presenciasTotalLocalizacionSeccionResponseDtoToTareaLocalizacionPresenciaSeccion(childDto,
                    tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
    
    @Override
    public List<TareaLocalizacionPresenciaSeccion> presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaSeccion(
            List<PtrPresenciaTotalizadoResultItemDto> src, TareaDto tareaDto) {
        List<TareaLocalizacionPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalizadoResultItemDto childDto : src) {
            TareaLocalizacionPresenciaSeccion dto = delegate.presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaSeccion(childDto,
                    tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
    }

}
