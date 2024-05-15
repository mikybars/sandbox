package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoPoliticaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoPoliticaServiceImplTest {
  private final TipoPoliticaDto tipoPoliticaDto = new TipoPoliticaDto();

  private final TipoPolitica tipoPolitica = new TipoPolitica();

  @InjectMocks
  private TipoPoliticaServiceImpl tipoPoliticaServiceImpl;

  @Mock
  private TipoPoliticaRepository tipoPoliticaRepository;

  @Mock
  private TipoPoliticaMapper tipoPoliticaMapper;

  @Test
  void findByIdMeta4Test() {
    when(this.tipoPoliticaRepository.findByIcmIdTpPolitica(any(String.class))).thenReturn(this.tipoPolitica);
    when(this.tipoPoliticaMapper.tipoPoliticaToTipoPoliticaDto(any(TipoPolitica.class))).thenReturn(this.tipoPoliticaDto);

    this.tipoPoliticaServiceImpl.findByIdMeta4("String");

    verify(this.tipoPoliticaRepository, times(1)).findByIcmIdTpPolitica(any(String.class));
    verify(this.tipoPoliticaMapper, times(1)).tipoPoliticaToTipoPoliticaDto(any(TipoPolitica.class));

  }

  @Test
  void findByIdTest() {
    when(this.tipoPoliticaRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(this.tipoPolitica));
    when(this.tipoPoliticaMapper.tipoPoliticaToTipoPoliticaDto(any(TipoPolitica.class))).thenReturn(this.tipoPoliticaDto);

    this.tipoPoliticaServiceImpl.findById(1);

    verify(this.tipoPoliticaMapper, times(1)).tipoPoliticaToTipoPoliticaDto(any(TipoPolitica.class));
    verify(this.tipoPoliticaRepository, times(1)).findById(any(Integer.class));
  }

}
