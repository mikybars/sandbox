package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.LocalizacionOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import java.util.List;

public interface TareaLocalizacionOnlineHistoricoService {

    List<LocalizacionOnlineDto> save(final List<TiendaOnlineResultItemDto> src, final TareaDto tarea);

}
