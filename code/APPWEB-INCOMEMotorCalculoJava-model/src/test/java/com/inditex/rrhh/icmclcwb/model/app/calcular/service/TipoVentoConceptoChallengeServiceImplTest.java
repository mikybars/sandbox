package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoChallengeMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoVentaConceptoChallengeRespository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoVentoConceptoChallengeServiceImplTest {

  @InjectMocks
  private TipoVentoConceptoChallengeServiceImpl tipoVentoConceptoChallengeServiceImpl;

  @Mock
  private TipoVentaConceptoChallengeRespository tipoVentaConceptoChallengeRespository;

  @Mock
  private TipoVentaConceptoChallengeMapper tipoVentaConceptoChallengeMapper;

  @Test
  void findByIcmIdConceptoVentaTest() {
    final TipoVentaConceptoChallengeDto tipoVentaConceptoChallengeDto = new TipoVentaConceptoChallengeDto();
    final TipoVentaConceptoChallenge tipoVentaConceptoChallenge = new TipoVentaConceptoChallenge();
    when(this.tipoVentaConceptoChallengeMapper
        .tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(any(TipoVentaConceptoChallenge.class)))
        .thenReturn(tipoVentaConceptoChallengeDto);
    when(this.tipoVentaConceptoChallengeRespository.findByIcmIdConceptoVenta(any(String.class))).thenReturn(tipoVentaConceptoChallenge);
    this.tipoVentoConceptoChallengeServiceImpl.findByIcmIdConceptoVenta("String");

    verify(this.tipoVentaConceptoChallengeRespository, times(1)).findByIcmIdConceptoVenta(any(String.class));
    verify(this.tipoVentaConceptoChallengeMapper, times(1))
        .tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(any(TipoVentaConceptoChallenge.class));
  }

  @Test
  void findByIdTest() {
    final TipoVentaConceptoChallengeDto tipoVentaConceptoChallengeDto = new TipoVentaConceptoChallengeDto();
    final TipoVentaConceptoChallenge tipoVentaConceptoChallenge = new TipoVentaConceptoChallenge();

    when(this.tipoVentaConceptoChallengeMapper
        .tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(any(TipoVentaConceptoChallenge.class)))
        .thenReturn(tipoVentaConceptoChallengeDto);
    when(this.tipoVentaConceptoChallengeRespository.findById(any(Long.class))).thenReturn(Optional.ofNullable(tipoVentaConceptoChallenge));
    this.tipoVentoConceptoChallengeServiceImpl.findById(1L);

    verify(this.tipoVentaConceptoChallengeRespository, times(1)).findById(any(Long.class));
    verify(this.tipoVentaConceptoChallengeMapper, times(1))
        .tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(any(TipoVentaConceptoChallenge.class));

  }

}
