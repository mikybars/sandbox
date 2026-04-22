package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaCalcularPrecioHoraServiceImplTest {

    @InjectMocks
    private RunTareaCalcularPrecioHoraServiceImpl runTareaCalcularPrecioHoraServiceImpl;

    @Test
    public void execute() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        tareaDto.setId(1L);
        tareaDto.setAmbito(new ArrayList<TareaAmbitoDto>());
        tareaDto.setStdIdLegEnt("1");
        runTareaDto.setTarea(tareaDto);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        tareaAmbitoDto.setCclIdOrigen("1");
        tareaDto.getAmbito().add(tareaAmbitoDto);
        final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
        tareaFaseAccionDto.setIdAccion(1);
    }

}
