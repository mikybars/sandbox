package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaComisionHistoricoRepository;

@Service
@Validated
public class TrabajoTiendaComisionHistoricoServiceImpl implements TrabajoTiendaComisionHistoricoService {

    @Autowired
    private TrabajoTiendaComisionHistoricoMapper mapper;
    
    @Autowired
    private TrabajoTiendaComisionHistoricoRepository trabajoTiendaComisionHistoricoRepository; 
    
    @Override
    public List<TrabajoTiendaComisionHistoricoDto> save(final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto) {
        return mapper.trabajoTiendaComisionHistoricoToTrabajoTiendaComisionHistoricoDto(trabajoTiendaComisionHistoricoRepository
                .save(mapper.trabajoTiendaComisionHistoricoDtoToTrabajoTiendaComisionHistorico(trabajoTiendaComisionHistoricoDto)));
    }
    
}
