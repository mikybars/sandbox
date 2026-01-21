package com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimulacionMapperTest {

  private SimulacionMapper simulacionMapper;

  @BeforeEach
  public void setup() {
    this.simulacionMapper = Mappers.getMapper(SimulacionMapper.class);
  }

  @Test
  public void simulacionToSimulacionDtoShouldMapId() {
    final Simulacion simulacion = new Simulacion();
    simulacion.setId(1L);

    final SimulacionDto simulacionDto = this.simulacionMapper.simulacionToSimulacionDto(simulacion);

    assertEquals(simulacion.getId(), simulacionDto.getId());
  }
}
