package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;

@Service
@Validated
public class PeriodoPersonaServiceImpl implements PeriodoPersonaService {

    @Autowired
    private PeriodoPersonaRepositoryCustom periodoPersonaRepositoryCustom;

    @Autowired
    private PeriodoPersonaMapper periodoPersonaMapper;
    
    @Override
    public List<PeriodoPersonaDto> save(@Valid final List<PeriodoPersonaDto> src) {
        return periodoPersonaMapper.periodoPersonaToPeriodoPersonaDto(
                periodoPersonaRepositoryCustom.save(periodoPersonaMapper.periodoPersonaDtoToPeriodoPersona(src)));
    }
    
    @Override
    public void mergePeriodoPersona(@NotNull RunTareaDto tareaDto) {
        periodoPersonaRepositoryCustom.mergePeriodoPersona(tareaDto);
    }
}
