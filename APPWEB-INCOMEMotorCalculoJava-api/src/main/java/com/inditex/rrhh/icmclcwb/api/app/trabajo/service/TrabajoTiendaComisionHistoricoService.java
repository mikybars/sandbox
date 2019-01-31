package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaComisionHistoricoDto;

public interface TrabajoTiendaComisionHistoricoService {

    List<TrabajoTiendaComisionHistoricoDto> save( 
            final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto) throws Exception;

}
