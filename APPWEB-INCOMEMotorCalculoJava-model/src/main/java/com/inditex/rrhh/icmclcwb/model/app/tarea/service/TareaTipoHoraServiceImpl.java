package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTipoHoraRepositoryCustom;

@Service
@Validated
public class TareaTipoHoraServiceImpl implements TareaTipoHoraService {

    @Autowired
    private TareaTipoHoraMapper mapper;
    
    @Autowired
    private TareaTipoHoraRepositoryCustom tareaTipoHoraRepositoryCustom;

    @Override
    public List<TareaTipoHoraDto> save(List<PtrPresenciaTiposHorasResultItemDto> dto, TareaDto tareaDto) {
        return mapper.tareaTareaTipoHoraListTotareaTipoHoraDtoList(tareaTipoHoraRepositoryCustom
                .save(mapper.ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(dto, tareaDto)));
    }

}
