package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaSeccionRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaPresenciaSeccionServiceImpl
        implements TareaLocalizacionPersonaPresenciaSeccionService {

    @Autowired
    private TareaLocalizacionPersonaPresenciaSeccionRepositoryCustom tareaLocalizacionPersonaPresenciaSeccionRepositoryCustom;
    
    @Autowired
    private TareaLocalizacionPersonaPresenciaSeccionMapper tareaLocalizacionPersonaPresenciaSeccionMapper;
    
    @Override
    public void save(@NotNull final List<PtrPresenciaDetalleResultItemDto> src, @NotNull final TareaDto tareaDto) {
        tareaLocalizacionPersonaPresenciaSeccionRepositoryCustom.save(tareaLocalizacionPersonaPresenciaSeccionMapper
                .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresenciaSeccion(src, tareaDto));
    }
    
    
}
