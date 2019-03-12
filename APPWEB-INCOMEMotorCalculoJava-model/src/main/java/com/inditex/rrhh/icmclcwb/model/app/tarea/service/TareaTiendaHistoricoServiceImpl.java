package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaHistoricoRepositoryCustom;

@Service
@Validated
public class TareaTiendaHistoricoServiceImpl implements TareaTiendaHistoricoService {

    @Autowired
    private TareaTiendaHistoricoRepositoryCustom tareaTiendaHistoricoRepositoryCustom;

    @Autowired
    private TareaTiendaHistoricoMapper tareaTiendaHistoricoMapper;

    @Override
    public List<TareaTiendaHistoricoDto> save(@Valid final List<TareaTiendaHistoricoDto> tareaTiendaHistorico,
            @Valid final TareaDto tarea) {
        List<TareaTiendaHistoricoDto> result = new ArrayList<>();
        List<TareaTiendaHistorico> data = tareaTiendaHistoricoMapper
                .mergeTareaTiendaHistoricoDtoAndTareaDtoToTareaTiendaHistorico(tareaTiendaHistorico, tarea);
        if (CollectionUtils.isNotEmpty(data)) {
            result.addAll(tareaTiendaHistoricoMapper
                    .tareaTiendaHistoricoToTareaTiendaHistoricoDto(tareaTiendaHistoricoRepositoryCustom.save(data)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaHistoricoDto> saveGenericTiendaResultItemDto(
            final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea) {
        return save(tareaTiendaHistoricoMapper
                .genericTiendaResultItemDtoToTareaTiendaHistoricoDto(genericTiendaResultItemDto), tarea);
    }
}
