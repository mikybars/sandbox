package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;

public interface TareaConfiguracionPrecioHoraService {

    void save(List<TareaConfiguracionPrecioHoraDto> src, TareaDto tarea);

    void saveConfPrecioHoraResultItemDto(List<ConfPrecioHoraResultItemDto> src, TareaDto tarea);

}
