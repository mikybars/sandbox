package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaComisionHistoricoDto;

public interface TrabajoTiendaComisionHistoricoService {

    List<TrabajoTiendaComisionHistoricoDto> save( 
            final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto);

}
