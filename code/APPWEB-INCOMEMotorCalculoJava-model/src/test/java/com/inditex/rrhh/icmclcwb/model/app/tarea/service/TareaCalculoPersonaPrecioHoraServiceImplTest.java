package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaPrecioHoraRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaCalculoPersonaPrecioHoraServiceImplTest {

    @Mock
    private TareaCalculoPersonaPrecioHoraRepositoryCustom tareaCalculoPersonaPrecioHoraRepositoryCustom;

    @Mock
    private TareaCalculoPersonaPrecioHoraServiceImpl tareaCalculoPersonaPrecioHoraServiceImpl;

    @Test
    public void getIdsPersonasCalculoPrecioHoraByTareaTest() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        final List<IdPersonaLocalDto> expected = Collections.singletonList(new IdPersonaLocalDto());

        when(this.tareaCalculoPersonaPrecioHoraRepositoryCustom.ids(runTareaDto.getTarea().getId(),
            tareaAmbitoDto.getCclIdOrigen())).thenReturn(expected);

        final List<IdPersonaLocalDto> result =
            this.tareaCalculoPersonaPrecioHoraServiceImpl.getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(runTareaDto, tareaAmbitoDto);

        assertEquals(expected, result);

        verify(this.tareaCalculoPersonaPrecioHoraRepositoryCustom, times(1)).ids(runTareaDto.getTarea().getId(),
            tareaAmbitoDto.getCclIdOrigen());
    }

    @Test
    public void calcularPrecioHoraTest() {
        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        final List<IdPersonaLocalDto> personas = Collections.singletonList(new IdPersonaLocalDto());

        this.tareaCalculoPersonaPrecioHoraServiceImpl.calcularPrecioHora(runTareaDto, tareaAmbitoDto, personas);

        verify(this.tareaCalculoPersonaPrecioHoraRepositoryCustom, times(1)).insertPrecioHora(
            runTareaDto.getTarea().getId(),
            runTareaDto.getTrabajo().getIcmIdPeriodo(),
            tareaAmbitoDto.getCclIdOrigen(),
            runTareaDto.getTarea().getStdIdLegEnt(),
            personas.stream().map(IdPersonaLocalDto::getIdPersonaLocal).toList()
        );
    }

}
