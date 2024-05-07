package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class LimpiezaAsyncServiceImplTest {
  @Mock
  private LimpiezaService limpiezaService;

  @InjectMocks
  private LimpiezaAsyncServiceImpl limpiezaAsyncServiceImpl;

  @Test
  void limpiezaTareaPersonaHistoricoTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaPersonaHistorico(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaPersonaHistorico(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaLocalizacionHistoricoTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaLocalizacionHistorico(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaLocalizacionHistorico(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaGlobalLocalizacionPersonaTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaGlobalLocalizacionPersona(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaGlobalLocalizacionPersona(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamientoTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaAmbitoLocalizacionTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaAmbitoLocalizacion(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaAmbitoLocalizacion(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManualTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(any(TareaDto.class));
  }

  @Test
  void limpiezaTareaAmbitoGlobalPersonaTest() {
    this.limpiezaAsyncServiceImpl.limpiezaTareaAmbitoGlobalPersona(new TareaDto());
    verify(this.limpiezaService, times(1)).limpiezaTareaAmbitoGlobalPersona(any(TareaDto.class));
  }
}
