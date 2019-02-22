package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoTiendaComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaComisionHistoricoRepositoryCustom;

@Service
@Validated
public class ProcesoTiendaComisionHistoricoServiceImpl implements ProcesoTiendaComisionHistoricoService {

    @Autowired
    private ProcesoTiendaComisionHistoricoMapper mapper;
    
    @Autowired
    private ProcesoTiendaComisionHistoricoRepositoryCustom procesoTiendaComisionHistoricoRepositoryCustom; 
 
    @Override
    public List<ProcesoTiendaComisionHistoricoDto> save(final List<ProcesoTiendaComisionHistoricoDto> procesoTiendaComisionHistoricoDto) {
        return mapper.procesoTiendaComisionHistoricoToProcesoTiendaComisionHistoricoDto(procesoTiendaComisionHistoricoRepositoryCustom
                .save(mapper.procesoTiendaComisionHistoricoDtoToProcesoTiendaComisionHistorico(procesoTiendaComisionHistoricoDto)));
    }
    
}
