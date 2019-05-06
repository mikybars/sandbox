package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.PeriodoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionRepositoryCustom;

@Service
@Validated
public class PeriodoLocalizacionServiceImpl implements PeriodoLocalizacionService {

    @Autowired
    private PeriodoLocalizacionRepositoryCustom periodoLocalizacionRepositoryCustom;

    @Autowired
    private PeriodoLocalizacionMapper periodoLocalizacionMapper;
    
    @Override
    public List<PeriodoLocalizacionDto> save(@Valid final List<PeriodoLocalizacionDto> src) {
        return periodoLocalizacionMapper.periodoLocalizacionToPeriodoLocalizacionDto(
                periodoLocalizacionRepositoryCustom.save(periodoLocalizacionMapper.periodoLocalizacionDtoToPeriodoLocalizacion(src)));
        
    }
    
    @Override
    public void mergePeriodoLocalizacion(@NotNull RunTareaDto tareaDto) {
        periodoLocalizacionRepositoryCustom.mergePeriodoLocalizacion(tareaDto);
    }
}
