package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaComisionHistoricoRepositoryCustom;

@Service
@Validated
public class TareaTiendaComisionHistoricoServiceImpl implements TareaTiendaComisionHistoricoService {

    @Autowired
    private TareaTiendaComisionHistoricoMapper mapper;
    
    @Autowired
    private TareaTiendaComisionHistoricoRepositoryCustom tareaTiendaComisionHistoricoRepositoryCustom; 
 
    @Override
    public List<TareaTiendaComisionHistoricoDto> save(final List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoDto) {
        return mapper.tareaTiendaComisionHistoricoToTareaTiendaComisionHistoricoDto(tareaTiendaComisionHistoricoRepositoryCustom
                .save(mapper.tareaTiendaComisionHistoricoDtoToTareaTiendaComisionHistorico(tareaTiendaComisionHistoricoDto)));
    }
    
}
