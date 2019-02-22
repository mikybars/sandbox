package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;

public interface ProcesoTiendaComisionHistoricoService {

    List<ProcesoTiendaComisionHistoricoDto> save( 
            final List<ProcesoTiendaComisionHistoricoDto> procesoTiendaComisionHistoricoDto);

}
