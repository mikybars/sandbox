package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inditex.aqsw.framework.test.randomizer.Random;
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
    void findByTipoCalculoIdTest(){
      when(this.algoritmoRepository.findByTipoCalculoId(any(Long.class))).thenReturn(this.algoritmo);
      when(this.algoritmoMapper.algoritmoToAlgoritmoDTO(any(Algoritmo.class))).thenReturn(this.algoritmoDTO);

      this.algoritmoServiceImpl.findByTipoCalculoId(1L);

      verify(this.algoritmoRepository, times(1)).findByTipoCalculoId(any(Long.class));
      verify(this.algoritmoMapper, times(1)).algoritmoToAlgoritmoDTO(any(Algoritmo.class));
}

  @Test
    void findByTipoCalculoIdAndTipoComisionIdTest(){
      when(this.algoritmoRepository.findByTipoCalculoIdAndTipoComisionId(any(Long.class), any(Long.class))).thenReturn(this.algoritmo);
      when(this.algoritmoMapper.algoritmoToAlgoritmoDTO(any(Algoritmo.class))).thenReturn(this.algoritmoDTO);

      this.algoritmoServiceImpl.findByTipoCalculoIdAndTipoComisionId(1L, 1L);

      verify(this.algoritmoRepository, times (1)).findByTipoCalculoIdAndTipoComisionId(any(Long.class), any(Long.class));
      verify(this.algoritmoMapper, times(1)).algoritmoToAlgoritmoDTO(any(Algoritmo.class));

    }

  @Test
    void findByIdTest(@Random final AlgoritmoDTO algoritmoDTO, @Random final Algoritmo algoritmo){
        when(this.algoritmoRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(algoritmo));
        when(this.algoritmoMapper.algoritmoToAlgoritmoDTO(any(Algoritmo.class))).thenReturn(algoritmoDTO);

        this. algoritmoServiceImpl.findById(1);

        verify(this.algoritmoRepository, times(1)).findById(any(Integer.class));
        verify(this.algoritmoMapper, times(1)).algoritmoToAlgoritmoDTO(any(Algoritmo.class));
    }

  @Test
    void findAllTest(@Random(type = Algoritmo.class, size = 2) final List<Algoritmo> list, @Random(type = AlgoritmoDTO.class, size = 2) final List<AlgoritmoDTO> listaDTO ){
    when(this.algoritmoRepository.findAll()).thenReturn(list);
    when(this.algoritmoMapper.algoritmoToAlgoritmoDTO(any(List.class))).thenReturn(listaDTO);

    this.algoritmoServiceImpl.findAll();

    verify(this.algoritmoRepository, times(1)).findAll();
    verify(this.algoritmoMapper, times(1)).algoritmoToAlgoritmoDTO(any(List.class));

   }

  @Test
    void checkDuplicatedActivesTest(){
      when(this.algoritmoRepositoryCustom.checkDuplicatedActives()).thenReturn(Boolean.TRUE);

      this.algoritmoServiceImpl.checkDuplicatedActives();

      verify(this.algoritmoRepositoryCustom, times (1)).checkDuplicatedActives();
    }

}
