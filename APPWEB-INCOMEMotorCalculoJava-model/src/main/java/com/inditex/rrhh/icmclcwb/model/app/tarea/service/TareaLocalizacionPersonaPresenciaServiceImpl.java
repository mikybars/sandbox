package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaPresenciaServiceImpl implements TareaLocalizacionPersonaPresenciaService{

    @Autowired
    private TareaLocalizacionPersonaPresenciaRepositoryCustom tareaPersonaPresenciaRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPersonaPresenciaMapper tareaPersonaPresenciaMapper;
    
    @Override
    public void save(@NotNull final List<PtrPresenciaDetalleResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaPersonaPresenciaRepositoryCustom.save(tareaPersonaPresenciaMapper
                .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
    }
    
    
}
