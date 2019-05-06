package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoLocalizacionPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionPersonaRepositoryCustom;

@Service
@Validated
public class PeriodoLocalizacionPersonaServiceImpl implements PeriodoLocalizacionPersonaService {

    @Autowired
    private PeriodoLocalizacionPersonaRepositoryCustom periodoLocalizacionPersonaRepositoryCustom;

    @Autowired
    private PeriodoLocalizacionPersonaMapper periodoLocalizacionPersonaMapper;
    
    @Override
    public List<PeriodoLocalizacionPersonaDto> save(@Valid final List<PeriodoLocalizacionPersonaDto> src) {
        return periodoLocalizacionPersonaMapper.periodoLocalizacionPersonaToPeriodoLocalizacionPersonaDto(
                periodoLocalizacionPersonaRepositoryCustom.save(periodoLocalizacionPersonaMapper.periodoLocalizacionPersonaDtoToPeriodoLocalizacionPersona(src)));
        
    }
    
    @Override
    public void mergePeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto) {
        periodoLocalizacionPersonaRepositoryCustom.mergePeriodoLocalizacionPersona(tareaDto);
    }
}
