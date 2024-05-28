package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.AlgoritmoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.AlgoritmoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class AlgoritmoServiceImplTest {
  private final AlgoritmoDTO algoritmoDTO = new AlgoritmoDTO();

  private final Algoritmo algoritmo = new Algoritmo();

  @InjectMocks
  private AlgoritmoServiceImpl algoritmoServiceImpl;

  @Mock
  private AlgoritmoRepository algoritmoRepository;

  @Mock
  private AlgoritmoRepositoryCustom algoritmoRepositoryCustom;

  @Mock
  private AlgoritmoMapper algoritmoMapper;

  @Test
  void customFindAlgoritmosIdsByTareaTest() {
    final List<Integer> lista = new ArrayList<>();
    when(this.algoritmoRepositoryCustom.customFindAlgoritmosIdsByTarea(any(Long.class))).thenReturn(lista);

    this.algoritmoServiceImpl.customFindAlgoritmosIdsByTarea(1L);

    verify(this.algoritmoRepositoryCustom, times(1))
        .customFindAlgoritmosIdsByTarea(any(Long.class));
  }

  @Test
  void findByIdTest() {
    when(this.algoritmoRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(this.algoritmo));
    when(this.algoritmoMapper.algoritmoToAlgoritmoDTO(any(Algoritmo.class))).thenReturn(this.algoritmoDTO);

    this.algoritmoServiceImpl.findById(1);

    verify(this.algoritmoRepository, times(1)).findById(any(Integer.class));
    verify(this.algoritmoMapper, times(1)).algoritmoToAlgoritmoDTO(any(Algoritmo.class));
  }

  @Test
  void findAllTest() {
    final List<Algoritmo> list = new ArrayList<>();
    final List listaDTO = new ArrayList<>();
    when(this.algoritmoRepository.findAll()).thenReturn(list);
    when(this.algoritmoMapper.algoritmoToAlgoritmoDTO(any(List.class))).thenReturn(listaDTO);

    this.algoritmoServiceImpl.findAll();

    verify(this.algoritmoRepository, times(1)).findAll();
    verify(this.algoritmoMapper, times(1)).algoritmoToAlgoritmoDTO(any(List.class));
  }

  @Test
  void checkDuplicatedActivesTest() {
    when(this.algoritmoRepositoryCustom.checkDuplicatedActives()).thenReturn(Boolean.TRUE);

    this.algoritmoServiceImpl.checkDuplicatedActives();

    verify(this.algoritmoRepositoryCustom, times(1)).checkDuplicatedActives();
  }

}
