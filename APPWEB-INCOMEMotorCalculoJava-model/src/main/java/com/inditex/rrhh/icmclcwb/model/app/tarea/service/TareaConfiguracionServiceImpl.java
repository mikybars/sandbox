package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class TareaConfiguracionServiceImpl implements TareaConfiguracionService {

    @Autowired
    private TareaConfiguracionMapper tareaConfiguracionMapper;

    @Autowired
    private TareaConfiguracionRepositoryCustom tareaConfiguracionRepositoryCustom;

    @Override
    public void save(List<ConfiguracionItemDto> src, TareaDto tarea) {
        List<TareaConfiguracion> configuraciones = tareaConfiguracionMapper.getConfiguracionItemDtoToTareaConfiguracion(src, tarea);
        tareaConfiguracionRepositoryCustom.save(configuraciones);
    }
}
