package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;

@Deprecated
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
    
    
}
