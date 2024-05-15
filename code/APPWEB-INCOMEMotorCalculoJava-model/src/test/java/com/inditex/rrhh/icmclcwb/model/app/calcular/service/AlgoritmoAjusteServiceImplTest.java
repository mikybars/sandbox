package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoAjusteMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.AlgoritmoAjuste;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoAjusteRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoAjusteRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class AlgoritmoAjusteServiceImplTest {

  @InjectMocks
  private AlgoritmoAjusteServiceImpl algoritmoAjusteServiceImpl;

  @Mock
  private AlgoritmoAjusteRepositoryCustom algoritmoAjusteRepositoryCustom;

  @Mock
  private AlgoritmoAjusteRepository algoritmoAjusteRepository;

  @Mock
  private AlgoritmoAjusteMapper algoritmoAjusteMapper;

  @Test
  void customFindAjustePesosByTareaTest() {
    final List<Long> lista = new ArrayList<>();
    when(this.algoritmoAjusteRepositoryCustom.customFindAjustePesosByTarea(any(Long.class))).thenReturn(lista);

    this.algoritmoAjusteServiceImpl.customFindAjustePesosByTarea(1L);

    verify(this.algoritmoAjusteRepositoryCustom, times(1)).customFindAjustePesosByTarea(any(Long.class));
  }

  @Test
  void customFindAjusteIdsByTareaAndPesoTest() {
    final List<Integer> lista = new ArrayList<>();
    when(this.algoritmoAjusteRepositoryCustom.customFindAjusteIdsByTareaAndPeso(any(Long.class), any(Long.class))).thenReturn(lista);

    this.algoritmoAjusteServiceImpl.customFindAjusteIdsByTareaAndPeso(1L, 1L);

    verify(this.algoritmoAjusteRepositoryCustom, times(1)).customFindAjusteIdsByTareaAndPeso(any(Long.class), any(Long.class));
  }

  @Test
  void findByIdTest() {
    final AlgoritmoAjuste algoritmo = new AlgoritmoAjuste();
    final AlgoritmoAjusteDto algoritmoAjusteDto = new AlgoritmoAjusteDto();
    when(this.algoritmoAjusteRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(algoritmo));
    when(this.algoritmoAjusteMapper.algoritmoAjusteToAlgoritmoAjusteDto(any(AlgoritmoAjuste.class))).thenReturn(algoritmoAjusteDto);

    this.algoritmoAjusteServiceImpl.findById(1);

    verify(this.algoritmoAjusteRepository, times(1)).findById(any(Integer.class));
    verify(this.algoritmoAjusteMapper, times(1)).algoritmoAjusteToAlgoritmoAjusteDto(any(AlgoritmoAjuste.class));
  }

  @Test
  void findByPesoTest() {
    final List<AlgoritmoAjuste> list = new ArrayList<>();
    final List<AlgoritmoAjusteDto> listaDTO = new ArrayList<>();

    when(this.algoritmoAjusteRepository.findByPeso(any(Long.class))).thenReturn(Optional.ofNullable(list));
    when(this.algoritmoAjusteMapper.algoritmoAjusteToAlgoritmoAjusteDto(any(List.class))).thenReturn(listaDTO);

    this.algoritmoAjusteServiceImpl.findByPeso(1L);

    verify(this.algoritmoAjusteRepository, times(1)).findByPeso(any(Long.class));
    verify(this.algoritmoAjusteMapper, times(1)).algoritmoAjusteToAlgoritmoAjusteDto(any(List.class));
  }
}
