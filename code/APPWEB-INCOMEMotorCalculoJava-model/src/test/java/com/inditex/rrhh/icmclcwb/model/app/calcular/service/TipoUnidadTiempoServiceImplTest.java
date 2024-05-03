package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoUnidadTiempoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoUnidadTiempoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoUnidadTiempoServiceImplTest {

  private final TipoUnidadTiempoDto tipoUnidadTiempoDto = new TipoUnidadTiempoDto();

  private final TipoUnidadTiempo tipoUnidadTiempo = new TipoUnidadTiempo();

  @InjectMocks
  private TipoUnidadTiempoServiceImpl tipoUnidadTiempoServiceImpl;

  @Mock
  private TipoUnidadTiempoMapper tipoUnidadTiempoMapper;

  @Mock
  private TipoUnidadTiempoRepository tipoUnidadTiempoRepository;

  @Test
  void findByIcmIdUnidadTiempoTest() {
      when(this.tipoUnidadTiempoRepository.findByIcmIdUnidadTiempo(any(String.class))).thenReturn(this.tipoUnidadTiempo);
      when(this.tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(any(TipoUnidadTiempo.class))).thenReturn(
          this.tipoUnidadTiempoDto);

    this.tipoUnidadTiempoServiceImpl.findByIcmIdUnidadTiempo("String");

    verify(this.tipoUnidadTiempoMapper, times(1)).tipoUnidadTiempoToTipoUnidadTiempoDto(any(TipoUnidadTiempo.class));
    verify(this.tipoUnidadTiempoRepository, times(1)).findByIcmIdUnidadTiempo(any(String.class));
  }

  @Test
  void findByIdTest() {
      when(this.tipoUnidadTiempoMapper.tipoUnidadTiempoToTipoUnidadTiempoDto(any(TipoUnidadTiempo.class))).thenReturn(
          this.tipoUnidadTiempoDto);
      when(this.tipoUnidadTiempoRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(this.tipoUnidadTiempo));

    this.tipoUnidadTiempoServiceImpl.findById(1);

    verify(this.tipoUnidadTiempoMapper, times(1)).tipoUnidadTiempoToTipoUnidadTiempoDto(any(TipoUnidadTiempo.class));
    verify(this.tipoUnidadTiempoRepository, times(1)).findById(any(Integer.class));
  }
}
