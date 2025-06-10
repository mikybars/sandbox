package com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionLocalizacionBandaExcepcionDto;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.SimulacionLocalizacionBandaExcepcion;

import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimulacionLocalizacionBandaExcepcionMapperTest {

  private SimulacionLocalizacionBandaExcepcionMapper simulacionLocalizacionBandaExcepcionMapper;

  @BeforeEach
  public void setup() {
    this.simulacionLocalizacionBandaExcepcionMapper = Mappers.getMapper(SimulacionLocalizacionBandaExcepcionMapper.class);
  }

  @Test
  public void simulacionToSimulacionDtoShouldMapId() {
    final SimulacionLocalizacionBandaExcepcion request = Instancio.create(SimulacionLocalizacionBandaExcepcion.class);

    final SimulacionLocalizacionBandaExcepcionDto result =
        this.simulacionLocalizacionBandaExcepcionMapper.simulacionLocalizacionBandaExcepcionToDto(request);

    assertEquals(request.getCclIdCodOrigen(), result.getCclIdCodOrigen());
    assertEquals(request.getCclIdSeccion(), result.getCclIdSeccion());
  }

}
