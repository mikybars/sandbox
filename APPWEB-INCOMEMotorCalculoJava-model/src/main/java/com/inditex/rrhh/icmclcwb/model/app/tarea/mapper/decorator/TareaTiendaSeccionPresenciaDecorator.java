package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaPresenciaSeccion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;

public abstract class TareaTiendaSeccionPresenciaDecorator extends TareaTiendaSeccionPresenciaMapper {

    @Autowired
    private TareaTiendaSeccionPresenciaMapper delegate;

    @Override
    public List<TareaTiendaSeccionPresencia> presenciasTotalTiendaSeccionResponseDtoToTareaTiendaSeccionPresencias(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto) {
        List<TareaTiendaSeccionPresencia> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalTiendaSeccionResultItemDto childDto : src) {
            TareaTiendaSeccionPresencia dto = delegate.presenciasTotalTiendaSeccionResponseDtoToTareaTiendaSeccionPresencia(childDto,
                    tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
    
    @Override
    public List<TareaTiendaPresenciaSeccion> presenciasTotalTiendaSeccionResponseDtoToTareaTiendaPresenciaSeccion(
            List<PtrPresenciaTotalTiendaSeccionResultItemDto> src, TareaDto tareaDto) {
        List<TareaTiendaPresenciaSeccion> dtoList = new ArrayList<>();
        for (PtrPresenciaTotalTiendaSeccionResultItemDto childDto : src) {
            TareaTiendaPresenciaSeccion dto = delegate.presenciasTotalTiendaSeccionResponseDtoToTareaTiendaPresenciaSeccion(childDto,
                    tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
    
}
