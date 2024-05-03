package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoDatoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoDatoServiceImplTest {

  @InjectMocks
  private TipoDatoServiceImpl tipoDatoServiceImpl;

  @Mock
  private TipoDatoRepository tipoDatoRepository;

  @Test
  void findTipoDatoByTipoGrupoDatoTest() {
    final List<TipoDato> tipoDatoList = new ArrayList<>();

    when(this.tipoDatoRepository.findTipoDatoByTipoGrupoDato(any(Integer.class))).thenReturn(tipoDatoList);

    this.tipoDatoServiceImpl.findTipoDatoByTipoGrupoDato(1);

    verify(this.tipoDatoRepository, times(1)).findTipoDatoByTipoGrupoDato(any(Integer.class));
  }
}
