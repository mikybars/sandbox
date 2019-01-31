package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaComisionHistoricoRepositoryCustom;

@Service
@Validated
public class TrabajoTiendaComisionHistoricoServiceImpl implements TrabajoTiendaComisionHistoricoService {

    @Autowired
    private TrabajoTiendaComisionHistoricoMapper mapper;
    
    @Autowired
    private TrabajoTiendaComisionHistoricoRepositoryCustom trabajoTiendaComisionHistoricoRepositoryCustom; 
 
    @Override
    public List<TrabajoTiendaComisionHistoricoDto> save(final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto) throws Exception {
        return mapper.trabajoTiendaComisionHistoricoToTrabajoTiendaComisionHistoricoDto(trabajoTiendaComisionHistoricoRepositoryCustom
                .save(mapper.trabajoTiendaComisionHistoricoDtoToTrabajoTiendaComisionHistorico(trabajoTiendaComisionHistoricoDto)));
    }
    
}
