package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

public abstract class TareaTipoHoraDecorator extends TareaTipoHoraMapper {

    @Autowired
    private TareaTipoHoraMapper delegate;

    @Override
    public List<TareaTipoHora> ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(
            final List<PtrPresenciaTiposHorasResultItemDto> src, final TareaDto tareaDto) {
        final List<TareaTipoHora> dtoList = new ArrayList<>();
        for (final PtrPresenciaTiposHorasResultItemDto childDto : src) {
            final TareaTipoHora dto = this.delegate.ptrPresenciasMockTiposHorasResponseDtoToTareaTipoHoraDto(childDto,
                    tareaDto);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<TareaTipoHora> tiposHorasResponseDtoToTareaTipoHora(
            final TiposHoraResponseDto src,
            final TareaDto tarea) {
        final List<TareaTipoHora> result = new ArrayList<>();
        if (src != null && CollectionUtils.isNotEmpty(src.getItems())) {
            src.getItems().forEach(item -> result.add(this.delegate.tipoHoraResultItemDtoToTareaTipoHora(item, tarea)));
        }
        return result;
    }

}
