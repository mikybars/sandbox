package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

@Service
@Validated
public class TareaCalculoServiceImpl implements TareaCalculoService{
    
    @Autowired
    private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

    @Override
    public void regularizarChallenge(RunTareaDto runTareaDto, @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto) {
        tareaCalculoRepositoryCustom.regularizarChallenge(runTareaDto.getTarea(), idPersonaLocalChallengeDto);
    }
    
}
