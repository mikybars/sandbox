package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
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
    public CompletableFuture<Void> save(List<PtrPresenciaTiposHorasResultItemDto> dto, TareaDto tareaDto) {
        mapper.tareaTareaTipoHoraListTotareaTipoHoraDtoList(tareaTipoHoraRepositoryCustom
                .save(mapper.ptrPresenciaTipoHoraResponsesDtoToTareaTipoHoraDto(dto, tareaDto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
