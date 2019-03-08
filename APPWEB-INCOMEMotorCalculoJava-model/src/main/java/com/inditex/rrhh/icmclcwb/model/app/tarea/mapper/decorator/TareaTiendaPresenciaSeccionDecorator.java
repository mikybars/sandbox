package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaPresenciaSeccion;

public abstract class TareaTiendaPresenciaSeccionDecorator extends TareaTiendaPresenciaSeccionMapper {

    @Autowired
    private TareaTiendaPresenciaSeccionMapper delegate;
    
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
