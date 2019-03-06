package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;

public interface TareaTiendaComisionHistoricoService {

    List<TareaTiendaComisionHistoricoDto> save( 
            final List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoDto);

}
