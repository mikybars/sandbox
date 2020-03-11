package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;

public interface TareaAgrupacionConfiguracionChallengeTipoVentaService {

    void save(List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src, TareaDto tarea);

    void saveConfChTpVentaResultItemDto(List<ConfChTpVentaResultItemDto> src, TareaDto tarea);

}
