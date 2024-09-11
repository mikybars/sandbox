package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionJornadaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaJornadaRepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class RunTareaProcesarJornadaServiceImplTest {

  @Mock
  private TareaLocalizacionPersonaJornadaRepositoryCustom tareaLocalizacionPersonaJornadaRepositoryCustom;

  @Mock
  private TareaLocalizacionJornadaRepositoryCustom tareaLocalizacionJornadaRepositoryCustom;

  @InjectMocks
  private RunTareaProcesarJornadaServiceImpl runTareaProcesarJornadaService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("ProcesarJornadaLocalizacionPersona should call repository with provided RunTareaDto")
  void procesarJornadaLocalizacionPersonaShouldCallRepositoryWithProvidedRunTareaDto() {
    final RunTareaDto runTareaDto = new RunTareaDto();

    this.runTareaProcesarJornadaService.procesarJornadaLocalizacionPersona(runTareaDto);

    verify(this.tareaLocalizacionPersonaJornadaRepositoryCustom).procesar(runTareaDto);
  }

  @Test
  @DisplayName("ProcesarJornadaLocalizacion should call repository with provided RunTareaDto")
  void procesarJornadaLocalizacionShouldCallRepositoryWithProvidedRunTareaDto() {
    final RunTareaDto runTareaDto = new RunTareaDto();

    this.runTareaProcesarJornadaService.procesarJornadaLocalizacion(runTareaDto);

    verify(this.tareaLocalizacionJornadaRepositoryCustom).procesar(runTareaDto);
  }
}
