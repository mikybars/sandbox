package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaComisionHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaComisionHistoricoRepositoryCustom;

@Service
@Validated
public class TareaTiendaComisionHistoricoServiceImpl implements TareaTiendaComisionHistoricoService {

    @Autowired
    private TareaTiendaComisionHistoricoMapper mapper;
    
    @Autowired
    private TareaTiendaComisionHistoricoRepositoryCustom tareaTiendaComisionHistoricoRepositoryCustom; 
 
    
    @Override
    public List<TareaTiendaComisionHistoricoDto> save(@Valid final List<TareaTiendaComisionHistoricoDto> tareaTiendaHistorico,
            @Valid final TareaDto tarea) {
        List<TareaTiendaComisionHistoricoDto> result = new ArrayList<>();
        List<TareaTiendaComisionHistorico> data = mapper
                .mergeTareaTiendaComisionHistoricoDtoAndTareaDtoToTareaTiendaComisionHistorico(tareaTiendaHistorico, tarea);
        if (CollectionUtils.isNotEmpty(data)) {
            result.addAll(mapper
                    .tareaTiendaComisionHistoricoToTareaTiendaComisionHistoricoDto(tareaTiendaComisionHistoricoRepositoryCustom.save(data)));
        }
        return result;
    }

    @Override
    public List<TareaTiendaComisionHistoricoDto> saveGenericTiendaResultItemDto(
            final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea) {
        return save(mapper
                .genericTiendaResultItemDtoToTareaTiendaComisionHistoricoDto(genericTiendaResultItemDto), tarea);
    }
}
