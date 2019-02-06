package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoTipoHoraRepositoryCustom;

@Service
@Validated
public class TrabajoTipoHoraServiceImpl implements TrabajoTipoHoraService {

    @Autowired
    private TrabajoTipoHoraMapper mapper;
    
    @Autowired
    private TrabajoTipoHoraRepositoryCustom trabajoTipoHoraRepositoryCustom;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTiposHorasResultItemDto> dto, TrabajoDto trabajoDto) throws Exception {
        mapper.trabajoTrabajoTipoHoraListTotrabajoTipoHoraDtoList(trabajoTipoHoraRepositoryCustom
                .save(mapper.ptrPresenciaTipoHoraResponsesDtoToTrabajoTipoHoraDto(dto, trabajoDto)));
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
