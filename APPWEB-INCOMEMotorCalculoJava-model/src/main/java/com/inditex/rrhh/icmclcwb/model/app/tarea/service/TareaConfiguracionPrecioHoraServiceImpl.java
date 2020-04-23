package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionPrecioHoraRepositoryCustom;

@Validated
@Service
public class TareaConfiguracionPrecioHoraServiceImpl implements TareaConfiguracionPrecioHoraService {

    @Autowired
    private TareaConfiguracionPrecioHoraMapper tareaConfiguracionPrecioHoraMapper;
   
    @Autowired
    private TareaConfiguracionPrecioHoraRepositoryCustom tareaConfiguracionPrecioHoraRepositoryCustom;
    
    @Override
    public void save(List<TareaConfiguracionPrecioHoraDto> src, TareaDto tarea) {
        tareaConfiguracionPrecioHoraRepositoryCustom.save(
                tareaConfiguracionPrecioHoraMapper.tareaConfiguracionPrecioHoraDtoToTareaConfiguracionPrecioHora(src));
    }
    
    @Override
    public void saveConfPrecioHoraResultItemDto(List<ConfPrecioHoraResultItemDto> src, TareaDto tarea) {
        tareaConfiguracionPrecioHoraRepositoryCustom.save(
                tareaConfiguracionPrecioHoraMapper.confPrecioHoraResultItemDtoToTareaConfiguracionPrecioHora(src, tarea));
    }
}
