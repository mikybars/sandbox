package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoPresupuestoRepository;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoPresupuestoServiceImplTest {
  private final TipoPresupuestoDto tipoPresupuestoDto = new TipoPresupuestoDto();

  private final TipoPresupuesto tipoPresupuesto = new TipoPresupuesto();

  @InjectMocks
  private TipoPresupuestoServiceImpl tipoPresupuestoServiceImpl;

  @Mock
  private TipoPresupuestoRepository tipoPresupuestoRepository;

  @Mock
  private TipoPresupuestoMapper tipoPresupuestoMapper;

  @Test
  void findByIcmIdTpPresupuestoTest() {
    when(this.tipoPresupuestoMapper.tipoPresupuestoToTipoPreupuestoDto(any(TipoPresupuesto.class))).thenReturn(this.tipoPresupuestoDto);
    when(this.tipoPresupuestoRepository.findByIcmIdTpPresupuesto(any(String.class))).thenReturn(this.tipoPresupuesto);

    this.tipoPresupuestoServiceImpl.findByIcmIdTpPresupuesto("String");

    verify(this.tipoPresupuestoRepository, times(1)).findByIcmIdTpPresupuesto(any(String.class));
    verify(this.tipoPresupuestoMapper, times(1)).tipoPresupuestoToTipoPreupuestoDto(any(TipoPresupuesto.class));
  }

  @Test
  void findByIdTest() {
    when(this.tipoPresupuestoRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(this.tipoPresupuesto));
    when(this.tipoPresupuestoMapper.tipoPresupuestoToTipoPreupuestoDto(any(TipoPresupuesto.class))).thenReturn(this.tipoPresupuestoDto);

    this.tipoPresupuestoServiceImpl.findById(1);

    verify(this.tipoPresupuestoMapper, times(1)).tipoPresupuestoToTipoPreupuestoDto(any(TipoPresupuesto.class));
    verify(this.tipoPresupuestoRepository, times(1)).findById(any(Integer.class));
  }

  @Test
    void findByIdShouldThrowEntityNotFoundException() {
        when(this.tipoPresupuestoRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> this.tipoPresupuestoServiceImpl.findById(1));
    }

}
