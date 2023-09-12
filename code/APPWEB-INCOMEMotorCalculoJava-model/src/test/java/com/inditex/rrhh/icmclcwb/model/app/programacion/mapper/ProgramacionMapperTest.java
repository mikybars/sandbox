
package com.inditex.rrhh.icmclcwb.model.app.programacion.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProgramacionMapperTest {

  @Mock
  private ProgramacionMapper programacionMapper;

  @Test
  public void programacionDtoToProgramacionTest() {
    final ProgramacionMapper INSTANCE = Mappers.getMapper(ProgramacionMapper.class);

    final ProgramacionDTO dto = new ProgramacionDTO();
    dto.setId(1L);
    dto.setFechaHoraCreacion(OffsetDateTime.MAX);
    dto.setFechaHoraSiguienteEjecucion(OffsetDateTime.MAX);
    dto.setHoraProgramacion(OffsetDateTime.MAX);
    final Programacion target = INSTANCE.programacionDtoToProgramacion(dto);
    assertThat(dto.getId()).isEqualTo(target.getId());
  }

  @Test
  public void programacionDtoToProgramacionListTest() {
    final ProgramacionMapper INSTANCE = Mappers.getMapper(ProgramacionMapper.class);

    final ProgramacionDTO dto = new ProgramacionDTO();
    dto.setId(1L);
    dto.setFechaHoraCreacion(OffsetDateTime.MAX);
    dto.setFechaHoraSiguienteEjecucion(OffsetDateTime.MAX);
    dto.setHoraProgramacion(OffsetDateTime.MAX);
    final List<Programacion> target = INSTANCE.programacionDtoToProgramacion(Arrays.asList(dto));
    assertThat(dto.getId()).isEqualTo(target.get(0).getId());
  }

  @Test
  public void programacionToProgramacionDtoTest() {
    final ProgramacionMapper INSTANCE = Mappers.getMapper(ProgramacionMapper.class);

    final Programacion programacion = new Programacion();
    programacion.setId(1L);
    programacion.setFechaHoraCreacion(LocalDateTime.MAX);
    programacion.setFechaHoraSiguienteEjecucion(LocalDateTime.MAX);
    programacion.setHoraProgramacion(LocalTime.MAX);
    final ProgramacionDTO target = INSTANCE.programacionToProgramacionDto(programacion);
    assertThat(programacion.getId()).isEqualTo(target.getId());
  }

  @Test
  public void programacionToProgramacionDtoListTest() {
    final ProgramacionMapper INSTANCE = Mappers.getMapper(ProgramacionMapper.class);

    final Programacion programacion = new Programacion();
    programacion.setId(1L);
    programacion.setFechaHoraCreacion(LocalDateTime.MAX);
    programacion.setFechaHoraSiguienteEjecucion(LocalDateTime.MAX);
    programacion.setHoraProgramacion(LocalTime.MAX);
    final List<ProgramacionDTO> target = INSTANCE.programacionToProgramacionDto(Arrays.asList(programacion));
    assertThat(programacion.getId()).isEqualTo(target.get(0).getId());
  }

}
