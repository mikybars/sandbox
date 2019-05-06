package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoCalculoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;

@Service
@Validated
public class PeriodoCalculoPersonaServiceImpl implements PeriodoCalculoPersonaService {
    
    @Autowired
    private PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

    @Autowired
    private PeriodoCalculoPersonaMapper periodoCalculoPersonaMapper;
    
    @Override
    public List<PeriodoCalculoPersonaDto> save(@Valid final List<PeriodoCalculoPersonaDto> src) {
        return periodoCalculoPersonaMapper.periodoCalculoPersonaToPeriodoCalculoPersonaDto(
                periodoCalculoPersonaRepositoryCustom.save(periodoCalculoPersonaMapper.periodoCalculoPersonaDtoToPeriodoCalculoPersona(src)));
        
    }
    
    @Override
    public void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto) {
        periodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona(tareaDto);
    }
}
