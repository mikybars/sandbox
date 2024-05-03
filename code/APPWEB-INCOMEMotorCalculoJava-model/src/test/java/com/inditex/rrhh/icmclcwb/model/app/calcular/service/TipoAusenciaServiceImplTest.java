package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoAusenciaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoAusenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoAusencia;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoAusenciaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TipoAusenciaServiceImplTest {
  private final TipoAusencia tipoAusencia = new TipoAusencia();

  private final TipoAusenciaDto tipoAusenciaDto = new TipoAusenciaDto();

  @InjectMocks
  private TipoAusenciaServiceImpl tipoAusenciaServiceImpl;

  @Mock
  private TipoAusenciaMapper tipoAusenciaMapper;

  @Mock
  private TipoAusenciaRepository tipoAusenciaRepository;

  @Test
    void findByIcmTpAbsenceTest(){

        when(this.tipoAusenciaRepository.findByIcmTpAbsence(any(String.class))).thenReturn(this.tipoAusencia);

        when(this.tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(any(TipoAusencia.class))).thenReturn(this.tipoAusenciaDto);

        this. tipoAusenciaServiceImpl.findByIcmTpAbsence("icmTpAbsence");

        verify(this.tipoAusenciaRepository, times(1)).findByIcmTpAbsence(any(String.class));
        verify(this.tipoAusenciaMapper, times(1)).tipoAusenciaToTipoAusenciaDto(any(TipoAusencia.class));
  }

  @Test
    void findByIdTest(){
        when(this.tipoAusenciaRepository.findById(any(Integer.class))).thenReturn( Optional.ofNullable(this.tipoAusencia));
        when(this.tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(any(TipoAusencia.class))).thenReturn(this.tipoAusenciaDto);

        this.tipoAusenciaServiceImpl.findById(1);

        verify(this.tipoAusenciaRepository, times(1)).findById(any(Integer.class));
        verify(this.tipoAusenciaMapper, times(1)).tipoAusenciaToTipoAusenciaDto(any(TipoAusencia.class));



    }

}
