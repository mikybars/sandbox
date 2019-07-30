package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

public abstract class TareaTipoHoraDecorator extends TareaTipoHoraMapper {

    @Autowired
    private TareaTipoHoraMapper delegate;

    @Override
    public List<TareaTipoHora> ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(
            List<PtrPresenciaTiposHorasResultItemDto> src, TareaDto tareaDto) {
        List<TareaTipoHora> dtoList = new ArrayList<>();
        for (PtrPresenciaTiposHorasResultItemDto childDto : src) {
            TareaTipoHora dto = delegate.ptrPresenciasMockTiposHorasResponseDtoToTareaTipoHoraDto(childDto,
                    tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
