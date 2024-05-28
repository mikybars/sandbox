package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoOpcionCalculoDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoOpcionCalculoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoOpcionCalculoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoOpcionCalculoServiceImplTest {

  @InjectMocks
  private TipoOpcionCalculoServiceImpl tipoOpcionCalculoServiceImpl;

  @Mock
  private TipoOpcionCalculoMapper tipoOpcionCalculoMapper;

  @Mock
  private TipoOpcionCalculoRepository tipoOpcionCalculoRepository;

  @Test

  void findByIdMeta4Test() {
    final TipoOpcionCalculoDto tipoOpcionCalculoDto = new TipoOpcionCalculoDto();
    final TipoOpcionCalculo tipoOpcionCalculo = new TipoOpcionCalculo();
    when(this.tipoOpcionCalculoRepository.findByIdMeta4(any(String.class))).thenReturn(tipoOpcionCalculo);
    when(this.tipoOpcionCalculoMapper.tipoOpcionCalculoToTipoOpcionCalculoDto(any(TipoOpcionCalculo.class)))
        .thenReturn(tipoOpcionCalculoDto);

    this.tipoOpcionCalculoServiceImpl.findByIdMeta4("String");

    verify(this.tipoOpcionCalculoRepository, times(1)).findByIdMeta4(any(String.class));
    verify(this.tipoOpcionCalculoMapper, times(1)).tipoOpcionCalculoToTipoOpcionCalculoDto(any(TipoOpcionCalculo.class));
  }

}
