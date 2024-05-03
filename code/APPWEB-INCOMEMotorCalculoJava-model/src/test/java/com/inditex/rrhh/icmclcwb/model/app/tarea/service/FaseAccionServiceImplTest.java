package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.FaseAccionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class FaseAccionServiceImplTest {
  @InjectMocks
  private FaseAccionServiceImpl faseAccionServiceImpl;

  @Mock
  private FaseAccionRepositoryCustom faseAccionRepositoryCustom;

  @Test
  void findByIdFaseTest() {
    final Integer id = 1;

    this.faseAccionServiceImpl.findByIdFase(id);

    verify(this.faseAccionRepositoryCustom, times(1)).findByIdFase(any(Integer.class));

  }
}
