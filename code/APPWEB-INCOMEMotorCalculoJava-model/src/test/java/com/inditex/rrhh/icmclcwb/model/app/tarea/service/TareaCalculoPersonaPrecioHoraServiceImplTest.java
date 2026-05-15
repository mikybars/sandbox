package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalSimpleDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaPrecioHoraRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaCalculoPersonaPrecioHoraServiceImplTest {

  @Mock
  private TareaCalculoPersonaPrecioHoraRepositoryCustom tareaCalculoPersonaPrecioHoraRepositoryCustom;

  @InjectMocks
  private TareaCalculoPersonaPrecioHoraServiceImpl tareaCalculoPersonaPrecioHoraServiceImpl;

  @Test
  void getIdsPersonasCalculoPrecioHoraByTareaTest() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(123L);

    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTarea(tareaDto);

    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("origen");

    final List<IdPersonaLocalSimpleDto> expected = Collections.singletonList(new IdPersonaLocalSimpleDto());

    when(this.tareaCalculoPersonaPrecioHoraRepositoryCustom.getEmployeeLocalIds(runTareaDto.getTarea().getId(),
        tareaAmbitoDto.getCclIdOrigen())).thenReturn(expected);

    final List<IdPersonaLocalSimpleDto> result =
        this.tareaCalculoPersonaPrecioHoraServiceImpl.getIdsPersonasCalculoPrecioHoraByTareaAndAmbito(runTareaDto, tareaAmbitoDto);

    assertEquals(expected, result);

    verify(this.tareaCalculoPersonaPrecioHoraRepositoryCustom, times(1)).getEmployeeLocalIds(runTareaDto.getTarea().getId(),
        tareaAmbitoDto.getCclIdOrigen());
  }

  @Test
  void calcularPrecioHoraTest() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(123L);
    tareaDto.setStdIdLegEnt("stdIdLegEnt");

    final TrabajoDTO trabajoDto = new TrabajoDTO();
    trabajoDto.setIcmIdPeriodo(202401L);

    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTarea(tareaDto);
    runTareaDto.setTrabajo(trabajoDto);

    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("origen");

    final IdPersonaLocalSimpleDto persona = new IdPersonaLocalSimpleDto();
    persona.setIdPersonaLocal("personaLocalId");

    final List<IdPersonaLocalSimpleDto> personas = Collections.singletonList(persona);

    this.tareaCalculoPersonaPrecioHoraServiceImpl.calcularPrecioHora(runTareaDto, tareaAmbitoDto, personas);

    verify(this.tareaCalculoPersonaPrecioHoraRepositoryCustom, timeout(1000).times(1)).insertPrecioHora(
        runTareaDto.getTarea().getId(),
        runTareaDto.getTrabajo().getIcmIdPeriodo(),
        tareaAmbitoDto.getCclIdOrigen(),
        runTareaDto.getTarea().getStdIdLegEnt(),
        personas.stream().map(IdPersonaLocalSimpleDto::getIdPersonaLocal).toList());
  }

}
