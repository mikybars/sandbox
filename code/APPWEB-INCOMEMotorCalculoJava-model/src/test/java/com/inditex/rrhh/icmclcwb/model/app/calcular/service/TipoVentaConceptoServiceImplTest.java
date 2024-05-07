package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoVentaConceptoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})

class TipoVentaConceptoServiceImplTest {

  @InjectMocks
  private TipoVentaConceptoServiceImpl tipoVentaConceptoServiceImpl;

  @Mock
  private TipoVentaConceptoMapper tipoVentaConceptoMapper;

  @Mock
  private TipoVentaConceptoRepository tipoVentaConceptoRepository;

  @Test
  void findByIdMeta4Test() {
    final TipoVentaConceptoDto tipoVentaConceptoDto = new TipoVentaConceptoDto();
    final TipoVentaConcepto tipoVentaConcepto = new TipoVentaConcepto();
    when(this.tipoVentaConceptoRepository.findByIcmIdConceptoVenta(any(String.class))).thenReturn(tipoVentaConcepto);
    when(this.tipoVentaConceptoMapper.tipoVentaConceptoToTipoVentaConceptoDto(any(TipoVentaConcepto.class)))
        .thenReturn(tipoVentaConceptoDto);

    this.tipoVentaConceptoServiceImpl.findByIdMeta4("String");

    verify(this.tipoVentaConceptoMapper, times(1)).tipoVentaConceptoToTipoVentaConceptoDto(any(TipoVentaConcepto.class));
    verify(this.tipoVentaConceptoRepository, times(1)).findByIcmIdConceptoVenta(any(String.class));

  }

  @Test
  void findByIdTest() {
    final TipoVentaConceptoDto tipoVentaConceptoDto = new TipoVentaConceptoDto();
    final TipoVentaConcepto tipoVentaConcepto = new TipoVentaConcepto();
    when(this.tipoVentaConceptoRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(tipoVentaConcepto));
    when(this.tipoVentaConceptoMapper.tipoVentaConceptoToTipoVentaConceptoDto(any(TipoVentaConcepto.class)))
        .thenReturn(tipoVentaConceptoDto);
    this.tipoVentaConceptoServiceImpl.findById(1L);

    verify(this.tipoVentaConceptoRepository, times(1)).findById(any(Long.class));
    verify(this.tipoVentaConceptoMapper, times(1)).tipoVentaConceptoToTipoVentaConceptoDto(any(TipoVentaConcepto.class));

  }

}
