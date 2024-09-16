package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionPersonaJornadaRepositoryCustomImplTest {

  private static final String SQL_PROCESAR = "SQL PROCESAR";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @InjectMocks
  private TareaLocalizacionPersonaJornadaRepositoryCustomImpl repository;

  @BeforeEach
  void setUp() throws IllegalAccessException {
    MockitoAnnotations.openMocks(this);
    FieldUtils.writeField(this.repository,
        "sqlProcesar", SQL_PROCESAR, true);
  }

  @Test
  @DisplayName("Procesar should execute update with correct parameters")
  void procesarShouldExecuteUpdateWithCorrectParameters() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    runTareaDto.setTarea(new TareaDto());

    this.repository.procesar(runTareaDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.paramsCaptor.capture());

    final MapSqlParameterSource parametros = this.paramsCaptor.getValue();
    assertEquals(5, parametros.getValues().size());
  }

  @Test
  @DisplayName("Procesar should handle null RunTareaDto gracefully")
  void procesarShouldHandleNullRunTareaDtoGracefully() {
    Assertions.assertThrows(NullPointerException.class, () -> this.repository.procesar(null));
  }
}
